package io.realm;

import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import io.realm.BaseRealm;
import io.realm.exceptions.RealmException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry;

public class org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy extends SymptomLogEntry implements RealmObjectProxy, org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface {
    public static final OsObjectSchemaInfo expectedObjectSchemaInfo;
    public SymptomLogEntryColumnInfo columnInfo;
    public ProxyState<SymptomLogEntry> proxyState;
    public RealmList<String> symptomsRealmList;

    public static final class SymptomLogEntryColumnInfo extends ColumnInfo {
        public long dateColKey;
        public long idColKey;
        public long symptomsColKey;

        public SymptomLogEntryColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(3, true);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("SymptomLogEntry");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.dateColKey = addColumnDetails(DatePickerDialogModule.ARG_DATE, DatePickerDialogModule.ARG_DATE, objectSchemaInfo);
            this.symptomsColKey = addColumnDetails("symptoms", "symptoms", objectSchemaInfo);
        }

        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            SymptomLogEntryColumnInfo symptomLogEntryColumnInfo = (SymptomLogEntryColumnInfo) columnInfo;
            SymptomLogEntryColumnInfo symptomLogEntryColumnInfo2 = (SymptomLogEntryColumnInfo) columnInfo2;
            symptomLogEntryColumnInfo2.idColKey = symptomLogEntryColumnInfo.idColKey;
            symptomLogEntryColumnInfo2.dateColKey = symptomLogEntryColumnInfo.dateColKey;
            symptomLogEntryColumnInfo2.symptomsColKey = symptomLogEntryColumnInfo.symptomsColKey;
        }
    }

    static {
        long[] jArr = {Property.nativeCreatePersistedProperty("id", Property.convertFromRealmFieldType(RealmFieldType.STRING, true), true, false), Property.nativeCreatePersistedProperty(DatePickerDialogModule.ARG_DATE, Property.convertFromRealmFieldType(RealmFieldType.INTEGER, true), false, false), Property.nativeCreatePersistedProperty("symptoms", Property.convertFromRealmFieldType(RealmFieldType.STRING_LIST, false), false, false)};
        OsObjectSchemaInfo osObjectSchemaInfo = new OsObjectSchemaInfo("SymptomLogEntry", null);
        OsObjectSchemaInfo.nativeAddProperties(osObjectSchemaInfo.nativePtr, jArr, new long[0]);
        expectedObjectSchemaInfo = osObjectSchemaInfo;
    }

    public org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: io.realm.internal.ColumnIndices */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x014c  */
    public static SymptomLogEntry copyOrUpdate(Realm realm, SymptomLogEntryColumnInfo symptomLogEntryColumnInfo, SymptomLogEntry symptomLogEntry, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        boolean z2;
        Class cls;
        ImportFlag importFlag = ImportFlag.CHECK_SAME_VALUES_BEFORE_SET;
        if ((symptomLogEntry instanceof RealmObjectProxy) && !RealmObject.isFrozen(symptomLogEntry)) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) symptomLogEntry;
            if (realmObjectProxy.realmGet$proxyState().realm != null) {
                BaseRealm baseRealm = realmObjectProxy.realmGet$proxyState().realm;
                if (baseRealm.threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                } else if (baseRealm.configuration.canonicalPath.equals(realm.configuration.canonicalPath)) {
                    return symptomLogEntry;
                }
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy2 = map.get(symptomLogEntry);
        if (realmObjectProxy2 != null) {
            return (SymptomLogEntry) realmObjectProxy2;
        }
        org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_symptomlogentryrealmproxy = null;
        if (z) {
            Table table = realm.schema.getTable(SymptomLogEntry.class);
            long j = symptomLogEntryColumnInfo.idColKey;
            String realmGet$id = symptomLogEntry.realmGet$id();
            if (table == null) {
                throw null;
            } else if (realmGet$id != null) {
                long nativeFindFirstString = Table.nativeFindFirstString(table.nativeTableRefPtr, j, realmGet$id);
                if (nativeFindFirstString == -1) {
                    z2 = false;
                    if (!z2) {
                        Table table2 = realm.schema.getTable(SymptomLogEntry.class);
                        long nativePtr = table2.sharedRealm.getNativePtr();
                        table2.getColumnNames();
                        long j2 = table2.nativeTableRefPtr;
                        long nativeCreateBuilder = OsObjectBuilder.nativeCreateBuilder();
                        boolean contains = set.contains(importFlag);
                        long j3 = symptomLogEntryColumnInfo.idColKey;
                        String realmGet$id2 = symptomLogEntry.realmGet$id();
                        if (realmGet$id2 == null) {
                            OsObjectBuilder.nativeAddNull(nativeCreateBuilder, j3);
                        } else {
                            OsObjectBuilder.nativeAddString(nativeCreateBuilder, j3, realmGet$id2);
                        }
                        long j4 = symptomLogEntryColumnInfo.dateColKey;
                        Long valueOf = Long.valueOf(symptomLogEntry.realmGet$date());
                        if (valueOf == null) {
                            OsObjectBuilder.nativeAddNull(nativeCreateBuilder, j4);
                        } else {
                            OsObjectBuilder.nativeAddInteger(nativeCreateBuilder, j4, valueOf.longValue());
                        }
                        long j5 = symptomLogEntryColumnInfo.symptomsColKey;
                        RealmList<String> realmGet$symptoms = symptomLogEntry.realmGet$symptoms();
                        OsObjectBuilder.ItemCallback<String> itemCallback = OsObjectBuilder.stringItemCallback;
                        if (realmGet$symptoms != null) {
                            long nativeStartList = OsObjectBuilder.nativeStartList((long) realmGet$symptoms.size());
                            for (int i = 0; i < realmGet$symptoms.size(); i++) {
                                String str = realmGet$symptoms.get(i);
                                if (str == null) {
                                    OsObjectBuilder.nativeAddNullListItem(nativeStartList);
                                } else {
                                    OsObjectBuilder.AnonymousClass2 r16 = (OsObjectBuilder.AnonymousClass2) itemCallback;
                                    OsObjectBuilder.nativeAddStringListItem(nativeStartList, str);
                                }
                            }
                            OsObjectBuilder.nativeStopList(nativeCreateBuilder, j5, nativeStartList);
                        } else {
                            OsObjectBuilder.nativeStopList(nativeCreateBuilder, j5, OsObjectBuilder.nativeStartList(0));
                        }
                        try {
                            OsObjectBuilder.nativeCreateOrUpdate(nativePtr, j2, nativeCreateBuilder, true, contains);
                            return org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_symptomlogentryrealmproxy;
                        } finally {
                            OsObjectBuilder.nativeDestroyBuilder(nativeCreateBuilder);
                        }
                    } else {
                        RealmObjectProxy realmObjectProxy3 = map.get(symptomLogEntry);
                        if (realmObjectProxy3 != null) {
                            return (SymptomLogEntry) realmObjectProxy3;
                        }
                        Table table3 = realm.schema.getTable(SymptomLogEntry.class);
                        OsSharedRealm osSharedRealm = table3.sharedRealm;
                        long nativePtr2 = osSharedRealm.getNativePtr();
                        table3.getColumnNames();
                        long j6 = table3.nativeTableRefPtr;
                        long nativeCreateBuilder2 = OsObjectBuilder.nativeCreateBuilder();
                        NativeContext nativeContext = osSharedRealm.context;
                        set.contains(importFlag);
                        long j7 = symptomLogEntryColumnInfo.idColKey;
                        String realmGet$id3 = symptomLogEntry.realmGet$id();
                        if (realmGet$id3 == null) {
                            OsObjectBuilder.nativeAddNull(nativeCreateBuilder2, j7);
                        } else {
                            OsObjectBuilder.nativeAddString(nativeCreateBuilder2, j7, realmGet$id3);
                        }
                        long j8 = symptomLogEntryColumnInfo.dateColKey;
                        Long valueOf2 = Long.valueOf(symptomLogEntry.realmGet$date());
                        if (valueOf2 == null) {
                            OsObjectBuilder.nativeAddNull(nativeCreateBuilder2, j8);
                        } else {
                            OsObjectBuilder.nativeAddInteger(nativeCreateBuilder2, j8, valueOf2.longValue());
                        }
                        long j9 = symptomLogEntryColumnInfo.symptomsColKey;
                        RealmList<String> realmGet$symptoms2 = symptomLogEntry.realmGet$symptoms();
                        OsObjectBuilder.ItemCallback<String> itemCallback2 = OsObjectBuilder.stringItemCallback;
                        if (realmGet$symptoms2 != null) {
                            long nativeStartList2 = OsObjectBuilder.nativeStartList((long) realmGet$symptoms2.size());
                            cls = SymptomLogEntry.class;
                            for (int i2 = 0; i2 < realmGet$symptoms2.size(); i2++) {
                                String str2 = realmGet$symptoms2.get(i2);
                                if (str2 == null) {
                                    OsObjectBuilder.nativeAddNullListItem(nativeStartList2);
                                } else {
                                    OsObjectBuilder.AnonymousClass2 r162 = (OsObjectBuilder.AnonymousClass2) itemCallback2;
                                    OsObjectBuilder.nativeAddStringListItem(nativeStartList2, str2);
                                }
                            }
                            OsObjectBuilder.nativeStopList(nativeCreateBuilder2, j9, nativeStartList2);
                        } else {
                            cls = SymptomLogEntry.class;
                            OsObjectBuilder.nativeStopList(nativeCreateBuilder2, j9, OsObjectBuilder.nativeStartList(0));
                        }
                        try {
                            UncheckedRow uncheckedRow = new UncheckedRow(nativeContext, table3, OsObjectBuilder.nativeCreateOrUpdate(nativePtr2, j6, nativeCreateBuilder2, false, false));
                            OsObjectBuilder.nativeDestroyBuilder(nativeCreateBuilder2);
                            BaseRealm.RealmObjectContext realmObjectContext2 = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                            RealmSchema realmSchema = realm.schema;
                            realmSchema.checkColumnKeys();
                            ColumnInfo columnInfo2 = realmSchema.columnIndices.getColumnInfo(cls);
                            List<String> emptyList = Collections.emptyList();
                            realmObjectContext2.realm = realm;
                            realmObjectContext2.row = uncheckedRow;
                            realmObjectContext2.columnInfo = columnInfo2;
                            realmObjectContext2.acceptDefaultValue = false;
                            realmObjectContext2.excludeFields = emptyList;
                            org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_symptomlogentryrealmproxy2 = new org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy();
                            realmObjectContext2.clear();
                            map.put(symptomLogEntry, org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_symptomlogentryrealmproxy2);
                            return org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_symptomlogentryrealmproxy2;
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
                        realmObjectContext.columnInfo = symptomLogEntryColumnInfo;
                        realmObjectContext.acceptDefaultValue = false;
                        realmObjectContext.excludeFields = emptyList2;
                        org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_symptomlogentryrealmproxy = new org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy();
                        map.put(symptomLogEntry, org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_symptomlogentryrealmproxy);
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

    public static SymptomLogEntryColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new SymptomLogEntryColumnInfo(osSchemaInfo);
    }

    public static SymptomLogEntry createDetachedCopy(SymptomLogEntry symptomLogEntry, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        SymptomLogEntry symptomLogEntry2;
        if (i > i2) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cacheData = map.get(symptomLogEntry);
        if (cacheData == null) {
            symptomLogEntry2 = new SymptomLogEntry();
            map.put(symptomLogEntry, new RealmObjectProxy.CacheData<>(i, symptomLogEntry2));
        } else if (i >= cacheData.minDepth) {
            return (SymptomLogEntry) cacheData.object;
        } else {
            cacheData.minDepth = i;
            symptomLogEntry2 = (SymptomLogEntry) cacheData.object;
        }
        symptomLogEntry2.realmSet$id(symptomLogEntry.realmGet$id());
        symptomLogEntry2.realmSet$date(symptomLogEntry.realmGet$date());
        symptomLogEntry2.realmSet$symptoms(new RealmList<>());
        symptomLogEntry2.realmGet$symptoms().addAll(symptomLogEntry.realmGet$symptoms());
        return symptomLogEntry2;
    }

    public static long insert(Realm realm, SymptomLogEntry symptomLogEntry, Map<RealmModel, Long> map) {
        if ((symptomLogEntry instanceof RealmObjectProxy) && !RealmObject.isFrozen(symptomLogEntry)) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) symptomLogEntry;
            if (realmObjectProxy.realmGet$proxyState().realm != null && realmObjectProxy.realmGet$proxyState().realm.configuration.canonicalPath.equals(realm.configuration.canonicalPath)) {
                return realmObjectProxy.realmGet$proxyState().row.getObjectKey();
            }
        }
        Table table = realm.schema.getTable(SymptomLogEntry.class);
        long j = table.nativeTableRefPtr;
        RealmSchema realmSchema = realm.schema;
        realmSchema.checkColumnKeys();
        SymptomLogEntryColumnInfo symptomLogEntryColumnInfo = (SymptomLogEntryColumnInfo) realmSchema.columnIndices.getColumnInfo(SymptomLogEntry.class);
        long j2 = symptomLogEntryColumnInfo.idColKey;
        String realmGet$id = symptomLogEntry.realmGet$id();
        if ((realmGet$id != null ? Table.nativeFindFirstString(j, j2, realmGet$id) : -1) == -1) {
            long createRowWithPrimaryKey = OsObject.createRowWithPrimaryKey(table, j2, realmGet$id);
            map.put(symptomLogEntry, Long.valueOf(createRowWithPrimaryKey));
            Table.nativeSetLong(j, symptomLogEntryColumnInfo.dateColKey, createRowWithPrimaryKey, symptomLogEntry.realmGet$date(), false);
            RealmList<String> realmGet$symptoms = symptomLogEntry.realmGet$symptoms();
            if (realmGet$symptoms != null) {
                OsList osList = new OsList(table.getUncheckedRow(createRowWithPrimaryKey), symptomLogEntryColumnInfo.symptomsColKey);
                Iterator<String> it = realmGet$symptoms.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next == null) {
                        OsList.nativeAddNull(osList.nativePtr);
                    } else {
                        OsList.nativeAddString(osList.nativePtr, next);
                    }
                }
            }
            return createRowWithPrimaryKey;
        }
        Table.throwDuplicatePrimaryKeyException(realmGet$id);
        throw null;
    }

    public static long insertOrUpdate(Realm realm, SymptomLogEntry symptomLogEntry, Map<RealmModel, Long> map) {
        if ((symptomLogEntry instanceof RealmObjectProxy) && !RealmObject.isFrozen(symptomLogEntry)) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) symptomLogEntry;
            if (realmObjectProxy.realmGet$proxyState().realm != null && realmObjectProxy.realmGet$proxyState().realm.configuration.canonicalPath.equals(realm.configuration.canonicalPath)) {
                return realmObjectProxy.realmGet$proxyState().row.getObjectKey();
            }
        }
        Table table = realm.schema.getTable(SymptomLogEntry.class);
        long j = table.nativeTableRefPtr;
        RealmSchema realmSchema = realm.schema;
        realmSchema.checkColumnKeys();
        SymptomLogEntryColumnInfo symptomLogEntryColumnInfo = (SymptomLogEntryColumnInfo) realmSchema.columnIndices.getColumnInfo(SymptomLogEntry.class);
        long j2 = symptomLogEntryColumnInfo.idColKey;
        String realmGet$id = symptomLogEntry.realmGet$id();
        long nativeFindFirstString = realmGet$id != null ? Table.nativeFindFirstString(j, j2, realmGet$id) : -1;
        if (nativeFindFirstString == -1) {
            nativeFindFirstString = OsObject.createRowWithPrimaryKey(table, j2, realmGet$id);
        }
        map.put(symptomLogEntry, Long.valueOf(nativeFindFirstString));
        Table.nativeSetLong(j, symptomLogEntryColumnInfo.dateColKey, nativeFindFirstString, symptomLogEntry.realmGet$date(), false);
        OsList osList = new OsList(table.getUncheckedRow(nativeFindFirstString), symptomLogEntryColumnInfo.symptomsColKey);
        OsList.nativeRemoveAll(osList.nativePtr);
        RealmList<String> realmGet$symptoms = symptomLogEntry.realmGet$symptoms();
        if (realmGet$symptoms != null) {
            Iterator<String> it = realmGet$symptoms.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    OsList.nativeAddNull(osList.nativePtr);
                } else {
                    OsList.nativeAddString(osList.nativePtr, next);
                }
            }
        }
        return nativeFindFirstString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy.class != obj.getClass()) {
            return false;
        }
        org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_symptomlogentryrealmproxy = (org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy) obj;
        BaseRealm baseRealm = this.proxyState.realm;
        BaseRealm baseRealm2 = org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_symptomlogentryrealmproxy.proxyState.realm;
        String str = baseRealm.configuration.canonicalPath;
        String str2 = baseRealm2.configuration.canonicalPath;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        if (baseRealm.isFrozen() != baseRealm2.isFrozen() || !baseRealm.sharedRealm.getVersionID().equals(baseRealm2.sharedRealm.getVersionID())) {
            return false;
        }
        String name = this.proxyState.row.getTable().getName();
        String name2 = org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_symptomlogentryrealmproxy.proxyState.row.getTable().getName();
        if (name == null ? name2 == null : name.equals(name2)) {
            return this.proxyState.row.getObjectKey() == org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_symptomlogentryrealmproxy.proxyState.row.getObjectKey();
        }
        return false;
    }

    public int hashCode() {
        ProxyState<SymptomLogEntry> proxyState2 = this.proxyState;
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
            this.columnInfo = (SymptomLogEntryColumnInfo) realmObjectContext.columnInfo;
            ProxyState<SymptomLogEntry> proxyState2 = new ProxyState<>(this);
            this.proxyState = proxyState2;
            proxyState2.realm = realmObjectContext.realm;
            proxyState2.row = realmObjectContext.row;
            proxyState2.acceptDefaultValue = realmObjectContext.acceptDefaultValue;
            proxyState2.excludeFields = realmObjectContext.excludeFields;
        }
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface, org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry
    public long realmGet$date() {
        this.proxyState.realm.checkIfValid();
        return this.proxyState.row.getLong(this.columnInfo.dateColKey);
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface, org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry
    public String realmGet$id() {
        this.proxyState.realm.checkIfValid();
        return this.proxyState.row.getString(this.columnInfo.idColKey);
    }

    @Override // io.realm.internal.RealmObjectProxy
    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface, org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry
    public RealmList<String> realmGet$symptoms() {
        this.proxyState.realm.checkIfValid();
        RealmList<String> realmList = this.symptomsRealmList;
        if (realmList != null) {
            return realmList;
        }
        RealmList<String> realmList2 = new RealmList<>(String.class, this.proxyState.row.getValueList(this.columnInfo.symptomsColKey, RealmFieldType.STRING_LIST), this.proxyState.realm);
        this.symptomsRealmList = realmList2;
        return realmList2;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface, org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry
    public void realmSet$date(long j) {
        ProxyState<SymptomLogEntry> proxyState2 = this.proxyState;
        if (!proxyState2.underConstruction) {
            proxyState2.realm.checkIfValid();
            this.proxyState.row.setLong(this.columnInfo.dateColKey, j);
        } else if (proxyState2.acceptDefaultValue) {
            Row row = proxyState2.row;
            row.getTable().setLong(this.columnInfo.dateColKey, row.getObjectKey(), j, true);
        }
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface, org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry
    public void realmSet$id(String str) {
        ProxyState<SymptomLogEntry> proxyState2 = this.proxyState;
        if (!proxyState2.underConstruction) {
            proxyState2.realm.checkIfValid();
            throw new RealmException("Primary key field 'id' cannot be changed after object was created.");
        }
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface, org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry
    public void realmSet$symptoms(RealmList<String> realmList) {
        ProxyState<SymptomLogEntry> proxyState2 = this.proxyState;
        if (!proxyState2.underConstruction || (proxyState2.acceptDefaultValue && !proxyState2.excludeFields.contains("symptoms"))) {
            this.proxyState.realm.checkIfValid();
            OsList valueList = this.proxyState.row.getValueList(this.columnInfo.symptomsColKey, RealmFieldType.STRING_LIST);
            OsList.nativeRemoveAll(valueList.nativePtr);
            Iterator<String> it = realmList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    OsList.nativeAddNull(valueList.nativePtr);
                } else {
                    OsList.nativeAddString(valueList.nativePtr, next);
                }
            }
        }
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        return "SymptomLogEntry = proxy[" + "{id:" + realmGet$id() + "}" + "," + "{date:" + realmGet$date() + "}" + "," + "{symptoms:" + "RealmList<String>[" + realmGet$symptoms().size() + "]" + "}" + "]";
    }
}
