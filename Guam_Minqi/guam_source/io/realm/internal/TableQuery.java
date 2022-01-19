package io.realm.internal;

import io.realm.Case;

public class TableQuery implements NativeObject {
    public static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    public final long nativePtr;
    public boolean queryValidated = true;
    public final Table table;

    public TableQuery(NativeContext nativeContext, Table table2, long j) {
        this.table = table2;
        this.nativePtr = j;
        nativeContext.addReference(this);
    }

    private native void nativeAlwaysFalse(long j);

    private native void nativeAlwaysTrue(long j);

    private native double nativeAverageDouble(long j, long j2);

    private native double nativeAverageFloat(long j, long j2);

    private native double nativeAverageInt(long j, long j2);

    private native void nativeBeginsWith(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native void nativeBetween(long j, long[] jArr, double d, double d2);

    private native void nativeBetween(long j, long[] jArr, float f, float f2);

    private native void nativeBetween(long j, long[] jArr, long j2, long j3);

    private native void nativeBetweenTimestamp(long j, long[] jArr, long j2, long j3);

    private native void nativeContains(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native long nativeCount(long j);

    private native void nativeEndGroup(long j);

    private native void nativeEndsWith(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, double d);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, float f);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, boolean z);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, byte[] bArr);

    private native void nativeEqualTimestamp(long j, long[] jArr, long[] jArr2, long j2);

    private native long nativeFind(long j);

    public static native long nativeGetFinalizerPtr();

    private native void nativeGreater(long j, long[] jArr, long[] jArr2, double d);

    private native void nativeGreater(long j, long[] jArr, long[] jArr2, float f);

    private native void nativeGreater(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeGreaterEqual(long j, long[] jArr, long[] jArr2, double d);

    private native void nativeGreaterEqual(long j, long[] jArr, long[] jArr2, float f);

    private native void nativeGreaterEqual(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeGreaterEqualTimestamp(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeGreaterTimestamp(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeGroup(long j);

    private native void nativeIsEmpty(long j, long[] jArr, long[] jArr2);

    private native void nativeIsNotEmpty(long j, long[] jArr, long[] jArr2);

    private native void nativeIsNotNull(long j, long[] jArr, long[] jArr2);

    private native void nativeIsNull(long j, long[] jArr, long[] jArr2);

    private native void nativeLess(long j, long[] jArr, long[] jArr2, double d);

    private native void nativeLess(long j, long[] jArr, long[] jArr2, float f);

    private native void nativeLess(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeLessEqual(long j, long[] jArr, long[] jArr2, double d);

    private native void nativeLessEqual(long j, long[] jArr, long[] jArr2, float f);

    private native void nativeLessEqual(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeLessEqualTimestamp(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeLessTimestamp(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeLike(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native Double nativeMaximumDouble(long j, long j2);

    private native Float nativeMaximumFloat(long j, long j2);

    private native Long nativeMaximumInt(long j, long j2);

    private native Long nativeMaximumTimestamp(long j, long j2);

    private native Double nativeMinimumDouble(long j, long j2);

    private native Float nativeMinimumFloat(long j, long j2);

    private native Long nativeMinimumInt(long j, long j2);

    private native Long nativeMinimumTimestamp(long j, long j2);

    private native void nativeNot(long j);

    private native void nativeNotEqual(long j, long[] jArr, long[] jArr2, double d);

    private native void nativeNotEqual(long j, long[] jArr, long[] jArr2, float f);

    private native void nativeNotEqual(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeNotEqual(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native void nativeNotEqual(long j, long[] jArr, long[] jArr2, byte[] bArr);

    private native void nativeNotEqualTimestamp(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeOr(long j);

    private native long nativeRemove(long j);

    private native double nativeSumDouble(long j, long j2);

    private native double nativeSumFloat(long j, long j2);

    private native long nativeSumInt(long j, long j2);

    private native String nativeValidateQuery(long j);

    public TableQuery equalTo(long[] jArr, long[] jArr2, String str, Case r11) {
        nativeEqual(this.nativePtr, jArr, jArr2, str, r11.value);
        this.queryValidated = false;
        return this;
    }

    public long find() {
        validateQuery();
        return nativeFind(this.nativePtr);
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    public TableQuery lessThan(long[] jArr, long[] jArr2, long j) {
        nativeLess(this.nativePtr, jArr, jArr2, j);
        this.queryValidated = false;
        return this;
    }

    public void validateQuery() {
        if (!this.queryValidated) {
            String nativeValidateQuery = nativeValidateQuery(this.nativePtr);
            if (nativeValidateQuery.equals("")) {
                this.queryValidated = true;
                return;
            }
            throw new UnsupportedOperationException(nativeValidateQuery);
        }
    }
}
