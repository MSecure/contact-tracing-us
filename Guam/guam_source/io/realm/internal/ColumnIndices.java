package io.realm.internal;

import io.realm.RealmModel;
import java.util.HashMap;
import java.util.Map;

public final class ColumnIndices {
    public final Map<Class<? extends RealmModel>, ColumnInfo> classToColumnInfoMap = new HashMap();
    public final RealmProxyMediator mediator;
    public final OsSchemaInfo osSchemaInfo;
    public final Map<String, ColumnInfo> simpleClassNameToColumnInfoMap = new HashMap();

    public ColumnIndices(RealmProxyMediator realmProxyMediator, OsSchemaInfo osSchemaInfo2) {
        this.mediator = realmProxyMediator;
        this.osSchemaInfo = osSchemaInfo2;
    }

    public ColumnInfo getColumnInfo(Class<? extends RealmModel> cls) {
        ColumnInfo columnInfo = this.classToColumnInfoMap.get(cls);
        if (columnInfo != null) {
            return columnInfo;
        }
        ColumnInfo createColumnInfo = this.mediator.createColumnInfo(cls, this.osSchemaInfo);
        this.classToColumnInfoMap.put(cls, createColumnInfo);
        return createColumnInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ColumnIndices[");
        boolean z = false;
        for (Map.Entry<Class<? extends RealmModel>, ColumnInfo> entry : this.classToColumnInfoMap.entrySet()) {
            if (z) {
                sb.append(",");
            }
            sb.append(entry.getKey().getSimpleName());
            sb.append("->");
            sb.append(entry.getValue());
            z = true;
        }
        sb.append("]");
        return sb.toString();
    }
}
