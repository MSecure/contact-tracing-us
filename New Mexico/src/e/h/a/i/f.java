package e.h.a.i;

import e.h.a.b;
import e.h.a.d;
import e.h.a.g;
import e.h.a.i.c;
import e.h.a.i.d;
/* loaded from: classes.dex */
public class f extends d {
    public float q0 = -1.0f;
    public int r0 = -1;
    public int s0 = -1;
    public c t0 = this.J;
    public int u0 = 0;
    public boolean v0;

    public f() {
        this.R.clear();
        this.R.add(this.t0);
        int length = this.Q.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.Q[i2] = this.t0;
        }
    }

    @Override // e.h.a.i.d
    public boolean A() {
        return this.v0;
    }

    @Override // e.h.a.i.d
    public boolean B() {
        return this.v0;
    }

    @Override // e.h.a.i.d
    public void P(d dVar, boolean z) {
        if (this.U != null) {
            int o = dVar.o(this.t0);
            if (this.u0 == 1) {
                this.Z = o;
                this.a0 = 0;
                I(this.U.l());
                N(0);
                return;
            }
            this.Z = 0;
            this.a0 = o;
            N(this.U.r());
            I(0);
        }
    }

    public void Q(int i2) {
        c cVar = this.t0;
        cVar.b = i2;
        cVar.c = true;
        this.v0 = true;
    }

    public void R(int i2) {
        if (this.u0 != i2) {
            this.u0 = i2;
            this.R.clear();
            this.t0 = this.u0 == 1 ? this.I : this.J;
            this.R.add(this.t0);
            int length = this.Q.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.Q[i3] = this.t0;
            }
        }
    }

    @Override // e.h.a.i.d
    public void d(d dVar, boolean z) {
        g l2;
        g l3;
        g l4;
        d.a aVar = d.a.WRAP_CONTENT;
        e eVar = (e) this.U;
        if (eVar != null) {
            Object i2 = eVar.i(c.a.LEFT);
            Object i3 = eVar.i(c.a.RIGHT);
            d dVar2 = this.U;
            boolean z2 = true;
            boolean z3 = dVar2 != null && dVar2.T[0] == aVar;
            if (this.u0 == 0) {
                i2 = eVar.i(c.a.TOP);
                i3 = eVar.i(c.a.BOTTOM);
                d dVar3 = this.U;
                if (dVar3 == null || dVar3.T[1] != aVar) {
                    z2 = false;
                }
                z3 = z2;
            }
            if (this.v0) {
                c cVar = this.t0;
                if (cVar.c) {
                    g l5 = dVar.l(cVar);
                    dVar.e(l5, this.t0.c());
                    if (this.r0 != -1) {
                        if (z3) {
                            l4 = dVar.l(i3);
                            dVar.f(l4, l5, 0, 5);
                        }
                        this.v0 = false;
                        return;
                    }
                    if (this.s0 != -1 && z3) {
                        l4 = dVar.l(i3);
                        dVar.f(l5, dVar.l(i2), 0, 5);
                        dVar.f(l4, l5, 0, 5);
                    }
                    this.v0 = false;
                    return;
                }
            }
            if (this.r0 != -1) {
                l2 = dVar.l(this.t0);
                dVar.d(l2, dVar.l(i2), this.r0, 8);
                if (z3) {
                    l3 = dVar.l(i3);
                } else {
                    return;
                }
            } else if (this.s0 != -1) {
                l2 = dVar.l(this.t0);
                l3 = dVar.l(i3);
                dVar.d(l2, l3, -this.s0, 8);
                if (z3) {
                    dVar.f(l2, dVar.l(i2), 0, 5);
                } else {
                    return;
                }
            } else if (this.q0 != -1.0f) {
                g l6 = dVar.l(this.t0);
                g l7 = dVar.l(i3);
                float f2 = this.q0;
                b m = dVar.m();
                m.f1338d.f(l6, -1.0f);
                m.f1338d.f(l7, f2);
                dVar.c(m);
                return;
            } else {
                return;
            }
            dVar.f(l3, l2, 0, 5);
        }
    }

    @Override // e.h.a.i.d
    public boolean e() {
        return true;
    }

    @Override // e.h.a.i.d
    public c i(c.a aVar) {
        int ordinal = aVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        return null;
                    }
                }
            }
            if (this.u0 == 0) {
                return this.t0;
            }
            return null;
        }
        if (this.u0 == 1) {
            return this.t0;
        }
        return null;
    }
}
