package io.realm.internal.objectstore;

import java.io.Closeable;

public class OsObjectBuilder implements Closeable {
    public static ItemCallback<String> stringItemCallback = new ItemCallback<String>() {
        /* class io.realm.internal.objectstore.OsObjectBuilder.AnonymousClass2 */
    };

    public interface ItemCallback<T> {
    }

    public static native void nativeAddBoolean(long j, long j2, boolean z);

    public static native void nativeAddBooleanListItem(long j, boolean z);

    public static native void nativeAddByteArray(long j, long j2, byte[] bArr);

    public static native void nativeAddByteArrayListItem(long j, byte[] bArr);

    public static native void nativeAddDate(long j, long j2, long j3);

    public static native void nativeAddDateListItem(long j, long j2);

    public static native void nativeAddDouble(long j, long j2, double d);

    public static native void nativeAddDoubleListItem(long j, double d);

    public static native void nativeAddFloat(long j, long j2, float f);

    public static native void nativeAddFloatListItem(long j, float f);

    public static native void nativeAddInteger(long j, long j2, long j3);

    public static native void nativeAddIntegerListItem(long j, long j2);

    public static native void nativeAddNull(long j, long j2);

    public static native void nativeAddNullListItem(long j);

    public static native void nativeAddObject(long j, long j2, long j3);

    public static native void nativeAddObjectList(long j, long j2, long[] jArr);

    public static native void nativeAddObjectListItem(long j, long j2);

    public static native void nativeAddString(long j, long j2, String str);

    public static native void nativeAddStringListItem(long j, String str);

    public static native long nativeCreateBuilder();

    public static native long nativeCreateOrUpdate(long j, long j2, long j3, boolean z, boolean z2);

    public static native void nativeDestroyBuilder(long j);

    public static native long nativeStartList(long j);

    public static native void nativeStopList(long j, long j2, long j3);
}
