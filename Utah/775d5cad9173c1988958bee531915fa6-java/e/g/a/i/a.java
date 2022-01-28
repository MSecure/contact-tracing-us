package e.g.a.i;

import e.g.a.b;
import e.g.a.d;
import e.g.a.g;
import e.g.a.i.c;
import e.g.a.i.d;

public class a extends h {
    public int s0 = 0;
    public boolean t0 = true;
    public int u0 = 0;
    public boolean v0 = false;

    @Override // e.g.a.i.d
    public boolean A() {
        return this.v0;
    }

    @Override // e.g.a.i.d
    public boolean B() {
        return this.v0;
    }

    public boolean R() {
        int i2;
        c i3;
        c i4;
        c i5;
        int i6;
        int i7;
        c.a aVar = c.a.BOTTOM;
        c.a aVar2 = c.a.TOP;
        c.a aVar3 = c.a.RIGHT;
        c.a aVar4 = c.a.LEFT;
        int i8 = 0;
        boolean z = true;
        while (true) {
            i2 = this.r0;
            if (i8 >= i2) {
                break;
            }
            d dVar = this.q0[i8];
            if ((this.t0 || dVar.e()) && ((((i6 = this.s0) == 0 || i6 == 1) && !dVar.A()) || (((i7 = this.s0) == 2 || i7 == 3) && !dVar.B()))) {
                z = false;
            }
            i8++;
        }
        if (!z || i2 <= 0) {
            return false;
        }
        int i9 = 0;
        boolean z2 = false;
        for (int i10 = 0; i10 < this.r0; i10++) {
            d dVar2 = this.q0[i10];
            if (this.t0 || dVar2.e()) {
                if (!z2) {
                    int i11 = this.s0;
                    if (i11 == 0) {
                        i5 = dVar2.i(aVar4);
                    } else if (i11 == 1) {
                        i5 = dVar2.i(aVar3);
                    } else if (i11 == 2) {
                        i5 = dVar2.i(aVar2);
                    } else {
                        if (i11 == 3) {
                            i5 = dVar2.i(aVar);
                        }
                        z2 = true;
                    }
                    i9 = i5.c();
                    z2 = true;
                }
                int i12 = this.s0;
                if (i12 == 0) {
                    i4 = dVar2.i(aVar4);
                } else {
                    if (i12 == 1) {
                        i3 = dVar2.i(aVar3);
                    } else if (i12 == 2) {
                        i4 = dVar2.i(aVar2);
                    } else if (i12 == 3) {
                        i3 = dVar2.i(aVar);
                    }
                    i9 = Math.max(i9, i3.c());
                }
                i9 = Math.min(i9, i4.c());
            }
        }
        int i13 = i9 + this.u0;
        int i14 = this.s0;
        if (i14 == 0 || i14 == 1) {
            G(i13, i13);
        } else {
            H(i13, i13);
        }
        this.v0 = true;
        return true;
    }

    public int S() {
        int i2 = this.s0;
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return (i2 == 2 || i2 == 3) ? 1 : -1;
    }

    @Override // e.g.a.i.d
    public void d(d dVar, boolean z) {
        Object[] objArr;
        boolean z2;
        g gVar;
        c cVar;
        int i2;
        int i3;
        int i4;
        g gVar2;
        int i5;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        c[] cVarArr = this.Q;
        cVarArr[0] = this.I;
        cVarArr[2] = this.J;
        cVarArr[1] = this.K;
        cVarArr[3] = this.L;
        int i6 = 0;
        while (true) {
            objArr = this.Q;
            if (i6 >= objArr.length) {
                break;
            }
            objArr[i6].f1298i = dVar.l(objArr[i6]);
            i6++;
        }
        int i7 = this.s0;
        if (i7 >= 0 && i7 < 4) {
            c cVar2 = objArr[i7];
            if (!this.v0) {
                R();
            }
            if (this.v0) {
                this.v0 = false;
                int i8 = this.s0;
                if (i8 == 0 || i8 == 1) {
                    dVar.e(this.I.f1298i, this.Z);
                    gVar2 = this.K.f1298i;
                    i5 = this.Z;
                } else if (i8 == 2 || i8 == 3) {
                    dVar.e(this.J.f1298i, this.a0);
                    gVar2 = this.L.f1298i;
                    i5 = this.a0;
                } else {
                    return;
                }
                dVar.e(gVar2, i5);
                return;
            }
            int i9 = 0;
            while (true) {
                if (i9 >= this.r0) {
                    z2 = false;
                    break;
                }
                d dVar2 = this.q0[i9];
                if ((this.t0 || dVar2.e()) && ((((i3 = this.s0) == 0 || i3 == 1) && dVar2.m() == aVar && dVar2.I.f1295f != null && dVar2.K.f1295f != null) || (((i4 = this.s0) == 2 || i4 == 3) && dVar2.q() == aVar && dVar2.J.f1295f != null && dVar2.L.f1295f != null))) {
                    z2 = true;
                } else {
                    i9++;
                }
            }
            z2 = true;
            boolean z3 = this.I.e() || this.K.e();
            boolean z4 = this.J.e() || this.L.e();
            boolean z5 = !z2 && (((i2 = this.s0) == 0 && z3) || ((i2 == 2 && z4) || ((i2 == 1 && z3) || (i2 == 3 && z4))));
            int i10 = 5;
            if (!z5) {
                i10 = 4;
            }
            for (int i11 = 0; i11 < this.r0; i11++) {
                d dVar3 = this.q0[i11];
                if (this.t0 || dVar3.e()) {
                    g l2 = dVar.l(dVar3.Q[this.s0]);
                    c[] cVarArr2 = dVar3.Q;
                    int i12 = this.s0;
                    cVarArr2[i12].f1298i = l2;
                    int i13 = (cVarArr2[i12].f1295f == null || cVarArr2[i12].f1295f.f1293d != this) ? 0 : cVarArr2[i12].f1296g + 0;
                    if (i12 == 0 || i12 == 2) {
                        b m = dVar.m();
                        g n = dVar.n();
                        n.f1272e = 0;
                        m.f(cVar2.f1298i, l2, n, this.u0 - i13);
                        dVar.c(m);
                    } else {
                        b m2 = dVar.m();
                        g n2 = dVar.n();
                        n2.f1272e = 0;
                        m2.e(cVar2.f1298i, l2, n2, this.u0 + i13);
                        dVar.c(m2);
                    }
                    dVar.d(cVar2.f1298i, l2, this.u0 + i13, i10);
                }
            }
            int i14 = this.s0;
            if (i14 == 0) {
                dVar.d(this.K.f1298i, this.I.f1298i, 0, 8);
                dVar.d(this.I.f1298i, this.U.K.f1298i, 0, 4);
                gVar = this.I.f1298i;
                cVar = this.U.I;
            } else if (i14 == 1) {
                dVar.d(this.I.f1298i, this.K.f1298i, 0, 8);
                dVar.d(this.I.f1298i, this.U.I.f1298i, 0, 4);
                gVar = this.I.f1298i;
                cVar = this.U.K;
            } else if (i14 == 2) {
                dVar.d(this.L.f1298i, this.J.f1298i, 0, 8);
                dVar.d(this.J.f1298i, this.U.L.f1298i, 0, 4);
                gVar = this.J.f1298i;
                cVar = this.U.J;
            } else if (i14 == 3) {
                dVar.d(this.J.f1298i, this.L.f1298i, 0, 8);
                dVar.d(this.J.f1298i, this.U.J.f1298i, 0, 4);
                gVar = this.J.f1298i;
                cVar = this.U.L;
            } else {
                return;
            }
            dVar.d(gVar, cVar.f1298i, 0, 0);
        }
    }

    @Override // e.g.a.i.d
    public boolean e() {
        return true;
    }

    @Override // e.g.a.i.d
    public String toString() {
        String e2 = f.a.a.a.a.e(f.a.a.a.a.h("[Barrier] "), this.i0, " {");
        for (int i2 = 0; i2 < this.r0; i2++) {
            d dVar = this.q0[i2];
            if (i2 > 0) {
                e2 = f.a.a.a.a.w(e2, ", ");
            }
            StringBuilder h2 = f.a.a.a.a.h(e2);
            h2.append(dVar.i0);
            e2 = h2.toString();
        }
        return f.a.a.a.a.w(e2, "}");
    }
}
