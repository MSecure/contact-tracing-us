package io.realm.internal;

public class OsObjectSchemaInfo implements NativeObject {
    public static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    public long nativePtr;

    public OsObjectSchemaInfo(String str, AnonymousClass1 r2) {
        this.nativePtr = nativeCreateRealmObjectSchema(str);
        NativeContext.dummyContext.addReference(this);
    }

    public static native void nativeAddProperties(long j, long[] jArr, long[] jArr2);

    public static native long nativeCreateRealmObjectSchema(String str);

    public static native String nativeGetClassName(long j);

    public static native long nativeGetFinalizerPtr();

    public static native long nativeGetPrimaryKeyProperty(long j);

    public static native long nativeGetProperty(long j, String str);

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    public OsObjectSchemaInfo(long j) {
        this.nativePtr = j;
        NativeContext.dummyContext.addReference(this);
    }
}
