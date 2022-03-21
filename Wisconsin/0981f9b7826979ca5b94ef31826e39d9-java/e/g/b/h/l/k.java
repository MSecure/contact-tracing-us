package e.g.b.h.l;

import e.g.b.h.c;
import e.g.b.h.d;
import e.g.b.h.g;
import e.g.b.h.l.f;
import e.g.b.h.l.o;
import f.a.a.a.a;
import java.util.List;

public class k extends o {

    /* renamed from: k  reason: collision with root package name */
    public static int[] f1315k = new int[2];

    public k(d dVar) {
        super(dVar);
        this.f1325h.f1300e = f.a.LEFT;
        this.f1326i.f1300e = f.a.RIGHT;
        this.f1323f = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0266, code lost:
        if (r7 != 1) goto L_0x02b6;
     */
    @Override // e.g.b.h.l.o, e.g.b.h.l.d
    public void a(d dVar) {
        int i2;
        float f2;
        float f3;
        float f4;
        int i3;
        float f5;
        int i4;
        int i5;
        float f6;
        int i6;
        float f7;
        f fVar;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        int[] iArr = f1315k;
        int ordinal = this.f1327j.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            g gVar = this.f1322e;
            if (!gVar.f1305j && this.f1321d == aVar) {
                d dVar2 = this.b;
                int i7 = dVar2.f1281l;
                if (i7 == 2) {
                    d dVar3 = dVar2.P;
                    if (dVar3 != null) {
                        g gVar2 = dVar3.f1273d.f1322e;
                        if (gVar2.f1305j) {
                            f3 = dVar2.q;
                            f4 = (float) gVar2.f1302g;
                        }
                    }
                } else if (i7 == 3) {
                    int i8 = dVar2.m;
                    if (i8 == 0 || i8 == 3) {
                        m mVar = dVar2.f1274e;
                        f fVar2 = mVar.f1325h;
                        f fVar3 = mVar.f1326i;
                        boolean z = dVar2.D.f1261f != null;
                        boolean z2 = dVar2.E.f1261f != null;
                        boolean z3 = dVar2.F.f1261f != null;
                        boolean z4 = dVar2.G.f1261f != null;
                        int i9 = dVar2.T;
                        if (z && z2 && z3 && z4) {
                            float f8 = dVar2.S;
                            if (!fVar2.f1305j || !fVar3.f1305j) {
                                f fVar4 = this.f1325h;
                                if (fVar4.f1305j) {
                                    f fVar5 = this.f1326i;
                                    if (fVar5.f1305j) {
                                        if (fVar2.c && fVar3.c) {
                                            f7 = f8;
                                            i6 = i9;
                                            m(iArr, fVar4.f1302g + fVar4.f1301f, fVar5.f1302g - fVar5.f1301f, fVar2.f1307l.get(0).f1302g + fVar2.f1301f, fVar3.f1307l.get(0).f1302g - fVar3.f1301f, f8, i9);
                                            this.f1322e.c(iArr[0]);
                                            this.b.f1274e.f1322e.c(iArr[1]);
                                            fVar = this.f1325h;
                                            if (fVar.c && this.f1326i.c && fVar2.c && fVar3.c) {
                                                m(iArr, fVar.f1307l.get(0).f1302g + this.f1325h.f1301f, this.f1326i.f1307l.get(0).f1302g - this.f1326i.f1301f, fVar2.f1307l.get(0).f1302g + fVar2.f1301f, fVar3.f1307l.get(0).f1302g - fVar3.f1301f, f7, i6);
                                                this.f1322e.c(iArr[0]);
                                                gVar = this.b.f1274e.f1322e;
                                                i2 = iArr[1];
                                                gVar.c(i2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                f7 = f8;
                                i6 = i9;
                                fVar = this.f1325h;
                                if (fVar.c) {
                                    return;
                                }
                                return;
                            }
                            f fVar6 = this.f1325h;
                            if (fVar6.c && this.f1326i.c) {
                                m(iArr, fVar6.f1307l.get(0).f1302g + this.f1325h.f1301f, this.f1326i.f1307l.get(0).f1302g - this.f1326i.f1301f, fVar2.f1302g + fVar2.f1301f, fVar3.f1302g - fVar3.f1301f, f8, i9);
                                this.f1322e.c(iArr[0]);
                                this.b.f1274e.f1322e.c(iArr[1]);
                                return;
                            }
                            return;
                        } else if (z && z3) {
                            f fVar7 = this.f1325h;
                            if (fVar7.c && this.f1326i.c) {
                                float f9 = dVar2.S;
                                int i10 = fVar7.f1307l.get(0).f1302g + this.f1325h.f1301f;
                                int i11 = this.f1326i.f1307l.get(0).f1302g - this.f1326i.f1301f;
                                if (i9 == -1 || i9 == 0) {
                                    i5 = g(i11 - i10, 0);
                                    int i12 = (int) ((((float) i5) * f9) + 0.5f);
                                    i4 = g(i12, 1);
                                    if (i12 != i4) {
                                        f6 = ((float) i4) / f9;
                                    }
                                    this.f1322e.c(i5);
                                    this.b.f1274e.f1322e.c(i4);
                                } else if (i9 == 1) {
                                    i5 = g(i11 - i10, 0);
                                    int i13 = (int) ((((float) i5) / f9) + 0.5f);
                                    i4 = g(i13, 1);
                                    if (i13 != i4) {
                                        f6 = ((float) i4) * f9;
                                    }
                                    this.f1322e.c(i5);
                                    this.b.f1274e.f1322e.c(i4);
                                }
                                i5 = (int) (f6 + 0.5f);
                                this.f1322e.c(i5);
                                this.b.f1274e.f1322e.c(i4);
                            } else {
                                return;
                            }
                        } else if (z2 && z4) {
                            if (fVar2.c && fVar3.c) {
                                float f10 = dVar2.S;
                                int i14 = fVar2.f1307l.get(0).f1302g + fVar2.f1301f;
                                int i15 = fVar3.f1307l.get(0).f1302g - fVar3.f1301f;
                                if (i9 != -1) {
                                    if (i9 == 0) {
                                        i2 = g(i15 - i14, 1);
                                        int i16 = (int) ((((float) i2) * f10) + 0.5f);
                                        i3 = g(i16, 0);
                                        if (i16 != i3) {
                                            f5 = ((float) i3) / f10;
                                            i2 = (int) (f5 + 0.5f);
                                        }
                                        this.f1322e.c(i3);
                                        gVar = this.b.f1274e.f1322e;
                                        gVar.c(i2);
                                    }
                                }
                                i2 = g(i15 - i14, 1);
                                int i17 = (int) ((((float) i2) / f10) + 0.5f);
                                i3 = g(i17, 0);
                                if (i17 != i3) {
                                    f5 = ((float) i3) * f10;
                                    i2 = (int) (f5 + 0.5f);
                                }
                                this.f1322e.c(i3);
                                gVar = this.b.f1274e.f1322e;
                                gVar.c(i2);
                            } else {
                                return;
                            }
                        }
                    } else {
                        int i18 = dVar2.T;
                        if (i18 != -1) {
                            if (i18 == 0) {
                                f2 = ((float) dVar2.f1274e.f1322e.f1302g) / dVar2.S;
                                i2 = (int) (f2 + 0.5f);
                                gVar.c(i2);
                            } else if (i18 != 1) {
                                i2 = 0;
                                gVar.c(i2);
                            }
                        }
                        f4 = (float) dVar2.f1274e.f1322e.f1302g;
                        f3 = dVar2.S;
                    }
                }
                f2 = f4 * f3;
                i2 = (int) (f2 + 0.5f);
                gVar.c(i2);
            }
            f fVar8 = this.f1325h;
            if (fVar8.c) {
                f fVar9 = this.f1326i;
                if (fVar9.c) {
                    if (!fVar8.f1305j || !fVar9.f1305j || !this.f1322e.f1305j) {
                        if (!this.f1322e.f1305j && this.f1321d == aVar) {
                            d dVar4 = this.b;
                            if (dVar4.f1281l == 0 && !dVar4.w()) {
                                int i19 = this.f1325h.f1307l.get(0).f1302g;
                                f fVar10 = this.f1325h;
                                int i20 = i19 + fVar10.f1301f;
                                int i21 = this.f1326i.f1307l.get(0).f1302g + this.f1326i.f1301f;
                                fVar10.c(i20);
                                this.f1326i.c(i21);
                                this.f1322e.c(i21 - i20);
                                return;
                            }
                        }
                        if (!this.f1322e.f1305j && this.f1321d == aVar && this.a == 1 && this.f1325h.f1307l.size() > 0 && this.f1326i.f1307l.size() > 0) {
                            int min = Math.min((this.f1326i.f1307l.get(0).f1302g + this.f1326i.f1301f) - (this.f1325h.f1307l.get(0).f1302g + this.f1325h.f1301f), this.f1322e.m);
                            d dVar5 = this.b;
                            int i22 = dVar5.p;
                            int max = Math.max(dVar5.o, min);
                            if (i22 > 0) {
                                max = Math.min(i22, max);
                            }
                            this.f1322e.c(max);
                        }
                        if (this.f1322e.f1305j) {
                            f fVar11 = this.f1325h.f1307l.get(0);
                            f fVar12 = this.f1326i.f1307l.get(0);
                            int i23 = fVar11.f1302g;
                            f fVar13 = this.f1325h;
                            int i24 = fVar13.f1301f + i23;
                            int i25 = fVar12.f1302g;
                            int i26 = this.f1326i.f1301f + i25;
                            float f11 = this.b.Z;
                            if (fVar11 == fVar12) {
                                f11 = 0.5f;
                            } else {
                                i23 = i24;
                                i25 = i26;
                            }
                            fVar13.c((int) ((((float) ((i25 - i23) - this.f1322e.f1302g)) * f11) + ((float) i23) + 0.5f));
                            this.f1326i.c(this.f1325h.f1302g + this.f1322e.f1302g);
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
        d dVar6 = this.b;
        l(dVar6.D, dVar6.F, 0);
    }

    @Override // e.g.b.h.l.o
    public void d() {
        c cVar;
        f fVar;
        d dVar;
        d dVar2;
        List<d> list;
        f fVar2;
        int i2;
        f fVar3;
        f fVar4;
        d dVar3;
        d dVar4;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        d.a aVar2 = d.a.MATCH_PARENT;
        d.a aVar3 = d.a.FIXED;
        d dVar5 = this.b;
        if (dVar5.a) {
            this.f1322e.c(dVar5.r());
        }
        if (!this.f1322e.f1305j) {
            d.a m = this.b.m();
            this.f1321d = m;
            if (m != aVar) {
                if (m == aVar2 && (((dVar4 = this.b.P) != null && dVar4.m() == aVar3) || dVar4.m() == aVar2)) {
                    int r = (dVar4.r() - this.b.D.d()) - this.b.F.d();
                    b(this.f1325h, dVar4.f1273d.f1325h, this.b.D.d());
                    b(this.f1326i, dVar4.f1273d.f1326i, -this.b.F.d());
                    this.f1322e.c(r);
                    return;
                } else if (this.f1321d == aVar3) {
                    this.f1322e.c(this.b.r());
                }
            }
        } else if (this.f1321d == aVar2 && (((dVar3 = this.b.P) != null && dVar3.m() == aVar3) || dVar3.m() == aVar2)) {
            b(this.f1325h, dVar3.f1273d.f1325h, this.b.D.d());
            b(this.f1326i, dVar3.f1273d.f1326i, -this.b.F.d());
            return;
        }
        g gVar = this.f1322e;
        if (gVar.f1305j) {
            d dVar6 = this.b;
            if (dVar6.a) {
                c[] cVarArr = dVar6.L;
                if (cVarArr[0].f1261f == null || cVarArr[1].f1261f == null) {
                    if (cVarArr[0].f1261f != null) {
                        f h2 = h(cVarArr[0]);
                        if (h2 != null) {
                            f fVar5 = this.f1325h;
                            int d2 = this.b.L[0].d();
                            fVar5.f1307l.add(h2);
                            fVar5.f1301f = d2;
                            h2.f1306k.add(fVar5);
                        } else {
                            return;
                        }
                    } else if (cVarArr[1].f1261f != null) {
                        f h3 = h(cVarArr[1]);
                        if (h3 != null) {
                            f fVar6 = this.f1326i;
                            fVar6.f1307l.add(h3);
                            fVar6.f1301f = -this.b.L[1].d();
                            h3.f1306k.add(fVar6);
                            fVar4 = this.f1325h;
                            fVar3 = this.f1326i;
                            i2 = -this.f1322e.f1302g;
                            b(fVar4, fVar3, i2);
                            return;
                        }
                        return;
                    } else if (!(dVar6 instanceof g) && dVar6.P != null && dVar6.i(c.a.CENTER).f1261f == null) {
                        d dVar7 = this.b;
                        b(this.f1325h, dVar7.P.f1273d.f1325h, dVar7.s());
                    } else {
                        return;
                    }
                    fVar4 = this.f1326i;
                    fVar3 = this.f1325h;
                    i2 = this.f1322e.f1302g;
                    b(fVar4, fVar3, i2);
                    return;
                } else if (dVar6.w()) {
                    this.f1325h.f1301f = this.b.L[0].d();
                    fVar = this.f1326i;
                    cVar = this.b.L[1];
                    fVar.f1301f = -cVar.d();
                } else {
                    f h4 = h(this.b.L[0]);
                    if (h4 != null) {
                        f fVar7 = this.f1325h;
                        int d3 = this.b.L[0].d();
                        fVar7.f1307l.add(h4);
                        fVar7.f1301f = d3;
                        h4.f1306k.add(fVar7);
                    }
                    f h5 = h(this.b.L[1]);
                    if (h5 != null) {
                        f fVar8 = this.f1326i;
                        fVar8.f1307l.add(h5);
                        fVar8.f1301f = -this.b.L[1].d();
                        h5.f1306k.add(fVar8);
                    }
                    this.f1325h.b = true;
                    this.f1326i.b = true;
                    return;
                }
            }
        }
        if (this.f1321d == aVar) {
            d dVar8 = this.b;
            int i3 = dVar8.f1281l;
            if (i3 == 2) {
                d dVar9 = dVar8.P;
                if (dVar9 != null) {
                    g gVar2 = dVar9.f1274e.f1322e;
                    gVar.f1307l.add(gVar2);
                    gVar2.f1306k.add(this.f1322e);
                    g gVar3 = this.f1322e;
                    gVar3.b = true;
                    gVar3.f1306k.add(this.f1325h);
                    list = this.f1322e.f1306k;
                    dVar2 = this.f1326i;
                }
            } else if (i3 == 3) {
                if (dVar8.m == 3) {
                    this.f1325h.a = this;
                    this.f1326i.a = this;
                    m mVar = dVar8.f1274e;
                    mVar.f1325h.a = this;
                    mVar.f1326i.a = this;
                    gVar.a = this;
                    if (dVar8.x()) {
                        this.f1322e.f1307l.add(this.b.f1274e.f1322e);
                        this.b.f1274e.f1322e.f1306k.add(this.f1322e);
                        m mVar2 = this.b.f1274e;
                        mVar2.f1322e.a = this;
                        this.f1322e.f1307l.add(mVar2.f1325h);
                        this.f1322e.f1307l.add(this.b.f1274e.f1326i);
                        this.b.f1274e.f1325h.f1306k.add(this.f1322e);
                        list = this.b.f1274e.f1326i.f1306k;
                        dVar2 = this.f1322e;
                    } else if (this.b.w()) {
                        this.b.f1274e.f1322e.f1307l.add(this.f1322e);
                        list = this.f1322e.f1306k;
                        dVar2 = this.b.f1274e.f1322e;
                    } else {
                        fVar2 = this.b.f1274e.f1322e;
                    }
                } else {
                    g gVar4 = dVar8.f1274e.f1322e;
                    gVar.f1307l.add(gVar4);
                    gVar4.f1306k.add(this.f1322e);
                    this.b.f1274e.f1325h.f1306k.add(this.f1322e);
                    this.b.f1274e.f1326i.f1306k.add(this.f1322e);
                    g gVar5 = this.f1322e;
                    gVar5.b = true;
                    gVar5.f1306k.add(this.f1325h);
                    this.f1322e.f1306k.add(this.f1326i);
                    this.f1325h.f1307l.add(this.f1322e);
                    fVar2 = this.f1326i;
                }
                list = fVar2.f1307l;
                dVar2 = this.f1322e;
            }
            list.add(dVar2);
        }
        d dVar10 = this.b;
        c[] cVarArr2 = dVar10.L;
        if (cVarArr2[0].f1261f == null || cVarArr2[1].f1261f == null) {
            if (cVarArr2[0].f1261f != null) {
                f h6 = h(cVarArr2[0]);
                if (h6 != null) {
                    f fVar9 = this.f1325h;
                    int d4 = this.b.L[0].d();
                    fVar9.f1307l.add(h6);
                    fVar9.f1301f = d4;
                    h6.f1306k.add(fVar9);
                } else {
                    return;
                }
            } else if (cVarArr2[1].f1261f != null) {
                f h7 = h(cVarArr2[1]);
                if (h7 != null) {
                    f fVar10 = this.f1326i;
                    fVar10.f1307l.add(h7);
                    fVar10.f1301f = -this.b.L[1].d();
                    h7.f1306k.add(fVar10);
                    c(this.f1325h, this.f1326i, -1, this.f1322e);
                    return;
                }
                return;
            } else if (!(dVar10 instanceof g) && (dVar = dVar10.P) != null) {
                b(this.f1325h, dVar.f1273d.f1325h, dVar10.s());
            } else {
                return;
            }
            c(this.f1326i, this.f1325h, 1, this.f1322e);
        } else if (dVar10.w()) {
            this.f1325h.f1301f = this.b.L[0].d();
            fVar = this.f1326i;
            cVar = this.b.L[1];
            fVar.f1301f = -cVar.d();
        } else {
            f h8 = h(this.b.L[0]);
            f h9 = h(this.b.L[1]);
            h8.f1306k.add(this);
            if (h8.f1305j) {
                a(this);
            }
            h9.f1306k.add(this);
            if (h9.f1305j) {
                a(this);
            }
            this.f1327j = o.a.CENTER;
        }
    }

    @Override // e.g.b.h.l.o
    public void e() {
        f fVar = this.f1325h;
        if (fVar.f1305j) {
            this.b.U = fVar.f1302g;
        }
    }

    @Override // e.g.b.h.l.o
    public void f() {
        this.c = null;
        this.f1325h.b();
        this.f1326i.b();
        this.f1322e.b();
        this.f1324g = false;
    }

    @Override // e.g.b.h.l.o
    public boolean k() {
        return this.f1321d != d.a.MATCH_CONSTRAINT || this.b.f1281l == 0;
    }

    public final void m(int[] iArr, int i2, int i3, int i4, int i5, float f2, int i6) {
        int i7 = i3 - i2;
        int i8 = i5 - i4;
        if (i6 == -1) {
            int i9 = (int) ((((float) i8) * f2) + 0.5f);
            int i10 = (int) ((((float) i7) / f2) + 0.5f);
            if (i9 <= i7 && i8 <= i8) {
                iArr[0] = i9;
                iArr[1] = i8;
            } else if (i7 <= i7 && i10 <= i8) {
                iArr[0] = i7;
                iArr[1] = i10;
            }
        } else if (i6 == 0) {
            iArr[0] = (int) ((((float) i8) * f2) + 0.5f);
            iArr[1] = i8;
        } else if (i6 == 1) {
            iArr[0] = i7;
            iArr[1] = (int) ((((float) i7) * f2) + 0.5f);
        }
    }

    public void n() {
        this.f1324g = false;
        this.f1325h.b();
        this.f1325h.f1305j = false;
        this.f1326i.b();
        this.f1326i.f1305j = false;
        this.f1322e.f1305j = false;
    }

    public String toString() {
        StringBuilder h2 = a.h("HorizontalRun ");
        h2.append(this.b.d0);
        return h2.toString();
    }
}
