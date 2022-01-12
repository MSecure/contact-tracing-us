package io.realm;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.internal.OsObjectStore;
import io.realm.internal.Table;
import java.util.Locale;

public class MutableRealmSchema extends RealmSchema {
    public MutableRealmSchema(BaseRealm baseRealm) {
        super(baseRealm, null);
    }

    @Override // io.realm.RealmSchema
    public RealmObjectSchema create(String str) {
        checkNotEmpty(str, "Null or empty class names are not allowed");
        String tableNameForClass = Table.getTableNameForClass(str);
        if (str.length() <= Table.CLASS_NAME_MAX_LENGTH) {
            BaseRealm baseRealm = this.realm;
            return new MutableRealmObjectSchema(baseRealm, this, baseRealm.sharedRealm.createTable(tableNameForClass));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Class name is too long. Limit is %1$d characters: %2$s", Integer.valueOf(Table.CLASS_NAME_MAX_LENGTH), Integer.valueOf(str.length())));
    }

    @Override // io.realm.RealmSchema
    public RealmObjectSchema get(String str) {
        checkNotEmpty(str, "Null or empty class names are not allowed");
        String tableNameForClass = Table.getTableNameForClass(str);
        if (!this.realm.sharedRealm.hasTable(tableNameForClass)) {
            return null;
        }
        return new MutableRealmObjectSchema(this.realm, this, this.realm.sharedRealm.getTable(tableNameForClass));
    }

    @Override // io.realm.RealmSchema
    public void remove(String str) {
        this.realm.checkNotInSync();
        checkNotEmpty(str, "Null or empty class names are not allowed");
        String tableNameForClass = Table.getTableNameForClass(str);
        if (OsObjectStore.nativeDeleteTableForObject(this.realm.sharedRealm.getNativePtr(), str)) {
            this.dynamicClassToSchema.remove(tableNameForClass);
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline10("Cannot remove class because it is not in this Realm: ", str));
    }

    @Override // io.realm.RealmSchema
    public RealmObjectSchema rename(String str, String str2) {
        this.realm.checkNotInSync();
        checkNotEmpty(str, "Class names cannot be empty or null");
        checkNotEmpty(str2, "Class names cannot be empty or null");
        String tableNameForClass = Table.getTableNameForClass(str);
        String tableNameForClass2 = Table.getTableNameForClass(str2);
        String outline10 = GeneratedOutlineSupport.outline10("Cannot rename class because it doesn't exist in this Realm: ", str);
        if (!this.realm.sharedRealm.hasTable(Table.getTableNameForClass(str))) {
            throw new IllegalArgumentException(outline10);
        } else if (!this.realm.sharedRealm.hasTable(tableNameForClass2)) {
            this.realm.sharedRealm.renameTable(tableNameForClass, tableNameForClass2);
            Table table = this.realm.sharedRealm.getTable(tableNameForClass2);
            RealmObjectSchema remove = this.dynamicClassToSchema.remove(tableNameForClass);
            if (remove == null || !remove.table.isValid() || !remove.getClassName().equals(str2)) {
                remove = new MutableRealmObjectSchema(this.realm, this, table);
            }
            this.dynamicClassToSchema.put(tableNameForClass2, remove);
            return remove;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline11(str, " cannot be renamed because the new class already exists: ", str2));
        }
    }
}
