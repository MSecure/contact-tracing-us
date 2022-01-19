package io.realm;

import io.realm.internal.OsList;
import java.util.Locale;

/* compiled from: RealmList */
public final class StringListOperator extends ManagedListOperator<String> {
    public StringListOperator(BaseRealm baseRealm, OsList osList, Class<String> cls) {
        super(baseRealm, osList, cls);
    }

    @Override // io.realm.ManagedListOperator
    public void appendValue(Object obj) {
        OsList.nativeAddString(this.osList.nativePtr, (String) obj);
    }

    @Override // io.realm.ManagedListOperator
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof String)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", "java.lang.String", obj.getClass().getName()));
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.realm.ManagedListOperator
    public String get(int i) {
        return (String) this.osList.getValue((long) i);
    }

    @Override // io.realm.ManagedListOperator
    public void insertValue(int i, Object obj) {
        OsList.nativeInsertString(this.osList.nativePtr, (long) i, (String) obj);
    }

    @Override // io.realm.ManagedListOperator
    public void setValue(int i, Object obj) {
        OsList.nativeSetString(this.osList.nativePtr, (long) i, (String) obj);
    }
}
