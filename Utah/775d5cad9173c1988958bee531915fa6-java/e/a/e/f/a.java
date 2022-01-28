package e.a.e.f;

import android.content.Context;
import android.content.Intent;

public abstract class a<I, O> {

    /* renamed from: e.a.e.f.a$a  reason: collision with other inner class name */
    public static final class C0011a<T> {
        public final T a;

        public C0011a(T t) {
            this.a = t;
        }
    }

    public abstract Intent a(Context context, I i2);

    public C0011a<O> b(Context context, I i2) {
        return null;
    }

    public abstract O c(int i2, Intent intent);
}
