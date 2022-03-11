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
    public static int[] f1328k = new int[2];

    public k(d dVar) {
        super(dVar);
        this.f1338h.f1313e = f.a.LEFT;
        this.f1339i.f1313e = f.a.RIGHT;
        this.f1336f = 0;
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
        int[] iArr = f1328k;
        int ordinal = this.f1340j.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            g gVar = this.f1335e;
            if (!gVar.f1318j && this.f1334d == aVar) {
                d dVar2 = this.b;
                int i7 = dVar2.f1294l;
                if (i7 == 2) {
                    d dVar3 = dVar2.P;
                    if (dVar3 != null) {
                        g gVar2 = dVar3.f1286d.f1335e;
                        if (gVar2.f1318j) {
                            f3 = dVar2.q;
                            f4 = (float) gVar2.f1315g;
                        }
                    }
                } else if (i7 == 3) {
                    int i8 = dVar2.m;
                    if (i8 == 0 || i8 == 3) {
                        m mVar = dVar2.f1287e;
                        f fVar2 = mVar.f1338h;
                        f fVar3 = mVar.f1339i;
                        boolean z = dVar2.D.f1274f != null;
                        boolean z2 = dVar2.E.f1274f != null;
                        boolean z3 = dVar2.F.f1274f != null;
                        boolean z4 = dVar2.G.f1274f != null;
                        int i9 = dVar2.T;
                        if (z && z2 && z3 && z4) {
                            float f8 = dVar2.S;
                            if (!fVar2.f1318j || !fVar3.f1318j) {
                                f fVar4 = this.f1338h;
                                if (fVar4.f1318j) {
                                    f fVar5 = this.f1339i;
                                    if (fVar5.f1318j) {
                                        if (fVar2.c && fVar3.c) {
                                            f7 = f8;
                                            i6 = i9;
                                            m(iArr, fVar4.f1315g + fVar4.f1314f, fVar5.f1315g - fVar5.f1314f, fVar2.f1320l.get(0).f1315g + fVar2.f1314f, fVar3.f1320l.get(0).f1315g - fVar3.f1314f, f8, i9);
                                            this.f1335e.c(iArr[0]);
                                            this.b.f1287e.f1335e.c(iArr[1]);
                                            fVar = this.f1338h;
                                            if (fVar.c && this.f1339i.c && fVar2.c && fVar3.c) {
                                                m(iArr, fVar.f1320l.get(0).f1315g + this.f1338h.f1314f, this.f1339i.f1320l.get(0).f1315g - this.f1339i.f1314f, fVar2.f1320l.get(0).f1315g + fVar2.f1314f, fVar3.f1320l.get(0).f1315g - fVar3.f1314f, f7, i6);
                                                this.f1335e.c(iArr[0]);
                                                gVar = this.b.f1287e.f1335e;
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
                                fVar = this.f1338h;
                                if (fVar.c) {
                                    return;
                                }
                                return;
                            }
                            f fVar6 = this.f1338h;
                            if (fVar6.c && this.f1339i.c) {
                                m(iArr, fVar6.f1320l.get(0).f1315g + this.f1338h.f1314f, this.f1339i.f1320l.get(0).f1315g - this.f1339i.f1314f, fVar2.f1315g + fVar2.f1314f, fVar3.f1315g - fVar3.f1314f, f8, i9);
                                this.f1335e.c(iArr[0]);
                                this.b.f1287e.f1335e.c(iArr[1]);
                                return;
                            }
                            return;
                        } else if (z && z3) {
                            f fVar7 = this.f1338h;
                            if (fVar7.c && this.f1339i.c) {
                                float f9 = dVar2.S;
                                int i10 = fVar7.f1320l.get(0).f1315g + this.f1338h.f1314f;
                                int i11 = this.f1339i.f1320l.get(0).f1315g - this.f1339i.f1314f;
                                if (i9 == -1 || i9 == 0) {
                                    i5 = g(i11 - i10, 0);
                                    int i12 = (int) ((((float) i5) * f9) + 0.5f);
                                    i4 = g(i12, 1);
                                    if (i12 != i4) {
                                        f6 = ((float) i4) / f9;
                                    }
                                    this.f1335e.c(i5);
                                    this.b.f1287e.f1335e.c(i4);
                                } else if (i9 == 1) {
                                    i5 = g(i11 - i10, 0);
                                    int i13 = (int) ((((float) i5) / f9) + 0.5f);
                                    i4 = g(i13, 1);
                                    if (i13 != i4) {
                                        f6 = ((float) i4) * f9;
                                    }
                                    this.f1335e.c(i5);
                                    this.b.f1287e.f1335e.c(i4);
                                }
                                i5 = (int) (f6 + 0.5f);
                                this.f1335e.c(i5);
                                this.b.f1287e.f1335e.c(i4);
                            } else {
                                return;
                            }
                        } else if (z2 && z4) {
                            if (fVar2.c && fVar3.c) {
                                float f10 = dVar2.S;
                                int i14 = fVar2.f1320l.get(0).f1315g + fVar2.f1314f;
                                int i15 = fVar3.f1320l.get(0).f1315g - fVar3.f1314f;
                                if (i9 != -1) {
                                    if (i9 == 0) {
                                        i2 = g(i15 - i14, 1);
                                        int i16 = (int) ((((float) i2) * f10) + 0.5f);
                                        i3 = g(i16, 0);
                                        if (i16 != i3) {
                                            f5 = ((float) i3) / f10;
                                            i2 = (int) (f5 + 0.5f);
                                        }
                                        this.f1335e.c(i3);
                                        gVar = this.b.f1287e.f1335e;
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
                                this.f1335e.c(i3);
                                gVar = this.b.f1287e.f1335e;
                                gVar.c(i2);
                            } else {
                                return;
                            }
                        }
                    } else {
                        int i18 = dVar2.T;
                        if (i18 != -1) {
                            if (i18 == 0) {
                                f2 = ((float) dVar2.f1287e.f1335e.f1315g) / dVar2.S;
                                i2 = (int) (f2 + 0.5f);
                                gVar.c(i2);
                            } else if (i18 != 1) {
                                i2 = 0;
                                gVar.c(i2);
                            }
                        }
                        f4 = (float) dVar2.f1287e.f1335e.f1315g;
                        f3 = dVar2.S;
                    }
                }
                f2 = f4 * f3;
                i2 = (int) (f2 + 0.5f);
                gVar.c(i2);
            }
            f fVar8 = this.f1338h;
            if (fVar8.c) {
                f fVar9 = this.f1339i;
                if (fVar9.c) {
                    if (!fVar8.f1318j || !fVar9.f1318j || !this.f1335e.f1318j) {
                        if (!this.f1335e.f1318j && this.f1334d == aVar) {
                            d dVar4 = this.b;
                            if (dVar4.f1294l == 0 && !dVar4.w()) {
                                int i19 = this.f1338h.f1320l.get(0).f1315g;
                                f fVar10 = this.f1338h;
                                int i20 = i19 + fVar10.f1314f;
                                int i21 = this.f1339i.f1320l.get(0).f1315g + this.f1339i.f1314f;
                                fVar10.c(i20);
                                this.f1339i.c(i21);
                                this.f1335e.c(i21 - i20);
                                return;
                            }
                        }
                        if (!this.f1335e.f1318j && this.f1334d == aVar && this.a == 1 && this.f1338h.f1320l.size() > 0 && this.f1339i.f1320l.size() > 0) {
                            int min = Math.min((this.f1339i.f1320l.get(0).f1315g + this.f1339i.f1314f) - (this.f1338h.f1320l.get(0).f1315g + this.f1338h.f1314f), this.f1335e.m);
                            d dVar5 = this.b;
                            int i22 = dVar5.p;
                            int max = Math.max(dVar5.o, min);
                            if (i22 > 0) {
                                max = Math.min(i22, max);
                            }
                            this.f1335e.c(max);
                        }
                        if (this.f1335e.f1318j) {
                            f fVar11 = this.f1338h.f1320l.get(0);
                            f fVar12 = this.f1339i.f1320l.get(0);
                            int i23 = fVar11.f1315g;
                            f fVar13 = this.f1338h;
                            int i24 = fVar13.f1314f + i23;
                            int i25 = fVar12.f1315g;
                            int i26 = this.f1339i.f1314f + i25;
                            float f11 = this.b.Z;
                            if (fVar11 == fVar12) {
                                f11 = 0.5f;
                            } else {
                                i23 = i24;
                                i25 = i26;
                            }
                            fVar13.c((int) ((((float) ((i25 - i23) - this.f1335e.f1315g)) * f11) + ((float) i23) + 0.5f));
                            this.f1339i.c(this.f1338h.f1315g + this.f1335e.f1315g);
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
            this.f1335e.c(dVar5.r());
        }
        if (!this.f1335e.f1318j) {
            d.a m = this.b.m();
            this.f1334d = m;
            if (m != aVar) {
                if (m == aVar2 && (((dVar4 = this.b.P) != null && dVar4.m() == aVar3) || dVar4.m() == aVar2)) {
                    int r = (dVar4.r() - this.b.D.d()) - this.b.F.d();
                    b(this.f1338h, dVar4.f1286d.f1338h, this.b.D.d());
                    b(this.f1339i, dVar4.f1286d.f1339i, -this.b.F.d());
                    this.f1335e.c(r);
                    return;
                } else if (this.f1334d == aVar3) {
                    this.f1335e.c(this.b.r());
                }
            }
        } else if (this.f1334d == aVar2 && (((dVar3 = this.b.P) != null && dVar3.m() == aVar3) || dVar3.m() == aVar2)) {
            b(this.f1338h, dVar3.f1286d.f1338h, this.b.D.d());
            b(this.f1339i, dVar3.f1286d.f1339i, -this.b.F.d());
            return;
        }
        g gVar = this.f1335e;
        if (gVar.f1318j) {
            d dVar6 = this.b;
            if (dVar6.a) {
                c[] cVarArr = dVar6.L;
                if (cVarArr[0].f1274f == null || cVarArr[1].f1274f == null) {
                    if (cVarArr[0].f1274f != null) {
                        f h2 = h(cVarArr[0]);
                        if (h2 != null) {
                            f fVar5 = this.f1338h;
                            int d2 = this.b.L[0].d();
                            fVar5.f1320l.add(h2);
                            fVar5.f1314f = d2;
                            h2.f1319k.add(fVar5);
                        } else {
                            return;
                        }
                    } else if (cVarArr[1].f1274f != null) {
                        f h3 = h(cVarArr[1]);
                        if (h3 != null) {
                            f fVar6 = this.f1339i;
                            fVar6.f1320l.add(h3);
                            fVar6.f1314f = -this.b.L[1].d();
                            h3.f1319k.add(fVar6);
                            fVar4 = this.f1338h;
                            fVar3 = this.f1339i;
                            i2 = -this.f1335e.f1315g;
                            b(fVar4, fVar3, i2);
                            return;
                        }
                        return;
                    } else if (!(dVar6 instanceof g) && dVar6.P != null && dVar6.i(c.a.CENTER).f1274f == null) {
                        d dVar7 = this.b;
                        b(this.f1338h, dVar7.P.f1286d.f1338h, dVar7.s());
                    } else {
                        return;
                    }
                    fVar4 = this.f1339i;
                    fVar3 = this.f1338h;
                    i2 = this.f1335e.f1315g;
                    b(fVar4, fVar3, i2);
                    return;
                } else if (dVar6.w()) {
                    this.f1338h.f1314f = this.b.L[0].d();
                    fVar = this.f1339i;
                    cVar = this.b.L[1];
                    fVar.f1314f = -cVar.d();
                } else {
                    f h4 = h(this.b.L[0]);
                    if (h4 != null) {
                        f fVar7 = this.f1338h;
                        int d3 = this.b.L[0].d();
                        fVar7.f1320l.add(h4);
                        fVar7.f1314f = d3;
                        h4.f1319k.add(fVar7);
                    }
                    f h5 = h(this.b.L[1]);
                    if (h5 != null) {
                        f fVar8 = this.f1339i;
                        fVar8.f1320l.add(h5);
                        fVar8.f1314f = -this.b.L[1].d();
                        h5.f1319k.add(fVar8);
                    }
                    this.f1338h.b = true;
                    this.f1339i.b = true;
                    return;
                }
            }
        }
        if (this.f1334d == aVar) {
            d dVar8 = this.b;
            int i3 = dVar8.f1294l;
            if (i3 == 2) {
                d dVar9 = dVar8.P;
                if (dVar9 != null) {
                    g gVar2 = dVar9.f1287e.f1335e;
                    gVar.f1320l.add(gVar2);
                    gVar2.f1319k.add(this.f1335e);
                    g gVar3 = this.f1335e;
                    gVar3.b = true;
                    gVar3.f1319k.add(this.f1338h);
                    list = this.f1335e.f1319k;
                    dVar2 = this.f1339i;
                }
            } else if (i3 == 3) {
                if (dVar8.m == 3) {
                    this.f1338h.a = this;
                    this.f1339i.a = this;
                    m mVar = dVar8.f1287e;
                    mVar.f1338h.a = this;
                    mVar.f1339i.a = this;
                    gVar.a = this;
                    if (dVar8.x()) {
                        this.f1335e.f1320l.add(this.b.f1287e.f1335e);
                        this.b.f1287e.f1335e.f1319k.add(this.f1335e);
                        m mVar2 = this.b.f1287e;
                        mVar2.f1335e.a = this;
                        this.f1335e.f1320l.add(mVar2.f1338h);
                        this.f1335e.f1320l.add(this.b.f1287e.f1339i);
                        this.b.f1287e.f1338h.f1319k.add(this.f1335e);
                        list = this.b.f1287e.f1339i.f1319k;
                        dVar2 = this.f1335e;
                    } else if (this.b.w()) {
                        this.b.f1287e.f1335e.f1320l.add(this.f1335e);
                        list = this.f1335e.f1319k;
                        dVar2 = this.b.f1287e.f1335e;
                    } else {
                        fVar2 = this.b.f1287e.f1335e;
                    }
                } else {
                    g gVar4 = dVar8.f1287e.f1335e;
                    gVar.f1320l.add(gVar4);
                    gVar4.f1319k.add(this.f1335e);
                    this.b.f1287e.f1338h.f1319k.add(this.f1335e);
                    this.b.f1287e.f1339i.f1319k.add(this.f1335e);
                    g gVar5 = this.f1335e;
                    gVar5.b = true;
                    gVar5.f1319k.add(this.f1338h);
                    this.f1335e.f1319k.add(this.f1339i);
                    this.f1338h.f1320l.add(this.f1335e);
                    fVar2 = this.f1339i;
                }
                list = fVar2.f1320l;
                dVar2 = this.f1335e;
            }
            list.add(dVar2);
        }
        d dVar10 = this.b;
        c[] cVarArr2 = dVar10.L;
        if (cVarArr2[0].f1274f == null || cVarArr2[1].f1274f == null) {
            if (cVarArr2[0].f1274f != null) {
                f h6 = h(cVarArr2[0]);
                if (h6 != null) {
                    f fVar9 = this.f1338h;
                    int d4 = this.b.L[0].d();
                    fVar9.f1320l.add(h6);
                    fVar9.f1314f = d4;
                    h6.f1319k.add(fVar9);
                } else {
                    return;
                }
            } else if (cVarArr2[1].f1274f != null) {
                f h7 = h(cVarArr2[1]);
                if (h7 != null) {
                    f fVar10 = this.f1339i;
                    fVar10.f1320l.add(h7);
                    fVar10.f1314f = -this.b.L[1].d();
                    h7.f1319k.add(fVar10);
                    c(this.f1338h, this.f1339i, -1, this.f1335e);
                    return;
                }
                return;
            } else if (!(dVar10 instanceof g) && (dVar = dVar10.P) != null) {
                b(this.f1338h, dVar.f1286d.f1338h, dVar10.s());
            } else {
                return;
            }
            c(this.f1339i, this.f1338h, 1, this.f1335e);
        } else if (dVar10.w()) {
            this.f1338h.f1314f = this.b.L[0].d();
            fVar = this.f1339i;
            cVar = this.b.L[1];
            fVar.f1314f = -cVar.d();
        } else {
            f h8 = h(this.b.L[0]);
            f h9 = h(this.b.L[1]);
            h8.f1319k.add(this);
            if (h8.f1318j) {
                a(this);
            }
            h9.f1319k.add(this);
            if (h9.f1318j) {
                a(this);
            }
            this.f1340j = o.a.CENTER;
        }
    }

    @Override // e.g.b.h.l.o
    public void e() {
        f fVar = this.f1338h;
        if (fVar.f1318j) {
            this.b.U = fVar.f1315g;
        }
    }

    @Override // e.g.b.h.l.o
    public void f() {
        this.c = null;
        this.f1338h.b();
        this.f1339i.b();
        this.f1335e.b();
        this.f1337g = false;
    }

    @Override // e.g.b.h.l.o
    public boolean k() {
        return this.f1334d != d.a.MATCH_CONSTRAINT || this.b.f1294l == 0;
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
        this.f1337g = false;
        this.f1338h.b();
        this.f1338h.f1318j = false;
        this.f1339i.b();
        this.f1339i.f1318j = false;
        this.f1335e.f1318j = false;
    }

    public String toString() {
        StringBuilder h2 = a.h("HorizontalRun ");
        h2.append(this.b.d0);
        return h2.toString();
    }
}
