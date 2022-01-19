package io.realm;

import io.realm.BaseRealm;
import io.realm.exceptions.RealmException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.UncheckedRow;
import io.realm.internal.objectstore.OsObjectBuilder;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.KeyValues;

public class org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy extends KeyValues implements RealmObjectProxy, org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxyInterface {
    public static final OsObjectSchemaInfo expectedObjectSchemaInfo;
    public KeyValuesColumnInfo columnInfo;
    public ProxyState<KeyValues> proxyState;

    public static final class KeyValuesColumnInfo extends ColumnInfo {
        public long idColKey;
        public long valueColKey;

        public KeyValuesColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(2, true);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("KeyValues");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.valueColKey = addColumnDetails("value", "value", objectSchemaInfo);
        }

        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            KeyValuesColumnInfo keyValuesColumnInfo = (KeyValuesColumnInfo) columnInfo;
            KeyValuesColumnInfo keyValuesColumnInfo2 = (KeyValuesColumnInfo) columnInfo2;
            keyValuesColumnInfo2.idColKey = keyValuesColumnInfo.idColKey;
            keyValuesColumnInfo2.valueColKey = keyValuesColumnInfo.valueColKey;
        }
    }

    static {
        long[] jArr = {Property.nativeCreatePersistedProperty("id", Property.convertFromRealmFieldType(RealmFieldType.STRING, true), true, false), Property.nativeCreatePersistedProperty("value", Property.convertFromRealmFieldType(RealmFieldType.STRING, false), false, false)};
        OsObjectSchemaInfo osObjectSchemaInfo = new OsObjectSchemaInfo("KeyValues", null);
        OsObjectSchemaInfo.nativeAddProperties(osObjectSchemaInfo.nativePtr, jArr, new long[0]);
        expectedObjectSchemaInfo = osObjectSchemaInfo;
    }

    public org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f4  */
    public static KeyValues copyOrUpdate(Realm realm, KeyValuesColumnInfo keyValuesColumnInfo, KeyValues keyValues, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        boolean z2;
        ImportFlag importFlag = ImportFlag.CHECK_SAME_VALUES_BEFORE_SET;
        if ((keyValues instanceof RealmObjectProxy) && !RealmObject.isFrozen(keyValues)) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) keyValues;
            if (realmObjectProxy.realmGet$proxyState().realm != null) {
                BaseRealm baseRealm = realmObjectProxy.realmGet$proxyState().realm;
                if (baseRealm.threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                } else if (baseRealm.configuration.canonicalPath.equals(realm.configuration.canonicalPath)) {
                    return keyValues;
                }
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy2 = map.get(keyValues);
        if (realmObjectProxy2 != null) {
            return (KeyValues) realmObjectProxy2;
        }
        org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_keyvaluesrealmproxy = null;
        if (z) {
            Table table = realm.schema.getTable(KeyValues.class);
            long j = keyValuesColumnInfo.idColKey;
            String realmGet$id = keyValues.realmGet$id();
            if (table == null) {
                throw null;
            } else if (realmGet$id != null) {
                long nativeFindFirstString = Table.nativeFindFirstString(table.nativeTableRefPtr, j, realmGet$id);
                if (nativeFindFirstString == -1) {
                    z2 = false;
                    if (!z2) {
                        Table table2 = realm.schema.getTable(KeyValues.class);
                        long nativePtr = table2.sharedRealm.getNativePtr();
                        table2.getColumnNames();
                        long j2 = table2.nativeTableRefPtr;
                        long nativeCreateBuilder = OsObjectBuilder.nativeCreateBuilder();
                        boolean contains = set.contains(importFlag);
                        long j3 = keyValuesColumnInfo.idColKey;
                        String realmGet$id2 = keyValues.realmGet$id();
                        if (realmGet$id2 == null) {
                            OsObjectBuilder.nativeAddNull(nativeCreateBuilder, j3);
                        } else {
                            OsObjectBuilder.nativeAddString(nativeCreateBuilder, j3, realmGet$id2);
                        }
                        long j4 = keyValuesColumnInfo.valueColKey;
                        String realmGet$value = keyValues.realmGet$value();
                        if (realmGet$value == null) {
                            OsObjectBuilder.nativeAddNull(nativeCreateBuilder, j4);
                        } else {
                            OsObjectBuilder.nativeAddString(nativeCreateBuilder, j4, realmGet$value);
                        }
                        try {
                            OsObjectBuilder.nativeCreateOrUpdate(nativePtr, j2, nativeCreateBuilder, true, contains);
                            return org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_keyvaluesrealmproxy;
                        } finally {
                            OsObjectBuilder.nativeDestroyBuilder(nativeCreateBuilder);
                        }
                    } else {
                        RealmObjectProxy realmObjectProxy3 = map.get(keyValues);
                        if (realmObjectProxy3 != null) {
                            return (KeyValues) realmObjectProxy3;
                        }
                        Table table3 = realm.schema.getTable(KeyValues.class);
                        OsSharedRealm osSharedRealm = table3.sharedRealm;
                        long nativePtr2 = osSharedRealm.getNativePtr();
                        table3.getColumnNames();
                        long j5 = table3.nativeTableRefPtr;
                        long nativeCreateBuilder2 = OsObjectBuilder.nativeCreateBuilder();
                        NativeContext nativeContext = osSharedRealm.context;
                        set.contains(importFlag);
                        long j6 = keyValuesColumnInfo.idColKey;
                        String realmGet$id3 = keyValues.realmGet$id();
                        if (realmGet$id3 == null) {
                            OsObjectBuilder.nativeAddNull(nativeCreateBuilder2, j6);
                        } else {
                            OsObjectBuilder.nativeAddString(nativeCreateBuilder2, j6, realmGet$id3);
                        }
                        long j7 = keyValuesColumnInfo.valueColKey;
                        String realmGet$value2 = keyValues.realmGet$value();
                        if (realmGet$value2 == null) {
                            OsObjectBuilder.nativeAddNull(nativeCreateBuilder2, j7);
                        } else {
                            OsObjectBuilder.nativeAddString(nativeCreateBuilder2, j7, realmGet$value2);
                        }
                        try {
                            UncheckedRow uncheckedRow = new UncheckedRow(nativeContext, table3, OsObjectBuilder.nativeCreateOrUpdate(nativePtr2, j5, nativeCreateBuilder2, false, false));
                            OsObjectBuilder.nativeDestroyBuilder(nativeCreateBuilder2);
                            BaseRealm.RealmObjectContext realmObjectContext2 = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                            RealmSchema realmSchema = realm.schema;
                            realmSchema.checkColumnKeys();
                            ColumnInfo columnInfo2 = realmSchema.columnIndices.getColumnInfo(KeyValues.class);
                            List<String> emptyList = Collections.emptyList();
                            realmObjectContext2.realm = realm;
                            realmObjectContext2.row = uncheckedRow;
                            realmObjectContext2.columnInfo = columnInfo2;
                            realmObjectContext2.acceptDefaultValue = false;
                            realmObjectContext2.excludeFields = emptyList;
                            org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_keyvaluesrealmproxy2 = new org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy();
                            realmObjectContext2.clear();
                            map.put(keyValues, org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_keyvaluesrealmproxy2);
                            return org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_keyvaluesrealmproxy2;
                        } catch (Throwable th) {
                            OsObjectBuilder.nativeDestroyBuilder(nativeCreateBuilder2);
                            throw th;
                        }
                    }
                } else {
                    try {
                        UncheckedRow uncheckedRow2 = table.getUncheckedRow(nativeFindFirstString);
                        List<String> emptyList2 = Collections.emptyList();
                        realmObjectContext.realm = realm;
                        realmObjectContext.row = uncheckedRow2;
                        realmObjectContext.columnInfo = keyValuesColumnInfo;
                        realmObjectContext.acceptDefaultValue = false;
                        realmObjectContext.excludeFields = emptyList2;
                        org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_keyvaluesrealmproxy = new org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy();
                        map.put(keyValues, org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_keyvaluesrealmproxy);
                    } finally {
                        realmObjectContext.clear();
                    }
                }
            } else {
                throw new IllegalArgumentException("null is not supported");
            }
        }
        z2 = z;
        if (!z2) {
        }
    }

    public static KeyValuesColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new KeyValuesColumnInfo(osSchemaInfo);
    }

    public static KeyValues createDetachedCopy(KeyValues keyValues, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        KeyValues keyValues2;
        if (i > i2) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cacheData = map.get(keyValues);
        if (cacheData == null) {
            keyValues2 = new KeyValues();
            map.put(keyValues, new RealmObjectProxy.CacheData<>(i, keyValues2));
        } else if (i >= cacheData.minDepth) {
            return (KeyValues) cacheData.object;
        } else {
            cacheData.minDepth = i;
            keyValues2 = (KeyValues) cacheData.object;
        }
        keyValues2.realmSet$id(keyValues.realmGet$id());
        keyValues2.realmSet$value(keyValues.realmGet$value());
        return keyValues2;
    }

    public static long insert(Realm realm, KeyValues keyValues, Map<RealmModel, Long> map) {
        if ((keyValues instanceof RealmObjectProxy) && !RealmObject.isFrozen(keyValues)) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) keyValues;
            if (realmObjectProxy.realmGet$proxyState().realm != null && realmObjectProxy.realmGet$proxyState().realm.configuration.canonicalPath.equals(realm.configuration.canonicalPath)) {
                return realmObjectProxy.realmGet$proxyState().row.getObjectKey();
            }
        }
        Table table = realm.schema.getTable(KeyValues.class);
        long j = table.nativeTableRefPtr;
        RealmSchema realmSchema = realm.schema;
        realmSchema.checkColumnKeys();
        KeyValuesColumnInfo keyValuesColumnInfo = (KeyValuesColumnInfo) realmSchema.columnIndices.getColumnInfo(KeyValues.class);
        long j2 = keyValuesColumnInfo.idColKey;
        String realmGet$id = keyValues.realmGet$id();
        if ((realmGet$id != null ? Table.nativeFindFirstString(j, j2, realmGet$id) : -1) == -1) {
            long createRowWithPrimaryKey = OsObject.createRowWithPrimaryKey(table, j2, realmGet$id);
            map.put(keyValues, Long.valueOf(createRowWithPrimaryKey));
            String realmGet$value = keyValues.realmGet$value();
            if (realmGet$value != null) {
                Table.nativeSetString(j, keyValuesColumnInfo.valueColKey, createRowWithPrimaryKey, realmGet$value, false);
            }
            return createRowWithPrimaryKey;
        }
        Table.throwDuplicatePrimaryKeyException(realmGet$id);
        throw null;
    }

    public static long insertOrUpdate(Realm realm, KeyValues keyValues, Map<RealmModel, Long> map) {
        if ((keyValues instanceof RealmObjectProxy) && !RealmObject.isFrozen(keyValues)) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) keyValues;
            if (realmObjectProxy.realmGet$proxyState().realm != null && realmObjectProxy.realmGet$proxyState().realm.configuration.canonicalPath.equals(realm.configuration.canonicalPath)) {
                return realmObjectProxy.realmGet$proxyState().row.getObjectKey();
            }
        }
        Table table = realm.schema.getTable(KeyValues.class);
        long j = table.nativeTableRefPtr;
        RealmSchema realmSchema = realm.schema;
        realmSchema.checkColumnKeys();
        KeyValuesColumnInfo keyValuesColumnInfo = (KeyValuesColumnInfo) realmSchema.columnIndices.getColumnInfo(KeyValues.class);
        long j2 = keyValuesColumnInfo.idColKey;
        String realmGet$id = keyValues.realmGet$id();
        long nativeFindFirstString = realmGet$id != null ? Table.nativeFindFirstString(j, j2, realmGet$id) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j2, realmGet$id);
        }
        map.put(keyValues, Long.valueOf(nativeFindFirstString));
        String realmGet$value = keyValues.realmGet$value();
        if (realmGet$value != null) {
            Table.nativeSetString(j, keyValuesColumnInfo.valueColKey, nativeFindFirstString, realmGet$value, false);
        } else {
            Table.nativeSetNull(j, keyValuesColumnInfo.valueColKey, nativeFindFirstString, false);
        }
        return nativeFindFirstString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy.class != obj.getClass()) {
            return false;
        }
        org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_keyvaluesrealmproxy = (org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy) obj;
        BaseRealm baseRealm = this.proxyState.realm;
        BaseRealm baseRealm2 = org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_keyvaluesrealmproxy.proxyState.realm;
        String str = baseRealm.configuration.canonicalPath;
        String str2 = baseRealm2.configuration.canonicalPath;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        if (baseRealm.isFrozen() != baseRealm2.isFrozen() || !baseRealm.sharedRealm.getVersionID().equals(baseRealm2.sharedRealm.getVersionID())) {
            return false;
        }
        String name = this.proxyState.row.getTable().getName();
        String name2 = org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_keyvaluesrealmproxy.proxyState.row.getTable().getName();
        if (name == null ? name2 == null : name.equals(name2)) {
            return this.proxyState.row.getObjectKey() == org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_keyvaluesrealmproxy.proxyState.row.getObjectKey();
        }
        return false;
    }

    public int hashCode() {
        ProxyState<KeyValues> proxyState2 = this.proxyState;
        String str = proxyState2.realm.configuration.canonicalPath;
        String name = proxyState2.row.getTable().getName();
        long objectKey = this.proxyState.row.getObjectKey();
        int i = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        if (name != null) {
            i = name.hashCode();
        }
        return ((hashCode + i) * 31) + ((int) ((objectKey >>> 32) ^ objectKey));
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (KeyValuesColumnInfo) realmObjectContext.columnInfo;
            ProxyState<KeyValues> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.realm = realmObjectContext.realm;
            proxyState2.row = realmObjectContext.row;
            proxyState2.acceptDefaultValue = realmObjectContext.acceptDefaultValue;
            proxyState2.excludeFields = realmObjectContext.excludeFields;
        }
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxyInterface, org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.KeyValues
    public String realmGet$id() {
        this.proxyState.realm.checkIfValid();
        return this.proxyState.row.getString(this.columnInfo.idColKey);
    }

    @Override // io.realm.internal.RealmObjectProxy
    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxyInterface, org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.KeyValues
    public String realmGet$value() {
        this.proxyState.realm.checkIfValid();
        return this.proxyState.row.getString(this.columnInfo.valueColKey);
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxyInterface, org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.KeyValues
    public void realmSet$id(String str) {
        ProxyState<KeyValues> proxyState2 = this.proxyState;
        if (!proxyState2.underConstruction) {
            proxyState2.realm.checkIfValid();
            throw new RealmException("Primary key field 'id' cannot be changed after object was created.");
        }
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxyInterface, org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.KeyValues
    public void realmSet$value(String str) {
        ProxyState<KeyValues> proxyState2 = this.proxyState;
        if (!proxyState2.underConstruction) {
            proxyState2.realm.checkIfValid();
            if (str == null) {
                this.proxyState.row.setNull(this.columnInfo.valueColKey);
            } else {
                this.proxyState.row.setString(this.columnInfo.valueColKey, str);
            }
        } else if (proxyState2.acceptDefaultValue) {
            Row row = proxyState2.row;
            if (str == null) {
                Table table = row.getTable();
                long j = this.columnInfo.valueColKey;
                long objectKey = row.getObjectKey();
                table.checkImmutable();
                Table.nativeSetNull(table.nativeTableRefPtr, j, objectKey, true);
                return;
            }
            Table table2 = row.getTable();
            long j2 = this.columnInfo.valueColKey;
            long objectKey2 = row.getObjectKey();
            table2.checkImmutable();
            Table.nativeSetString(table2.nativeTableRefPtr, j2, objectKey2, str, true);
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb = new StringBuilder("KeyValues = proxy[");
        sb.append("{id:");
        sb.append(realmGet$id());
        sb.append("}");
        sb.append(",");
        sb.append("{value:");
        sb.append(realmGet$value() != null ? realmGet$value() : "null");
        sb.append("}");
        sb.append("]");
        return sb.toString();
    }
}
