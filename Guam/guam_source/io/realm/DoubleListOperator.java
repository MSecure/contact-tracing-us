package io.realm;

import io.realm.internal.OsList;
import java.util.Locale;

/* compiled from: RealmList */
public final class DoubleListOperator extends ManagedListOperator<Double> {
    public DoubleListOperator(BaseRealm baseRealm, OsList osList, Class<Double> cls) {
        super(baseRealm, osList, cls);
    }

    @Override // io.realm.ManagedListOperator
    public void appendValue(Object obj) {
        OsList osList = this.osList;
        OsList.nativeAddDouble(osList.nativePtr, ((Number) obj).doubleValue());
    }

    @Override // io.realm.ManagedListOperator
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof Number)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", "java.lang.Number", obj.getClass().getName()));
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.realm.ManagedListOperator
    public Double get(int i) {
        return (Double) this.osList.getValue((long) i);
    }

    @Override // io.realm.ManagedListOperator
    public void insertValue(int i, Object obj) {
        OsList osList = this.osList;
        double doubleValue = ((Number) obj).doubleValue();
        OsList.nativeInsertDouble(osList.nativePtr, (long) i, doubleValue);
    }

    @Override // io.realm.ManagedListOperator
    public void setValue(int i, Object obj) {
        OsList osList = this.osList;
        double doubleValue = ((Number) obj).doubleValue();
        OsList.nativeSetDouble(osList.nativePtr, (long) i, doubleValue);
    }
}
