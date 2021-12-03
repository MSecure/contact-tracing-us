package e.g.b.h;

import e.g.b.b;
import e.g.b.d;
import e.g.b.g;
import e.g.b.h.c;
import e.g.b.h.d;

public class a extends h {
    public int n0 = 0;
    public boolean o0 = true;
    public int p0 = 0;
    public boolean q0 = false;

    @Override // e.g.b.h.d
    public boolean A() {
        return this.q0;
    }

    public boolean Q() {
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
            i2 = this.m0;
            if (i8 >= i2) {
                break;
            }
            d dVar = this.l0[i8];
            if ((this.o0 || dVar.e()) && ((((i6 = this.n0) == 0 || i6 == 1) && !dVar.z()) || (((i7 = this.n0) == 2 || i7 == 3) && !dVar.A()))) {
                z = false;
            }
            i8++;
        }
        if (!z || i2 <= 0) {
            return false;
        }
        int i9 = 0;
        boolean z2 = false;
        for (int i10 = 0; i10 < this.m0; i10++) {
            d dVar2 = this.l0[i10];
            if (this.o0 || dVar2.e()) {
                if (!z2) {
                    int i11 = this.n0;
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
                int i12 = this.n0;
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
        int i13 = i9 + this.p0;
        int i14 = this.n0;
        if (i14 == 0 || i14 == 1) {
            F(i13, i13);
        } else {
            G(i13, i13);
        }
        this.q0 = true;
        return true;
    }

    public int R() {
        int i2 = this.n0;
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return (i2 == 2 || i2 == 3) ? 1 : -1;
    }

    @Override // e.g.b.h.d
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
        c[] cVarArr = this.L;
        cVarArr[0] = this.D;
        cVarArr[2] = this.E;
        cVarArr[1] = this.F;
        cVarArr[3] = this.G;
        int i6 = 0;
        while (true) {
            objArr = this.L;
            if (i6 >= objArr.length) {
                break;
            }
            objArr[i6].f1088i = dVar.l(objArr[i6]);
            i6++;
        }
        int i7 = this.n0;
        if (i7 >= 0 && i7 < 4) {
            c cVar2 = objArr[i7];
            if (!this.q0) {
                Q();
            }
            if (this.q0) {
                this.q0 = false;
                int i8 = this.n0;
                if (i8 == 0 || i8 == 1) {
                    dVar.e(this.D.f1088i, this.U);
                    gVar2 = this.F.f1088i;
                    i5 = this.U;
                } else if (i8 == 2 || i8 == 3) {
                    dVar.e(this.E.f1088i, this.V);
                    gVar2 = this.G.f1088i;
                    i5 = this.V;
                } else {
                    return;
                }
                dVar.e(gVar2, i5);
                return;
            }
            int i9 = 0;
            while (true) {
                if (i9 >= this.m0) {
                    z2 = false;
                    break;
                }
                d dVar2 = this.l0[i9];
                if ((this.o0 || dVar2.e()) && ((((i3 = this.n0) == 0 || i3 == 1) && dVar2.m() == aVar && dVar2.D.f1085f != null && dVar2.F.f1085f != null) || (((i4 = this.n0) == 2 || i4 == 3) && dVar2.q() == aVar && dVar2.E.f1085f != null && dVar2.G.f1085f != null))) {
                    z2 = true;
                } else {
                    i9++;
                }
            }
            z2 = true;
            boolean z3 = this.D.e() || this.F.e();
            boolean z4 = this.E.e() || this.G.e();
            boolean z5 = !z2 && (((i2 = this.n0) == 0 && z3) || ((i2 == 2 && z4) || ((i2 == 1 && z3) || (i2 == 3 && z4))));
            int i10 = 5;
            if (!z5) {
                i10 = 4;
            }
            for (int i11 = 0; i11 < this.m0; i11++) {
                d dVar3 = this.l0[i11];
                if (this.o0 || dVar3.e()) {
                    g l2 = dVar.l(dVar3.L[this.n0]);
                    c[] cVarArr2 = dVar3.L;
                    int i12 = this.n0;
                    cVarArr2[i12].f1088i = l2;
                    int i13 = (cVarArr2[i12].f1085f == null || cVarArr2[i12].f1085f.f1083d != this) ? 0 : cVarArr2[i12].f1086g + 0;
                    if (i12 == 0 || i12 == 2) {
                        b m = dVar.m();
                        g n = dVar.n();
                        n.f1061d = 0;
                        m.f(cVar2.f1088i, l2, n, this.p0 - i13);
                        dVar.c(m);
                    } else {
                        b m2 = dVar.m();
                        g n2 = dVar.n();
                        n2.f1061d = 0;
                        m2.e(cVar2.f1088i, l2, n2, this.p0 + i13);
                        dVar.c(m2);
                    }
                    dVar.d(cVar2.f1088i, l2, this.p0 + i13, i10);
                }
            }
            int i14 = this.n0;
            if (i14 == 0) {
                dVar.d(this.F.f1088i, this.D.f1088i, 0, 8);
                dVar.d(this.D.f1088i, this.P.F.f1088i, 0, 4);
                gVar = this.D.f1088i;
                cVar = this.P.D;
            } else if (i14 == 1) {
                dVar.d(this.D.f1088i, this.F.f1088i, 0, 8);
                dVar.d(this.D.f1088i, this.P.D.f1088i, 0, 4);
                gVar = this.D.f1088i;
                cVar = this.P.F;
            } else if (i14 == 2) {
                dVar.d(this.G.f1088i, this.E.f1088i, 0, 8);
                dVar.d(this.E.f1088i, this.P.G.f1088i, 0, 4);
                gVar = this.E.f1088i;
                cVar = this.P.E;
            } else if (i14 == 3) {
                dVar.d(this.E.f1088i, this.G.f1088i, 0, 8);
                dVar.d(this.E.f1088i, this.P.E.f1088i, 0, 4);
                gVar = this.E.f1088i;
                cVar = this.P.G;
            } else {
                return;
            }
            dVar.d(gVar, cVar.f1088i, 0, 0);
        }
    }

    @Override // e.g.b.h.d
    public boolean e() {
        return true;
    }

    @Override // e.g.b.h.d
    public String toString() {
        String f2 = f.a.a.a.a.f(f.a.a.a.a.i("[Barrier] "), this.d0, " {");
        for (int i2 = 0; i2 < this.m0; i2++) {
            d dVar = this.l0[i2];
            if (i2 > 0) {
                f2 = f.a.a.a.a.c(f2, ", ");
            }
            StringBuilder i3 = f.a.a.a.a.i(f2);
            i3.append(dVar.d0);
            f2 = i3.toString();
        }
        return f.a.a.a.a.c(f2, "}");
    }

    @Override // e.g.b.h.d
    public boolean z() {
        return this.q0;
    }
}
