package b.g.b.h;

import b.g.b.b;
import b.g.b.g;
import b.g.b.h.c;
import b.g.b.h.l.f;
import b.g.b.h.l.j;
import b.g.b.h.l.l;
import java.util.ArrayList;

public class d {
    public c A = new c(this, c.a.BOTTOM);
    public c B = new c(this, c.a.BASELINE);
    public c C = new c(this, c.a.CENTER_X);
    public c D = new c(this, c.a.CENTER_Y);
    public c E;
    public c[] F;
    public ArrayList<c> G;
    public a[] H;
    public d I;
    public int J;
    public int K;
    public float L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public float S;
    public float T;
    public Object U;
    public int V;
    public String W;
    public String X;
    public int Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1511a = false;
    public float[] a0;

    /* renamed from: b  reason: collision with root package name */
    public b.g.b.h.l.c f1512b;
    public d[] b0;

    /* renamed from: c  reason: collision with root package name */
    public b.g.b.h.l.c f1513c;
    public d[] c0;

    /* renamed from: d  reason: collision with root package name */
    public j f1514d = new j(this);

    /* renamed from: e  reason: collision with root package name */
    public l f1515e = new l(this);

    /* renamed from: f  reason: collision with root package name */
    public boolean[] f1516f = {true, true};

    /* renamed from: g  reason: collision with root package name */
    public int[] f1517g = {0, 0};
    public int h = -1;
    public int i = -1;
    public int j = 0;
    public int k = 0;
    public int[] l = new int[2];
    public int m = 0;
    public int n = 0;
    public float o = 1.0f;
    public int p = 0;
    public int q = 0;
    public float r = 1.0f;
    public int s = -1;
    public float t = 1.0f;
    public int[] u = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float v = 0.0f;
    public boolean w = false;
    public c x = new c(this, c.a.LEFT);
    public c y = new c(this, c.a.TOP);
    public c z = new c(this, c.a.RIGHT);

    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public d() {
        c cVar = new c(this, c.a.CENTER);
        this.E = cVar;
        this.F = new c[]{this.x, this.z, this.y, this.A, this.B, cVar};
        ArrayList<c> arrayList = new ArrayList<>();
        this.G = arrayList;
        a aVar = a.FIXED;
        this.H = new a[]{aVar, aVar};
        this.I = null;
        this.J = 0;
        this.K = 0;
        this.L = 0.0f;
        this.M = -1;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.S = 0.5f;
        this.T = 0.5f;
        this.V = 0;
        this.W = null;
        this.X = null;
        this.Y = 0;
        this.Z = 0;
        this.a0 = new float[]{-1.0f, -1.0f};
        this.b0 = new d[]{null, null};
        this.c0 = new d[]{null, null};
        arrayList.add(this.x);
        this.G.add(this.y);
        this.G.add(this.z);
        this.G.add(this.A);
        this.G.add(this.C);
        this.G.add(this.D);
        this.G.add(this.E);
        this.G.add(this.B);
    }

    public void A(a aVar) {
        this.H[1] = aVar;
    }

    public void B(int i2) {
        this.J = i2;
        int i3 = this.Q;
        if (i2 < i3) {
            this.J = i3;
        }
    }

    public void C(boolean z2, boolean z3) {
        int i2;
        int i3;
        a aVar = a.FIXED;
        j jVar = this.f1514d;
        boolean z4 = z2 & jVar.f1563g;
        l lVar = this.f1515e;
        boolean z5 = z3 & lVar.f1563g;
        int i4 = jVar.h.f1547g;
        int i5 = lVar.h.f1547g;
        int i6 = jVar.i.f1547g;
        int i7 = lVar.i.f1547g;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i7 = 0;
            i4 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (z4) {
            this.N = i4;
        }
        if (z5) {
            this.O = i5;
        }
        if (this.V == 8) {
            this.J = 0;
            this.K = 0;
            return;
        }
        if (z4) {
            if (this.H[0] == aVar && i9 < (i3 = this.J)) {
                i9 = i3;
            }
            this.J = i9;
            int i11 = this.Q;
            if (i9 < i11) {
                this.J = i11;
            }
        }
        if (z5) {
            if (this.H[1] == aVar && i10 < (i2 = this.K)) {
                i10 = i2;
            }
            this.K = i10;
            int i12 = this.R;
            if (i10 < i12) {
                this.K = i12;
            }
        }
    }

    public void D(b.g.b.d dVar) {
        int i2;
        int i3;
        int o2 = dVar.o(this.x);
        int o3 = dVar.o(this.y);
        int o4 = dVar.o(this.z);
        int o5 = dVar.o(this.A);
        j jVar = this.f1514d;
        f fVar = jVar.h;
        if (fVar.j) {
            f fVar2 = jVar.i;
            if (fVar2.j) {
                o2 = fVar.f1547g;
                o4 = fVar2.f1547g;
            }
        }
        l lVar = this.f1515e;
        f fVar3 = lVar.h;
        if (fVar3.j) {
            f fVar4 = lVar.i;
            if (fVar4.j) {
                o3 = fVar3.f1547g;
                o5 = fVar4.f1547g;
            }
        }
        int i4 = o5 - o3;
        if (o4 - o2 < 0 || i4 < 0 || o2 == Integer.MIN_VALUE || o2 == Integer.MAX_VALUE || o3 == Integer.MIN_VALUE || o3 == Integer.MAX_VALUE || o4 == Integer.MIN_VALUE || o4 == Integer.MAX_VALUE || o5 == Integer.MIN_VALUE || o5 == Integer.MAX_VALUE) {
            o5 = 0;
            o2 = 0;
            o3 = 0;
            o4 = 0;
        }
        a aVar = a.FIXED;
        int i5 = o4 - o2;
        int i6 = o5 - o3;
        this.N = o2;
        this.O = o3;
        if (this.V == 8) {
            this.J = 0;
            this.K = 0;
            return;
        }
        if (this.H[0] == aVar && i5 < (i3 = this.J)) {
            i5 = i3;
        }
        if (this.H[1] == aVar && i6 < (i2 = this.K)) {
            i6 = i2;
        }
        this.J = i5;
        this.K = i6;
        int i7 = this.R;
        if (i6 < i7) {
            this.K = i7;
        }
        int i8 = this.J;
        int i9 = this.Q;
        if (i8 < i9) {
            this.J = i9;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:278:0x04b2, code lost:
        if (r13.V == 8) goto L_0x04b7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0410  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x046b  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x046e  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x052a  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0530  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0554  */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x055e  */
    /* JADX WARNING: Removed duplicated region for block: B:308:? A[RETURN, SYNTHETIC] */
    public void b(b.g.b.d dVar) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i2;
        int i3;
        boolean z6;
        int i4;
        char c2;
        int i5;
        boolean z7;
        char c3;
        a aVar;
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        f fVar;
        int i6;
        b.g.b.d dVar2;
        g gVar6;
        g gVar7;
        int i7;
        int i8;
        int i9;
        g gVar8;
        g gVar9;
        g gVar10;
        d dVar3;
        g gVar11;
        g gVar12;
        g gVar13;
        g gVar14;
        b.g.b.d dVar4;
        boolean z8;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z9;
        boolean z10;
        d dVar5 = this;
        a aVar2 = a.WRAP_CONTENT;
        a aVar3 = a.MATCH_CONSTRAINT;
        g l2 = dVar.l(dVar5.x);
        g l3 = dVar.l(dVar5.z);
        g l4 = dVar.l(dVar5.y);
        g l5 = dVar.l(dVar5.A);
        g l6 = dVar.l(dVar5.B);
        j jVar = dVar5.f1514d;
        f fVar2 = jVar.h;
        if (fVar2.j && jVar.i.j) {
            l lVar = dVar5.f1515e;
            if (lVar.h.j && lVar.i.j) {
                dVar.e(l2, fVar2.f1547g);
                dVar.e(l3, dVar5.f1514d.i.f1547g);
                dVar.e(l4, dVar5.f1515e.h.f1547g);
                dVar.e(l5, dVar5.f1515e.i.f1547g);
                dVar.e(l6, dVar5.f1515e.k.f1547g);
                d dVar6 = dVar5.I;
                if (dVar6 != null) {
                    boolean z11 = dVar6 != null && dVar6.H[0] == aVar2;
                    d dVar7 = dVar5.I;
                    boolean z12 = dVar7 != null && dVar7.H[1] == aVar2;
                    if (z11 && dVar5.f1516f[0] && !s()) {
                        dVar.f(dVar.l(dVar5.I.z), l3, 0, 7);
                    }
                    if (z12 && dVar5.f1516f[1] && !t()) {
                        dVar.f(dVar.l(dVar5.I.A), l5, 0, 7);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        d dVar8 = dVar5.I;
        if (dVar8 != null) {
            boolean z13 = dVar8 != null && dVar8.H[0] == aVar2;
            d dVar9 = dVar5.I;
            boolean z14 = dVar9 != null && dVar9.H[1] == aVar2;
            if (dVar5.r(0)) {
                ((e) dVar5.I).F(dVar5, 0);
                z9 = true;
            } else {
                z9 = s();
            }
            if (dVar5.r(1)) {
                ((e) dVar5.I).F(dVar5, 1);
                z10 = true;
            } else {
                z10 = t();
            }
            if (!z9 && z13 && dVar5.V != 8 && dVar5.x.f1501c == null && dVar5.z.f1501c == null) {
                dVar.f(dVar.l(dVar5.I.z), l3, 0, 1);
            }
            if (!z10 && z14 && dVar5.V != 8 && dVar5.y.f1501c == null && dVar5.A.f1501c == null && dVar5.B == null) {
                dVar.f(dVar.l(dVar5.I.A), l5, 0, 1);
            }
            z4 = z13;
            z5 = z14;
            z2 = z9;
            z3 = z10;
        } else {
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
        }
        int i14 = dVar5.J;
        int i15 = dVar5.Q;
        if (i14 < i15) {
            i14 = i15;
        }
        int i16 = dVar5.K;
        int i17 = dVar5.R;
        if (i16 < i17) {
            i16 = i17;
        }
        boolean z15 = dVar5.H[0] != aVar3;
        boolean z16 = dVar5.H[1] != aVar3;
        dVar5.s = dVar5.M;
        float f2 = dVar5.L;
        dVar5.t = f2;
        int i18 = dVar5.j;
        int i19 = dVar5.k;
        if (f2 <= 0.0f || dVar5.V == 8) {
            c2 = 0;
            i4 = i16;
            i3 = i19;
            i2 = i18;
            z6 = false;
        } else {
            if (dVar5.H[0] == aVar3 && i18 == 0) {
                i18 = 3;
            }
            if (dVar5.H[1] == aVar3 && i19 == 0) {
                i19 = 3;
            }
            a[] aVarArr = dVar5.H;
            if (aVarArr[0] == aVar3 && aVarArr[1] == aVar3 && i18 == 3 && i19 == 3) {
                if (dVar5.s == -1) {
                    if (z15 && !z16) {
                        dVar5.s = 0;
                    } else if (!z15 && z16) {
                        dVar5.s = 1;
                        if (dVar5.M == -1) {
                            dVar5.t = 1.0f / dVar5.t;
                        }
                    }
                }
                if (dVar5.s != 0 || (dVar5.y.c() && dVar5.A.c())) {
                    if (dVar5.s == 1 && (!dVar5.x.c() || !dVar5.z.c())) {
                        i13 = 0;
                    }
                    if (dVar5.s == -1 && (!dVar5.y.c() || !dVar5.A.c() || !dVar5.x.c() || !dVar5.z.c())) {
                        if (!dVar5.y.c() && dVar5.A.c()) {
                            i12 = 0;
                        } else if (dVar5.x.c() && dVar5.z.c()) {
                            dVar5.t = 1.0f / dVar5.t;
                            i12 = 1;
                        }
                        dVar5.s = i12;
                    }
                    if (dVar5.s == -1) {
                        if (dVar5.m > 0 && dVar5.p == 0) {
                            i11 = 0;
                        } else if (dVar5.m == 0 && dVar5.p > 0) {
                            dVar5.t = 1.0f / dVar5.t;
                            i11 = 1;
                        }
                        dVar5.s = i11;
                    }
                } else {
                    i13 = 1;
                }
                dVar5.s = i13;
                if (!dVar5.y.c()) {
                }
                dVar5.t = 1.0f / dVar5.t;
                i12 = 1;
                dVar5.s = i12;
                if (dVar5.s == -1) {
                }
            } else {
                a[] aVarArr2 = dVar5.H;
                if (aVarArr2[0] == aVar3 && i18 == 3) {
                    dVar5.s = 0;
                    int i20 = (int) (dVar5.t * ((float) dVar5.K));
                    i4 = i16;
                    if (aVarArr2[1] != aVar3) {
                        i5 = i20;
                        i3 = i19;
                        i2 = 4;
                        c2 = 0;
                        z6 = false;
                    } else {
                        i5 = i20;
                        z6 = true;
                        i3 = i19;
                        i2 = i18;
                        c2 = 0;
                    }
                    int[] iArr = dVar5.l;
                    iArr[c2] = i2;
                    iArr[1] = i3;
                    if (!z6) {
                    }
                    z7 = false;
                    if (dVar5.H[0] != aVar2) {
                    }
                    if (r21) {
                    }
                    boolean z17 = !dVar5.E.c();
                    g gVar15 = null;
                    if (dVar5.h != 2) {
                    }
                    dVar5 = this;
                    l lVar2 = dVar5.f1515e;
                    fVar = lVar2.h;
                    if (fVar.j) {
                    }
                    dVar2 = dVar;
                    gVar8 = gVar5;
                    gVar7 = gVar4;
                    gVar6 = gVar3;
                    i9 = 7;
                    i8 = 0;
                    i7 = 1;
                    i6 = 1;
                    if ((dVar5.i != 2 ? i8 : i6) == 0) {
                    }
                    if (!z6) {
                    }
                    if (!dVar3.E.c()) {
                    }
                } else if (dVar5.H[1] == aVar3 && i19 == 3) {
                    dVar5.s = 1;
                    if (dVar5.M == -1) {
                        dVar5.t = 1.0f / dVar5.t;
                    }
                    i16 = (int) (dVar5.t * ((float) dVar5.J));
                    c2 = 0;
                    if (dVar5.H[0] != aVar3) {
                        i4 = i16;
                        i2 = i18;
                        z6 = false;
                        i3 = 4;
                    }
                    i4 = i16;
                    i3 = i19;
                    i2 = i18;
                    i5 = i14;
                    z6 = true;
                    int[] iArr2 = dVar5.l;
                    iArr2[c2] = i2;
                    iArr2[1] = i3;
                    if (!z6) {
                        int i21 = dVar5.s;
                        c3 = 65535;
                        if (i21 == 0 || i21 == -1) {
                            z7 = true;
                            boolean z18 = dVar5.H[0] != aVar2 && (dVar5 instanceof e);
                            int i22 = z18 ? 0 : i5;
                            boolean z172 = !dVar5.E.c();
                            g gVar152 = null;
                            if (dVar5.h != 2) {
                                j jVar2 = dVar5.f1514d;
                                f fVar3 = jVar2.h;
                                if (!fVar3.j || !jVar2.i.j) {
                                    d dVar10 = dVar5.I;
                                    g l7 = dVar10 != null ? dVar.l(dVar10.z) : null;
                                    d dVar11 = dVar5.I;
                                    gVar5 = l6;
                                    gVar4 = l5;
                                    gVar3 = l4;
                                    gVar2 = l3;
                                    gVar = l2;
                                    aVar = aVar2;
                                    d(dVar, true, z4, z5, dVar5.f1516f[0], dVar11 != null ? dVar.l(dVar11.x) : null, l7, dVar5.H[0], z18, dVar5.x, dVar5.z, dVar5.N, i22, dVar5.Q, dVar5.u[0], dVar5.S, z7, z2, z3, i2, i3, dVar5.m, dVar5.n, dVar5.o, z172);
                                } else {
                                    dVar.e(l2, fVar3.f1547g);
                                    dVar.e(l3, dVar5.f1514d.i.f1547g);
                                    if (dVar5.I != null && z4 && dVar5.f1516f[0] && !s()) {
                                        dVar.f(dVar.l(dVar5.I.z), l3, 0, 7);
                                    }
                                    gVar4 = l5;
                                    gVar3 = l4;
                                    gVar2 = l3;
                                    gVar = l2;
                                    aVar = aVar2;
                                    gVar5 = l6;
                                    l lVar22 = dVar5.f1515e;
                                    fVar = lVar22.h;
                                    if (fVar.j || !lVar22.i.j) {
                                        dVar2 = dVar;
                                        gVar8 = gVar5;
                                        gVar7 = gVar4;
                                        gVar6 = gVar3;
                                        i9 = 7;
                                        i8 = 0;
                                        i7 = 1;
                                        i6 = 1;
                                    } else {
                                        dVar2 = dVar;
                                        gVar6 = gVar3;
                                        dVar2.e(gVar6, fVar.f1547g);
                                        gVar7 = gVar4;
                                        dVar2.e(gVar7, dVar5.f1515e.i.f1547g);
                                        gVar8 = gVar5;
                                        dVar2.e(gVar8, dVar5.f1515e.k.f1547g);
                                        d dVar12 = dVar5.I;
                                        if (dVar12 == null || z3 || !z5) {
                                            i9 = 7;
                                            i8 = 0;
                                            i7 = 1;
                                        } else {
                                            i7 = 1;
                                            if (dVar5.f1516f[1]) {
                                                i9 = 7;
                                                i8 = 0;
                                                dVar2.f(dVar2.l(dVar12.A), gVar7, 0, 7);
                                            } else {
                                                i9 = 7;
                                                i8 = 0;
                                            }
                                        }
                                        i6 = i8;
                                    }
                                    if ((dVar5.i != 2 ? i8 : i6) == 0) {
                                        boolean z19 = (dVar5.H[i7] != aVar || !(dVar5 instanceof e)) ? i8 : i7;
                                        if (z19) {
                                            i4 = i8;
                                        }
                                        boolean z20 = (!z6 || !((i10 = dVar5.s) == i7 || i10 == -1)) ? i8 : i7;
                                        d dVar13 = dVar5.I;
                                        g l8 = dVar13 != null ? dVar2.l(dVar13.A) : null;
                                        d dVar14 = dVar5.I;
                                        if (dVar14 != null) {
                                            gVar152 = dVar2.l(dVar14.y);
                                        }
                                        int i23 = dVar5.P <= 0 ? 8 : 8;
                                        dVar2.d(gVar8, gVar6, dVar5.P, i9);
                                        c cVar = dVar5.B.f1501c;
                                        if (cVar != null) {
                                            dVar2.d(gVar8, dVar2.l(cVar), i8, i9);
                                            if (z5) {
                                                dVar2.f(l8, dVar2.l(dVar5.A), i8, 5);
                                            }
                                            z8 = i8;
                                            gVar10 = gVar7;
                                            gVar9 = gVar6;
                                            d(dVar, false, z5, z4, dVar5.f1516f[i7], gVar152, l8, dVar5.H[i7], z19, dVar5.y, dVar5.A, dVar5.O, i4, dVar5.R, dVar5.u[i7], dVar5.T, z20, z3, z2, i3, i2, dVar5.p, dVar5.q, dVar5.r, z8);
                                        } else {
                                            if (dVar5.V == i23) {
                                                dVar2.d(gVar8, gVar6, i8, i9);
                                            }
                                            z8 = z172;
                                            gVar10 = gVar7;
                                            gVar9 = gVar6;
                                            d(dVar, false, z5, z4, dVar5.f1516f[i7], gVar152, l8, dVar5.H[i7], z19, dVar5.y, dVar5.A, dVar5.O, i4, dVar5.R, dVar5.u[i7], dVar5.T, z20, z3, z2, i3, i2, dVar5.p, dVar5.q, dVar5.r, z8);
                                        }
                                    } else {
                                        gVar10 = gVar7;
                                        gVar9 = gVar6;
                                    }
                                    if (!z6) {
                                        int i24 = 7;
                                        dVar3 = this;
                                        int i25 = dVar3.s;
                                        float f3 = dVar3.t;
                                        if (i25 == 1) {
                                            dVar4 = dVar;
                                            gVar14 = gVar10;
                                            gVar13 = gVar9;
                                            gVar12 = gVar2;
                                            gVar11 = gVar;
                                        } else {
                                            i24 = 7;
                                            dVar4 = dVar;
                                            gVar14 = gVar2;
                                            gVar13 = gVar;
                                            gVar12 = gVar10;
                                            gVar11 = gVar9;
                                        }
                                        dVar4.h(gVar14, gVar13, gVar12, gVar11, f3, i24);
                                    } else {
                                        dVar3 = this;
                                    }
                                    if (!dVar3.E.c()) {
                                        d dVar15 = dVar3.E.f1501c.f1499a;
                                        int b2 = dVar3.E.b();
                                        c.a aVar4 = c.a.BOTTOM;
                                        c.a aVar5 = c.a.RIGHT;
                                        c.a aVar6 = c.a.TOP;
                                        c.a aVar7 = c.a.LEFT;
                                        g l9 = dVar.l(dVar3.f(aVar7));
                                        g l10 = dVar.l(dVar3.f(aVar6));
                                        g l11 = dVar.l(dVar3.f(aVar5));
                                        g l12 = dVar.l(dVar3.f(aVar4));
                                        g l13 = dVar.l(dVar15.f(aVar7));
                                        g l14 = dVar.l(dVar15.f(aVar6));
                                        g l15 = dVar.l(dVar15.f(aVar5));
                                        g l16 = dVar.l(dVar15.f(aVar4));
                                        b m2 = dVar.m();
                                        double radians = (double) ((float) Math.toRadians((double) (dVar3.v + 90.0f)));
                                        double d2 = (double) b2;
                                        m2.g(l10, l12, l14, l16, (float) (Math.sin(radians) * d2));
                                        dVar.c(m2);
                                        b m3 = dVar.m();
                                        m3.g(l9, l11, l13, l15, (float) (Math.cos(radians) * d2));
                                        dVar.c(m3);
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                gVar4 = l5;
                                gVar3 = l4;
                                gVar2 = l3;
                                gVar = l2;
                                aVar = aVar2;
                                gVar5 = l6;
                            }
                            dVar5 = this;
                            l lVar222 = dVar5.f1515e;
                            fVar = lVar222.h;
                            if (fVar.j) {
                            }
                            dVar2 = dVar;
                            gVar8 = gVar5;
                            gVar7 = gVar4;
                            gVar6 = gVar3;
                            i9 = 7;
                            i8 = 0;
                            i7 = 1;
                            i6 = 1;
                            if ((dVar5.i != 2 ? i8 : i6) == 0) {
                            }
                            if (!z6) {
                            }
                            if (!dVar3.E.c()) {
                            }
                        }
                    } else {
                        c3 = 65535;
                    }
                    z7 = false;
                    if (dVar5.H[0] != aVar2) {
                    }
                    if (z18) {
                    }
                    boolean z1722 = !dVar5.E.c();
                    g gVar1522 = null;
                    if (dVar5.h != 2) {
                    }
                    dVar5 = this;
                    l lVar2222 = dVar5.f1515e;
                    fVar = lVar2222.h;
                    if (fVar.j) {
                    }
                    dVar2 = dVar;
                    gVar8 = gVar5;
                    gVar7 = gVar4;
                    gVar6 = gVar3;
                    i9 = 7;
                    i8 = 0;
                    i7 = 1;
                    i6 = 1;
                    if ((dVar5.i != 2 ? i8 : i6) == 0) {
                    }
                    if (!z6) {
                    }
                    if (!dVar3.E.c()) {
                    }
                }
            }
            c2 = 0;
            i4 = i16;
            i3 = i19;
            i2 = i18;
            i5 = i14;
            z6 = true;
            int[] iArr22 = dVar5.l;
            iArr22[c2] = i2;
            iArr22[1] = i3;
            if (!z6) {
            }
            z7 = false;
            if (dVar5.H[0] != aVar2) {
            }
            if (z18) {
            }
            boolean z17222 = !dVar5.E.c();
            g gVar15222 = null;
            if (dVar5.h != 2) {
            }
            dVar5 = this;
            l lVar22222 = dVar5.f1515e;
            fVar = lVar22222.h;
            if (fVar.j) {
            }
            dVar2 = dVar;
            gVar8 = gVar5;
            gVar7 = gVar4;
            gVar6 = gVar3;
            i9 = 7;
            i8 = 0;
            i7 = 1;
            i6 = 1;
            if ((dVar5.i != 2 ? i8 : i6) == 0) {
            }
            if (!z6) {
            }
            if (!dVar3.E.c()) {
            }
        }
        i5 = i14;
        int[] iArr222 = dVar5.l;
        iArr222[c2] = i2;
        iArr222[1] = i3;
        if (!z6) {
        }
        z7 = false;
        if (dVar5.H[0] != aVar2) {
        }
        if (z18) {
        }
        boolean z172222 = !dVar5.E.c();
        g gVar152222 = null;
        if (dVar5.h != 2) {
        }
        dVar5 = this;
        l lVar222222 = dVar5.f1515e;
        fVar = lVar222222.h;
        if (fVar.j) {
        }
        dVar2 = dVar;
        gVar8 = gVar5;
        gVar7 = gVar4;
        gVar6 = gVar3;
        i9 = 7;
        i8 = 0;
        i7 = 1;
        i6 = 1;
        if ((dVar5.i != 2 ? i8 : i6) == 0) {
        }
        if (!z6) {
        }
        if (!dVar3.E.c()) {
        }
    }

    public boolean c() {
        return this.V != 8;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:147:0x023b, code lost:
        if ((r49 == 2 || r49 == 1) == false) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x03af, code lost:
        if (r4[1] == r6) goto L_0x03b3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0326  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0357 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0370  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x037d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:265:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x018b  */
    public final void d(b.g.b.d dVar, boolean z2, boolean z3, boolean z4, boolean z5, g gVar, g gVar2, a aVar, boolean z6, c cVar, c cVar2, int i2, int i3, int i4, int i5, float f2, boolean z7, boolean z8, boolean z9, int i6, int i7, int i8, int i9, float f3, boolean z10) {
        int i10;
        g gVar3;
        int i11;
        boolean z11;
        boolean z12;
        int i12;
        boolean z13;
        int i13;
        boolean z14;
        int i14;
        boolean z15;
        int i15;
        d dVar2;
        char c2;
        boolean z16;
        g gVar4;
        g gVar5;
        int i16;
        int i17;
        g gVar6;
        int i18;
        g gVar7;
        c cVar3;
        boolean z17;
        g gVar8;
        g gVar9;
        int i19;
        int i20;
        g gVar10;
        int i21;
        boolean z18;
        int i22;
        int i23;
        boolean z19;
        int i24;
        boolean z20;
        boolean z21;
        boolean z22;
        int i25;
        int i26;
        d dVar3;
        g gVar11;
        d dVar4;
        g gVar12;
        d dVar5;
        int i27;
        int i28;
        int i29;
        boolean z23;
        int i30;
        int i31;
        int i32;
        int i33;
        boolean z24;
        int i34;
        int i35;
        g gVar13;
        g gVar14;
        c.a aVar2;
        char c3;
        int i36 = i8;
        int i37 = i9;
        c.a aVar3 = c.a.BOTTOM;
        c.a aVar4 = c.a.TOP;
        g l2 = dVar.l(cVar);
        g l3 = dVar.l(cVar2);
        g l4 = dVar.l(cVar.f1501c);
        g l5 = dVar.l(cVar2.f1501c);
        boolean c4 = cVar.c();
        boolean c5 = cVar2.c();
        boolean c6 = this.E.c();
        if (c5) {
            i10 = (c4 ? 1 : 0) + 1;
        } else {
            i10 = c4 ? 1 : 0;
        }
        if (c6) {
            i10++;
        }
        if (z7) {
            gVar3 = l5;
            i11 = 3;
        } else {
            i11 = i6;
            gVar3 = l5;
        }
        int ordinal = aVar.ordinal();
        if (ordinal != 0 && ordinal != 1 && ordinal == 2) {
            if (i11 != 4) {
                z11 = true;
                if (this.V != 8) {
                    i12 = 0;
                    z12 = false;
                } else {
                    i12 = i3;
                    z12 = z11;
                }
                if (z10) {
                    if (!c4 && !c5 && !c6) {
                        dVar.e(l2, i2);
                    } else if (c4 && !c5) {
                        z13 = c6;
                        i13 = 7;
                        dVar.d(l2, l4, cVar.b(), 7);
                        if (!z12) {
                            if (z6) {
                                c3 = 3;
                                dVar.d(l3, l2, 0, 3);
                                if (i4 > 0) {
                                    dVar.f(l3, l2, i4, i13);
                                }
                                if (i5 < Integer.MAX_VALUE) {
                                    dVar.g(l3, l2, i5, i13);
                                }
                            } else {
                                c3 = 3;
                                dVar.d(l3, l2, i12, i13);
                            }
                            c2 = c3;
                            i35 = 7;
                        } else {
                            c2 = 3;
                            if (i10 == 2 || z7 || !(i11 == 1 || i11 == 0)) {
                                if (i36 == -2) {
                                    i36 = i12;
                                }
                                if (i37 == -2) {
                                    i37 = i12;
                                }
                                if (i12 > 0 && i11 != 1) {
                                    i12 = 0;
                                }
                                if (i36 > 0) {
                                    dVar.f(l3, l2, i36, 7);
                                    i12 = Math.max(i12, i36);
                                }
                                if (i37 > 0) {
                                    if (!z3 || i11 != 1) {
                                        i35 = 7;
                                        dVar.g(l3, l2, i37, 7);
                                    } else {
                                        i35 = 7;
                                    }
                                    i12 = Math.min(i12, i37);
                                } else {
                                    i35 = 7;
                                }
                                if (i11 == 1) {
                                    if (z3) {
                                        dVar.d(l3, l2, i12, i35);
                                    } else {
                                        dVar.d(l3, l2, i12, 5);
                                        dVar.g(l3, l2, i12, i35);
                                    }
                                } else if (i11 == 2) {
                                    c.a aVar5 = cVar.f1500b;
                                    if (aVar5 != aVar4) {
                                        aVar2 = aVar3;
                                        if (aVar5 == aVar2) {
                                            i15 = i35;
                                        } else {
                                            i15 = i35;
                                            dVar2 = this;
                                            gVar13 = dVar.l(dVar2.I.f(c.a.LEFT));
                                            gVar14 = dVar.l(dVar2.I.f(c.a.RIGHT));
                                            b m2 = dVar.m();
                                            m2.d(l3, l2, gVar14, gVar13, f3);
                                            dVar.c(m2);
                                        }
                                    } else {
                                        i15 = i35;
                                        aVar2 = aVar3;
                                    }
                                    dVar2 = this;
                                    g l6 = dVar.l(dVar2.I.f(aVar4));
                                    gVar14 = dVar.l(dVar2.I.f(aVar2));
                                    gVar13 = l6;
                                    b m22 = dVar.m();
                                    m22.d(l3, l2, gVar14, gVar13, f3);
                                    dVar.c(m22);
                                } else {
                                    i15 = i35;
                                    dVar2 = this;
                                    i14 = i36;
                                    z14 = z12;
                                    z15 = true;
                                    if (!z10) {
                                        gVar6 = gVar;
                                        gVar7 = gVar2;
                                        gVar5 = l2;
                                        z16 = z15;
                                        i17 = i10;
                                        i18 = 0;
                                        gVar4 = l3;
                                        i16 = 2;
                                    } else if (z8) {
                                        gVar6 = gVar;
                                        gVar7 = gVar2;
                                        gVar5 = l2;
                                        z16 = z15;
                                        i17 = i10;
                                        i18 = 0;
                                        i16 = 2;
                                        gVar4 = l3;
                                    } else {
                                        if ((c4 || c5 || z13) && (!c4 || c5)) {
                                            if (c4 || !c5) {
                                                gVar8 = gVar3;
                                                i21 = 0;
                                                if (c4 && c5) {
                                                    d dVar6 = cVar.f1501c.f1499a;
                                                    d dVar7 = cVar2.f1501c.f1499a;
                                                    d dVar8 = dVar2.I;
                                                    if (z14) {
                                                        if (i11 == 0) {
                                                            if (i37 == 0 && i14 == 0) {
                                                                i33 = 7;
                                                                i34 = 7;
                                                                z24 = false;
                                                                z18 = true;
                                                            } else {
                                                                i33 = 5;
                                                                i34 = 5;
                                                                z24 = true;
                                                                z18 = false;
                                                            }
                                                            i24 = ((dVar6 instanceof a) || (dVar7 instanceof a)) ? 4 : i33;
                                                            z19 = z24;
                                                            z20 = false;
                                                            i22 = i34;
                                                            i23 = 5;
                                                        } else if (i11 == 1) {
                                                            z20 = true;
                                                            i29 = 7;
                                                            z19 = true;
                                                            i22 = i29;
                                                            i24 = 4;
                                                            i23 = 5;
                                                            z18 = false;
                                                        } else if (i11 == 3) {
                                                            if (dVar2.s == -1) {
                                                                if (!z9) {
                                                                    i31 = 7;
                                                                    i24 = 5;
                                                                    i30 = 7;
                                                                } else if (!z3) {
                                                                    i31 = 7;
                                                                    i24 = 5;
                                                                    i30 = 4;
                                                                }
                                                                i22 = i31;
                                                                i23 = i30;
                                                                z20 = true;
                                                                z19 = true;
                                                                z18 = true;
                                                            } else {
                                                                if (!z7) {
                                                                    if (i37 > 0) {
                                                                        i32 = 5;
                                                                    } else if (i37 != 0 || i14 != 0) {
                                                                        i32 = 4;
                                                                    } else if (!z9) {
                                                                        i32 = 7;
                                                                    } else if (!(dVar6 == dVar8 || dVar7 == dVar8)) {
                                                                        i31 = 4;
                                                                        i24 = 4;
                                                                        i30 = 5;
                                                                        i22 = i31;
                                                                        i23 = i30;
                                                                        z20 = true;
                                                                        z19 = true;
                                                                        z18 = true;
                                                                    }
                                                                    i24 = i32;
                                                                    i31 = 5;
                                                                    i30 = 5;
                                                                    i22 = i31;
                                                                    i23 = i30;
                                                                    z20 = true;
                                                                    z19 = true;
                                                                    z18 = true;
                                                                }
                                                                i31 = 5;
                                                                i24 = 4;
                                                                i30 = 5;
                                                                i22 = i31;
                                                                i23 = i30;
                                                                z20 = true;
                                                                z19 = true;
                                                                z18 = true;
                                                            }
                                                            i31 = 7;
                                                            i24 = 5;
                                                            i30 = 5;
                                                            i22 = i31;
                                                            i23 = i30;
                                                            z20 = true;
                                                            z19 = true;
                                                            z18 = true;
                                                        } else {
                                                            z20 = false;
                                                            z23 = false;
                                                        }
                                                        if (z20 || l4 != gVar8 || dVar6 == dVar8) {
                                                            z22 = z20;
                                                            z21 = true;
                                                        } else {
                                                            z22 = false;
                                                            z21 = false;
                                                        }
                                                        if (!z19) {
                                                            dVar4 = dVar7;
                                                            dVar5 = dVar6;
                                                            z17 = z15;
                                                            i26 = i11;
                                                            gVar11 = l4;
                                                            i25 = i24;
                                                            gVar9 = l3;
                                                            dVar3 = dVar8;
                                                            gVar12 = l2;
                                                            dVar.b(l2, l4, cVar.b(), f2, gVar8, l3, cVar2.b(), i23);
                                                        } else {
                                                            dVar4 = dVar7;
                                                            dVar5 = dVar6;
                                                            i25 = i24;
                                                            dVar3 = dVar8;
                                                            gVar11 = l4;
                                                            i26 = i11;
                                                            z17 = z15;
                                                            gVar9 = l3;
                                                            gVar12 = l2;
                                                        }
                                                        int i38 = 6;
                                                        if (!z22) {
                                                            i27 = (!z3 || gVar11 == gVar8 || z14 || (!(dVar5 instanceof a) && !(dVar4 instanceof a))) ? i22 : 6;
                                                            dVar.f(gVar12, gVar11, cVar.b(), i27);
                                                            dVar.g(gVar9, gVar8, -cVar2.b(), i27);
                                                        } else {
                                                            i27 = i22;
                                                        }
                                                        if (z21) {
                                                            if (!z18 || (z9 && !z4)) {
                                                                i28 = i25;
                                                            } else {
                                                                if (!(dVar5 == dVar3 || dVar4 == dVar3)) {
                                                                    i38 = i25;
                                                                }
                                                                if ((dVar5 instanceof f) || (dVar4 instanceof f)) {
                                                                    i38 = 5;
                                                                }
                                                                if ((dVar5 instanceof a) || (dVar4 instanceof a)) {
                                                                    i38 = 5;
                                                                }
                                                                if (z9) {
                                                                    i38 = 5;
                                                                }
                                                                i28 = Math.max(i38, i25);
                                                            }
                                                            if (z3) {
                                                                i28 = Math.min(i27, i28);
                                                            }
                                                            dVar.d(gVar12, gVar11, cVar.b(), i28);
                                                            dVar.d(gVar9, gVar8, -cVar2.b(), i28);
                                                        }
                                                        if (z3) {
                                                            int b2 = gVar == gVar11 ? cVar.b() : 0;
                                                            if (gVar11 != gVar) {
                                                                dVar.f(gVar12, gVar, b2, 5);
                                                            }
                                                        }
                                                        if (z3 || !z14 || i4 != 0 || i14 != 0) {
                                                            i19 = 0;
                                                            if (!z3 && z17) {
                                                                if (cVar2.f1501c != null) {
                                                                    i20 = cVar2.b();
                                                                    gVar10 = gVar2;
                                                                } else {
                                                                    gVar10 = gVar2;
                                                                    i20 = i19;
                                                                }
                                                                if (gVar8 != gVar10) {
                                                                    dVar.f(gVar10, gVar9, i20, 5);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        i19 = 0;
                                                        dVar.f(gVar9, gVar12, 0, (!z14 || i26 != 3) ? 5 : 7);
                                                        if (!z3) {
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    z20 = true;
                                                    z23 = true;
                                                    z19 = z23;
                                                    i29 = 5;
                                                    i22 = i29;
                                                    i24 = 4;
                                                    i23 = 5;
                                                    z18 = false;
                                                    if (z20) {
                                                    }
                                                    z22 = z20;
                                                    z21 = true;
                                                    if (!z19) {
                                                    }
                                                    int i382 = 6;
                                                    if (!z22) {
                                                    }
                                                    if (z21) {
                                                    }
                                                    if (z3) {
                                                    }
                                                    if (z3) {
                                                    }
                                                    i19 = 0;
                                                    if (!z3) {
                                                    }
                                                }
                                            } else {
                                                gVar8 = gVar3;
                                                dVar.d(l3, gVar8, -cVar2.b(), i15);
                                                if (z3) {
                                                    i21 = 0;
                                                    dVar.f(l2, gVar, 0, 5);
                                                } else {
                                                    z17 = z15;
                                                }
                                            }
                                            i19 = i21;
                                            z17 = z15;
                                            gVar9 = l3;
                                            if (!z3) {
                                            }
                                        } else {
                                            z17 = z15;
                                            gVar8 = gVar3;
                                        }
                                        i19 = 0;
                                        gVar9 = l3;
                                        if (!z3) {
                                        }
                                    }
                                    if (i17 >= i16 && z3 && z16) {
                                        dVar.f(gVar5, gVar6, i18, 7);
                                        int i39 = (z2 || this.B.f1501c == null) ? 1 : i18;
                                        if (!z2 && (cVar3 = this.B.f1501c) != null) {
                                            d dVar9 = cVar3.f1499a;
                                            if (dVar9.L != 0.0f && (r4 = dVar9.H)[i18] == (r6 = a.MATCH_CONSTRAINT)) {
                                                i39 = 1;
                                            }
                                            i39 = i18;
                                        }
                                        if (i39 != 0) {
                                            dVar.f(gVar7, gVar4, i18, 7);
                                            return;
                                        }
                                        return;
                                    }
                                }
                            } else {
                                int max = Math.max(i36, i12);
                                if (i37 > 0) {
                                    max = Math.min(i37, max);
                                }
                                i15 = 7;
                                dVar.d(l3, l2, max, 7);
                                dVar2 = this;
                            }
                            z15 = z5;
                            i14 = i36;
                            z14 = false;
                            if (!z10) {
                            }
                            if (i17 >= i16) {
                            }
                        }
                        i15 = i35;
                        i14 = i36;
                        z14 = z12;
                        dVar2 = this;
                        z15 = z5;
                        if (!z10) {
                        }
                        if (i17 >= i16) {
                        }
                    }
                }
                z13 = c6;
                i13 = 7;
                if (!z12) {
                }
                i15 = i35;
                i14 = i36;
                z14 = z12;
                dVar2 = this;
                z15 = z5;
                if (!z10) {
                }
                if (i17 >= i16) {
                }
            }
        }
        z11 = false;
        if (this.V != 8) {
        }
        if (z10) {
        }
        z13 = c6;
        i13 = 7;
        if (!z12) {
        }
        i15 = i35;
        i14 = i36;
        z14 = z12;
        dVar2 = this;
        z15 = z5;
        if (!z10) {
        }
        if (i17 >= i16) {
        }
    }

    public void e(b.g.b.d dVar) {
        dVar.l(this.x);
        dVar.l(this.y);
        dVar.l(this.z);
        dVar.l(this.A);
        if (this.P > 0) {
            dVar.l(this.B);
        }
    }

    public c f(c.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.x;
            case 2:
                return this.y;
            case 3:
                return this.z;
            case 4:
                return this.A;
            case 5:
                return this.B;
            case 6:
                return this.E;
            case 7:
                return this.C;
            case 8:
                return this.D;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public int g() {
        return q() + this.K;
    }

    public a h(int i2) {
        if (i2 == 0) {
            return j();
        }
        if (i2 == 1) {
            return n();
        }
        return null;
    }

    public int i() {
        if (this.V == 8) {
            return 0;
        }
        return this.K;
    }

    public a j() {
        return this.H[0];
    }

    public d k(int i2) {
        c cVar;
        c cVar2;
        if (i2 == 0) {
            c cVar3 = this.z;
            c cVar4 = cVar3.f1501c;
            if (cVar4 == null || cVar4.f1501c != cVar3) {
                return null;
            }
            return cVar4.f1499a;
        } else if (i2 == 1 && (cVar2 = (cVar = this.A).f1501c) != null && cVar2.f1501c == cVar) {
            return cVar2.f1499a;
        } else {
            return null;
        }
    }

    public d l(int i2) {
        c cVar;
        c cVar2;
        if (i2 == 0) {
            c cVar3 = this.x;
            c cVar4 = cVar3.f1501c;
            if (cVar4 == null || cVar4.f1501c != cVar3) {
                return null;
            }
            return cVar4.f1499a;
        } else if (i2 == 1 && (cVar2 = (cVar = this.y).f1501c) != null && cVar2.f1501c == cVar) {
            return cVar2.f1499a;
        } else {
            return null;
        }
    }

    public int m() {
        return p() + this.J;
    }

    public a n() {
        return this.H[1];
    }

    public int o() {
        if (this.V == 8) {
            return 0;
        }
        return this.J;
    }

    public int p() {
        d dVar = this.I;
        return (dVar == null || !(dVar instanceof e)) ? this.N : ((e) dVar).j0 + this.N;
    }

    public int q() {
        d dVar = this.I;
        return (dVar == null || !(dVar instanceof e)) ? this.O : ((e) dVar).k0 + this.O;
    }

    public final boolean r(int i2) {
        int i3 = i2 * 2;
        c[] cVarArr = this.F;
        if (!(cVarArr[i3].f1501c == null || cVarArr[i3].f1501c.f1501c == cVarArr[i3])) {
            int i4 = i3 + 1;
            return cVarArr[i4].f1501c != null && cVarArr[i4].f1501c.f1501c == cVarArr[i4];
        }
    }

    public boolean s() {
        c cVar = this.x;
        c cVar2 = cVar.f1501c;
        if (cVar2 != null && cVar2.f1501c == cVar) {
            return true;
        }
        c cVar3 = this.z;
        c cVar4 = cVar3.f1501c;
        return cVar4 != null && cVar4.f1501c == cVar3;
    }

    public boolean t() {
        c cVar = this.y;
        c cVar2 = cVar.f1501c;
        if (cVar2 != null && cVar2.f1501c == cVar) {
            return true;
        }
        c cVar3 = this.A;
        c cVar4 = cVar3.f1501c;
        return cVar4 != null && cVar4.f1501c == cVar3;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.X != null) {
            StringBuilder h2 = c.a.a.a.a.h("type: ");
            h2.append(this.X);
            h2.append(" ");
            str = h2.toString();
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.W != null) {
            StringBuilder h3 = c.a.a.a.a.h("id: ");
            h3.append(this.W);
            h3.append(" ");
            str2 = h3.toString();
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.N);
        sb.append(", ");
        sb.append(this.O);
        sb.append(") - (");
        sb.append(this.J);
        sb.append(" x ");
        sb.append(this.K);
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        this.x.d();
        this.y.d();
        this.z.d();
        this.A.d();
        this.B.d();
        this.C.d();
        this.D.d();
        this.E.d();
        this.I = null;
        this.v = 0.0f;
        this.J = 0;
        this.K = 0;
        this.L = 0.0f;
        this.M = -1;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0.5f;
        this.T = 0.5f;
        a[] aVarArr = this.H;
        a aVar = a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.U = null;
        this.V = 0;
        this.X = null;
        this.Y = 0;
        this.Z = 0;
        float[] fArr = this.a0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.h = -1;
        this.i = -1;
        int[] iArr = this.u;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.j = 0;
        this.k = 0;
        this.o = 1.0f;
        this.r = 1.0f;
        this.n = Integer.MAX_VALUE;
        this.q = Integer.MAX_VALUE;
        this.m = 0;
        this.p = 0;
        this.s = -1;
        this.t = 1.0f;
        boolean[] zArr = this.f1516f;
        zArr[0] = true;
        zArr[1] = true;
    }

    public void v(b.g.b.c cVar) {
        this.x.e();
        this.y.e();
        this.z.e();
        this.A.e();
        this.B.e();
        this.E.e();
        this.C.e();
        this.D.e();
    }

    public void w(int i2) {
        this.K = i2;
        int i3 = this.R;
        if (i2 < i3) {
            this.K = i3;
        }
    }

    public void x(a aVar) {
        this.H[0] = aVar;
    }

    public void y(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.R = i2;
    }

    public void z(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.Q = i2;
    }
}
