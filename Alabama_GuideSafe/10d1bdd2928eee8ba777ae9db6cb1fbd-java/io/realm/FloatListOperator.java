package io.realm;

import io.realm.internal.OsList;
import java.util.Locale;

/* compiled from: RealmList */
public final class FloatListOperator extends ManagedListOperator<Float> {
    public FloatListOperator(BaseRealm baseRealm, OsList osList, Class<Float> cls) {
        super(baseRealm, osList, cls);
    }

    @Override // io.realm.ManagedListOperator
    public void appendValue(Object obj) {
        OsList osList = this.osList;
        OsList.nativeAddFloat(osList.nativePtr, ((Number) obj).floatValue());
    }

    @Override // io.realm.ManagedListOperator
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof Number)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", "java.lang.Number", obj.getClass().getName()));
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.realm.ManagedListOperator
    public Float get(int i) {
        return (Float) this.osList.getValue((long) i);
    }

    @Override // io.realm.ManagedListOperator
    public void insertValue(int i, Object obj) {
        OsList osList = this.osList;
        OsList.nativeInsertFloat(osList.nativePtr, (long) i, ((Number) obj).floatValue());
    }

    @Override // io.realm.ManagedListOperator
    public void setValue(int i, Object obj) {
        OsList osList = this.osList;
        OsList.nativeSetFloat(osList.nativePtr, (long) i, ((Number) obj).floatValue());
    }
}
