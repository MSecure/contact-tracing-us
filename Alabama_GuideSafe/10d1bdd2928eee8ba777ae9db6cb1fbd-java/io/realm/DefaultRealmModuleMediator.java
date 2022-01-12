package io.realm;

import io.realm.BaseRealm;
import io.realm.annotations.RealmModule;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy;
import io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy;
import io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.KeyValues;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry;

@RealmModule
public class DefaultRealmModuleMediator extends RealmProxyMediator {
    public static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    static {
        HashSet hashSet = new HashSet(3);
        hashSet.add(SymptomLogEntry.class);
        hashSet.add(KeyValues.class);
        hashSet.add(ExposureEntity.class);
        MODEL_CLASSES = Collections.unmodifiableSet(hashSet);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        Class<?> superclass = e instanceof RealmObjectProxy ? e.getClass().getSuperclass() : e.getClass();
        if (superclass.equals(SymptomLogEntry.class)) {
            RealmSchema realmSchema = realm.schema;
            realmSchema.checkColumnKeys();
            return (E) ((RealmModel) superclass.cast(org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy.copyOrUpdate(realm, (org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy.SymptomLogEntryColumnInfo) realmSchema.columnIndices.getColumnInfo(SymptomLogEntry.class), (SymptomLogEntry) e, z, map, set)));
        } else if (superclass.equals(KeyValues.class)) {
            RealmSchema realmSchema2 = realm.schema;
            realmSchema2.checkColumnKeys();
            return (E) ((RealmModel) superclass.cast(org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy.copyOrUpdate(realm, (org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy.KeyValuesColumnInfo) realmSchema2.columnIndices.getColumnInfo(KeyValues.class), (KeyValues) e, z, map, set)));
        } else if (superclass.equals(ExposureEntity.class)) {
            RealmSchema realmSchema3 = realm.schema;
            realmSchema3.checkColumnKeys();
            return (E) ((RealmModel) superclass.cast(org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy.copyOrUpdate(realm, (org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy.ExposureEntityColumnInfo) realmSchema3.columnIndices.getColumnInfo(ExposureEntity.class), (ExposureEntity) e, z, map, set)));
        } else {
            throw RealmProxyMediator.getMissingProxyClassException(superclass);
        }
    }

    @Override // io.realm.internal.RealmProxyMediator
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> cls, OsSchemaInfo osSchemaInfo) {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(SymptomLogEntry.class)) {
            return org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(KeyValues.class)) {
            return org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(ExposureEntity.class)) {
            return org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy.createColumnInfo(osSchemaInfo);
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public <E extends RealmModel> E createDetachedCopy(E e, int i, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        Class<? super Object> superclass = e.getClass().getSuperclass();
        if (superclass.equals(SymptomLogEntry.class)) {
            return (E) ((RealmModel) superclass.cast(org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy.createDetachedCopy((SymptomLogEntry) e, 0, i, map)));
        }
        if (superclass.equals(KeyValues.class)) {
            return (E) ((RealmModel) superclass.cast(org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy.createDetachedCopy((KeyValues) e, 0, i, map)));
        }
        if (superclass.equals(ExposureEntity.class)) {
            return (E) ((RealmModel) superclass.cast(org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy.createDetachedCopy((ExposureEntity) e, 0, i, map)));
        }
        throw RealmProxyMediator.getMissingProxyClassException(superclass);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        HashMap hashMap = new HashMap(3);
        hashMap.put(SymptomLogEntry.class, org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy.expectedObjectSchemaInfo);
        hashMap.put(KeyValues.class, org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy.expectedObjectSchemaInfo);
        hashMap.put(ExposureEntity.class, org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy.expectedObjectSchemaInfo);
        return hashMap;
    }

    @Override // io.realm.internal.RealmProxyMediator
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override // io.realm.internal.RealmProxyMediator
    public String getSimpleClassNameImpl(Class<? extends RealmModel> cls) {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(SymptomLogEntry.class)) {
            return "SymptomLogEntry";
        }
        if (cls.equals(KeyValues.class)) {
            return "KeyValues";
        }
        if (cls.equals(ExposureEntity.class)) {
            return "ExposureEntity";
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public void insert(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        Class<?> superclass = realmModel instanceof RealmObjectProxy ? realmModel.getClass().getSuperclass() : realmModel.getClass();
        if (superclass.equals(SymptomLogEntry.class)) {
            org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy.insert(realm, (SymptomLogEntry) realmModel, map);
        } else if (superclass.equals(KeyValues.class)) {
            org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy.insert(realm, (KeyValues) realmModel, map);
        } else if (superclass.equals(ExposureEntity.class)) {
            org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy.insert(realm, (ExposureEntity) realmModel, map);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException(superclass);
        }
    }

    @Override // io.realm.internal.RealmProxyMediator
    public void insertOrUpdate(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        Class<?> superclass = realmModel instanceof RealmObjectProxy ? realmModel.getClass().getSuperclass() : realmModel.getClass();
        if (superclass.equals(SymptomLogEntry.class)) {
            org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy.insertOrUpdate(realm, (SymptomLogEntry) realmModel, map);
        } else if (superclass.equals(KeyValues.class)) {
            org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy.insertOrUpdate(realm, (KeyValues) realmModel, map);
        } else if (superclass.equals(ExposureEntity.class)) {
            org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy.insertOrUpdate(realm, (ExposureEntity) realmModel, map);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException(superclass);
        }
    }

    @Override // io.realm.internal.RealmProxyMediator
    public <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list) {
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        try {
            realmObjectContext.set((BaseRealm) obj, row, columnInfo, z, list);
            RealmProxyMediator.checkClass(cls);
            if (cls.equals(SymptomLogEntry.class)) {
                return cls.cast(new org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxy());
            }
            if (cls.equals(KeyValues.class)) {
                E cast = cls.cast(new org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxy());
                realmObjectContext.clear();
                return cast;
            } else if (cls.equals(ExposureEntity.class)) {
                E cast2 = cls.cast(new org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxy());
                realmObjectContext.clear();
                return cast2;
            } else {
                throw RealmProxyMediator.getMissingProxyClassException(cls);
            }
        } finally {
            realmObjectContext.clear();
        }
    }

    @Override // io.realm.internal.RealmProxyMediator
    public boolean transformerApplied() {
        return true;
    }
}
