/*
 * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.api.frame;

import com.oracle.truffle.api.CompilerDirectives;

/**
 * Represents a frame containing values of local variables of the guest language. Instances of this
 * type must not be stored in a field or cast to {@link java.lang.Object}.
 *
 * @since 0.8 or earlier
 */
@SuppressWarnings("deprecation")
public interface Frame {

    /**
     * @return the object describing the layout of this frame
     * @since 0.8 or earlier
     */
    FrameDescriptor getFrameDescriptor();

    /**
     * Retrieves the arguments object from this frame. The runtime assumes that the arguments object
     * is never null.
     *
     * @return the arguments used when calling this method
     * @since 0.8 or earlier
     */
    Object[] getArguments();

    /**
     * Read access to a local variable of type {@link Object}.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default Object getObject(FrameSlot slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type {@link Object}.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default void setObject(FrameSlot slot, Object value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type byte.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @throws FrameSlotTypeException
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default byte getByte(FrameSlot slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type byte.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default void setByte(FrameSlot slot, byte value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type boolean.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default boolean getBoolean(FrameSlot slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type boolean.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default void setBoolean(FrameSlot slot, boolean value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type int.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default int getInt(FrameSlot slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type int.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default void setInt(FrameSlot slot, int value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type long.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default long getLong(FrameSlot slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type long.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default void setLong(FrameSlot slot, long value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type float.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default float getFloat(FrameSlot slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type float.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default void setFloat(FrameSlot slot, float value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type double.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default double getDouble(FrameSlot slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type double.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default void setDouble(FrameSlot slot, double value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of any type.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable or defaultValue if unset
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default Object getValue(FrameSlot slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Materializes this frame, which allows it to be stored in a field or cast to
     * {@link java.lang.Object}.
     *
     * @return the new materialized frame
     * @since 0.8 or earlier
     */
    MaterializedFrame materialize();

    /**
     * Check whether the given frame slot is of type object.
     *
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default boolean isObject(@SuppressWarnings("unused") FrameSlot slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given frame slot is of type byte.
     *
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default boolean isByte(@SuppressWarnings("unused") FrameSlot slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given frame slot is of type boolean.
     *
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default boolean isBoolean(@SuppressWarnings("unused") FrameSlot slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given frame slot is of type int.
     *
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default boolean isInt(@SuppressWarnings("unused") FrameSlot slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given frame slot is of type long.
     *
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default boolean isLong(@SuppressWarnings("unused") FrameSlot slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given frame slot is of type float.
     *
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default boolean isFloat(@SuppressWarnings("unused") FrameSlot slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given frame slot is of type double.
     *
     * @since 0.8 or earlier
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default boolean isDouble(@SuppressWarnings("unused") FrameSlot slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Clears the given slot in the frame. Writing over a previously cleared slot is still allowed.
     * Subsequent reads to this slot, unless re-written to, will fail with
     * {@link FrameSlotTypeException}.
     * <p>
     * This method is intended to be used for implementations of liveness analysis. As such, the
     * compiler will find and report any inconsistency with respect to liveness analysis when using
     * this method, such as clearing a slot in a branch, but not on another one, and their execution
     * merge.
     * <p>
     * Liveness analysis implementations are expected to clear unused slots on method entry
     *
     * @param slot the slot of the local variable
     * @since 21.1
     * @deprecated use index-based slots instead
     */
    @Deprecated(since = "22.0")
    default void clear(FrameSlot slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type {@link Object}.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @throws FrameSlotTypeException if the current value is not of type object
     * @since 22.0
     */
    default Object getObject(int slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type {@link Object}.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.0
     */
    default void setObject(int slot, Object value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type byte.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @throws FrameSlotTypeException
     * @since 22.0
     */
    default byte getByte(int slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type byte.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.0
     */
    default void setByte(int slot, byte value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type boolean.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @throws FrameSlotTypeException if the current value is not of type boolean
     * @since 22.0
     */
    default boolean getBoolean(int slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type boolean.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.0
     */
    default void setBoolean(int slot, boolean value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type int.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @throws FrameSlotTypeException if the current value is not of type int
     * @since 22.0
     */
    default int getInt(int slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type int.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.0
     */
    default void setInt(int slot, int value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type long.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @throws FrameSlotTypeException if the current value is not of type long
     * @since 22.0
     */
    default long getLong(int slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type long.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.0
     */
    default void setLong(int slot, long value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type float.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @throws FrameSlotTypeException if the current value is not of type float
     * @since 22.0
     */
    default float getFloat(int slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type float.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.0
     */
    default void setFloat(int slot, float value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of type double.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @throws FrameSlotTypeException if the current value is not of type double
     * @since 22.0
     */
    default double getDouble(int slot) throws FrameSlotTypeException {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Write access to a local variable of type double.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.0
     */
    default void setDouble(int slot, double value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Read access to a local variable of any type.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable or defaultValue if unset
     * @since 22.0
     */
    default Object getValue(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Copies, including the type, from one slot to another.
     *
     * @param srcSlot the slot of the source local variable
     * @param destSlot the slot of the target local variable
     * @since 22.0
     */
    default void copy(int srcSlot, int destSlot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Swaps, including the type, the contents of two slots.
     *
     * @param first the slot of the first local variable
     * @param second the slot of the second local variable
     * @since 22.0
     */
    default void swap(int first, int second) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Determines the actual {@link FrameSlotKind} of the value in the slot, and returns it as
     * {@link FrameSlotKind#tag}.
     *
     * @param slot the slot of the local variable
     * @return the tag of the value in the slot
     * @since 22.0
     */
    default byte getTag(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given indexed slot is of type object.
     *
     * @param slot the slot of the local variable
     * @since 22.0
     */
    default boolean isObject(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given indexed slot is of type byte.
     *
     * @param slot the slot of the local variable
     * @since 22.0
     */
    default boolean isByte(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given indexed slot is of type boolean.
     *
     * @param slot the slot of the local variable
     * @since 22.0
     */
    default boolean isBoolean(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given indexed slot is of type int.
     *
     * @param slot the slot of the local variable
     * @since 22.0
     */
    default boolean isInt(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given indexed slot is of type long.
     *
     * @param slot the slot of the local variable
     * @since 22.0
     */
    default boolean isLong(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given indexed slot is of type float.
     *
     * @param slot the slot of the local variable
     * @since 22.0
     */
    default boolean isFloat(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Check whether the given indexed slot is of type double.
     *
     * @param slot the slot of the local variable
     * @since 22.0
     */
    default boolean isDouble(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Checks whether the given indexed slot is static.
     *
     * @param slot the slot of the local variable
     * @since 22.2
     */
    default boolean isStatic(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Clears the given indexed slot in the frame. Writing over a previously cleared slot is still
     * allowed. Subsequent reads to this slot, unless re-written to, will fail with
     * {@link FrameSlotTypeException}.
     * <p>
     * This method is intended to be used for implementations of liveness analysis. As such, the
     * compiler will find and report any inconsistency with respect to liveness analysis when using
     * this method, such as clearing a slot in a branch, but not on another one, and their execution
     * merge.
     * <p>
     * Liveness analysis implementations are expected to clear unused slots on method entry
     *
     * @param slot the slot of the local variable
     * @since 22.0
     */
    default void clear(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * @param slot the auxiliary slot index to query
     * @return the current value of the auxiliary slot - {@code null} if it was never set (not the
     *         frame descriptor's default value)
     * @since 22.0
     */
    default Object getAuxiliarySlot(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the value of the given auxiliary slot.
     *
     * @param slot the auxiliary slot index
     * @param value the new value
     * @since 22.0
     */
    default void setAuxiliarySlot(int slot, Object value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static read access to a local variable of type {@link Object}. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not perform any type checks, language
     * implementations have to guarantee that the variable in the given slot is of type
     * {@link Object}.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 22.2
     */
    default Object getObjectStatic(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static write access to a local variable of type {@link Object}. Requires the given slot to
     * use {@link FrameSlotKind#Static}. Since this method does not update the internal slot type,
     * language implementations have to track this information.
     *
     * Writing an object value to this slot does not change the underlying primitive value.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.2
     */
    default void setObjectStatic(int slot, Object value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static read access to a local variable of type byte. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not perform any type checks, language
     * implementations have to guarantee that the variable in the given slot can be interpreted as
     * type byte.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 22.2
     */
    default byte getByteStatic(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static write access to a local variable of type byte. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not update the internal slot type,
     * language implementations have to track this information.
     *
     * Writing a primitive value to this slot does not change the underlying object value.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.2
     */
    default void setByteStatic(int slot, byte value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static read access to a local variable of type boolean. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not perform any type checks, language
     * implementations have to guarantee that the variable in the given slot can be interpreted as
     * type boolean.
     *
     * Reading a boolean value after writing a byte, int, or float value to this slot does not give
     * any guarantees about the upper 56 respectively 32 bits of the underlying value and can lead
     * to unexpected results and suboptimal performance.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 22.2
     */
    default boolean getBooleanStatic(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static write access to a local variable of type boolean. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not update the internal slot type,
     * language implementations have to track this information.
     *
     * Writing a primitive value to this slot does not change the underlying object value.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.2
     */
    default void setBooleanStatic(int slot, boolean value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static read access to a local variable of type int. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not perform any type checks, language
     * implementations have to guarantee that the variable in the given slot can be interpreted as
     * type int.
     *
     * Reading an int value after writing a byte value to this slot does not give any guarantees
     * about the upper 24 bits of the underlying value and can lead to unexpected results and
     * suboptimal performance.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 22.2
     */
    default int getIntStatic(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static write access to a local variable of type int. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not update the internal slot type,
     * language implementations have to track this information.
     *
     * Writing a primitive value to this slot does not change the underlying object value.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.2
     */
    default void setIntStatic(int slot, int value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static read access to a local variable of type long. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not perform any type checks, language
     * implementations have to guarantee that the variable in the given slot can be interpreted as
     * type long.
     *
     * Reading a long value after writing a byte, int, or float value to this slot does not give any
     * guarantees about the upper 56 respectively 32 bits of the underlying value and can lead to
     * unexpected results and suboptimal performance.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 22.2
     */
    default long getLongStatic(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static write access to a local variable of type long. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not update the internal slot type,
     * language implementations have to track this information.
     *
     * Writing a primitive value to this slot does not change the underlying object value.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.2
     */
    default void setLongStatic(int slot, long value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static read access to a local variable of type float. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not perform any type checks, language
     * implementations have to guarantee that the variable in the given slot can be interpreted as
     * type float.
     *
     * Reading a float value after writing a byte value to this slot does not give any guarantees
     * about the upper 24 bits of the underlying value and can lead to unexpected results and
     * suboptimal performance.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 22.2
     */
    default float getFloatStatic(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static write access to a local variable of type float. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not update the internal slot type,
     * language implementations have to track this information.
     *
     * Writing a primitive value to this slot does not change the underlying object value.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.2
     */
    default void setFloatStatic(int slot, float value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static read access to a local variable of type double. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not perform any type checks, language
     * implementations have to guarantee that the variable in the given slot can be interpreted as
     * type double.
     *
     * Reading a double value after writing a byte, int, or float value to this slot does not give
     * any guarantees about the upper 56 respectively 32 bits of the underlying value and can lead
     * to unexpected results and suboptimal performance.
     *
     * @param slot the slot of the local variable
     * @return the current value of the local variable
     * @since 22.2
     */
    default double getDoubleStatic(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Static write access to a local variable of type double. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Since this method does not update the internal slot type,
     * language implementations have to track this information.
     *
     * Writing a primitive value to this slot does not change the underlying object value.
     *
     * @param slot the slot of the local variable
     * @param value the new value of the local variable
     * @since 22.2
     */
    default void setDoubleStatic(int slot, double value) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Copies a primitive value from one slot to another. Requires both slots to use
     * {@link FrameSlotKind#Static}. Since this method does not perform any type checks, language
     * implementations have to guarantee that the variable at the source slot is a primitive value.
     * An existing object value at the destination slot is not overwritten.
     *
     * @param srcSlot the slot of the source local variable
     * @param destSlot the slot of the target local variable
     * @since 22.2
     */
    default void copyPrimitiveStatic(int srcSlot, int destSlot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Copies an object value from one slot to another. Requires both slots to use
     * {@link FrameSlotKind#Static}. Since this method does not perform any type checks, language
     * implementations have to guarantee that the variable at the source slot is an {@link Object}.
     * An existing primitive value at the destination slot is not overwritten.
     *
     * @param srcSlot the slot of the source local variable
     * @param destSlot the slot of the target local variable
     * @since 22.2
     */
    default void copyObjectStatic(int srcSlot, int destSlot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Clears the primitive value at the given slot in the frame. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Writing over a previously cleared slot is still allowed.
     * Subsequent reads to the slot, unless re-written to, will not give any guarantees about the
     * returned value.
     *
     * Since this method does not perform any type checks, language implementations have to
     * guarantee that the variable at the given slot is a primitive value. An existing object value
     * at this slot is not cleared.
     *
     * <p>
     * This method is intended to be used for implementations of liveness analysis. As such, the
     * compiler will find and report any inconsistency with respect to liveness analysis when using
     * this method, such as clearing a slot in a branch, but not on another one, and their execution
     * merge.
     * </p>
     * Liveness analysis implementations are expected to clear unused slots on method entry.
     *
     * @param slot the slot of the local variable
     * @since 22.2
     */
    default void clearPrimitiveStatic(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }

    /**
     * Clears the object value at the given slot in the frame. Requires the given slot to use
     * {@link FrameSlotKind#Static}. Writing over a previously cleared slot is still allowed.
     * Subsequent reads to the slot, unless re-written to, will not give any guarantees about the
     * returned value.
     *
     * Since this method does not perform any type checks, language implementations have to
     * guarantee that the variable at the given slot is an {@link Object}. An existing primitive
     * value at this slot is not cleared.
     *
     * <p>
     * This method is intended to be used for implementations of liveness analysis. As such, the
     * compiler will find and report any inconsistency with respect to liveness analysis when using
     * this method, such as clearing a slot in a branch, but not on another one, and their execution
     * merge.
     * </p>
     * Liveness analysis implementations are expected to clear unused slots on method entry.
     *
     * @param slot the slot of the local variable
     * @since 22.2
     */
    default void clearObjectStatic(int slot) {
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnsupportedOperationException();
    }
}
