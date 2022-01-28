package io.realm;

import io.realm.internal.OsList;

/* compiled from: RealmList */
public abstract class ManagedListOperator<T> {
    public final Class<T> clazz;
    public final OsList osList;
    public final BaseRealm realm;

    public ManagedListOperator(BaseRealm baseRealm, OsList osList2, Class<T> cls) {
        this.realm = baseRealm;
        this.clazz = cls;
        this.osList = osList2;
    }

    public abstract void appendValue(Object obj);

    public abstract void checkValidValue(Object obj);

    public abstract T get(int i);

    public void insertNull(int i) {
        OsList.nativeInsertNull(this.osList.nativePtr, (long) i);
    }

    public abstract void insertValue(int i, Object obj);

    public void setNull(int i) {
        OsList.nativeSetNull(this.osList.nativePtr, (long) i);
    }

    public abstract void setValue(int i, Object obj);
}
