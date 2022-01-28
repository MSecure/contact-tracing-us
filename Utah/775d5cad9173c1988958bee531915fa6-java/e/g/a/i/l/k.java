package e.g.a.i.l;

import e.g.a.i.c;
import e.g.a.i.d;
import e.g.a.i.g;
import e.g.a.i.l.f;
import e.g.a.i.l.o;
import f.a.a.a.a;
import java.util.List;

public class k extends o {

    /* renamed from: k  reason: collision with root package name */
    public static int[] f1349k = new int[2];

    public k(d dVar) {
        super(dVar);
        this.f1359h.f1334e = f.a.LEFT;
        this.f1360i.f1334e = f.a.RIGHT;
        this.f1357f = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:99:0x026c, code lost:
        if (r15 != 1) goto L_0x02bc;
     */
    @Override // e.g.a.i.l.d, e.g.a.i.l.o
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
        int ordinal = this.f1361j.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            g gVar = this.f1356e;
            if (!gVar.f1339j && this.f1355d == aVar) {
                d dVar2 = this.b;
                int i6 = dVar2.q;
                if (i6 == 2) {
                    d dVar3 = dVar2.U;
                    if (dVar3 != null) {
                        g gVar2 = dVar3.f1307d.f1356e;
                        if (gVar2.f1339j) {
                            f3 = dVar2.v;
                            f4 = (float) gVar2.f1336g;
                        }
                    }
                } else if (i6 == 3) {
                    int i7 = dVar2.r;
                    if (i7 == 0 || i7 == 3) {
                        m mVar = dVar2.f1308e;
                        f fVar2 = mVar.f1359h;
                        f fVar3 = mVar.f1360i;
                        boolean z = dVar2.I.f1295f != null;
                        boolean z2 = dVar2.J.f1295f != null;
                        boolean z3 = dVar2.K.f1295f != null;
                        boolean z4 = dVar2.L.f1295f != null;
                        int i8 = dVar2.Y;
                        if (z && z2 && z3 && z4) {
                            float f8 = dVar2.X;
                            if (!fVar2.f1339j || !fVar3.f1339j) {
                                f fVar4 = this.f1359h;
                                if (fVar4.f1339j) {
                                    f fVar5 = this.f1360i;
                                    if (fVar5.f1339j) {
                                        if (fVar2.c && fVar3.c) {
                                            f7 = f8;
                                            m(f1349k, fVar4.f1336g + fVar4.f1335f, fVar5.f1336g - fVar5.f1335f, fVar2.f1341l.get(0).f1336g + fVar2.f1335f, fVar3.f1341l.get(0).f1336g - fVar3.f1335f, f8, i8);
                                            this.f1356e.c(f1349k[0]);
                                            this.b.f1308e.f1356e.c(f1349k[1]);
                                            fVar = this.f1359h;
                                            if (fVar.c && this.f1360i.c && fVar2.c && fVar3.c) {
                                                m(f1349k, fVar.f1341l.get(0).f1336g + this.f1359h.f1335f, this.f1360i.f1341l.get(0).f1336g - this.f1360i.f1335f, fVar2.f1341l.get(0).f1336g + fVar2.f1335f, fVar3.f1341l.get(0).f1336g - fVar3.f1335f, f7, i8);
                                                this.f1356e.c(f1349k[0]);
                                                gVar = this.b.f1308e.f1356e;
                                                i2 = f1349k[1];
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
                                fVar = this.f1359h;
                                if (fVar.c) {
                                    return;
                                }
                                return;
                            }
                            f fVar6 = this.f1359h;
                            if (fVar6.c && this.f1360i.c) {
                                m(f1349k, fVar6.f1341l.get(0).f1336g + this.f1359h.f1335f, this.f1360i.f1341l.get(0).f1336g - this.f1360i.f1335f, fVar2.f1336g + fVar2.f1335f, fVar3.f1336g - fVar3.f1335f, f8, i8);
                                this.f1356e.c(f1349k[0]);
                                this.b.f1308e.f1356e.c(f1349k[1]);
                                return;
                            }
                            return;
                        } else if (z && z3) {
                            f fVar7 = this.f1359h;
                            if (fVar7.c && this.f1360i.c) {
                                float f9 = dVar2.X;
                                int i9 = fVar7.f1341l.get(0).f1336g + this.f1359h.f1335f;
                                int i10 = this.f1360i.f1341l.get(0).f1336g - this.f1360i.f1335f;
                                if (i8 == -1 || i8 == 0) {
                                    i5 = g(i10 - i9, 0);
                                    int i11 = (int) ((((float) i5) * f9) + 0.5f);
                                    i4 = g(i11, 1);
                                    if (i11 != i4) {
                                        f6 = ((float) i4) / f9;
                                    }
                                    this.f1356e.c(i5);
                                    this.b.f1308e.f1356e.c(i4);
                                } else if (i8 == 1) {
                                    i5 = g(i10 - i9, 0);
                                    int i12 = (int) ((((float) i5) / f9) + 0.5f);
                                    i4 = g(i12, 1);
                                    if (i12 != i4) {
                                        f6 = ((float) i4) * f9;
                                    }
                                    this.f1356e.c(i5);
                                    this.b.f1308e.f1356e.c(i4);
                                }
                                i5 = (int) (f6 + 0.5f);
                                this.f1356e.c(i5);
                                this.b.f1308e.f1356e.c(i4);
                            } else {
                                return;
                            }
                        } else if (z2 && z4) {
                            if (fVar2.c && fVar3.c) {
                                float f10 = dVar2.X;
                                int i13 = fVar2.f1341l.get(0).f1336g + fVar2.f1335f;
                                int i14 = fVar3.f1341l.get(0).f1336g - fVar3.f1335f;
                                if (i8 != -1) {
                                    if (i8 == 0) {
                                        i2 = g(i14 - i13, 1);
                                        int i15 = (int) ((((float) i2) * f10) + 0.5f);
                                        i3 = g(i15, 0);
                                        if (i15 != i3) {
                                            f5 = ((float) i3) / f10;
                                            i2 = (int) (f5 + 0.5f);
                                        }
                                        this.f1356e.c(i3);
                                        gVar = this.b.f1308e.f1356e;
                                        gVar.c(i2);
                                    }
                                }
                                i2 = g(i14 - i13, 1);
                                int i16 = (int) ((((float) i2) / f10) + 0.5f);
                                i3 = g(i16, 0);
                                if (i16 != i3) {
                                    f5 = ((float) i3) * f10;
                                    i2 = (int) (f5 + 0.5f);
                                }
                                this.f1356e.c(i3);
                                gVar = this.b.f1308e.f1356e;
                                gVar.c(i2);
                            } else {
                                return;
                            }
                        }
                    } else {
                        int i17 = dVar2.Y;
                        if (i17 != -1) {
                            if (i17 == 0) {
                                f2 = ((float) dVar2.f1308e.f1356e.f1336g) / dVar2.X;
                                i2 = (int) (f2 + 0.5f);
                                gVar.c(i2);
                            } else if (i17 != 1) {
                                i2 = 0;
                                gVar.c(i2);
                            }
                        }
                        f4 = (float) dVar2.f1308e.f1356e.f1336g;
                        f3 = dVar2.X;
                    }
                }
                f2 = f4 * f3;
                i2 = (int) (f2 + 0.5f);
                gVar.c(i2);
            }
            f fVar8 = this.f1359h;
            if (fVar8.c) {
                f fVar9 = this.f1360i;
                if (fVar9.c) {
                    if (!fVar8.f1339j || !fVar9.f1339j || !this.f1356e.f1339j) {
                        if (!this.f1356e.f1339j && this.f1355d == aVar) {
                            d dVar4 = this.b;
                            if (dVar4.q == 0 && !dVar4.x()) {
                                int i18 = this.f1359h.f1341l.get(0).f1336g;
                                f fVar10 = this.f1359h;
                                int i19 = i18 + fVar10.f1335f;
                                int i20 = this.f1360i.f1341l.get(0).f1336g + this.f1360i.f1335f;
                                fVar10.c(i19);
                                this.f1360i.c(i20);
                                this.f1356e.c(i20 - i19);
                                return;
                            }
                        }
                        if (!this.f1356e.f1339j && this.f1355d == aVar && this.a == 1 && this.f1359h.f1341l.size() > 0 && this.f1360i.f1341l.size() > 0) {
                            int min = Math.min((this.f1360i.f1341l.get(0).f1336g + this.f1360i.f1335f) - (this.f1359h.f1341l.get(0).f1336g + this.f1359h.f1335f), this.f1356e.m);
                            d dVar5 = this.b;
                            int i21 = dVar5.u;
                            int max = Math.max(dVar5.t, min);
                            if (i21 > 0) {
                                max = Math.min(i21, max);
                            }
                            this.f1356e.c(max);
                        }
                        if (this.f1356e.f1339j) {
                            f fVar11 = this.f1359h.f1341l.get(0);
                            f fVar12 = this.f1360i.f1341l.get(0);
                            int i22 = fVar11.f1336g;
                            f fVar13 = this.f1359h;
                            int i23 = fVar13.f1335f + i22;
                            int i24 = fVar12.f1336g;
                            int i25 = this.f1360i.f1335f + i24;
                            float f11 = this.b.e0;
                            if (fVar11 == fVar12) {
                                f11 = 0.5f;
                            } else {
                                i22 = i23;
                                i24 = i25;
                            }
                            fVar13.c((int) ((((float) ((i24 - i22) - this.f1356e.f1336g)) * f11) + ((float) i22) + 0.5f));
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
        d dVar6 = this.b;
        l(dVar6.I, dVar6.K, 0);
    }

    @Override // e.g.a.i.l.o
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
            this.f1356e.c(dVar5.r());
        }
        if (!this.f1356e.f1339j) {
            d.a m = this.b.m();
            this.f1355d = m;
            if (m != aVar) {
                if (m == aVar2 && (dVar4 = this.b.U) != null && (dVar4.m() == aVar3 || dVar4.m() == aVar2)) {
                    int r = (dVar4.r() - this.b.I.d()) - this.b.K.d();
                    b(this.f1359h, dVar4.f1307d.f1359h, this.b.I.d());
                    b(this.f1360i, dVar4.f1307d.f1360i, -this.b.K.d());
                    this.f1356e.c(r);
                    return;
                } else if (this.f1355d == aVar3) {
                    this.f1356e.c(this.b.r());
                }
            }
        } else if (this.f1355d == aVar2 && (dVar3 = this.b.U) != null && (dVar3.m() == aVar3 || dVar3.m() == aVar2)) {
            b(this.f1359h, dVar3.f1307d.f1359h, this.b.I.d());
            b(this.f1360i, dVar3.f1307d.f1360i, -this.b.K.d());
            return;
        }
        g gVar = this.f1356e;
        if (gVar.f1339j) {
            d dVar6 = this.b;
            if (dVar6.a) {
                c[] cVarArr = dVar6.Q;
                if (cVarArr[0].f1295f == null || cVarArr[1].f1295f == null) {
                    if (cVarArr[0].f1295f != null) {
                        f h2 = h(cVarArr[0]);
                        if (h2 != null) {
                            f fVar5 = this.f1359h;
                            int d2 = this.b.Q[0].d();
                            fVar5.f1341l.add(h2);
                            fVar5.f1335f = d2;
                            h2.f1340k.add(fVar5);
                        } else {
                            return;
                        }
                    } else if (cVarArr[1].f1295f != null) {
                        f h3 = h(cVarArr[1]);
                        if (h3 != null) {
                            f fVar6 = this.f1360i;
                            fVar6.f1341l.add(h3);
                            fVar6.f1335f = -this.b.Q[1].d();
                            h3.f1340k.add(fVar6);
                            fVar4 = this.f1359h;
                            fVar3 = this.f1360i;
                            i2 = -this.f1356e.f1336g;
                            b(fVar4, fVar3, i2);
                            return;
                        }
                        return;
                    } else if (!(dVar6 instanceof g) && dVar6.U != null && dVar6.i(c.a.CENTER).f1295f == null) {
                        d dVar7 = this.b;
                        b(this.f1359h, dVar7.U.f1307d.f1359h, dVar7.s());
                    } else {
                        return;
                    }
                    fVar4 = this.f1360i;
                    fVar3 = this.f1359h;
                    i2 = this.f1356e.f1336g;
                    b(fVar4, fVar3, i2);
                    return;
                } else if (dVar6.x()) {
                    this.f1359h.f1335f = this.b.Q[0].d();
                    fVar = this.f1360i;
                    cVar = this.b.Q[1];
                    fVar.f1335f = -cVar.d();
                } else {
                    f h4 = h(this.b.Q[0]);
                    if (h4 != null) {
                        f fVar7 = this.f1359h;
                        int d3 = this.b.Q[0].d();
                        fVar7.f1341l.add(h4);
                        fVar7.f1335f = d3;
                        h4.f1340k.add(fVar7);
                    }
                    f h5 = h(this.b.Q[1]);
                    if (h5 != null) {
                        f fVar8 = this.f1360i;
                        fVar8.f1341l.add(h5);
                        fVar8.f1335f = -this.b.Q[1].d();
                        h5.f1340k.add(fVar8);
                    }
                    this.f1359h.b = true;
                    this.f1360i.b = true;
                    return;
                }
            }
        }
        if (this.f1355d == aVar) {
            d dVar8 = this.b;
            int i3 = dVar8.q;
            if (i3 == 2) {
                d dVar9 = dVar8.U;
                if (dVar9 != null) {
                    g gVar2 = dVar9.f1308e.f1356e;
                    gVar.f1341l.add(gVar2);
                    gVar2.f1340k.add(this.f1356e);
                    g gVar3 = this.f1356e;
                    gVar3.b = true;
                    gVar3.f1340k.add(this.f1359h);
                    list = this.f1356e.f1340k;
                    dVar2 = this.f1360i;
                }
            } else if (i3 == 3) {
                if (dVar8.r == 3) {
                    this.f1359h.a = this;
                    this.f1360i.a = this;
                    m mVar = dVar8.f1308e;
                    mVar.f1359h.a = this;
                    mVar.f1360i.a = this;
                    gVar.a = this;
                    if (dVar8.y()) {
                        this.f1356e.f1341l.add(this.b.f1308e.f1356e);
                        this.b.f1308e.f1356e.f1340k.add(this.f1356e);
                        m mVar2 = this.b.f1308e;
                        mVar2.f1356e.a = this;
                        this.f1356e.f1341l.add(mVar2.f1359h);
                        this.f1356e.f1341l.add(this.b.f1308e.f1360i);
                        this.b.f1308e.f1359h.f1340k.add(this.f1356e);
                        list = this.b.f1308e.f1360i.f1340k;
                        dVar2 = this.f1356e;
                    } else if (this.b.x()) {
                        this.b.f1308e.f1356e.f1341l.add(this.f1356e);
                        list = this.f1356e.f1340k;
                        dVar2 = this.b.f1308e.f1356e;
                    } else {
                        fVar2 = this.b.f1308e.f1356e;
                    }
                } else {
                    g gVar4 = dVar8.f1308e.f1356e;
                    gVar.f1341l.add(gVar4);
                    gVar4.f1340k.add(this.f1356e);
                    this.b.f1308e.f1359h.f1340k.add(this.f1356e);
                    this.b.f1308e.f1360i.f1340k.add(this.f1356e);
                    g gVar5 = this.f1356e;
                    gVar5.b = true;
                    gVar5.f1340k.add(this.f1359h);
                    this.f1356e.f1340k.add(this.f1360i);
                    this.f1359h.f1341l.add(this.f1356e);
                    fVar2 = this.f1360i;
                }
                list = fVar2.f1341l;
                dVar2 = this.f1356e;
            }
            list.add(dVar2);
        }
        d dVar10 = this.b;
        c[] cVarArr2 = dVar10.Q;
        if (cVarArr2[0].f1295f == null || cVarArr2[1].f1295f == null) {
            if (cVarArr2[0].f1295f != null) {
                f h6 = h(cVarArr2[0]);
                if (h6 != null) {
                    f fVar9 = this.f1359h;
                    int d4 = this.b.Q[0].d();
                    fVar9.f1341l.add(h6);
                    fVar9.f1335f = d4;
                    h6.f1340k.add(fVar9);
                } else {
                    return;
                }
            } else if (cVarArr2[1].f1295f != null) {
                f h7 = h(cVarArr2[1]);
                if (h7 != null) {
                    f fVar10 = this.f1360i;
                    fVar10.f1341l.add(h7);
                    fVar10.f1335f = -this.b.Q[1].d();
                    h7.f1340k.add(fVar10);
                    c(this.f1359h, this.f1360i, -1, this.f1356e);
                    return;
                }
                return;
            } else if (!(dVar10 instanceof g) && (dVar = dVar10.U) != null) {
                b(this.f1359h, dVar.f1307d.f1359h, dVar10.s());
            } else {
                return;
            }
            c(this.f1360i, this.f1359h, 1, this.f1356e);
        } else if (dVar10.x()) {
            this.f1359h.f1335f = this.b.Q[0].d();
            fVar = this.f1360i;
            cVar = this.b.Q[1];
            fVar.f1335f = -cVar.d();
        } else {
            f h8 = h(this.b.Q[0]);
            f h9 = h(this.b.Q[1]);
            if (h8 != null) {
                h8.f1340k.add(this);
                if (h8.f1339j) {
                    a(this);
                }
            }
            if (h9 != null) {
                h9.f1340k.add(this);
                if (h9.f1339j) {
                    a(this);
                }
            }
            this.f1361j = o.a.CENTER;
        }
    }

    @Override // e.g.a.i.l.o
    public void e() {
        f fVar = this.f1359h;
        if (fVar.f1339j) {
            this.b.Z = fVar.f1336g;
        }
    }

    @Override // e.g.a.i.l.o
    public void f() {
        this.c = null;
        this.f1359h.b();
        this.f1360i.b();
        this.f1356e.b();
        this.f1358g = false;
    }

    @Override // e.g.a.i.l.o
    public boolean k() {
        return this.f1355d != d.a.MATCH_CONSTRAINT || this.b.q == 0;
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
        this.f1358g = false;
        this.f1359h.b();
        this.f1359h.f1339j = false;
        this.f1360i.b();
        this.f1360i.f1339j = false;
        this.f1356e.f1339j = false;
    }

    public String toString() {
        StringBuilder h2 = a.h("HorizontalRun ");
        h2.append(this.b.i0);
        return h2.toString();
    }
}
