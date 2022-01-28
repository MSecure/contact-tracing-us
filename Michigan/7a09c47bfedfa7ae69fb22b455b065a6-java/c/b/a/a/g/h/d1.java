package c.b.a.a.g.h;

import c.b.a.a.g.h.b1;

public final class d1 implements v4 {

    /* renamed from: a  reason: collision with root package name */
    public final b1 f3864a;

    public d1(b1 b1Var) {
        u1.d(b1Var, "output");
        this.f3864a = b1Var;
        b1Var.f3844a = this;
    }

    public final void a(int i, double d2) {
        b1 b1Var = this.f3864a;
        if (b1Var != null) {
            long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
            b1.b bVar = (b1.b) b1Var;
            bVar.k((i << 3) | 1);
            bVar.Q(doubleToRawLongBits);
            return;
        }
        throw null;
    }

    public final void b(int i, float f2) {
        b1 b1Var = this.f3864a;
        if (b1Var != null) {
            int floatToRawIntBits = Float.floatToRawIntBits(f2);
            b1.b bVar = (b1.b) b1Var;
            bVar.k((i << 3) | 5);
            bVar.l(floatToRawIntBits);
            return;
        }
        throw null;
    }

    public final void c(int i, long j) {
        b1.b bVar = (b1.b) this.f3864a;
        bVar.k((i << 3) | 0);
        bVar.O(j);
    }

    public final void d(int i, q0 q0Var) {
        b1.b bVar = (b1.b) this.f3864a;
        bVar.k((i << 3) | 2);
        bVar.Z(q0Var);
    }

    public final void e(int i, Object obj) {
        if (obj instanceof q0) {
            b1.b bVar = (b1.b) this.f3864a;
            bVar.X(1, 3);
            bVar.b0(2, i);
            bVar.Y(3, (q0) obj);
            bVar.X(1, 4);
            return;
        }
        b1.b bVar2 = (b1.b) this.f3864a;
        bVar2.X(1, 3);
        bVar2.b0(2, i);
        bVar2.X(3, 2);
        bVar2.a0((c3) obj);
        bVar2.X(1, 4);
    }

    public final void f(int i, Object obj, q3 q3Var) {
        c3 c3Var = (c3) obj;
        b1.b bVar = (b1.b) this.f3864a;
        bVar.k((i << 3) | 2);
        g0 g0Var = (g0) c3Var;
        t1 t1Var = (t1) g0Var;
        int i2 = t1Var.zzya;
        if (i2 == -1) {
            i2 = q3Var.e(g0Var);
            t1Var.zzya = i2;
        }
        bVar.k(i2);
        q3Var.i(c3Var, bVar.f3844a);
    }

    public final void g(int i, boolean z) {
        b1.b bVar = (b1.b) this.f3864a;
        bVar.k((i << 3) | 0);
        bVar.w(z ? (byte) 1 : 0);
    }

    public final void h(int i, long j) {
        b1 b1Var = this.f3864a;
        if (b1Var != null) {
            long c2 = b1.c(j);
            b1.b bVar = (b1.b) b1Var;
            bVar.k((i << 3) | 0);
            bVar.O(c2);
            return;
        }
        throw null;
    }

    public final void i(int i, Object obj, q3 q3Var) {
        b1 b1Var = this.f3864a;
        int i2 = i << 3;
        ((b1.b) b1Var).k(i2 | 3);
        q3Var.i((c3) obj, b1Var.f3844a);
        ((b1.b) b1Var).k(i2 | 4);
    }

    public final void j(int i, long j) {
        b1.b bVar = (b1.b) this.f3864a;
        bVar.k((i << 3) | 1);
        bVar.Q(j);
    }

    public final void k(int i, long j) {
        b1.b bVar = (b1.b) this.f3864a;
        bVar.k((i << 3) | 0);
        bVar.O(j);
    }

    public final void l(int i, long j) {
        b1.b bVar = (b1.b) this.f3864a;
        bVar.k((i << 3) | 1);
        bVar.Q(j);
    }

    public final void m(int i, int i2) {
        b1.b bVar = (b1.b) this.f3864a;
        bVar.k((i << 3) | 0);
        bVar.k(i2);
    }

    public final void n(int i, int i2) {
        b1 b1Var = this.f3864a;
        if (b1Var != null) {
            int s = b1.s(i2);
            b1.b bVar = (b1.b) b1Var;
            bVar.k((i << 3) | 0);
            bVar.k(s);
            return;
        }
        throw null;
    }

    public final void o(int i, int i2) {
        b1.b bVar = (b1.b) this.f3864a;
        bVar.k((i << 3) | 5);
        bVar.l(i2);
    }

    public final void p(int i, int i2) {
        b1.b bVar = (b1.b) this.f3864a;
        bVar.k((i << 3) | 5);
        bVar.l(i2);
    }
}
