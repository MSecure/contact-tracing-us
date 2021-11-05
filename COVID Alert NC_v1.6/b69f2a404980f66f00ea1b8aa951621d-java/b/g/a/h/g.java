package b.g.a.h;

import b.g.a.b;
import b.g.a.e;
import b.g.a.h.c;
import b.g.a.h.d;

public class g extends d {
    public float j0 = -1.0f;
    public int k0 = -1;
    public int l0 = -1;
    public c m0 = this.t;
    public int n0;
    public boolean o0;

    public g() {
        this.n0 = 0;
        this.o0 = false;
        this.B.clear();
        this.B.add(this.m0);
        int length = this.A.length;
        for (int i = 0; i < length; i++) {
            this.A[i] = this.m0;
        }
    }

    @Override // b.g.a.h.d
    public void E(e eVar) {
        if (this.D != null) {
            int o = eVar.o(this.m0);
            if (this.n0 == 1) {
                this.I = o;
                this.J = 0;
                w(this.D.h());
                C(0);
                return;
            }
            this.I = 0;
            this.J = o;
            C(this.D.n());
            w(0);
        }
    }

    public void F(int i) {
        if (this.n0 != i) {
            this.n0 = i;
            this.B.clear();
            this.m0 = this.n0 == 1 ? this.s : this.t;
            this.B.add(this.m0);
            int length = this.A.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.A[i2] = this.m0;
            }
        }
    }

    @Override // b.g.a.h.d
    public void a(e eVar) {
        d.a aVar = d.a.WRAP_CONTENT;
        e eVar2 = (e) this.D;
        if (eVar2 != null) {
            c f = eVar2.f(c.b.LEFT);
            c f2 = eVar2.f(c.b.RIGHT);
            d dVar = this.D;
            boolean z = true;
            boolean z2 = dVar != null && dVar.C[0] == aVar;
            if (this.n0 == 0) {
                f = eVar2.f(c.b.TOP);
                f2 = eVar2.f(c.b.BOTTOM);
                d dVar2 = this.D;
                if (dVar2 == null || dVar2.C[1] != aVar) {
                    z = false;
                }
                z2 = z;
            }
            if (this.k0 != -1) {
                b.g.a.g l = eVar.l(this.m0);
                eVar.d(l, eVar.l(f), this.k0, 6);
                if (z2) {
                    eVar.f(eVar.l(f2), l, 0, 5);
                }
            } else if (this.l0 != -1) {
                b.g.a.g l2 = eVar.l(this.m0);
                b.g.a.g l3 = eVar.l(f2);
                eVar.d(l2, l3, -this.l0, 6);
                if (z2) {
                    eVar.f(l2, eVar.l(f), 0, 5);
                    eVar.f(l3, l2, 0, 5);
                }
            } else if (this.j0 != -1.0f) {
                b.g.a.g l4 = eVar.l(this.m0);
                b.g.a.g l5 = eVar.l(f);
                b.g.a.g l6 = eVar.l(f2);
                float f3 = this.j0;
                boolean z3 = this.o0;
                b m = eVar.m();
                if (z3) {
                    m.b(eVar, 0);
                }
                m.f871d.h(l4, -1.0f);
                m.f871d.h(l5, 1.0f - f3);
                m.f871d.h(l6, f3);
                eVar.c(m);
            }
        }
    }

    @Override // b.g.a.h.d
    public boolean b() {
        return true;
    }

    @Override // b.g.a.h.d
    public void c(int i) {
        int i2;
        j jVar;
        c cVar;
        j jVar2;
        c cVar2;
        j jVar3;
        int i3;
        c cVar3;
        d.a aVar = d.a.FIXED;
        d dVar = this.D;
        if (dVar != null) {
            if (this.n0 == 1) {
                this.t.f897a.f(1, dVar.t.f897a, 0);
                this.v.f897a.f(1, dVar.t.f897a, 0);
                int i4 = this.k0;
                if (i4 != -1) {
                    this.s.f897a.f(1, dVar.s.f897a, i4);
                    jVar2 = this.u.f897a;
                    cVar3 = dVar.s;
                } else {
                    int i5 = this.l0;
                    if (i5 != -1) {
                        this.s.f897a.f(1, dVar.u.f897a, -i5);
                        jVar2 = this.u.f897a;
                        cVar2 = dVar.u;
                        jVar3 = cVar2.f897a;
                        i3 = -this.l0;
                        jVar2.f(1, jVar3, i3);
                    } else if (this.j0 != -1.0f && dVar.i() == aVar) {
                        i2 = (int) (((float) dVar.E) * this.j0);
                        this.s.f897a.f(1, dVar.s.f897a, i2);
                        jVar = this.u.f897a;
                        cVar = dVar.s;
                        jVar.f(1, cVar.f897a, i2);
                        return;
                    } else {
                        return;
                    }
                }
            } else {
                this.s.f897a.f(1, dVar.s.f897a, 0);
                this.u.f897a.f(1, dVar.s.f897a, 0);
                int i6 = this.k0;
                if (i6 != -1) {
                    this.t.f897a.f(1, dVar.t.f897a, i6);
                    jVar2 = this.v.f897a;
                    cVar3 = dVar.t;
                } else {
                    int i7 = this.l0;
                    if (i7 != -1) {
                        this.t.f897a.f(1, dVar.v.f897a, -i7);
                        jVar2 = this.v.f897a;
                        cVar2 = dVar.v;
                        jVar3 = cVar2.f897a;
                        i3 = -this.l0;
                        jVar2.f(1, jVar3, i3);
                    } else if (this.j0 != -1.0f && dVar.m() == aVar) {
                        i2 = (int) (((float) dVar.F) * this.j0);
                        this.t.f897a.f(1, dVar.t.f897a, i2);
                        jVar = this.v.f897a;
                        cVar = dVar.t;
                        jVar.f(1, cVar.f897a, i2);
                        return;
                    } else {
                        return;
                    }
                }
            }
            jVar3 = cVar3.f897a;
            i3 = this.k0;
            jVar2.f(1, jVar3, i3);
        }
    }

    @Override // b.g.a.h.d
    public c f(c.b bVar) {
        switch (bVar.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.n0 == 1) {
                    return this.m0;
                }
                break;
            case 2:
            case 4:
                if (this.n0 == 0) {
                    return this.m0;
                }
                break;
        }
        throw new AssertionError(bVar.name());
    }
}
