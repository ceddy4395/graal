/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.api;

import static com.oracle.truffle.api.LanguageAccessor.ENGINE;

/**
 * A context thread local reference that refers to a value that is created for each polyglot context
 * and thread. Context thread references can be used to attach data to a polyglot context for a
 * thread. That data can be retrieved efficiently for the current context and thread using
 * {@link #get()} or less efficiently for other contexts and other threads using
 * {@link #get(TruffleContext, Thread)}. Context thread locals can be created for languages and
 * instruments. See links below for usage examples.
 *
 * @see TruffleLanguage.ContextLocalProvider#createContextThreadLocal(com.oracle.truffle.api.TruffleLanguage.ContextThreadLocalFactory)
 *      Usage with languages.
 * @see com.oracle.truffle.api.instrumentation.TruffleInstrument.ContextLocalProvider#createContextThreadLocal(com.oracle.truffle.api.instrumentation.TruffleInstrument.ContextThreadLocalFactory)
 *      Usage with instruments.
 * @since 20.3
 */
public abstract class ContextThreadLocal<T> {

    /**
     * Custom subclasses of context local are not allowed.
     *
     * @since 20.3
     */
    protected ContextThreadLocal(Object polyglotObject) {
        if (!ENGINE.isPolyglotSecret(polyglotObject)) {
            throw new IllegalStateException("No custom subclasses of ContextLocal allowed.");
        }
    }

    /**
     * Returns the context thread local value for the currently entered context and thread. This
     * method is intended to be used on compiled code paths. The return value is never
     * <code>null</code>. Throws {@link IllegalStateException} if no current context is entered on
     * the current thread.
     *
     * @since 20.3
     */
    public abstract T get();

    /**
     * Returns the context thread local value for the currently entered context and the given
     * thread. This method is less efficient than {@link #get()} or {@link #get(TruffleContext)} as
     * it requires synchronization between the threads. The return value is never <code>null</code>.
     * Throws {@link IllegalStateException} if no current context is entered on the current thread.
     *
     * @since 20.3
     */
    public abstract T get(Thread t);

    /**
     * Returns the context thread local value for the given context and the current thread.his
     * method is intended to be used on compiled code paths. The return value is never
     * <code>null</code>. Throws {@link IllegalStateException} if no current context is entered on
     * the current thread.
     *
     * @since 20.3
     */
    public abstract T get(TruffleContext t);

    /**
     * Returns the context thread local value for the given context and the given thread. The
     * context does not need to, but may be entered when retrieving the current context local. This
     * method is less efficient than {@link #get()} or {@link #get(TruffleContext)} as it requires
     * synchronization between the threads. The return value is never <code>null</code>. Throws
     * {@link IllegalStateException} if no current context is entered on the current thread.
     *
     * @since 20.3
     */
    public abstract T get(TruffleContext context, Thread t);

}
