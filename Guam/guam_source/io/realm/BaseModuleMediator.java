package io.realm;

import io.realm.BaseRealm;
import io.realm.annotations.RealmModule;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.sync.Subscription;
import io.realm.sync.permissions.ClassPermissions;
import io.realm.sync.permissions.Permission;
import io.realm.sync.permissions.PermissionUser;
import io.realm.sync.permissions.RealmPermissions;
import io.realm.sync.permissions.Role;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RealmModule
public class BaseModuleMediator extends RealmProxyMediator {
    public static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    static {
        HashSet hashSet = new HashSet(6);
        hashSet.add(PermissionUser.class);
        hashSet.add(RealmPermissions.class);
        hashSet.add(ClassPermissions.class);
        hashSet.add(Permission.class);
        hashSet.add(Role.class);
        hashSet.add(Subscription.class);
        MODEL_CLASSES = Collections.unmodifiableSet(hashSet);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        Class<?> superclass = e instanceof RealmObjectProxy ? e.getClass().getSuperclass() : e.getClass();
        if (superclass.equals(PermissionUser.class)) {
            RealmSchema realmSchema = realm.schema;
            realmSchema.checkColumnKeys();
            return (E) ((RealmModel) superclass.cast(io_realm_sync_permissions_PermissionUserRealmProxy.copyOrUpdate(realm, (io_realm_sync_permissions_PermissionUserRealmProxy$PermissionUserColumnInfo) realmSchema.columnIndices.getColumnInfo(PermissionUser.class), (PermissionUser) e, z, map, set)));
        } else if (superclass.equals(RealmPermissions.class)) {
            RealmSchema realmSchema2 = realm.schema;
            realmSchema2.checkColumnKeys();
            return (E) ((RealmModel) superclass.cast(io_realm_sync_permissions_RealmPermissionsRealmProxy.copyOrUpdate(realm, (io_realm_sync_permissions_RealmPermissionsRealmProxy$RealmPermissionsColumnInfo) realmSchema2.columnIndices.getColumnInfo(RealmPermissions.class), (RealmPermissions) e, z, map, set)));
        } else if (superclass.equals(ClassPermissions.class)) {
            RealmSchema realmSchema3 = realm.schema;
            realmSchema3.checkColumnKeys();
            return (E) ((RealmModel) superclass.cast(io_realm_sync_permissions_ClassPermissionsRealmProxy.copyOrUpdate(realm, (io_realm_sync_permissions_ClassPermissionsRealmProxy$ClassPermissionsColumnInfo) realmSchema3.columnIndices.getColumnInfo(ClassPermissions.class), (ClassPermissions) e, z, map, set)));
        } else if (superclass.equals(Permission.class)) {
            RealmSchema realmSchema4 = realm.schema;
            realmSchema4.checkColumnKeys();
            return (E) ((RealmModel) superclass.cast(io_realm_sync_permissions_PermissionRealmProxy.copyOrUpdate(realm, (io_realm_sync_permissions_PermissionRealmProxy$PermissionColumnInfo) realmSchema4.columnIndices.getColumnInfo(Permission.class), (Permission) e, z, map, set)));
        } else if (superclass.equals(Role.class)) {
            RealmSchema realmSchema5 = realm.schema;
            realmSchema5.checkColumnKeys();
            return (E) ((RealmModel) superclass.cast(io_realm_sync_permissions_RoleRealmProxy.copyOrUpdate(realm, (io_realm_sync_permissions_RoleRealmProxy$RoleColumnInfo) realmSchema5.columnIndices.getColumnInfo(Role.class), (Role) e, z, map, set)));
        } else if (superclass.equals(Subscription.class)) {
            RealmSchema realmSchema6 = realm.schema;
            realmSchema6.checkColumnKeys();
            return (E) ((RealmModel) superclass.cast(io_realm_sync_SubscriptionRealmProxy.copyOrUpdate(realm, (io_realm_sync_SubscriptionRealmProxy$SubscriptionColumnInfo) realmSchema6.columnIndices.getColumnInfo(Subscription.class), (Subscription) e, z, map, set)));
        } else {
            throw RealmProxyMediator.getMissingProxyClassException(superclass);
        }
    }

    @Override // io.realm.internal.RealmProxyMediator
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> cls, OsSchemaInfo osSchemaInfo) {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(PermissionUser.class)) {
            return io_realm_sync_permissions_PermissionUserRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(RealmPermissions.class)) {
            return io_realm_sync_permissions_RealmPermissionsRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(ClassPermissions.class)) {
            return io_realm_sync_permissions_ClassPermissionsRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(Permission.class)) {
            return io_realm_sync_permissions_PermissionRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(Role.class)) {
            return io_realm_sync_permissions_RoleRealmProxy.createColumnInfo(osSchemaInfo);
        }
        if (cls.equals(Subscription.class)) {
            return io_realm_sync_SubscriptionRealmProxy.createColumnInfo(osSchemaInfo);
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public <E extends RealmModel> E createDetachedCopy(E e, int i, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        Class<? super Object> superclass = e.getClass().getSuperclass();
        if (superclass.equals(PermissionUser.class)) {
            return (E) ((RealmModel) superclass.cast(io_realm_sync_permissions_PermissionUserRealmProxy.createDetachedCopy((PermissionUser) e, 0, i, map)));
        }
        if (superclass.equals(RealmPermissions.class)) {
            return (E) ((RealmModel) superclass.cast(io_realm_sync_permissions_RealmPermissionsRealmProxy.createDetachedCopy((RealmPermissions) e, 0, i, map)));
        }
        if (superclass.equals(ClassPermissions.class)) {
            return (E) ((RealmModel) superclass.cast(io_realm_sync_permissions_ClassPermissionsRealmProxy.createDetachedCopy((ClassPermissions) e, 0, i, map)));
        }
        if (superclass.equals(Permission.class)) {
            return (E) ((RealmModel) superclass.cast(io_realm_sync_permissions_PermissionRealmProxy.createDetachedCopy((Permission) e, 0, i, map)));
        }
        if (superclass.equals(Role.class)) {
            return (E) ((RealmModel) superclass.cast(io_realm_sync_permissions_RoleRealmProxy.createDetachedCopy((Role) e, 0, i, map)));
        }
        if (superclass.equals(Subscription.class)) {
            return (E) ((RealmModel) superclass.cast(io_realm_sync_SubscriptionRealmProxy.createDetachedCopy((Subscription) e, 0, i, map)));
        }
        throw RealmProxyMediator.getMissingProxyClassException(superclass);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        HashMap hashMap = new HashMap(6);
        hashMap.put(PermissionUser.class, io_realm_sync_permissions_PermissionUserRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(RealmPermissions.class, io_realm_sync_permissions_RealmPermissionsRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(ClassPermissions.class, io_realm_sync_permissions_ClassPermissionsRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(Permission.class, io_realm_sync_permissions_PermissionRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(Role.class, io_realm_sync_permissions_RoleRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(Subscription.class, io_realm_sync_SubscriptionRealmProxy.getExpectedObjectSchemaInfo());
        return hashMap;
    }

    @Override // io.realm.internal.RealmProxyMediator
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override // io.realm.internal.RealmProxyMediator
    public String getSimpleClassNameImpl(Class<? extends RealmModel> cls) {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(PermissionUser.class)) {
            return "__User";
        }
        if (cls.equals(RealmPermissions.class)) {
            return "__Realm";
        }
        if (cls.equals(ClassPermissions.class)) {
            return "__Class";
        }
        if (cls.equals(Permission.class)) {
            return "__Permission";
        }
        if (cls.equals(Role.class)) {
            return "__Role";
        }
        if (cls.equals(Subscription.class)) {
            return "__ResultSets";
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    @Override // io.realm.internal.RealmProxyMediator
    public void insert(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        Class<?> superclass = realmModel instanceof RealmObjectProxy ? realmModel.getClass().getSuperclass() : realmModel.getClass();
        if (superclass.equals(PermissionUser.class)) {
            io_realm_sync_permissions_PermissionUserRealmProxy.insert(realm, (PermissionUser) realmModel, map);
        } else if (superclass.equals(RealmPermissions.class)) {
            io_realm_sync_permissions_RealmPermissionsRealmProxy.insert(realm, (RealmPermissions) realmModel, map);
        } else if (superclass.equals(ClassPermissions.class)) {
            io_realm_sync_permissions_ClassPermissionsRealmProxy.insert(realm, (ClassPermissions) realmModel, map);
        } else if (superclass.equals(Permission.class)) {
            io_realm_sync_permissions_PermissionRealmProxy.insert(realm, (Permission) realmModel, map);
        } else if (superclass.equals(Role.class)) {
            io_realm_sync_permissions_RoleRealmProxy.insert(realm, (Role) realmModel, map);
        } else if (superclass.equals(Subscription.class)) {
            io_realm_sync_SubscriptionRealmProxy.insert(realm, (Subscription) realmModel, map);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException(superclass);
        }
    }

    @Override // io.realm.internal.RealmProxyMediator
    public void insertOrUpdate(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        Class<?> superclass = realmModel instanceof RealmObjectProxy ? realmModel.getClass().getSuperclass() : realmModel.getClass();
        if (superclass.equals(PermissionUser.class)) {
            io_realm_sync_permissions_PermissionUserRealmProxy.insertOrUpdate(realm, (PermissionUser) realmModel, map);
        } else if (superclass.equals(RealmPermissions.class)) {
            io_realm_sync_permissions_RealmPermissionsRealmProxy.insertOrUpdate(realm, (RealmPermissions) realmModel, map);
        } else if (superclass.equals(ClassPermissions.class)) {
            io_realm_sync_permissions_ClassPermissionsRealmProxy.insertOrUpdate(realm, (ClassPermissions) realmModel, map);
        } else if (superclass.equals(Permission.class)) {
            io_realm_sync_permissions_PermissionRealmProxy.insertOrUpdate(realm, (Permission) realmModel, map);
        } else if (superclass.equals(Role.class)) {
            io_realm_sync_permissions_RoleRealmProxy.insertOrUpdate(realm, (Role) realmModel, map);
        } else if (superclass.equals(Subscription.class)) {
            io_realm_sync_SubscriptionRealmProxy.insertOrUpdate(realm, (Subscription) realmModel, map);
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
            if (cls.equals(PermissionUser.class)) {
                return cls.cast(new io_realm_sync_permissions_PermissionUserRealmProxy());
            }
            if (cls.equals(RealmPermissions.class)) {
                E cast = cls.cast(new io_realm_sync_permissions_RealmPermissionsRealmProxy());
                realmObjectContext.clear();
                return cast;
            } else if (cls.equals(ClassPermissions.class)) {
                E cast2 = cls.cast(new io_realm_sync_permissions_ClassPermissionsRealmProxy());
                realmObjectContext.clear();
                return cast2;
            } else if (cls.equals(Permission.class)) {
                E cast3 = cls.cast(new io_realm_sync_permissions_PermissionRealmProxy());
                realmObjectContext.clear();
                return cast3;
            } else if (cls.equals(Role.class)) {
                E cast4 = cls.cast(new io_realm_sync_permissions_RoleRealmProxy());
                realmObjectContext.clear();
                return cast4;
            } else if (cls.equals(Subscription.class)) {
                E cast5 = cls.cast(new io_realm_sync_SubscriptionRealmProxy());
                realmObjectContext.clear();
                return cast5;
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
