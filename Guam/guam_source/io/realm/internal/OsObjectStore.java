package io.realm.internal;

public class OsObjectStore {
    public static String getPrimaryKeyForObject(OsSharedRealm osSharedRealm, String str) {
        return nativeGetPrimaryKeyForObject(osSharedRealm.getNativePtr(), str);
    }

    public static native boolean nativeCallWithLock(String str, Runnable runnable);

    public static native boolean nativeDeleteTableForObject(long j, String str);

    public static native String nativeGetPrimaryKeyForObject(long j, String str);

    public static native long nativeGetSchemaVersion(long j);

    public static native void nativeSetPrimaryKeyForObject(long j, String str, String str2);

    public static native void nativeSetSchemaVersion(long j, long j2);

    public static void setPrimaryKeyForObject(OsSharedRealm osSharedRealm, String str, String str2) {
        nativeSetPrimaryKeyForObject(osSharedRealm.getNativePtr(), str, str2);
    }
}
