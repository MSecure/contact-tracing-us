package b.g.a.h;

import b.g.a.b;
import b.g.a.e;
import b.g.a.g;
import b.g.a.h.c;
import java.util.ArrayList;

public class d {
    public c[] A;
    public ArrayList<c> B;
    public a[] C;
    public d D;
    public int E;
    public int F;
    public float G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public float V;
    public float W;
    public Object X;
    public int Y;
    public String Z;

    /* renamed from: a  reason: collision with root package name */
    public int f910a = -1;
    public String a0;

    /* renamed from: b  reason: collision with root package name */
    public int f911b = -1;
    public boolean b0;

    /* renamed from: c  reason: collision with root package name */
    public k f912c;
    public boolean c0;

    /* renamed from: d  reason: collision with root package name */
    public k f913d;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public int f914e = 0;
    public int e0;
    public int f = 0;
    public int f0;
    public int[] g = new int[2];
    public float[] g0;
    public int h = 0;
    public d[] h0;
    public int i = 0;
    public d[] i0;
    public float j = 1.0f;
    public int k = 0;
    public int l = 0;
    public float m = 1.0f;
    public int n = -1;
    public float o = 1.0f;
    public f p = null;
    public int[] q = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float r = 0.0f;
    public c s = new c(this, c.b.LEFT);
    public c t = new c(this, c.b.TOP);
    public c u = new c(this, c.b.RIGHT);
    public c v = new c(this, c.b.BOTTOM);
    public c w = new c(this, c.b.BASELINE);
    public c x = new c(this, c.b.CENTER_X);
    public c y = new c(this, c.b.CENTER_Y);
    public c z;

    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public d() {
        c cVar = new c(this, c.b.CENTER);
        this.z = cVar;
        this.A = new c[]{this.s, this.u, this.t, this.v, this.w, cVar};
        ArrayList<c> arrayList = new ArrayList<>();
        this.B = arrayList;
        a aVar = a.FIXED;
        this.C = new a[]{aVar, aVar};
        this.D = null;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.V = 0.5f;
        this.W = 0.5f;
        this.Y = 0;
        this.Z = null;
        this.a0 = null;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = new float[]{-1.0f, -1.0f};
        this.h0 = new d[]{null, null};
        this.i0 = new d[]{null, null};
        arrayList.add(this.s);
        this.B.add(this.t);
        this.B.add(this.u);
        this.B.add(this.v);
        this.B.add(this.x);
        this.B.add(this.y);
        this.B.add(this.z);
        this.B.add(this.w);
    }

    public void A(int i2, int i3) {
        this.J = i2;
        int i4 = i3 - i2;
        this.F = i4;
        int i5 = this.S;
        if (i4 < i5) {
            this.F = i5;
        }
    }

    public void B(a aVar) {
        this.C[1] = aVar;
        if (aVar == a.WRAP_CONTENT) {
            w(this.U);
        }
    }

    public void C(int i2) {
        this.E = i2;
        int i3 = this.R;
        if (i2 < i3) {
            this.E = i3;
        }
    }

    public void D() {
        int i2 = this.I;
        int i3 = this.J;
        this.M = i2;
        this.N = i3;
    }

    public void E(e eVar) {
        int i2;
        int i3;
        int o2 = eVar.o(this.s);
        int o3 = eVar.o(this.t);
        int o4 = eVar.o(this.u);
        int o5 = eVar.o(this.v);
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
        this.I = o2;
        this.J = o3;
        if (this.Y == 8) {
            this.E = 0;
            this.F = 0;
            return;
        }
        if (this.C[0] == aVar && i5 < (i3 = this.E)) {
            i5 = i3;
        }
        if (this.C[1] == aVar && i6 < (i2 = this.F)) {
            i6 = i2;
        }
        this.E = i5;
        this.F = i6;
        int i7 = this.S;
        if (i6 < i7) {
            this.F = i7;
        }
        int i8 = this.E;
        int i9 = this.R;
        if (i8 < i9) {
            this.E = i9;
        }
        this.c0 = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x034f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0415  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x041f  */
    /* JADX WARNING: Removed duplicated region for block: B:259:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007a  */
    public void a(e eVar) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i2;
        int i3;
        boolean z6;
        int i4;
        int i5;
        char c2;
        boolean z7;
        a aVar;
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        boolean z8;
        e eVar2;
        g gVar5;
        d dVar;
        g gVar6;
        g gVar7;
        g gVar8;
        g gVar9;
        e eVar3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z9;
        boolean z10;
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        a aVar2 = a.WRAP_CONTENT;
        a aVar3 = a.MATCH_CONSTRAINT;
        g l2 = eVar.l(this.s);
        g l3 = eVar.l(this.u);
        g l4 = eVar.l(this.t);
        g l5 = eVar.l(this.v);
        g l6 = eVar.l(this.w);
        d dVar2 = this.D;
        if (dVar2 != null) {
            boolean z11 = dVar2 != null && dVar2.C[0] == aVar2;
            d dVar3 = this.D;
            boolean z12 = dVar3 != null && dVar3.C[1] == aVar2;
            if (p(0)) {
                ((e) this.D).G(this, 0);
            } else {
                c cVar5 = this.s;
                c cVar6 = cVar5.f900d;
                if ((cVar6 == null || cVar6.f900d != cVar5) && ((cVar4 = (cVar3 = this.u).f900d) == null || cVar4.f900d != cVar3)) {
                    z9 = false;
                    if (!p(1)) {
                        ((e) this.D).G(this, 1);
                    } else {
                        c cVar7 = this.t;
                        c cVar8 = cVar7.f900d;
                        if ((cVar8 == null || cVar8.f900d != cVar7) && ((cVar2 = (cVar = this.v).f900d) == null || cVar2.f900d != cVar)) {
                            z10 = false;
                            if (z11 && this.Y != 8 && this.s.f900d == null && this.u.f900d == null) {
                                eVar.f(eVar.l(this.D.u), l3, 0, 1);
                            }
                            if (z12 && this.Y != 8 && this.t.f900d == null && this.v.f900d == null && this.w == null) {
                                eVar.f(eVar.l(this.D.v), l5, 0, 1);
                            }
                            z5 = z11;
                            z3 = z12;
                            z4 = z9;
                            z2 = z10;
                        }
                    }
                    z10 = true;
                    eVar.f(eVar.l(this.D.u), l3, 0, 1);
                    eVar.f(eVar.l(this.D.v), l5, 0, 1);
                    z5 = z11;
                    z3 = z12;
                    z4 = z9;
                    z2 = z10;
                }
            }
            z9 = true;
            if (!p(1)) {
            }
            z10 = true;
            eVar.f(eVar.l(this.D.u), l3, 0, 1);
            eVar.f(eVar.l(this.D.v), l5, 0, 1);
            z5 = z11;
            z3 = z12;
            z4 = z9;
            z2 = z10;
        } else {
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
        }
        int i11 = this.E;
        int i12 = this.R;
        if (i11 < i12) {
            i11 = i12;
        }
        int i13 = this.F;
        int i14 = this.S;
        if (i13 < i14) {
            i13 = i14;
        }
        boolean z13 = this.C[0] != aVar3;
        boolean z14 = this.C[1] != aVar3;
        this.n = this.H;
        float f2 = this.G;
        this.o = f2;
        int i15 = this.f914e;
        int i16 = this.f;
        if (f2 <= 0.0f || this.Y == 8) {
            c2 = 0;
            i5 = i11;
            i4 = i13;
            i2 = i16;
            i3 = i15;
            z6 = false;
        } else {
            if (this.C[0] == aVar3 && i15 == 0) {
                i15 = 3;
            }
            if (this.C[1] == aVar3 && i16 == 0) {
                i16 = 3;
            }
            a[] aVarArr = this.C;
            if (aVarArr[0] == aVar3 && aVarArr[1] == aVar3 && i15 == 3 && i16 == 3) {
                if (this.n == -1) {
                    if (z13 && !z14) {
                        this.n = 0;
                    } else if (!z13 && z14) {
                        this.n = 1;
                        if (this.H == -1) {
                            this.o = 1.0f / this.o;
                        }
                    }
                }
                if (this.n != 0 || (this.t.c() && this.v.c())) {
                    if (this.n == 1 && (!this.s.c() || !this.u.c())) {
                        i10 = 0;
                    }
                    if (this.n == -1 && (!this.t.c() || !this.v.c() || !this.s.c() || !this.u.c())) {
                        if (!this.t.c() && this.v.c()) {
                            i9 = 0;
                        } else if (this.s.c() && this.u.c()) {
                            this.o = 1.0f / this.o;
                            i9 = 1;
                        }
                        this.n = i9;
                    }
                    if (this.n == -1) {
                        if (z5 && !z3) {
                            i8 = 0;
                        } else if (!z5 && z3) {
                            this.o = 1.0f / this.o;
                            i8 = 1;
                        }
                        this.n = i8;
                    }
                    if (this.n == -1) {
                        if (this.h > 0 && this.k == 0) {
                            i7 = 0;
                        } else if (this.h == 0 && this.k > 0) {
                            this.o = 1.0f / this.o;
                            i7 = 1;
                        }
                        this.n = i7;
                    }
                    if (this.n == -1 && z5 && z3) {
                        this.o = 1.0f / this.o;
                        this.n = 1;
                    }
                } else {
                    i10 = 1;
                }
                this.n = i10;
                if (!this.t.c()) {
                }
                this.o = 1.0f / this.o;
                i9 = 1;
                this.n = i9;
                if (this.n == -1) {
                }
                if (this.n == -1) {
                }
                this.o = 1.0f / this.o;
                this.n = 1;
            } else {
                a[] aVarArr2 = this.C;
                if (aVarArr2[0] == aVar3 && i15 == 3) {
                    this.n = 0;
                    a aVar4 = aVarArr2[1];
                    i5 = (int) (this.o * ((float) this.F));
                    i4 = i13;
                    if (aVar4 != aVar3) {
                        i2 = i16;
                        i3 = 4;
                        c2 = 0;
                        z6 = false;
                    } else {
                        z6 = true;
                        i2 = i16;
                        i3 = i15;
                        c2 = 0;
                    }
                } else if (this.C[1] == aVar3 && i16 == 3) {
                    this.n = 1;
                    if (this.H == -1) {
                        this.o = 1.0f / this.o;
                    }
                    c2 = 0;
                    a aVar5 = this.C[0];
                    i5 = i11;
                    i4 = (int) (this.o * ((float) this.E));
                    if (aVar5 != aVar3) {
                        i3 = i15;
                        z6 = false;
                        i2 = 4;
                    }
                    i2 = i16;
                    i3 = i15;
                    z6 = true;
                }
            }
            c2 = 0;
            i5 = i11;
            i4 = i13;
            i2 = i16;
            i3 = i15;
            z6 = true;
        }
        int[] iArr = this.g;
        iArr[c2] = i3;
        iArr[1] = i2;
        if (z6) {
            int i17 = this.n;
            if (i17 == 0 || i17 == -1) {
                z7 = true;
                boolean z15 = this.C[0] != aVar2 && (this instanceof e);
                boolean z16 = !this.z.c();
                if (this.f910a == 2) {
                    d dVar4 = this.D;
                    g l7 = dVar4 != null ? eVar.l(dVar4.u) : null;
                    d dVar5 = this.D;
                    gVar3 = l6;
                    gVar2 = l5;
                    gVar = l4;
                    gVar4 = l3;
                    aVar = aVar2;
                    d(eVar, z5, dVar5 != null ? eVar.l(dVar5.s) : null, l7, this.C[0], z15, this.s, this.u, this.I, i5, this.R, this.q[0], this.V, z7, z4, i3, this.h, this.i, this.j, z16);
                } else {
                    gVar3 = l6;
                    gVar2 = l5;
                    gVar = l4;
                    gVar4 = l3;
                    aVar = aVar2;
                }
                if (this.f911b == 2) {
                    boolean z17 = this.C[1] == aVar && (this instanceof e);
                    boolean z18 = z6 && ((i6 = this.n) == 1 || i6 == -1);
                    int i18 = this.Q;
                    if (i18 > 0) {
                        j jVar = this.w.f897a;
                        eVar2 = eVar;
                        if (jVar.f930b == 1) {
                            jVar.e(eVar2);
                        } else {
                            gVar5 = gVar;
                            eVar2.d(gVar3, gVar5, i18, 6);
                            c cVar9 = this.w.f900d;
                            if (cVar9 != null) {
                                eVar2.d(gVar3, eVar2.l(cVar9), 0, 6);
                                z8 = false;
                                d dVar6 = this.D;
                                g l8 = dVar6 != null ? eVar2.l(dVar6.v) : null;
                                d dVar7 = this.D;
                                d(eVar, z3, dVar7 != null ? eVar2.l(dVar7.t) : null, l8, this.C[1], z17, this.t, this.v, this.J, i4, this.S, this.q[1], this.W, z18, z2, i2, this.k, this.l, this.m, z8);
                                if (z6) {
                                    int i19 = 6;
                                    dVar = this;
                                    int i20 = dVar.n;
                                    float f3 = dVar.o;
                                    if (i20 == 1) {
                                        eVar3 = eVar;
                                        gVar9 = gVar2;
                                        gVar8 = gVar5;
                                        gVar7 = gVar4;
                                        gVar6 = l2;
                                    } else {
                                        i19 = 6;
                                        eVar3 = eVar;
                                        gVar9 = gVar4;
                                        gVar8 = l2;
                                        gVar7 = gVar2;
                                        gVar6 = gVar5;
                                    }
                                    eVar3.h(gVar9, gVar8, gVar7, gVar6, f3, i19);
                                } else {
                                    dVar = this;
                                }
                                if (dVar.z.c()) {
                                    d dVar8 = dVar.z.f900d.f898b;
                                    int b2 = dVar.z.b();
                                    c.b bVar = c.b.BOTTOM;
                                    c.b bVar2 = c.b.RIGHT;
                                    c.b bVar3 = c.b.TOP;
                                    c.b bVar4 = c.b.LEFT;
                                    g l9 = eVar.l(dVar.f(bVar4));
                                    g l10 = eVar.l(dVar.f(bVar3));
                                    g l11 = eVar.l(dVar.f(bVar2));
                                    g l12 = eVar.l(dVar.f(bVar));
                                    g l13 = eVar.l(dVar8.f(bVar4));
                                    g l14 = eVar.l(dVar8.f(bVar3));
                                    g l15 = eVar.l(dVar8.f(bVar2));
                                    g l16 = eVar.l(dVar8.f(bVar));
                                    b m2 = eVar.m();
                                    double radians = (double) ((float) Math.toRadians((double) (dVar.r + 90.0f)));
                                    double d2 = (double) b2;
                                    m2.f(l10, l12, l14, l16, (float) (Math.sin(radians) * d2));
                                    eVar.c(m2);
                                    b m3 = eVar.m();
                                    m3.f(l9, l11, l13, l15, (float) (Math.cos(radians) * d2));
                                    eVar.c(m3);
                                    return;
                                }
                                return;
                            }
                            z8 = z16;
                            d dVar62 = this.D;
                            if (dVar62 != null) {
                            }
                            d dVar72 = this.D;
                            d(eVar, z3, dVar72 != null ? eVar2.l(dVar72.t) : null, l8, this.C[1], z17, this.t, this.v, this.J, i4, this.S, this.q[1], this.W, z18, z2, i2, this.k, this.l, this.m, z8);
                            if (z6) {
                            }
                            if (dVar.z.c()) {
                            }
                        }
                    } else {
                        eVar2 = eVar;
                    }
                    gVar5 = gVar;
                    z8 = z16;
                    d dVar622 = this.D;
                    if (dVar622 != null) {
                    }
                    d dVar722 = this.D;
                    d(eVar, z3, dVar722 != null ? eVar2.l(dVar722.t) : null, l8, this.C[1], z17, this.t, this.v, this.J, i4, this.S, this.q[1], this.W, z18, z2, i2, this.k, this.l, this.m, z8);
                    if (z6) {
                    }
                    if (dVar.z.c()) {
                    }
                } else {
                    return;
                }
            }
        }
        z7 = false;
        if (this.C[0] != aVar2) {
        }
        boolean z162 = !this.z.c();
        if (this.f910a == 2) {
        }
        if (this.f911b == 2) {
        }
    }

    public boolean b() {
        return this.Y != 8;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01e3, code lost:
        if (r10 != false) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01f2, code lost:
        if (r10 != false) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01fd, code lost:
        r8.f926d = r5;
        r8.f927e = (float) r1;
        r5.f929a.add(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0097, code lost:
        if (r10 != false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a7, code lost:
        if (r10 != false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b7, code lost:
        if (r10 != false) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0104, code lost:
        if (r10 != false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0117, code lost:
        if (r10 != false) goto L_0x0119;
     */
    public void c(int i2) {
        int i3;
        int i4;
        a aVar = a.FIXED;
        a aVar2 = a.MATCH_CONSTRAINT;
        boolean z2 = false;
        for (int i5 = 0; i5 < 6; i5++) {
            j jVar = this.A[i5].f897a;
            c cVar = jVar.f925c;
            c cVar2 = cVar.f900d;
            if (cVar2 != null) {
                if (cVar2.f900d == cVar) {
                    jVar.h = 4;
                    cVar2.f897a.h = 4;
                }
                int b2 = jVar.f925c.b();
                c.b bVar = jVar.f925c.f899c;
                if (bVar == c.b.RIGHT || bVar == c.b.BOTTOM) {
                    b2 = -b2;
                }
                jVar.g(cVar2.f897a, b2);
            }
        }
        j jVar2 = this.s.f897a;
        j jVar3 = this.t.f897a;
        j jVar4 = this.u.f897a;
        j jVar5 = this.v.f897a;
        boolean z3 = (i2 & 8) == 8;
        boolean z4 = this.C[0] == aVar2 && i.a(this, 0);
        if (!(jVar2.h == 4 || jVar4.h == 4)) {
            if (this.C[0] == aVar || (z4 && this.Y == 8)) {
                if (this.s.f900d == null && this.u.f900d == null) {
                    jVar2.h = 1;
                    jVar4.h = 1;
                } else if (this.s.f900d != null && this.u.f900d == null) {
                    jVar2.h = 1;
                    jVar4.h = 1;
                } else if (this.s.f900d == null && this.u.f900d != null) {
                    jVar2.h = 1;
                    jVar4.h = 1;
                    jVar2.f926d = jVar4;
                    jVar2.f927e = (float) (-n());
                    jVar4.f929a.add(jVar2);
                    if (!z3) {
                        i4 = n();
                        jVar2.f926d = jVar4;
                        jVar2.f927e = (float) (-i4);
                        jVar4.f929a.add(jVar2);
                    }
                    jVar2.h(jVar4, -1, l());
                } else if (!(this.s.f900d == null || this.u.f900d == null)) {
                    jVar2.h = 2;
                    jVar4.h = 2;
                    if (z3) {
                        l().f929a.add(jVar2);
                        l().f929a.add(jVar4);
                        k l2 = l();
                        jVar2.i = jVar4;
                        jVar2.l = l2;
                        jVar2.m = -1;
                        k l3 = l();
                        jVar4.i = jVar2;
                        jVar4.l = l3;
                        jVar4.m = 1;
                    }
                    jVar2.i = jVar4;
                    jVar4.i = jVar2;
                }
                i4 = n();
                jVar4.f926d = jVar2;
                jVar4.f927e = (float) i4;
                jVar2.f929a.add(jVar4);
            } else if (z4) {
                i4 = n();
                jVar2.h = 1;
                jVar4.h = 1;
                if (this.s.f900d != null || this.u.f900d != null) {
                    if (this.s.f900d == null || this.u.f900d != null) {
                        if (this.s.f900d != null || this.u.f900d == null) {
                            if (!(this.s.f900d == null || this.u.f900d == null)) {
                                if (z3) {
                                    l().f929a.add(jVar2);
                                    l().f929a.add(jVar4);
                                }
                                if (this.G == 0.0f) {
                                    jVar2.h = 3;
                                    jVar4.h = 3;
                                    jVar2.i = jVar4;
                                    jVar4.i = jVar2;
                                } else {
                                    jVar2.h = 2;
                                    jVar4.h = 2;
                                    jVar2.i = jVar4;
                                    jVar4.i = jVar2;
                                    C(i4);
                                }
                            }
                        }
                    }
                }
            }
            jVar4.h(jVar2, 1, l());
        }
        if (this.C[1] == aVar2 && i.a(this, 1)) {
            z2 = true;
        }
        if (!(jVar3.h == 4 || jVar5.h == 4)) {
            if (this.C[1] == aVar || (z2 && this.Y == 8)) {
                if (this.t.f900d == null && this.v.f900d == null) {
                    jVar3.h = 1;
                    jVar5.h = 1;
                    if (z3) {
                        jVar5.h(jVar3, 1, k());
                    } else {
                        int h2 = h();
                        jVar5.f926d = jVar3;
                        jVar5.f927e = (float) h2;
                        jVar3.f929a.add(jVar5);
                    }
                    c cVar3 = this.w;
                    if (cVar3.f900d != null) {
                        j jVar6 = cVar3.f897a;
                        jVar6.h = 1;
                        jVar3.f(1, jVar6, -this.Q);
                        return;
                    }
                    return;
                } else if (this.t.f900d != null && this.v.f900d == null) {
                    jVar3.h = 1;
                    jVar5.h = 1;
                    if (z3) {
                        jVar5.h(jVar3, 1, k());
                    } else {
                        int h3 = h();
                        jVar5.f926d = jVar3;
                        jVar5.f927e = (float) h3;
                        jVar3.f929a.add(jVar5);
                    }
                    i3 = this.Q;
                    if (i3 <= 0) {
                        return;
                    }
                } else if (this.t.f900d == null && this.v.f900d != null) {
                    jVar3.h = 1;
                    jVar5.h = 1;
                    if (z3) {
                        jVar3.h(jVar5, -1, k());
                    } else {
                        jVar3.f926d = jVar5;
                        jVar3.f927e = (float) (-h());
                        jVar5.f929a.add(jVar3);
                    }
                    i3 = this.Q;
                    if (i3 <= 0) {
                        return;
                    }
                } else if (this.t.f900d != null && this.v.f900d != null) {
                    jVar3.h = 2;
                    jVar5.h = 2;
                    if (z3) {
                        k k2 = k();
                        jVar3.i = jVar5;
                        jVar3.l = k2;
                        jVar3.m = -1;
                        k k3 = k();
                        jVar5.i = jVar3;
                        jVar5.l = k3;
                        jVar5.m = 1;
                        k().f929a.add(jVar3);
                        l().f929a.add(jVar5);
                    } else {
                        jVar3.i = jVar5;
                        jVar5.i = jVar3;
                    }
                    i3 = this.Q;
                    if (i3 <= 0) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (z2) {
                int h4 = h();
                jVar3.h = 1;
                jVar5.h = 1;
                if (this.t.f900d != null || this.v.f900d != null) {
                    if (this.t.f900d == null || this.v.f900d != null) {
                        if (this.t.f900d != null || this.v.f900d == null) {
                            if (this.t.f900d != null && this.v.f900d != null) {
                                if (z3) {
                                    k().f929a.add(jVar3);
                                    l().f929a.add(jVar5);
                                }
                                if (this.G == 0.0f) {
                                    jVar3.h = 3;
                                    jVar5.h = 3;
                                    jVar3.i = jVar5;
                                    jVar5.i = jVar3;
                                    return;
                                }
                                jVar3.h = 2;
                                jVar5.h = 2;
                                jVar3.i = jVar5;
                                jVar5.i = jVar3;
                                w(h4);
                                i3 = this.Q;
                                if (i3 <= 0) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else if (z3) {
                            jVar3.h(jVar5, -1, k());
                            return;
                        } else {
                            jVar3.f926d = jVar5;
                            jVar3.f927e = (float) (-h4);
                            jVar5.f929a.add(jVar3);
                            return;
                        }
                    }
                }
                jVar5.h(jVar3, 1, k());
                return;
            } else {
                return;
            }
            this.w.f897a.f(1, jVar3, i3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0196, code lost:
        if (r27 != false) goto L_0x01a4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d6  */
    public final void d(e eVar, boolean z2, g gVar, g gVar2, a aVar, boolean z3, c cVar, c cVar2, int i2, int i3, int i4, int i5, float f2, boolean z4, boolean z5, int i6, int i7, int i8, float f3, boolean z6) {
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z7;
        int i13;
        int i14;
        boolean z8;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        g gVar3;
        int i21;
        int i22;
        int i23;
        int i24;
        g gVar4;
        g gVar5;
        g gVar6;
        g gVar7;
        int i25;
        boolean z9;
        int i26;
        boolean z10;
        int i27;
        int i28;
        int i29;
        int i30;
        c cVar3;
        g gVar8;
        c.b bVar = c.b.BOTTOM;
        c.b bVar2 = c.b.TOP;
        g l2 = eVar.l(cVar);
        g l3 = eVar.l(cVar2);
        g l4 = eVar.l(cVar.f900d);
        g l5 = eVar.l(cVar2.f900d);
        if (eVar.g) {
            j jVar = cVar.f897a;
            if (jVar.f930b == 1 && cVar2.f897a.f930b == 1) {
                jVar.e(eVar);
                cVar2.f897a.e(eVar);
                if (!z5 && z2) {
                    eVar.f(gVar2, l3, 0, 6);
                    return;
                }
                return;
            }
        }
        boolean c2 = cVar.c();
        boolean c3 = cVar2.c();
        boolean c4 = this.z.c();
        if (c3) {
            i9 = (c2 ? 1 : 0) + 1;
        } else {
            i9 = c2 ? 1 : 0;
        }
        if (c4) {
            i9++;
        }
        if (z4) {
            i10 = i9;
            i11 = 3;
        } else {
            i11 = i6;
            i10 = i9;
        }
        int ordinal = aVar.ordinal();
        boolean z11 = (ordinal == 0 || ordinal == 1 || ordinal != 2 || i11 == 4) ? false : true;
        if (this.Y == 8) {
            i12 = 0;
            z11 = false;
        } else {
            i12 = i3;
        }
        if (z6) {
            if (!c2 && !c3 && !c4) {
                eVar.e(l2, i2);
            } else if (c2 && !c3) {
                z7 = c3;
                i13 = 6;
                eVar.d(l2, l4, cVar.b(), 6);
                if (z11) {
                    if (z3) {
                        eVar.d(l3, l2, 0, 3);
                        if (i4 > 0) {
                            eVar.f(l3, l2, i4, i13);
                        }
                        if (i5 < Integer.MAX_VALUE) {
                            eVar.g(l3, l2, i5, i13);
                        }
                    } else {
                        eVar.d(l3, l2, i12, i13);
                    }
                    i16 = i7;
                    i18 = i8;
                    z8 = z11;
                    i17 = i10;
                    i15 = 1;
                    i14 = 4;
                } else {
                    int i31 = i7;
                    i18 = i8;
                    if (i31 == -2) {
                        i31 = i12;
                    }
                    if (i18 == -2) {
                        i18 = i12;
                    }
                    if (i31 > 0) {
                        eVar.f(l3, l2, i31, 6);
                        i12 = Math.max(i12, i31);
                    }
                    if (i18 > 0) {
                        eVar.g(l3, l2, i18, 6);
                        i12 = Math.min(i12, i18);
                    }
                    if (i11 == 1) {
                        if (z2) {
                            eVar.d(l3, l2, i12, 6);
                            z8 = z11;
                            i16 = i31;
                            i17 = i10;
                            i14 = 4;
                        } else {
                            if (z5) {
                                eVar.d(l3, l2, i12, 4);
                            } else {
                                eVar.d(l3, l2, i12, 1);
                            }
                            i14 = 4;
                            z8 = z11;
                            i16 = i31;
                            i17 = i10;
                        }
                        i15 = 1;
                    } else {
                        i14 = 4;
                        if (i11 == 2) {
                            c.b bVar3 = cVar.f899c;
                            if (bVar3 == bVar2 || bVar3 == bVar) {
                                gVar8 = eVar.l(this.D.f(bVar2));
                                cVar3 = this.D.f(bVar);
                            } else {
                                gVar8 = eVar.l(this.D.f(c.b.LEFT));
                                cVar3 = this.D.f(c.b.RIGHT);
                            }
                            g l6 = eVar.l(cVar3);
                            b m2 = eVar.m();
                            i16 = i31;
                            i17 = i10;
                            m2.c(l3, l2, l6, gVar8, f3);
                            eVar.c(m2);
                            i15 = 1;
                            z8 = false;
                        } else {
                            z8 = z11;
                            i16 = i31;
                            i17 = i10;
                            i15 = 1;
                        }
                    }
                    if (z8 && i17 != 2 && !z4) {
                        int max = Math.max(i16, i12);
                        if (i18 > 0) {
                            max = Math.min(i18, max);
                        }
                        eVar.d(l3, l2, max, 6);
                        z8 = false;
                    }
                }
                if (!z6 && !z5) {
                    if (c2 || z7 || c4) {
                        if (!c2 || z7) {
                            i21 = 0;
                            if (c2 || !z7) {
                                if (c2 && z7) {
                                    if (z8) {
                                        if (z2 && i4 == 0) {
                                            eVar.f(l3, l2, 0, 6);
                                        }
                                        if (i11 == 0) {
                                            if (i18 > 0 || i16 > 0) {
                                                i29 = i15;
                                                i30 = i14;
                                            } else {
                                                i30 = 6;
                                                i29 = 0;
                                            }
                                            eVar.d(l2, l4, cVar.b(), i30);
                                            eVar.d(l3, l5, -cVar2.b(), i30);
                                            i24 = (i18 > 0 || i16 > 0) ? i15 : 0;
                                            i22 = i29;
                                            i23 = 5;
                                        } else {
                                            if (i11 == i15) {
                                                i28 = 6;
                                            } else if (i11 == 3) {
                                                int i32 = (z4 || this.n == -1 || i18 > 0) ? i14 : 6;
                                                eVar.d(l2, l4, cVar.b(), i32);
                                                eVar.d(l3, l5, -cVar2.b(), i32);
                                                i28 = 5;
                                            } else {
                                                i28 = 5;
                                                i27 = 0;
                                                i23 = i28;
                                                i24 = i27;
                                                i22 = i24;
                                            }
                                            i27 = i15;
                                            i23 = i28;
                                            i24 = i27;
                                            i22 = i24;
                                        }
                                    } else {
                                        i23 = 5;
                                        i24 = i15;
                                        i22 = 0;
                                    }
                                    if (i24 != 0) {
                                        gVar5 = gVar;
                                        gVar4 = l5;
                                        gVar7 = l4;
                                        gVar3 = l3;
                                        gVar6 = l2;
                                        eVar.b(l2, l4, cVar.b(), f2, gVar4, l3, cVar2.b(), i23);
                                        boolean z12 = cVar.f900d.f898b instanceof a;
                                        boolean z13 = cVar2.f900d.f898b instanceof a;
                                        if (z12 && !z13) {
                                            z10 = z2;
                                            i26 = 5;
                                            z9 = true;
                                            i25 = 6;
                                            if (i22 != 0) {
                                            }
                                            eVar.f(gVar6, gVar7, cVar.b(), i26);
                                            eVar.g(gVar3, gVar4, -cVar2.b(), i25);
                                            i20 = 0;
                                            i19 = 6;
                                            if (z2) {
                                            }
                                            if (z2) {
                                            }
                                        } else if (!z12 && z13) {
                                            z10 = true;
                                            i26 = 6;
                                            z9 = z2;
                                            i25 = 5;
                                            if (i22 != 0) {
                                                i26 = 6;
                                                i25 = 6;
                                            }
                                            if ((!z8 && z10) || i22 != 0) {
                                                eVar.f(gVar6, gVar7, cVar.b(), i26);
                                            }
                                            if ((!z8 && z9) || i22 != 0) {
                                                eVar.g(gVar3, gVar4, -cVar2.b(), i25);
                                            }
                                            i20 = 0;
                                            i19 = 6;
                                            if (z2) {
                                                eVar.f(gVar6, gVar5, 0, 6);
                                            }
                                            if (z2) {
                                                eVar.f(gVar2, gVar3, i20, i19);
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        gVar5 = gVar;
                                        gVar4 = l5;
                                        gVar7 = l4;
                                        gVar3 = l3;
                                        gVar6 = l2;
                                    }
                                    z10 = z2;
                                    i26 = 5;
                                    z9 = z2;
                                    i25 = 5;
                                    if (i22 != 0) {
                                    }
                                    eVar.f(gVar6, gVar7, cVar.b(), i26);
                                    eVar.g(gVar3, gVar4, -cVar2.b(), i25);
                                    i20 = 0;
                                    i19 = 6;
                                    if (z2) {
                                    }
                                    if (z2) {
                                    }
                                }
                                i20 = i21;
                                gVar3 = l3;
                                i19 = 6;
                                if (z2) {
                                }
                            } else {
                                eVar.d(l3, l5, -cVar2.b(), 6);
                                if (z2) {
                                    eVar.f(l2, gVar, 0, 5);
                                }
                                i20 = i21;
                                gVar3 = l3;
                                i19 = 6;
                                if (z2) {
                                }
                            }
                        } else {
                            if (!z2) {
                            }
                            i21 = 0;
                            eVar.f(gVar2, l3, 0, 5);
                            i20 = i21;
                            gVar3 = l3;
                            i19 = 6;
                            if (z2) {
                            }
                        }
                    }
                    gVar3 = l3;
                    i20 = 0;
                    i19 = 6;
                    if (z2) {
                    }
                } else if (i17 < 2 && z2) {
                    eVar.f(l2, gVar, 0, 6);
                    eVar.f(gVar2, l3, 0, 6);
                    return;
                }
            }
        }
        z7 = c3;
        i13 = 6;
        if (z11) {
        }
        if (!z6) {
        }
        if (i17 < 2) {
        }
    }

    public void e(e eVar) {
        eVar.l(this.s);
        eVar.l(this.t);
        eVar.l(this.u);
        eVar.l(this.v);
        if (this.Q > 0) {
            eVar.l(this.w);
        }
    }

    public c f(c.b bVar) {
        switch (bVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.s;
            case 2:
                return this.t;
            case 3:
                return this.u;
            case 4:
                return this.v;
            case 5:
                return this.w;
            case 6:
                return this.z;
            case 7:
                return this.x;
            case 8:
                return this.y;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public a g(int i2) {
        if (i2 == 0) {
            return i();
        }
        if (i2 == 1) {
            return m();
        }
        return null;
    }

    public int h() {
        if (this.Y == 8) {
            return 0;
        }
        return this.F;
    }

    public a i() {
        return this.C[0];
    }

    public int j(int i2) {
        if (i2 == 0) {
            return n();
        }
        if (i2 == 1) {
            return h();
        }
        return 0;
    }

    public k k() {
        if (this.f913d == null) {
            this.f913d = new k();
        }
        return this.f913d;
    }

    public k l() {
        if (this.f912c == null) {
            this.f912c = new k();
        }
        return this.f912c;
    }

    public a m() {
        return this.C[1];
    }

    public int n() {
        if (this.Y == 8) {
            return 0;
        }
        return this.E;
    }

    public void o(c.b bVar, d dVar, c.b bVar2, int i2, int i3) {
        f(bVar).a(dVar.f(bVar2), i2, i3, c.a.STRONG, 0, true);
    }

    public final boolean p(int i2) {
        int i3 = i2 * 2;
        c[] cVarArr = this.A;
        if (!(cVarArr[i3].f900d == null || cVarArr[i3].f900d.f900d == cVarArr[i3])) {
            int i4 = i3 + 1;
            return cVarArr[i4].f900d != null && cVarArr[i4].f900d.f900d == cVarArr[i4];
        }
    }

    public boolean q() {
        if (this.s.f897a.f930b == 1 && this.u.f897a.f930b == 1 && this.t.f897a.f930b == 1 && this.v.f897a.f930b == 1) {
            return true;
        }
        return false;
    }

    public void r() {
        this.s.d();
        this.t.d();
        this.u.d();
        this.v.d();
        this.w.d();
        this.x.d();
        this.y.d();
        this.z.d();
        this.D = null;
        this.r = 0.0f;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0.5f;
        this.W = 0.5f;
        a[] aVarArr = this.C;
        a aVar = a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.X = null;
        this.Y = 0;
        this.a0 = null;
        this.e0 = 0;
        this.f0 = 0;
        float[] fArr = this.g0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f910a = -1;
        this.f911b = -1;
        int[] iArr = this.q;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f914e = 0;
        this.f = 0;
        this.j = 1.0f;
        this.m = 1.0f;
        this.i = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.h = 0;
        this.k = 0;
        this.n = -1;
        this.o = 1.0f;
        k kVar = this.f912c;
        if (kVar != null) {
            kVar.f930b = 0;
            kVar.f929a.clear();
            kVar.f928c = 0.0f;
        }
        k kVar2 = this.f913d;
        if (kVar2 != null) {
            kVar2.f930b = 0;
            kVar2.f929a.clear();
            kVar2.f928c = 0.0f;
        }
        this.p = null;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
    }

    public void s() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.A[i2].f897a.i();
        }
    }

    public void t(b.g.a.c cVar) {
        this.s.e();
        this.t.e();
        this.u.e();
        this.v.e();
        this.w.e();
        this.z.e();
        this.x.e();
        this.y.e();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.a0 != null) {
            StringBuilder g2 = c.a.a.a.a.g("type: ");
            g2.append(this.a0);
            g2.append(" ");
            str = g2.toString();
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.Z != null) {
            StringBuilder g3 = c.a.a.a.a.g("id: ");
            g3.append(this.Z);
            g3.append(" ");
            str2 = g3.toString();
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.I);
        sb.append(", ");
        sb.append(this.J);
        sb.append(") - (");
        sb.append(this.E);
        sb.append(" x ");
        sb.append(this.F);
        sb.append(") wrap: (");
        sb.append(this.T);
        sb.append(" x ");
        sb.append(this.U);
        sb.append(")");
        return sb.toString();
    }

    public void u() {
    }

    public void v(int i2, int i3, int i4) {
        if (i4 == 0) {
            this.I = i2;
            int i5 = i3 - i2;
            this.E = i5;
            int i6 = this.R;
            if (i5 < i6) {
                this.E = i6;
            }
        } else if (i4 == 1) {
            this.J = i2;
            int i7 = i3 - i2;
            this.F = i7;
            int i8 = this.S;
            if (i7 < i8) {
                this.F = i8;
            }
        }
        this.c0 = true;
    }

    public void w(int i2) {
        this.F = i2;
        int i3 = this.S;
        if (i2 < i3) {
            this.F = i3;
        }
    }

    public void x(int i2, int i3) {
        this.I = i2;
        int i4 = i3 - i2;
        this.E = i4;
        int i5 = this.R;
        if (i4 < i5) {
            this.E = i5;
        }
    }

    public void y(a aVar) {
        this.C[0] = aVar;
        if (aVar == a.WRAP_CONTENT) {
            C(this.T);
        }
    }

    public void z(int i2, int i3) {
        this.O = i2;
        this.P = i3;
    }
}
