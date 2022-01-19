package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.Date;

public class UncheckedRow implements NativeObject, Row {
    public static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    public final NativeContext context;
    public final long nativePtr;
    public final Table parent;

    public UncheckedRow(NativeContext nativeContext, Table table, long j) {
        this.context = nativeContext;
        this.parent = table;
        this.nativePtr = j;
        nativeContext.addReference(this);
    }

    public static UncheckedRow getByRowKey(NativeContext nativeContext, Table table, long j) {
        return new UncheckedRow(nativeContext, table, table.nativeGetRowPtr(table.nativeTableRefPtr, j));
    }

    public static native long nativeGetFinalizerPtr();

    @Override // io.realm.internal.Row
    public byte[] getBinaryByteArray(long j) {
        return nativeGetByteArray(this.nativePtr, j);
    }

    @Override // io.realm.internal.Row
    public boolean getBoolean(long j) {
        return nativeGetBoolean(this.nativePtr, j);
    }

    @Override // io.realm.internal.Row
    public long getColumnKey(String str) {
        if (str != null) {
            return nativeGetColumnKey(this.nativePtr, str);
        }
        throw new IllegalArgumentException("Column name can not be null.");
    }

    @Override // io.realm.internal.Row
    public String[] getColumnNames() {
        return nativeGetColumnNames(this.nativePtr);
    }

    @Override // io.realm.internal.Row
    public RealmFieldType getColumnType(long j) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.nativePtr, j));
    }

    @Override // io.realm.internal.Row
    public Date getDate(long j) {
        return new Date(nativeGetTimestamp(this.nativePtr, j));
    }

    @Override // io.realm.internal.Row
    public double getDouble(long j) {
        return nativeGetDouble(this.nativePtr, j);
    }

    @Override // io.realm.internal.Row
    public float getFloat(long j) {
        return nativeGetFloat(this.nativePtr, j);
    }

    @Override // io.realm.internal.Row
    public long getLong(long j) {
        return nativeGetLong(this.nativePtr, j);
    }

    @Override // io.realm.internal.Row
    public OsList getModelList(long j) {
        return new OsList(this, j);
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    @Override // io.realm.internal.Row
    public long getObjectKey() {
        return nativeGetObjectKey(this.nativePtr);
    }

    @Override // io.realm.internal.Row
    public String getString(long j) {
        return nativeGetString(this.nativePtr, j);
    }

    @Override // io.realm.internal.Row
    public Table getTable() {
        return this.parent;
    }

    @Override // io.realm.internal.Row
    public OsList getValueList(long j, RealmFieldType realmFieldType) {
        return new OsList(this, j);
    }

    @Override // io.realm.internal.Row
    public boolean isNull(long j) {
        return nativeIsNull(this.nativePtr, j);
    }

    @Override // io.realm.internal.Row
    public boolean isNullLink(long j) {
        return nativeIsNullLink(this.nativePtr, j);
    }

    @Override // io.realm.internal.Row
    public boolean isValid() {
        long j = this.nativePtr;
        return j != 0 && nativeIsValid(j);
    }

    public native long nativeFreeze(long j, long j2);

    public native boolean nativeGetBoolean(long j, long j2);

    public native byte[] nativeGetByteArray(long j, long j2);

    public native long nativeGetColumnCount(long j);

    public native long nativeGetColumnKey(long j, String str);

    public native String[] nativeGetColumnNames(long j);

    public native int nativeGetColumnType(long j, long j2);

    public native double nativeGetDouble(long j, long j2);

    public native float nativeGetFloat(long j, long j2);

    public native long nativeGetLink(long j, long j2);

    public native long nativeGetLong(long j, long j2);

    public native long nativeGetObjectKey(long j);

    public native String nativeGetString(long j, long j2);

    public native long nativeGetTimestamp(long j, long j2);

    public native boolean nativeHasColumn(long j, String str);

    public native boolean nativeIsNull(long j, long j2);

    public native boolean nativeIsNullLink(long j, long j2);

    public native boolean nativeIsValid(long j);

    public native void nativeNullifyLink(long j, long j2);

    public native void nativeSetBoolean(long j, long j2, boolean z);

    public native void nativeSetByteArray(long j, long j2, byte[] bArr);

    public native void nativeSetDouble(long j, long j2, double d);

    public native void nativeSetFloat(long j, long j2, float f);

    public native void nativeSetLink(long j, long j2, long j3);

    public native void nativeSetLong(long j, long j2, long j3);

    public native void nativeSetNull(long j, long j2);

    public native void nativeSetString(long j, long j2, String str);

    public native void nativeSetTimestamp(long j, long j2, long j3);

    @Override // io.realm.internal.Row
    public void setLong(long j, long j2) {
        this.parent.checkImmutable();
        nativeSetLong(this.nativePtr, j, j2);
    }

    @Override // io.realm.internal.Row
    public void setNull(long j) {
        this.parent.checkImmutable();
        nativeSetNull(this.nativePtr, j);
    }

    @Override // io.realm.internal.Row
    public void setString(long j, String str) {
        this.parent.checkImmutable();
        if (str == null) {
            nativeSetNull(this.nativePtr, j);
        } else {
            nativeSetString(this.nativePtr, j, str);
        }
    }

    public UncheckedRow(UncheckedRow uncheckedRow) {
        this.context = uncheckedRow.context;
        this.parent = uncheckedRow.parent;
        this.nativePtr = uncheckedRow.nativePtr;
    }
}
