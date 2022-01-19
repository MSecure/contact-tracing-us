package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.Date;

public enum InvalidRow implements Row {
    INSTANCE;

    @Override // io.realm.internal.Row
    public byte[] getBinaryByteArray(long j) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public boolean getBoolean(long j) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public long getColumnKey(String str) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public String[] getColumnNames() {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public RealmFieldType getColumnType(long j) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public Date getDate(long j) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public double getDouble(long j) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public float getFloat(long j) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public long getLong(long j) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public OsList getModelList(long j) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public long getObjectKey() {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public String getString(long j) {
        throw getStubException();
    }

    public final RuntimeException getStubException() {
        return new IllegalStateException("Object is no longer managed by Realm. Has it been deleted?");
    }

    @Override // io.realm.internal.Row
    public Table getTable() {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public OsList getValueList(long j, RealmFieldType realmFieldType) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public boolean isNull(long j) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public boolean isNullLink(long j) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public boolean isValid() {
        return false;
    }

    @Override // io.realm.internal.Row
    public void setLong(long j, long j2) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public void setNull(long j) {
        throw getStubException();
    }

    @Override // io.realm.internal.Row
    public void setString(long j, String str) {
        throw getStubException();
    }
}
