package io.realm.internal.core;

import io.realm.internal.NativeObject;

public class DescriptorOrdering implements NativeObject {
    public static final long nativeFinalizerMethodPtr = nativeGetFinalizerMethodPtr();
    public final long nativePtr = nativeCreate();

    public static native void nativeAppendDistinct(long j, QueryDescriptor queryDescriptor);

    public static native void nativeAppendInclude(long j, long j2);

    public static native void nativeAppendLimit(long j, long j2);

    public static native void nativeAppendSort(long j, QueryDescriptor queryDescriptor);

    public static native long nativeCreate();

    public static native long nativeGetFinalizerMethodPtr();

    public static native boolean nativeIsEmpty(long j);

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerMethodPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }
}
