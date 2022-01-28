package c.b.a.a.g.b;

public final class i0 implements b4 {

    /* renamed from: a  reason: collision with root package name */
    public final g0 f3309a;

    public i0(g0 g0Var) {
        b1.e(g0Var, "output");
        this.f3309a = g0Var;
        g0Var.f3271a = this;
    }

    public final void a(int i, double d2) {
        g0 g0Var = this.f3309a;
        if (g0Var != null) {
            g0Var.H(i, Double.doubleToRawLongBits(d2));
            return;
        }
        throw null;
    }

    public final void b(int i, float f2) {
        g0 g0Var = this.f3309a;
        if (g0Var != null) {
            g0Var.Q(i, Float.floatToRawIntBits(f2));
            return;
        }
        throw null;
    }

    public final void c(int i, Object obj) {
        if (obj instanceof y) {
            this.f3309a.t(i, (y) obj);
        } else {
            this.f3309a.u(i, (e2) obj);
        }
    }

    public final void d(int i, Object obj, u2 u2Var) {
        this.f3309a.j(i, (e2) obj, u2Var);
    }

    public final void e(int i, long j) {
        this.f3309a.g(i, g0.b0(j));
    }

    public final void f(int i, Object obj, u2 u2Var) {
        g0 g0Var = this.f3309a;
        g0Var.s(i, 3);
        u2Var.g((e2) obj, g0Var.f3271a);
        g0Var.s(i, 4);
    }

    public final void g(int i, int i2) {
        this.f3309a.L(i, g0.n0(i2));
    }
}
