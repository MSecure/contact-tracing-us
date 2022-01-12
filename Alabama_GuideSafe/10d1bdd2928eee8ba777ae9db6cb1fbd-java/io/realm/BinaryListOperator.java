package io.realm;

import io.realm.internal.OsList;
import java.util.Locale;

/* compiled from: RealmList */
public final class BinaryListOperator extends ManagedListOperator<byte[]> {
    public BinaryListOperator(BaseRealm baseRealm, OsList osList, Class<byte[]> cls) {
        super(baseRealm, osList, cls);
    }

    @Override // io.realm.ManagedListOperator
    public void appendValue(Object obj) {
        OsList.nativeAddBinary(this.osList.nativePtr, (byte[]) obj);
    }

    @Override // io.realm.ManagedListOperator
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof byte[])) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", "byte[]", obj.getClass().getName()));
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.realm.ManagedListOperator
    public byte[] get(int i) {
        return (byte[]) this.osList.getValue((long) i);
    }

    @Override // io.realm.ManagedListOperator
    public void insertValue(int i, Object obj) {
        OsList.nativeInsertBinary(this.osList.nativePtr, (long) i, (byte[]) obj);
    }

    @Override // io.realm.ManagedListOperator
    public void setValue(int i, Object obj) {
        OsList.nativeSetBinary(this.osList.nativePtr, (long) i, (byte[]) obj);
    }
}
