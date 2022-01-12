package io.realm;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.internal.OsList;
import java.util.Locale;

/* compiled from: RealmList */
public final class LongListOperator<T> extends ManagedListOperator<T> {
    public LongListOperator(BaseRealm baseRealm, OsList osList, Class<T> cls) {
        super(baseRealm, osList, cls);
    }

    @Override // io.realm.ManagedListOperator
    public void appendValue(Object obj) {
        OsList osList = this.osList;
        OsList.nativeAddLong(osList.nativePtr, ((Number) obj).longValue());
    }

    @Override // io.realm.ManagedListOperator
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof Number)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", "java.lang.Long, java.lang.Integer, java.lang.Short, java.lang.Byte", obj.getClass().getName()));
        }
    }

    @Override // io.realm.ManagedListOperator
    public T get(int i) {
        T t = (T) ((Long) this.osList.getValue((long) i));
        if (t == null) {
            return null;
        }
        Class<T> cls = this.clazz;
        if (cls == Long.class) {
            return t;
        }
        if (cls == Integer.class) {
            return cls.cast(Integer.valueOf(t.intValue()));
        }
        if (cls == Short.class) {
            return cls.cast(Short.valueOf(t.shortValue()));
        }
        if (cls == Byte.class) {
            return cls.cast(Byte.valueOf(t.byteValue()));
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Unexpected element type: ");
        outline17.append(this.clazz.getName());
        throw new IllegalStateException(outline17.toString());
    }

    @Override // io.realm.ManagedListOperator
    public void insertValue(int i, Object obj) {
        OsList osList = this.osList;
        long longValue = ((Number) obj).longValue();
        OsList.nativeInsertLong(osList.nativePtr, (long) i, longValue);
    }

    @Override // io.realm.ManagedListOperator
    public void setValue(int i, Object obj) {
        OsList osList = this.osList;
        long longValue = ((Number) obj).longValue();
        OsList.nativeSetLong(osList.nativePtr, (long) i, longValue);
    }
}
