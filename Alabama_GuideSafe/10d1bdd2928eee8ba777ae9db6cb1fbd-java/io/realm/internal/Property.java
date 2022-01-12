package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.Locale;

public class Property implements NativeObject {
    public static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    public long nativePtr;

    public Property(long j) {
        this.nativePtr = j;
        NativeContext.dummyContext.addReference(this);
    }

    public static int convertFromRealmFieldType(RealmFieldType realmFieldType, boolean z) {
        int i = 1;
        int i2 = 0;
        switch (realmFieldType.ordinal()) {
            case 0:
                i = 0;
                break;
            case 1:
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 6:
                i = 6;
                break;
            case 7:
                return 71;
            case 8:
                return 135;
            case 9:
                return 136;
            case 10:
                i = 128;
                break;
            case 11:
                i = 129;
                break;
            case 12:
                i = 130;
                break;
            case 13:
                i = 131;
                break;
            case 14:
                i = 132;
                break;
            case 15:
                i = 133;
                break;
            case 16:
                i = 134;
                break;
            default:
                throw new IllegalArgumentException(String.format(Locale.US, "Unsupported filed type: '%s'.", realmFieldType.name()));
        }
        if (!z) {
            i2 = 64;
        }
        return i | i2;
    }

    public static native long nativeCreateComputedLinkProperty(String str, String str2, String str3);

    public static native long nativeCreatePersistedLinkProperty(String str, int i, String str2);

    public static native long nativeCreatePersistedProperty(String str, int i, boolean z, boolean z2);

    public static native long nativeGetColumnKey(long j);

    public static native long nativeGetFinalizerPtr();

    public static native String nativeGetLinkedObjectName(long j);

    public static native int nativeGetType(long j);

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }
}
