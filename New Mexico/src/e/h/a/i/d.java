package e.h.a.i;

import e.h.a.b;
import e.h.a.g;
import e.h.a.i.c;
import e.h.a.i.l.c;
import e.h.a.i.l.f;
import e.h.a.i.l.k;
import e.h.a.i.l.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    public boolean E;
    public c I;
    public c J;
    public c K;
    public c L;
    public c M;
    public c P;
    public c[] Q;
    public ArrayList<c> R;
    public a[] T;
    public c b;
    public c c;
    public int c0;
    public int d0;
    public Object g0;
    public boolean a = false;

    /* renamed from: d */
    public k f1391d = null;

    /* renamed from: e */
    public m f1392e = null;

    /* renamed from: f */
    public boolean[] f1393f = {true, true};

    /* renamed from: g */
    public boolean f1394g = true;

    /* renamed from: h */
    public int f1395h = -1;

    /* renamed from: i */
    public int f1396i = -1;

    /* renamed from: j */
    public boolean f1397j = false;

    /* renamed from: k */
    public boolean f1398k = false;

    /* renamed from: l */
    public boolean f1399l = false;
    public boolean m = false;
    public int n = -1;
    public int o = -1;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public int[] s = new int[2];
    public int t = 0;
    public int u = 0;
    public float v = 1.0f;
    public int w = 0;
    public int x = 0;
    public float y = 1.0f;
    public int z = -1;
    public float A = 1.0f;
    public int[] B = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float C = 0.0f;
    public boolean D = false;
    public boolean F = false;
    public int G = 0;
    public int H = 0;
    public c N = new c(this, c.a.CENTER_X);
    public c O = new c(this, c.a.CENTER_Y);
    public boolean[] S = new boolean[2];
    public d U = null;
    public int V = 0;
    public int W = 0;
    public float X = 0.0f;
    public int Y = -1;
    public int Z = 0;
    public int a0 = 0;
    public int b0 = 0;
    public float e0 = 0.5f;
    public float f0 = 0.5f;
    public int h0 = 0;
    public String i0 = null;
    public int j0 = 0;
    public int k0 = 0;
    public float[] l0 = {-1.0f, -1.0f};
    public d[] m0 = {null, null};
    public d[] n0 = {null, null};
    public int o0 = -1;
    public int p0 = -1;

    /* loaded from: classes.dex */
    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public d() {
        new HashMap();
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
        c cVar6 = new c(this, c.a.CENTER);
        this.P = cVar6;
        this.Q = new c[]{cVar, cVar3, cVar2, cVar4, cVar5, cVar6};
        ArrayList<c> arrayList = new ArrayList<>();
        this.R = arrayList;
        a aVar = a.FIXED;
        this.T = new a[]{aVar, aVar};
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
        return this.f1397j || (this.I.c && this.K.c);
    }

    public boolean B() {
        return this.f1398k || (this.J.c && this.L.c);
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
        boolean[] zArr = this.f1393f;
        zArr[0] = true;
        zArr[1] = true;
        this.F = false;
        boolean[] zArr2 = this.S;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f1394g = true;
        int[] iArr2 = this.s;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f1395h = -1;
        this.f1396i = -1;
    }

    public void D() {
        this.f1397j = false;
        this.f1398k = false;
        this.f1399l = false;
        this.m = false;
        int size = this.R.size();
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = this.R.get(i2);
            cVar.c = false;
            cVar.b = 0;
        }
    }

    public void E(e.h.a.c cVar) {
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
        if (!this.f1397j) {
            c cVar = this.I;
            cVar.b = i2;
            cVar.c = true;
            c cVar2 = this.K;
            cVar2.b = i3;
            cVar2.c = true;
            this.Z = i2;
            this.V = i3 - i2;
            this.f1397j = true;
        }
    }

    public void H(int i2, int i3) {
        if (!this.f1398k) {
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
            this.f1398k = true;
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

    public void O(boolean z, boolean z2) {
        int i2;
        int i3;
        a aVar = a.FIXED;
        k kVar = this.f1391d;
        boolean z3 = z & kVar.f1442g;
        m mVar = this.f1392e;
        boolean z4 = z2 & mVar.f1442g;
        int i4 = kVar.f1443h.f1420g;
        int i5 = mVar.f1443h.f1420g;
        int i6 = kVar.f1444i.f1420g;
        int i7 = mVar.f1444i.f1420g;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i7 = 0;
            i4 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (z3) {
            this.Z = i4;
        }
        if (z4) {
            this.a0 = i5;
        }
        if (this.h0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        if (z3) {
            if (this.T[0] == aVar && i9 < (i3 = this.V)) {
                i9 = i3;
            }
            this.V = i9;
            int i11 = this.c0;
            if (i9 < i11) {
                this.V = i11;
            }
        }
        if (z4) {
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

    public void P(e.h.a.d dVar, boolean z) {
        int i2;
        int i3;
        m mVar;
        k kVar;
        int o = dVar.o(this.I);
        int o2 = dVar.o(this.J);
        int o3 = dVar.o(this.K);
        int o4 = dVar.o(this.L);
        if (z && (kVar = this.f1391d) != null) {
            f fVar = kVar.f1443h;
            if (fVar.f1423j) {
                f fVar2 = kVar.f1444i;
                if (fVar2.f1423j) {
                    o = fVar.f1420g;
                    o3 = fVar2.f1420g;
                }
            }
        }
        if (z && (mVar = this.f1392e) != null) {
            f fVar3 = mVar.f1443h;
            if (fVar3.f1423j) {
                f fVar4 = mVar.f1444i;
                if (fVar4.f1423j) {
                    o2 = fVar3.f1420g;
                    o4 = fVar4.f1420g;
                }
            }
        }
        int i4 = o4 - o2;
        if (o3 - o < 0 || i4 < 0 || o == Integer.MIN_VALUE || o == Integer.MAX_VALUE || o2 == Integer.MIN_VALUE || o2 == Integer.MAX_VALUE || o3 == Integer.MIN_VALUE || o3 == Integer.MAX_VALUE || o4 == Integer.MIN_VALUE || o4 == Integer.MAX_VALUE) {
            o4 = 0;
            o = 0;
            o2 = 0;
            o3 = 0;
        }
        a aVar = a.MATCH_CONSTRAINT;
        int i5 = o3 - o;
        int i6 = o4 - o2;
        this.Z = o;
        this.a0 = o2;
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
            this.f1395h = i11;
        }
        int i12 = this.W;
        if (i6 != i12) {
            this.f1396i = i12;
        }
    }

    public void b(e eVar, e.h.a.d dVar, HashSet<d> hashSet, int i2, boolean z) {
        if (z) {
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
                    it.next().f1377d.b(eVar, dVar, hashSet, i2, true);
                }
            }
            HashSet<c> hashSet3 = this.K.a;
            if (hashSet3 != null) {
                Iterator<c> it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    it2.next().f1377d.b(eVar, dVar, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet<c> hashSet4 = this.J.a;
        if (hashSet4 != null) {
            Iterator<c> it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                it3.next().f1377d.b(eVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<c> hashSet5 = this.L.a;
        if (hashSet5 != null) {
            Iterator<c> it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                it4.next().f1377d.b(eVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<c> hashSet6 = this.M.a;
        if (hashSet6 != null) {
            Iterator<c> it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                it5.next().f1377d.b(eVar, dVar, hashSet, i2, true);
            }
        }
    }

    public boolean c() {
        return (this instanceof j) || (this instanceof f);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x017e  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void d(e.h.a.d dVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i2;
        int i3;
        int i4;
        int i5;
        float f2;
        int i6;
        int i7;
        boolean z7;
        int i8;
        g gVar;
        char c;
        boolean z8;
        int i9;
        boolean z9;
        boolean z10;
        boolean z11;
        a aVar;
        g gVar2;
        g gVar3;
        g gVar4;
        a aVar2;
        g gVar5;
        g gVar6;
        d dVar2;
        e.h.a.d dVar3;
        g gVar7;
        g gVar8;
        char c2;
        int i10;
        boolean z12;
        int i11;
        g gVar9;
        g gVar10;
        g gVar11;
        d dVar4;
        g gVar12;
        g gVar13;
        g gVar14;
        g gVar15;
        e.h.a.d dVar5;
        boolean z13;
        k kVar;
        f fVar;
        int i12;
        int i13;
        int i14;
        boolean z14;
        boolean z15;
        k kVar2;
        m mVar;
        f fVar2;
        d dVar6;
        d dVar7;
        boolean z16;
        a aVar3 = a.WRAP_CONTENT;
        g l2 = dVar.l(this.I);
        g l3 = dVar.l(this.K);
        g l4 = dVar.l(this.J);
        g l5 = dVar.l(this.L);
        g l6 = dVar.l(this.M);
        d dVar8 = this.U;
        if (dVar8 != null) {
            boolean z17 = dVar8 != null && dVar8.T[0] == aVar3;
            boolean z18 = dVar8 != null && dVar8.T[1] == aVar3;
            int i15 = this.p;
            if (i15 == 1) {
                z2 = z17;
                z3 = false;
            } else if (i15 == 2) {
                z3 = z18;
                z2 = false;
            } else if (i15 != 3) {
                z3 = z18;
                z2 = z17;
            }
            if (this.h0 == 8) {
                int size = this.R.size();
                int i16 = 0;
                while (true) {
                    if (i16 >= size) {
                        z16 = false;
                        break;
                    } else if (this.R.get(i16).f()) {
                        z16 = true;
                        break;
                    } else {
                        i16++;
                    }
                }
                if (!z16) {
                    boolean[] zArr = this.S;
                    if (!zArr[0] && !zArr[1]) {
                        return;
                    }
                }
            }
            z4 = this.f1397j;
            if (!z4 || this.f1398k) {
                if (z4) {
                    dVar.e(l2, this.Z);
                    dVar.e(l3, this.Z + this.V);
                    if (z2 && (dVar7 = this.U) != null) {
                        e eVar = (e) dVar7;
                        eVar.U(this.I);
                        eVar.T(this.K);
                    }
                }
                if (this.f1398k) {
                    dVar.e(l4, this.a0);
                    dVar.e(l5, this.a0 + this.W);
                    if (this.M.f()) {
                        dVar.e(l6, this.a0 + this.b0);
                    }
                    if (z3 && (dVar6 = this.U) != null) {
                        e eVar2 = (e) dVar6;
                        eVar2.W(this.J);
                        eVar2.V(this.L);
                    }
                }
                if (this.f1397j && this.f1398k) {
                    this.f1397j = false;
                    this.f1398k = false;
                    return;
                }
            }
            if (!(!z || (kVar2 = this.f1391d) == null || (mVar = this.f1392e) == null)) {
                fVar2 = kVar2.f1443h;
                if (fVar2.f1423j && kVar2.f1444i.f1423j && mVar.f1443h.f1423j && mVar.f1444i.f1423j) {
                    dVar.e(l2, fVar2.f1420g);
                    dVar.e(l3, this.f1391d.f1444i.f1420g);
                    dVar.e(l4, this.f1392e.f1443h.f1420g);
                    dVar.e(l5, this.f1392e.f1444i.f1420g);
                    dVar.e(l6, this.f1392e.f1434k.f1420g);
                    if (this.U != null) {
                        if (z2 && this.f1393f[0] && !x()) {
                            dVar.f(dVar.l(this.U.K), l3, 0, 8);
                        }
                        if (z3 && this.f1393f[1] && !y()) {
                            dVar.f(dVar.l(this.U.L), l5, 0, 8);
                        }
                    }
                    this.f1397j = false;
                    this.f1398k = false;
                    return;
                }
            }
            if (this.U == null) {
                if (w(0)) {
                    ((e) this.U).R(this, 0);
                    z14 = true;
                } else {
                    z14 = x();
                }
                if (w(1)) {
                    ((e) this.U).R(this, 1);
                    z15 = true;
                } else {
                    z15 = y();
                }
                if (!z14 && z2 && this.h0 != 8 && this.I.f1379f == null && this.K.f1379f == null) {
                    dVar.f(dVar.l(this.U.K), l3, 0, 1);
                }
                if (!z15 && z3 && this.h0 != 8 && this.J.f1379f == null && this.L.f1379f == null && this.M == null) {
                    dVar.f(dVar.l(this.U.L), l5, 0, 1);
                }
                z5 = z14;
                z6 = z15;
            } else {
                z6 = false;
                z5 = false;
            }
            i2 = this.V;
            i3 = this.c0;
            if (i2 >= i3) {
                i3 = i2;
            }
            i4 = this.W;
            i5 = this.d0;
            if (i4 >= i5) {
                i5 = i4;
            }
            a[] aVarArr = this.T;
            a aVar4 = aVarArr[0];
            int i17 = i3;
            a aVar5 = a.MATCH_CONSTRAINT;
            boolean z19 = aVar4 == aVar5;
            boolean z20 = aVarArr[1] == aVar5;
            int i18 = this.Y;
            this.z = i18;
            f2 = this.X;
            this.A = f2;
            int i19 = this.q;
            int i20 = this.r;
            if (f2 <= 0.0f) {
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
                            if (z19 && !z20) {
                                this.z = 0;
                            } else if (!z19 && z20) {
                                this.z = 1;
                                if (i18 == -1) {
                                    this.A = 1.0f / f2;
                                }
                            }
                        }
                        if (this.z != 0 || (this.J.g() && this.L.g())) {
                            if (this.z == 1 && (!this.I.g() || !this.K.g())) {
                                i14 = 0;
                            }
                            if (this.z == -1 && (!this.J.g() || !this.L.g() || !this.I.g() || !this.K.g())) {
                                if (!this.J.g() && this.L.g()) {
                                    i13 = 0;
                                } else if (this.I.g() && this.K.g()) {
                                    this.A = 1.0f / this.A;
                                    i13 = 1;
                                }
                                this.z = i13;
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
                            i14 = 1;
                        }
                        this.z = i14;
                        if (this.z == -1) {
                            if (!this.J.g()) {
                            }
                            if (this.I.g()) {
                                this.A = 1.0f / this.A;
                                i13 = 1;
                                this.z = i13;
                            }
                        }
                        if (this.z == -1) {
                        }
                    } else if (aVarArr[0] == aVar5 && i19 == 3) {
                        this.z = 0;
                        i17 = (int) (f2 * ((float) i4));
                        if (aVarArr[1] != aVar5) {
                            i7 = i20;
                            i8 = i5;
                            c = 0;
                            z7 = false;
                            i6 = 4;
                            int[] iArr = this.s;
                            iArr[c] = i6;
                            iArr[1] = i7;
                            if (z7) {
                            }
                            z8 = false;
                            if (!z7) {
                            }
                            if (this.T[0] != aVar3) {
                            }
                            if (z9) {
                            }
                            z10 = !this.P.g();
                            boolean[] zArr2 = this.S;
                            z11 = zArr2[0];
                            boolean z21 = zArr2[1];
                            if (this.n != 2) {
                            }
                            aVar2 = aVar5;
                            gVar5 = l2;
                            aVar = aVar3;
                            gVar4 = l6;
                            gVar3 = l5;
                            gVar2 = l4;
                            gVar6 = gVar;
                            if (z) {
                            }
                            z12 = true;
                            if (dVar2.o != 2 ? false : z12) {
                            }
                            gVar11 = gVar8;
                            gVar10 = gVar7;
                            if (!z7) {
                            }
                            if (dVar4.P.g()) {
                            }
                            this.f1397j = false;
                            this.f1398k = false;
                        }
                        i6 = i19;
                        i7 = i20;
                        i8 = i5;
                        c = 0;
                        z7 = true;
                        int[] iArr2 = this.s;
                        iArr2[c] = i6;
                        iArr2[1] = i7;
                        if (z7) {
                        }
                        z8 = false;
                        if (!z7) {
                        }
                        if (this.T[0] != aVar3) {
                        }
                        if (z9) {
                        }
                        z10 = !this.P.g();
                        boolean[] zArr22 = this.S;
                        z11 = zArr22[0];
                        boolean z212 = zArr22[1];
                        if (this.n != 2) {
                        }
                        aVar2 = aVar5;
                        gVar5 = l2;
                        aVar = aVar3;
                        gVar4 = l6;
                        gVar3 = l5;
                        gVar2 = l4;
                        gVar6 = gVar;
                        if (z) {
                        }
                        z12 = true;
                        if (dVar2.o != 2 ? false : z12) {
                        }
                        gVar11 = gVar8;
                        gVar10 = gVar7;
                        if (!z7) {
                        }
                        if (dVar4.P.g()) {
                        }
                        this.f1397j = false;
                        this.f1398k = false;
                    } else if (aVarArr[1] == aVar5 && i20 == 3) {
                        this.z = 1;
                        if (i18 == -1) {
                            this.A = 1.0f / f2;
                        }
                        i8 = (int) (this.A * ((float) i2));
                        c = 0;
                        i6 = i19;
                        if (aVarArr[0] != aVar5) {
                            z7 = false;
                            i7 = 4;
                            int[] iArr22 = this.s;
                            iArr22[c] = i6;
                            iArr22[1] = i7;
                            if (z7) {
                                int i22 = this.z;
                                i9 = -1;
                                if (i22 == 0 || i22 == -1) {
                                    z8 = true;
                                    boolean z22 = !z7 && ((i12 = this.z) == 1 || i12 == i9);
                                    z9 = this.T[0] != aVar3 && (this instanceof e);
                                    if (z9) {
                                        i17 = 0;
                                    }
                                    z10 = !this.P.g();
                                    boolean[] zArr222 = this.S;
                                    z11 = zArr222[0];
                                    boolean z2122 = zArr222[1];
                                    if (this.n != 2 && !this.f1397j) {
                                        if (z && (kVar = this.f1391d) != null) {
                                            fVar = kVar.f1443h;
                                            if (fVar.f1423j && kVar.f1444i.f1423j) {
                                                if (z) {
                                                    dVar.e(l2, fVar.f1420g);
                                                    dVar.e(gVar, this.f1391d.f1444i.f1420g);
                                                    if (this.U != null && z2 && this.f1393f[0] && !x()) {
                                                        dVar.f(dVar.l(this.U.K), gVar, 0, 8);
                                                    }
                                                    aVar2 = aVar5;
                                                    gVar5 = l2;
                                                    aVar = aVar3;
                                                    gVar4 = l6;
                                                    gVar3 = l5;
                                                    gVar2 = l4;
                                                    gVar6 = gVar;
                                                    if (z) {
                                                        dVar2 = this;
                                                        m mVar2 = dVar2.f1392e;
                                                        if (mVar2 != null) {
                                                            f fVar3 = mVar2.f1443h;
                                                            if (fVar3.f1423j && mVar2.f1444i.f1423j) {
                                                                dVar3 = dVar;
                                                                gVar7 = gVar2;
                                                                dVar3.e(gVar7, fVar3.f1420g);
                                                                gVar8 = gVar3;
                                                                dVar3.e(gVar8, dVar2.f1392e.f1444i.f1420g);
                                                                gVar9 = gVar4;
                                                                dVar3.e(gVar9, dVar2.f1392e.f1434k.f1420g);
                                                                d dVar9 = dVar2.U;
                                                                if (dVar9 == null || z6 || !z3) {
                                                                    i11 = 8;
                                                                    i10 = 0;
                                                                    c2 = 1;
                                                                } else {
                                                                    c2 = 1;
                                                                    if (dVar2.f1393f[1]) {
                                                                        i11 = 8;
                                                                        i10 = 0;
                                                                        dVar3.f(dVar3.l(dVar9.L), gVar8, 0, 8);
                                                                    } else {
                                                                        i11 = 8;
                                                                        i10 = 0;
                                                                    }
                                                                }
                                                                z12 = false;
                                                                if ((dVar2.o != 2 ? false : z12) || dVar2.f1398k) {
                                                                    gVar11 = gVar8;
                                                                    gVar10 = gVar7;
                                                                } else {
                                                                    boolean z23 = dVar2.T[c2] == aVar && (dVar2 instanceof e);
                                                                    if (z23) {
                                                                        i8 = 0;
                                                                    }
                                                                    d dVar10 = dVar2.U;
                                                                    g l7 = dVar10 != null ? dVar3.l(dVar10.L) : null;
                                                                    d dVar11 = dVar2.U;
                                                                    g l8 = dVar11 != null ? dVar3.l(dVar11.J) : null;
                                                                    int i23 = dVar2.b0;
                                                                    if (i23 > 0 || dVar2.h0 == i11) {
                                                                        c cVar = dVar2.M;
                                                                        if (cVar.f1379f != null) {
                                                                            dVar3.d(gVar9, gVar7, i23, i11);
                                                                            dVar3.d(gVar9, dVar3.l(dVar2.M.f1379f), dVar2.M.d(), i11);
                                                                            if (z3) {
                                                                                dVar3.f(l7, dVar3.l(dVar2.L), i10, 5);
                                                                            }
                                                                            z13 = false;
                                                                            boolean z24 = dVar2.f1393f[c2];
                                                                            a[] aVarArr2 = dVar2.T;
                                                                            gVar11 = gVar8;
                                                                            gVar10 = gVar7;
                                                                            f(dVar, false, z3, z2, z24, l8, l7, aVarArr2[c2], z23, dVar2.J, dVar2.L, dVar2.a0, i8, dVar2.d0, dVar2.B[c2], dVar2.f0, z22, aVarArr2[0] != aVar2, z6, z5, z2122, i7, i6, dVar2.w, dVar2.x, dVar2.y, z13);
                                                                        } else {
                                                                            if (dVar2.h0 == i11) {
                                                                                i23 = cVar.d();
                                                                            }
                                                                            dVar3.d(gVar9, gVar7, i23, i11);
                                                                        }
                                                                    }
                                                                    z13 = z10;
                                                                    boolean z242 = dVar2.f1393f[c2];
                                                                    a[] aVarArr22 = dVar2.T;
                                                                    gVar11 = gVar8;
                                                                    gVar10 = gVar7;
                                                                    f(dVar, false, z3, z2, z242, l8, l7, aVarArr22[c2], z23, dVar2.J, dVar2.L, dVar2.a0, i8, dVar2.d0, dVar2.B[c2], dVar2.f0, z22, aVarArr22[0] != aVar2, z6, z5, z2122, i7, i6, dVar2.w, dVar2.x, dVar2.y, z13);
                                                                }
                                                                if (!z7) {
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
                                                                    d dVar12 = dVar4.P.f1379f.f1377d;
                                                                    int d2 = dVar4.P.d();
                                                                    c.a aVar6 = c.a.LEFT;
                                                                    g l9 = dVar.l(dVar4.i(aVar6));
                                                                    c.a aVar7 = c.a.TOP;
                                                                    g l10 = dVar.l(dVar4.i(aVar7));
                                                                    c.a aVar8 = c.a.RIGHT;
                                                                    g l11 = dVar.l(dVar4.i(aVar8));
                                                                    c.a aVar9 = c.a.BOTTOM;
                                                                    g l12 = dVar.l(dVar4.i(aVar9));
                                                                    g l13 = dVar.l(dVar12.i(aVar6));
                                                                    g l14 = dVar.l(dVar12.i(aVar7));
                                                                    g l15 = dVar.l(dVar12.i(aVar8));
                                                                    g l16 = dVar.l(dVar12.i(aVar9));
                                                                    b m = dVar.m();
                                                                    double radians = (double) ((float) Math.toRadians((double) (dVar4.C + 90.0f)));
                                                                    double d3 = (double) d2;
                                                                    m.g(l10, l12, l14, l16, (float) (Math.sin(radians) * d3));
                                                                    dVar.c(m);
                                                                    b m2 = dVar.m();
                                                                    m2.g(l9, l11, l13, l15, (float) (Math.cos(radians) * d3));
                                                                    dVar.c(m2);
                                                                }
                                                                this.f1397j = false;
                                                                this.f1398k = false;
                                                            }
                                                        }
                                                        dVar3 = dVar;
                                                        gVar9 = gVar4;
                                                        gVar8 = gVar3;
                                                        gVar7 = gVar2;
                                                        i11 = 8;
                                                        i10 = 0;
                                                        c2 = 1;
                                                    } else {
                                                        i11 = 8;
                                                        i10 = 0;
                                                        c2 = 1;
                                                        dVar2 = this;
                                                        dVar3 = dVar;
                                                        gVar9 = gVar4;
                                                        gVar8 = gVar3;
                                                        gVar7 = gVar2;
                                                    }
                                                    z12 = true;
                                                    if (dVar2.o != 2 ? false : z12) {
                                                    }
                                                    gVar11 = gVar8;
                                                    gVar10 = gVar7;
                                                    if (!z7) {
                                                    }
                                                    if (dVar4.P.g()) {
                                                    }
                                                    this.f1397j = false;
                                                    this.f1398k = false;
                                                }
                                            }
                                        }
                                        d dVar13 = this.U;
                                        g l17 = dVar13 == null ? dVar.l(dVar13.K) : null;
                                        d dVar14 = this.U;
                                        g l18 = dVar14 == null ? dVar.l(dVar14.I) : null;
                                        boolean z25 = this.f1393f[0];
                                        a[] aVarArr3 = this.T;
                                        aVar2 = aVar5;
                                        gVar4 = l6;
                                        gVar3 = l5;
                                        gVar2 = l4;
                                        gVar6 = gVar;
                                        gVar5 = l2;
                                        aVar = aVar3;
                                        f(dVar, true, z2, z3, z25, l18, l17, aVarArr3[0], z9, this.I, this.K, this.Z, i17, this.c0, this.B[0], this.e0, z8, aVarArr3[1] != aVar5, z5, z6, z11, i6, i7, this.t, this.u, this.v, z10);
                                        if (z) {
                                        }
                                        z12 = true;
                                        if (dVar2.o != 2 ? false : z12) {
                                        }
                                        gVar11 = gVar8;
                                        gVar10 = gVar7;
                                        if (!z7) {
                                        }
                                        if (dVar4.P.g()) {
                                        }
                                        this.f1397j = false;
                                        this.f1398k = false;
                                    }
                                    aVar2 = aVar5;
                                    gVar5 = l2;
                                    aVar = aVar3;
                                    gVar4 = l6;
                                    gVar3 = l5;
                                    gVar2 = l4;
                                    gVar6 = gVar;
                                    if (z) {
                                    }
                                    z12 = true;
                                    if (dVar2.o != 2 ? false : z12) {
                                    }
                                    gVar11 = gVar8;
                                    gVar10 = gVar7;
                                    if (!z7) {
                                    }
                                    if (dVar4.P.g()) {
                                    }
                                    this.f1397j = false;
                                    this.f1398k = false;
                                }
                            } else {
                                i9 = -1;
                            }
                            z8 = false;
                            if (!z7) {
                            }
                            if (this.T[0] != aVar3) {
                            }
                            if (z9) {
                            }
                            z10 = !this.P.g();
                            boolean[] zArr2222 = this.S;
                            z11 = zArr2222[0];
                            boolean z21222 = zArr2222[1];
                            if (this.n != 2) {
                                if (z) {
                                    fVar = kVar.f1443h;
                                    if (fVar.f1423j) {
                                        if (z) {
                                        }
                                    }
                                }
                                d dVar132 = this.U;
                                if (dVar132 == null) {
                                }
                                d dVar142 = this.U;
                                if (dVar142 == null) {
                                }
                                boolean z252 = this.f1393f[0];
                                a[] aVarArr32 = this.T;
                                aVar2 = aVar5;
                                gVar4 = l6;
                                gVar3 = l5;
                                gVar2 = l4;
                                gVar6 = gVar;
                                gVar5 = l2;
                                aVar = aVar3;
                                f(dVar, true, z2, z3, z252, l18, l17, aVarArr32[0], z9, this.I, this.K, this.Z, i17, this.c0, this.B[0], this.e0, z8, aVarArr32[1] != aVar5, z5, z6, z11, i6, i7, this.t, this.u, this.v, z10);
                                if (z) {
                                }
                                z12 = true;
                                if (dVar2.o != 2 ? false : z12) {
                                }
                                gVar11 = gVar8;
                                gVar10 = gVar7;
                                if (!z7) {
                                }
                                if (dVar4.P.g()) {
                                }
                                this.f1397j = false;
                                this.f1398k = false;
                            }
                            aVar2 = aVar5;
                            gVar5 = l2;
                            aVar = aVar3;
                            gVar4 = l6;
                            gVar3 = l5;
                            gVar2 = l4;
                            gVar6 = gVar;
                            if (z) {
                            }
                            z12 = true;
                            if (dVar2.o != 2 ? false : z12) {
                            }
                            gVar11 = gVar8;
                            gVar10 = gVar7;
                            if (!z7) {
                            }
                            if (dVar4.P.g()) {
                            }
                            this.f1397j = false;
                            this.f1398k = false;
                        }
                        i7 = i20;
                        z7 = true;
                        int[] iArr222 = this.s;
                        iArr222[c] = i6;
                        iArr222[1] = i7;
                        if (z7) {
                        }
                        z8 = false;
                        if (!z7) {
                        }
                        if (this.T[0] != aVar3) {
                        }
                        if (z9) {
                        }
                        z10 = !this.P.g();
                        boolean[] zArr22222 = this.S;
                        z11 = zArr22222[0];
                        boolean z212222 = zArr22222[1];
                        if (this.n != 2) {
                        }
                        aVar2 = aVar5;
                        gVar5 = l2;
                        aVar = aVar3;
                        gVar4 = l6;
                        gVar3 = l5;
                        gVar2 = l4;
                        gVar6 = gVar;
                        if (z) {
                        }
                        z12 = true;
                        if (dVar2.o != 2 ? false : z12) {
                        }
                        gVar11 = gVar8;
                        gVar10 = gVar7;
                        if (!z7) {
                        }
                        if (dVar4.P.g()) {
                        }
                        this.f1397j = false;
                        this.f1398k = false;
                    }
                    c = 0;
                    i6 = i19;
                    i7 = i20;
                    i8 = i5;
                    z7 = true;
                    int[] iArr2222 = this.s;
                    iArr2222[c] = i6;
                    iArr2222[1] = i7;
                    if (z7) {
                    }
                    z8 = false;
                    if (!z7) {
                    }
                    if (this.T[0] != aVar3) {
                    }
                    if (z9) {
                    }
                    z10 = !this.P.g();
                    boolean[] zArr222222 = this.S;
                    z11 = zArr222222[0];
                    boolean z2122222 = zArr222222[1];
                    if (this.n != 2) {
                    }
                    aVar2 = aVar5;
                    gVar5 = l2;
                    aVar = aVar3;
                    gVar4 = l6;
                    gVar3 = l5;
                    gVar2 = l4;
                    gVar6 = gVar;
                    if (z) {
                    }
                    z12 = true;
                    if (dVar2.o != 2 ? false : z12) {
                    }
                    gVar11 = gVar8;
                    gVar10 = gVar7;
                    if (!z7) {
                    }
                    if (dVar4.P.g()) {
                    }
                    this.f1397j = false;
                    this.f1398k = false;
                }
            } else {
                gVar = l3;
            }
            c = 0;
            i6 = i19;
            i7 = i20;
            i8 = i5;
            z7 = false;
            int[] iArr22222 = this.s;
            iArr22222[c] = i6;
            iArr22222[1] = i7;
            if (z7) {
            }
            z8 = false;
            if (!z7) {
            }
            if (this.T[0] != aVar3) {
            }
            if (z9) {
            }
            z10 = !this.P.g();
            boolean[] zArr2222222 = this.S;
            z11 = zArr2222222[0];
            boolean z21222222 = zArr2222222[1];
            if (this.n != 2) {
            }
            aVar2 = aVar5;
            gVar5 = l2;
            aVar = aVar3;
            gVar4 = l6;
            gVar3 = l5;
            gVar2 = l4;
            gVar6 = gVar;
            if (z) {
            }
            z12 = true;
            if (dVar2.o != 2 ? false : z12) {
            }
            gVar11 = gVar8;
            gVar10 = gVar7;
            if (!z7) {
            }
            if (dVar4.P.g()) {
            }
            this.f1397j = false;
            this.f1398k = false;
        }
        z3 = false;
        z2 = false;
        if (this.h0 == 8) {
        }
        z4 = this.f1397j;
        if (!z4) {
        }
        if (z4) {
        }
        if (this.f1398k) {
        }
        if (this.f1397j) {
            this.f1397j = false;
            this.f1398k = false;
            return;
        }
        if (!z) {
            fVar2 = kVar2.f1443h;
            if (fVar2.f1423j) {
                dVar.e(l2, fVar2.f1420g);
                dVar.e(l3, this.f1391d.f1444i.f1420g);
                dVar.e(l4, this.f1392e.f1443h.f1420g);
                dVar.e(l5, this.f1392e.f1444i.f1420g);
                dVar.e(l6, this.f1392e.f1434k.f1420g);
                if (this.U != null) {
                }
                this.f1397j = false;
                this.f1398k = false;
                return;
            }
        }
        if (this.U == null) {
        }
        i2 = this.V;
        i3 = this.c0;
        if (i2 >= i3) {
        }
        i4 = this.W;
        i5 = this.d0;
        if (i4 >= i5) {
        }
        a[] aVarArr4 = this.T;
        a aVar42 = aVarArr4[0];
        int i172 = i3;
        a aVar52 = a.MATCH_CONSTRAINT;
        if (aVar42 == aVar52) {
        }
        if (aVarArr4[1] == aVar52) {
        }
        int i182 = this.Y;
        this.z = i182;
        f2 = this.X;
        this.A = f2;
        int i192 = this.q;
        int i202 = this.r;
        if (f2 <= 0.0f) {
        }
        c = 0;
        i6 = i192;
        i7 = i202;
        i8 = i5;
        z7 = false;
        int[] iArr222222 = this.s;
        iArr222222[c] = i6;
        iArr222222[1] = i7;
        if (z7) {
        }
        z8 = false;
        if (!z7) {
        }
        if (this.T[0] != aVar3) {
        }
        if (z9) {
        }
        z10 = !this.P.g();
        boolean[] zArr22222222 = this.S;
        z11 = zArr22222222[0];
        boolean z212222222 = zArr22222222[1];
        if (this.n != 2) {
        }
        aVar2 = aVar52;
        gVar5 = l2;
        aVar = aVar3;
        gVar4 = l6;
        gVar3 = l5;
        gVar2 = l4;
        gVar6 = gVar;
        if (z) {
        }
        z12 = true;
        if (dVar2.o != 2 ? false : z12) {
        }
        gVar11 = gVar8;
        gVar10 = gVar7;
        if (!z7) {
        }
        if (dVar4.P.g()) {
        }
        this.f1397j = false;
        this.f1398k = false;
    }

    public boolean e() {
        return this.h0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x04cf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:345:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void f(e.h.a.d dVar, boolean z, boolean z2, boolean z3, boolean z4, g gVar, g gVar2, a aVar, boolean z5, c cVar, c cVar2, int i2, int i3, int i4, int i5, float f2, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i6, int i7, int i8, int i9, float f3, boolean z11) {
        boolean z12;
        int i10;
        boolean z13;
        int i11;
        boolean z14;
        int i12;
        boolean z15;
        int i13;
        int i14;
        boolean z16;
        boolean z17;
        char c;
        int i15;
        g gVar3;
        int i16;
        g gVar4;
        int i17;
        g gVar5;
        g gVar6;
        int i18;
        c cVar3;
        a[] aVarArr;
        a aVar2;
        boolean z18;
        boolean z19;
        g gVar7;
        int i19;
        g gVar8;
        int i20;
        g gVar9;
        int i21;
        boolean z20;
        boolean z21;
        boolean z22;
        int i22;
        int i23;
        int i24;
        g gVar10;
        boolean z23;
        int i25;
        g gVar11;
        g gVar12;
        g gVar13;
        g gVar14;
        g gVar15;
        d dVar2;
        int i26;
        d dVar3;
        boolean z24;
        g gVar16;
        int i27;
        int i28;
        int i29;
        int i30;
        boolean z25;
        boolean z26;
        g gVar17;
        int i31;
        boolean z27;
        boolean z28;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        boolean z29;
        int i40;
        int i41;
        int i42;
        g gVar18;
        g gVar19;
        int i43 = i8;
        int i44 = i9;
        c.a aVar3 = c.a.BOTTOM;
        g l2 = dVar.l(cVar);
        g l3 = dVar.l(cVar2);
        g l4 = dVar.l(cVar.f1379f);
        g l5 = dVar.l(cVar2.f1379f);
        boolean g2 = cVar.g();
        boolean g3 = cVar2.g();
        boolean g4 = this.P.g();
        int i45 = g3 ? (g2 ? 1 : 0) + 1 : g2 ? 1 : 0;
        if (g4) {
            i45++;
        }
        int i46 = z6 ? 3 : i6;
        int ordinal = aVar.ordinal();
        if (ordinal != 0 && ordinal != 1 && ordinal == 2) {
            if (i46 != 4) {
                z12 = true;
                i10 = this.f1395h;
                z13 = z12;
                if (i10 != -1 && z) {
                    this.f1395h = -1;
                    i3 = i10;
                    z13 = false;
                }
                i11 = this.f1396i;
                if (i11 != -1 || z) {
                    i11 = i3;
                } else {
                    this.f1396i = -1;
                    z13 = false;
                }
                if (this.h0 != 8) {
                    i12 = 0;
                    z14 = false;
                } else {
                    i12 = i11;
                    z14 = z13;
                }
                if (z11) {
                    if (!g2 && !g3 && !g4) {
                        dVar.e(l2, i2);
                    } else if (g2 && !g3) {
                        z15 = g4;
                        i13 = 8;
                        dVar.d(l2, l4, cVar.d(), 8);
                        if (z14) {
                            if (i45 == 2 || z6 || !(i46 == 1 || i46 == 0)) {
                                if (i43 == -2) {
                                    i43 = i12;
                                }
                                if (i44 == -2) {
                                    i44 = i12;
                                }
                                if (i12 > 0 && i46 != 1) {
                                    i12 = 0;
                                }
                                if (i43 > 0) {
                                    dVar.f(l3, l2, i43, 8);
                                    i12 = Math.max(i12, i43);
                                }
                                if (i44 > 0) {
                                    if (!z2 || i46 != 1) {
                                        i42 = 8;
                                        dVar.g(l3, l2, i44, 8);
                                    } else {
                                        i42 = 8;
                                    }
                                    i12 = Math.min(i12, i44);
                                } else {
                                    i42 = 8;
                                }
                                if (i46 == 1) {
                                    if (z2) {
                                        dVar.d(l3, l2, i12, i42);
                                    } else {
                                        dVar.d(l3, l2, i12, 5);
                                        dVar.g(l3, l2, i12, i42);
                                    }
                                } else if (i46 == 2) {
                                    c.a aVar4 = cVar.f1378e;
                                    c.a aVar5 = c.a.TOP;
                                    if (aVar4 == aVar5 || aVar4 == aVar3) {
                                        gVar18 = dVar.l(this.U.i(aVar5));
                                        gVar19 = dVar.l(this.U.i(aVar3));
                                    } else {
                                        gVar18 = dVar.l(this.U.i(c.a.LEFT));
                                        gVar19 = dVar.l(this.U.i(c.a.RIGHT));
                                    }
                                    b m = dVar.m();
                                    m.d(l3, l2, gVar19, gVar18, f3);
                                    dVar.c(m);
                                    if (z2) {
                                        z14 = false;
                                    }
                                } else {
                                    i14 = i43;
                                    z16 = true;
                                }
                            } else {
                                int max = Math.max(i43, i12);
                                if (i44 > 0) {
                                    max = Math.min(i44, max);
                                }
                                dVar.d(l3, l2, max, 8);
                                z16 = z4;
                                i14 = i43;
                                z14 = false;
                            }
                            if (z11) {
                                gVar5 = gVar2;
                                i17 = i45;
                                gVar3 = l3;
                                gVar4 = l2;
                                z17 = z16;
                                i18 = 0;
                                i15 = 8;
                                c = 1;
                                gVar6 = gVar;
                                i16 = 2;
                            } else if (z8) {
                                gVar5 = gVar2;
                                i17 = i45;
                                gVar3 = l3;
                                gVar4 = l2;
                                z17 = z16;
                                i18 = 0;
                                i16 = 2;
                                i15 = 8;
                                c = 1;
                                gVar6 = gVar;
                            } else {
                                if (!g2 && !g3 && !z15) {
                                    gVar7 = l3;
                                    z18 = z16;
                                    gVar8 = l5;
                                } else if (!g2 || g3) {
                                    if (g2 || !g3) {
                                        gVar9 = l5;
                                        if (g2 && g3) {
                                            d dVar4 = cVar.f1379f.f1377d;
                                            d dVar5 = cVar2.f1379f.f1377d;
                                            d dVar6 = this.U;
                                            if (z14) {
                                                if (i46 == 0) {
                                                    if (i44 != 0 || i14 != 0) {
                                                        i41 = 5;
                                                        i40 = 5;
                                                        z28 = false;
                                                        z27 = true;
                                                        z22 = true;
                                                    } else if (!l4.f1358g || !gVar9.f1358g) {
                                                        i41 = 8;
                                                        i40 = 8;
                                                        z28 = true;
                                                        z27 = false;
                                                        z22 = false;
                                                    } else {
                                                        dVar.d(l2, l4, cVar.d(), 8);
                                                        dVar.d(l3, gVar9, -cVar2.d(), 8);
                                                        return;
                                                    }
                                                    if ((dVar4 instanceof a) || (dVar5 instanceof a)) {
                                                        i21 = i40;
                                                        z20 = z28;
                                                        z21 = z27;
                                                        i23 = 4;
                                                        i22 = 6;
                                                        i24 = i46;
                                                        gVar10 = gVar2;
                                                    } else {
                                                        i33 = i41;
                                                        i24 = i46;
                                                        i32 = i40;
                                                        i21 = i32;
                                                        z20 = z28;
                                                        z21 = z27;
                                                        i22 = 6;
                                                        gVar10 = gVar2;
                                                        i23 = i33;
                                                    }
                                                } else {
                                                    if (i46 == 2) {
                                                        i34 = ((dVar4 instanceof a) || (dVar5 instanceof a)) ? 4 : 5;
                                                        i35 = 5;
                                                    } else if (i46 == 1) {
                                                        i35 = 8;
                                                        i34 = 4;
                                                    } else if (i46 == 3) {
                                                        i24 = i46;
                                                        if (this.z == -1) {
                                                            i38 = z9 ? z2 ? 5 : 4 : 8;
                                                            i37 = 5;
                                                            i36 = 8;
                                                        } else if (z6) {
                                                            if (!(i7 == 2 || i7 == 1)) {
                                                                z29 = false;
                                                                if (z29) {
                                                                    i33 = 5;
                                                                    i32 = 8;
                                                                } else {
                                                                    i33 = 4;
                                                                    i32 = 5;
                                                                }
                                                                z28 = true;
                                                                z27 = true;
                                                                z22 = true;
                                                                i21 = i32;
                                                                z20 = z28;
                                                                z21 = z27;
                                                                i22 = 6;
                                                                gVar10 = gVar2;
                                                                i23 = i33;
                                                            }
                                                            z29 = true;
                                                            if (z29) {
                                                            }
                                                            z28 = true;
                                                            z27 = true;
                                                            z22 = true;
                                                            i21 = i32;
                                                            z20 = z28;
                                                            z21 = z27;
                                                            i22 = 6;
                                                            gVar10 = gVar2;
                                                            i23 = i33;
                                                        } else {
                                                            if (i44 > 0) {
                                                                i39 = 5;
                                                            } else if (i44 != 0 || i14 != 0) {
                                                                i39 = 4;
                                                            } else if (!z9) {
                                                                i39 = 8;
                                                            } else {
                                                                i36 = (dVar4 == dVar6 || dVar5 == dVar6) ? 5 : 4;
                                                                i38 = 6;
                                                                i37 = 4;
                                                            }
                                                            i37 = i39;
                                                            i38 = 6;
                                                            i36 = 5;
                                                        }
                                                        i22 = i38;
                                                        i21 = i36;
                                                        z22 = true;
                                                        z21 = true;
                                                        z20 = true;
                                                        i23 = i37;
                                                        gVar10 = gVar2;
                                                    } else {
                                                        i24 = i46;
                                                        gVar10 = gVar2;
                                                        z26 = false;
                                                        z25 = false;
                                                    }
                                                    i24 = i46;
                                                    z28 = false;
                                                    z27 = true;
                                                    z22 = true;
                                                    i32 = i35;
                                                    i33 = i34;
                                                    i21 = i32;
                                                    z20 = z28;
                                                    z21 = z27;
                                                    i22 = 6;
                                                    gVar10 = gVar2;
                                                    i23 = i33;
                                                }
                                                if (z22 || l4 != gVar9 || dVar4 == dVar6) {
                                                    z23 = true;
                                                } else {
                                                    z22 = false;
                                                    z23 = false;
                                                }
                                                if (!z21) {
                                                    if (z14 || z7 || z9 || l4 != gVar || gVar9 != gVar10) {
                                                        i30 = i22;
                                                        z19 = z2;
                                                    } else {
                                                        z19 = false;
                                                        i30 = 8;
                                                        i21 = 8;
                                                        z23 = false;
                                                    }
                                                    dVar2 = dVar4;
                                                    gVar15 = gVar;
                                                    z18 = z16;
                                                    dVar3 = dVar5;
                                                    gVar11 = gVar9;
                                                    i25 = i14;
                                                    i26 = 8;
                                                    gVar14 = l4;
                                                    gVar13 = l3;
                                                    gVar12 = l2;
                                                    dVar.b(l2, l4, cVar.d(), f2, gVar9, l3, cVar2.d(), i30);
                                                } else {
                                                    dVar2 = dVar4;
                                                    gVar15 = gVar;
                                                    gVar11 = gVar9;
                                                    gVar14 = l4;
                                                    gVar13 = l3;
                                                    gVar12 = l2;
                                                    z18 = z16;
                                                    i25 = i14;
                                                    i26 = 8;
                                                    dVar3 = dVar5;
                                                    z19 = z2;
                                                }
                                                z24 = z23;
                                                if (this.h0 == i26 || cVar2.f()) {
                                                    gVar8 = gVar11;
                                                    if (!z22) {
                                                        int i47 = (!z19 || gVar14 == gVar8 || z14 || (!(dVar2 instanceof a) && !(dVar3 instanceof a))) ? i21 : 6;
                                                        gVar16 = gVar12;
                                                        dVar.f(gVar16, gVar14, cVar.d(), i47);
                                                        gVar7 = gVar13;
                                                        dVar.g(gVar7, gVar8, -cVar2.d(), i47);
                                                        i21 = i47;
                                                    } else {
                                                        gVar7 = gVar13;
                                                        gVar16 = gVar12;
                                                    }
                                                    if (z19 || !z10 || (dVar2 instanceof a) || (dVar3 instanceof a) || dVar3 == dVar6) {
                                                        i28 = i23;
                                                        i27 = i21;
                                                    } else {
                                                        i28 = 6;
                                                        i27 = 6;
                                                        z24 = true;
                                                    }
                                                    if (z24) {
                                                        if (z20 && (!z9 || z3)) {
                                                            int i48 = (dVar2 == dVar6 || dVar3 == dVar6) ? 6 : i28;
                                                            if ((dVar2 instanceof f) || (dVar3 instanceof f)) {
                                                                i48 = 5;
                                                            }
                                                            if ((dVar2 instanceof a) || (dVar3 instanceof a)) {
                                                                i48 = 5;
                                                            }
                                                            if (z9) {
                                                                i48 = 5;
                                                            }
                                                            i28 = Math.max(i48, i28);
                                                        }
                                                        if (z19) {
                                                            i28 = Math.min(i27, i28);
                                                            if (z6 && !z9 && (dVar2 == dVar6 || dVar3 == dVar6)) {
                                                                i29 = 4;
                                                                dVar.d(gVar16, gVar14, cVar.d(), i29);
                                                                dVar.d(gVar7, gVar8, -cVar2.d(), i29);
                                                            }
                                                        }
                                                        i29 = i28;
                                                        dVar.d(gVar16, gVar14, cVar.d(), i29);
                                                        dVar.d(gVar7, gVar8, -cVar2.d(), i29);
                                                    }
                                                    if (z19) {
                                                        int d2 = gVar15 == gVar14 ? cVar.d() : 0;
                                                        if (gVar14 != gVar15) {
                                                            dVar.f(gVar16, gVar15, d2, 5);
                                                        }
                                                    }
                                                    if (z19 || !z14 || i4 != 0 || i25 != 0) {
                                                        i20 = 0;
                                                    } else if (!z14 || i24 != 3) {
                                                        i20 = 0;
                                                        dVar.f(gVar7, gVar16, 0, 5);
                                                        i19 = 5;
                                                        if (!z19 && z18) {
                                                            if (cVar2.f1379f != null) {
                                                                i20 = cVar2.d();
                                                            }
                                                            if (gVar8 != gVar2) {
                                                                dVar.f(gVar2, gVar7, i20, i19);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        i20 = 0;
                                                        dVar.f(gVar7, gVar16, 0, i26);
                                                    }
                                                    i19 = 5;
                                                    if (!z19) {
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            i24 = i46;
                                            if (!l4.f1358g || !gVar9.f1358g) {
                                                gVar10 = gVar2;
                                                z26 = true;
                                                z25 = true;
                                            } else {
                                                dVar.b(l2, l4, cVar.d(), f2, gVar9, l3, cVar2.d(), 8);
                                                if (z2 && z16) {
                                                    if (cVar2.f1379f != null) {
                                                        i31 = cVar2.d();
                                                        gVar17 = gVar2;
                                                    } else {
                                                        gVar17 = gVar2;
                                                        i31 = 0;
                                                    }
                                                    if (gVar9 != gVar17) {
                                                        dVar.f(gVar17, l3, i31, 5);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            z21 = z26;
                                            z22 = z25;
                                            i23 = 4;
                                            i22 = 6;
                                            z20 = false;
                                            i21 = 5;
                                            if (z22) {
                                            }
                                            z23 = true;
                                            if (!z21) {
                                            }
                                            z24 = z23;
                                            if (this.h0 == i26) {
                                            }
                                            gVar8 = gVar11;
                                            if (!z22) {
                                            }
                                            if (z19) {
                                            }
                                            i28 = i23;
                                            i27 = i21;
                                            if (z24) {
                                            }
                                            if (z19) {
                                            }
                                            if (z19) {
                                            }
                                            i20 = 0;
                                            i19 = 5;
                                            if (!z19) {
                                            }
                                        }
                                    } else {
                                        gVar9 = l5;
                                        dVar.d(l3, gVar9, -cVar2.d(), 8);
                                        if (z2) {
                                            dVar.f(l2, gVar, 0, 5);
                                        }
                                    }
                                    gVar8 = gVar9;
                                    gVar7 = l3;
                                    z18 = z16;
                                } else {
                                    i19 = (!z2 || !(cVar.f1379f.f1377d instanceof a)) ? 5 : 8;
                                    z19 = z2;
                                    gVar7 = l3;
                                    z18 = z16;
                                    gVar8 = l5;
                                    i20 = 0;
                                    if (!z19) {
                                    }
                                }
                                i20 = 0;
                                z19 = z2;
                                i19 = 5;
                                if (!z19) {
                                }
                            }
                            if (i17 < i16 && z2 && z17) {
                                dVar.f(gVar4, gVar6, i18, i15);
                                boolean z30 = z || this.M.f1379f == null;
                                if (!z && (cVar3 = this.M.f1379f) != null) {
                                    d dVar7 = cVar3.f1377d;
                                    z30 = dVar7.X != 0.0f && (aVarArr = dVar7.T)[i18] == (aVar2 = a.MATCH_CONSTRAINT) && aVarArr[c] == aVar2;
                                }
                                if (z30) {
                                    dVar.f(gVar5, gVar3, i18, i15);
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (z5) {
                            dVar.d(l3, l2, 0, 3);
                            if (i4 > 0) {
                                dVar.f(l3, l2, i4, i13);
                            }
                            if (i5 < Integer.MAX_VALUE) {
                                dVar.g(l3, l2, i5, i13);
                            }
                        } else {
                            dVar.d(l3, l2, i12, i13);
                        }
                        z16 = z4;
                        i14 = i43;
                        if (z11) {
                        }
                        if (i17 < i16) {
                            return;
                        }
                        return;
                    }
                }
                z15 = g4;
                i13 = 8;
                if (z14) {
                }
                z16 = z4;
                i14 = i43;
                if (z11) {
                }
                if (i17 < i16) {
                }
            }
        }
        z12 = false;
        i10 = this.f1395h;
        z13 = z12;
        if (i10 != -1) {
            this.f1395h = -1;
            i3 = i10;
            z13 = false;
        }
        i11 = this.f1396i;
        if (i11 != -1) {
        }
        i11 = i3;
        if (this.h0 != 8) {
        }
        if (z11) {
        }
        z15 = g4;
        i13 = 8;
        if (z14) {
        }
        z16 = z4;
        i14 = i43;
        if (z11) {
        }
        if (i17 < i16) {
        }
    }

    public void g(e.h.a.d dVar) {
        dVar.l(this.I);
        dVar.l(this.J);
        dVar.l(this.K);
        dVar.l(this.L);
        if (this.b0 > 0) {
            dVar.l(this.M);
        }
    }

    public void h() {
        if (this.f1391d == null) {
            this.f1391d = new k(this);
        }
        if (this.f1392e == null) {
            this.f1392e = new m(this);
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
            c cVar4 = cVar3.f1379f;
            if (cVar4 == null || cVar4.f1379f != cVar3) {
                return null;
            }
            return cVar4.f1377d;
        } else if (i2 == 1 && (cVar2 = (cVar = this.L).f1379f) != null && cVar2.f1379f == cVar) {
            return cVar2.f1377d;
        } else {
            return null;
        }
    }

    public d o(int i2) {
        c cVar;
        c cVar2;
        if (i2 == 0) {
            c cVar3 = this.I;
            c cVar4 = cVar3.f1379f;
            if (cVar4 == null || cVar4.f1379f != cVar3) {
                return null;
            }
            return cVar4.f1377d;
        } else if (i2 == 1 && (cVar2 = (cVar = this.J).f1379f) != null && cVar2.f1379f == cVar) {
            return cVar2.f1377d;
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
            return (this.I.f1379f != null ? 1 : 0) + (this.K.f1379f != null ? 1 : 0) < 2;
        }
        return ((this.J.f1379f != null ? 1 : 0) + (this.L.f1379f != null ? 1 : 0)) + (this.M.f1379f != null ? 1 : 0) < 2;
    }

    public boolean v(int i2, int i3) {
        c cVar;
        c cVar2;
        if (i2 == 0) {
            c cVar3 = this.I.f1379f;
            if (cVar3 != null && cVar3.c && (cVar2 = this.K.f1379f) != null && cVar2.c) {
                if ((cVar2.c() - this.K.d()) - (this.I.d() + this.I.f1379f.c()) >= i3) {
                    return true;
                }
                return false;
            }
        } else {
            c cVar4 = this.J.f1379f;
            if (cVar4 != null && cVar4.c && (cVar = this.L.f1379f) != null && cVar.c) {
                if ((cVar.c() - this.L.d()) - (this.J.d() + this.J.f1379f.c()) >= i3) {
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
        if (!(cVarArr[i3].f1379f == null || cVarArr[i3].f1379f.f1379f == cVarArr[i3])) {
            int i4 = i3 + 1;
            if (cVarArr[i4].f1379f != null && cVarArr[i4].f1379f.f1379f == cVarArr[i4]) {
                return true;
            }
        }
        return false;
    }

    public boolean x() {
        c cVar = this.I;
        c cVar2 = cVar.f1379f;
        if (cVar2 != null && cVar2.f1379f == cVar) {
            return true;
        }
        c cVar3 = this.K;
        c cVar4 = cVar3.f1379f;
        return cVar4 != null && cVar4.f1379f == cVar3;
    }

    public boolean y() {
        c cVar = this.J;
        c cVar2 = cVar.f1379f;
        if (cVar2 != null && cVar2.f1379f == cVar) {
            return true;
        }
        c cVar3 = this.L;
        c cVar4 = cVar3.f1379f;
        return cVar4 != null && cVar4.f1379f == cVar3;
    }

    public boolean z() {
        return this.f1394g && this.h0 != 8;
    }
}
