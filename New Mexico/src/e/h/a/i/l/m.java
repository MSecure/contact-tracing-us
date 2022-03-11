package e.h.a.i.l;

import e.h.a.i.c;
import e.h.a.i.d;
import e.h.a.i.g;
import e.h.a.i.l.f;
import e.h.a.i.l.o;
import f.a.a.a.a;
import java.util.List;
/* loaded from: classes.dex */
public class m extends o {

    /* renamed from: k */
    public f f1434k;

    /* renamed from: l */
    public g f1435l = null;

    public m(d dVar) {
        super(dVar);
        f fVar = new f(this);
        this.f1434k = fVar;
        this.f1443h.f1418e = f.a.TOP;
        this.f1444i.f1418e = f.a.BOTTOM;
        fVar.f1418e = f.a.BASELINE;
        this.f1441f = 1;
    }

    @Override // e.h.a.i.l.o, e.h.a.i.l.d
    public void a(d dVar) {
        int i2;
        float f2;
        float f3;
        float f4;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        int ordinal = this.f1445j.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            g gVar = this.f1440e;
            if (gVar.c && !gVar.f1423j && this.f1439d == aVar) {
                d dVar2 = this.b;
                int i3 = dVar2.r;
                if (i3 == 2) {
                    d dVar3 = dVar2.U;
                    if (dVar3 != null) {
                        g gVar2 = dVar3.f1392e.f1440e;
                        if (gVar2.f1423j) {
                            f3 = dVar2.y;
                            f4 = (float) gVar2.f1420g;
                            f2 = f4 * f3;
                        }
                    }
                } else if (i3 == 3) {
                    g gVar3 = dVar2.f1391d.f1440e;
                    if (gVar3.f1423j) {
                        int i4 = dVar2.Y;
                        if (i4 != -1) {
                            if (i4 == 0) {
                                f4 = (float) gVar3.f1420g;
                                f3 = dVar2.X;
                                f2 = f4 * f3;
                            } else if (i4 != 1) {
                                i2 = 0;
                                gVar.c(i2);
                            }
                        }
                        f2 = ((float) gVar3.f1420g) / dVar2.X;
                    }
                }
                i2 = (int) (f2 + 0.5f);
                gVar.c(i2);
            }
            f fVar = this.f1443h;
            if (fVar.c) {
                f fVar2 = this.f1444i;
                if (fVar2.c) {
                    if (!fVar.f1423j || !fVar2.f1423j || !this.f1440e.f1423j) {
                        if (!this.f1440e.f1423j && this.f1439d == aVar) {
                            d dVar4 = this.b;
                            if (dVar4.q == 0 && !dVar4.y()) {
                                int i5 = this.f1443h.f1425l.get(0).f1420g;
                                f fVar3 = this.f1443h;
                                int i6 = i5 + fVar3.f1419f;
                                int i7 = this.f1444i.f1425l.get(0).f1420g + this.f1444i.f1419f;
                                fVar3.c(i6);
                                this.f1444i.c(i7);
                                this.f1440e.c(i7 - i6);
                                return;
                            }
                        }
                        if (!this.f1440e.f1423j && this.f1439d == aVar && this.a == 1 && this.f1443h.f1425l.size() > 0 && this.f1444i.f1425l.size() > 0) {
                            int i8 = (this.f1444i.f1425l.get(0).f1420g + this.f1444i.f1419f) - (this.f1443h.f1425l.get(0).f1420g + this.f1443h.f1419f);
                            g gVar4 = this.f1440e;
                            int i9 = gVar4.m;
                            if (i8 < i9) {
                                gVar4.c(i8);
                            } else {
                                gVar4.c(i9);
                            }
                        }
                        if (this.f1440e.f1423j && this.f1443h.f1425l.size() > 0 && this.f1444i.f1425l.size() > 0) {
                            f fVar4 = this.f1443h.f1425l.get(0);
                            f fVar5 = this.f1444i.f1425l.get(0);
                            int i10 = fVar4.f1420g;
                            f fVar6 = this.f1443h;
                            int i11 = fVar6.f1419f + i10;
                            int i12 = fVar5.f1420g;
                            int i13 = this.f1444i.f1419f + i12;
                            float f5 = this.b.f0;
                            if (fVar4 == fVar5) {
                                f5 = 0.5f;
                            } else {
                                i10 = i11;
                                i12 = i13;
                            }
                            fVar6.c((int) ((((float) ((i12 - i10) - this.f1440e.f1420g)) * f5) + ((float) i10) + 0.5f));
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
        d dVar5 = this.b;
        l(dVar5.J, dVar5.L, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0320, code lost:
        if (r10.b.D != false) goto L_0x0322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0322, code lost:
        r0 = r10.f1434k;
        r1 = r10.f1443h;
        r2 = r10.f1435l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x037c, code lost:
        if (r0.f1439d == r2) goto L_0x0425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x03b5, code lost:
        if (r10.b.D != false) goto L_0x0322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0423, code lost:
        if (r0.f1439d == r2) goto L_0x0425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0425, code lost:
        r0.f1440e.f1424k.add(r10.f1440e);
        r10.f1440e.f1425l.add(r10.b.f1391d.f1440e);
        r10.f1440e.a = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    @Override // e.h.a.i.l.o
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void d() {
        k kVar;
        d dVar;
        f fVar;
        f fVar2;
        g gVar;
        List<d> list;
        d dVar2;
        f fVar3;
        f fVar4;
        d dVar3;
        d dVar4;
        d.a aVar = d.a.MATCH_PARENT;
        d.a aVar2 = d.a.FIXED;
        d.a aVar3 = d.a.MATCH_CONSTRAINT;
        d dVar5 = this.b;
        if (dVar5.a) {
            this.f1440e.c(dVar5.l());
        }
        if (!this.f1440e.f1423j) {
            this.f1439d = this.b.q();
            if (this.b.D) {
                this.f1435l = new a(this);
            }
            d.a aVar4 = this.f1439d;
            if (aVar4 != aVar3) {
                if (aVar4 == aVar && (dVar4 = this.b.U) != null && dVar4.q() == aVar2) {
                    int l2 = (dVar4.l() - this.b.J.d()) - this.b.L.d();
                    b(this.f1443h, dVar4.f1392e.f1443h, this.b.J.d());
                    b(this.f1444i, dVar4.f1392e.f1444i, -this.b.L.d());
                    this.f1440e.c(l2);
                    return;
                } else if (this.f1439d == aVar2) {
                    this.f1440e.c(this.b.l());
                }
            }
        } else if (this.f1439d == aVar && (dVar3 = this.b.U) != null && dVar3.q() == aVar2) {
            b(this.f1443h, dVar3.f1392e.f1443h, this.b.J.d());
            b(this.f1444i, dVar3.f1392e.f1444i, -this.b.L.d());
            return;
        }
        g gVar2 = this.f1440e;
        boolean z = gVar2.f1423j;
        if (z) {
            d dVar6 = this.b;
            if (dVar6.a) {
                c[] cVarArr = dVar6.Q;
                if (cVarArr[2].f1379f != null && cVarArr[3].f1379f != null) {
                    if (dVar6.y()) {
                        this.f1443h.f1419f = this.b.Q[2].d();
                        this.f1444i.f1419f = -this.b.Q[3].d();
                    } else {
                        f h2 = h(this.b.Q[2]);
                        if (h2 != null) {
                            f fVar5 = this.f1443h;
                            int d2 = this.b.Q[2].d();
                            fVar5.f1425l.add(h2);
                            fVar5.f1419f = d2;
                            h2.f1424k.add(fVar5);
                        }
                        f h3 = h(this.b.Q[3]);
                        if (h3 != null) {
                            f fVar6 = this.f1444i;
                            fVar6.f1425l.add(h3);
                            fVar6.f1419f = -this.b.Q[3].d();
                            h3.f1424k.add(fVar6);
                        }
                        this.f1443h.b = true;
                        this.f1444i.b = true;
                    }
                    dVar2 = this.b;
                    if (dVar2.D) {
                        fVar3 = this.f1434k;
                        fVar4 = this.f1443h;
                    } else {
                        return;
                    }
                } else if (cVarArr[2].f1379f != null) {
                    f h4 = h(cVarArr[2]);
                    if (h4 != null) {
                        f fVar7 = this.f1443h;
                        int d3 = this.b.Q[2].d();
                        fVar7.f1425l.add(h4);
                        fVar7.f1419f = d3;
                        h4.f1424k.add(fVar7);
                        b(this.f1444i, this.f1443h, this.f1440e.f1420g);
                        dVar2 = this.b;
                        if (dVar2.D) {
                            fVar3 = this.f1434k;
                            fVar4 = this.f1443h;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (cVarArr[3].f1379f != null) {
                    f h5 = h(cVarArr[3]);
                    if (h5 != null) {
                        f fVar8 = this.f1444i;
                        fVar8.f1425l.add(h5);
                        fVar8.f1419f = -this.b.Q[3].d();
                        h5.f1424k.add(fVar8);
                        b(this.f1443h, this.f1444i, -this.f1440e.f1420g);
                    }
                    dVar2 = this.b;
                    if (dVar2.D) {
                        fVar3 = this.f1434k;
                        fVar4 = this.f1443h;
                    } else {
                        return;
                    }
                } else if (cVarArr[4].f1379f != null) {
                    f h6 = h(cVarArr[4]);
                    if (h6 != null) {
                        f fVar9 = this.f1434k;
                        fVar9.f1425l.add(h6);
                        fVar9.f1419f = 0;
                        h6.f1424k.add(fVar9);
                        b(this.f1443h, this.f1434k, -this.b.b0);
                        b(this.f1444i, this.f1443h, this.f1440e.f1420g);
                        return;
                    }
                    return;
                } else if (!(dVar6 instanceof g) && dVar6.U != null && dVar6.i(c.a.CENTER).f1379f == null) {
                    d dVar7 = this.b;
                    b(this.f1443h, dVar7.U.f1392e.f1443h, dVar7.t());
                    b(this.f1444i, this.f1443h, this.f1440e.f1420g);
                    dVar2 = this.b;
                    if (dVar2.D) {
                        fVar3 = this.f1434k;
                        fVar4 = this.f1443h;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                b(fVar3, fVar4, dVar2.b0);
                return;
            }
        }
        if (z || this.f1439d != aVar3) {
            gVar2.f1424k.add(this);
            if (gVar2.f1423j) {
                a(this);
            }
        } else {
            d dVar8 = this.b;
            int i2 = dVar8.r;
            if (i2 == 2) {
                d dVar9 = dVar8.U;
                if (dVar9 != null) {
                    g gVar3 = dVar9.f1392e.f1440e;
                    gVar2.f1425l.add(gVar3);
                    list = gVar3.f1424k;
                    list.add(this.f1440e);
                    g gVar4 = this.f1440e;
                    gVar4.b = true;
                    gVar4.f1424k.add(this.f1443h);
                    this.f1440e.f1424k.add(this.f1444i);
                }
            } else if (i2 == 3 && !dVar8.y()) {
                d dVar10 = this.b;
                if (dVar10.q != 3) {
                    g gVar5 = dVar10.f1391d.f1440e;
                    this.f1440e.f1425l.add(gVar5);
                    list = gVar5.f1424k;
                    list.add(this.f1440e);
                    g gVar42 = this.f1440e;
                    gVar42.b = true;
                    gVar42.f1424k.add(this.f1443h);
                    this.f1440e.f1424k.add(this.f1444i);
                }
            }
        }
        d dVar11 = this.b;
        c[] cVarArr2 = dVar11.Q;
        if (cVarArr2[2].f1379f == null || cVarArr2[3].f1379f == null) {
            if (cVarArr2[2].f1379f != null) {
                f h7 = h(cVarArr2[2]);
                if (h7 != null) {
                    f fVar10 = this.f1443h;
                    int d4 = this.b.Q[2].d();
                    fVar10.f1425l.add(h7);
                    fVar10.f1419f = d4;
                    h7.f1424k.add(fVar10);
                    c(this.f1444i, this.f1443h, 1, this.f1440e);
                    if (this.b.D) {
                        c(this.f1434k, this.f1443h, 1, this.f1435l);
                    }
                    if (this.f1439d == aVar3) {
                        d dVar12 = this.b;
                        if (dVar12.X > 0.0f) {
                            kVar = dVar12.f1391d;
                        }
                    }
                }
                if (this.f1440e.f1425l.size() == 0) {
                    this.f1440e.c = true;
                    return;
                }
                return;
            }
            if (cVarArr2[3].f1379f != null) {
                f h8 = h(cVarArr2[3]);
                if (h8 != null) {
                    f fVar11 = this.f1444i;
                    fVar11.f1425l.add(h8);
                    fVar11.f1419f = -this.b.Q[3].d();
                    h8.f1424k.add(fVar11);
                    c(this.f1443h, this.f1444i, -1, this.f1440e);
                }
            } else if (cVarArr2[4].f1379f != null) {
                f h9 = h(cVarArr2[4]);
                if (h9 != null) {
                    f fVar12 = this.f1434k;
                    fVar12.f1425l.add(h9);
                    fVar12.f1419f = 0;
                    h9.f1424k.add(fVar12);
                    c(this.f1443h, this.f1434k, -1, this.f1435l);
                    fVar = this.f1444i;
                    fVar2 = this.f1443h;
                    gVar = this.f1440e;
                }
            } else if (!(dVar11 instanceof g) && (dVar = dVar11.U) != null) {
                b(this.f1443h, dVar.f1392e.f1443h, dVar11.t());
                c(this.f1444i, this.f1443h, 1, this.f1440e);
                if (this.b.D) {
                    c(this.f1434k, this.f1443h, 1, this.f1435l);
                }
                if (this.f1439d == aVar3) {
                    d dVar13 = this.b;
                    if (dVar13.X > 0.0f) {
                        kVar = dVar13.f1391d;
                    }
                }
            }
            if (this.f1440e.f1425l.size() == 0) {
            }
        } else if (dVar11.y()) {
            this.f1443h.f1419f = this.b.Q[2].d();
            this.f1444i.f1419f = -this.b.Q[3].d();
        } else {
            f h10 = h(this.b.Q[2]);
            f h11 = h(this.b.Q[3]);
            if (h10 != null) {
                h10.f1424k.add(this);
                if (h10.f1423j) {
                    a(this);
                }
            }
            if (h11 != null) {
                h11.f1424k.add(this);
                if (h11.f1423j) {
                    a(this);
                }
            }
            this.f1445j = o.a.CENTER;
        }
        c(fVar, fVar2, 1, gVar);
        if (this.f1440e.f1425l.size() == 0) {
        }
    }

    @Override // e.h.a.i.l.o
    public void e() {
        f fVar = this.f1443h;
        if (fVar.f1423j) {
            this.b.a0 = fVar.f1420g;
        }
    }

    @Override // e.h.a.i.l.o
    public void f() {
        this.c = null;
        this.f1443h.b();
        this.f1444i.b();
        this.f1434k.b();
        this.f1440e.b();
        this.f1442g = false;
    }

    @Override // e.h.a.i.l.o
    public boolean k() {
        return this.f1439d != d.a.MATCH_CONSTRAINT || this.b.r == 0;
    }

    public void m() {
        this.f1442g = false;
        this.f1443h.b();
        this.f1443h.f1423j = false;
        this.f1444i.b();
        this.f1444i.f1423j = false;
        this.f1434k.b();
        this.f1434k.f1423j = false;
        this.f1440e.f1423j = false;
    }

    public String toString() {
        StringBuilder h2 = a.h("VerticalRun ");
        h2.append(this.b.i0);
        return h2.toString();
    }
}
