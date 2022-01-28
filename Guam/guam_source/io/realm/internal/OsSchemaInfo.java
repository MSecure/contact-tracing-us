package io.realm.internal;

import java.util.Collection;

public class OsSchemaInfo implements NativeObject {
    public static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    public long nativePtr;
    public final OsSharedRealm sharedRealm;

    public OsSchemaInfo(Collection<OsObjectSchemaInfo> collection) {
        long[] jArr = new long[collection.size()];
        int i = 0;
        for (OsObjectSchemaInfo osObjectSchemaInfo : collection) {
            jArr[i] = osObjectSchemaInfo.nativePtr;
            i++;
        }
        this.nativePtr = nativeCreateFromList(jArr);
        NativeContext.dummyContext.addReference(this);
    }

    public static native long nativeCreateFromList(long[] jArr);

    public static native long nativeGetFinalizerPtr();

    public static native long nativeGetObjectSchemaInfo(long j, String str);

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    public OsObjectSchemaInfo getObjectSchemaInfo(String str) {
        return new OsObjectSchemaInfo(nativeGetObjectSchemaInfo(this.nativePtr, str));
    }

    public OsSchemaInfo(long j, OsSharedRealm osSharedRealm) {
        this.nativePtr = j;
        this.sharedRealm = osSharedRealm;
    }
}
