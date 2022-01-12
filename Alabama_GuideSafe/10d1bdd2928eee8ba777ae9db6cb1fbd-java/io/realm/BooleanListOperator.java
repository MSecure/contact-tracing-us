package io.realm;

import io.realm.internal.OsList;
import java.util.Locale;

/* compiled from: RealmList */
public final class BooleanListOperator extends ManagedListOperator<Boolean> {
    public BooleanListOperator(BaseRealm baseRealm, OsList osList, Class<Boolean> cls) {
        super(baseRealm, osList, cls);
    }

    @Override // io.realm.ManagedListOperator
    public void appendValue(Object obj) {
        OsList osList = this.osList;
        OsList.nativeAddBoolean(osList.nativePtr, ((Boolean) obj).booleanValue());
    }

    @Override // io.realm.ManagedListOperator
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof Boolean)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", "java.lang.Boolean", obj.getClass().getName()));
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.realm.ManagedListOperator
    public Boolean get(int i) {
        return (Boolean) this.osList.getValue((long) i);
    }

    @Override // io.realm.ManagedListOperator
    public void insertValue(int i, Object obj) {
        OsList osList = this.osList;
        OsList.nativeInsertBoolean(osList.nativePtr, (long) i, ((Boolean) obj).booleanValue());
    }

    @Override // io.realm.ManagedListOperator
    public void setValue(int i, Object obj) {
        OsList osList = this.osList;
        OsList.nativeSetBoolean(osList.nativePtr, (long) i, ((Boolean) obj).booleanValue());
    }
}
