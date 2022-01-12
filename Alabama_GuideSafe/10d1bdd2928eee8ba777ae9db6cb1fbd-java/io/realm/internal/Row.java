package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.Date;

public interface Row {
    byte[] getBinaryByteArray(long j);

    boolean getBoolean(long j);

    long getColumnKey(String str);

    String[] getColumnNames();

    RealmFieldType getColumnType(long j);

    Date getDate(long j);

    double getDouble(long j);

    float getFloat(long j);

    long getLong(long j);

    OsList getModelList(long j);

    long getObjectKey();

    String getString(long j);

    Table getTable();

    OsList getValueList(long j, RealmFieldType realmFieldType);

    boolean isNull(long j);

    boolean isNullLink(long j);

    boolean isValid();

    void setLong(long j, long j2);

    void setNull(long j);

    void setString(long j, String str);
}
