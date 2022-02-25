package f.b.f;

public abstract class r1<T, B> {
    public abstract void a(B b, int i2, int i3);

    public abstract void b(B b, int i2, long j2);

    public abstract void c(B b, int i2, T t);

    public abstract void d(B b, int i2, j jVar);

    public abstract void e(B b, int i2, long j2);

    public abstract B f(Object obj);

    public abstract T g(Object obj);

    public abstract int h(T t);

    public abstract int i(T t);

    public abstract void j(Object obj);

    public abstract T k(T t, T t2);

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    public final boolean l(B b, h1 h1Var) {
        int k2 = h1Var.k();
        int i2 = k2 >>> 3;
        int i3 = k2 & 7;
        if (i3 == 0) {
            e(b, i2, h1Var.F());
            return true;
        } else if (i3 == 1) {
            b(b, i2, h1Var.n());
            return true;
        } else if (i3 == 2) {
            d(b, i2, h1Var.e());
            return true;
        } else if (i3 == 3) {
            B m = m();
            int i4 = 4 | (i2 << 3);
            while (h1Var.O() != Integer.MAX_VALUE && l(m, h1Var)) {
                while (h1Var.O() != Integer.MAX_VALUE) {
                    while (h1Var.O() != Integer.MAX_VALUE) {
                    }
                }
            }
            if (i4 == h1Var.k()) {
                c(b, i2, q(m));
                return true;
            }
            throw d0.a();
        } else if (i3 == 4) {
            return false;
        } else {
            if (i3 == 5) {
                a(b, i2, h1Var.H());
                return true;
            }
            throw d0.d();
        }
    }

    public abstract B m();

    public abstract void n(Object obj, B b);

    public abstract void o(Object obj, T t);

    public abstract boolean p(h1 h1Var);

    public abstract T q(B b);

    public abstract void r(T t, a2 a2Var);

    public abstract void s(T t, a2 a2Var);
}
