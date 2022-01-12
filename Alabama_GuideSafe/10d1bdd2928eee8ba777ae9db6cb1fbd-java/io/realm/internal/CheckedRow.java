package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.Locale;

public class CheckedRow extends UncheckedRow {
    public CheckedRow(UncheckedRow uncheckedRow) {
        super(uncheckedRow);
    }

    @Override // io.realm.internal.Row, io.realm.internal.UncheckedRow
    public OsList getModelList(long j) {
        if (this.parent.getColumnType(j) == RealmFieldType.LIST) {
            return new OsList(this, j);
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Field '%s' is not a 'RealmList'.", this.parent.getColumnName(j)));
    }

    @Override // io.realm.internal.Row, io.realm.internal.UncheckedRow
    public OsList getValueList(long j, RealmFieldType realmFieldType) {
        if (realmFieldType == this.parent.getColumnType(j)) {
            return new OsList(this, j);
        }
        throw new IllegalArgumentException(String.format(Locale.US, "The type of field '%1$s' is not 'RealmFieldType.%2$s'.", this.parent.getColumnName(j), realmFieldType.name()));
    }

    @Override // io.realm.internal.Row, io.realm.internal.UncheckedRow
    public boolean isNull(long j) {
        return nativeIsNull(this.nativePtr, j);
    }

    @Override // io.realm.internal.Row, io.realm.internal.UncheckedRow
    public boolean isNullLink(long j) {
        RealmFieldType fromNativeValue = RealmFieldType.fromNativeValue(nativeGetColumnType(this.nativePtr, j));
        if (fromNativeValue == RealmFieldType.OBJECT || fromNativeValue == RealmFieldType.LIST) {
            return nativeIsNullLink(this.nativePtr, j);
        }
        return false;
    }

    @Override // io.realm.internal.UncheckedRow
    public native boolean nativeGetBoolean(long j, long j2);

    @Override // io.realm.internal.UncheckedRow
    public native byte[] nativeGetByteArray(long j, long j2);

    @Override // io.realm.internal.UncheckedRow
    public native long nativeGetColumnCount(long j);

    @Override // io.realm.internal.UncheckedRow
    public native long nativeGetColumnKey(long j, String str);

    @Override // io.realm.internal.UncheckedRow
    public native int nativeGetColumnType(long j, long j2);

    @Override // io.realm.internal.UncheckedRow
    public native double nativeGetDouble(long j, long j2);

    @Override // io.realm.internal.UncheckedRow
    public native float nativeGetFloat(long j, long j2);

    @Override // io.realm.internal.UncheckedRow
    public native long nativeGetLink(long j, long j2);

    @Override // io.realm.internal.UncheckedRow
    public native long nativeGetLong(long j, long j2);

    @Override // io.realm.internal.UncheckedRow
    public native String nativeGetString(long j, long j2);

    @Override // io.realm.internal.UncheckedRow
    public native long nativeGetTimestamp(long j, long j2);

    @Override // io.realm.internal.UncheckedRow
    public native boolean nativeIsNullLink(long j, long j2);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeNullifyLink(long j, long j2);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetBoolean(long j, long j2, boolean z);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetByteArray(long j, long j2, byte[] bArr);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetDouble(long j, long j2, double d);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetFloat(long j, long j2, float f);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetLink(long j, long j2, long j3);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetLong(long j, long j2, long j3);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetString(long j, long j2, String str);

    @Override // io.realm.internal.UncheckedRow
    public native void nativeSetTimestamp(long j, long j2, long j3);

    @Override // io.realm.internal.Row, io.realm.internal.UncheckedRow
    public void setNull(long j) {
        if (RealmFieldType.fromNativeValue(nativeGetColumnType(this.nativePtr, j)) == RealmFieldType.BINARY) {
            this.parent.checkImmutable();
            nativeSetByteArray(this.nativePtr, j, null);
            return;
        }
        this.parent.checkImmutable();
        nativeSetNull(this.nativePtr, j);
    }
}
