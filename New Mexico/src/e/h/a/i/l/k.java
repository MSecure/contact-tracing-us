package e.h.a.i.l;

import e.h.a.i.c;
import e.h.a.i.d;
import e.h.a.i.g;
import e.h.a.i.l.f;
import e.h.a.i.l.o;
import f.a.a.a.a;
import java.util.List;
/* loaded from: classes.dex */
public class k extends o {

    /* renamed from: k */
    public static int[] f1433k = new int[2];

    public k(d dVar) {
        super(dVar);
        this.f1443h.f1418e = f.a.LEFT;
        this.f1444i.f1418e = f.a.RIGHT;
        this.f1441f = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x026c, code lost:
        if (r15 != 1) goto L_0x02bc;
     */
    @Override // e.h.a.i.l.o, e.h.a.i.l.d
    /* Code decompiled incorrectly, please refer to instructions dump */
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
        float f7;
        f fVar;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        int ordinal = this.f1445j.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            g gVar = this.f1440e;
            if (!gVar.f1423j && this.f1439d == aVar) {
                d dVar2 = this.b;
                int i6 = dVar2.q;
                if (i6 == 2) {
                    d dVar3 = dVar2.U;
                    if (dVar3 != null) {
                        g gVar2 = dVar3.f1391d.f1440e;
                        if (gVar2.f1423j) {
                            f3 = dVar2.v;
                            f4 = (float) gVar2.f1420g;
                            f2 = f4 * f3;
                        }
                    }
                } else if (i6 == 3) {
                    int i7 = dVar2.r;
                    if (i7 == 0 || i7 == 3) {
                        m mVar = dVar2.f1392e;
                        f fVar2 = mVar.f1443h;
                        f fVar3 = mVar.f1444i;
                        boolean z = dVar2.I.f1379f != null;
                        boolean z2 = dVar2.J.f1379f != null;
                        boolean z3 = dVar2.K.f1379f != null;
                        boolean z4 = dVar2.L.f1379f != null;
                        int i8 = dVar2.Y;
                        if (z && z2 && z3 && z4) {
                            float f8 = dVar2.X;
                            if (!fVar2.f1423j || !fVar3.f1423j) {
                                f fVar4 = this.f1443h;
                                if (fVar4.f1423j) {
                                    f fVar5 = this.f1444i;
                                    if (fVar5.f1423j) {
                                        if (fVar2.c && fVar3.c) {
                                            f7 = f8;
                                            m(f1433k, fVar4.f1420g + fVar4.f1419f, fVar5.f1420g - fVar5.f1419f, fVar2.f1425l.get(0).f1420g + fVar2.f1419f, fVar3.f1425l.get(0).f1420g - fVar3.f1419f, f8, i8);
                                            this.f1440e.c(f1433k[0]);
                                            this.b.f1392e.f1440e.c(f1433k[1]);
                                            fVar = this.f1443h;
                                            if (fVar.c && this.f1444i.c && fVar2.c && fVar3.c) {
                                                m(f1433k, fVar.f1425l.get(0).f1420g + this.f1443h.f1419f, this.f1444i.f1425l.get(0).f1420g - this.f1444i.f1419f, fVar2.f1425l.get(0).f1420g + fVar2.f1419f, fVar3.f1425l.get(0).f1420g - fVar3.f1419f, f7, i8);
                                                this.f1440e.c(f1433k[0]);
                                                gVar = this.b.f1392e.f1440e;
                                                i2 = f1433k[1];
                                            } else {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                f7 = f8;
                                fVar = this.f1443h;
                                if (fVar.c) {
                                    return;
                                }
                                return;
                            }
                            f fVar6 = this.f1443h;
                            if (fVar6.c && this.f1444i.c) {
                                m(f1433k, fVar6.f1425l.get(0).f1420g + this.f1443h.f1419f, this.f1444i.f1425l.get(0).f1420g - this.f1444i.f1419f, fVar2.f1420g + fVar2.f1419f, fVar3.f1420g - fVar3.f1419f, f8, i8);
                                this.f1440e.c(f1433k[0]);
                                this.b.f1392e.f1440e.c(f1433k[1]);
                                return;
                            }
                            return;
                        } else if (z && z3) {
                            f fVar7 = this.f1443h;
                            if (fVar7.c && this.f1444i.c) {
                                float f9 = dVar2.X;
                                int i9 = fVar7.f1425l.get(0).f1420g + this.f1443h.f1419f;
                                int i10 = this.f1444i.f1425l.get(0).f1420g - this.f1444i.f1419f;
                                if (i8 == -1 || i8 == 0) {
                                    i5 = g(i10 - i9, 0);
                                    int i11 = (int) ((((float) i5) * f9) + 0.5f);
                                    i4 = g(i11, 1);
                                    if (i11 != i4) {
                                        f6 = ((float) i4) / f9;
                                        i5 = (int) (f6 + 0.5f);
                                    }
                                    this.f1440e.c(i5);
                                    this.b.f1392e.f1440e.c(i4);
                                } else if (i8 == 1) {
                                    i5 = g(i10 - i9, 0);
                                    int i12 = (int) ((((float) i5) / f9) + 0.5f);
                                    i4 = g(i12, 1);
                                    if (i12 != i4) {
                                        f6 = ((float) i4) * f9;
                                        i5 = (int) (f6 + 0.5f);
                                    }
                                    this.f1440e.c(i5);
                                    this.b.f1392e.f1440e.c(i4);
                                }
                            } else {
                                return;
                            }
                        } else if (z2 && z4) {
                            if (fVar2.c && fVar3.c) {
                                float f10 = dVar2.X;
                                int i13 = fVar2.f1425l.get(0).f1420g + fVar2.f1419f;
                                int i14 = fVar3.f1425l.get(0).f1420g - fVar3.f1419f;
                                if (i8 != -1) {
                                    if (i8 == 0) {
                                        i2 = g(i14 - i13, 1);
                                        int i15 = (int) ((((float) i2) * f10) + 0.5f);
                                        i3 = g(i15, 0);
                                        if (i15 != i3) {
                                            f5 = ((float) i3) / f10;
                                            i2 = (int) (f5 + 0.5f);
                                        }
                                        this.f1440e.c(i3);
                                        gVar = this.b.f1392e.f1440e;
                                    }
                                }
                                i2 = g(i14 - i13, 1);
                                int i16 = (int) ((((float) i2) / f10) + 0.5f);
                                i3 = g(i16, 0);
                                if (i16 != i3) {
                                    f5 = ((float) i3) * f10;
                                    i2 = (int) (f5 + 0.5f);
                                }
                                this.f1440e.c(i3);
                                gVar = this.b.f1392e.f1440e;
                            } else {
                                return;
                            }
                        }
                    } else {
                        int i17 = dVar2.Y;
                        if (i17 != -1) {
                            if (i17 == 0) {
                                f2 = ((float) dVar2.f1392e.f1440e.f1420g) / dVar2.X;
                            } else if (i17 != 1) {
                                i2 = 0;
                            }
                        }
                        f4 = (float) dVar2.f1392e.f1440e.f1420g;
                        f3 = dVar2.X;
                        f2 = f4 * f3;
                    }
                    gVar.c(i2);
                }
                i2 = (int) (f2 + 0.5f);
                gVar.c(i2);
            }
            f fVar8 = this.f1443h;
            if (fVar8.c) {
                f fVar9 = this.f1444i;
                if (fVar9.c) {
                    if (!fVar8.f1423j || !fVar9.f1423j || !this.f1440e.f1423j) {
                        if (!this.f1440e.f1423j && this.f1439d == aVar) {
                            d dVar4 = this.b;
                            if (dVar4.q == 0 && !dVar4.x()) {
                                int i18 = this.f1443h.f1425l.get(0).f1420g;
                                f fVar10 = this.f1443h;
                                int i19 = i18 + fVar10.f1419f;
                                int i20 = this.f1444i.f1425l.get(0).f1420g + this.f1444i.f1419f;
                                fVar10.c(i19);
                                this.f1444i.c(i20);
                                this.f1440e.c(i20 - i19);
                                return;
                            }
                        }
                        if (!this.f1440e.f1423j && this.f1439d == aVar && this.a == 1 && this.f1443h.f1425l.size() > 0 && this.f1444i.f1425l.size() > 0) {
                            int min = Math.min((this.f1444i.f1425l.get(0).f1420g + this.f1444i.f1419f) - (this.f1443h.f1425l.get(0).f1420g + this.f1443h.f1419f), this.f1440e.m);
                            d dVar5 = this.b;
                            int i21 = dVar5.u;
                            int max = Math.max(dVar5.t, min);
                            if (i21 > 0) {
                                max = Math.min(i21, max);
                            }
                            this.f1440e.c(max);
                        }
                        if (this.f1440e.f1423j) {
                            f fVar11 = this.f1443h.f1425l.get(0);
                            f fVar12 = this.f1444i.f1425l.get(0);
                            int i22 = fVar11.f1420g;
                            f fVar13 = this.f1443h;
                            int i23 = fVar13.f1419f + i22;
                            int i24 = fVar12.f1420g;
                            int i25 = this.f1444i.f1419f + i24;
                            float f11 = this.b.e0;
                            if (fVar11 == fVar12) {
                                f11 = 0.5f;
                            } else {
                                i22 = i23;
                                i24 = i25;
                            }
                            fVar13.c((int) ((((float) ((i24 - i22) - this.f1440e.f1420g)) * f11) + ((float) i22) + 0.5f));
                            this.f1444i.c(this.f1443h.f1420g + this.f1440e.f1420g);
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
        l(dVar6.I, dVar6.K, 0);
    }

    @Override // e.h.a.i.l.o
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
            this.f1440e.c(dVar5.r());
        }
        if (!this.f1440e.f1423j) {
            d.a m = this.b.m();
            this.f1439d = m;
            if (m != aVar) {
                if (m == aVar2 && (dVar4 = this.b.U) != null && (dVar4.m() == aVar3 || dVar4.m() == aVar2)) {
                    int r = (dVar4.r() - this.b.I.d()) - this.b.K.d();
                    b(this.f1443h, dVar4.f1391d.f1443h, this.b.I.d());
                    b(this.f1444i, dVar4.f1391d.f1444i, -this.b.K.d());
                    this.f1440e.c(r);
                    return;
                } else if (this.f1439d == aVar3) {
                    this.f1440e.c(this.b.r());
                }
            }
        } else if (this.f1439d == aVar2 && (dVar3 = this.b.U) != null && (dVar3.m() == aVar3 || dVar3.m() == aVar2)) {
            b(this.f1443h, dVar3.f1391d.f1443h, this.b.I.d());
            b(this.f1444i, dVar3.f1391d.f1444i, -this.b.K.d());
            return;
        }
        g gVar = this.f1440e;
        if (gVar.f1423j) {
            d dVar6 = this.b;
            if (dVar6.a) {
                c[] cVarArr = dVar6.Q;
                if (cVarArr[0].f1379f == null || cVarArr[1].f1379f == null) {
                    if (cVarArr[0].f1379f != null) {
                        f h2 = h(cVarArr[0]);
                        if (h2 != null) {
                            f fVar5 = this.f1443h;
                            int d2 = this.b.Q[0].d();
                            fVar5.f1425l.add(h2);
                            fVar5.f1419f = d2;
                            h2.f1424k.add(fVar5);
                        } else {
                            return;
                        }
                    } else if (cVarArr[1].f1379f != null) {
                        f h3 = h(cVarArr[1]);
                        if (h3 != null) {
                            f fVar6 = this.f1444i;
                            fVar6.f1425l.add(h3);
                            fVar6.f1419f = -this.b.Q[1].d();
                            h3.f1424k.add(fVar6);
                            fVar4 = this.f1443h;
                            fVar3 = this.f1444i;
                            i2 = -this.f1440e.f1420g;
                            b(fVar4, fVar3, i2);
                            return;
                        }
                        return;
                    } else if (!(dVar6 instanceof g) && dVar6.U != null && dVar6.i(c.a.CENTER).f1379f == null) {
                        d dVar7 = this.b;
                        b(this.f1443h, dVar7.U.f1391d.f1443h, dVar7.s());
                    } else {
                        return;
                    }
                    fVar4 = this.f1444i;
                    fVar3 = this.f1443h;
                    i2 = this.f1440e.f1420g;
                    b(fVar4, fVar3, i2);
                    return;
                } else if (dVar6.x()) {
                    this.f1443h.f1419f = this.b.Q[0].d();
                    fVar = this.f1444i;
                    cVar = this.b.Q[1];
                    fVar.f1419f = -cVar.d();
                } else {
                    f h4 = h(this.b.Q[0]);
                    if (h4 != null) {
                        f fVar7 = this.f1443h;
                        int d3 = this.b.Q[0].d();
                        fVar7.f1425l.add(h4);
                        fVar7.f1419f = d3;
                        h4.f1424k.add(fVar7);
                    }
                    f h5 = h(this.b.Q[1]);
                    if (h5 != null) {
                        f fVar8 = this.f1444i;
                        fVar8.f1425l.add(h5);
                        fVar8.f1419f = -this.b.Q[1].d();
                        h5.f1424k.add(fVar8);
                    }
                    this.f1443h.b = true;
                    this.f1444i.b = true;
                    return;
                }
            }
        }
        if (this.f1439d == aVar) {
            d dVar8 = this.b;
            int i3 = dVar8.q;
            if (i3 == 2) {
                d dVar9 = dVar8.U;
                if (dVar9 != null) {
                    g gVar2 = dVar9.f1392e.f1440e;
                    gVar.f1425l.add(gVar2);
                    gVar2.f1424k.add(this.f1440e);
                    g gVar3 = this.f1440e;
                    gVar3.b = true;
                    gVar3.f1424k.add(this.f1443h);
                    list = this.f1440e.f1424k;
                    dVar2 = this.f1444i;
                    list.add(dVar2);
                }
            } else if (i3 == 3) {
                if (dVar8.r == 3) {
                    this.f1443h.a = this;
                    this.f1444i.a = this;
                    m mVar = dVar8.f1392e;
                    mVar.f1443h.a = this;
                    mVar.f1444i.a = this;
                    gVar.a = this;
                    if (dVar8.y()) {
                        this.f1440e.f1425l.add(this.b.f1392e.f1440e);
                        this.b.f1392e.f1440e.f1424k.add(this.f1440e);
                        m mVar2 = this.b.f1392e;
                        mVar2.f1440e.a = this;
                        this.f1440e.f1425l.add(mVar2.f1443h);
                        this.f1440e.f1425l.add(this.b.f1392e.f1444i);
                        this.b.f1392e.f1443h.f1424k.add(this.f1440e);
                        list = this.b.f1392e.f1444i.f1424k;
                        dVar2 = this.f1440e;
                        list.add(dVar2);
                    } else if (this.b.x()) {
                        this.b.f1392e.f1440e.f1425l.add(this.f1440e);
                        list = this.f1440e.f1424k;
                        dVar2 = this.b.f1392e.f1440e;
                        list.add(dVar2);
                    } else {
                        fVar2 = this.b.f1392e.f1440e;
                    }
                } else {
                    g gVar4 = dVar8.f1392e.f1440e;
                    gVar.f1425l.add(gVar4);
                    gVar4.f1424k.add(this.f1440e);
                    this.b.f1392e.f1443h.f1424k.add(this.f1440e);
                    this.b.f1392e.f1444i.f1424k.add(this.f1440e);
                    g gVar5 = this.f1440e;
                    gVar5.b = true;
                    gVar5.f1424k.add(this.f1443h);
                    this.f1440e.f1424k.add(this.f1444i);
                    this.f1443h.f1425l.add(this.f1440e);
                    fVar2 = this.f1444i;
                }
                list = fVar2.f1425l;
                dVar2 = this.f1440e;
                list.add(dVar2);
            }
            fVar.f1419f = -cVar.d();
        }
        d dVar10 = this.b;
        c[] cVarArr2 = dVar10.Q;
        if (cVarArr2[0].f1379f == null || cVarArr2[1].f1379f == null) {
            if (cVarArr2[0].f1379f != null) {
                f h6 = h(cVarArr2[0]);
                if (h6 != null) {
                    f fVar9 = this.f1443h;
                    int d4 = this.b.Q[0].d();
                    fVar9.f1425l.add(h6);
                    fVar9.f1419f = d4;
                    h6.f1424k.add(fVar9);
                } else {
                    return;
                }
            } else if (cVarArr2[1].f1379f != null) {
                f h7 = h(cVarArr2[1]);
                if (h7 != null) {
                    f fVar10 = this.f1444i;
                    fVar10.f1425l.add(h7);
                    fVar10.f1419f = -this.b.Q[1].d();
                    h7.f1424k.add(fVar10);
                    c(this.f1443h, this.f1444i, -1, this.f1440e);
                    return;
                }
                return;
            } else if (!(dVar10 instanceof g) && (dVar = dVar10.U) != null) {
                b(this.f1443h, dVar.f1391d.f1443h, dVar10.s());
            } else {
                return;
            }
            c(this.f1444i, this.f1443h, 1, this.f1440e);
        } else if (dVar10.x()) {
            this.f1443h.f1419f = this.b.Q[0].d();
            fVar = this.f1444i;
            cVar = this.b.Q[1];
            fVar.f1419f = -cVar.d();
        } else {
            f h8 = h(this.b.Q[0]);
            f h9 = h(this.b.Q[1]);
            if (h8 != null) {
                h8.f1424k.add(this);
                if (h8.f1423j) {
                    a(this);
                }
            }
            if (h9 != null) {
                h9.f1424k.add(this);
                if (h9.f1423j) {
                    a(this);
                }
            }
            this.f1445j = o.a.CENTER;
        }
    }

    @Override // e.h.a.i.l.o
    public void e() {
        f fVar = this.f1443h;
        if (fVar.f1423j) {
            this.b.Z = fVar.f1420g;
        }
    }

    @Override // e.h.a.i.l.o
    public void f() {
        this.c = null;
        this.f1443h.b();
        this.f1444i.b();
        this.f1440e.b();
        this.f1442g = false;
    }

    @Override // e.h.a.i.l.o
    public boolean k() {
        return this.f1439d != d.a.MATCH_CONSTRAINT || this.b.q == 0;
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
        this.f1442g = false;
        this.f1443h.b();
        this.f1443h.f1423j = false;
        this.f1444i.b();
        this.f1444i.f1423j = false;
        this.f1440e.f1423j = false;
    }

    public String toString() {
        StringBuilder h2 = a.h("HorizontalRun ");
        h2.append(this.b.i0);
        return h2.toString();
    }
}
