package io.realm;

import com.android.tools.r8.GeneratedOutlineSupport;
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
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity;

public class org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy extends ExposureEntity implements RealmObjectProxy, org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface {
    public static final OsObjectSchemaInfo expectedObjectSchemaInfo;
    public ExposureEntityColumnInfo columnInfo;
    public ProxyState<ExposureEntity> proxyState;

    public static final class ExposureEntityColumnInfo extends ColumnInfo {
        public long dateMillisSinceEpochColKey;
        public long idColKey;
        public long receivedTimestampMsColKey;

        public ExposureEntityColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(3, true);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("ExposureEntity");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.dateMillisSinceEpochColKey = addColumnDetails("dateMillisSinceEpoch", "dateMillisSinceEpoch", objectSchemaInfo);
            this.receivedTimestampMsColKey = addColumnDetails("receivedTimestampMs", "receivedTimestampMs", objectSchemaInfo);
        }

        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            ExposureEntityColumnInfo exposureEntityColumnInfo = (ExposureEntityColumnInfo) columnInfo;
            ExposureEntityColumnInfo exposureEntityColumnInfo2 = (ExposureEntityColumnInfo) columnInfo2;
            exposureEntityColumnInfo2.idColKey = exposureEntityColumnInfo.idColKey;
            exposureEntityColumnInfo2.dateMillisSinceEpochColKey = exposureEntityColumnInfo.dateMillisSinceEpochColKey;
            exposureEntityColumnInfo2.receivedTimestampMsColKey = exposureEntityColumnInfo.receivedTimestampMsColKey;
        }
    }

    static {
        long[] jArr = {Property.nativeCreatePersistedProperty("id", Property.convertFromRealmFieldType(RealmFieldType.INTEGER, true), true, true), Property.nativeCreatePersistedProperty("dateMillisSinceEpoch", Property.convertFromRealmFieldType(RealmFieldType.INTEGER, true), false, false), Property.nativeCreatePersistedProperty("receivedTimestampMs", Property.convertFromRealmFieldType(RealmFieldType.INTEGER, true), false, false)};
        OsObjectSchemaInfo osObjectSchemaInfo = new OsObjectSchemaInfo("ExposureEntity", null);
        OsObjectSchemaInfo.nativeAddProperties(osObjectSchemaInfo.nativePtr, jArr, new long[0]);
        expectedObjectSchemaInfo = osObjectSchemaInfo;
    }

    public org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011a  */
    public static ExposureEntity copyOrUpdate(Realm realm, ExposureEntityColumnInfo exposureEntityColumnInfo, ExposureEntity exposureEntity, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        boolean z2;
        long j;
        long j2;
        long j3;
        ImportFlag importFlag = ImportFlag.CHECK_SAME_VALUES_BEFORE_SET;
        if ((exposureEntity instanceof RealmObjectProxy) && !RealmObject.isFrozen(exposureEntity)) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) exposureEntity;
            if (realmObjectProxy.realmGet$proxyState().realm != null) {
                BaseRealm baseRealm = realmObjectProxy.realmGet$proxyState().realm;
                if (baseRealm.threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                } else if (baseRealm.configuration.canonicalPath.equals(realm.configuration.canonicalPath)) {
                    return exposureEntity;
                }
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy2 = map.get(exposureEntity);
        if (realmObjectProxy2 != null) {
            return (ExposureEntity) realmObjectProxy2;
        }
        org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_exposureentityrealmproxy = null;
        if (z) {
            Table table = realm.schema.getTable(ExposureEntity.class);
            long nativeFindFirstInt = Table.nativeFindFirstInt(table.nativeTableRefPtr, exposureEntityColumnInfo.idColKey, exposureEntity.realmGet$id());
            if (nativeFindFirstInt == -1) {
                z2 = false;
                if (!z2) {
                    Table table2 = realm.schema.getTable(ExposureEntity.class);
                    long nativePtr = table2.sharedRealm.getNativePtr();
                    table2.getColumnNames();
                    long j4 = table2.nativeTableRefPtr;
                    long nativeCreateBuilder = OsObjectBuilder.nativeCreateBuilder();
                    boolean contains = set.contains(importFlag);
                    long j5 = exposureEntityColumnInfo.idColKey;
                    Long valueOf = Long.valueOf(exposureEntity.realmGet$id());
                    if (valueOf == null) {
                        OsObjectBuilder.nativeAddNull(nativeCreateBuilder, j5);
                    } else {
                        OsObjectBuilder.nativeAddInteger(nativeCreateBuilder, j5, valueOf.longValue());
                    }
                    long j6 = exposureEntityColumnInfo.dateMillisSinceEpochColKey;
                    Long valueOf2 = Long.valueOf(exposureEntity.realmGet$dateMillisSinceEpoch());
                    if (valueOf2 == null) {
                        OsObjectBuilder.nativeAddNull(nativeCreateBuilder, j6);
                    } else {
                        OsObjectBuilder.nativeAddInteger(nativeCreateBuilder, j6, valueOf2.longValue());
                    }
                    long j7 = exposureEntityColumnInfo.receivedTimestampMsColKey;
                    Long valueOf3 = Long.valueOf(exposureEntity.realmGet$receivedTimestampMs());
                    if (valueOf3 == null) {
                        OsObjectBuilder.nativeAddNull(nativeCreateBuilder, j7);
                    } else {
                        OsObjectBuilder.nativeAddInteger(nativeCreateBuilder, j7, valueOf3.longValue());
                    }
                    try {
                        OsObjectBuilder.nativeCreateOrUpdate(nativePtr, j4, nativeCreateBuilder, true, contains);
                        return org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_exposureentityrealmproxy;
                    } finally {
                        OsObjectBuilder.nativeDestroyBuilder(nativeCreateBuilder);
                    }
                } else {
                    RealmObjectProxy realmObjectProxy3 = map.get(exposureEntity);
                    if (realmObjectProxy3 != null) {
                        return (ExposureEntity) realmObjectProxy3;
                    }
                    Table table3 = realm.schema.getTable(ExposureEntity.class);
                    OsSharedRealm osSharedRealm = table3.sharedRealm;
                    long nativePtr2 = osSharedRealm.getNativePtr();
                    table3.getColumnNames();
                    long j8 = table3.nativeTableRefPtr;
                    long nativeCreateBuilder2 = OsObjectBuilder.nativeCreateBuilder();
                    NativeContext nativeContext = osSharedRealm.context;
                    set.contains(importFlag);
                    long j9 = exposureEntityColumnInfo.idColKey;
                    Long valueOf4 = Long.valueOf(exposureEntity.realmGet$id());
                    if (valueOf4 == null) {
                        OsObjectBuilder.nativeAddNull(nativeCreateBuilder2, j9);
                        j = nativeCreateBuilder2;
                    } else {
                        j = nativeCreateBuilder2;
                        OsObjectBuilder.nativeAddInteger(nativeCreateBuilder2, j9, valueOf4.longValue());
                    }
                    long j10 = exposureEntityColumnInfo.dateMillisSinceEpochColKey;
                    Long valueOf5 = Long.valueOf(exposureEntity.realmGet$dateMillisSinceEpoch());
                    if (valueOf5 == null) {
                        j2 = nativePtr2;
                        j3 = j;
                        OsObjectBuilder.nativeAddNull(j3, j10);
                    } else {
                        j2 = nativePtr2;
                        j3 = j;
                        OsObjectBuilder.nativeAddInteger(j3, j10, valueOf5.longValue());
                    }
                    long j11 = exposureEntityColumnInfo.receivedTimestampMsColKey;
                    Long valueOf6 = Long.valueOf(exposureEntity.realmGet$receivedTimestampMs());
                    if (valueOf6 == null) {
                        OsObjectBuilder.nativeAddNull(j3, j11);
                    } else {
                        OsObjectBuilder.nativeAddInteger(j3, j11, valueOf6.longValue());
                    }
                    try {
                        UncheckedRow uncheckedRow = new UncheckedRow(nativeContext, table3, OsObjectBuilder.nativeCreateOrUpdate(j2, j8, j3, false, false));
                        OsObjectBuilder.nativeDestroyBuilder(j3);
                        BaseRealm.RealmObjectContext realmObjectContext2 = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                        RealmSchema realmSchema = realm.schema;
                        realmSchema.checkColumnKeys();
                        ColumnInfo columnInfo2 = realmSchema.columnIndices.getColumnInfo(ExposureEntity.class);
                        List<String> emptyList = Collections.emptyList();
                        realmObjectContext2.realm = realm;
                        realmObjectContext2.row = uncheckedRow;
                        realmObjectContext2.columnInfo = columnInfo2;
                        realmObjectContext2.acceptDefaultValue = false;
                        realmObjectContext2.excludeFields = emptyList;
                        org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_exposureentityrealmproxy2 = new org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy();
                        realmObjectContext2.clear();
                        map.put(exposureEntity, org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_exposureentityrealmproxy2);
                        return org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_exposureentityrealmproxy2;
                    } catch (Throwable th) {
                        OsObjectBuilder.nativeDestroyBuilder(j3);
                        throw th;
                    }
                }
            } else {
                try {
                    UncheckedRow uncheckedRow2 = table.getUncheckedRow(nativeFindFirstInt);
                    List<String> emptyList2 = Collections.emptyList();
                    realmObjectContext.realm = realm;
                    realmObjectContext.row = uncheckedRow2;
                    realmObjectContext.columnInfo = exposureEntityColumnInfo;
                    realmObjectContext.acceptDefaultValue = false;
                    realmObjectContext.excludeFields = emptyList2;
                    org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_exposureentityrealmproxy = new org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy();
                    map.put(exposureEntity, org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_exposureentityrealmproxy);
                } finally {
                    realmObjectContext.clear();
                }
            }
        }
        z2 = z;
        if (!z2) {
        }
    }

    public static ExposureEntityColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new ExposureEntityColumnInfo(osSchemaInfo);
    }

    public static ExposureEntity createDetachedCopy(ExposureEntity exposureEntity, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        ExposureEntity exposureEntity2;
        if (i > i2) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cacheData = map.get(exposureEntity);
        if (cacheData == null) {
            exposureEntity2 = new ExposureEntity();
            map.put(exposureEntity, new RealmObjectProxy.CacheData<>(i, exposureEntity2));
        } else if (i >= cacheData.minDepth) {
            return (ExposureEntity) cacheData.object;
        } else {
            cacheData.minDepth = i;
            exposureEntity2 = (ExposureEntity) cacheData.object;
        }
        exposureEntity2.realmSet$id(exposureEntity.realmGet$id());
        exposureEntity2.realmSet$dateMillisSinceEpoch(exposureEntity.realmGet$dateMillisSinceEpoch());
        exposureEntity2.realmSet$receivedTimestampMs(exposureEntity.realmGet$receivedTimestampMs());
        return exposureEntity2;
    }

    public static long insert(Realm realm, ExposureEntity exposureEntity, Map<RealmModel, Long> map) {
        if ((exposureEntity instanceof RealmObjectProxy) && !RealmObject.isFrozen(exposureEntity)) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) exposureEntity;
            if (realmObjectProxy.realmGet$proxyState().realm != null && realmObjectProxy.realmGet$proxyState().realm.configuration.canonicalPath.equals(realm.configuration.canonicalPath)) {
                return realmObjectProxy.realmGet$proxyState().row.getObjectKey();
            }
        }
        Table table = realm.schema.getTable(ExposureEntity.class);
        long j = table.nativeTableRefPtr;
        RealmSchema realmSchema = realm.schema;
        realmSchema.checkColumnKeys();
        ExposureEntityColumnInfo exposureEntityColumnInfo = (ExposureEntityColumnInfo) realmSchema.columnIndices.getColumnInfo(ExposureEntity.class);
        long j2 = exposureEntityColumnInfo.idColKey;
        Long valueOf = Long.valueOf(exposureEntity.realmGet$id());
        if ((valueOf != null ? Table.nativeFindFirstInt(j, j2, exposureEntity.realmGet$id()) : -1) == -1) {
            long createRowWithPrimaryKey = OsObject.createRowWithPrimaryKey(table, j2, Long.valueOf(exposureEntity.realmGet$id()));
            map.put(exposureEntity, Long.valueOf(createRowWithPrimaryKey));
            Table.nativeSetLong(j, exposureEntityColumnInfo.dateMillisSinceEpochColKey, createRowWithPrimaryKey, exposureEntity.realmGet$dateMillisSinceEpoch(), false);
            Table.nativeSetLong(j, exposureEntityColumnInfo.receivedTimestampMsColKey, createRowWithPrimaryKey, exposureEntity.realmGet$receivedTimestampMs(), false);
            return createRowWithPrimaryKey;
        }
        Table.throwDuplicatePrimaryKeyException(valueOf);
        throw null;
    }

    public static long insertOrUpdate(Realm realm, ExposureEntity exposureEntity, Map<RealmModel, Long> map) {
        if ((exposureEntity instanceof RealmObjectProxy) && !RealmObject.isFrozen(exposureEntity)) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) exposureEntity;
            if (realmObjectProxy.realmGet$proxyState().realm != null && realmObjectProxy.realmGet$proxyState().realm.configuration.canonicalPath.equals(realm.configuration.canonicalPath)) {
                return realmObjectProxy.realmGet$proxyState().row.getObjectKey();
            }
        }
        Table table = realm.schema.getTable(ExposureEntity.class);
        long j = table.nativeTableRefPtr;
        RealmSchema realmSchema = realm.schema;
        realmSchema.checkColumnKeys();
        ExposureEntityColumnInfo exposureEntityColumnInfo = (ExposureEntityColumnInfo) realmSchema.columnIndices.getColumnInfo(ExposureEntity.class);
        long j2 = exposureEntityColumnInfo.idColKey;
        long nativeFindFirstInt = Long.valueOf(exposureEntity.realmGet$id()) != null ? Table.nativeFindFirstInt(j, j2, exposureEntity.realmGet$id()) : -1;
        if (nativeFindFirstInt == -1) {
            nativeFindFirstInt = OsObject.createRowWithPrimaryKey(table, j2, Long.valueOf(exposureEntity.realmGet$id()));
        }
        map.put(exposureEntity, Long.valueOf(nativeFindFirstInt));
        Table.nativeSetLong(j, exposureEntityColumnInfo.dateMillisSinceEpochColKey, nativeFindFirstInt, exposureEntity.realmGet$dateMillisSinceEpoch(), false);
        Table.nativeSetLong(j, exposureEntityColumnInfo.receivedTimestampMsColKey, nativeFindFirstInt, exposureEntity.realmGet$receivedTimestampMs(), false);
        return nativeFindFirstInt;
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (ExposureEntityColumnInfo) realmObjectContext.columnInfo;
            ProxyState<ExposureEntity> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.realm = realmObjectContext.realm;
            proxyState2.row = realmObjectContext.row;
            proxyState2.acceptDefaultValue = realmObjectContext.acceptDefaultValue;
            proxyState2.excludeFields = realmObjectContext.excludeFields;
        }
    }

    @Override // org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity, io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface
    public long realmGet$dateMillisSinceEpoch() {
        this.proxyState.realm.checkIfValid();
        return this.proxyState.row.getLong(this.columnInfo.dateMillisSinceEpochColKey);
    }

    @Override // org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity, io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface
    public long realmGet$id() {
        this.proxyState.realm.checkIfValid();
        return this.proxyState.row.getLong(this.columnInfo.idColKey);
    }

    @Override // io.realm.internal.RealmObjectProxy
    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    @Override // org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity, io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface
    public long realmGet$receivedTimestampMs() {
        this.proxyState.realm.checkIfValid();
        return this.proxyState.row.getLong(this.columnInfo.receivedTimestampMsColKey);
    }

    @Override // org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity, io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface
    public void realmSet$dateMillisSinceEpoch(long j) {
        ProxyState<ExposureEntity> proxyState2 = this.proxyState;
        if (!proxyState2.underConstruction) {
            proxyState2.realm.checkIfValid();
            this.proxyState.row.setLong(this.columnInfo.dateMillisSinceEpochColKey, j);
        } else if (proxyState2.acceptDefaultValue) {
            Row row = proxyState2.row;
            row.getTable().setLong(this.columnInfo.dateMillisSinceEpochColKey, row.getObjectKey(), j, true);
        }
    }

    @Override // org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity, io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface
    public void realmSet$id(long j) {
        ProxyState<ExposureEntity> proxyState2 = this.proxyState;
        if (!proxyState2.underConstruction) {
            proxyState2.realm.checkIfValid();
            throw new RealmException("Primary key field 'id' cannot be changed after object was created.");
        }
    }

    @Override // org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity, io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface
    public void realmSet$receivedTimestampMs(long j) {
        ProxyState<ExposureEntity> proxyState2 = this.proxyState;
        if (!proxyState2.underConstruction) {
            proxyState2.realm.checkIfValid();
            this.proxyState.row.setLong(this.columnInfo.receivedTimestampMsColKey, j);
        } else if (proxyState2.acceptDefaultValue) {
            Row row = proxyState2.row;
            row.getTable().setLong(this.columnInfo.receivedTimestampMsColKey, row.getObjectKey(), j, true);
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb = new StringBuilder("ExposureEntity = proxy[");
        sb.append("{id:");
        sb.append(realmGet$id());
        sb.append("}");
        sb.append(",");
        sb.append("{dateMillisSinceEpoch:");
        sb.append(realmGet$dateMillisSinceEpoch());
        sb.append("}");
        sb.append(",");
        sb.append("{receivedTimestampMs:");
        sb.append(realmGet$receivedTimestampMs());
        return GeneratedOutlineSupport.outline12(sb, "}", "]");
    }
}
