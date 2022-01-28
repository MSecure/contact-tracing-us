package io.realm;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.internal.OsList;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsObjectStore;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Util;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: RealmList */
public final class RealmModelListOperator<T> extends ManagedListOperator<T> {
    public final String className;

    public RealmModelListOperator(BaseRealm baseRealm, OsList osList, Class<T> cls, String str) {
        super(baseRealm, osList, cls);
        this.className = str;
    }

    @Override // io.realm.ManagedListOperator
    public void appendValue(Object obj) {
        OsList osList = this.osList;
        OsList.nativeAddRow(osList.nativePtr, ((RealmObjectProxy) copyToRealmIfNeeded((RealmModel) obj)).realmGet$proxyState().row.getObjectKey());
    }

    @Override // io.realm.ManagedListOperator
    public void checkValidValue(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("RealmList does not accept null values.");
        } else if (!(obj instanceof RealmModel)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", "java.lang.String", obj.getClass().getName()));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: io.realm.internal.RealmProxyMediator */
    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: io.realm.internal.RealmProxyMediator */
    /* JADX WARN: Multi-variable type inference failed */
    public final <E extends RealmModel> E copyToRealmIfNeeded(E e) {
        Property property;
        if (e instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) e;
            if (realmObjectProxy instanceof DynamicRealmObject) {
                String str = this.className;
                BaseRealm baseRealm = realmObjectProxy.realmGet$proxyState().realm;
                BaseRealm baseRealm2 = this.realm;
                if (baseRealm == baseRealm2) {
                    DynamicRealmObject dynamicRealmObject = (DynamicRealmObject) e;
                    dynamicRealmObject.proxyState.realm.checkIfValid();
                    String className2 = dynamicRealmObject.proxyState.row.getTable().getClassName();
                    if (str.equals(className2)) {
                        return e;
                    }
                    throw new IllegalArgumentException(String.format(Locale.US, "The object has a different type from list's. Type of the list is '%s', type of object is '%s'.", str, className2));
                } else if (baseRealm2.threadId == realmObjectProxy.realmGet$proxyState().realm.threadId) {
                    throw new IllegalArgumentException("Cannot copy DynamicRealmObject between Realm instances.");
                } else {
                    throw new IllegalStateException("Cannot copy an object to a Realm instance created in another thread.");
                }
            } else if (realmObjectProxy.realmGet$proxyState().row != null && realmObjectProxy.realmGet$proxyState().realm.configuration.canonicalPath.equals(this.realm.configuration.canonicalPath)) {
                if (this.realm == realmObjectProxy.realmGet$proxyState().realm) {
                    return e;
                }
                throw new IllegalArgumentException("Cannot copy an object from another Realm instance.");
            }
        }
        Realm realm = (Realm) this.realm;
        if (OsObjectStore.getPrimaryKeyForObject(realm.sharedRealm, realm.configuration.schemaMediator.getSimpleClassName(e.getClass())) == null) {
            return (E) realm.copyOrUpdate(e, false, new HashMap(), Util.toSet(new ImportFlag[0]));
        }
        ImportFlag[] importFlagArr = new ImportFlag[0];
        Class<?> cls = e.getClass();
        OsObjectSchemaInfo objectSchemaInfo = realm.sharedRealm.getSchemaInfo().getObjectSchemaInfo(realm.configuration.schemaMediator.getSimpleClassName(cls));
        if (OsObjectSchemaInfo.nativeGetPrimaryKeyProperty(objectSchemaInfo.nativePtr) == 0) {
            property = null;
        } else {
            property = new Property(OsObjectSchemaInfo.nativeGetPrimaryKeyProperty(objectSchemaInfo.nativePtr));
        }
        if (property != null) {
            return (E) realm.copyOrUpdate(e, true, new HashMap(), Util.toSet(importFlagArr));
        }
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("A RealmObject with no @PrimaryKey cannot be updated: ");
        outline15.append(cls.toString());
        throw new IllegalArgumentException(outline15.toString());
    }

    @Override // io.realm.ManagedListOperator
    public T get(int i) {
        BaseRealm baseRealm = this.realm;
        Class<T> cls = this.clazz;
        String str = this.className;
        OsList osList = this.osList;
        return (T) baseRealm.get(cls, str, osList.targetTable.getUncheckedRowByPointer(OsList.nativeGetRow(osList.nativePtr, (long) i)));
    }

    @Override // io.realm.ManagedListOperator
    public void insertNull(int i) {
        throw new RuntimeException("Should not reach here.");
    }

    @Override // io.realm.ManagedListOperator
    public void insertValue(int i, Object obj) {
        long size = this.osList.size();
        int i2 = size < 2147483647L ? (int) size : Integer.MAX_VALUE;
        if (i < 0 || i2 < i) {
            StringBuilder outline16 = GeneratedOutlineSupport.outline16("Invalid index ", i, ", size is ");
            outline16.append(this.osList.size());
            throw new IndexOutOfBoundsException(outline16.toString());
        }
        OsList.nativeInsertRow(this.osList.nativePtr, (long) i, ((RealmObjectProxy) copyToRealmIfNeeded((RealmModel) obj)).realmGet$proxyState().row.getObjectKey());
    }

    @Override // io.realm.ManagedListOperator
    public void setNull(int i) {
        throw new RuntimeException("Should not reach here.");
    }

    @Override // io.realm.ManagedListOperator
    public void setValue(int i, Object obj) {
        OsList osList = this.osList;
        OsList.nativeSetRow(osList.nativePtr, (long) i, ((RealmObjectProxy) copyToRealmIfNeeded((RealmModel) obj)).realmGet$proxyState().row.getObjectKey());
    }
}
