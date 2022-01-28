package c.b.a.a.e;

import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.e.a;
import java.lang.reflect.Field;

public final class b<T> extends a.AbstractBinderC0068a {

    /* renamed from: a  reason: collision with root package name */
    public final T f3189a;

    public b(T t) {
        this.f3189a = t;
    }

    @RecentlyNonNull
    public static <T> T g0(@RecentlyNonNull a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f3189a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i == 1) {
            t.C(field);
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return (T) field.get(asBinder);
                } catch (NullPointerException e2) {
                    throw new IllegalArgumentException("Binder object is null.", e2);
                } catch (IllegalAccessException e3) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e3);
                }
            } else {
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
        } else {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
