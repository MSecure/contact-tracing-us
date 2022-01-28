package b.g.b.h.l;

import b.g.b.h.c;
import b.g.b.h.d;
import b.g.b.h.g;
import b.g.b.h.l.f;
import b.g.b.h.l.m;
import c.a.a.a.a;
import java.util.List;

public class l extends m {
    public f k;
    public g l = null;

    public l(d dVar) {
        super(dVar);
        f fVar = new f(this);
        this.k = fVar;
        this.h.f1545e = f.a.TOP;
        this.i.f1545e = f.a.BOTTOM;
        fVar.f1545e = f.a.BASELINE;
        this.f1562f = 1;
    }

    @Override // b.g.b.h.l.d, b.g.b.h.l.m
    public void a(d dVar) {
        int i;
        float f2;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        int ordinal = this.j.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            g gVar = this.f1561e;
            if (gVar.f1543c && !gVar.j && this.f1560d == aVar) {
                d dVar2 = this.f1558b;
                int i2 = dVar2.k;
                if (i2 == 2) {
                    d dVar3 = dVar2.I;
                    if (dVar3 != null) {
                        g gVar2 = dVar3.f1515e.f1561e;
                        if (gVar2.j) {
                            gVar.c((int) ((((float) gVar2.f1547g) * dVar2.r) + 0.5f));
                        }
                    }
                } else if (i2 == 3) {
                    g gVar3 = dVar2.f1514d.f1561e;
                    if (gVar3.j) {
                        int i3 = dVar2.M;
                        if (i3 != -1) {
                            if (i3 == 0) {
                                f2 = ((float) gVar3.f1547g) * dVar2.L;
                                i = (int) (f2 + 0.5f);
                                this.f1561e.c(i);
                            } else if (i3 != 1) {
                                i = 0;
                                this.f1561e.c(i);
                            }
                        }
                        f2 = ((float) gVar3.f1547g) / dVar2.L;
                        i = (int) (f2 + 0.5f);
                        this.f1561e.c(i);
                    }
                }
            }
            f fVar = this.h;
            if (fVar.f1543c) {
                f fVar2 = this.i;
                if (fVar2.f1543c) {
                    if (!fVar.j || !fVar2.j || !this.f1561e.j) {
                        if (!this.f1561e.j && this.f1560d == aVar) {
                            d dVar4 = this.f1558b;
                            if (dVar4.j == 0 && !dVar4.t()) {
                                int i4 = this.h.l.get(0).f1547g;
                                f fVar3 = this.h;
                                int i5 = i4 + fVar3.f1546f;
                                int i6 = this.i.l.get(0).f1547g + this.i.f1546f;
                                fVar3.c(i5);
                                this.i.c(i6);
                                this.f1561e.c(i6 - i5);
                                return;
                            }
                        }
                        if (!this.f1561e.j && this.f1560d == aVar && this.f1557a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                            int i7 = (this.i.l.get(0).f1547g + this.i.f1546f) - (this.h.l.get(0).f1547g + this.h.f1546f);
                            g gVar4 = this.f1561e;
                            int i8 = gVar4.m;
                            if (i7 < i8) {
                                gVar4.c(i7);
                            } else {
                                gVar4.c(i8);
                            }
                        }
                        if (this.f1561e.j && this.h.l.size() > 0 && this.i.l.size() > 0) {
                            f fVar4 = this.h.l.get(0);
                            f fVar5 = this.i.l.get(0);
                            int i9 = fVar4.f1547g;
                            int i10 = this.h.f1546f + i9;
                            int i11 = fVar5.f1547g;
                            int i12 = this.i.f1546f + i11;
                            float f3 = this.f1558b.T;
                            if (fVar4 == fVar5) {
                                f3 = 0.5f;
                            } else {
                                i9 = i10;
                                i11 = i12;
                            }
                            this.h.c((int) ((((float) ((i11 - i9) - this.f1561e.f1547g)) * f3) + ((float) i9) + 0.5f));
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
        d dVar5 = this.f1558b;
        l(dVar5.y, dVar5.A, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0326, code lost:
        if (r10.f1558b.w != false) goto L_0x0328;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0386, code lost:
        if (r0.f1560d == r2) goto L_0x042f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x03bf, code lost:
        if (r10.f1558b.w != false) goto L_0x0328;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x042d, code lost:
        if (r0.f1560d == r2) goto L_0x042f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0453  */
    /* JADX WARNING: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    @Override // b.g.b.h.l.m
    public void d() {
        j jVar;
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
        d dVar5 = this.f1558b;
        if (dVar5.f1511a) {
            this.f1561e.c(dVar5.i());
        }
        if (!this.f1561e.j) {
            this.f1560d = this.f1558b.n();
            if (this.f1558b.w) {
                this.l = new a(this);
            }
            d.a aVar4 = this.f1560d;
            if (aVar4 != aVar3) {
                if (aVar4 == aVar && (dVar4 = this.f1558b.I) != null && dVar4.n() == aVar2) {
                    int i = (dVar4.i() - this.f1558b.y.b()) - this.f1558b.A.b();
                    b(this.h, dVar4.f1515e.h, this.f1558b.y.b());
                    b(this.i, dVar4.f1515e.i, -this.f1558b.A.b());
                    this.f1561e.c(i);
                    return;
                } else if (this.f1560d == aVar2) {
                    this.f1561e.c(this.f1558b.i());
                }
            }
        } else if (this.f1560d == aVar && (dVar3 = this.f1558b.I) != null && dVar3.n() == aVar2) {
            b(this.h, dVar3.f1515e.h, this.f1558b.y.b());
            b(this.i, dVar3.f1515e.i, -this.f1558b.A.b());
            return;
        }
        if (this.f1561e.j) {
            d dVar6 = this.f1558b;
            if (dVar6.f1511a) {
                c[] cVarArr = dVar6.F;
                if (cVarArr[2].f1501c == null || cVarArr[3].f1501c == null) {
                    d dVar7 = this.f1558b;
                    c[] cVarArr2 = dVar7.F;
                    if (cVarArr2[2].f1501c != null) {
                        f h = h(cVarArr2[2]);
                        if (h != null) {
                            f fVar5 = this.h;
                            int b2 = this.f1558b.F[2].b();
                            fVar5.l.add(h);
                            fVar5.f1546f = b2;
                            h.k.add(fVar5);
                            b(this.i, this.h, this.f1561e.f1547g);
                            dVar2 = this.f1558b;
                            if (dVar2.w) {
                                fVar3 = this.k;
                                fVar4 = this.h;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (cVarArr2[3].f1501c != null) {
                        f h2 = h(cVarArr2[3]);
                        if (h2 != null) {
                            f fVar6 = this.i;
                            fVar6.l.add(h2);
                            fVar6.f1546f = -this.f1558b.F[3].b();
                            h2.k.add(fVar6);
                            b(this.h, this.i, -this.f1561e.f1547g);
                        }
                        dVar2 = this.f1558b;
                        if (dVar2.w) {
                            fVar3 = this.k;
                            fVar4 = this.h;
                        } else {
                            return;
                        }
                    } else if (cVarArr2[4].f1501c != null) {
                        f h3 = h(cVarArr2[4]);
                        if (h3 != null) {
                            f fVar7 = this.k;
                            fVar7.l.add(h3);
                            fVar7.f1546f = 0;
                            h3.k.add(fVar7);
                            b(this.h, this.k, -this.f1558b.P);
                            b(this.i, this.h, this.f1561e.f1547g);
                            return;
                        }
                        return;
                    } else if (!(dVar7 instanceof g) && dVar7.I != null && dVar7.f(c.a.CENTER).f1501c == null) {
                        d dVar8 = this.f1558b;
                        b(this.h, dVar8.I.f1515e.h, dVar8.q());
                        b(this.i, this.h, this.f1561e.f1547g);
                        dVar2 = this.f1558b;
                        if (dVar2.w) {
                            fVar3 = this.k;
                            fVar4 = this.h;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    if (dVar6.t()) {
                        this.h.f1546f = this.f1558b.F[2].b();
                        this.i.f1546f = -this.f1558b.F[3].b();
                    } else {
                        f h4 = h(this.f1558b.F[2]);
                        if (h4 != null) {
                            f fVar8 = this.h;
                            int b3 = this.f1558b.F[2].b();
                            fVar8.l.add(h4);
                            fVar8.f1546f = b3;
                            h4.k.add(fVar8);
                        }
                        f h5 = h(this.f1558b.F[3]);
                        if (h5 != null) {
                            f fVar9 = this.i;
                            fVar9.l.add(h5);
                            fVar9.f1546f = -this.f1558b.F[3].b();
                            h5.k.add(fVar9);
                        }
                        this.h.f1542b = true;
                        this.i.f1542b = true;
                    }
                    dVar2 = this.f1558b;
                    if (dVar2.w) {
                        fVar3 = this.k;
                        fVar4 = this.h;
                    } else {
                        return;
                    }
                }
                b(fVar3, fVar4, dVar2.P);
                return;
            }
        }
        g gVar2 = this.f1561e;
        if (gVar2.j || this.f1560d != aVar3) {
            g gVar3 = this.f1561e;
            gVar3.k.add(this);
            if (gVar3.j) {
                a(this);
            }
        } else {
            d dVar9 = this.f1558b;
            int i2 = dVar9.k;
            if (i2 == 2) {
                d dVar10 = dVar9.I;
                if (dVar10 != null) {
                    g gVar4 = dVar10.f1515e.f1561e;
                    gVar2.l.add(gVar4);
                    list = gVar4.k;
                }
            } else if (i2 == 3 && !dVar9.t()) {
                d dVar11 = this.f1558b;
                if (dVar11.j != 3) {
                    g gVar5 = dVar11.f1514d.f1561e;
                    this.f1561e.l.add(gVar5);
                    list = gVar5.k;
                }
            }
            list.add(this.f1561e);
            g gVar6 = this.f1561e;
            gVar6.f1542b = true;
            gVar6.k.add(this.h);
            this.f1561e.k.add(this.i);
        }
        d dVar12 = this.f1558b;
        c[] cVarArr3 = dVar12.F;
        if (cVarArr3[2].f1501c == null || cVarArr3[3].f1501c == null) {
            d dVar13 = this.f1558b;
            c[] cVarArr4 = dVar13.F;
            if (cVarArr4[2].f1501c != null) {
                f h6 = h(cVarArr4[2]);
                if (h6 != null) {
                    f fVar10 = this.h;
                    int b4 = this.f1558b.F[2].b();
                    fVar10.l.add(h6);
                    fVar10.f1546f = b4;
                    h6.k.add(fVar10);
                    c(this.i, this.h, 1, this.f1561e);
                    if (this.f1558b.w) {
                        c(this.k, this.h, 1, this.l);
                    }
                    if (this.f1560d == aVar3) {
                        d dVar14 = this.f1558b;
                        if (dVar14.L > 0.0f) {
                            jVar = dVar14.f1514d;
                        }
                    }
                }
                if (this.f1561e.l.size() != 0) {
                    this.f1561e.f1543c = true;
                    return;
                }
                return;
            }
            if (cVarArr4[3].f1501c != null) {
                f h7 = h(cVarArr4[3]);
                if (h7 != null) {
                    f fVar11 = this.i;
                    fVar11.l.add(h7);
                    fVar11.f1546f = -this.f1558b.F[3].b();
                    h7.k.add(fVar11);
                    c(this.h, this.i, -1, this.f1561e);
                }
            } else if (cVarArr4[4].f1501c != null) {
                f h8 = h(cVarArr4[4]);
                if (h8 != null) {
                    f fVar12 = this.k;
                    fVar12.l.add(h8);
                    fVar12.f1546f = 0;
                    h8.k.add(fVar12);
                    c(this.h, this.k, -1, this.l);
                    fVar = this.i;
                    fVar2 = this.h;
                    gVar = this.f1561e;
                    c(fVar, fVar2, 1, gVar);
                }
            } else if (!(dVar13 instanceof g) && (dVar = dVar13.I) != null) {
                b(this.h, dVar.f1515e.h, dVar13.q());
                c(this.i, this.h, 1, this.f1561e);
                if (this.f1558b.w) {
                    c(this.k, this.h, 1, this.l);
                }
                if (this.f1560d == aVar3) {
                    d dVar15 = this.f1558b;
                    if (dVar15.L > 0.0f) {
                        jVar = dVar15.f1514d;
                    }
                }
            }
            if (this.f1561e.l.size() != 0) {
            }
            jVar.f1561e.k.add(this.f1561e);
            this.f1561e.l.add(this.f1558b.f1514d.f1561e);
            this.f1561e.f1541a = this;
            if (this.f1561e.l.size() != 0) {
            }
        } else if (dVar12.t()) {
            this.h.f1546f = this.f1558b.F[2].b();
            this.i.f1546f = -this.f1558b.F[3].b();
        } else {
            f h9 = h(this.f1558b.F[2]);
            f h10 = h(this.f1558b.F[3]);
            h9.k.add(this);
            if (h9.j) {
                a(this);
            }
            h10.k.add(this);
            if (h10.j) {
                a(this);
            }
            this.j = m.a.CENTER;
        }
        fVar = this.k;
        fVar2 = this.h;
        gVar = this.l;
        c(fVar, fVar2, 1, gVar);
        if (this.f1561e.l.size() != 0) {
        }
    }

    @Override // b.g.b.h.l.m
    public void e() {
        f fVar = this.h;
        if (fVar.j) {
            this.f1558b.O = fVar.f1547g;
        }
    }

    @Override // b.g.b.h.l.m
    public void f() {
        this.f1559c = null;
        this.h.b();
        this.i.b();
        this.k.b();
        this.f1561e.b();
        this.f1563g = false;
    }

    @Override // b.g.b.h.l.m
    public boolean k() {
        return this.f1560d != d.a.MATCH_CONSTRAINT || this.f1558b.k == 0;
    }

    public void m() {
        this.f1563g = false;
        this.h.b();
        this.h.j = false;
        this.i.b();
        this.i.j = false;
        this.k.b();
        this.k.j = false;
        this.f1561e.j = false;
    }

    public String toString() {
        StringBuilder h = a.h("VerticalRun ");
        h.append(this.f1558b.W);
        return h.toString();
    }
}
