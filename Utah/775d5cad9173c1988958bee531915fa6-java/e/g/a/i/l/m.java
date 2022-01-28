package e.g.a.i.l;

import e.g.a.i.c;
import e.g.a.i.d;
import e.g.a.i.g;
import e.g.a.i.l.f;
import e.g.a.i.l.o;
import f.a.a.a.a;
import java.util.List;

public class m extends o {

    /* renamed from: k  reason: collision with root package name */
    public f f1350k;

    /* renamed from: l  reason: collision with root package name */
    public g f1351l = null;

    public m(d dVar) {
        super(dVar);
        f fVar = new f(this);
        this.f1350k = fVar;
        this.f1359h.f1334e = f.a.TOP;
        this.f1360i.f1334e = f.a.BOTTOM;
        fVar.f1334e = f.a.BASELINE;
        this.f1357f = 1;
    }

    @Override // e.g.a.i.l.d, e.g.a.i.l.o
    public void a(d dVar) {
        int i2;
        float f2;
        float f3;
        float f4;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        int ordinal = this.f1361j.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            g gVar = this.f1356e;
            if (gVar.c && !gVar.f1339j && this.f1355d == aVar) {
                d dVar2 = this.b;
                int i3 = dVar2.r;
                if (i3 == 2) {
                    d dVar3 = dVar2.U;
                    if (dVar3 != null) {
                        g gVar2 = dVar3.f1308e.f1356e;
                        if (gVar2.f1339j) {
                            f3 = dVar2.y;
                            f4 = (float) gVar2.f1336g;
                        }
                    }
                } else if (i3 == 3) {
                    g gVar3 = dVar2.f1307d.f1356e;
                    if (gVar3.f1339j) {
                        int i4 = dVar2.Y;
                        if (i4 != -1) {
                            if (i4 == 0) {
                                f4 = (float) gVar3.f1336g;
                                f3 = dVar2.X;
                            } else if (i4 != 1) {
                                i2 = 0;
                                gVar.c(i2);
                            }
                        }
                        f2 = ((float) gVar3.f1336g) / dVar2.X;
                        i2 = (int) (f2 + 0.5f);
                        gVar.c(i2);
                    }
                }
                f2 = f4 * f3;
                i2 = (int) (f2 + 0.5f);
                gVar.c(i2);
            }
            f fVar = this.f1359h;
            if (fVar.c) {
                f fVar2 = this.f1360i;
                if (fVar2.c) {
                    if (!fVar.f1339j || !fVar2.f1339j || !this.f1356e.f1339j) {
                        if (!this.f1356e.f1339j && this.f1355d == aVar) {
                            d dVar4 = this.b;
                            if (dVar4.q == 0 && !dVar4.y()) {
                                int i5 = this.f1359h.f1341l.get(0).f1336g;
                                f fVar3 = this.f1359h;
                                int i6 = i5 + fVar3.f1335f;
                                int i7 = this.f1360i.f1341l.get(0).f1336g + this.f1360i.f1335f;
                                fVar3.c(i6);
                                this.f1360i.c(i7);
                                this.f1356e.c(i7 - i6);
                                return;
                            }
                        }
                        if (!this.f1356e.f1339j && this.f1355d == aVar && this.a == 1 && this.f1359h.f1341l.size() > 0 && this.f1360i.f1341l.size() > 0) {
                            int i8 = (this.f1360i.f1341l.get(0).f1336g + this.f1360i.f1335f) - (this.f1359h.f1341l.get(0).f1336g + this.f1359h.f1335f);
                            g gVar4 = this.f1356e;
                            int i9 = gVar4.m;
                            if (i8 < i9) {
                                gVar4.c(i8);
                            } else {
                                gVar4.c(i9);
                            }
                        }
                        if (this.f1356e.f1339j && this.f1359h.f1341l.size() > 0 && this.f1360i.f1341l.size() > 0) {
                            f fVar4 = this.f1359h.f1341l.get(0);
                            f fVar5 = this.f1360i.f1341l.get(0);
                            int i10 = fVar4.f1336g;
                            f fVar6 = this.f1359h;
                            int i11 = fVar6.f1335f + i10;
                            int i12 = fVar5.f1336g;
                            int i13 = this.f1360i.f1335f + i12;
                            float f5 = this.b.f0;
                            if (fVar4 == fVar5) {
                                f5 = 0.5f;
                            } else {
                                i10 = i11;
                                i12 = i13;
                            }
                            fVar6.c((int) ((((float) ((i12 - i10) - this.f1356e.f1336g)) * f5) + ((float) i10) + 0.5f));
                            this.f1360i.c(this.f1359h.f1336g + this.f1356e.f1336g);
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

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0320, code lost:
        if (r10.b.D != false) goto L_0x0322;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x037c, code lost:
        if (r0.f1355d == r2) goto L_0x0425;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x03b5, code lost:
        if (r10.b.D != false) goto L_0x0322;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0423, code lost:
        if (r0.f1355d == r2) goto L_0x0425;
     */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0449  */
    /* JADX WARNING: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    @Override // e.g.a.i.l.o
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
            this.f1356e.c(dVar5.l());
        }
        if (!this.f1356e.f1339j) {
            this.f1355d = this.b.q();
            if (this.b.D) {
                this.f1351l = new a(this);
            }
            d.a aVar4 = this.f1355d;
            if (aVar4 != aVar3) {
                if (aVar4 == aVar && (dVar4 = this.b.U) != null && dVar4.q() == aVar2) {
                    int l2 = (dVar4.l() - this.b.J.d()) - this.b.L.d();
                    b(this.f1359h, dVar4.f1308e.f1359h, this.b.J.d());
                    b(this.f1360i, dVar4.f1308e.f1360i, -this.b.L.d());
                    this.f1356e.c(l2);
                    return;
                } else if (this.f1355d == aVar2) {
                    this.f1356e.c(this.b.l());
                }
            }
        } else if (this.f1355d == aVar && (dVar3 = this.b.U) != null && dVar3.q() == aVar2) {
            b(this.f1359h, dVar3.f1308e.f1359h, this.b.J.d());
            b(this.f1360i, dVar3.f1308e.f1360i, -this.b.L.d());
            return;
        }
        g gVar2 = this.f1356e;
        boolean z = gVar2.f1339j;
        if (z) {
            d dVar6 = this.b;
            if (dVar6.a) {
                c[] cVarArr = dVar6.Q;
                if (cVarArr[2].f1295f != null && cVarArr[3].f1295f != null) {
                    if (dVar6.y()) {
                        this.f1359h.f1335f = this.b.Q[2].d();
                        this.f1360i.f1335f = -this.b.Q[3].d();
                    } else {
                        f h2 = h(this.b.Q[2]);
                        if (h2 != null) {
                            f fVar5 = this.f1359h;
                            int d2 = this.b.Q[2].d();
                            fVar5.f1341l.add(h2);
                            fVar5.f1335f = d2;
                            h2.f1340k.add(fVar5);
                        }
                        f h3 = h(this.b.Q[3]);
                        if (h3 != null) {
                            f fVar6 = this.f1360i;
                            fVar6.f1341l.add(h3);
                            fVar6.f1335f = -this.b.Q[3].d();
                            h3.f1340k.add(fVar6);
                        }
                        this.f1359h.b = true;
                        this.f1360i.b = true;
                    }
                    dVar2 = this.b;
                    if (dVar2.D) {
                        fVar3 = this.f1350k;
                        fVar4 = this.f1359h;
                    } else {
                        return;
                    }
                } else if (cVarArr[2].f1295f != null) {
                    f h4 = h(cVarArr[2]);
                    if (h4 != null) {
                        f fVar7 = this.f1359h;
                        int d3 = this.b.Q[2].d();
                        fVar7.f1341l.add(h4);
                        fVar7.f1335f = d3;
                        h4.f1340k.add(fVar7);
                        b(this.f1360i, this.f1359h, this.f1356e.f1336g);
                        dVar2 = this.b;
                        if (dVar2.D) {
                            fVar3 = this.f1350k;
                            fVar4 = this.f1359h;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (cVarArr[3].f1295f != null) {
                    f h5 = h(cVarArr[3]);
                    if (h5 != null) {
                        f fVar8 = this.f1360i;
                        fVar8.f1341l.add(h5);
                        fVar8.f1335f = -this.b.Q[3].d();
                        h5.f1340k.add(fVar8);
                        b(this.f1359h, this.f1360i, -this.f1356e.f1336g);
                    }
                    dVar2 = this.b;
                    if (dVar2.D) {
                        fVar3 = this.f1350k;
                        fVar4 = this.f1359h;
                    } else {
                        return;
                    }
                } else if (cVarArr[4].f1295f != null) {
                    f h6 = h(cVarArr[4]);
                    if (h6 != null) {
                        f fVar9 = this.f1350k;
                        fVar9.f1341l.add(h6);
                        fVar9.f1335f = 0;
                        h6.f1340k.add(fVar9);
                        b(this.f1359h, this.f1350k, -this.b.b0);
                        b(this.f1360i, this.f1359h, this.f1356e.f1336g);
                        return;
                    }
                    return;
                } else if (!(dVar6 instanceof g) && dVar6.U != null && dVar6.i(c.a.CENTER).f1295f == null) {
                    d dVar7 = this.b;
                    b(this.f1359h, dVar7.U.f1308e.f1359h, dVar7.t());
                    b(this.f1360i, this.f1359h, this.f1356e.f1336g);
                    dVar2 = this.b;
                    if (dVar2.D) {
                        fVar3 = this.f1350k;
                        fVar4 = this.f1359h;
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
        if (z || this.f1355d != aVar3) {
            gVar2.f1340k.add(this);
            if (gVar2.f1339j) {
                a(this);
            }
        } else {
            d dVar8 = this.b;
            int i2 = dVar8.r;
            if (i2 == 2) {
                d dVar9 = dVar8.U;
                if (dVar9 != null) {
                    g gVar3 = dVar9.f1308e.f1356e;
                    gVar2.f1341l.add(gVar3);
                    list = gVar3.f1340k;
                }
            } else if (i2 == 3 && !dVar8.y()) {
                d dVar10 = this.b;
                if (dVar10.q != 3) {
                    g gVar4 = dVar10.f1307d.f1356e;
                    this.f1356e.f1341l.add(gVar4);
                    list = gVar4.f1340k;
                }
            }
            list.add(this.f1356e);
            g gVar5 = this.f1356e;
            gVar5.b = true;
            gVar5.f1340k.add(this.f1359h);
            this.f1356e.f1340k.add(this.f1360i);
        }
        d dVar11 = this.b;
        c[] cVarArr2 = dVar11.Q;
        if (cVarArr2[2].f1295f == null || cVarArr2[3].f1295f == null) {
            if (cVarArr2[2].f1295f != null) {
                f h7 = h(cVarArr2[2]);
                if (h7 != null) {
                    f fVar10 = this.f1359h;
                    int d4 = this.b.Q[2].d();
                    fVar10.f1341l.add(h7);
                    fVar10.f1335f = d4;
                    h7.f1340k.add(fVar10);
                    c(this.f1360i, this.f1359h, 1, this.f1356e);
                    if (this.b.D) {
                        c(this.f1350k, this.f1359h, 1, this.f1351l);
                    }
                    if (this.f1355d == aVar3) {
                        d dVar12 = this.b;
                        if (dVar12.X > 0.0f) {
                            kVar = dVar12.f1307d;
                        }
                    }
                }
                if (this.f1356e.f1341l.size() != 0) {
                    this.f1356e.c = true;
                    return;
                }
                return;
            }
            if (cVarArr2[3].f1295f != null) {
                f h8 = h(cVarArr2[3]);
                if (h8 != null) {
                    f fVar11 = this.f1360i;
                    fVar11.f1341l.add(h8);
                    fVar11.f1335f = -this.b.Q[3].d();
                    h8.f1340k.add(fVar11);
                    c(this.f1359h, this.f1360i, -1, this.f1356e);
                }
            } else if (cVarArr2[4].f1295f != null) {
                f h9 = h(cVarArr2[4]);
                if (h9 != null) {
                    f fVar12 = this.f1350k;
                    fVar12.f1341l.add(h9);
                    fVar12.f1335f = 0;
                    h9.f1340k.add(fVar12);
                    c(this.f1359h, this.f1350k, -1, this.f1351l);
                    fVar = this.f1360i;
                    fVar2 = this.f1359h;
                    gVar = this.f1356e;
                    c(fVar, fVar2, 1, gVar);
                }
            } else if (!(dVar11 instanceof g) && (dVar = dVar11.U) != null) {
                b(this.f1359h, dVar.f1308e.f1359h, dVar11.t());
                c(this.f1360i, this.f1359h, 1, this.f1356e);
                if (this.b.D) {
                    c(this.f1350k, this.f1359h, 1, this.f1351l);
                }
                if (this.f1355d == aVar3) {
                    d dVar13 = this.b;
                    if (dVar13.X > 0.0f) {
                        kVar = dVar13.f1307d;
                    }
                }
            }
            if (this.f1356e.f1341l.size() != 0) {
            }
            kVar.f1356e.f1340k.add(this.f1356e);
            this.f1356e.f1341l.add(this.b.f1307d.f1356e);
            this.f1356e.a = this;
            if (this.f1356e.f1341l.size() != 0) {
            }
        } else if (dVar11.y()) {
            this.f1359h.f1335f = this.b.Q[2].d();
            this.f1360i.f1335f = -this.b.Q[3].d();
        } else {
            f h10 = h(this.b.Q[2]);
            f h11 = h(this.b.Q[3]);
            if (h10 != null) {
                h10.f1340k.add(this);
                if (h10.f1339j) {
                    a(this);
                }
            }
            if (h11 != null) {
                h11.f1340k.add(this);
                if (h11.f1339j) {
                    a(this);
                }
            }
            this.f1361j = o.a.CENTER;
        }
        fVar = this.f1350k;
        fVar2 = this.f1359h;
        gVar = this.f1351l;
        c(fVar, fVar2, 1, gVar);
        if (this.f1356e.f1341l.size() != 0) {
        }
    }

    @Override // e.g.a.i.l.o
    public void e() {
        f fVar = this.f1359h;
        if (fVar.f1339j) {
            this.b.a0 = fVar.f1336g;
        }
    }

    @Override // e.g.a.i.l.o
    public void f() {
        this.c = null;
        this.f1359h.b();
        this.f1360i.b();
        this.f1350k.b();
        this.f1356e.b();
        this.f1358g = false;
    }

    @Override // e.g.a.i.l.o
    public boolean k() {
        return this.f1355d != d.a.MATCH_CONSTRAINT || this.b.r == 0;
    }

    public void m() {
        this.f1358g = false;
        this.f1359h.b();
        this.f1359h.f1339j = false;
        this.f1360i.b();
        this.f1360i.f1339j = false;
        this.f1350k.b();
        this.f1350k.f1339j = false;
        this.f1356e.f1339j = false;
    }

    public String toString() {
        StringBuilder h2 = a.h("VerticalRun ");
        h2.append(this.b.i0);
        return h2.toString();
    }
}
