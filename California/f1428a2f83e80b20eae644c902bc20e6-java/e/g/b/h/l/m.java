package e.g.b.h.l;

import e.g.b.h.c;
import e.g.b.h.d;
import e.g.b.h.g;
import e.g.b.h.l.f;
import e.g.b.h.l.o;
import f.a.a.a.a;
import java.util.List;

public class m extends o {

    /* renamed from: k  reason: collision with root package name */
    public f f1317k;

    /* renamed from: l  reason: collision with root package name */
    public g f1318l = null;

    public m(d dVar) {
        super(dVar);
        f fVar = new f(this);
        this.f1317k = fVar;
        this.f1326h.f1301e = f.a.TOP;
        this.f1327i.f1301e = f.a.BOTTOM;
        fVar.f1301e = f.a.BASELINE;
        this.f1324f = 1;
    }

    @Override // e.g.b.h.l.o, e.g.b.h.l.d
    public void a(d dVar) {
        int i2;
        float f2;
        float f3;
        float f4;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        int ordinal = this.f1328j.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            g gVar = this.f1323e;
            if (gVar.c && !gVar.f1306j && this.f1322d == aVar) {
                d dVar2 = this.b;
                int i3 = dVar2.m;
                if (i3 == 2) {
                    d dVar3 = dVar2.P;
                    if (dVar3 != null) {
                        g gVar2 = dVar3.f1275e.f1323e;
                        if (gVar2.f1306j) {
                            f3 = dVar2.t;
                            f4 = (float) gVar2.f1303g;
                        }
                    }
                } else if (i3 == 3) {
                    g gVar3 = dVar2.f1274d.f1323e;
                    if (gVar3.f1306j) {
                        int i4 = dVar2.T;
                        if (i4 != -1) {
                            if (i4 == 0) {
                                f4 = (float) gVar3.f1303g;
                                f3 = dVar2.S;
                            } else if (i4 != 1) {
                                i2 = 0;
                                gVar.c(i2);
                            }
                        }
                        f2 = ((float) gVar3.f1303g) / dVar2.S;
                        i2 = (int) (f2 + 0.5f);
                        gVar.c(i2);
                    }
                }
                f2 = f4 * f3;
                i2 = (int) (f2 + 0.5f);
                gVar.c(i2);
            }
            f fVar = this.f1326h;
            if (fVar.c) {
                f fVar2 = this.f1327i;
                if (fVar2.c) {
                    if (!fVar.f1306j || !fVar2.f1306j || !this.f1323e.f1306j) {
                        if (!this.f1323e.f1306j && this.f1322d == aVar) {
                            d dVar4 = this.b;
                            if (dVar4.f1282l == 0 && !dVar4.x()) {
                                int i5 = this.f1326h.f1308l.get(0).f1303g;
                                f fVar3 = this.f1326h;
                                int i6 = i5 + fVar3.f1302f;
                                int i7 = this.f1327i.f1308l.get(0).f1303g + this.f1327i.f1302f;
                                fVar3.c(i6);
                                this.f1327i.c(i7);
                                this.f1323e.c(i7 - i6);
                                return;
                            }
                        }
                        if (!this.f1323e.f1306j && this.f1322d == aVar && this.a == 1 && this.f1326h.f1308l.size() > 0 && this.f1327i.f1308l.size() > 0) {
                            int i8 = (this.f1327i.f1308l.get(0).f1303g + this.f1327i.f1302f) - (this.f1326h.f1308l.get(0).f1303g + this.f1326h.f1302f);
                            g gVar4 = this.f1323e;
                            int i9 = gVar4.m;
                            if (i8 < i9) {
                                gVar4.c(i8);
                            } else {
                                gVar4.c(i9);
                            }
                        }
                        if (this.f1323e.f1306j && this.f1326h.f1308l.size() > 0 && this.f1327i.f1308l.size() > 0) {
                            f fVar4 = this.f1326h.f1308l.get(0);
                            f fVar5 = this.f1327i.f1308l.get(0);
                            int i10 = fVar4.f1303g;
                            f fVar6 = this.f1326h;
                            int i11 = fVar6.f1302f + i10;
                            int i12 = fVar5.f1303g;
                            int i13 = this.f1327i.f1302f + i12;
                            float f5 = this.b.a0;
                            if (fVar4 == fVar5) {
                                f5 = 0.5f;
                            } else {
                                i10 = i11;
                                i12 = i13;
                            }
                            fVar6.c((int) ((((float) ((i12 - i10) - this.f1323e.f1303g)) * f5) + ((float) i10) + 0.5f));
                            this.f1327i.c(this.f1326h.f1303g + this.f1323e.f1303g);
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
        l(dVar5.E, dVar5.G, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x031c, code lost:
        if (r10.b.y != false) goto L_0x031e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0378, code lost:
        if (r0.f1322d == r2) goto L_0x0421;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x03b1, code lost:
        if (r10.b.y != false) goto L_0x031e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x041f, code lost:
        if (r0.f1322d == r2) goto L_0x0421;
     */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0445  */
    /* JADX WARNING: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    @Override // e.g.b.h.l.o
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
            this.f1323e.c(dVar5.l());
        }
        if (!this.f1323e.f1306j) {
            this.f1322d = this.b.q();
            if (this.b.y) {
                this.f1318l = new a(this);
            }
            d.a aVar4 = this.f1322d;
            if (aVar4 != aVar3) {
                if (aVar4 == aVar && (dVar4 = this.b.P) != null && dVar4.q() == aVar2) {
                    int l2 = (dVar4.l() - this.b.E.d()) - this.b.G.d();
                    b(this.f1326h, dVar4.f1275e.f1326h, this.b.E.d());
                    b(this.f1327i, dVar4.f1275e.f1327i, -this.b.G.d());
                    this.f1323e.c(l2);
                    return;
                } else if (this.f1322d == aVar2) {
                    this.f1323e.c(this.b.l());
                }
            }
        } else if (this.f1322d == aVar && (dVar3 = this.b.P) != null && dVar3.q() == aVar2) {
            b(this.f1326h, dVar3.f1275e.f1326h, this.b.E.d());
            b(this.f1327i, dVar3.f1275e.f1327i, -this.b.G.d());
            return;
        }
        g gVar2 = this.f1323e;
        boolean z = gVar2.f1306j;
        if (z) {
            d dVar6 = this.b;
            if (dVar6.a) {
                c[] cVarArr = dVar6.L;
                if (cVarArr[2].f1262f != null && cVarArr[3].f1262f != null) {
                    if (dVar6.x()) {
                        this.f1326h.f1302f = this.b.L[2].d();
                        this.f1327i.f1302f = -this.b.L[3].d();
                    } else {
                        f h2 = h(this.b.L[2]);
                        if (h2 != null) {
                            f fVar5 = this.f1326h;
                            int d2 = this.b.L[2].d();
                            fVar5.f1308l.add(h2);
                            fVar5.f1302f = d2;
                            h2.f1307k.add(fVar5);
                        }
                        f h3 = h(this.b.L[3]);
                        if (h3 != null) {
                            f fVar6 = this.f1327i;
                            fVar6.f1308l.add(h3);
                            fVar6.f1302f = -this.b.L[3].d();
                            h3.f1307k.add(fVar6);
                        }
                        this.f1326h.b = true;
                        this.f1327i.b = true;
                    }
                    dVar2 = this.b;
                    if (dVar2.y) {
                        fVar3 = this.f1317k;
                        fVar4 = this.f1326h;
                    } else {
                        return;
                    }
                } else if (cVarArr[2].f1262f != null) {
                    f h4 = h(cVarArr[2]);
                    if (h4 != null) {
                        f fVar7 = this.f1326h;
                        int d3 = this.b.L[2].d();
                        fVar7.f1308l.add(h4);
                        fVar7.f1302f = d3;
                        h4.f1307k.add(fVar7);
                        b(this.f1327i, this.f1326h, this.f1323e.f1303g);
                        dVar2 = this.b;
                        if (dVar2.y) {
                            fVar3 = this.f1317k;
                            fVar4 = this.f1326h;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (cVarArr[3].f1262f != null) {
                    f h5 = h(cVarArr[3]);
                    if (h5 != null) {
                        f fVar8 = this.f1327i;
                        fVar8.f1308l.add(h5);
                        fVar8.f1302f = -this.b.L[3].d();
                        h5.f1307k.add(fVar8);
                        b(this.f1326h, this.f1327i, -this.f1323e.f1303g);
                    }
                    dVar2 = this.b;
                    if (dVar2.y) {
                        fVar3 = this.f1317k;
                        fVar4 = this.f1326h;
                    } else {
                        return;
                    }
                } else if (cVarArr[4].f1262f != null) {
                    f h6 = h(cVarArr[4]);
                    if (h6 != null) {
                        f fVar9 = this.f1317k;
                        fVar9.f1308l.add(h6);
                        fVar9.f1302f = 0;
                        h6.f1307k.add(fVar9);
                        b(this.f1326h, this.f1317k, -this.b.W);
                        b(this.f1327i, this.f1326h, this.f1323e.f1303g);
                        return;
                    }
                    return;
                } else if (!(dVar6 instanceof g) && dVar6.P != null && dVar6.i(c.a.CENTER).f1262f == null) {
                    d dVar7 = this.b;
                    b(this.f1326h, dVar7.P.f1275e.f1326h, dVar7.t());
                    b(this.f1327i, this.f1326h, this.f1323e.f1303g);
                    dVar2 = this.b;
                    if (dVar2.y) {
                        fVar3 = this.f1317k;
                        fVar4 = this.f1326h;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                b(fVar3, fVar4, dVar2.W);
                return;
            }
        }
        if (z || this.f1322d != aVar3) {
            gVar2.f1307k.add(this);
            if (gVar2.f1306j) {
                a(this);
            }
        } else {
            d dVar8 = this.b;
            int i2 = dVar8.m;
            if (i2 == 2) {
                d dVar9 = dVar8.P;
                if (dVar9 != null) {
                    g gVar3 = dVar9.f1275e.f1323e;
                    gVar2.f1308l.add(gVar3);
                    list = gVar3.f1307k;
                }
            } else if (i2 == 3 && !dVar8.x()) {
                d dVar10 = this.b;
                if (dVar10.f1282l != 3) {
                    g gVar4 = dVar10.f1274d.f1323e;
                    this.f1323e.f1308l.add(gVar4);
                    list = gVar4.f1307k;
                }
            }
            list.add(this.f1323e);
            g gVar5 = this.f1323e;
            gVar5.b = true;
            gVar5.f1307k.add(this.f1326h);
            this.f1323e.f1307k.add(this.f1327i);
        }
        d dVar11 = this.b;
        c[] cVarArr2 = dVar11.L;
        if (cVarArr2[2].f1262f == null || cVarArr2[3].f1262f == null) {
            if (cVarArr2[2].f1262f != null) {
                f h7 = h(cVarArr2[2]);
                if (h7 != null) {
                    f fVar10 = this.f1326h;
                    int d4 = this.b.L[2].d();
                    fVar10.f1308l.add(h7);
                    fVar10.f1302f = d4;
                    h7.f1307k.add(fVar10);
                    c(this.f1327i, this.f1326h, 1, this.f1323e);
                    if (this.b.y) {
                        c(this.f1317k, this.f1326h, 1, this.f1318l);
                    }
                    if (this.f1322d == aVar3) {
                        d dVar12 = this.b;
                        if (dVar12.S > 0.0f) {
                            kVar = dVar12.f1274d;
                        }
                    }
                }
                if (this.f1323e.f1308l.size() != 0) {
                    this.f1323e.c = true;
                    return;
                }
                return;
            }
            if (cVarArr2[3].f1262f != null) {
                f h8 = h(cVarArr2[3]);
                if (h8 != null) {
                    f fVar11 = this.f1327i;
                    fVar11.f1308l.add(h8);
                    fVar11.f1302f = -this.b.L[3].d();
                    h8.f1307k.add(fVar11);
                    c(this.f1326h, this.f1327i, -1, this.f1323e);
                }
            } else if (cVarArr2[4].f1262f != null) {
                f h9 = h(cVarArr2[4]);
                if (h9 != null) {
                    f fVar12 = this.f1317k;
                    fVar12.f1308l.add(h9);
                    fVar12.f1302f = 0;
                    h9.f1307k.add(fVar12);
                    c(this.f1326h, this.f1317k, -1, this.f1318l);
                    fVar = this.f1327i;
                    fVar2 = this.f1326h;
                    gVar = this.f1323e;
                    c(fVar, fVar2, 1, gVar);
                }
            } else if (!(dVar11 instanceof g) && (dVar = dVar11.P) != null) {
                b(this.f1326h, dVar.f1275e.f1326h, dVar11.t());
                c(this.f1327i, this.f1326h, 1, this.f1323e);
                if (this.b.y) {
                    c(this.f1317k, this.f1326h, 1, this.f1318l);
                }
                if (this.f1322d == aVar3) {
                    d dVar13 = this.b;
                    if (dVar13.S > 0.0f) {
                        kVar = dVar13.f1274d;
                    }
                }
            }
            if (this.f1323e.f1308l.size() != 0) {
            }
            kVar.f1323e.f1307k.add(this.f1323e);
            this.f1323e.f1308l.add(this.b.f1274d.f1323e);
            this.f1323e.a = this;
            if (this.f1323e.f1308l.size() != 0) {
            }
        } else if (dVar11.x()) {
            this.f1326h.f1302f = this.b.L[2].d();
            this.f1327i.f1302f = -this.b.L[3].d();
        } else {
            f h10 = h(this.b.L[2]);
            f h11 = h(this.b.L[3]);
            h10.f1307k.add(this);
            if (h10.f1306j) {
                a(this);
            }
            h11.f1307k.add(this);
            if (h11.f1306j) {
                a(this);
            }
            this.f1328j = o.a.CENTER;
        }
        fVar = this.f1317k;
        fVar2 = this.f1326h;
        gVar = this.f1318l;
        c(fVar, fVar2, 1, gVar);
        if (this.f1323e.f1308l.size() != 0) {
        }
    }

    @Override // e.g.b.h.l.o
    public void e() {
        f fVar = this.f1326h;
        if (fVar.f1306j) {
            this.b.V = fVar.f1303g;
        }
    }

    @Override // e.g.b.h.l.o
    public void f() {
        this.c = null;
        this.f1326h.b();
        this.f1327i.b();
        this.f1317k.b();
        this.f1323e.b();
        this.f1325g = false;
    }

    @Override // e.g.b.h.l.o
    public boolean k() {
        return this.f1322d != d.a.MATCH_CONSTRAINT || this.b.m == 0;
    }

    public void m() {
        this.f1325g = false;
        this.f1326h.b();
        this.f1326h.f1306j = false;
        this.f1327i.b();
        this.f1327i.f1306j = false;
        this.f1317k.b();
        this.f1317k.f1306j = false;
        this.f1323e.f1306j = false;
    }

    public String toString() {
        StringBuilder h2 = a.h("VerticalRun ");
        h2.append(this.b.d0);
        return h2.toString();
    }
}
