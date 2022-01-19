package io.realm;

import io.realm.internal.OsList;
import java.util.Date;
import java.util.Locale;

/* compiled from: RealmList */
public final class DateListOperator extends ManagedListOperator<Date> {
    public DateListOperator(BaseRealm baseRealm, OsList osList, Class<Date> cls) {
        super(baseRealm, osList, cls);
    }

    @Override // io.realm.ManagedListOperator
    public void appendValue(Object obj) {
        OsList.nativeAddDate(this.osList.nativePtr, ((Date) obj).getTime());
    }

    @Override // io.realm.ManagedListOperator
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof Date)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", "java.util.Date", obj.getClass().getName()));
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.realm.ManagedListOperator
    public Date get(int i) {
        return (Date) this.osList.getValue((long) i);
    }

    @Override // io.realm.ManagedListOperator
    public void insertValue(int i, Object obj) {
        OsList.nativeInsertDate(this.osList.nativePtr, (long) i, ((Date) obj).getTime());
    }

    @Override // io.realm.ManagedListOperator
    public void setValue(int i, Object obj) {
        OsList.nativeSetDate(this.osList.nativePtr, (long) i, ((Date) obj).getTime());
    }
}
