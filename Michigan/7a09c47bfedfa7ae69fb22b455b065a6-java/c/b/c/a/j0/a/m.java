package c.b.c.a.j0.a;

import c.b.c.a.j0.a.l;

public final class m implements u1 {

    /* renamed from: a  reason: collision with root package name */
    public final l f4982a;

    public m(l lVar) {
        a0.b(lVar, "output");
        this.f4982a = lVar;
        lVar.f4976a = this;
    }

    public void a(int i, boolean z) {
        l.b bVar = (l.b) this.f4982a;
        bVar.V((i << 3) | 0);
        bVar.P(z ? (byte) 1 : 0);
    }

    public void b(int i, i iVar) {
        l.b bVar = (l.b) this.f4982a;
        bVar.V((i << 3) | 2);
        bVar.Z(iVar);
    }

    public void c(int i, double d2) {
        l lVar = this.f4982a;
        if (lVar != null) {
            long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
            l.b bVar = (l.b) lVar;
            bVar.V((i << 3) | 1);
            bVar.S(doubleToRawLongBits);
            return;
        }
        throw null;
    }

    public void d(int i, int i2) {
        l.b bVar = (l.b) this.f4982a;
        bVar.V((i << 3) | 5);
        bVar.R(i2);
    }

    public void e(int i, long j) {
        l.b bVar = (l.b) this.f4982a;
        bVar.V((i << 3) | 1);
        bVar.S(j);
    }

    public void f(int i, float f2) {
        l lVar = this.f4982a;
        if (lVar != null) {
            int floatToRawIntBits = Float.floatToRawIntBits(f2);
            l.b bVar = (l.b) lVar;
            bVar.V((i << 3) | 5);
            bVar.R(floatToRawIntBits);
            return;
        }
        throw null;
    }

    public void g(int i, Object obj, f1 f1Var) {
        l lVar = this.f4982a;
        r0 r0Var = (r0) obj;
        if (lVar != null) {
            l.b bVar = (l.b) lVar;
            int i2 = i << 3;
            bVar.V(i2 | 3);
            f1Var.i(r0Var, lVar.f4976a);
            bVar.V(i2 | 4);
            return;
        }
        throw null;
    }

    public void h(int i, long j) {
        l lVar = this.f4982a;
        if (lVar != null) {
            l.b bVar = (l.b) lVar;
            bVar.V((i << 3) | 0);
            bVar.W(j);
            return;
        }
        throw null;
    }

    public void i(int i, Object obj, f1 f1Var) {
        r0 r0Var = (r0) obj;
        l.b bVar = (l.b) this.f4982a;
        bVar.V((i << 3) | 2);
        bVar.V(((a) r0Var).b(f1Var));
        f1Var.i(r0Var, bVar.f4976a);
    }

    public final void j(int i, Object obj) {
        if (obj instanceof i) {
            l.b bVar = (l.b) this.f4982a;
            bVar.b0(1, 3);
            bVar.c0(2, i);
            bVar.Y(3, (i) obj);
            bVar.b0(1, 4);
            return;
        }
        r0 r0Var = (r0) obj;
        l.b bVar2 = (l.b) this.f4982a;
        bVar2.b0(1, 3);
        bVar2.c0(2, i);
        bVar2.V(26);
        bVar2.V(r0Var.getSerializedSize());
        r0Var.a(bVar2);
        bVar2.b0(1, 4);
    }

    public void k(int i, int i2) {
        l lVar = this.f4982a;
        if (lVar != null) {
            l.b bVar = (l.b) lVar;
            bVar.V((i << 3) | 5);
            bVar.R(i2);
            return;
        }
        throw null;
    }

    public void l(int i, long j) {
        l lVar = this.f4982a;
        if (lVar != null) {
            l.b bVar = (l.b) lVar;
            bVar.V((i << 3) | 1);
            bVar.S(j);
            return;
        }
        throw null;
    }

    public void m(int i, int i2) {
        l lVar = this.f4982a;
        if (lVar != null) {
            int L = l.L(i2);
            l.b bVar = (l.b) lVar;
            bVar.V((i << 3) | 0);
            bVar.V(L);
            return;
        }
        throw null;
    }

    public void n(int i, long j) {
        l lVar = this.f4982a;
        if (lVar != null) {
            long M = l.M(j);
            l.b bVar = (l.b) lVar;
            bVar.V((i << 3) | 0);
            bVar.W(M);
            return;
        }
        throw null;
    }

    public void o(int i, int i2) {
        l.b bVar = (l.b) this.f4982a;
        bVar.V((i << 3) | 0);
        bVar.V(i2);
    }

    public void p(int i, long j) {
        l.b bVar = (l.b) this.f4982a;
        bVar.V((i << 3) | 0);
        bVar.W(j);
    }
}
