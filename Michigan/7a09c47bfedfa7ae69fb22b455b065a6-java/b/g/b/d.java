package b.g.b;

import b.g.b.g;
import b.g.b.h.c;
import java.util.Arrays;
import java.util.HashMap;

public class d {
    public static int q = 1000;

    /* renamed from: a  reason: collision with root package name */
    public int f1466a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, g> f1467b;

    /* renamed from: c  reason: collision with root package name */
    public a f1468c;

    /* renamed from: d  reason: collision with root package name */
    public int f1469d;

    /* renamed from: e  reason: collision with root package name */
    public int f1470e;

    /* renamed from: f  reason: collision with root package name */
    public b[] f1471f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1472g;
    public boolean h;
    public boolean[] i;
    public int j;
    public int k;
    public int l;
    public final c m;
    public g[] n;
    public int o;
    public final a p;

    public interface a {
        void a(g gVar);

        g b(d dVar, boolean[] zArr);

        void clear();
    }

    public d() {
        this.f1466a = 0;
        this.f1467b = null;
        this.f1469d = 32;
        this.f1470e = 32;
        this.f1471f = null;
        this.f1472g = false;
        this.h = false;
        this.i = new boolean[32];
        this.j = 1;
        this.k = 0;
        this.l = 32;
        this.n = new g[q];
        this.o = 0;
        this.f1471f = new b[32];
        s();
        c cVar = new c();
        this.m = cVar;
        this.f1468c = new e(cVar);
        this.p = new b(this.m);
    }

    public final g a(g.a aVar, String str) {
        g a2 = this.m.f1464b.a();
        if (a2 == null) {
            a2 = new g(aVar);
        } else {
            a2.c();
        }
        a2.i = aVar;
        int i2 = this.o;
        int i3 = q;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            q = i4;
            this.n = (g[]) Arrays.copyOf(this.n, i4);
        }
        g[] gVarArr = this.n;
        int i5 = this.o;
        this.o = i5 + 1;
        gVarArr[i5] = a2;
        return a2;
    }

    public void b(g gVar, g gVar2, int i2, float f2, g gVar3, g gVar4, int i3, int i4) {
        float f3;
        int i5;
        b m2 = m();
        if (gVar2 == gVar3) {
            m2.f1461d.h(gVar, 1.0f);
            m2.f1461d.h(gVar4, 1.0f);
            m2.f1461d.h(gVar2, -2.0f);
        } else {
            if (f2 == 0.5f) {
                m2.f1461d.h(gVar, 1.0f);
                m2.f1461d.h(gVar2, -1.0f);
                m2.f1461d.h(gVar3, -1.0f);
                m2.f1461d.h(gVar4, 1.0f);
                if (i2 > 0 || i3 > 0) {
                    i5 = (-i2) + i3;
                }
            } else if (f2 <= 0.0f) {
                m2.f1461d.h(gVar, -1.0f);
                m2.f1461d.h(gVar2, 1.0f);
                f3 = (float) i2;
                m2.f1459b = f3;
            } else if (f2 >= 1.0f) {
                m2.f1461d.h(gVar4, -1.0f);
                m2.f1461d.h(gVar3, 1.0f);
                i5 = -i3;
            } else {
                float f4 = 1.0f - f2;
                m2.f1461d.h(gVar, f4 * 1.0f);
                m2.f1461d.h(gVar2, f4 * -1.0f);
                m2.f1461d.h(gVar3, -1.0f * f2);
                m2.f1461d.h(gVar4, 1.0f * f2);
                if (i2 > 0 || i3 > 0) {
                    m2.f1459b = (((float) i3) * f2) + (((float) (-i2)) * f4);
                }
            }
            f3 = (float) i5;
            m2.f1459b = f3;
        }
        if (i4 != 7) {
            m2.c(this, i4);
        }
        c(m2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:147:0x0152 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0113  */
    public void c(b bVar) {
        int i2;
        boolean z;
        int i3;
        int i4;
        g d2;
        g.a aVar = g.a.UNRESTRICTED;
        if (this.k + 1 >= this.l || this.j + 1 >= this.f1470e) {
            p();
        }
        if (!bVar.f1462e) {
            if (this.k > 0) {
                a aVar2 = bVar.f1461d;
                b[] bVarArr = this.f1471f;
                loop0:
                while (true) {
                    int i5 = aVar2.i;
                    int i6 = 0;
                    while (i5 != -1 && i6 < aVar2.f1451a) {
                        g gVar = aVar2.f1453c.f1465c[aVar2.f1456f[i5]];
                        if (gVar.f1482d != -1) {
                            float f2 = aVar2.h[i5];
                            aVar2.i(gVar, true);
                            b bVar2 = bVarArr[gVar.f1482d];
                            if (!bVar2.f1462e) {
                                a aVar3 = bVar2.f1461d;
                                int i7 = aVar3.i;
                                int i8 = 0;
                                while (i7 != -1 && i8 < aVar3.f1451a) {
                                    aVar2.a(aVar2.f1453c.f1465c[aVar3.f1456f[i7]], aVar3.h[i7] * f2, true);
                                    i7 = aVar3.f1457g[i7];
                                    i8++;
                                }
                            }
                            float f3 = (bVar2.f1459b * f2) + bVar.f1459b;
                            bVar.f1459b = f3;
                            if (Math.abs(f3) < 0.001f) {
                                bVar.f1459b = 0.0f;
                            }
                            bVar2.f1458a.b(bVar);
                        } else {
                            i5 = aVar2.f1457g[i5];
                            i6++;
                        }
                    }
                }
                if (bVar.f1461d.f1451a == 0) {
                    bVar.f1462e = true;
                }
            }
            if (!(bVar.f1458a == null && bVar.f1459b == 0.0f && bVar.f1461d.f1451a == 0)) {
                float f4 = bVar.f1459b;
                if (f4 < 0.0f) {
                    bVar.f1459b = f4 * -1.0f;
                    a aVar4 = bVar.f1461d;
                    int i9 = aVar4.i;
                    int i10 = 0;
                    while (i9 != -1 && i10 < aVar4.f1451a) {
                        float[] fArr = aVar4.h;
                        fArr[i9] = fArr[i9] * -1.0f;
                        i9 = aVar4.f1457g[i9];
                        i10++;
                    }
                }
                a aVar5 = bVar.f1461d;
                int i11 = aVar5.i;
                float f5 = 0.0f;
                float f6 = 0.0f;
                int i12 = 0;
                g gVar2 = null;
                g gVar3 = null;
                boolean z2 = false;
                boolean z3 = false;
                for (int i13 = -1; i11 != i13 && i12 < aVar5.f1451a; i13 = -1) {
                    float[] fArr2 = aVar5.h;
                    float f7 = fArr2[i11];
                    g gVar4 = aVar5.f1453c.f1465c[aVar5.f1456f[i11]];
                    if (f7 < 0.0f) {
                        if (f7 > -0.001f) {
                            fArr2[i11] = 0.0f;
                        }
                        if (f7 != 0.0f) {
                            if (gVar4.i == aVar) {
                                if (gVar3 == null || f5 > f7) {
                                    z2 = aVar5.g(gVar4);
                                } else if (!z2 && aVar5.g(gVar4)) {
                                    z2 = true;
                                }
                                gVar3 = gVar4;
                                f5 = f7;
                            } else if (gVar3 == null && f7 < 0.0f) {
                                if (gVar2 == null || f6 > f7) {
                                    z3 = aVar5.g(gVar4);
                                } else if (!z3 && aVar5.g(gVar4)) {
                                    z3 = true;
                                }
                                gVar2 = gVar4;
                                f6 = f7;
                            }
                        }
                        i11 = aVar5.f1457g[i11];
                        i12++;
                    } else {
                        if (f7 < 0.001f) {
                            fArr2[i11] = 0.0f;
                        }
                        if (f7 != 0.0f) {
                        }
                        i11 = aVar5.f1457g[i11];
                        i12++;
                    }
                    gVar4.b(aVar5.f1452b);
                    f7 = 0.0f;
                    if (f7 != 0.0f) {
                    }
                    i11 = aVar5.f1457g[i11];
                    i12++;
                }
                if (gVar3 != null) {
                    gVar2 = gVar3;
                }
                if (gVar2 == null) {
                    z = true;
                } else {
                    bVar.h(gVar2);
                    z = false;
                }
                if (bVar.f1461d.f1451a == 0) {
                    i3 = 1;
                    bVar.f1462e = true;
                } else {
                    i3 = 1;
                }
                if (z) {
                    if (this.j + i3 >= this.f1470e) {
                        p();
                    }
                    g a2 = a(g.a.SLACK, null);
                    int i14 = this.f1466a + i3;
                    this.f1466a = i14;
                    this.j += i3;
                    a2.f1481c = i14;
                    this.m.f1465c[i14] = a2;
                    bVar.f1458a = a2;
                    i(bVar);
                    b bVar3 = (b) this.p;
                    if (bVar3 != null) {
                        bVar3.f1458a = null;
                        bVar3.f1461d.b();
                        int i15 = 0;
                        while (true) {
                            a aVar6 = bVar.f1461d;
                            if (i15 >= aVar6.f1451a) {
                                break;
                            }
                            bVar3.f1461d.a(aVar6.e(i15), bVar.f1461d.f(i15), true);
                            i15++;
                        }
                        r(this.p);
                        if (a2.f1482d == -1) {
                            if (bVar.f1458a == a2 && (d2 = bVar.f1461d.d(null, a2)) != null) {
                                bVar.h(d2);
                            }
                            if (!bVar.f1462e) {
                                bVar.f1458a.d(bVar);
                            }
                            i3 = 1;
                            this.k--;
                        } else {
                            i3 = 1;
                        }
                        i4 = i3;
                    } else {
                        throw null;
                    }
                } else {
                    i4 = 0;
                }
                g gVar5 = bVar.f1458a;
                if (gVar5 == null || (gVar5.i != aVar && bVar.f1459b < 0.0f)) {
                    i3 = 0;
                }
                if (i3 != 0) {
                    i2 = i4;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            i(bVar);
        }
    }

    public b d(g gVar, g gVar2, int i2, int i3) {
        b m2 = m();
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            m2.f1459b = (float) i2;
        }
        if (!z) {
            m2.f1461d.h(gVar, -1.0f);
            m2.f1461d.h(gVar2, 1.0f);
        } else {
            m2.f1461d.h(gVar, 1.0f);
            m2.f1461d.h(gVar2, -1.0f);
        }
        if (i3 != 7) {
            m2.c(this, i3);
        }
        c(m2);
        return m2;
    }

    public void e(g gVar, int i2) {
        b bVar;
        a aVar;
        float f2;
        int i3 = gVar.f1482d;
        if (i3 != -1) {
            b bVar2 = this.f1471f[i3];
            if (!bVar2.f1462e) {
                if (bVar2.f1461d.f1451a == 0) {
                    bVar2.f1462e = true;
                } else {
                    bVar = m();
                    if (i2 < 0) {
                        bVar.f1459b = (float) (i2 * -1);
                        aVar = bVar.f1461d;
                        f2 = 1.0f;
                    } else {
                        bVar.f1459b = (float) i2;
                        aVar = bVar.f1461d;
                        f2 = -1.0f;
                    }
                    aVar.h(gVar, f2);
                }
            }
            bVar2.f1459b = (float) i2;
            return;
        }
        bVar = m();
        bVar.f1458a = gVar;
        float f3 = (float) i2;
        gVar.f1484f = f3;
        bVar.f1459b = f3;
        bVar.f1462e = true;
        c(bVar);
    }

    public void f(g gVar, g gVar2, int i2, int i3) {
        b m2 = m();
        g n2 = n();
        n2.f1483e = 0;
        m2.e(gVar, gVar2, n2, i2);
        if (i3 != 7) {
            m2.f1461d.h(k(i3, null), (float) ((int) (m2.f1461d.c(n2) * -1.0f)));
        }
        c(m2);
    }

    public void g(g gVar, g gVar2, int i2, int i3) {
        b m2 = m();
        g n2 = n();
        n2.f1483e = 0;
        m2.f(gVar, gVar2, n2, i2);
        if (i3 != 7) {
            m2.f1461d.h(k(i3, null), (float) ((int) (m2.f1461d.c(n2) * -1.0f)));
        }
        c(m2);
    }

    public void h(g gVar, g gVar2, g gVar3, g gVar4, float f2, int i2) {
        b m2 = m();
        m2.d(gVar, gVar2, gVar3, gVar4, f2);
        if (i2 != 7) {
            m2.c(this, i2);
        }
        c(m2);
    }

    public final void i(b bVar) {
        b[] bVarArr = this.f1471f;
        int i2 = this.k;
        if (bVarArr[i2] != null) {
            this.m.f1463a.b(bVarArr[i2]);
        }
        b[] bVarArr2 = this.f1471f;
        int i3 = this.k;
        bVarArr2[i3] = bVar;
        g gVar = bVar.f1458a;
        gVar.f1482d = i3;
        this.k = i3 + 1;
        gVar.d(bVar);
    }

    public final void j() {
        for (int i2 = 0; i2 < this.k; i2++) {
            b bVar = this.f1471f[i2];
            bVar.f1458a.f1484f = bVar.f1459b;
        }
    }

    public g k(int i2, String str) {
        if (this.j + 1 >= this.f1470e) {
            p();
        }
        g a2 = a(g.a.ERROR, str);
        int i3 = this.f1466a + 1;
        this.f1466a = i3;
        this.j++;
        a2.f1481c = i3;
        a2.f1483e = i2;
        this.m.f1465c[i3] = a2;
        this.f1468c.a(a2);
        return a2;
    }

    public g l(Object obj) {
        g gVar = null;
        if (obj == null) {
            return null;
        }
        if (this.j + 1 >= this.f1470e) {
            p();
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            gVar = cVar.f1504f;
            if (gVar == null) {
                cVar.e();
                gVar = cVar.f1504f;
            }
            int i2 = gVar.f1481c;
            if (i2 == -1 || i2 > this.f1466a || this.m.f1465c[i2] == null) {
                if (gVar.f1481c != -1) {
                    gVar.c();
                }
                int i3 = this.f1466a + 1;
                this.f1466a = i3;
                this.j++;
                gVar.f1481c = i3;
                gVar.i = g.a.UNRESTRICTED;
                this.m.f1465c[i3] = gVar;
            }
        }
        return gVar;
    }

    public b m() {
        b a2 = this.m.f1463a.a();
        if (a2 == null) {
            a2 = new b(this.m);
        } else {
            a2.f1458a = null;
            a2.f1461d.b();
            a2.f1459b = 0.0f;
            a2.f1462e = false;
        }
        g.m++;
        return a2;
    }

    public g n() {
        if (this.j + 1 >= this.f1470e) {
            p();
        }
        g a2 = a(g.a.SLACK, null);
        int i2 = this.f1466a + 1;
        this.f1466a = i2;
        this.j++;
        a2.f1481c = i2;
        this.m.f1465c[i2] = a2;
        return a2;
    }

    public int o(Object obj) {
        g gVar = ((c) obj).f1504f;
        if (gVar != null) {
            return (int) (gVar.f1484f + 0.5f);
        }
        return 0;
    }

    public final void p() {
        int i2 = this.f1469d * 2;
        this.f1469d = i2;
        this.f1471f = (b[]) Arrays.copyOf(this.f1471f, i2);
        c cVar = this.m;
        cVar.f1465c = (g[]) Arrays.copyOf(cVar.f1465c, this.f1469d);
        int i3 = this.f1469d;
        this.i = new boolean[i3];
        this.f1470e = i3;
        this.l = i3;
    }

    public void q(a aVar) {
        float f2;
        int i2;
        boolean z;
        g.a aVar2 = g.a.UNRESTRICTED;
        int i3 = 0;
        while (true) {
            f2 = 0.0f;
            i2 = 1;
            if (i3 >= this.k) {
                z = false;
                break;
            }
            b[] bVarArr = this.f1471f;
            if (bVarArr[i3].f1458a.i != aVar2 && bVarArr[i3].f1459b < 0.0f) {
                z = true;
                break;
            }
            i3++;
        }
        if (z) {
            boolean z2 = false;
            int i4 = 0;
            while (!z2) {
                i4 += i2;
                float f3 = Float.MAX_VALUE;
                int i5 = -1;
                int i6 = -1;
                int i7 = 0;
                int i8 = 0;
                while (i7 < this.k) {
                    b bVar = this.f1471f[i7];
                    if (bVar.f1458a.i != aVar2 && !bVar.f1462e && bVar.f1459b < f2) {
                        int i9 = i2;
                        while (i9 < this.j) {
                            g gVar = this.m.f1465c[i9];
                            float c2 = bVar.f1461d.c(gVar);
                            if (c2 > f2) {
                                for (int i10 = 0; i10 < 8; i10++) {
                                    float f4 = gVar.f1485g[i10] / c2;
                                    if ((f4 < f3 && i10 == i8) || i10 > i8) {
                                        i8 = i10;
                                        f3 = f4;
                                        i5 = i7;
                                        i6 = i9;
                                    }
                                }
                            }
                            i9++;
                            f2 = 0.0f;
                        }
                    }
                    i7++;
                    f2 = 0.0f;
                    i2 = 1;
                }
                if (i5 != -1) {
                    b bVar2 = this.f1471f[i5];
                    bVar2.f1458a.f1482d = -1;
                    bVar2.h(this.m.f1465c[i6]);
                    g gVar2 = bVar2.f1458a;
                    gVar2.f1482d = i5;
                    gVar2.d(bVar2);
                } else {
                    z2 = true;
                }
                if (i4 > this.j / 2) {
                    z2 = true;
                }
                f2 = 0.0f;
                i2 = 1;
            }
        }
        r(aVar);
        j();
    }

    public final int r(a aVar) {
        boolean z;
        int i2 = 0;
        for (int i3 = 0; i3 < this.j; i3++) {
            this.i[i3] = false;
        }
        boolean z2 = false;
        int i4 = 0;
        while (!z2) {
            i4++;
            if (i4 >= this.j * 2) {
                return i4;
            }
            g gVar = ((b) aVar).f1458a;
            if (gVar != null) {
                this.i[gVar.f1481c] = true;
            }
            g b2 = aVar.b(this, this.i);
            if (b2 != null) {
                boolean[] zArr = this.i;
                int i5 = b2.f1481c;
                if (zArr[i5]) {
                    return i4;
                }
                zArr[i5] = true;
            }
            if (b2 != null) {
                float f2 = Float.MAX_VALUE;
                int i6 = i2;
                int i7 = -1;
                while (i6 < this.k) {
                    b bVar = this.f1471f[i6];
                    if (bVar.f1458a.i != g.a.UNRESTRICTED && !bVar.f1462e) {
                        a aVar2 = bVar.f1461d;
                        int i8 = aVar2.i;
                        if (i8 != -1) {
                            int i9 = i2;
                            while (true) {
                                if (i8 == -1 || i9 >= aVar2.f1451a) {
                                    break;
                                } else if (aVar2.f1456f[i8] == b2.f1481c) {
                                    z = true;
                                    break;
                                } else {
                                    i8 = aVar2.f1457g[i8];
                                    i9++;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            float c2 = bVar.f1461d.c(b2);
                            if (c2 < 0.0f) {
                                float f3 = (-bVar.f1459b) / c2;
                                if (f3 < f2) {
                                    i7 = i6;
                                    f2 = f3;
                                }
                            }
                        }
                    }
                    i6++;
                    i2 = 0;
                }
                if (i7 > -1) {
                    b bVar2 = this.f1471f[i7];
                    bVar2.f1458a.f1482d = -1;
                    bVar2.h(b2);
                    g gVar2 = bVar2.f1458a;
                    gVar2.f1482d = i7;
                    gVar2.d(bVar2);
                }
            } else {
                z2 = true;
            }
            i2 = 0;
        }
        return i4;
    }

    public final void s() {
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.f1471f;
            if (i2 < bVarArr.length) {
                b bVar = bVarArr[i2];
                if (bVar != null) {
                    this.m.f1463a.b(bVar);
                }
                this.f1471f[i2] = null;
                i2++;
            } else {
                return;
            }
        }
    }

    public void t() {
        c cVar;
        int i2 = 0;
        while (true) {
            cVar = this.m;
            g[] gVarArr = cVar.f1465c;
            if (i2 >= gVarArr.length) {
                break;
            }
            g gVar = gVarArr[i2];
            if (gVar != null) {
                gVar.c();
            }
            i2++;
        }
        f<g> fVar = cVar.f1464b;
        g[] gVarArr2 = this.n;
        int i3 = this.o;
        if (fVar != null) {
            if (i3 > gVarArr2.length) {
                i3 = gVarArr2.length;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                g gVar2 = gVarArr2[i4];
                int i5 = fVar.f1478b;
                Object[] objArr = fVar.f1477a;
                if (i5 < objArr.length) {
                    objArr[i5] = gVar2;
                    fVar.f1478b = i5 + 1;
                }
            }
            this.o = 0;
            Arrays.fill(this.m.f1465c, (Object) null);
            HashMap<String, g> hashMap = this.f1467b;
            if (hashMap != null) {
                hashMap.clear();
            }
            this.f1466a = 0;
            this.f1468c.clear();
            this.j = 1;
            for (int i6 = 0; i6 < this.k; i6++) {
                this.f1471f[i6].f1460c = false;
            }
            s();
            this.k = 0;
            return;
        }
        throw null;
    }
}
