package c.b.d;

public abstract class o2<T, B> {
    public abstract void a(B b2, int i, int i2);

    public abstract void b(B b2, int i, long j);

    public abstract void c(B b2, int i, T t);

    public abstract void d(B b2, int i, j jVar);

    public abstract void e(B b2, int i, long j);

    public abstract B f(Object obj);

    public abstract T g(Object obj);

    public abstract int h(T t);

    public abstract int i(T t);

    public abstract void j(Object obj);

    public abstract T k(T t, T t2);

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    public final boolean l(B b2, a2 a2Var) {
        int i = a2Var.i();
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            e(b2, i2, a2Var.B());
            return true;
        } else if (i3 == 1) {
            b(b2, i2, a2Var.l());
            return true;
        } else if (i3 == 2) {
            d(b2, i2, a2Var.c());
            return true;
        } else if (i3 == 3) {
            B m = m();
            int i4 = 4 | (i2 << 3);
            while (a2Var.I() != Integer.MAX_VALUE && l(m, a2Var)) {
                while (a2Var.I() != Integer.MAX_VALUE) {
                    while (a2Var.I() != Integer.MAX_VALUE) {
                    }
                }
            }
            if (i4 == a2Var.i()) {
                c(b2, i2, q(m));
                return true;
            }
            throw n0.a();
        } else if (i3 == 4) {
            return false;
        } else {
            if (i3 == 5) {
                a(b2, i2, a2Var.D());
                return true;
            }
            throw n0.d();
        }
    }

    public abstract B m();

    public abstract void n(Object obj, B b2);

    public abstract void o(Object obj, T t);

    public abstract boolean p(a2 a2Var);

    public abstract T q(B b2);

    public abstract void r(T t, x2 x2Var);

    public abstract void s(T t, x2 x2Var);
}
