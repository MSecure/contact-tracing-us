package e.g.b.h;

import e.g.b.b;
import e.g.b.d;
import e.g.b.g;
import e.g.b.h.c;
import e.g.b.h.d;

public class f extends d {
    public float l0 = -1.0f;
    public int m0 = -1;
    public int n0 = -1;
    public c o0 = this.E;
    public int p0;
    public boolean q0;

    public f() {
        this.p0 = 0;
        this.M.clear();
        this.M.add(this.o0);
        int length = this.L.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.L[i2] = this.o0;
        }
    }

    @Override // e.g.b.h.d
    public boolean A() {
        return this.q0;
    }

    @Override // e.g.b.h.d
    public void O(d dVar, boolean z) {
        if (this.P != null) {
            int o = dVar.o(this.o0);
            if (this.p0 == 1) {
                this.U = o;
                this.V = 0;
                H(this.P.l());
                M(0);
                return;
            }
            this.U = 0;
            this.V = o;
            M(this.P.r());
            H(0);
        }
    }

    public void P(int i2) {
        c cVar = this.o0;
        cVar.b = i2;
        cVar.c = true;
        this.q0 = true;
    }

    public void Q(int i2) {
        if (this.p0 != i2) {
            this.p0 = i2;
            this.M.clear();
            this.o0 = this.p0 == 1 ? this.D : this.E;
            this.M.add(this.o0);
            int length = this.L.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.L[i3] = this.o0;
            }
        }
    }

    @Override // e.g.b.h.d
    public void d(d dVar, boolean z) {
        g l2;
        g l3;
        g l4;
        d.a aVar = d.a.WRAP_CONTENT;
        e eVar = (e) this.P;
        if (eVar != null) {
            Object i2 = eVar.i(c.a.LEFT);
            Object i3 = eVar.i(c.a.RIGHT);
            d dVar2 = this.P;
            boolean z2 = true;
            boolean z3 = dVar2 != null && dVar2.O[0] == aVar;
            if (this.p0 == 0) {
                i2 = eVar.i(c.a.TOP);
                i3 = eVar.i(c.a.BOTTOM);
                d dVar3 = this.P;
                if (dVar3 == null || dVar3.O[1] != aVar) {
                    z2 = false;
                }
                z3 = z2;
            }
            if (this.q0) {
                c cVar = this.o0;
                if (cVar.c) {
                    g l5 = dVar.l(cVar);
                    dVar.e(l5, this.o0.c());
                    if (this.m0 != -1) {
                        if (z3) {
                            l4 = dVar.l(i3);
                        }
                        this.q0 = false;
                        return;
                    }
                    if (this.n0 != -1 && z3) {
                        l4 = dVar.l(i3);
                        dVar.f(l5, dVar.l(i2), 0, 5);
                    }
                    this.q0 = false;
                    return;
                    dVar.f(l4, l5, 0, 5);
                    this.q0 = false;
                    return;
                }
            }
            if (this.m0 != -1) {
                l2 = dVar.l(this.o0);
                dVar.d(l2, dVar.l(i2), this.m0, 8);
                if (z3) {
                    l3 = dVar.l(i3);
                } else {
                    return;
                }
            } else if (this.n0 != -1) {
                l2 = dVar.l(this.o0);
                l3 = dVar.l(i3);
                dVar.d(l2, l3, -this.n0, 8);
                if (z3) {
                    dVar.f(l2, dVar.l(i2), 0, 5);
                } else {
                    return;
                }
            } else if (this.l0 != -1.0f) {
                g l6 = dVar.l(this.o0);
                g l7 = dVar.l(i3);
                float f2 = this.l0;
                b m = dVar.m();
                m.f1044d.c(l6, -1.0f);
                m.f1044d.c(l7, f2);
                dVar.c(m);
                return;
            } else {
                return;
            }
            dVar.f(l3, l2, 0, 5);
        }
    }

    @Override // e.g.b.h.d
    public boolean e() {
        return true;
    }

    @Override // e.g.b.h.d
    public c i(c.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.p0 == 1) {
                    return this.o0;
                }
                break;
            case 2:
            case 4:
                if (this.p0 == 0) {
                    return this.o0;
                }
                break;
        }
        throw new AssertionError(aVar.name());
    }

    @Override // e.g.b.h.d
    public boolean z() {
        return this.q0;
    }
}
