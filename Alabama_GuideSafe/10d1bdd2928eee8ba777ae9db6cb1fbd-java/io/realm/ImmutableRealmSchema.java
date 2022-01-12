package io.realm;

import io.realm.internal.ColumnIndices;
import io.realm.internal.Table;

public class ImmutableRealmSchema extends RealmSchema {
    public ImmutableRealmSchema(BaseRealm baseRealm, ColumnIndices columnIndices) {
        super(baseRealm, columnIndices);
    }

    @Override // io.realm.RealmSchema
    public RealmObjectSchema create(String str) {
        throw new UnsupportedOperationException("This 'RealmSchema' is immutable. Please use 'DynamicRealm.getSchema() to get a mutable instance.");
    }

    @Override // io.realm.RealmSchema
    public RealmObjectSchema get(String str) {
        checkNotEmpty(str, "Null or empty class names are not allowed");
        String tableNameForClass = Table.getTableNameForClass(str);
        if (!this.realm.sharedRealm.hasTable(tableNameForClass)) {
            return null;
        }
        return new ImmutableRealmObjectSchema(this.realm, this, this.realm.sharedRealm.getTable(tableNameForClass), getColumnInfo(str));
    }

    @Override // io.realm.RealmSchema
    public void remove(String str) {
        throw new UnsupportedOperationException("This 'RealmSchema' is immutable. Please use 'DynamicRealm.getSchema() to get a mutable instance.");
    }

    @Override // io.realm.RealmSchema
    public RealmObjectSchema rename(String str, String str2) {
        throw new UnsupportedOperationException("This 'RealmSchema' is immutable. Please use 'DynamicRealm.getSchema() to get a mutable instance.");
    }
}
