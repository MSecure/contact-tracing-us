package io.realm.internal;

import io.realm.ImportFlag;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.exceptions.RealmException;
import io.realm.internal.RealmObjectProxy;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class RealmProxyMediator {
    public static void checkClass(Class<? extends RealmModel> cls) {
        if (cls == null) {
            throw new NullPointerException("A class extending RealmObject must be provided");
        }
    }

    public static RealmException getMissingProxyClassException(Class<? extends RealmModel> cls) {
        return new RealmException(String.format("'%s' is not part of the schema for this Realm.", cls.toString()));
    }

    public abstract <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set);

    public abstract ColumnInfo createColumnInfo(Class<? extends RealmModel> cls, OsSchemaInfo osSchemaInfo);

    public abstract <E extends RealmModel> E createDetachedCopy(E e, int i, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map);

    public boolean equals(Object obj) {
        if (!(obj instanceof RealmProxyMediator)) {
            return false;
        }
        return getModelClasses().equals(((RealmProxyMediator) obj).getModelClasses());
    }

    public abstract Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap();

    public abstract Set<Class<? extends RealmModel>> getModelClasses();

    public final String getSimpleClassName(Class<? extends RealmModel> cls) {
        return getSimpleClassNameImpl(Util.getOriginalModelClass(cls));
    }

    public abstract String getSimpleClassNameImpl(Class<? extends RealmModel> cls);

    public int hashCode() {
        return getModelClasses().hashCode();
    }

    public abstract void insert(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map);

    public abstract void insertOrUpdate(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map);

    public abstract <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list);

    public boolean transformerApplied() {
        return false;
    }
}
