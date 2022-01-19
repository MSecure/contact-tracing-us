package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.BaseRealm;
import io.realm.DynamicRealmObject;
import io.realm.ImmutableRealmObjectSchema;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.internal.OsObjectStore;
import io.realm.internal.Table;
import java.util.Locale;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.KeyValues;

/* compiled from: Migration.kt */
public final class Migration$migrate$1 implements RealmObjectSchema.Function {
    public static final Migration$migrate$1 INSTANCE = new Migration$migrate$1();

    @Override // io.realm.RealmObjectSchema.Function
    public final void apply(DynamicRealmObject dynamicRealmObject) {
        dynamicRealmObject.proxyState.realm.checkIfValid();
        RealmSchema schema = dynamicRealmObject.proxyState.realm.getSchema();
        dynamicRealmObject.proxyState.realm.checkIfValid();
        String className = dynamicRealmObject.proxyState.row.getTable().getClassName();
        if (schema != null) {
            String tableNameForClass = Table.getTableNameForClass(className);
            RealmObjectSchema realmObjectSchema = schema.dynamicClassToSchema.get(tableNameForClass);
            if (realmObjectSchema == null || !realmObjectSchema.table.isValid() || !realmObjectSchema.getClassName().equals(className)) {
                if (schema.realm.sharedRealm.hasTable(tableNameForClass)) {
                    BaseRealm baseRealm = schema.realm;
                    realmObjectSchema = new ImmutableRealmObjectSchema(baseRealm, schema, baseRealm.sharedRealm.getTable(tableNameForClass));
                    schema.dynamicClassToSchema.put(tableNameForClass, realmObjectSchema);
                } else {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline9("The class ", className, " doesn't exist in this Realm."));
                }
            }
            if (OsObjectStore.getPrimaryKeyForObject(realmObjectSchema.realm.sharedRealm, realmObjectSchema.getClassName()) != null) {
                String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(realmObjectSchema.realm.sharedRealm, realmObjectSchema.getClassName());
                if (primaryKeyForObject == null) {
                    throw new IllegalStateException(realmObjectSchema.getClassName() + " doesn't have a primary key.");
                } else if (primaryKeyForObject.equals("id")) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Primary key field '%s' cannot be changed after object was created.", "id"));
                }
            }
            dynamicRealmObject.proxyState.row.setString(dynamicRealmObject.proxyState.row.getColumnKey("id"), KeyValues.LAST_PROCESSED_FILE_NAME_KEY);
            return;
        }
        throw null;
    }
}
