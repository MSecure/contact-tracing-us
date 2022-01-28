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
    public static int[] f1139k = new int[2];

    public k(d dVar) {
        super(dVar);
        this.f1149h.f1124e = f.a.LEFT;
        this.f1150i.f1124e = f.a.RIGHT;
        this.f1147f = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:99:0x026c, code lost:
        if (r15 != 1) goto L_0x02bc;
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
        float f7;
        f fVar;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        int ordinal = this.f1151j.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            g gVar = this.f1146e;
            if (!gVar.f1129j && this.f1145d == aVar) {
                d dVar2 = this.b;
                int i6 = dVar2.f1105l;
                if (i6 == 2) {
                    d dVar3 = dVar2.P;
                    if (dVar3 != null) {
                        g gVar2 = dVar3.f1097d.f1146e;
                        if (gVar2.f1129j) {
                            f3 = dVar2.q;
                            f4 = (float) gVar2.f1126g;
                        }
                    }
                } else if (i6 == 3) {
                    int i7 = dVar2.m;
                    if (i7 == 0 || i7 == 3) {
                        m mVar = dVar2.f1098e;
                        f fVar2 = mVar.f1149h;
                        f fVar3 = mVar.f1150i;
                        boolean z = dVar2.D.f1085f != null;
                        boolean z2 = dVar2.E.f1085f != null;
                        boolean z3 = dVar2.F.f1085f != null;
                        boolean z4 = dVar2.G.f1085f != null;
                        int i8 = dVar2.T;
                        if (z && z2 && z3 && z4) {
                            float f8 = dVar2.S;
                            if (!fVar2.f1129j || !fVar3.f1129j) {
                                f fVar4 = this.f1149h;
                                if (fVar4.f1129j) {
                                    f fVar5 = this.f1150i;
                                    if (fVar5.f1129j) {
                                        if (fVar2.c && fVar3.c) {
                                            f7 = f8;
                                            m(f1139k, fVar4.f1126g + fVar4.f1125f, fVar5.f1126g - fVar5.f1125f, fVar2.f1131l.get(0).f1126g + fVar2.f1125f, fVar3.f1131l.get(0).f1126g - fVar3.f1125f, f8, i8);
                                            this.f1146e.c(f1139k[0]);
                                            this.b.f1098e.f1146e.c(f1139k[1]);
                                            fVar = this.f1149h;
                                            if (fVar.c && this.f1150i.c && fVar2.c && fVar3.c) {
                                                m(f1139k, fVar.f1131l.get(0).f1126g + this.f1149h.f1125f, this.f1150i.f1131l.get(0).f1126g - this.f1150i.f1125f, fVar2.f1131l.get(0).f1126g + fVar2.f1125f, fVar3.f1131l.get(0).f1126g - fVar3.f1125f, f7, i8);
                                                this.f1146e.c(f1139k[0]);
                                                gVar = this.b.f1098e.f1146e;
                                                i2 = f1139k[1];
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
                                fVar = this.f1149h;
                                if (fVar.c) {
                                    return;
                                }
                                return;
                            }
                            f fVar6 = this.f1149h;
                            if (fVar6.c && this.f1150i.c) {
                                m(f1139k, fVar6.f1131l.get(0).f1126g + this.f1149h.f1125f, this.f1150i.f1131l.get(0).f1126g - this.f1150i.f1125f, fVar2.f1126g + fVar2.f1125f, fVar3.f1126g - fVar3.f1125f, f8, i8);
                                this.f1146e.c(f1139k[0]);
                                this.b.f1098e.f1146e.c(f1139k[1]);
                                return;
                            }
                            return;
                        } else if (z && z3) {
                            f fVar7 = this.f1149h;
                            if (fVar7.c && this.f1150i.c) {
                                float f9 = dVar2.S;
                                int i9 = fVar7.f1131l.get(0).f1126g + this.f1149h.f1125f;
                                int i10 = this.f1150i.f1131l.get(0).f1126g - this.f1150i.f1125f;
                                if (i8 == -1 || i8 == 0) {
                                    i5 = g(i10 - i9, 0);
                                    int i11 = (int) ((((float) i5) * f9) + 0.5f);
                                    i4 = g(i11, 1);
                                    if (i11 != i4) {
                                        f6 = ((float) i4) / f9;
                                    }
                                    this.f1146e.c(i5);
                                    this.b.f1098e.f1146e.c(i4);
                                } else if (i8 == 1) {
                                    i5 = g(i10 - i9, 0);
                                    int i12 = (int) ((((float) i5) / f9) + 0.5f);
                                    i4 = g(i12, 1);
                                    if (i12 != i4) {
                                        f6 = ((float) i4) * f9;
                                    }
                                    this.f1146e.c(i5);
                                    this.b.f1098e.f1146e.c(i4);
                                }
                                i5 = (int) (f6 + 0.5f);
                                this.f1146e.c(i5);
                                this.b.f1098e.f1146e.c(i4);
                            } else {
                                return;
                            }
                        } else if (z2 && z4) {
                            if (fVar2.c && fVar3.c) {
                                float f10 = dVar2.S;
                                int i13 = fVar2.f1131l.get(0).f1126g + fVar2.f1125f;
                                int i14 = fVar3.f1131l.get(0).f1126g - fVar3.f1125f;
                                if (i8 != -1) {
                                    if (i8 == 0) {
                                        i2 = g(i14 - i13, 1);
                                        int i15 = (int) ((((float) i2) * f10) + 0.5f);
                                        i3 = g(i15, 0);
                                        if (i15 != i3) {
                                            f5 = ((float) i3) / f10;
                                            i2 = (int) (f5 + 0.5f);
                                        }
                                        this.f1146e.c(i3);
                                        gVar = this.b.f1098e.f1146e;
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
                                this.f1146e.c(i3);
                                gVar = this.b.f1098e.f1146e;
                                gVar.c(i2);
                            } else {
                                return;
                            }
                        }
                    } else {
                        int i17 = dVar2.T;
                        if (i17 != -1) {
                            if (i17 == 0) {
                                f2 = ((float) dVar2.f1098e.f1146e.f1126g) / dVar2.S;
                                i2 = (int) (f2 + 0.5f);
                                gVar.c(i2);
                            } else if (i17 != 1) {
                                i2 = 0;
                                gVar.c(i2);
                            }
                        }
                        f4 = (float) dVar2.f1098e.f1146e.f1126g;
                        f3 = dVar2.S;
                    }
                }
                f2 = f4 * f3;
                i2 = (int) (f2 + 0.5f);
                gVar.c(i2);
            }
            f fVar8 = this.f1149h;
            if (fVar8.c) {
                f fVar9 = this.f1150i;
                if (fVar9.c) {
                    if (!fVar8.f1129j || !fVar9.f1129j || !this.f1146e.f1129j) {
                        if (!this.f1146e.f1129j && this.f1145d == aVar) {
                            d dVar4 = this.b;
                            if (dVar4.f1105l == 0 && !dVar4.w()) {
                                int i18 = this.f1149h.f1131l.get(0).f1126g;
                                f fVar10 = this.f1149h;
                                int i19 = i18 + fVar10.f1125f;
                                int i20 = this.f1150i.f1131l.get(0).f1126g + this.f1150i.f1125f;
                                fVar10.c(i19);
                                this.f1150i.c(i20);
                                this.f1146e.c(i20 - i19);
                                return;
                            }
                        }
                        if (!this.f1146e.f1129j && this.f1145d == aVar && this.a == 1 && this.f1149h.f1131l.size() > 0 && this.f1150i.f1131l.size() > 0) {
                            int min = Math.min((this.f1150i.f1131l.get(0).f1126g + this.f1150i.f1125f) - (this.f1149h.f1131l.get(0).f1126g + this.f1149h.f1125f), this.f1146e.m);
                            d dVar5 = this.b;
                            int i21 = dVar5.p;
                            int max = Math.max(dVar5.o, min);
                            if (i21 > 0) {
                                max = Math.min(i21, max);
                            }
                            this.f1146e.c(max);
                        }
                        if (this.f1146e.f1129j) {
                            f fVar11 = this.f1149h.f1131l.get(0);
                            f fVar12 = this.f1150i.f1131l.get(0);
                            int i22 = fVar11.f1126g;
                            f fVar13 = this.f1149h;
                            int i23 = fVar13.f1125f + i22;
                            int i24 = fVar12.f1126g;
                            int i25 = this.f1150i.f1125f + i24;
                            float f11 = this.b.Z;
                            if (fVar11 == fVar12) {
                                f11 = 0.5f;
                            } else {
                                i22 = i23;
                                i24 = i25;
                            }
                            fVar13.c((int) ((((float) ((i24 - i22) - this.f1146e.f1126g)) * f11) + ((float) i22) + 0.5f));
                            this.f1150i.c(this.f1149h.f1126g + this.f1146e.f1126g);
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
            this.f1146e.c(dVar5.r());
        }
        if (!this.f1146e.f1129j) {
            d.a m = this.b.m();
            this.f1145d = m;
            if (m != aVar) {
                if (m == aVar2 && (((dVar4 = this.b.P) != null && dVar4.m() == aVar3) || dVar4.m() == aVar2)) {
                    int r = (dVar4.r() - this.b.D.d()) - this.b.F.d();
                    b(this.f1149h, dVar4.f1097d.f1149h, this.b.D.d());
                    b(this.f1150i, dVar4.f1097d.f1150i, -this.b.F.d());
                    this.f1146e.c(r);
                    return;
                } else if (this.f1145d == aVar3) {
                    this.f1146e.c(this.b.r());
                }
            }
        } else if (this.f1145d == aVar2 && (((dVar3 = this.b.P) != null && dVar3.m() == aVar3) || dVar3.m() == aVar2)) {
            b(this.f1149h, dVar3.f1097d.f1149h, this.b.D.d());
            b(this.f1150i, dVar3.f1097d.f1150i, -this.b.F.d());
            return;
        }
        g gVar = this.f1146e;
        if (gVar.f1129j) {
            d dVar6 = this.b;
            if (dVar6.a) {
                c[] cVarArr = dVar6.L;
                if (cVarArr[0].f1085f == null || cVarArr[1].f1085f == null) {
                    if (cVarArr[0].f1085f != null) {
                        f h2 = h(cVarArr[0]);
                        if (h2 != null) {
                            f fVar5 = this.f1149h;
                            int d2 = this.b.L[0].d();
                            fVar5.f1131l.add(h2);
                            fVar5.f1125f = d2;
                            h2.f1130k.add(fVar5);
                        } else {
                            return;
                        }
                    } else if (cVarArr[1].f1085f != null) {
                        f h3 = h(cVarArr[1]);
                        if (h3 != null) {
                            f fVar6 = this.f1150i;
                            fVar6.f1131l.add(h3);
                            fVar6.f1125f = -this.b.L[1].d();
                            h3.f1130k.add(fVar6);
                            fVar4 = this.f1149h;
                            fVar3 = this.f1150i;
                            i2 = -this.f1146e.f1126g;
                            b(fVar4, fVar3, i2);
                            return;
                        }
                        return;
                    } else if (!(dVar6 instanceof g) && dVar6.P != null && dVar6.i(c.a.CENTER).f1085f == null) {
                        d dVar7 = this.b;
                        b(this.f1149h, dVar7.P.f1097d.f1149h, dVar7.s());
                    } else {
                        return;
                    }
                    fVar4 = this.f1150i;
                    fVar3 = this.f1149h;
                    i2 = this.f1146e.f1126g;
                    b(fVar4, fVar3, i2);
                    return;
                } else if (dVar6.w()) {
                    this.f1149h.f1125f = this.b.L[0].d();
                    fVar = this.f1150i;
                    cVar = this.b.L[1];
                    fVar.f1125f = -cVar.d();
                } else {
                    f h4 = h(this.b.L[0]);
                    if (h4 != null) {
                        f fVar7 = this.f1149h;
                        int d3 = this.b.L[0].d();
                        fVar7.f1131l.add(h4);
                        fVar7.f1125f = d3;
                        h4.f1130k.add(fVar7);
                    }
                    f h5 = h(this.b.L[1]);
                    if (h5 != null) {
                        f fVar8 = this.f1150i;
                        fVar8.f1131l.add(h5);
                        fVar8.f1125f = -this.b.L[1].d();
                        h5.f1130k.add(fVar8);
                    }
                    this.f1149h.b = true;
                    this.f1150i.b = true;
                    return;
                }
            }
        }
        if (this.f1145d == aVar) {
            d dVar8 = this.b;
            int i3 = dVar8.f1105l;
            if (i3 == 2) {
                d dVar9 = dVar8.P;
                if (dVar9 != null) {
                    g gVar2 = dVar9.f1098e.f1146e;
                    gVar.f1131l.add(gVar2);
                    gVar2.f1130k.add(this.f1146e);
                    g gVar3 = this.f1146e;
                    gVar3.b = true;
                    gVar3.f1130k.add(this.f1149h);
                    list = this.f1146e.f1130k;
                    dVar2 = this.f1150i;
                }
            } else if (i3 == 3) {
                if (dVar8.m == 3) {
                    this.f1149h.a = this;
                    this.f1150i.a = this;
                    m mVar = dVar8.f1098e;
                    mVar.f1149h.a = this;
                    mVar.f1150i.a = this;
                    gVar.a = this;
                    if (dVar8.x()) {
                        this.f1146e.f1131l.add(this.b.f1098e.f1146e);
                        this.b.f1098e.f1146e.f1130k.add(this.f1146e);
                        m mVar2 = this.b.f1098e;
                        mVar2.f1146e.a = this;
                        this.f1146e.f1131l.add(mVar2.f1149h);
                        this.f1146e.f1131l.add(this.b.f1098e.f1150i);
                        this.b.f1098e.f1149h.f1130k.add(this.f1146e);
                        list = this.b.f1098e.f1150i.f1130k;
                        dVar2 = this.f1146e;
                    } else if (this.b.w()) {
                        this.b.f1098e.f1146e.f1131l.add(this.f1146e);
                        list = this.f1146e.f1130k;
                        dVar2 = this.b.f1098e.f1146e;
                    } else {
                        fVar2 = this.b.f1098e.f1146e;
                    }
                } else {
                    g gVar4 = dVar8.f1098e.f1146e;
                    gVar.f1131l.add(gVar4);
                    gVar4.f1130k.add(this.f1146e);
                    this.b.f1098e.f1149h.f1130k.add(this.f1146e);
                    this.b.f1098e.f1150i.f1130k.add(this.f1146e);
                    g gVar5 = this.f1146e;
                    gVar5.b = true;
                    gVar5.f1130k.add(this.f1149h);
                    this.f1146e.f1130k.add(this.f1150i);
                    this.f1149h.f1131l.add(this.f1146e);
                    fVar2 = this.f1150i;
                }
                list = fVar2.f1131l;
                dVar2 = this.f1146e;
            }
            list.add(dVar2);
        }
        d dVar10 = this.b;
        c[] cVarArr2 = dVar10.L;
        if (cVarArr2[0].f1085f == null || cVarArr2[1].f1085f == null) {
            if (cVarArr2[0].f1085f != null) {
                f h6 = h(cVarArr2[0]);
                if (h6 != null) {
                    f fVar9 = this.f1149h;
                    int d4 = this.b.L[0].d();
                    fVar9.f1131l.add(h6);
                    fVar9.f1125f = d4;
                    h6.f1130k.add(fVar9);
                } else {
                    return;
                }
            } else if (cVarArr2[1].f1085f != null) {
                f h7 = h(cVarArr2[1]);
                if (h7 != null) {
                    f fVar10 = this.f1150i;
                    fVar10.f1131l.add(h7);
                    fVar10.f1125f = -this.b.L[1].d();
                    h7.f1130k.add(fVar10);
                    c(this.f1149h, this.f1150i, -1, this.f1146e);
                    return;
                }
                return;
            } else if (!(dVar10 instanceof g) && (dVar = dVar10.P) != null) {
                b(this.f1149h, dVar.f1097d.f1149h, dVar10.s());
            } else {
                return;
            }
            c(this.f1150i, this.f1149h, 1, this.f1146e);
        } else if (dVar10.w()) {
            this.f1149h.f1125f = this.b.L[0].d();
            fVar = this.f1150i;
            cVar = this.b.L[1];
            fVar.f1125f = -cVar.d();
        } else {
            f h8 = h(this.b.L[0]);
            f h9 = h(this.b.L[1]);
            h8.f1130k.add(this);
            if (h8.f1129j) {
                a(this);
            }
            h9.f1130k.add(this);
            if (h9.f1129j) {
                a(this);
            }
            this.f1151j = o.a.CENTER;
        }
    }

    @Override // e.g.b.h.l.o
    public void e() {
        f fVar = this.f1149h;
        if (fVar.f1129j) {
            this.b.U = fVar.f1126g;
        }
    }

    @Override // e.g.b.h.l.o
    public void f() {
        this.c = null;
        this.f1149h.b();
        this.f1150i.b();
        this.f1146e.b();
        this.f1148g = false;
    }

    @Override // e.g.b.h.l.o
    public boolean k() {
        return this.f1145d != d.a.MATCH_CONSTRAINT || this.b.f1105l == 0;
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
        this.f1148g = false;
        this.f1149h.b();
        this.f1149h.f1129j = false;
        this.f1150i.b();
        this.f1150i.f1129j = false;
        this.f1146e.f1129j = false;
    }

    public String toString() {
        StringBuilder i2 = a.i("HorizontalRun ");
        i2.append(this.b.d0);
        return i2.toString();
    }
}
