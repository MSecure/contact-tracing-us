package b.a.e.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

public abstract class a<I, O> {

    /* renamed from: b.a.e.f.a$a  reason: collision with other inner class name */
    public static final class C0007a<T> {
        @SuppressLint({"UnknownNullness"})

        /* renamed from: a  reason: collision with root package name */
        public final T f506a;

        public C0007a(@SuppressLint({"UnknownNullness"}) T t) {
            this.f506a = t;
        }
    }

    public abstract Intent a(Context context, @SuppressLint({"UnknownNullness"}) I i);

    public C0007a<O> b(Context context, @SuppressLint({"UnknownNullness"}) I i) {
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    public abstract O c(int i, Intent intent);
}
