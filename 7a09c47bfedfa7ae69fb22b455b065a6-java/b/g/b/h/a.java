package b.g.b.h;

import b.g.b.b;
import b.g.b.d;
import b.g.b.g;
import b.g.b.h.d;

public class a extends h {
    public int f0 = 0;
    public boolean g0 = true;
    public int h0 = 0;

    @Override // b.g.b.h.d
    public void b(d dVar) {
        Object[] objArr;
        boolean z;
        c cVar;
        g gVar;
        int i;
        int i2;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        c[] cVarArr = this.F;
        cVarArr[0] = this.x;
        cVarArr[2] = this.y;
        cVarArr[1] = this.z;
        cVarArr[3] = this.A;
        int i3 = 0;
        while (true) {
            objArr = this.F;
            if (i3 >= objArr.length) {
                break;
            }
            objArr[i3].f1504f = dVar.l(objArr[i3]);
            i3++;
        }
        int i4 = this.f0;
        if (i4 >= 0) {
            int i5 = 4;
            if (i4 < 4) {
                c cVar2 = objArr[i4];
                int i6 = 0;
                while (true) {
                    if (i6 >= this.e0) {
                        z = false;
                        break;
                    }
                    d dVar2 = this.d0[i6];
                    if ((this.g0 || dVar2.c()) && ((((i = this.f0) == 0 || i == 1) && dVar2.j() == aVar && dVar2.x.f1501c != null && dVar2.z.f1501c != null) || (((i2 = this.f0) == 2 || i2 == 3) && dVar2.n() == aVar && dVar2.y.f1501c != null && dVar2.A.f1501c != null))) {
                        z = true;
                    } else {
                        i6++;
                    }
                }
                z = true;
                for (int i7 = 0; i7 < this.e0; i7++) {
                    d dVar3 = this.d0[i7];
                    if (this.g0 || dVar3.c()) {
                        g l = dVar.l(dVar3.F[this.f0]);
                        c[] cVarArr2 = dVar3.F;
                        int i8 = this.f0;
                        cVarArr2[i8].f1504f = l;
                        int i9 = (cVarArr2[i8].f1501c == null || cVarArr2[i8].f1501c.f1499a != this) ? 0 : cVarArr2[i8].f1502d + 0;
                        int i10 = this.f0;
                        if (i10 == 0 || i10 == 2) {
                            g gVar2 = cVar2.f1504f;
                            int i11 = this.h0 - i9;
                            b m = dVar.m();
                            g n = dVar.n();
                            n.f1483e = 0;
                            m.f(gVar2, l, n, i11);
                            dVar.c(m);
                        } else {
                            g gVar3 = cVar2.f1504f;
                            int i12 = this.h0 + i9;
                            b m2 = dVar.m();
                            g n2 = dVar.n();
                            n2.f1483e = 0;
                            m2.e(gVar3, l, n2, i12);
                            dVar.c(m2);
                        }
                    }
                }
                if (!z) {
                    i5 = 5;
                }
                int i13 = this.f0;
                if (i13 == 0) {
                    dVar.d(this.z.f1504f, this.x.f1504f, 0, 7);
                    dVar.d(this.x.f1504f, this.I.z.f1504f, 0, i5);
                    gVar = this.x.f1504f;
                    cVar = this.I.x;
                } else if (i13 == 1) {
                    dVar.d(this.x.f1504f, this.z.f1504f, 0, 7);
                    dVar.d(this.x.f1504f, this.I.x.f1504f, 0, i5);
                    gVar = this.x.f1504f;
                    cVar = this.I.z;
                } else if (i13 == 2) {
                    dVar.d(this.A.f1504f, this.y.f1504f, 0, 7);
                    dVar.d(this.y.f1504f, this.I.A.f1504f, 0, i5);
                    gVar = this.y.f1504f;
                    cVar = this.I.y;
                } else if (i13 == 3) {
                    dVar.d(this.y.f1504f, this.A.f1504f, 0, 7);
                    dVar.d(this.y.f1504f, this.I.y.f1504f, 0, i5);
                    gVar = this.y.f1504f;
                    cVar = this.I.A;
                } else {
                    return;
                }
                dVar.d(gVar, cVar.f1504f, 0, 0);
            }
        }
    }

    @Override // b.g.b.h.d
    public boolean c() {
        return true;
    }
}
