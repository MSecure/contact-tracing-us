package b.g.b.h.l;

import b.g.b.h.c;
import b.g.b.h.d;
import b.g.b.h.g;
import b.g.b.h.l.f;
import b.g.b.h.l.m;
import c.a.a.a.a;
import java.util.List;

public class j extends m {
    public static int[] k = new int[2];

    public j(d dVar) {
        super(dVar);
        this.h.f1545e = f.a.LEFT;
        this.i.f1545e = f.a.RIGHT;
        this.f1562f = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x027e, code lost:
        if (r15 != 1) goto L_0x02cb;
     */
    @Override // b.g.b.h.l.d, b.g.b.h.l.m
    public void a(d dVar) {
        int i;
        int i2;
        float f2;
        int i3;
        int i4;
        float f3;
        float f4;
        f fVar;
        int i5;
        float f5;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        int ordinal = this.j.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            g gVar = this.f1561e;
            if (!gVar.j && this.f1560d == aVar) {
                d dVar2 = this.f1558b;
                int i6 = dVar2.j;
                if (i6 == 2) {
                    d dVar3 = dVar2.I;
                    if (dVar3 != null) {
                        g gVar2 = dVar3.f1514d.f1561e;
                        if (gVar2.j) {
                            i = (int) ((((float) gVar2.f1547g) * dVar2.o) + 0.5f);
                        }
                    }
                } else if (i6 == 3) {
                    int i7 = dVar2.k;
                    if (i7 == 0 || i7 == 3) {
                        d dVar4 = this.f1558b;
                        l lVar = dVar4.f1515e;
                        f fVar2 = lVar.h;
                        f fVar3 = lVar.i;
                        boolean z = dVar4.x.f1501c != null;
                        boolean z2 = this.f1558b.y.f1501c != null;
                        boolean z3 = this.f1558b.z.f1501c != null;
                        boolean z4 = this.f1558b.A.f1501c != null;
                        d dVar5 = this.f1558b;
                        int i8 = dVar5.M;
                        if (z && z2 && z3 && z4) {
                            float f6 = dVar5.L;
                            if (!fVar2.j || !fVar3.j) {
                                f fVar4 = this.h;
                                if (fVar4.j) {
                                    f fVar5 = this.i;
                                    if (fVar5.j) {
                                        if (fVar2.f1543c && fVar3.f1543c) {
                                            f4 = f6;
                                            m(k, fVar4.f1547g + fVar4.f1546f, fVar5.f1547g - fVar5.f1546f, fVar2.l.get(0).f1547g + fVar2.f1546f, fVar3.l.get(0).f1547g - fVar3.f1546f, f6, i8);
                                            this.f1561e.c(k[0]);
                                            this.f1558b.f1515e.f1561e.c(k[1]);
                                            fVar = this.h;
                                            if (fVar.f1543c && this.i.f1543c && fVar2.f1543c && fVar3.f1543c) {
                                                m(k, fVar.l.get(0).f1547g + this.h.f1546f, this.i.l.get(0).f1547g - this.i.f1546f, fVar2.l.get(0).f1547g + fVar2.f1546f, fVar3.l.get(0).f1547g - fVar3.f1546f, f4, i8);
                                                this.f1561e.c(k[0]);
                                                gVar = this.f1558b.f1515e.f1561e;
                                                i = k[1];
                                            } else {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                f4 = f6;
                                fVar = this.h;
                                if (fVar.f1543c) {
                                    return;
                                }
                                return;
                            }
                            f fVar6 = this.h;
                            if (fVar6.f1543c && this.i.f1543c) {
                                m(k, fVar6.l.get(0).f1547g + this.h.f1546f, this.i.l.get(0).f1547g - this.i.f1546f, fVar2.f1547g + fVar2.f1546f, fVar3.f1547g - fVar3.f1546f, f6, i8);
                                this.f1561e.c(k[0]);
                                this.f1558b.f1515e.f1561e.c(k[1]);
                                return;
                            }
                            return;
                        } else if (z && z3) {
                            f fVar7 = this.h;
                            if (fVar7.f1543c && this.i.f1543c) {
                                float f7 = this.f1558b.L;
                                int i9 = fVar7.l.get(0).f1547g + this.h.f1546f;
                                int i10 = this.i.l.get(0).f1547g - this.i.f1546f;
                                if (i8 == -1 || i8 == 0) {
                                    i4 = g(i10 - i9, 0);
                                    int i11 = (int) ((((float) i4) * f7) + 0.5f);
                                    i3 = g(i11, 1);
                                    if (i11 != i3) {
                                        f3 = ((float) i3) / f7;
                                    }
                                    this.f1561e.c(i4);
                                    this.f1558b.f1515e.f1561e.c(i3);
                                } else if (i8 == 1) {
                                    i4 = g(i10 - i9, 0);
                                    int i12 = (int) ((((float) i4) / f7) + 0.5f);
                                    i3 = g(i12, 1);
                                    if (i12 != i3) {
                                        f3 = ((float) i3) * f7;
                                    }
                                    this.f1561e.c(i4);
                                    this.f1558b.f1515e.f1561e.c(i3);
                                }
                                i4 = (int) (f3 + 0.5f);
                                this.f1561e.c(i4);
                                this.f1558b.f1515e.f1561e.c(i3);
                            } else {
                                return;
                            }
                        } else if (z2 && z4) {
                            if (fVar2.f1543c && fVar3.f1543c) {
                                float f8 = this.f1558b.L;
                                int i13 = fVar2.l.get(0).f1547g + fVar2.f1546f;
                                int i14 = fVar3.l.get(0).f1547g - fVar3.f1546f;
                                if (i8 != -1) {
                                    if (i8 == 0) {
                                        i = g(i14 - i13, 1);
                                        int i15 = (int) ((((float) i) * f8) + 0.5f);
                                        i2 = g(i15, 0);
                                        if (i15 != i2) {
                                            f2 = ((float) i2) / f8;
                                            i = (int) (f2 + 0.5f);
                                        }
                                        this.f1561e.c(i2);
                                        gVar = this.f1558b.f1515e.f1561e;
                                    }
                                }
                                i = g(i14 - i13, 1);
                                int i16 = (int) ((((float) i) / f8) + 0.5f);
                                i2 = g(i16, 0);
                                if (i16 != i2) {
                                    f2 = ((float) i2) * f8;
                                    i = (int) (f2 + 0.5f);
                                }
                                this.f1561e.c(i2);
                                gVar = this.f1558b.f1515e.f1561e;
                            } else {
                                return;
                            }
                        }
                    } else {
                        int i17 = dVar2.M;
                        if (i17 != -1) {
                            if (i17 == 0) {
                                f5 = ((float) dVar2.f1515e.f1561e.f1547g) / dVar2.L;
                                i5 = (int) (f5 + 0.5f);
                                this.f1561e.c(i5);
                            } else if (i17 != 1) {
                                i5 = 0;
                                this.f1561e.c(i5);
                            }
                        }
                        f5 = ((float) dVar2.f1515e.f1561e.f1547g) * dVar2.L;
                        i5 = (int) (f5 + 0.5f);
                        this.f1561e.c(i5);
                    }
                }
                gVar.c(i);
            }
            f fVar8 = this.h;
            if (fVar8.f1543c) {
                f fVar9 = this.i;
                if (fVar9.f1543c) {
                    if (!fVar8.j || !fVar9.j || !this.f1561e.j) {
                        if (!this.f1561e.j && this.f1560d == aVar) {
                            d dVar6 = this.f1558b;
                            if (dVar6.j == 0 && !dVar6.s()) {
                                int i18 = this.h.l.get(0).f1547g;
                                f fVar10 = this.h;
                                int i19 = i18 + fVar10.f1546f;
                                int i20 = this.i.l.get(0).f1547g + this.i.f1546f;
                                fVar10.c(i19);
                                this.i.c(i20);
                                this.f1561e.c(i20 - i19);
                                return;
                            }
                        }
                        if (!this.f1561e.j && this.f1560d == aVar && this.f1557a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                            int min = Math.min((this.i.l.get(0).f1547g + this.i.f1546f) - (this.h.l.get(0).f1547g + this.h.f1546f), this.f1561e.m);
                            d dVar7 = this.f1558b;
                            int i21 = dVar7.n;
                            int max = Math.max(dVar7.m, min);
                            if (i21 > 0) {
                                max = Math.min(i21, max);
                            }
                            this.f1561e.c(max);
                        }
                        if (this.f1561e.j) {
                            f fVar11 = this.h.l.get(0);
                            f fVar12 = this.i.l.get(0);
                            int i22 = fVar11.f1547g;
                            int i23 = this.h.f1546f + i22;
                            int i24 = fVar12.f1547g;
                            int i25 = this.i.f1546f + i24;
                            float f9 = this.f1558b.S;
                            if (fVar11 == fVar12) {
                                f9 = 0.5f;
                            } else {
                                i22 = i23;
                                i24 = i25;
                            }
                            this.h.c((int) ((((float) ((i24 - i22) - this.f1561e.f1547g)) * f9) + ((float) i22) + 0.5f));
                            this.i.c(this.h.f1547g + this.f1561e.f1547g);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        d dVar8 = this.f1558b;
        l(dVar8.x, dVar8.z, 0);
    }

    @Override // b.g.b.h.l.m
    public void d() {
        c cVar;
        f fVar;
        d dVar;
        d dVar2;
        List<d> list;
        f fVar2;
        int i;
        f fVar3;
        f fVar4;
        d dVar3;
        d dVar4;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        d.a aVar2 = d.a.FIXED;
        d.a aVar3 = d.a.MATCH_PARENT;
        d dVar5 = this.f1558b;
        if (dVar5.f1511a) {
            this.f1561e.c(dVar5.o());
        }
        if (!this.f1561e.j) {
            d.a j = this.f1558b.j();
            this.f1560d = j;
            if (j != aVar) {
                if (j == aVar3 && (((dVar4 = this.f1558b.I) != null && dVar4.j() == aVar2) || dVar4.j() == aVar3)) {
                    int o = (dVar4.o() - this.f1558b.x.b()) - this.f1558b.z.b();
                    b(this.h, dVar4.f1514d.h, this.f1558b.x.b());
                    b(this.i, dVar4.f1514d.i, -this.f1558b.z.b());
                    this.f1561e.c(o);
                    return;
                } else if (this.f1560d == aVar2) {
                    this.f1561e.c(this.f1558b.o());
                }
            }
        } else if (this.f1560d == aVar3 && (((dVar3 = this.f1558b.I) != null && dVar3.j() == aVar2) || dVar3.j() == aVar3)) {
            b(this.h, dVar3.f1514d.h, this.f1558b.x.b());
            b(this.i, dVar3.f1514d.i, -this.f1558b.z.b());
            return;
        }
        if (this.f1561e.j) {
            d dVar6 = this.f1558b;
            if (dVar6.f1511a) {
                c[] cVarArr = dVar6.F;
                if (cVarArr[0].f1501c == null || cVarArr[1].f1501c == null) {
                    d dVar7 = this.f1558b;
                    c[] cVarArr2 = dVar7.F;
                    if (cVarArr2[0].f1501c != null) {
                        f h = h(cVarArr2[0]);
                        if (h != null) {
                            f fVar5 = this.h;
                            int b2 = this.f1558b.F[0].b();
                            fVar5.l.add(h);
                            fVar5.f1546f = b2;
                            h.k.add(fVar5);
                        } else {
                            return;
                        }
                    } else if (cVarArr2[1].f1501c != null) {
                        f h2 = h(cVarArr2[1]);
                        if (h2 != null) {
                            f fVar6 = this.i;
                            fVar6.l.add(h2);
                            fVar6.f1546f = -this.f1558b.F[1].b();
                            h2.k.add(fVar6);
                            fVar4 = this.h;
                            fVar3 = this.i;
                            i = -this.f1561e.f1547g;
                            b(fVar4, fVar3, i);
                            return;
                        }
                        return;
                    } else if (!(dVar7 instanceof g) && dVar7.I != null && dVar7.f(c.a.CENTER).f1501c == null) {
                        d dVar8 = this.f1558b;
                        b(this.h, dVar8.I.f1514d.h, dVar8.p());
                    } else {
                        return;
                    }
                    fVar4 = this.i;
                    fVar3 = this.h;
                    i = this.f1561e.f1547g;
                    b(fVar4, fVar3, i);
                    return;
                } else if (dVar6.s()) {
                    this.h.f1546f = this.f1558b.F[0].b();
                    fVar = this.i;
                    cVar = this.f1558b.F[1];
                    fVar.f1546f = -cVar.b();
                } else {
                    f h3 = h(this.f1558b.F[0]);
                    if (h3 != null) {
                        f fVar7 = this.h;
                        int b3 = this.f1558b.F[0].b();
                        fVar7.l.add(h3);
                        fVar7.f1546f = b3;
                        h3.k.add(fVar7);
                    }
                    f h4 = h(this.f1558b.F[1]);
                    if (h4 != null) {
                        f fVar8 = this.i;
                        fVar8.l.add(h4);
                        fVar8.f1546f = -this.f1558b.F[1].b();
                        h4.k.add(fVar8);
                    }
                    this.h.f1542b = true;
                    this.i.f1542b = true;
                    return;
                }
            }
        }
        if (this.f1560d == aVar) {
            d dVar9 = this.f1558b;
            int i2 = dVar9.j;
            if (i2 == 2) {
                d dVar10 = dVar9.I;
                if (dVar10 != null) {
                    g gVar = dVar10.f1515e.f1561e;
                    this.f1561e.l.add(gVar);
                    gVar.k.add(this.f1561e);
                    g gVar2 = this.f1561e;
                    gVar2.f1542b = true;
                    gVar2.k.add(this.h);
                    list = this.f1561e.k;
                    dVar2 = this.i;
                }
            } else if (i2 == 3) {
                if (dVar9.k == 3) {
                    this.h.f1541a = this;
                    this.i.f1541a = this;
                    l lVar = dVar9.f1515e;
                    lVar.h.f1541a = this;
                    lVar.i.f1541a = this;
                    this.f1561e.f1541a = this;
                    if (dVar9.t()) {
                        this.f1561e.l.add(this.f1558b.f1515e.f1561e);
                        this.f1558b.f1515e.f1561e.k.add(this.f1561e);
                        l lVar2 = this.f1558b.f1515e;
                        lVar2.f1561e.f1541a = this;
                        this.f1561e.l.add(lVar2.h);
                        this.f1561e.l.add(this.f1558b.f1515e.i);
                        this.f1558b.f1515e.h.k.add(this.f1561e);
                        list = this.f1558b.f1515e.i.k;
                        dVar2 = this.f1561e;
                    } else if (this.f1558b.s()) {
                        this.f1558b.f1515e.f1561e.l.add(this.f1561e);
                        list = this.f1561e.k;
                        dVar2 = this.f1558b.f1515e.f1561e;
                    } else {
                        fVar2 = this.f1558b.f1515e.f1561e;
                    }
                } else {
                    g gVar3 = dVar9.f1515e.f1561e;
                    this.f1561e.l.add(gVar3);
                    gVar3.k.add(this.f1561e);
                    this.f1558b.f1515e.h.k.add(this.f1561e);
                    this.f1558b.f1515e.i.k.add(this.f1561e);
                    g gVar4 = this.f1561e;
                    gVar4.f1542b = true;
                    gVar4.k.add(this.h);
                    this.f1561e.k.add(this.i);
                    this.h.l.add(this.f1561e);
                    fVar2 = this.i;
                }
                list = fVar2.l;
                dVar2 = this.f1561e;
            }
            list.add(dVar2);
        }
        d dVar11 = this.f1558b;
        c[] cVarArr3 = dVar11.F;
        if (cVarArr3[0].f1501c == null || cVarArr3[1].f1501c == null) {
            d dVar12 = this.f1558b;
            c[] cVarArr4 = dVar12.F;
            if (cVarArr4[0].f1501c != null) {
                f h5 = h(cVarArr4[0]);
                if (h5 != null) {
                    f fVar9 = this.h;
                    int b4 = this.f1558b.F[0].b();
                    fVar9.l.add(h5);
                    fVar9.f1546f = b4;
                    h5.k.add(fVar9);
                } else {
                    return;
                }
            } else if (cVarArr4[1].f1501c != null) {
                f h6 = h(cVarArr4[1]);
                if (h6 != null) {
                    f fVar10 = this.i;
                    fVar10.l.add(h6);
                    fVar10.f1546f = -this.f1558b.F[1].b();
                    h6.k.add(fVar10);
                    c(this.h, this.i, -1, this.f1561e);
                    return;
                }
                return;
            } else if (!(dVar12 instanceof g) && (dVar = dVar12.I) != null) {
                b(this.h, dVar.f1514d.h, dVar12.p());
            } else {
                return;
            }
            c(this.i, this.h, 1, this.f1561e);
        } else if (dVar11.s()) {
            this.h.f1546f = this.f1558b.F[0].b();
            fVar = this.i;
            cVar = this.f1558b.F[1];
            fVar.f1546f = -cVar.b();
        } else {
            f h7 = h(this.f1558b.F[0]);
            f h8 = h(this.f1558b.F[1]);
            h7.k.add(this);
            if (h7.j) {
                a(this);
            }
            h8.k.add(this);
            if (h8.j) {
                a(this);
            }
            this.j = m.a.CENTER;
        }
    }

    @Override // b.g.b.h.l.m
    public void e() {
        f fVar = this.h;
        if (fVar.j) {
            this.f1558b.N = fVar.f1547g;
        }
    }

    @Override // b.g.b.h.l.m
    public void f() {
        this.f1559c = null;
        this.h.b();
        this.i.b();
        this.f1561e.b();
        this.f1563g = false;
    }

    @Override // b.g.b.h.l.m
    public boolean k() {
        return this.f1560d != d.a.MATCH_CONSTRAINT || this.f1558b.j == 0;
    }

    public final void m(int[] iArr, int i, int i2, int i3, int i4, float f2, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 == -1) {
            int i8 = (int) ((((float) i7) * f2) + 0.5f);
            int i9 = (int) ((((float) i6) / f2) + 0.5f);
            if (i8 <= i6 && i7 <= i7) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i6 <= i6 && i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        } else if (i5 == 0) {
            iArr[0] = (int) ((((float) i7) * f2) + 0.5f);
            iArr[1] = i7;
        } else if (i5 == 1) {
            iArr[0] = i6;
            iArr[1] = (int) ((((float) i6) * f2) + 0.5f);
        }
    }

    public void n() {
        this.f1563g = false;
        this.h.b();
        this.h.j = false;
        this.i.b();
        this.i.j = false;
        this.f1561e.j = false;
    }

    public String toString() {
        StringBuilder h = a.h("HorizontalRun ");
        h.append(this.f1558b.W);
        return h.toString();
    }
}
