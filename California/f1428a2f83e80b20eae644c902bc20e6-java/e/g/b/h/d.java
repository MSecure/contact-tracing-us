package e.g.b.h;

import e.g.b.b;
import e.g.b.g;
import e.g.b.h.c;
import e.g.b.h.l.c;
import e.g.b.h.l.f;
import e.g.b.h.l.k;
import e.g.b.h.l.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class d {
    public boolean A = false;
    public int B = 0;
    public int C = 0;
    public c D;
    public c E;
    public c F;
    public c G;
    public c H;
    public c I;
    public c J;
    public c K;
    public c[] L;
    public ArrayList<c> M;
    public boolean[] N;
    public a[] O;
    public d P;
    public int Q;
    public int R;
    public float S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public float Z;
    public boolean a = false;
    public float a0;
    public c b;
    public Object b0;
    public c c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public k f1274d = null;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public m f1275e = null;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean[] f1276f = {true, true};
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1277g = true;
    public float[] g0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1278h = false;
    public d[] h0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1279i = false;
    public d[] i0;

    /* renamed from: j  reason: collision with root package name */
    public int f1280j = -1;
    public int j0;

    /* renamed from: k  reason: collision with root package name */
    public int f1281k = -1;
    public int k0;

    /* renamed from: l  reason: collision with root package name */
    public int f1282l = 0;
    public int m = 0;
    public int[] n = new int[2];
    public int o = 0;
    public int p = 0;
    public float q = 1.0f;
    public int r = 0;
    public int s = 0;
    public float t = 1.0f;
    public int u = -1;
    public float v = 1.0f;
    public int[] w = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float x = 0.0f;
    public boolean y = false;
    public boolean z;

    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public d() {
        c cVar = new c(this, c.a.LEFT);
        this.D = cVar;
        c cVar2 = new c(this, c.a.TOP);
        this.E = cVar2;
        c cVar3 = new c(this, c.a.RIGHT);
        this.F = cVar3;
        c cVar4 = new c(this, c.a.BOTTOM);
        this.G = cVar4;
        c cVar5 = new c(this, c.a.BASELINE);
        this.H = cVar5;
        this.I = new c(this, c.a.CENTER_X);
        this.J = new c(this, c.a.CENTER_Y);
        c cVar6 = new c(this, c.a.CENTER);
        this.K = cVar6;
        this.L = new c[]{cVar, cVar3, cVar2, cVar4, cVar5, cVar6};
        ArrayList<c> arrayList = new ArrayList<>();
        this.M = arrayList;
        this.N = new boolean[2];
        a aVar = a.FIXED;
        this.O = new a[]{aVar, aVar};
        this.P = null;
        this.Q = 0;
        this.R = 0;
        this.S = 0.0f;
        this.T = -1;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.Z = 0.5f;
        this.a0 = 0.5f;
        this.c0 = 0;
        this.d0 = null;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = new float[]{-1.0f, -1.0f};
        this.h0 = new d[]{null, null};
        this.i0 = new d[]{null, null};
        this.j0 = -1;
        this.k0 = -1;
        arrayList.add(this.D);
        this.M.add(this.E);
        this.M.add(this.F);
        this.M.add(this.G);
        this.M.add(this.I);
        this.M.add(this.J);
        this.M.add(this.K);
        this.M.add(this.H);
    }

    public boolean A() {
        return this.f1279i || (this.E.c && this.G.c);
    }

    public void B() {
        this.D.h();
        this.E.h();
        this.F.h();
        this.G.h();
        this.H.h();
        this.I.h();
        this.J.h();
        this.K.h();
        this.P = null;
        this.x = 0.0f;
        this.Q = 0;
        this.R = 0;
        this.S = 0.0f;
        this.T = -1;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0.5f;
        this.a0 = 0.5f;
        a[] aVarArr = this.O;
        a aVar = a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.b0 = null;
        this.c0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        float[] fArr = this.g0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f1280j = -1;
        this.f1281k = -1;
        int[] iArr = this.w;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f1282l = 0;
        this.m = 0;
        this.q = 1.0f;
        this.t = 1.0f;
        this.p = Integer.MAX_VALUE;
        this.s = Integer.MAX_VALUE;
        this.o = 0;
        this.r = 0;
        this.u = -1;
        this.v = 1.0f;
        boolean[] zArr = this.f1276f;
        zArr[0] = true;
        zArr[1] = true;
        this.A = false;
        boolean[] zArr2 = this.N;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f1277g = true;
    }

    public void C() {
        this.f1278h = false;
        this.f1279i = false;
        int size = this.M.size();
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = this.M.get(i2);
            cVar.c = false;
            cVar.b = 0;
        }
    }

    public void D(e.g.b.c cVar) {
        this.D.i();
        this.E.i();
        this.F.i();
        this.G.i();
        this.H.i();
        this.K.i();
        this.I.i();
        this.J.i();
    }

    public void E(int i2) {
        this.W = i2;
        this.y = i2 > 0;
    }

    public void F(int i2, int i3) {
        c cVar = this.D;
        cVar.b = i2;
        cVar.c = true;
        c cVar2 = this.F;
        cVar2.b = i3;
        cVar2.c = true;
        this.U = i2;
        this.Q = i3 - i2;
        this.f1278h = true;
    }

    public void G(int i2, int i3) {
        c cVar = this.E;
        cVar.b = i2;
        cVar.c = true;
        c cVar2 = this.G;
        cVar2.b = i3;
        cVar2.c = true;
        this.V = i2;
        this.R = i3 - i2;
        if (this.y) {
            this.H.j(i2 + this.W);
        }
        this.f1279i = true;
    }

    public void H(int i2) {
        this.R = i2;
        int i3 = this.Y;
        if (i2 < i3) {
            this.R = i3;
        }
    }

    public void I(a aVar) {
        this.O[0] = aVar;
    }

    public void J(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.Y = i2;
    }

    public void K(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.X = i2;
    }

    public void L(a aVar) {
        this.O[1] = aVar;
    }

    public void M(int i2) {
        this.Q = i2;
        int i3 = this.X;
        if (i2 < i3) {
            this.Q = i3;
        }
    }

    public void N(boolean z2, boolean z3) {
        int i2;
        int i3;
        a aVar = a.FIXED;
        k kVar = this.f1274d;
        boolean z4 = z2 & kVar.f1325g;
        m mVar = this.f1275e;
        boolean z5 = z3 & mVar.f1325g;
        int i4 = kVar.f1326h.f1303g;
        int i5 = mVar.f1326h.f1303g;
        int i6 = kVar.f1327i.f1303g;
        int i7 = mVar.f1327i.f1303g;
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
            this.U = i4;
        }
        if (z5) {
            this.V = i5;
        }
        if (this.c0 == 8) {
            this.Q = 0;
            this.R = 0;
            return;
        }
        if (z4) {
            if (this.O[0] == aVar && i9 < (i3 = this.Q)) {
                i9 = i3;
            }
            this.Q = i9;
            int i11 = this.X;
            if (i9 < i11) {
                this.Q = i11;
            }
        }
        if (z5) {
            if (this.O[1] == aVar && i10 < (i2 = this.R)) {
                i10 = i2;
            }
            this.R = i10;
            int i12 = this.Y;
            if (i10 < i12) {
                this.R = i12;
            }
        }
    }

    public void O(e.g.b.d dVar, boolean z2) {
        int i2;
        int i3;
        m mVar;
        k kVar;
        int o2 = dVar.o(this.D);
        int o3 = dVar.o(this.E);
        int o4 = dVar.o(this.F);
        int o5 = dVar.o(this.G);
        if (z2 && (kVar = this.f1274d) != null) {
            f fVar = kVar.f1326h;
            if (fVar.f1306j) {
                f fVar2 = kVar.f1327i;
                if (fVar2.f1306j) {
                    o2 = fVar.f1303g;
                    o4 = fVar2.f1303g;
                }
            }
        }
        if (z2 && (mVar = this.f1275e) != null) {
            f fVar3 = mVar.f1326h;
            if (fVar3.f1306j) {
                f fVar4 = mVar.f1327i;
                if (fVar4.f1306j) {
                    o3 = fVar3.f1303g;
                    o5 = fVar4.f1303g;
                }
            }
        }
        int i4 = o5 - o3;
        if (o4 - o2 < 0 || i4 < 0 || o2 == Integer.MIN_VALUE || o2 == Integer.MAX_VALUE || o3 == Integer.MIN_VALUE || o3 == Integer.MAX_VALUE || o4 == Integer.MIN_VALUE || o4 == Integer.MAX_VALUE || o5 == Integer.MIN_VALUE || o5 == Integer.MAX_VALUE) {
            o5 = 0;
            o2 = 0;
            o3 = 0;
            o4 = 0;
        }
        int i5 = o4 - o2;
        int i6 = o5 - o3;
        this.U = o2;
        this.V = o3;
        if (this.c0 == 8) {
            this.Q = 0;
            this.R = 0;
            return;
        }
        a[] aVarArr = this.O;
        a aVar = aVarArr[0];
        a aVar2 = a.FIXED;
        if (aVar == aVar2 && i5 < (i3 = this.Q)) {
            i5 = i3;
        }
        if (aVarArr[1] == aVar2 && i6 < (i2 = this.R)) {
            i6 = i2;
        }
        this.Q = i5;
        this.R = i6;
        int i7 = this.Y;
        if (i6 < i7) {
            this.R = i7;
        }
        int i8 = this.X;
        if (i5 < i8) {
            this.Q = i8;
        }
    }

    public void b(e eVar, e.g.b.d dVar, HashSet<d> hashSet, int i2, boolean z2) {
        if (z2) {
            if (hashSet.contains(this)) {
                i.a(eVar, dVar, this);
                hashSet.remove(this);
                d(dVar, eVar.Y(64));
            } else {
                return;
            }
        }
        if (i2 == 0) {
            HashSet<c> hashSet2 = this.D.a;
            if (hashSet2 != null) {
                Iterator<c> it = hashSet2.iterator();
                while (it.hasNext()) {
                    it.next().f1260d.b(eVar, dVar, hashSet, i2, true);
                }
            }
            HashSet<c> hashSet3 = this.F.a;
            if (hashSet3 != null) {
                Iterator<c> it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    it2.next().f1260d.b(eVar, dVar, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet<c> hashSet4 = this.E.a;
        if (hashSet4 != null) {
            Iterator<c> it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                it3.next().f1260d.b(eVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<c> hashSet5 = this.G.a;
        if (hashSet5 != null) {
            Iterator<c> it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                it4.next().f1260d.b(eVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<c> hashSet6 = this.H.a;
        if (hashSet6 != null) {
            Iterator<c> it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                it5.next().f1260d.b(eVar, dVar, hashSet, i2, true);
            }
        }
    }

    public boolean c() {
        return (this instanceof j) || (this instanceof f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:196:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0382  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x039a  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x03d8  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x04b6  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x051a  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x052e  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0530  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0533  */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x05bc  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x05bf  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x0605  */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x062b  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0635  */
    public void d(e.g.b.d dVar, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i2;
        int i3;
        boolean z7;
        int i4;
        g gVar;
        char c2;
        int i5;
        boolean z8;
        int i6;
        a aVar;
        g gVar2;
        g gVar3;
        g gVar4;
        a aVar2;
        g gVar5;
        d dVar2;
        e.g.b.d dVar3;
        g gVar6;
        g gVar7;
        char c3;
        int i7;
        boolean z9;
        int i8;
        g gVar8;
        g gVar9;
        g gVar10;
        d dVar4;
        g gVar11;
        g gVar12;
        g gVar13;
        g gVar14;
        e.g.b.d dVar5;
        boolean z10;
        k kVar;
        int i9;
        int i10;
        int i11;
        boolean z11;
        boolean z12;
        k kVar2;
        m mVar;
        d dVar6;
        d dVar7;
        boolean z13;
        a aVar3 = a.WRAP_CONTENT;
        g l2 = dVar.l(this.D);
        g l3 = dVar.l(this.F);
        g l4 = dVar.l(this.E);
        g l5 = dVar.l(this.G);
        g l6 = dVar.l(this.H);
        d dVar8 = this.P;
        if (dVar8 != null) {
            boolean z14 = dVar8 != null && dVar8.O[0] == aVar3;
            z4 = dVar8 != null && dVar8.O[1] == aVar3;
            z3 = z14;
        } else {
            z4 = false;
            z3 = false;
        }
        if (this.c0 == 8) {
            int size = this.M.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    z13 = false;
                    break;
                } else if (this.M.get(i12).f()) {
                    z13 = true;
                    break;
                } else {
                    i12++;
                }
            }
            if (!z13) {
                boolean[] zArr = this.N;
                if (!zArr[0] && !zArr[1]) {
                    return;
                }
            }
        }
        boolean z15 = this.f1278h;
        if (z15 || this.f1279i) {
            if (z15) {
                dVar.e(l2, this.U);
                dVar.e(l3, this.U + this.Q);
                if (z3 && (dVar7 = this.P) != null) {
                    e eVar = (e) dVar7;
                    eVar.U(this.D);
                    eVar.S(this.F);
                }
            }
            if (this.f1279i) {
                dVar.e(l4, this.V);
                dVar.e(l5, this.V + this.R);
                if (this.H.f()) {
                    dVar.e(l6, this.V + this.W);
                }
                if (z4 && (dVar6 = this.P) != null) {
                    e eVar2 = (e) dVar6;
                    eVar2.U(this.E);
                    eVar2.T(this.G);
                }
            }
            if (this.f1278h && this.f1279i) {
                this.f1278h = false;
                this.f1279i = false;
                return;
            }
        }
        if (!(!z2 || (kVar2 = this.f1274d) == null || (mVar = this.f1275e) == null)) {
            f fVar = kVar2.f1326h;
            if (fVar.f1306j && kVar2.f1327i.f1306j && mVar.f1326h.f1306j && mVar.f1327i.f1306j) {
                dVar.e(l2, fVar.f1303g);
                dVar.e(l3, this.f1274d.f1327i.f1303g);
                dVar.e(l4, this.f1275e.f1326h.f1303g);
                dVar.e(l5, this.f1275e.f1327i.f1303g);
                dVar.e(l6, this.f1275e.f1317k.f1303g);
                if (this.P != null) {
                    if (z3 && this.f1276f[0] && !w()) {
                        dVar.f(dVar.l(this.P.F), l3, 0, 8);
                    }
                    if (z4 && this.f1276f[1] && !x()) {
                        dVar.f(dVar.l(this.P.G), l5, 0, 8);
                    }
                }
                this.f1278h = false;
                this.f1279i = false;
                return;
            }
        }
        if (this.P != null) {
            if (v(0)) {
                ((e) this.P).Q(this, 0);
                z11 = true;
            } else {
                z11 = w();
            }
            if (v(1)) {
                ((e) this.P).Q(this, 1);
                z12 = true;
            } else {
                z12 = x();
            }
            if (!z11 && z3 && this.c0 != 8 && this.D.f1262f == null && this.F.f1262f == null) {
                dVar.f(dVar.l(this.P.F), l3, 0, 1);
            }
            if (!z12 && z4 && this.c0 != 8 && this.E.f1262f == null && this.G.f1262f == null && this.H == null) {
                dVar.f(dVar.l(this.P.G), l5, 0, 1);
            }
            z5 = z11;
            z6 = z12;
        } else {
            z6 = false;
            z5 = false;
        }
        int i13 = this.Q;
        int i14 = this.X;
        if (i13 >= i14) {
            i14 = i13;
        }
        int i15 = this.R;
        int i16 = this.Y;
        if (i15 >= i16) {
            i16 = i15;
        }
        a[] aVarArr = this.O;
        a aVar4 = aVarArr[0];
        a aVar5 = a.MATCH_CONSTRAINT;
        boolean z16 = aVar4 != aVar5;
        boolean z17 = aVarArr[1] != aVar5;
        int i17 = this.T;
        this.u = i17;
        float f2 = this.S;
        this.v = f2;
        int i18 = this.f1282l;
        int i19 = this.m;
        if (f2 > 0.0f) {
            gVar = l3;
            if (this.c0 != 8) {
                if (aVarArr[0] == aVar5 && i18 == 0) {
                    i18 = 3;
                }
                if (aVarArr[1] == aVar5 && i19 == 0) {
                    i19 = 3;
                }
                if (aVarArr[0] == aVar5 && aVarArr[1] == aVar5 && i18 == 3 && i19 == 3) {
                    if (i17 == -1) {
                        if (z16 && !z17) {
                            this.u = 0;
                        } else if (!z16 && z17) {
                            this.u = 1;
                            if (i17 == -1) {
                                this.v = 1.0f / f2;
                            }
                        }
                    }
                    if (this.u != 0 || (this.E.g() && this.G.g())) {
                        if (this.u == 1 && (!this.D.g() || !this.F.g())) {
                            i11 = 0;
                        }
                        if (this.u == -1 && (!this.E.g() || !this.G.g() || !this.D.g() || !this.F.g())) {
                            if (!this.E.g() && this.G.g()) {
                                i10 = 0;
                            } else if (this.D.g() && this.F.g()) {
                                this.v = 1.0f / this.v;
                                i10 = 1;
                            }
                            this.u = i10;
                        }
                        if (this.u == -1) {
                            int i20 = this.o;
                            if (i20 > 0 && this.r == 0) {
                                this.u = 0;
                            } else if (i20 == 0 && this.r > 0) {
                                this.v = 1.0f / this.v;
                                this.u = 1;
                            }
                        }
                    } else {
                        i11 = 1;
                    }
                    this.u = i11;
                    if (!this.E.g()) {
                    }
                    this.v = 1.0f / this.v;
                    i10 = 1;
                    this.u = i10;
                    if (this.u == -1) {
                    }
                } else if (aVarArr[0] == aVar5 && i18 == 3) {
                    this.u = 0;
                    i5 = (int) (f2 * ((float) i15));
                    if (aVarArr[1] != aVar5) {
                        i3 = i19;
                        i4 = i16;
                        c2 = 0;
                        z7 = false;
                        i2 = 4;
                        int[] iArr = this.n;
                        iArr[c2] = i2;
                        iArr[1] = i3;
                        if (!z7) {
                        }
                        z8 = false;
                        if (!z7) {
                        }
                        if (this.O[0] != aVar3) {
                        }
                        if (r9) {
                        }
                        boolean z18 = !this.K.g();
                        boolean[] zArr2 = this.N;
                        boolean z19 = zArr2[0];
                        boolean z20 = zArr2[1];
                        f fVar2 = kVar.f1326h;
                        if (z2) {
                        }
                        aVar2 = aVar5;
                        gVar5 = l2;
                        aVar = aVar3;
                        gVar4 = l6;
                        gVar3 = l5;
                        gVar2 = l4;
                        if (z2) {
                        }
                        z9 = true;
                        if (dVar2.f1281k != 2 ? false : z9) {
                        }
                        gVar10 = gVar7;
                        gVar9 = gVar6;
                        if (!z7) {
                        }
                        if (dVar4.K.g()) {
                        }
                        this.f1278h = false;
                        this.f1279i = false;
                    }
                    i2 = i18;
                    i3 = i19;
                    i4 = i16;
                    c2 = 0;
                    z7 = true;
                    int[] iArr2 = this.n;
                    iArr2[c2] = i2;
                    iArr2[1] = i3;
                    if (!z7) {
                    }
                    z8 = false;
                    if (!z7) {
                    }
                    if (this.O[0] != aVar3) {
                    }
                    if (r9) {
                    }
                    boolean z182 = !this.K.g();
                    boolean[] zArr22 = this.N;
                    boolean z192 = zArr22[0];
                    boolean z202 = zArr22[1];
                    f fVar22 = kVar.f1326h;
                    if (z2) {
                    }
                    aVar2 = aVar5;
                    gVar5 = l2;
                    aVar = aVar3;
                    gVar4 = l6;
                    gVar3 = l5;
                    gVar2 = l4;
                    if (z2) {
                    }
                    z9 = true;
                    if (dVar2.f1281k != 2 ? false : z9) {
                    }
                    gVar10 = gVar7;
                    gVar9 = gVar6;
                    if (!z7) {
                    }
                    if (dVar4.K.g()) {
                    }
                    this.f1278h = false;
                    this.f1279i = false;
                } else if (aVarArr[1] == aVar5 && i19 == 3) {
                    this.u = 1;
                    if (i17 == -1) {
                        this.v = 1.0f / f2;
                    }
                    c2 = 0;
                    a aVar6 = aVarArr[0];
                    i4 = (int) (this.v * ((float) i13));
                    i2 = i18;
                    if (aVar6 != aVar5) {
                        i5 = i14;
                        z7 = false;
                        i3 = 4;
                        int[] iArr22 = this.n;
                        iArr22[c2] = i2;
                        iArr22[1] = i3;
                        if (!z7) {
                            int i21 = this.u;
                            i6 = -1;
                            if (i21 == 0 || i21 == -1) {
                                z8 = true;
                                boolean z21 = !z7 && ((i9 = this.u) == 1 || i9 == i6);
                                boolean z22 = this.O[0] != aVar3 && (this instanceof e);
                                int i22 = z22 ? 0 : i5;
                                boolean z1822 = !this.K.g();
                                boolean[] zArr222 = this.N;
                                boolean z1922 = zArr222[0];
                                boolean z2022 = zArr222[1];
                                if (this.f1280j != 2 && !this.f1278h) {
                                    if (z2 && (kVar = this.f1274d) != null) {
                                        f fVar222 = kVar.f1326h;
                                        if (fVar222.f1306j && kVar.f1327i.f1306j) {
                                            if (z2) {
                                                dVar.e(l2, fVar222.f1303g);
                                                dVar.e(gVar, this.f1274d.f1327i.f1303g);
                                                if (this.P != null && z3 && this.f1276f[0] && !w()) {
                                                    dVar.f(dVar.l(this.P.F), gVar, 0, 8);
                                                }
                                                aVar2 = aVar5;
                                                gVar = gVar;
                                                gVar5 = l2;
                                                aVar = aVar3;
                                                gVar4 = l6;
                                                gVar3 = l5;
                                                gVar2 = l4;
                                                if (z2) {
                                                    dVar2 = this;
                                                    m mVar2 = dVar2.f1275e;
                                                    if (mVar2 != null) {
                                                        f fVar3 = mVar2.f1326h;
                                                        if (fVar3.f1306j && mVar2.f1327i.f1306j) {
                                                            dVar3 = dVar;
                                                            gVar6 = gVar2;
                                                            dVar3.e(gVar6, fVar3.f1303g);
                                                            gVar7 = gVar3;
                                                            dVar3.e(gVar7, dVar2.f1275e.f1327i.f1303g);
                                                            gVar8 = gVar4;
                                                            dVar3.e(gVar8, dVar2.f1275e.f1317k.f1303g);
                                                            d dVar9 = dVar2.P;
                                                            if (dVar9 == null || z6 || !z4) {
                                                                i8 = 8;
                                                                i7 = 0;
                                                                c3 = 1;
                                                            } else {
                                                                c3 = 1;
                                                                if (dVar2.f1276f[1]) {
                                                                    i8 = 8;
                                                                    i7 = 0;
                                                                    dVar3.f(dVar3.l(dVar9.G), gVar7, 0, 8);
                                                                } else {
                                                                    i8 = 8;
                                                                    i7 = 0;
                                                                }
                                                            }
                                                            z9 = false;
                                                            if ((dVar2.f1281k != 2 ? false : z9) || dVar2.f1279i) {
                                                                gVar10 = gVar7;
                                                                gVar9 = gVar6;
                                                            } else {
                                                                boolean z23 = dVar2.O[c3] == aVar && (dVar2 instanceof e);
                                                                if (z23) {
                                                                    i4 = 0;
                                                                }
                                                                d dVar10 = dVar2.P;
                                                                g l7 = dVar10 != null ? dVar3.l(dVar10.G) : null;
                                                                d dVar11 = dVar2.P;
                                                                g l8 = dVar11 != null ? dVar3.l(dVar11.E) : null;
                                                                int i23 = dVar2.W;
                                                                if (i23 > 0 || dVar2.c0 == i8) {
                                                                    if (dVar2.H.f1262f != null) {
                                                                        dVar3.d(gVar8, gVar6, i23, i8);
                                                                        dVar3.d(gVar8, dVar3.l(dVar2.H.f1262f), i7, i8);
                                                                        if (z4) {
                                                                            dVar3.f(l7, dVar3.l(dVar2.G), i7, 5);
                                                                        }
                                                                        z10 = false;
                                                                        boolean z24 = dVar2.f1276f[c3];
                                                                        a[] aVarArr2 = dVar2.O;
                                                                        gVar10 = gVar7;
                                                                        gVar9 = gVar6;
                                                                        f(dVar, false, z4, z3, z24, l8, l7, aVarArr2[c3], z23, dVar2.E, dVar2.G, dVar2.V, i4, dVar2.Y, dVar2.w[c3], dVar2.a0, z21, aVarArr2[0] != aVar2, z6, z5, z2022, i3, i2, dVar2.r, dVar2.s, dVar2.t, z10);
                                                                    } else if (dVar2.c0 == i8) {
                                                                        dVar3.d(gVar8, gVar6, i7, i8);
                                                                    } else {
                                                                        dVar3.d(gVar8, gVar6, i23, i8);
                                                                    }
                                                                }
                                                                z10 = z1822;
                                                                boolean z242 = dVar2.f1276f[c3];
                                                                a[] aVarArr22 = dVar2.O;
                                                                gVar10 = gVar7;
                                                                gVar9 = gVar6;
                                                                f(dVar, false, z4, z3, z242, l8, l7, aVarArr22[c3], z23, dVar2.E, dVar2.G, dVar2.V, i4, dVar2.Y, dVar2.w[c3], dVar2.a0, z21, aVarArr22[0] != aVar2, z6, z5, z2022, i3, i2, dVar2.r, dVar2.s, dVar2.t, z10);
                                                            }
                                                            if (!z7) {
                                                                int i24 = 8;
                                                                dVar4 = this;
                                                                int i25 = dVar4.u;
                                                                float f3 = dVar4.v;
                                                                if (i25 == 1) {
                                                                    dVar5 = dVar;
                                                                    gVar14 = gVar10;
                                                                    gVar13 = gVar9;
                                                                    gVar12 = gVar;
                                                                    gVar11 = gVar5;
                                                                } else {
                                                                    i24 = 8;
                                                                    dVar5 = dVar;
                                                                    gVar14 = gVar;
                                                                    gVar13 = gVar5;
                                                                    gVar12 = gVar10;
                                                                    gVar11 = gVar9;
                                                                }
                                                                dVar5.h(gVar14, gVar13, gVar12, gVar11, f3, i24);
                                                            } else {
                                                                dVar4 = this;
                                                            }
                                                            if (dVar4.K.g()) {
                                                                d dVar12 = dVar4.K.f1262f.f1260d;
                                                                int d2 = dVar4.K.d();
                                                                c.a aVar7 = c.a.LEFT;
                                                                g l9 = dVar.l(dVar4.i(aVar7));
                                                                c.a aVar8 = c.a.TOP;
                                                                g l10 = dVar.l(dVar4.i(aVar8));
                                                                c.a aVar9 = c.a.RIGHT;
                                                                g l11 = dVar.l(dVar4.i(aVar9));
                                                                c.a aVar10 = c.a.BOTTOM;
                                                                g l12 = dVar.l(dVar4.i(aVar10));
                                                                g l13 = dVar.l(dVar12.i(aVar7));
                                                                g l14 = dVar.l(dVar12.i(aVar8));
                                                                g l15 = dVar.l(dVar12.i(aVar9));
                                                                g l16 = dVar.l(dVar12.i(aVar10));
                                                                b m2 = dVar.m();
                                                                double radians = (double) ((float) Math.toRadians((double) (dVar4.x + 90.0f)));
                                                                double d3 = (double) d2;
                                                                m2.g(l10, l12, l14, l16, (float) (Math.sin(radians) * d3));
                                                                dVar.c(m2);
                                                                b m3 = dVar.m();
                                                                m3.g(l9, l11, l13, l15, (float) (Math.cos(radians) * d3));
                                                                dVar.c(m3);
                                                            }
                                                            this.f1278h = false;
                                                            this.f1279i = false;
                                                        }
                                                    }
                                                    dVar3 = dVar;
                                                    gVar8 = gVar4;
                                                    gVar7 = gVar3;
                                                    gVar6 = gVar2;
                                                    i8 = 8;
                                                    i7 = 0;
                                                    c3 = 1;
                                                } else {
                                                    i8 = 8;
                                                    i7 = 0;
                                                    c3 = 1;
                                                    dVar2 = this;
                                                    dVar3 = dVar;
                                                    gVar8 = gVar4;
                                                    gVar7 = gVar3;
                                                    gVar6 = gVar2;
                                                }
                                                z9 = true;
                                                if (dVar2.f1281k != 2 ? false : z9) {
                                                }
                                                gVar10 = gVar7;
                                                gVar9 = gVar6;
                                                if (!z7) {
                                                }
                                                if (dVar4.K.g()) {
                                                }
                                                this.f1278h = false;
                                                this.f1279i = false;
                                            }
                                        }
                                    }
                                    d dVar13 = this.P;
                                    g l17 = dVar13 != null ? dVar.l(dVar13.F) : null;
                                    d dVar14 = this.P;
                                    g l18 = dVar14 != null ? dVar.l(dVar14.D) : null;
                                    boolean z25 = this.f1276f[0];
                                    a[] aVarArr3 = this.O;
                                    aVar2 = aVar5;
                                    gVar4 = l6;
                                    gVar3 = l5;
                                    gVar2 = l4;
                                    gVar = gVar;
                                    gVar5 = l2;
                                    aVar = aVar3;
                                    f(dVar, true, z3, z4, z25, l18, l17, aVarArr3[0], z22, this.D, this.F, this.U, i22, this.X, this.w[0], this.Z, z8, aVarArr3[1] == aVar5, z5, z6, z1922, i2, i3, this.o, this.p, this.q, z1822);
                                    if (z2) {
                                    }
                                    z9 = true;
                                    if (dVar2.f1281k != 2 ? false : z9) {
                                    }
                                    gVar10 = gVar7;
                                    gVar9 = gVar6;
                                    if (!z7) {
                                    }
                                    if (dVar4.K.g()) {
                                    }
                                    this.f1278h = false;
                                    this.f1279i = false;
                                }
                                aVar2 = aVar5;
                                gVar5 = l2;
                                aVar = aVar3;
                                gVar4 = l6;
                                gVar3 = l5;
                                gVar2 = l4;
                                if (z2) {
                                }
                                z9 = true;
                                if (dVar2.f1281k != 2 ? false : z9) {
                                }
                                gVar10 = gVar7;
                                gVar9 = gVar6;
                                if (!z7) {
                                }
                                if (dVar4.K.g()) {
                                }
                                this.f1278h = false;
                                this.f1279i = false;
                            }
                        } else {
                            i6 = -1;
                        }
                        z8 = false;
                        if (!z7) {
                        }
                        if (this.O[0] != aVar3) {
                        }
                        if (z22) {
                        }
                        boolean z18222 = !this.K.g();
                        boolean[] zArr2222 = this.N;
                        boolean z19222 = zArr2222[0];
                        boolean z20222 = zArr2222[1];
                        f fVar2222 = kVar.f1326h;
                        if (z2) {
                        }
                        aVar2 = aVar5;
                        gVar5 = l2;
                        aVar = aVar3;
                        gVar4 = l6;
                        gVar3 = l5;
                        gVar2 = l4;
                        if (z2) {
                        }
                        z9 = true;
                        if (dVar2.f1281k != 2 ? false : z9) {
                        }
                        gVar10 = gVar7;
                        gVar9 = gVar6;
                        if (!z7) {
                        }
                        if (dVar4.K.g()) {
                        }
                        this.f1278h = false;
                        this.f1279i = false;
                    }
                    i3 = i19;
                    i5 = i14;
                    z7 = true;
                    int[] iArr222 = this.n;
                    iArr222[c2] = i2;
                    iArr222[1] = i3;
                    if (!z7) {
                    }
                    z8 = false;
                    if (!z7) {
                    }
                    if (this.O[0] != aVar3) {
                    }
                    if (z22) {
                    }
                    boolean z182222 = !this.K.g();
                    boolean[] zArr22222 = this.N;
                    boolean z192222 = zArr22222[0];
                    boolean z202222 = zArr22222[1];
                    f fVar22222 = kVar.f1326h;
                    if (z2) {
                    }
                    aVar2 = aVar5;
                    gVar5 = l2;
                    aVar = aVar3;
                    gVar4 = l6;
                    gVar3 = l5;
                    gVar2 = l4;
                    if (z2) {
                    }
                    z9 = true;
                    if (dVar2.f1281k != 2 ? false : z9) {
                    }
                    gVar10 = gVar7;
                    gVar9 = gVar6;
                    if (!z7) {
                    }
                    if (dVar4.K.g()) {
                    }
                    this.f1278h = false;
                    this.f1279i = false;
                }
                c2 = 0;
                i2 = i18;
                i3 = i19;
                i5 = i14;
                i4 = i16;
                z7 = true;
                int[] iArr2222 = this.n;
                iArr2222[c2] = i2;
                iArr2222[1] = i3;
                if (!z7) {
                }
                z8 = false;
                if (!z7) {
                }
                if (this.O[0] != aVar3) {
                }
                if (z22) {
                }
                boolean z1822222 = !this.K.g();
                boolean[] zArr222222 = this.N;
                boolean z1922222 = zArr222222[0];
                boolean z2022222 = zArr222222[1];
                f fVar222222 = kVar.f1326h;
                if (z2) {
                }
                aVar2 = aVar5;
                gVar5 = l2;
                aVar = aVar3;
                gVar4 = l6;
                gVar3 = l5;
                gVar2 = l4;
                if (z2) {
                }
                z9 = true;
                if (dVar2.f1281k != 2 ? false : z9) {
                }
                gVar10 = gVar7;
                gVar9 = gVar6;
                if (!z7) {
                }
                if (dVar4.K.g()) {
                }
                this.f1278h = false;
                this.f1279i = false;
            }
        } else {
            gVar = l3;
        }
        c2 = 0;
        i2 = i18;
        i3 = i19;
        i5 = i14;
        i4 = i16;
        z7 = false;
        int[] iArr22222 = this.n;
        iArr22222[c2] = i2;
        iArr22222[1] = i3;
        if (!z7) {
        }
        z8 = false;
        if (!z7) {
        }
        if (this.O[0] != aVar3) {
        }
        if (z22) {
        }
        boolean z18222222 = !this.K.g();
        boolean[] zArr2222222 = this.N;
        boolean z19222222 = zArr2222222[0];
        boolean z20222222 = zArr2222222[1];
        f fVar2222222 = kVar.f1326h;
        if (z2) {
        }
        aVar2 = aVar5;
        gVar5 = l2;
        aVar = aVar3;
        gVar4 = l6;
        gVar3 = l5;
        gVar2 = l4;
        if (z2) {
        }
        z9 = true;
        if (dVar2.f1281k != 2 ? false : z9) {
        }
        gVar10 = gVar7;
        gVar9 = gVar6;
        if (!z7) {
        }
        if (dVar4.K.g()) {
        }
        this.f1278h = false;
        this.f1279i = false;
    }

    public boolean e() {
        return this.c0 != 8;
    }

    /* JADX WARNING: Removed duplicated region for block: B:154:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x030b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x03ac A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0412  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0424  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0427 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x044a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0463  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0472 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:318:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:322:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x016f  */
    public final void f(e.g.b.d dVar, boolean z2, boolean z3, boolean z4, boolean z5, g gVar, g gVar2, a aVar, boolean z6, c cVar, c cVar2, int i2, int i3, int i4, int i5, float f2, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i6, int i7, int i8, int i9, float f3, boolean z12) {
        int i10;
        boolean z13;
        boolean z14;
        int i11;
        boolean z15;
        int i12;
        int i13;
        boolean z16;
        boolean z17;
        char c2;
        g gVar3;
        int i14;
        int i15;
        int i16;
        g gVar4;
        g gVar5;
        g gVar6;
        c cVar3;
        a[] aVarArr;
        a aVar2;
        boolean z18;
        boolean z19;
        g gVar7;
        g gVar8;
        int i17;
        g gVar9;
        g gVar10;
        boolean z20;
        int i18;
        int i19;
        boolean z21;
        boolean z22;
        int i20;
        g gVar11;
        int i21;
        boolean z23;
        int i22;
        g gVar12;
        d dVar2;
        g gVar13;
        d dVar3;
        g gVar14;
        g gVar15;
        d dVar4;
        boolean z24;
        int i23;
        int i24;
        int i25;
        int i26;
        d dVar5;
        int i27;
        int i28;
        int i29;
        boolean z25;
        boolean z26;
        boolean z27;
        g gVar16;
        int i30;
        boolean z28;
        int i31;
        boolean z29;
        boolean z30;
        int i32;
        boolean z31;
        int i33;
        boolean z32;
        int i34;
        boolean z33;
        int i35;
        g gVar17;
        g gVar18;
        int i36 = i8;
        int i37 = i9;
        c.a aVar3 = c.a.BOTTOM;
        g l2 = dVar.l(cVar);
        g l3 = dVar.l(cVar2);
        g l4 = dVar.l(cVar.f1262f);
        g l5 = dVar.l(cVar2.f1262f);
        boolean g2 = cVar.g();
        boolean g3 = cVar2.g();
        boolean g4 = this.K.g();
        if (g3) {
            i10 = (g2 ? 1 : 0) + 1;
        } else {
            i10 = g2 ? 1 : 0;
        }
        if (g4) {
            i10++;
        }
        int i38 = z7 ? 3 : i6;
        int ordinal = aVar.ordinal();
        if (ordinal != 0 && ordinal != 1 && ordinal == 2) {
            if (i38 != 4) {
                z13 = true;
                z14 = z13;
                if (this.c0 != 8) {
                    i11 = 0;
                    z14 = false;
                } else {
                    i11 = i3;
                }
                if (z12) {
                    if (!g2 && !g3 && !g4) {
                        dVar.e(l2, i2);
                    } else if (g2 && !g3) {
                        z15 = g4;
                        i12 = 8;
                        dVar.d(l2, l4, cVar.d(), 8);
                        if (z14) {
                            if (i10 == 2 || z7 || !(i38 == 1 || i38 == 0)) {
                                if (i36 == -2) {
                                    i36 = i11;
                                }
                                if (i37 == -2) {
                                    i37 = i11;
                                }
                                if (i11 > 0 && i38 != 1) {
                                    i11 = 0;
                                }
                                if (i36 > 0) {
                                    dVar.f(l3, l2, i36, 8);
                                    i11 = Math.max(i11, i36);
                                }
                                if (i37 > 0) {
                                    if (!z3 || i38 != 1) {
                                        i35 = 8;
                                        dVar.g(l3, l2, i37, 8);
                                    } else {
                                        i35 = 8;
                                    }
                                    i11 = Math.min(i11, i37);
                                } else {
                                    i35 = 8;
                                }
                                if (i38 == 1) {
                                    if (z3) {
                                        dVar.d(l3, l2, i11, i35);
                                    } else {
                                        dVar.d(l3, l2, i11, 5);
                                        dVar.g(l3, l2, i11, i35);
                                    }
                                } else if (i38 == 2) {
                                    c.a aVar4 = cVar.f1261e;
                                    c.a aVar5 = c.a.TOP;
                                    if (aVar4 == aVar5 || aVar4 == aVar3) {
                                        g l6 = dVar.l(this.P.i(aVar5));
                                        gVar18 = dVar.l(this.P.i(aVar3));
                                        gVar17 = l6;
                                    } else {
                                        gVar17 = dVar.l(this.P.i(c.a.LEFT));
                                        gVar18 = dVar.l(this.P.i(c.a.RIGHT));
                                    }
                                    b m2 = dVar.m();
                                    m2.d(l3, l2, gVar18, gVar17, f3);
                                    dVar.c(m2);
                                } else {
                                    i13 = i36;
                                    z16 = true;
                                    if (!z12) {
                                        gVar6 = gVar;
                                        i15 = i10;
                                        gVar4 = l3;
                                        gVar3 = l2;
                                        z17 = z16;
                                        i16 = 0;
                                        c2 = 1;
                                        gVar5 = gVar2;
                                        i14 = 2;
                                    } else if (z9) {
                                        gVar6 = gVar;
                                        i15 = i10;
                                        gVar4 = l3;
                                        gVar3 = l2;
                                        z17 = z16;
                                        i16 = 0;
                                        i14 = 2;
                                        c2 = 1;
                                        gVar5 = gVar2;
                                    } else {
                                        if ((g2 || g3 || z15) && (!g2 || g3)) {
                                            if (g2 || !g3) {
                                                gVar10 = l5;
                                                if (g2 && g3) {
                                                    d dVar6 = cVar.f1262f.f1260d;
                                                    d dVar7 = cVar2.f1262f.f1260d;
                                                    d dVar8 = this.P;
                                                    int i39 = 6;
                                                    if (z14) {
                                                        if (i38 == 0) {
                                                            if (i37 != 0 || i13 != 0) {
                                                                z32 = true;
                                                                z33 = true;
                                                                z29 = false;
                                                                i31 = 5;
                                                                i34 = 5;
                                                            } else if (!l4.f1240f || !gVar10.f1240f) {
                                                                z32 = false;
                                                                z33 = false;
                                                                z29 = true;
                                                                i31 = 8;
                                                                i34 = 8;
                                                            } else {
                                                                dVar.d(l2, l4, cVar.d(), 8);
                                                                dVar.d(l3, gVar10, -cVar2.d(), 8);
                                                                return;
                                                            }
                                                            if ((dVar6 instanceof a) || (dVar7 instanceof a)) {
                                                                z28 = z32;
                                                                i32 = 4;
                                                            } else {
                                                                z28 = z32;
                                                                i32 = i34;
                                                            }
                                                            i20 = i38;
                                                            z30 = z33;
                                                        } else {
                                                            if (i38 == 1) {
                                                                i20 = i38;
                                                                i32 = 4;
                                                                z30 = true;
                                                                z29 = false;
                                                                i31 = 8;
                                                            } else if (i38 == 3) {
                                                                i20 = i38;
                                                                if (this.u == -1) {
                                                                    i21 = z10 ? z3 ? 5 : 4 : 8;
                                                                    gVar11 = gVar2;
                                                                    z22 = true;
                                                                    z21 = true;
                                                                    i19 = 5;
                                                                    i18 = 8;
                                                                } else if (z7) {
                                                                    if (i7 != 2) {
                                                                        if (i7 != 1) {
                                                                            z31 = false;
                                                                            if (z31) {
                                                                                i32 = 5;
                                                                                i33 = 8;
                                                                            } else {
                                                                                i32 = 4;
                                                                                i33 = 5;
                                                                            }
                                                                            i31 = i33;
                                                                            z30 = true;
                                                                            z29 = true;
                                                                        }
                                                                    }
                                                                    z31 = true;
                                                                    if (z31) {
                                                                    }
                                                                    i31 = i33;
                                                                    z30 = true;
                                                                    z29 = true;
                                                                } else {
                                                                    if (i37 > 0) {
                                                                        gVar11 = gVar2;
                                                                        z26 = true;
                                                                        z25 = true;
                                                                        z21 = true;
                                                                        i19 = 5;
                                                                    } else if (i37 != 0 || i13 != 0) {
                                                                        gVar11 = gVar2;
                                                                        z27 = true;
                                                                    } else if (!z10) {
                                                                        gVar11 = gVar2;
                                                                        z26 = true;
                                                                        z25 = true;
                                                                        z21 = true;
                                                                        i19 = 8;
                                                                    } else {
                                                                        gVar11 = gVar2;
                                                                        i18 = (dVar6 == dVar8 || dVar7 == dVar8) ? 5 : 4;
                                                                        i21 = 6;
                                                                        z22 = true;
                                                                        z21 = true;
                                                                        i19 = 4;
                                                                    }
                                                                    z20 = z25;
                                                                    i18 = 5;
                                                                    z22 = z26;
                                                                    i21 = 6;
                                                                    if (z20 || l4 != gVar10 || dVar6 == dVar8) {
                                                                        z23 = true;
                                                                    } else {
                                                                        z23 = false;
                                                                        z20 = false;
                                                                    }
                                                                    if (z22) {
                                                                        if (z14 || z8 || z10 || l4 != gVar || gVar10 != gVar11) {
                                                                            z19 = z3;
                                                                            i28 = i18;
                                                                            i29 = i21;
                                                                        } else {
                                                                            z19 = false;
                                                                            i29 = 8;
                                                                            z23 = false;
                                                                            i28 = 8;
                                                                        }
                                                                        dVar3 = dVar6;
                                                                        z18 = z16;
                                                                        dVar4 = dVar7;
                                                                        gVar12 = gVar10;
                                                                        i22 = i13;
                                                                        gVar15 = l4;
                                                                        gVar13 = l3;
                                                                        dVar2 = dVar8;
                                                                        gVar14 = l2;
                                                                        dVar.b(l2, l4, cVar.d(), f2, gVar10, l3, cVar2.d(), i29);
                                                                        z24 = z23;
                                                                        i18 = i28;
                                                                    } else {
                                                                        dVar3 = dVar6;
                                                                        gVar12 = gVar10;
                                                                        gVar13 = l3;
                                                                        z18 = z16;
                                                                        i22 = i13;
                                                                        dVar2 = dVar8;
                                                                        dVar4 = dVar7;
                                                                        gVar15 = l4;
                                                                        gVar14 = l2;
                                                                        z19 = z3;
                                                                        z24 = z23;
                                                                    }
                                                                    if (this.c0 == 8 || cVar2.f()) {
                                                                        gVar8 = gVar12;
                                                                        if (z20) {
                                                                            int i40 = (!z19 || gVar15 == gVar8 || z14 || (!(dVar3 instanceof a) && !(dVar4 instanceof a))) ? i18 : 6;
                                                                            dVar.f(gVar14, gVar15, cVar.d(), i40);
                                                                            dVar.g(gVar13, gVar8, -cVar2.d(), i40);
                                                                            i18 = i40;
                                                                        }
                                                                        if (z19 || !z11 || (dVar3 instanceof a) || (dVar4 instanceof a)) {
                                                                            i24 = i19;
                                                                            i23 = i18;
                                                                        } else {
                                                                            i24 = 6;
                                                                            i23 = 6;
                                                                            z24 = true;
                                                                        }
                                                                        if (z24) {
                                                                            if (!z21 || (z10 && !z4)) {
                                                                                dVar5 = dVar2;
                                                                            } else {
                                                                                dVar5 = dVar2;
                                                                                if (!(dVar3 == dVar5 || dVar4 == dVar5)) {
                                                                                    i39 = i24;
                                                                                }
                                                                                if ((dVar3 instanceof f) || (dVar4 instanceof f)) {
                                                                                    i39 = 5;
                                                                                }
                                                                                if ((dVar3 instanceof a) || (dVar4 instanceof a)) {
                                                                                    i39 = 5;
                                                                                }
                                                                                i24 = Math.max(z10 ? 5 : i39, i24);
                                                                            }
                                                                            if (z19) {
                                                                                i24 = Math.min(i23, i24);
                                                                                if (z7 && !z10 && (dVar3 == dVar5 || dVar4 == dVar5)) {
                                                                                    i27 = 4;
                                                                                    dVar.d(gVar14, gVar15, cVar.d(), i27);
                                                                                    dVar.d(gVar13, gVar8, -cVar2.d(), i27);
                                                                                }
                                                                            }
                                                                            i27 = i24;
                                                                            dVar.d(gVar14, gVar15, cVar.d(), i27);
                                                                            dVar.d(gVar13, gVar8, -cVar2.d(), i27);
                                                                        }
                                                                        if (z19) {
                                                                            gVar7 = gVar13;
                                                                            int d2 = gVar == gVar15 ? cVar.d() : 0;
                                                                            if (gVar15 != gVar) {
                                                                                dVar.f(gVar14, gVar, d2, 5);
                                                                            }
                                                                        } else {
                                                                            gVar7 = gVar13;
                                                                        }
                                                                        if (!z19 && z14 && i4 == 0 && i22 == 0) {
                                                                            if (!z14 || i20 != 3) {
                                                                                i25 = 0;
                                                                                i26 = 5;
                                                                            } else {
                                                                                i26 = 8;
                                                                                i25 = 0;
                                                                            }
                                                                            dVar.f(gVar7, gVar14, i25, i26);
                                                                            if (!z19) {
                                                                                return;
                                                                            }
                                                                            return;
                                                                        } else if (!z19 && z18) {
                                                                            if (cVar2.f1262f != null) {
                                                                                i17 = cVar2.d();
                                                                                gVar9 = gVar2;
                                                                            } else {
                                                                                gVar9 = gVar2;
                                                                                i17 = 0;
                                                                            }
                                                                            if (gVar8 != gVar9) {
                                                                                dVar.f(gVar9, gVar7, i17, 5);
                                                                                return;
                                                                            }
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                z20 = true;
                                                                if (z20) {
                                                                }
                                                                z23 = true;
                                                                if (z22) {
                                                                }
                                                                if (this.c0 == 8) {
                                                                }
                                                                gVar8 = gVar12;
                                                                if (z20) {
                                                                }
                                                                if (z19) {
                                                                }
                                                                i24 = i19;
                                                                i23 = i18;
                                                                if (z24) {
                                                                }
                                                                if (z19) {
                                                                }
                                                                if (!z19) {
                                                                }
                                                                if (!z19) {
                                                                }
                                                            } else {
                                                                i20 = i38;
                                                                gVar11 = gVar2;
                                                                z26 = false;
                                                                z25 = false;
                                                                z21 = false;
                                                                i19 = 4;
                                                                z20 = z25;
                                                                i18 = 5;
                                                                z22 = z26;
                                                                i21 = 6;
                                                                if (z20) {
                                                                }
                                                                z23 = true;
                                                                if (z22) {
                                                                }
                                                                if (this.c0 == 8) {
                                                                }
                                                                gVar8 = gVar12;
                                                                if (z20) {
                                                                }
                                                                if (z19) {
                                                                }
                                                                i24 = i19;
                                                                i23 = i18;
                                                                if (z24) {
                                                                }
                                                                if (z19) {
                                                                }
                                                                if (!z19) {
                                                                }
                                                                if (!z19) {
                                                                }
                                                            }
                                                            z28 = true;
                                                        }
                                                        i19 = i32;
                                                        i18 = i31;
                                                        i21 = 6;
                                                        z21 = z29;
                                                        z22 = z28;
                                                        z20 = z30;
                                                        gVar11 = gVar2;
                                                        if (z20) {
                                                        }
                                                        z23 = true;
                                                        if (z22) {
                                                        }
                                                        if (this.c0 == 8) {
                                                        }
                                                        gVar8 = gVar12;
                                                        if (z20) {
                                                        }
                                                        if (z19) {
                                                        }
                                                        i24 = i19;
                                                        i23 = i18;
                                                        if (z24) {
                                                        }
                                                        if (z19) {
                                                        }
                                                        if (!z19) {
                                                        }
                                                        if (!z19) {
                                                        }
                                                    } else {
                                                        i20 = i38;
                                                        if (!l4.f1240f || !gVar10.f1240f) {
                                                            gVar11 = gVar2;
                                                            z27 = false;
                                                        } else {
                                                            dVar.b(l2, l4, cVar.d(), f2, gVar10, l3, cVar2.d(), 8);
                                                            if (z3 && z16) {
                                                                if (cVar2.f1262f != null) {
                                                                    i30 = cVar2.d();
                                                                    gVar16 = gVar2;
                                                                } else {
                                                                    gVar16 = gVar2;
                                                                    i30 = 0;
                                                                }
                                                                if (gVar10 != gVar16) {
                                                                    dVar.f(gVar16, l3, i30, 5);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                    }
                                                    z21 = z27;
                                                    z26 = true;
                                                    z25 = true;
                                                    i19 = 4;
                                                    z20 = z25;
                                                    i18 = 5;
                                                    z22 = z26;
                                                    i21 = 6;
                                                    if (z20) {
                                                    }
                                                    z23 = true;
                                                    if (z22) {
                                                    }
                                                    if (this.c0 == 8) {
                                                    }
                                                    gVar8 = gVar12;
                                                    if (z20) {
                                                    }
                                                    if (z19) {
                                                    }
                                                    i24 = i19;
                                                    i23 = i18;
                                                    if (z24) {
                                                    }
                                                    if (z19) {
                                                    }
                                                    if (!z19) {
                                                    }
                                                    if (!z19) {
                                                    }
                                                }
                                            } else {
                                                gVar10 = l5;
                                                dVar.d(l3, gVar10, -cVar2.d(), 8);
                                                if (z3) {
                                                    dVar.f(l2, gVar, 0, 5);
                                                }
                                            }
                                            gVar8 = gVar10;
                                            gVar7 = l3;
                                            z18 = z16;
                                        } else {
                                            gVar7 = l3;
                                            z18 = z16;
                                            gVar8 = l5;
                                        }
                                        z19 = z3;
                                        if (!z19) {
                                        }
                                    }
                                    if (i15 >= i14 && z3 && z17) {
                                        dVar.f(gVar3, gVar6, i16, 8);
                                        boolean z34 = z2 || this.H.f1262f == null;
                                        if (!z2 && (cVar3 = this.H.f1262f) != null) {
                                            d dVar9 = cVar3.f1260d;
                                            z34 = dVar9.S != 0.0f && (aVarArr = dVar9.O)[i16] == (aVar2 = a.MATCH_CONSTRAINT) && aVarArr[c2] == aVar2;
                                        }
                                        if (z34) {
                                            dVar.f(gVar5, gVar4, i16, 8);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                int max = Math.max(i36, i11);
                                if (i37 > 0) {
                                    max = Math.min(i37, max);
                                }
                                dVar.d(l3, l2, max, 8);
                            }
                            z16 = z5;
                            i13 = i36;
                            z14 = false;
                            if (!z12) {
                            }
                            if (i15 >= i14) {
                                return;
                            }
                            return;
                        } else if (z6) {
                            dVar.d(l3, l2, 0, 3);
                            if (i4 > 0) {
                                dVar.f(l3, l2, i4, i12);
                            }
                            if (i5 < Integer.MAX_VALUE) {
                                dVar.g(l3, l2, i5, i12);
                            }
                        } else {
                            dVar.d(l3, l2, i11, i12);
                        }
                        z16 = z5;
                        i13 = i36;
                        if (!z12) {
                        }
                        if (i15 >= i14) {
                        }
                    }
                }
                z15 = g4;
                i12 = 8;
                if (z14) {
                }
                z16 = z5;
                i13 = i36;
                if (!z12) {
                }
                if (i15 >= i14) {
                }
            }
        }
        z13 = false;
        z14 = z13;
        if (this.c0 != 8) {
        }
        if (z12) {
        }
        z15 = g4;
        i12 = 8;
        if (z14) {
        }
        z16 = z5;
        i13 = i36;
        if (!z12) {
        }
        if (i15 >= i14) {
        }
    }

    public void g(e.g.b.d dVar) {
        dVar.l(this.D);
        dVar.l(this.E);
        dVar.l(this.F);
        dVar.l(this.G);
        if (this.W > 0) {
            dVar.l(this.H);
        }
    }

    public void h() {
        if (this.f1274d == null) {
            this.f1274d = new k(this);
        }
        if (this.f1275e == null) {
            this.f1275e = new m(this);
        }
    }

    public c i(c.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.D;
            case 2:
                return this.E;
            case 3:
                return this.F;
            case 4:
                return this.G;
            case 5:
                return this.H;
            case 6:
                return this.K;
            case 7:
                return this.I;
            case 8:
                return this.J;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public int j() {
        return t() + this.R;
    }

    public a k(int i2) {
        if (i2 == 0) {
            return m();
        }
        if (i2 == 1) {
            return q();
        }
        return null;
    }

    public int l() {
        if (this.c0 == 8) {
            return 0;
        }
        return this.R;
    }

    public a m() {
        return this.O[0];
    }

    public d n(int i2) {
        c cVar;
        c cVar2;
        if (i2 == 0) {
            c cVar3 = this.F;
            c cVar4 = cVar3.f1262f;
            if (cVar4 == null || cVar4.f1262f != cVar3) {
                return null;
            }
            return cVar4.f1260d;
        } else if (i2 == 1 && (cVar2 = (cVar = this.G).f1262f) != null && cVar2.f1262f == cVar) {
            return cVar2.f1260d;
        } else {
            return null;
        }
    }

    public d o(int i2) {
        c cVar;
        c cVar2;
        if (i2 == 0) {
            c cVar3 = this.D;
            c cVar4 = cVar3.f1262f;
            if (cVar4 == null || cVar4.f1262f != cVar3) {
                return null;
            }
            return cVar4.f1260d;
        } else if (i2 == 1 && (cVar2 = (cVar = this.E).f1262f) != null && cVar2.f1262f == cVar) {
            return cVar2.f1260d;
        } else {
            return null;
        }
    }

    public int p() {
        return s() + this.Q;
    }

    public a q() {
        return this.O[1];
    }

    public int r() {
        if (this.c0 == 8) {
            return 0;
        }
        return this.Q;
    }

    public int s() {
        d dVar = this.P;
        return (dVar == null || !(dVar instanceof e)) ? this.U : ((e) dVar).r0 + this.U;
    }

    public int t() {
        d dVar = this.P;
        return (dVar == null || !(dVar instanceof e)) ? this.V : ((e) dVar).s0 + this.V;
    }

    public String toString() {
        String str = "";
        StringBuilder h2 = f.a.a.a.a.h(str);
        if (this.d0 != null) {
            str = f.a.a.a.a.e(f.a.a.a.a.h("id: "), this.d0, " ");
        }
        h2.append(str);
        h2.append("(");
        h2.append(this.U);
        h2.append(", ");
        h2.append(this.V);
        h2.append(") - (");
        h2.append(this.Q);
        h2.append(" x ");
        h2.append(this.R);
        h2.append(")");
        return h2.toString();
    }

    public boolean u(int i2) {
        if (i2 == 0) {
            return (this.D.f1262f != null ? 1 : 0) + (this.F.f1262f != null ? 1 : 0) < 2;
        }
        return ((this.E.f1262f != null ? 1 : 0) + (this.G.f1262f != null ? 1 : 0)) + (this.H.f1262f != null ? 1 : 0) < 2;
    }

    public final boolean v(int i2) {
        int i3 = i2 * 2;
        c[] cVarArr = this.L;
        if (!(cVarArr[i3].f1262f == null || cVarArr[i3].f1262f.f1262f == cVarArr[i3])) {
            int i4 = i3 + 1;
            return cVarArr[i4].f1262f != null && cVarArr[i4].f1262f.f1262f == cVarArr[i4];
        }
    }

    public boolean w() {
        c cVar = this.D;
        c cVar2 = cVar.f1262f;
        if (cVar2 != null && cVar2.f1262f == cVar) {
            return true;
        }
        c cVar3 = this.F;
        c cVar4 = cVar3.f1262f;
        return cVar4 != null && cVar4.f1262f == cVar3;
    }

    public boolean x() {
        c cVar = this.E;
        c cVar2 = cVar.f1262f;
        if (cVar2 != null && cVar2.f1262f == cVar) {
            return true;
        }
        c cVar3 = this.G;
        c cVar4 = cVar3.f1262f;
        return cVar4 != null && cVar4.f1262f == cVar3;
    }

    public boolean y() {
        return this.f1277g && this.c0 != 8;
    }

    public boolean z() {
        return this.f1278h || (this.D.c && this.F.c);
    }
}
