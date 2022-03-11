package e.v;

import e.x.a.f.f;
/* loaded from: classes.dex */
public abstract class b<T> extends l {
    public b(g gVar) {
        super(gVar);
    }

    public abstract void d(f fVar, T t);

    public final void e(T t) {
        f a = a();
        try {
            d(a, t);
            a.c();
            if (a == this.c) {
                this.a.set(false);
            }
        } catch (Throwable th) {
            c(a);
            throw th;
        }
    }

    public final long f(T t) {
        f a = a();
        try {
            d(a, t);
            long c = a.c();
            if (a == this.c) {
                this.a.set(false);
            }
            return c;
        } catch (Throwable th) {
            c(a);
            throw th;
        }
    }
}
