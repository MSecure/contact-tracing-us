package io.realm;

import io.realm.exceptions.RealmException;
import io.realm.internal.ColumnIndices;
import io.realm.internal.ColumnInfo;
import io.realm.internal.Table;
import io.realm.internal.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public abstract class RealmSchema {
    public final Map<Class<? extends RealmModel>, RealmObjectSchema> classToSchema = new HashMap();
    public final Map<Class<? extends RealmModel>, Table> classToTable = new HashMap();
    public final ColumnIndices columnIndices;
    public final Map<String, RealmObjectSchema> dynamicClassToSchema = new HashMap();
    public final Map<String, Table> dynamicClassToTable = new HashMap();
    public final BaseRealm realm;

    public RealmSchema(BaseRealm baseRealm, ColumnIndices columnIndices2) {
        this.realm = baseRealm;
        this.columnIndices = columnIndices2;
    }

    public final void checkColumnKeys() {
        if (!(this.columnIndices != null)) {
            throw new IllegalStateException("Attempt to use column key before set.");
        }
    }

    public void checkNotEmpty(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(str2);
        }
    }

    public abstract RealmObjectSchema create(String str);

    public abstract RealmObjectSchema get(String str);

    public final ColumnInfo getColumnInfo(String str) {
        checkColumnKeys();
        ColumnIndices columnIndices2 = this.columnIndices;
        ColumnInfo columnInfo = columnIndices2.simpleClassNameToColumnInfoMap.get(str);
        if (columnInfo == null) {
            Iterator<Class<? extends RealmModel>> it = columnIndices2.mediator.getModelClasses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Class<? extends RealmModel> next = it.next();
                if (columnIndices2.mediator.getSimpleClassName(next).equals(str)) {
                    columnInfo = columnIndices2.getColumnInfo(next);
                    columnIndices2.simpleClassNameToColumnInfoMap.put(str, columnInfo);
                    break;
                }
            }
        }
        if (columnInfo != null) {
            return columnInfo;
        }
        throw new RealmException(String.format(Locale.US, "'%s' doesn't exist in current schema.", str));
    }

    public RealmObjectSchema getSchemaForClass(Class<? extends RealmModel> cls) {
        RealmObjectSchema realmObjectSchema = this.classToSchema.get(cls);
        if (realmObjectSchema != null) {
            return realmObjectSchema;
        }
        Class<? extends RealmModel> originalModelClass = Util.getOriginalModelClass(cls);
        if (originalModelClass.equals(cls)) {
            realmObjectSchema = this.classToSchema.get(originalModelClass);
        }
        if (realmObjectSchema == null) {
            Table table = getTable(cls);
            BaseRealm baseRealm = this.realm;
            checkColumnKeys();
            ImmutableRealmObjectSchema immutableRealmObjectSchema = new ImmutableRealmObjectSchema(baseRealm, this, table, this.columnIndices.getColumnInfo(originalModelClass));
            this.classToSchema.put(originalModelClass, immutableRealmObjectSchema);
            realmObjectSchema = immutableRealmObjectSchema;
        }
        if (originalModelClass.equals(cls)) {
            this.classToSchema.put(cls, realmObjectSchema);
        }
        return realmObjectSchema;
    }

    public Table getTable(String str) {
        String tableNameForClass = Table.getTableNameForClass(str);
        Table table = this.dynamicClassToTable.get(tableNameForClass);
        if (table != null) {
            return table;
        }
        Table table2 = this.realm.sharedRealm.getTable(tableNameForClass);
        this.dynamicClassToTable.put(tableNameForClass, table2);
        return table2;
    }

    public abstract void remove(String str);

    public abstract RealmObjectSchema rename(String str, String str2);

    public Table getTable(Class<? extends RealmModel> cls) {
        Table table = this.classToTable.get(cls);
        if (table != null) {
            return table;
        }
        Class<? extends RealmModel> originalModelClass = Util.getOriginalModelClass(cls);
        if (originalModelClass.equals(cls)) {
            table = this.classToTable.get(originalModelClass);
        }
        if (table == null) {
            table = this.realm.sharedRealm.getTable(Table.getTableNameForClass(this.realm.configuration.schemaMediator.getSimpleClassName(originalModelClass)));
            this.classToTable.put(originalModelClass, table);
        }
        if (originalModelClass.equals(cls)) {
            this.classToTable.put(cls, table);
        }
        return table;
    }
}
