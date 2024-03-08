/*
 * Copyright (c) 2023, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oracle.truffle.api.bytecode.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.graalvm.polyglot.Context;
import org.junit.Assert;
import org.junit.Test;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.ContextThreadLocal;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.bytecode.BytecodeConfig;
import com.oracle.truffle.api.bytecode.BytecodeParser;
import com.oracle.truffle.api.bytecode.BytecodeRootNode;
import com.oracle.truffle.api.bytecode.BytecodeRootNodes;
import com.oracle.truffle.api.bytecode.GenerateBytecode;
import com.oracle.truffle.api.bytecode.Instrumentation;
import com.oracle.truffle.api.bytecode.Operation;
import com.oracle.truffle.api.bytecode.Prolog;
import com.oracle.truffle.api.dsl.Bind;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;

/**
 * Showcases how to implement the python set trace func feature.
 */
public class SetTraceFuncTest extends AbstractInstructionTest {

    private static SetTraceFuncRootNode parse(BytecodeParser<SetTraceFuncRootNodeGen.Builder> parser) {
        BytecodeRootNodes<SetTraceFuncRootNode> nodes = SetTraceFuncRootNodeGen.create(BytecodeConfig.WITH_SOURCE, parser);
        return nodes.getNodes().get(nodes.getNodes().size() - 1);
    }

    @Test
    public void test() {
        try (Context c = Context.create(TraceFunLanguage.ID)) {
            c.enter();
            c.initialize(TraceFunLanguage.ID);

            AtomicInteger firstCounter = new AtomicInteger();
            AtomicInteger secondCounter = new AtomicInteger();
            SetTraceFuncRootNode node = parse((b) -> {
                b.beginRoot(TraceFunLanguage.REF.get(null));
                b.emitTraceFun();
                b.emitTraceFun();

                b.beginSetTraceFun();
                b.emitLoadConstant((Runnable) () -> {
                    firstCounter.incrementAndGet();
                });
                b.endSetTraceFun();

                // already in the first execution these two
                // trace fun calls should increment the first counter
                b.emitTraceFun();
                b.emitTraceFun();

                b.beginSetTraceFun();
                b.emitLoadConstant((Runnable) () -> {
                    secondCounter.incrementAndGet();
                });
                b.endSetTraceFun();

                b.emitTraceFun();
                b.emitTraceFun();

                b.beginReturn();
                b.emitLoadConstant(42);
                b.endReturn();

                b.endRoot();
            });
            assertEquals(42, node.getCallTarget().call());

            Assert.assertEquals(2, firstCounter.get());
            Assert.assertEquals(2, secondCounter.get());

            assertEquals(42, node.getCallTarget().call());

            Assert.assertEquals(4, firstCounter.get());
            Assert.assertEquals(6, secondCounter.get());
        }
    }

    @GenerateBytecode(languageClass = TraceFunLanguage.class, //
                    enableYield = true, enableSerialization = true, //
                    enableQuickening = true, //
                    enableUncachedInterpreter = true,  //
                    boxingEliminationTypes = {long.class, int.class, boolean.class})
    public abstract static class SetTraceFuncRootNode extends DebugBytecodeRootNode implements BytecodeRootNode {

        private static final BytecodeConfig TRACE_FUN = SetTraceFuncRootNodeGen.newConfigBuilder().addInstrumentation(TraceFun.class).build();

        protected SetTraceFuncRootNode(TruffleLanguage<?> language,
                        FrameDescriptor frameDescriptor) {
            super(language, frameDescriptor);
        }

        @Prolog
        static final class CheckTraceFunOnEnter {
            @Specialization
            public static void doProlog(@Bind("$root") SetTraceFuncRootNode root) {
                if (root.getLanguage(TraceFunLanguage.class).noTraceFun.isValid()) {
                    return;
                }
                root.enableTraceFun();
            }
        }

        private void enableTraceFun() {
            getRootNodes().update(TRACE_FUN);
        }

        @Operation
        static final class SetTraceFun {

            @Specialization
            @TruffleBoundary
            public static void doDefault(Runnable fun,
                            @Bind("$root") SetTraceFuncRootNode root) {
                TraceFunLanguage language = root.getLanguage(TraceFunLanguage.class);
                language.threadLocal.get().traceFun = fun;
                language.noTraceFun.invalidate();
                Truffle.getRuntime().iterateFrames((frameInstance) -> {
                    if (frameInstance.getCallTarget() instanceof RootCallTarget c && c.getRootNode() instanceof SetTraceFuncRootNode r) {
                        root.enableTraceFun();
                    }
                    return null;
                });
            }

        }

        @Instrumentation
        static final class TraceFun {

            @Specialization
            public static void doDefault(@Bind("$root") SetTraceFuncRootNode node) {
                Runnable fun = node.getLanguage(TraceFunLanguage.class).threadLocal.get().traceFun;
                if (fun != null) {
                    invokeSetTraceFunc(fun);
                }
            }

            @TruffleBoundary
            private static void invokeSetTraceFunc(Runnable fun) {
                fun.run();
            }
        }

    }

    static class ThreadLocalData {

        private Runnable traceFun;

    }

    @TruffleLanguage.Registration(id = TraceFunLanguage.ID)
    @ProvidedTags(StandardTags.ExpressionTag.class)
    public static class TraceFunLanguage extends TruffleLanguage<Object> {
        public static final String ID = "TraceLineLanguage";

        final ContextThreadLocal<ThreadLocalData> threadLocal = this.locals.createContextThreadLocal((c, t) -> new ThreadLocalData());
        final Assumption noTraceFun = Truffle.getRuntime().createAssumption();

        @Override
        protected Object createContext(Env env) {
            return new Object();
        }

        static final LanguageReference<TraceFunLanguage> REF = LanguageReference.create(TraceFunLanguage.class);
    }

}
