package io.realm;

import io.realm.internal.InvalidRow;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;

public abstract class RealmObject implements RealmModel {
    public static final String MSG_DELETED_OBJECT = "the object is already deleted.";
    public static final String MSG_DYNAMIC_OBJECT = "the object is an instance of DynamicRealmObject. Use DynamicRealmObject.getDynamicRealm() instead.";
    public static final String MSG_NULL_OBJECT = "'model' is null.";

    public static <E extends RealmModel> boolean isFrozen(E e) {
        if (e instanceof RealmObjectProxy) {
            return ((RealmObjectProxy) e).realmGet$proxyState().realm.isFrozen();
        }
        return false;
    }

    public static <E extends RealmModel> boolean isValid(E e) {
        if (!(e instanceof RealmObjectProxy)) {
            return true;
        }
        Row row = ((RealmObjectProxy) e).realmGet$proxyState().row;
        if (row == null || !row.isValid()) {
            return false;
        }
        return true;
    }

    public final void deleteFromRealm() {
        if (this instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) this;
            if (realmObjectProxy.realmGet$proxyState().row == null) {
                throw new IllegalStateException("Object malformed: missing object in Realm. Make sure to instantiate RealmObjects with Realm.createObject()");
            } else if (realmObjectProxy.realmGet$proxyState().realm != null) {
                realmObjectProxy.realmGet$proxyState().realm.checkIfValid();
                Row row = realmObjectProxy.realmGet$proxyState().row;
                row.getTable().moveLastOver(row.getObjectKey());
                realmObjectProxy.realmGet$proxyState().row = InvalidRow.INSTANCE;
            } else {
                throw new IllegalStateException("Object malformed: missing Realm. Make sure to instantiate RealmObjects with Realm.createObject()");
            }
        } else {
            throw new IllegalArgumentException("Object not managed by Realm, so it cannot be removed.");
        }
    }
}
