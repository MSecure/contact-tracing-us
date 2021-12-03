package e.g.a.i;

import e.g.a.b;
import e.g.a.g;
import e.g.a.i.c;
import e.g.a.i.l.c;
import e.g.a.i.l.f;
import e.g.a.i.l.k;
import e.g.a.i.l.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class d {
    public float A;
    public int[] B;
    public float C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public c I;
    public c J;
    public c K;
    public c L;
    public c M;
    public c N;
    public c O;
    public c P;
    public c[] Q;
    public ArrayList<c> R;
    public boolean[] S;
    public a[] T;
    public d U;
    public int V;
    public int W;
    public float X;
    public int Y;
    public int Z;
    public boolean a = false;
    public int a0;
    public c b;
    public int b0;
    public c c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public k f1307d = null;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public m f1308e = null;
    public float e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean[] f1309f = {true, true};
    public float f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1310g = true;
    public Object g0;

    /* renamed from: h  reason: collision with root package name */
    public int f1311h = -1;
    public int h0;

    /* renamed from: i  reason: collision with root package name */
    public int f1312i = -1;
    public String i0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1313j;
    public int j0;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1314k;
    public int k0;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1315l;
    public float[] l0;
    public boolean m;
    public d[] m0;
    public int n;
    public d[] n0;
    public int o;
    public int o0;
    public int p;
    public int p0;
    public int q;
    public int r;
    public int[] s;
    public int t;
    public int u;
    public float v;
    public int w;
    public int x;
    public float y;
    public int z;

    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public d() {
        new HashMap();
        this.f1313j = false;
        this.f1314k = false;
        this.f1315l = false;
        this.m = false;
        this.n = -1;
        this.o = -1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = new int[2];
        this.t = 0;
        this.u = 0;
        this.v = 1.0f;
        this.w = 0;
        this.x = 0;
        this.y = 1.0f;
        this.z = -1;
        this.A = 1.0f;
        this.B = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.C = 0.0f;
        this.D = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        c cVar = new c(this, c.a.LEFT);
        this.I = cVar;
        c cVar2 = new c(this, c.a.TOP);
        this.J = cVar2;
        c cVar3 = new c(this, c.a.RIGHT);
        this.K = cVar3;
        c cVar4 = new c(this, c.a.BOTTOM);
        this.L = cVar4;
        c cVar5 = new c(this, c.a.BASELINE);
        this.M = cVar5;
        this.N = new c(this, c.a.CENTER_X);
        this.O = new c(this, c.a.CENTER_Y);
        c cVar6 = new c(this, c.a.CENTER);
        this.P = cVar6;
        this.Q = new c[]{cVar, cVar3, cVar2, cVar4, cVar5, cVar6};
        ArrayList<c> arrayList = new ArrayList<>();
        this.R = arrayList;
        this.S = new boolean[2];
        a aVar = a.FIXED;
        this.T = new a[]{aVar, aVar};
        this.U = null;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.e0 = 0.5f;
        this.f0 = 0.5f;
        this.h0 = 0;
        this.i0 = null;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = new float[]{-1.0f, -1.0f};
        this.m0 = new d[]{null, null};
        this.n0 = new d[]{null, null};
        this.o0 = -1;
        this.p0 = -1;
        arrayList.add(this.I);
        this.R.add(this.J);
        this.R.add(this.K);
        this.R.add(this.L);
        this.R.add(this.N);
        this.R.add(this.O);
        this.R.add(this.P);
        this.R.add(this.M);
    }

    public boolean A() {
        return this.f1313j || (this.I.c && this.K.c);
    }

    public boolean B() {
        return this.f1314k || (this.J.c && this.L.c);
    }

    public void C() {
        this.I.h();
        this.J.h();
        this.K.h();
        this.L.h();
        this.M.h();
        this.N.h();
        this.O.h();
        this.P.h();
        this.U = null;
        this.C = 0.0f;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0.5f;
        this.f0 = 0.5f;
        a[] aVarArr = this.T;
        a aVar = a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.g0 = null;
        this.h0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        float[] fArr = this.l0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.n = -1;
        this.o = -1;
        int[] iArr = this.B;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.q = 0;
        this.r = 0;
        this.v = 1.0f;
        this.y = 1.0f;
        this.u = Integer.MAX_VALUE;
        this.x = Integer.MAX_VALUE;
        this.t = 0;
        this.w = 0;
        this.z = -1;
        this.A = 1.0f;
        boolean[] zArr = this.f1309f;
        zArr[0] = true;
        zArr[1] = true;
        this.F = false;
        boolean[] zArr2 = this.S;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f1310g = true;
        int[] iArr2 = this.s;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f1311h = -1;
        this.f1312i = -1;
    }

    public void D() {
        this.f1313j = false;
        this.f1314k = false;
        this.f1315l = false;
        this.m = false;
        int size = this.R.size();
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = this.R.get(i2);
            cVar.c = false;
            cVar.b = 0;
        }
    }

    public void E(e.g.a.c cVar) {
        this.I.i();
        this.J.i();
        this.K.i();
        this.L.i();
        this.M.i();
        this.P.i();
        this.N.i();
        this.O.i();
    }

    public void F(int i2) {
        this.b0 = i2;
        this.D = i2 > 0;
    }

    public void G(int i2, int i3) {
        if (!this.f1313j) {
            c cVar = this.I;
            cVar.b = i2;
            cVar.c = true;
            c cVar2 = this.K;
            cVar2.b = i3;
            cVar2.c = true;
            this.Z = i2;
            this.V = i3 - i2;
            this.f1313j = true;
        }
    }

    public void H(int i2, int i3) {
        if (!this.f1314k) {
            c cVar = this.J;
            cVar.b = i2;
            cVar.c = true;
            c cVar2 = this.L;
            cVar2.b = i3;
            cVar2.c = true;
            this.a0 = i2;
            this.W = i3 - i2;
            if (this.D) {
                this.M.j(i2 + this.b0);
            }
            this.f1314k = true;
        }
    }

    public void I(int i2) {
        this.W = i2;
        int i3 = this.d0;
        if (i2 < i3) {
            this.W = i3;
        }
    }

    public void J(a aVar) {
        this.T[0] = aVar;
    }

    public void K(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.d0 = i2;
    }

    public void L(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.c0 = i2;
    }

    public void M(a aVar) {
        this.T[1] = aVar;
    }

    public void N(int i2) {
        this.V = i2;
        int i3 = this.c0;
        if (i2 < i3) {
            this.V = i3;
        }
    }

    public void O(boolean z2, boolean z3) {
        int i2;
        int i3;
        a aVar = a.FIXED;
        k kVar = this.f1307d;
        boolean z4 = z2 & kVar.f1358g;
        m mVar = this.f1308e;
        boolean z5 = z3 & mVar.f1358g;
        int i4 = kVar.f1359h.f1336g;
        int i5 = mVar.f1359h.f1336g;
        int i6 = kVar.f1360i.f1336g;
        int i7 = mVar.f1360i.f1336g;
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
            this.Z = i4;
        }
        if (z5) {
            this.a0 = i5;
        }
        if (this.h0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        if (z4) {
            if (this.T[0] == aVar && i9 < (i3 = this.V)) {
                i9 = i3;
            }
            this.V = i9;
            int i11 = this.c0;
            if (i9 < i11) {
                this.V = i11;
            }
        }
        if (z5) {
            if (this.T[1] == aVar && i10 < (i2 = this.W)) {
                i10 = i2;
            }
            this.W = i10;
            int i12 = this.d0;
            if (i10 < i12) {
                this.W = i12;
            }
        }
    }

    public void P(e.g.a.d dVar, boolean z2) {
        int i2;
        int i3;
        m mVar;
        k kVar;
        int o2 = dVar.o(this.I);
        int o3 = dVar.o(this.J);
        int o4 = dVar.o(this.K);
        int o5 = dVar.o(this.L);
        if (z2 && (kVar = this.f1307d) != null) {
            f fVar = kVar.f1359h;
            if (fVar.f1339j) {
                f fVar2 = kVar.f1360i;
                if (fVar2.f1339j) {
                    o2 = fVar.f1336g;
                    o4 = fVar2.f1336g;
                }
            }
        }
        if (z2 && (mVar = this.f1308e) != null) {
            f fVar3 = mVar.f1359h;
            if (fVar3.f1339j) {
                f fVar4 = mVar.f1360i;
                if (fVar4.f1339j) {
                    o3 = fVar3.f1336g;
                    o5 = fVar4.f1336g;
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
        a aVar = a.MATCH_CONSTRAINT;
        int i5 = o4 - o2;
        int i6 = o5 - o3;
        this.Z = o2;
        this.a0 = o3;
        if (this.h0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        a[] aVarArr = this.T;
        a aVar2 = aVarArr[0];
        a aVar3 = a.FIXED;
        if (aVar2 == aVar3 && i5 < (i3 = this.V)) {
            i5 = i3;
        }
        if (aVarArr[1] == aVar3 && i6 < (i2 = this.W)) {
            i6 = i2;
        }
        this.V = i5;
        this.W = i6;
        int i7 = this.d0;
        if (i6 < i7) {
            this.W = i7;
        }
        int i8 = this.c0;
        if (i5 < i8) {
            this.V = i8;
        }
        int i9 = this.u;
        if (i9 > 0 && aVarArr[0] == aVar) {
            this.V = Math.min(this.V, i9);
        }
        int i10 = this.x;
        if (i10 > 0 && this.T[1] == aVar) {
            this.W = Math.min(this.W, i10);
        }
        int i11 = this.V;
        if (i5 != i11) {
            this.f1311h = i11;
        }
        int i12 = this.W;
        if (i6 != i12) {
            this.f1312i = i12;
        }
    }

    public void b(e eVar, e.g.a.d dVar, HashSet<d> hashSet, int i2, boolean z2) {
        if (z2) {
            if (hashSet.contains(this)) {
                i.a(eVar, dVar, this);
                hashSet.remove(this);
                d(dVar, eVar.a0(64));
            } else {
                return;
            }
        }
        if (i2 == 0) {
            HashSet<c> hashSet2 = this.I.a;
            if (hashSet2 != null) {
                Iterator<c> it = hashSet2.iterator();
                while (it.hasNext()) {
                    it.next().f1293d.b(eVar, dVar, hashSet, i2, true);
                }
            }
            HashSet<c> hashSet3 = this.K.a;
            if (hashSet3 != null) {
                Iterator<c> it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    it2.next().f1293d.b(eVar, dVar, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet<c> hashSet4 = this.J.a;
        if (hashSet4 != null) {
            Iterator<c> it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                it3.next().f1293d.b(eVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<c> hashSet5 = this.L.a;
        if (hashSet5 != null) {
            Iterator<c> it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                it4.next().f1293d.b(eVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<c> hashSet6 = this.M.a;
        if (hashSet6 != null) {
            Iterator<c> it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                it5.next().f1293d.b(eVar, dVar, hashSet, i2, true);
            }
        }
    }

    public boolean c() {
        return (this instanceof j) || (this instanceof f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:203:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x04c3  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x053b  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x053d  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0540  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x05cf  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x0618  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x063e  */
    /* JADX WARNING: Removed duplicated region for block: B:365:0x0648  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b8  */
    public void d(e.g.a.d dVar, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i2;
        int i3;
        boolean z8;
        int i4;
        g gVar;
        char c2;
        boolean z9;
        int i5;
        boolean z10;
        a aVar;
        g gVar2;
        g gVar3;
        g gVar4;
        a aVar2;
        g gVar5;
        g gVar6;
        d dVar2;
        e.g.a.d dVar3;
        g gVar7;
        g gVar8;
        char c3;
        int i6;
        boolean z11;
        int i7;
        g gVar9;
        g gVar10;
        g gVar11;
        d dVar4;
        g gVar12;
        g gVar13;
        g gVar14;
        g gVar15;
        e.g.a.d dVar5;
        boolean z12;
        k kVar;
        int i8;
        int i9;
        int i10;
        boolean z13;
        boolean z14;
        k kVar2;
        m mVar;
        d dVar6;
        d dVar7;
        boolean z15;
        a aVar3 = a.WRAP_CONTENT;
        g l2 = dVar.l(this.I);
        g l3 = dVar.l(this.K);
        g l4 = dVar.l(this.J);
        g l5 = dVar.l(this.L);
        g l6 = dVar.l(this.M);
        d dVar8 = this.U;
        if (dVar8 != null) {
            boolean z16 = dVar8 != null && dVar8.T[0] == aVar3;
            boolean z17 = dVar8 != null && dVar8.T[1] == aVar3;
            int i11 = this.p;
            if (i11 == 1) {
                z3 = z16;
                z4 = false;
            } else if (i11 == 2) {
                z4 = z17;
                z3 = false;
            } else if (i11 != 3) {
                z4 = z17;
                z3 = z16;
            }
            if (this.h0 == 8) {
                int size = this.R.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size) {
                        z15 = false;
                        break;
                    } else if (this.R.get(i12).f()) {
                        z15 = true;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (!z15) {
                    boolean[] zArr = this.S;
                    if (!zArr[0] && !zArr[1]) {
                        return;
                    }
                }
            }
            z5 = this.f1313j;
            if (z5 || this.f1314k) {
                if (z5) {
                    dVar.e(l2, this.Z);
                    dVar.e(l3, this.Z + this.V);
                    if (z3 && (dVar7 = this.U) != null) {
                        e eVar = (e) dVar7;
                        eVar.U(this.I);
                        eVar.T(this.K);
                    }
                }
                if (this.f1314k) {
                    dVar.e(l4, this.a0);
                    dVar.e(l5, this.a0 + this.W);
                    if (this.M.f()) {
                        dVar.e(l6, this.a0 + this.b0);
                    }
                    if (z4 && (dVar6 = this.U) != null) {
                        e eVar2 = (e) dVar6;
                        eVar2.W(this.J);
                        eVar2.V(this.L);
                    }
                }
                if (this.f1313j && this.f1314k) {
                    this.f1313j = false;
                    this.f1314k = false;
                }
            }
            if (!(!z2 || (kVar2 = this.f1307d) == null || (mVar = this.f1308e) == null)) {
                f fVar = kVar2.f1359h;
                if (fVar.f1339j && kVar2.f1360i.f1339j && mVar.f1359h.f1339j && mVar.f1360i.f1339j) {
                    dVar.e(l2, fVar.f1336g);
                    dVar.e(l3, this.f1307d.f1360i.f1336g);
                    dVar.e(l4, this.f1308e.f1359h.f1336g);
                    dVar.e(l5, this.f1308e.f1360i.f1336g);
                    dVar.e(l6, this.f1308e.f1350k.f1336g);
                    if (this.U != null) {
                        if (z3 && this.f1309f[0] && !x()) {
                            dVar.f(dVar.l(this.U.K), l3, 0, 8);
                        }
                        if (z4 && this.f1309f[1] && !y()) {
                            dVar.f(dVar.l(this.U.L), l5, 0, 8);
                        }
                    }
                    this.f1313j = false;
                    this.f1314k = false;
                    return;
                }
            }
            if (this.U != null) {
                if (w(0)) {
                    ((e) this.U).R(this, 0);
                    z13 = true;
                } else {
                    z13 = x();
                }
                if (w(1)) {
                    ((e) this.U).R(this, 1);
                    z14 = true;
                } else {
                    z14 = y();
                }
                if (!z13 && z3 && this.h0 != 8 && this.I.f1295f == null && this.K.f1295f == null) {
                    dVar.f(dVar.l(this.U.K), l3, 0, 1);
                }
                if (!z14 && z4 && this.h0 != 8 && this.J.f1295f == null && this.L.f1295f == null && this.M == null) {
                    dVar.f(dVar.l(this.U.L), l5, 0, 1);
                }
                z6 = z13;
                z7 = z14;
            } else {
                z7 = false;
                z6 = false;
            }
            int i13 = this.V;
            int i14 = this.c0;
            if (i13 >= i14) {
                i14 = i13;
            }
            int i15 = this.W;
            int i16 = this.d0;
            if (i15 >= i16) {
                i16 = i15;
            }
            a[] aVarArr = this.T;
            a aVar4 = aVarArr[0];
            int i17 = i14;
            a aVar5 = a.MATCH_CONSTRAINT;
            boolean z18 = aVar4 != aVar5;
            boolean z19 = aVarArr[1] != aVar5;
            int i18 = this.Y;
            this.z = i18;
            float f2 = this.X;
            this.A = f2;
            int i19 = this.q;
            int i20 = this.r;
            if (f2 > 0.0f) {
                gVar = l3;
                if (this.h0 != 8) {
                    if (aVarArr[0] == aVar5 && i19 == 0) {
                        i19 = 3;
                    }
                    if (aVarArr[1] == aVar5 && i20 == 0) {
                        i20 = 3;
                    }
                    if (aVarArr[0] == aVar5 && aVarArr[1] == aVar5 && i19 == 3 && i20 == 3) {
                        if (i18 == -1) {
                            if (z18 && !z19) {
                                this.z = 0;
                            } else if (!z18 && z19) {
                                this.z = 1;
                                if (i18 == -1) {
                                    this.A = 1.0f / f2;
                                }
                            }
                        }
                        if (this.z != 0 || (this.J.g() && this.L.g())) {
                            if (this.z == 1 && (!this.I.g() || !this.K.g())) {
                                i10 = 0;
                            }
                            if (this.z == -1 && (!this.J.g() || !this.L.g() || !this.I.g() || !this.K.g())) {
                                if (!this.J.g() && this.L.g()) {
                                    i9 = 0;
                                } else if (this.I.g() && this.K.g()) {
                                    this.A = 1.0f / this.A;
                                    i9 = 1;
                                }
                                this.z = i9;
                            }
                            if (this.z == -1) {
                                int i21 = this.t;
                                if (i21 > 0 && this.w == 0) {
                                    this.z = 0;
                                } else if (i21 == 0 && this.w > 0) {
                                    this.A = 1.0f / this.A;
                                    this.z = 1;
                                }
                            }
                        } else {
                            i10 = 1;
                        }
                        this.z = i10;
                        if (!this.J.g()) {
                        }
                        this.A = 1.0f / this.A;
                        i9 = 1;
                        this.z = i9;
                        if (this.z == -1) {
                        }
                    } else if (aVarArr[0] == aVar5 && i19 == 3) {
                        this.z = 0;
                        i17 = (int) (f2 * ((float) i15));
                        if (aVarArr[1] != aVar5) {
                            i3 = i20;
                            i4 = i16;
                            c2 = 0;
                            z8 = false;
                            i2 = 4;
                            int[] iArr = this.s;
                            iArr[c2] = i2;
                            iArr[1] = i3;
                            if (!z8) {
                            }
                            z9 = false;
                            if (!z8) {
                            }
                            if (this.T[0] != aVar3) {
                            }
                            if (z10) {
                            }
                            boolean z20 = !this.P.g();
                            boolean[] zArr2 = this.S;
                            boolean z21 = zArr2[0];
                            boolean z22 = zArr2[1];
                            f fVar2 = kVar.f1359h;
                            if (z2) {
                            }
                            aVar2 = aVar5;
                            gVar5 = l2;
                            aVar = aVar3;
                            gVar4 = l6;
                            gVar3 = l5;
                            gVar2 = l4;
                            gVar6 = gVar;
                            if (z2) {
                            }
                            z11 = true;
                            if (dVar2.o != 2 ? false : z11) {
                            }
                            gVar11 = gVar8;
                            gVar10 = gVar7;
                            if (!z8) {
                            }
                            if (dVar4.P.g()) {
                            }
                            this.f1313j = false;
                            this.f1314k = false;
                            return;
                        }
                        i2 = i19;
                        i3 = i20;
                        i4 = i16;
                        c2 = 0;
                        z8 = true;
                        int[] iArr2 = this.s;
                        iArr2[c2] = i2;
                        iArr2[1] = i3;
                        if (!z8) {
                        }
                        z9 = false;
                        if (!z8) {
                        }
                        if (this.T[0] != aVar3) {
                        }
                        if (z10) {
                        }
                        boolean z202 = !this.P.g();
                        boolean[] zArr22 = this.S;
                        boolean z212 = zArr22[0];
                        boolean z222 = zArr22[1];
                        f fVar22 = kVar.f1359h;
                        if (z2) {
                        }
                        aVar2 = aVar5;
                        gVar5 = l2;
                        aVar = aVar3;
                        gVar4 = l6;
                        gVar3 = l5;
                        gVar2 = l4;
                        gVar6 = gVar;
                        if (z2) {
                        }
                        z11 = true;
                        if (dVar2.o != 2 ? false : z11) {
                        }
                        gVar11 = gVar8;
                        gVar10 = gVar7;
                        if (!z8) {
                        }
                        if (dVar4.P.g()) {
                        }
                        this.f1313j = false;
                        this.f1314k = false;
                        return;
                    } else if (aVarArr[1] == aVar5 && i20 == 3) {
                        this.z = 1;
                        if (i18 == -1) {
                            this.A = 1.0f / f2;
                        }
                        c2 = 0;
                        a aVar6 = aVarArr[0];
                        i4 = (int) (this.A * ((float) i13));
                        i2 = i19;
                        if (aVar6 != aVar5) {
                            z8 = false;
                            i3 = 4;
                            int[] iArr22 = this.s;
                            iArr22[c2] = i2;
                            iArr22[1] = i3;
                            if (!z8) {
                                int i22 = this.z;
                                i5 = -1;
                                if (i22 == 0 || i22 == -1) {
                                    z9 = true;
                                    boolean z23 = !z8 && ((i8 = this.z) == 1 || i8 == i5);
                                    z10 = this.T[0] != aVar3 && (this instanceof e);
                                    if (z10) {
                                        i17 = 0;
                                    }
                                    boolean z2022 = !this.P.g();
                                    boolean[] zArr222 = this.S;
                                    boolean z2122 = zArr222[0];
                                    boolean z2222 = zArr222[1];
                                    if (this.n != 2 && !this.f1313j) {
                                        if (z2 && (kVar = this.f1307d) != null) {
                                            f fVar222 = kVar.f1359h;
                                            if (fVar222.f1339j && kVar.f1360i.f1339j) {
                                                if (z2) {
                                                    dVar.e(l2, fVar222.f1336g);
                                                    dVar.e(gVar, this.f1307d.f1360i.f1336g);
                                                    if (this.U != null && z3 && this.f1309f[0] && !x()) {
                                                        dVar.f(dVar.l(this.U.K), gVar, 0, 8);
                                                    }
                                                    aVar2 = aVar5;
                                                    gVar5 = l2;
                                                    aVar = aVar3;
                                                    gVar4 = l6;
                                                    gVar3 = l5;
                                                    gVar2 = l4;
                                                    gVar6 = gVar;
                                                    if (z2) {
                                                        dVar2 = this;
                                                        m mVar2 = dVar2.f1308e;
                                                        if (mVar2 != null) {
                                                            f fVar3 = mVar2.f1359h;
                                                            if (fVar3.f1339j && mVar2.f1360i.f1339j) {
                                                                dVar3 = dVar;
                                                                gVar7 = gVar2;
                                                                dVar3.e(gVar7, fVar3.f1336g);
                                                                gVar8 = gVar3;
                                                                dVar3.e(gVar8, dVar2.f1308e.f1360i.f1336g);
                                                                gVar9 = gVar4;
                                                                dVar3.e(gVar9, dVar2.f1308e.f1350k.f1336g);
                                                                d dVar9 = dVar2.U;
                                                                if (dVar9 == null || z7 || !z4) {
                                                                    i7 = 8;
                                                                    i6 = 0;
                                                                    c3 = 1;
                                                                } else {
                                                                    c3 = 1;
                                                                    if (dVar2.f1309f[1]) {
                                                                        i7 = 8;
                                                                        i6 = 0;
                                                                        dVar3.f(dVar3.l(dVar9.L), gVar8, 0, 8);
                                                                    } else {
                                                                        i7 = 8;
                                                                        i6 = 0;
                                                                    }
                                                                }
                                                                z11 = false;
                                                                if ((dVar2.o != 2 ? false : z11) || dVar2.f1314k) {
                                                                    gVar11 = gVar8;
                                                                    gVar10 = gVar7;
                                                                } else {
                                                                    boolean z24 = dVar2.T[c3] == aVar && (dVar2 instanceof e);
                                                                    if (z24) {
                                                                        i4 = 0;
                                                                    }
                                                                    d dVar10 = dVar2.U;
                                                                    g l7 = dVar10 != null ? dVar3.l(dVar10.L) : null;
                                                                    d dVar11 = dVar2.U;
                                                                    g l8 = dVar11 != null ? dVar3.l(dVar11.J) : null;
                                                                    int i23 = dVar2.b0;
                                                                    if (i23 > 0 || dVar2.h0 == i7) {
                                                                        c cVar = dVar2.M;
                                                                        if (cVar.f1295f != null) {
                                                                            dVar3.d(gVar9, gVar7, i23, i7);
                                                                            dVar3.d(gVar9, dVar3.l(dVar2.M.f1295f), dVar2.M.d(), i7);
                                                                            if (z4) {
                                                                                dVar3.f(l7, dVar3.l(dVar2.L), i6, 5);
                                                                            }
                                                                            z12 = false;
                                                                            boolean z25 = dVar2.f1309f[c3];
                                                                            a[] aVarArr2 = dVar2.T;
                                                                            gVar11 = gVar8;
                                                                            gVar10 = gVar7;
                                                                            f(dVar, false, z4, z3, z25, l8, l7, aVarArr2[c3], z24, dVar2.J, dVar2.L, dVar2.a0, i4, dVar2.d0, dVar2.B[c3], dVar2.f0, z23, aVarArr2[0] != aVar2, z7, z6, z2222, i3, i2, dVar2.w, dVar2.x, dVar2.y, z12);
                                                                        } else {
                                                                            if (dVar2.h0 == i7) {
                                                                                i23 = cVar.d();
                                                                            }
                                                                            dVar3.d(gVar9, gVar7, i23, i7);
                                                                        }
                                                                    }
                                                                    z12 = z2022;
                                                                    boolean z252 = dVar2.f1309f[c3];
                                                                    a[] aVarArr22 = dVar2.T;
                                                                    gVar11 = gVar8;
                                                                    gVar10 = gVar7;
                                                                    f(dVar, false, z4, z3, z252, l8, l7, aVarArr22[c3], z24, dVar2.J, dVar2.L, dVar2.a0, i4, dVar2.d0, dVar2.B[c3], dVar2.f0, z23, aVarArr22[0] != aVar2, z7, z6, z2222, i3, i2, dVar2.w, dVar2.x, dVar2.y, z12);
                                                                }
                                                                if (!z8) {
                                                                    int i24 = 8;
                                                                    dVar4 = this;
                                                                    int i25 = dVar4.z;
                                                                    float f3 = dVar4.A;
                                                                    if (i25 == 1) {
                                                                        dVar5 = dVar;
                                                                        gVar15 = gVar11;
                                                                        gVar14 = gVar10;
                                                                        gVar13 = gVar6;
                                                                        gVar12 = gVar5;
                                                                    } else {
                                                                        i24 = 8;
                                                                        dVar5 = dVar;
                                                                        gVar15 = gVar6;
                                                                        gVar14 = gVar5;
                                                                        gVar13 = gVar11;
                                                                        gVar12 = gVar10;
                                                                    }
                                                                    dVar5.h(gVar15, gVar14, gVar13, gVar12, f3, i24);
                                                                } else {
                                                                    dVar4 = this;
                                                                }
                                                                if (dVar4.P.g()) {
                                                                    d dVar12 = dVar4.P.f1295f.f1293d;
                                                                    int d2 = dVar4.P.d();
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
                                                                    double radians = (double) ((float) Math.toRadians((double) (dVar4.C + 90.0f)));
                                                                    double d3 = (double) d2;
                                                                    m2.g(l10, l12, l14, l16, (float) (Math.sin(radians) * d3));
                                                                    dVar.c(m2);
                                                                    b m3 = dVar.m();
                                                                    m3.g(l9, l11, l13, l15, (float) (Math.cos(radians) * d3));
                                                                    dVar.c(m3);
                                                                }
                                                                this.f1313j = false;
                                                                this.f1314k = false;
                                                                return;
                                                            }
                                                        }
                                                        dVar3 = dVar;
                                                        gVar9 = gVar4;
                                                        gVar8 = gVar3;
                                                        gVar7 = gVar2;
                                                        i7 = 8;
                                                        i6 = 0;
                                                        c3 = 1;
                                                    } else {
                                                        i7 = 8;
                                                        i6 = 0;
                                                        c3 = 1;
                                                        dVar2 = this;
                                                        dVar3 = dVar;
                                                        gVar9 = gVar4;
                                                        gVar8 = gVar3;
                                                        gVar7 = gVar2;
                                                    }
                                                    z11 = true;
                                                    if (dVar2.o != 2 ? false : z11) {
                                                    }
                                                    gVar11 = gVar8;
                                                    gVar10 = gVar7;
                                                    if (!z8) {
                                                    }
                                                    if (dVar4.P.g()) {
                                                    }
                                                    this.f1313j = false;
                                                    this.f1314k = false;
                                                    return;
                                                }
                                            }
                                        }
                                        d dVar13 = this.U;
                                        g l17 = dVar13 != null ? dVar.l(dVar13.K) : null;
                                        d dVar14 = this.U;
                                        g l18 = dVar14 != null ? dVar.l(dVar14.I) : null;
                                        boolean z26 = this.f1309f[0];
                                        a[] aVarArr3 = this.T;
                                        aVar2 = aVar5;
                                        gVar4 = l6;
                                        gVar3 = l5;
                                        gVar2 = l4;
                                        gVar6 = gVar;
                                        gVar5 = l2;
                                        aVar = aVar3;
                                        f(dVar, true, z3, z4, z26, l18, l17, aVarArr3[0], z10, this.I, this.K, this.Z, i17, this.c0, this.B[0], this.e0, z9, aVarArr3[1] == aVar5, z6, z7, z2122, i2, i3, this.t, this.u, this.v, z2022);
                                        if (z2) {
                                        }
                                        z11 = true;
                                        if (dVar2.o != 2 ? false : z11) {
                                        }
                                        gVar11 = gVar8;
                                        gVar10 = gVar7;
                                        if (!z8) {
                                        }
                                        if (dVar4.P.g()) {
                                        }
                                        this.f1313j = false;
                                        this.f1314k = false;
                                        return;
                                    }
                                    aVar2 = aVar5;
                                    gVar5 = l2;
                                    aVar = aVar3;
                                    gVar4 = l6;
                                    gVar3 = l5;
                                    gVar2 = l4;
                                    gVar6 = gVar;
                                    if (z2) {
                                    }
                                    z11 = true;
                                    if (dVar2.o != 2 ? false : z11) {
                                    }
                                    gVar11 = gVar8;
                                    gVar10 = gVar7;
                                    if (!z8) {
                                    }
                                    if (dVar4.P.g()) {
                                    }
                                    this.f1313j = false;
                                    this.f1314k = false;
                                    return;
                                }
                            } else {
                                i5 = -1;
                            }
                            z9 = false;
                            if (!z8) {
                            }
                            if (this.T[0] != aVar3) {
                            }
                            if (z10) {
                            }
                            boolean z20222 = !this.P.g();
                            boolean[] zArr2222 = this.S;
                            boolean z21222 = zArr2222[0];
                            boolean z22222 = zArr2222[1];
                            f fVar2222 = kVar.f1359h;
                            if (z2) {
                            }
                            aVar2 = aVar5;
                            gVar5 = l2;
                            aVar = aVar3;
                            gVar4 = l6;
                            gVar3 = l5;
                            gVar2 = l4;
                            gVar6 = gVar;
                            if (z2) {
                            }
                            z11 = true;
                            if (dVar2.o != 2 ? false : z11) {
                            }
                            gVar11 = gVar8;
                            gVar10 = gVar7;
                            if (!z8) {
                            }
                            if (dVar4.P.g()) {
                            }
                            this.f1313j = false;
                            this.f1314k = false;
                            return;
                        }
                        i3 = i20;
                        z8 = true;
                        int[] iArr222 = this.s;
                        iArr222[c2] = i2;
                        iArr222[1] = i3;
                        if (!z8) {
                        }
                        z9 = false;
                        if (!z8) {
                        }
                        if (this.T[0] != aVar3) {
                        }
                        if (z10) {
                        }
                        boolean z202222 = !this.P.g();
                        boolean[] zArr22222 = this.S;
                        boolean z212222 = zArr22222[0];
                        boolean z222222 = zArr22222[1];
                        f fVar22222 = kVar.f1359h;
                        if (z2) {
                        }
                        aVar2 = aVar5;
                        gVar5 = l2;
                        aVar = aVar3;
                        gVar4 = l6;
                        gVar3 = l5;
                        gVar2 = l4;
                        gVar6 = gVar;
                        if (z2) {
                        }
                        z11 = true;
                        if (dVar2.o != 2 ? false : z11) {
                        }
                        gVar11 = gVar8;
                        gVar10 = gVar7;
                        if (!z8) {
                        }
                        if (dVar4.P.g()) {
                        }
                        this.f1313j = false;
                        this.f1314k = false;
                        return;
                    }
                    c2 = 0;
                    i2 = i19;
                    i3 = i20;
                    i4 = i16;
                    z8 = true;
                    int[] iArr2222 = this.s;
                    iArr2222[c2] = i2;
                    iArr2222[1] = i3;
                    if (!z8) {
                    }
                    z9 = false;
                    if (!z8) {
                    }
                    if (this.T[0] != aVar3) {
                    }
                    if (z10) {
                    }
                    boolean z2022222 = !this.P.g();
                    boolean[] zArr222222 = this.S;
                    boolean z2122222 = zArr222222[0];
                    boolean z2222222 = zArr222222[1];
                    f fVar222222 = kVar.f1359h;
                    if (z2) {
                    }
                    aVar2 = aVar5;
                    gVar5 = l2;
                    aVar = aVar3;
                    gVar4 = l6;
                    gVar3 = l5;
                    gVar2 = l4;
                    gVar6 = gVar;
                    if (z2) {
                    }
                    z11 = true;
                    if (dVar2.o != 2 ? false : z11) {
                    }
                    gVar11 = gVar8;
                    gVar10 = gVar7;
                    if (!z8) {
                    }
                    if (dVar4.P.g()) {
                    }
                    this.f1313j = false;
                    this.f1314k = false;
                    return;
                }
            } else {
                gVar = l3;
            }
            c2 = 0;
            i2 = i19;
            i3 = i20;
            i4 = i16;
            z8 = false;
            int[] iArr22222 = this.s;
            iArr22222[c2] = i2;
            iArr22222[1] = i3;
            if (!z8) {
            }
            z9 = false;
            if (!z8) {
            }
            if (this.T[0] != aVar3) {
            }
            if (z10) {
            }
            boolean z20222222 = !this.P.g();
            boolean[] zArr2222222 = this.S;
            boolean z21222222 = zArr2222222[0];
            boolean z22222222 = zArr2222222[1];
            f fVar2222222 = kVar.f1359h;
            if (z2) {
            }
            aVar2 = aVar5;
            gVar5 = l2;
            aVar = aVar3;
            gVar4 = l6;
            gVar3 = l5;
            gVar2 = l4;
            gVar6 = gVar;
            if (z2) {
            }
            z11 = true;
            if (dVar2.o != 2 ? false : z11) {
            }
            gVar11 = gVar8;
            gVar10 = gVar7;
            if (!z8) {
            }
            if (dVar4.P.g()) {
            }
            this.f1313j = false;
            this.f1314k = false;
            return;
        }
        z4 = false;
        z3 = false;
        if (this.h0 == 8) {
        }
        z5 = this.f1313j;
        if (z5) {
        }
        if (this.f1314k) {
        }
        this.f1313j = false;
        this.f1314k = false;
    }

    public boolean e() {
        return this.h0 != 8;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0366 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0373  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x03e7  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x040f  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0415 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x042b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0474  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0484 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x04aa A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x04be  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x04cf A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:342:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:346:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ce  */
    public final void f(e.g.a.d dVar, boolean z2, boolean z3, boolean z4, boolean z5, g gVar, g gVar2, a aVar, boolean z6, c cVar, c cVar2, int i2, int i3, int i4, int i5, float f2, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i6, int i7, int i8, int i9, float f3, boolean z12) {
        int i10;
        boolean z13;
        int i11;
        boolean z14;
        int i12;
        boolean z15;
        int i13;
        boolean z16;
        int i14;
        int i15;
        boolean z17;
        boolean z18;
        char c2;
        int i16;
        g gVar3;
        int i17;
        g gVar4;
        int i18;
        g gVar5;
        g gVar6;
        int i19;
        c cVar3;
        a[] aVarArr;
        a aVar2;
        boolean z19;
        boolean z20;
        g gVar7;
        int i20;
        g gVar8;
        int i21;
        g gVar9;
        int i22;
        boolean z21;
        boolean z22;
        boolean z23;
        int i23;
        int i24;
        int i25;
        g gVar10;
        boolean z24;
        int i26;
        g gVar11;
        g gVar12;
        g gVar13;
        g gVar14;
        g gVar15;
        d dVar2;
        int i27;
        d dVar3;
        boolean z25;
        g gVar16;
        int i28;
        int i29;
        int i30;
        int i31;
        boolean z26;
        boolean z27;
        g gVar17;
        int i32;
        boolean z28;
        boolean z29;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        boolean z30;
        int i41;
        int i42;
        int i43;
        g gVar18;
        g gVar19;
        int i44 = i8;
        int i45 = i9;
        c.a aVar3 = c.a.BOTTOM;
        g l2 = dVar.l(cVar);
        g l3 = dVar.l(cVar2);
        g l4 = dVar.l(cVar.f1295f);
        g l5 = dVar.l(cVar2.f1295f);
        boolean g2 = cVar.g();
        boolean g3 = cVar2.g();
        boolean g4 = this.P.g();
        if (g3) {
            i10 = (g2 ? 1 : 0) + 1;
        } else {
            i10 = g2 ? 1 : 0;
        }
        if (g4) {
            i10++;
        }
        int i46 = z7 ? 3 : i6;
        int ordinal = aVar.ordinal();
        if (ordinal != 0 && ordinal != 1 && ordinal == 2) {
            if (i46 != 4) {
                z13 = true;
                i11 = this.f1311h;
                z14 = z13;
                if (i11 != -1 && z2) {
                    this.f1311h = -1;
                    i3 = i11;
                    z14 = false;
                }
                i12 = this.f1312i;
                if (i12 != -1 || z2) {
                    i12 = i3;
                } else {
                    this.f1312i = -1;
                    z14 = false;
                }
                if (this.h0 != 8) {
                    i13 = 0;
                    z15 = false;
                } else {
                    i13 = i12;
                    z15 = z14;
                }
                if (z12) {
                    if (!g2 && !g3 && !g4) {
                        dVar.e(l2, i2);
                    } else if (g2 && !g3) {
                        z16 = g4;
                        i14 = 8;
                        dVar.d(l2, l4, cVar.d(), 8);
                        if (!z15) {
                            if (z6) {
                                dVar.d(l3, l2, 0, 3);
                                if (i4 > 0) {
                                    dVar.f(l3, l2, i4, i14);
                                }
                                if (i5 < Integer.MAX_VALUE) {
                                    dVar.g(l3, l2, i5, i14);
                                }
                            } else {
                                dVar.d(l3, l2, i13, i14);
                            }
                        } else if (i10 == 2 || z7 || !(i46 == 1 || i46 == 0)) {
                            if (i44 == -2) {
                                i44 = i13;
                            }
                            if (i45 == -2) {
                                i45 = i13;
                            }
                            if (i13 > 0 && i46 != 1) {
                                i13 = 0;
                            }
                            if (i44 > 0) {
                                dVar.f(l3, l2, i44, 8);
                                i13 = Math.max(i13, i44);
                            }
                            if (i45 > 0) {
                                if (!z3 || i46 != 1) {
                                    i43 = 8;
                                    dVar.g(l3, l2, i45, 8);
                                } else {
                                    i43 = 8;
                                }
                                i13 = Math.min(i13, i45);
                            } else {
                                i43 = 8;
                            }
                            if (i46 == 1) {
                                if (z3) {
                                    dVar.d(l3, l2, i13, i43);
                                } else {
                                    dVar.d(l3, l2, i13, 5);
                                    dVar.g(l3, l2, i13, i43);
                                }
                            } else if (i46 == 2) {
                                c.a aVar4 = cVar.f1294e;
                                c.a aVar5 = c.a.TOP;
                                if (aVar4 == aVar5 || aVar4 == aVar3) {
                                    g l6 = dVar.l(this.U.i(aVar5));
                                    gVar19 = dVar.l(this.U.i(aVar3));
                                    gVar18 = l6;
                                } else {
                                    gVar18 = dVar.l(this.U.i(c.a.LEFT));
                                    gVar19 = dVar.l(this.U.i(c.a.RIGHT));
                                }
                                b m2 = dVar.m();
                                m2.d(l3, l2, gVar19, gVar18, f3);
                                dVar.c(m2);
                                if (z3) {
                                    z15 = false;
                                }
                            } else {
                                i15 = i44;
                                z17 = true;
                                if (!z12) {
                                    gVar5 = gVar2;
                                    i18 = i10;
                                    gVar3 = l3;
                                    gVar4 = l2;
                                    z18 = z17;
                                    i19 = 0;
                                    i16 = 8;
                                    c2 = 1;
                                    gVar6 = gVar;
                                    i17 = 2;
                                } else if (z9) {
                                    gVar5 = gVar2;
                                    i18 = i10;
                                    gVar3 = l3;
                                    gVar4 = l2;
                                    z18 = z17;
                                    i19 = 0;
                                    i17 = 2;
                                    i16 = 8;
                                    c2 = 1;
                                    gVar6 = gVar;
                                } else {
                                    if (!g2 && !g3 && !z16) {
                                        gVar7 = l3;
                                        z19 = z17;
                                        gVar8 = l5;
                                    } else if (!g2 || g3) {
                                        if (g2 || !g3) {
                                            gVar9 = l5;
                                            if (g2 && g3) {
                                                d dVar4 = cVar.f1295f.f1293d;
                                                d dVar5 = cVar2.f1295f.f1293d;
                                                d dVar6 = this.U;
                                                if (z15) {
                                                    if (i46 == 0) {
                                                        if (i45 != 0 || i15 != 0) {
                                                            i42 = 5;
                                                            i41 = 5;
                                                            z29 = false;
                                                            z28 = true;
                                                            z23 = true;
                                                        } else if (!l4.f1274g || !gVar9.f1274g) {
                                                            i42 = 8;
                                                            i41 = 8;
                                                            z29 = true;
                                                            z28 = false;
                                                            z23 = false;
                                                        } else {
                                                            dVar.d(l2, l4, cVar.d(), 8);
                                                            dVar.d(l3, gVar9, -cVar2.d(), 8);
                                                            return;
                                                        }
                                                        if ((dVar4 instanceof a) || (dVar5 instanceof a)) {
                                                            i22 = i41;
                                                            z21 = z29;
                                                            z22 = z28;
                                                            i24 = 4;
                                                            i23 = 6;
                                                            i25 = i46;
                                                        } else {
                                                            i34 = i42;
                                                            i25 = i46;
                                                            i33 = i41;
                                                            i22 = i33;
                                                            z21 = z29;
                                                            z22 = z28;
                                                            i23 = 6;
                                                            gVar10 = gVar2;
                                                            i24 = i34;
                                                            if (z23 || l4 != gVar9 || dVar4 == dVar6) {
                                                                z24 = true;
                                                            } else {
                                                                z23 = false;
                                                                z24 = false;
                                                            }
                                                            if (!z22) {
                                                                if (z15 || z8 || z10 || l4 != gVar || gVar9 != gVar10) {
                                                                    i31 = i23;
                                                                    z20 = z3;
                                                                } else {
                                                                    z20 = false;
                                                                    i31 = 8;
                                                                    i22 = 8;
                                                                    z24 = false;
                                                                }
                                                                dVar2 = dVar4;
                                                                gVar15 = gVar;
                                                                z19 = z17;
                                                                dVar3 = dVar5;
                                                                gVar11 = gVar9;
                                                                i26 = i15;
                                                                i27 = 8;
                                                                gVar14 = l4;
                                                                gVar13 = l3;
                                                                gVar12 = l2;
                                                                dVar.b(l2, l4, cVar.d(), f2, gVar9, l3, cVar2.d(), i31);
                                                            } else {
                                                                dVar2 = dVar4;
                                                                gVar15 = gVar;
                                                                gVar11 = gVar9;
                                                                gVar14 = l4;
                                                                gVar13 = l3;
                                                                gVar12 = l2;
                                                                z19 = z17;
                                                                i26 = i15;
                                                                i27 = 8;
                                                                dVar3 = dVar5;
                                                                z20 = z3;
                                                            }
                                                            z25 = z24;
                                                            if (this.h0 == i27 || cVar2.f()) {
                                                                gVar8 = gVar11;
                                                                if (!z23) {
                                                                    int i47 = (!z20 || gVar14 == gVar8 || z15 || (!(dVar2 instanceof a) && !(dVar3 instanceof a))) ? i22 : 6;
                                                                    gVar16 = gVar12;
                                                                    dVar.f(gVar16, gVar14, cVar.d(), i47);
                                                                    gVar7 = gVar13;
                                                                    dVar.g(gVar7, gVar8, -cVar2.d(), i47);
                                                                    i22 = i47;
                                                                } else {
                                                                    gVar7 = gVar13;
                                                                    gVar16 = gVar12;
                                                                }
                                                                if (z20 || !z11 || (dVar2 instanceof a) || (dVar3 instanceof a) || dVar3 == dVar6) {
                                                                    i29 = i24;
                                                                    i28 = i22;
                                                                } else {
                                                                    i29 = 6;
                                                                    i28 = 6;
                                                                    z25 = true;
                                                                }
                                                                if (z25) {
                                                                    if (z21 && (!z10 || z4)) {
                                                                        int i48 = (dVar2 == dVar6 || dVar3 == dVar6) ? 6 : i29;
                                                                        if ((dVar2 instanceof f) || (dVar3 instanceof f)) {
                                                                            i48 = 5;
                                                                        }
                                                                        if ((dVar2 instanceof a) || (dVar3 instanceof a)) {
                                                                            i48 = 5;
                                                                        }
                                                                        if (z10) {
                                                                            i48 = 5;
                                                                        }
                                                                        i29 = Math.max(i48, i29);
                                                                    }
                                                                    if (z20) {
                                                                        i29 = Math.min(i28, i29);
                                                                        if (z7 && !z10 && (dVar2 == dVar6 || dVar3 == dVar6)) {
                                                                            i30 = 4;
                                                                            dVar.d(gVar16, gVar14, cVar.d(), i30);
                                                                            dVar.d(gVar7, gVar8, -cVar2.d(), i30);
                                                                        }
                                                                    }
                                                                    i30 = i29;
                                                                    dVar.d(gVar16, gVar14, cVar.d(), i30);
                                                                    dVar.d(gVar7, gVar8, -cVar2.d(), i30);
                                                                }
                                                                if (z20) {
                                                                    int d2 = gVar15 == gVar14 ? cVar.d() : 0;
                                                                    if (gVar14 != gVar15) {
                                                                        dVar.f(gVar16, gVar15, d2, 5);
                                                                    }
                                                                }
                                                                if (z20 || !z15 || i4 != 0 || i26 != 0) {
                                                                    i21 = 0;
                                                                } else if (!z15 || i25 != 3) {
                                                                    i21 = 0;
                                                                    dVar.f(gVar7, gVar16, 0, 5);
                                                                    i20 = 5;
                                                                    if (!z20 && z19) {
                                                                        if (cVar2.f1295f != null) {
                                                                            i21 = cVar2.d();
                                                                        }
                                                                        if (gVar8 != gVar2) {
                                                                            dVar.f(gVar2, gVar7, i21, i20);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                } else {
                                                                    i21 = 0;
                                                                    dVar.f(gVar7, gVar16, 0, i27);
                                                                }
                                                                i20 = 5;
                                                                if (!z20) {
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                    } else {
                                                        if (i46 == 2) {
                                                            i35 = ((dVar4 instanceof a) || (dVar5 instanceof a)) ? 4 : 5;
                                                            i36 = 5;
                                                        } else if (i46 == 1) {
                                                            i36 = 8;
                                                            i35 = 4;
                                                        } else if (i46 == 3) {
                                                            i25 = i46;
                                                            if (this.z == -1) {
                                                                i39 = z10 ? z3 ? 5 : 4 : 8;
                                                                i38 = 5;
                                                                i37 = 8;
                                                            } else if (z7) {
                                                                if (i7 != 2) {
                                                                    if (i7 != 1) {
                                                                        z30 = false;
                                                                        if (z30) {
                                                                            i34 = 5;
                                                                            i33 = 8;
                                                                        } else {
                                                                            i34 = 4;
                                                                            i33 = 5;
                                                                        }
                                                                        z29 = true;
                                                                        z28 = true;
                                                                        z23 = true;
                                                                        i22 = i33;
                                                                        z21 = z29;
                                                                        z22 = z28;
                                                                        i23 = 6;
                                                                        gVar10 = gVar2;
                                                                        i24 = i34;
                                                                        if (z23) {
                                                                        }
                                                                        z24 = true;
                                                                        if (!z22) {
                                                                        }
                                                                        z25 = z24;
                                                                        if (this.h0 == i27) {
                                                                        }
                                                                        gVar8 = gVar11;
                                                                        if (!z23) {
                                                                        }
                                                                        if (z20) {
                                                                        }
                                                                        i29 = i24;
                                                                        i28 = i22;
                                                                        if (z25) {
                                                                        }
                                                                        if (z20) {
                                                                        }
                                                                        if (z20) {
                                                                        }
                                                                        i21 = 0;
                                                                        i20 = 5;
                                                                        if (!z20) {
                                                                        }
                                                                    }
                                                                }
                                                                z30 = true;
                                                                if (z30) {
                                                                }
                                                                z29 = true;
                                                                z28 = true;
                                                                z23 = true;
                                                                i22 = i33;
                                                                z21 = z29;
                                                                z22 = z28;
                                                                i23 = 6;
                                                                gVar10 = gVar2;
                                                                i24 = i34;
                                                                if (z23) {
                                                                }
                                                                z24 = true;
                                                                if (!z22) {
                                                                }
                                                                z25 = z24;
                                                                if (this.h0 == i27) {
                                                                }
                                                                gVar8 = gVar11;
                                                                if (!z23) {
                                                                }
                                                                if (z20) {
                                                                }
                                                                i29 = i24;
                                                                i28 = i22;
                                                                if (z25) {
                                                                }
                                                                if (z20) {
                                                                }
                                                                if (z20) {
                                                                }
                                                                i21 = 0;
                                                                i20 = 5;
                                                                if (!z20) {
                                                                }
                                                            } else {
                                                                if (i45 > 0) {
                                                                    i40 = 5;
                                                                } else if (i45 != 0 || i15 != 0) {
                                                                    i40 = 4;
                                                                } else if (!z10) {
                                                                    i40 = 8;
                                                                } else {
                                                                    i37 = (dVar4 == dVar6 || dVar5 == dVar6) ? 5 : 4;
                                                                    i39 = 6;
                                                                    i38 = 4;
                                                                }
                                                                i38 = i40;
                                                                i39 = 6;
                                                                i37 = 5;
                                                            }
                                                            i23 = i39;
                                                            i22 = i37;
                                                            z23 = true;
                                                            z22 = true;
                                                            z21 = true;
                                                            i24 = i38;
                                                        } else {
                                                            i25 = i46;
                                                            gVar10 = gVar2;
                                                            z27 = false;
                                                            z26 = false;
                                                        }
                                                        i25 = i46;
                                                        z29 = false;
                                                        z28 = true;
                                                        z23 = true;
                                                        i33 = i36;
                                                        i34 = i35;
                                                        i22 = i33;
                                                        z21 = z29;
                                                        z22 = z28;
                                                        i23 = 6;
                                                        gVar10 = gVar2;
                                                        i24 = i34;
                                                        if (z23) {
                                                        }
                                                        z24 = true;
                                                        if (!z22) {
                                                        }
                                                        z25 = z24;
                                                        if (this.h0 == i27) {
                                                        }
                                                        gVar8 = gVar11;
                                                        if (!z23) {
                                                        }
                                                        if (z20) {
                                                        }
                                                        i29 = i24;
                                                        i28 = i22;
                                                        if (z25) {
                                                        }
                                                        if (z20) {
                                                        }
                                                        if (z20) {
                                                        }
                                                        i21 = 0;
                                                        i20 = 5;
                                                        if (!z20) {
                                                        }
                                                    }
                                                    gVar10 = gVar2;
                                                    if (z23) {
                                                    }
                                                    z24 = true;
                                                    if (!z22) {
                                                    }
                                                    z25 = z24;
                                                    if (this.h0 == i27) {
                                                    }
                                                    gVar8 = gVar11;
                                                    if (!z23) {
                                                    }
                                                    if (z20) {
                                                    }
                                                    i29 = i24;
                                                    i28 = i22;
                                                    if (z25) {
                                                    }
                                                    if (z20) {
                                                    }
                                                    if (z20) {
                                                    }
                                                    i21 = 0;
                                                    i20 = 5;
                                                    if (!z20) {
                                                    }
                                                } else {
                                                    i25 = i46;
                                                    if (!l4.f1274g || !gVar9.f1274g) {
                                                        gVar10 = gVar2;
                                                        z27 = true;
                                                        z26 = true;
                                                    } else {
                                                        dVar.b(l2, l4, cVar.d(), f2, gVar9, l3, cVar2.d(), 8);
                                                        if (z3 && z17) {
                                                            if (cVar2.f1295f != null) {
                                                                i32 = cVar2.d();
                                                                gVar17 = gVar2;
                                                            } else {
                                                                gVar17 = gVar2;
                                                                i32 = 0;
                                                            }
                                                            if (gVar9 != gVar17) {
                                                                dVar.f(gVar17, l3, i32, 5);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                }
                                                z22 = z27;
                                                z23 = z26;
                                                i24 = 4;
                                                i23 = 6;
                                                z21 = false;
                                                i22 = 5;
                                                if (z23) {
                                                }
                                                z24 = true;
                                                if (!z22) {
                                                }
                                                z25 = z24;
                                                if (this.h0 == i27) {
                                                }
                                                gVar8 = gVar11;
                                                if (!z23) {
                                                }
                                                if (z20) {
                                                }
                                                i29 = i24;
                                                i28 = i22;
                                                if (z25) {
                                                }
                                                if (z20) {
                                                }
                                                if (z20) {
                                                }
                                                i21 = 0;
                                                i20 = 5;
                                                if (!z20) {
                                                }
                                            }
                                        } else {
                                            gVar9 = l5;
                                            dVar.d(l3, gVar9, -cVar2.d(), 8);
                                            if (z3) {
                                                dVar.f(l2, gVar, 0, 5);
                                            }
                                        }
                                        gVar8 = gVar9;
                                        gVar7 = l3;
                                        z19 = z17;
                                    } else {
                                        i20 = (!z3 || !(cVar.f1295f.f1293d instanceof a)) ? 5 : 8;
                                        z20 = z3;
                                        gVar7 = l3;
                                        z19 = z17;
                                        gVar8 = l5;
                                        i21 = 0;
                                        if (!z20) {
                                        }
                                    }
                                    i21 = 0;
                                    z20 = z3;
                                    i20 = 5;
                                    if (!z20) {
                                    }
                                }
                                if (i18 >= i17 && z3 && z18) {
                                    dVar.f(gVar4, gVar6, i19, i16);
                                    boolean z31 = z2 || this.M.f1295f == null;
                                    if (!z2 && (cVar3 = this.M.f1295f) != null) {
                                        d dVar7 = cVar3.f1293d;
                                        z31 = dVar7.X != 0.0f && (aVarArr = dVar7.T)[i19] == (aVar2 = a.MATCH_CONSTRAINT) && aVarArr[c2] == aVar2;
                                    }
                                    if (z31) {
                                        dVar.f(gVar5, gVar3, i19, i16);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        } else {
                            int max = Math.max(i44, i13);
                            if (i45 > 0) {
                                max = Math.min(i45, max);
                            }
                            dVar.d(l3, l2, max, 8);
                            z17 = z5;
                            i15 = i44;
                            z15 = false;
                            if (!z12) {
                            }
                            if (i18 >= i17) {
                                return;
                            }
                            return;
                        }
                        z17 = z5;
                        i15 = i44;
                        if (!z12) {
                        }
                        if (i18 >= i17) {
                        }
                    }
                }
                z16 = g4;
                i14 = 8;
                if (!z15) {
                }
                z17 = z5;
                i15 = i44;
                if (!z12) {
                }
                if (i18 >= i17) {
                }
            }
        }
        z13 = false;
        i11 = this.f1311h;
        z14 = z13;
        this.f1311h = -1;
        i3 = i11;
        z14 = false;
        i12 = this.f1312i;
        if (i12 != -1) {
        }
        i12 = i3;
        if (this.h0 != 8) {
        }
        if (z12) {
        }
        z16 = g4;
        i14 = 8;
        if (!z15) {
        }
        z17 = z5;
        i15 = i44;
        if (!z12) {
        }
        if (i18 >= i17) {
        }
    }

    public void g(e.g.a.d dVar) {
        dVar.l(this.I);
        dVar.l(this.J);
        dVar.l(this.K);
        dVar.l(this.L);
        if (this.b0 > 0) {
            dVar.l(this.M);
        }
    }

    public void h() {
        if (this.f1307d == null) {
            this.f1307d = new k(this);
        }
        if (this.f1308e == null) {
            this.f1308e = new m(this);
        }
    }

    public c i(c.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.I;
            case 2:
                return this.J;
            case 3:
                return this.K;
            case 4:
                return this.L;
            case 5:
                return this.M;
            case 6:
                return this.P;
            case 7:
                return this.N;
            case 8:
                return this.O;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public int j() {
        return t() + this.W;
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
        if (this.h0 == 8) {
            return 0;
        }
        return this.W;
    }

    public a m() {
        return this.T[0];
    }

    public d n(int i2) {
        c cVar;
        c cVar2;
        if (i2 == 0) {
            c cVar3 = this.K;
            c cVar4 = cVar3.f1295f;
            if (cVar4 == null || cVar4.f1295f != cVar3) {
                return null;
            }
            return cVar4.f1293d;
        } else if (i2 == 1 && (cVar2 = (cVar = this.L).f1295f) != null && cVar2.f1295f == cVar) {
            return cVar2.f1293d;
        } else {
            return null;
        }
    }

    public d o(int i2) {
        c cVar;
        c cVar2;
        if (i2 == 0) {
            c cVar3 = this.I;
            c cVar4 = cVar3.f1295f;
            if (cVar4 == null || cVar4.f1295f != cVar3) {
                return null;
            }
            return cVar4.f1293d;
        } else if (i2 == 1 && (cVar2 = (cVar = this.J).f1295f) != null && cVar2.f1295f == cVar) {
            return cVar2.f1293d;
        } else {
            return null;
        }
    }

    public int p() {
        return s() + this.V;
    }

    public a q() {
        return this.T[1];
    }

    public int r() {
        if (this.h0 == 8) {
            return 0;
        }
        return this.V;
    }

    public int s() {
        d dVar = this.U;
        return (dVar == null || !(dVar instanceof e)) ? this.Z : ((e) dVar).x0 + this.Z;
    }

    public int t() {
        d dVar = this.U;
        return (dVar == null || !(dVar instanceof e)) ? this.a0 : ((e) dVar).y0 + this.a0;
    }

    public String toString() {
        String str = "";
        StringBuilder h2 = f.a.a.a.a.h(str);
        if (this.i0 != null) {
            str = f.a.a.a.a.e(f.a.a.a.a.h("id: "), this.i0, " ");
        }
        h2.append(str);
        h2.append("(");
        h2.append(this.Z);
        h2.append(", ");
        h2.append(this.a0);
        h2.append(") - (");
        h2.append(this.V);
        h2.append(" x ");
        h2.append(this.W);
        h2.append(")");
        return h2.toString();
    }

    public boolean u(int i2) {
        if (i2 == 0) {
            return (this.I.f1295f != null ? 1 : 0) + (this.K.f1295f != null ? 1 : 0) < 2;
        }
        return ((this.J.f1295f != null ? 1 : 0) + (this.L.f1295f != null ? 1 : 0)) + (this.M.f1295f != null ? 1 : 0) < 2;
    }

    public boolean v(int i2, int i3) {
        c cVar;
        c cVar2;
        if (i2 == 0) {
            c cVar3 = this.I.f1295f;
            if (cVar3 != null && cVar3.c && (cVar2 = this.K.f1295f) != null && cVar2.c) {
                if ((cVar2.c() - this.K.d()) - (this.I.d() + this.I.f1295f.c()) >= i3) {
                    return true;
                }
                return false;
            }
        } else {
            c cVar4 = this.J.f1295f;
            if (cVar4 != null && cVar4.c && (cVar = this.L.f1295f) != null && cVar.c) {
                if ((cVar.c() - this.L.d()) - (this.J.d() + this.J.f1295f.c()) >= i3) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final boolean w(int i2) {
        int i3 = i2 * 2;
        c[] cVarArr = this.Q;
        if (!(cVarArr[i3].f1295f == null || cVarArr[i3].f1295f.f1295f == cVarArr[i3])) {
            int i4 = i3 + 1;
            return cVarArr[i4].f1295f != null && cVarArr[i4].f1295f.f1295f == cVarArr[i4];
        }
    }

    public boolean x() {
        c cVar = this.I;
        c cVar2 = cVar.f1295f;
        if (cVar2 != null && cVar2.f1295f == cVar) {
            return true;
        }
        c cVar3 = this.K;
        c cVar4 = cVar3.f1295f;
        return cVar4 != null && cVar4.f1295f == cVar3;
    }

    public boolean y() {
        c cVar = this.J;
        c cVar2 = cVar.f1295f;
        if (cVar2 != null && cVar2.f1295f == cVar) {
            return true;
        }
        c cVar3 = this.L;
        c cVar4 = cVar3.f1295f;
        return cVar4 != null && cVar4.f1295f == cVar3;
    }

    public boolean z() {
        return this.f1310g && this.h0 != 8;
    }
}
