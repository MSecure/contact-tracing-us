package b.g.a;

import b.g.a.g;
import b.g.a.h.c;
import java.util.Arrays;
import java.util.HashMap;

public class e {
    public static int p = 1000;

    /* renamed from: a  reason: collision with root package name */
    public int f876a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, g> f877b;

    /* renamed from: c  reason: collision with root package name */
    public a f878c;

    /* renamed from: d  reason: collision with root package name */
    public int f879d;

    /* renamed from: e  reason: collision with root package name */
    public int f880e;
    public b[] f;
    public boolean g;
    public boolean[] h;
    public int i;
    public int j;
    public int k;
    public final c l;
    public g[] m;
    public int n;
    public final a o;

    public interface a {
        void a(g gVar);
    }

    public e() {
        this.f876a = 0;
        this.f877b = null;
        this.f879d = 32;
        this.f880e = 32;
        this.f = null;
        this.g = false;
        this.h = new boolean[32];
        this.i = 1;
        this.j = 0;
        this.k = 32;
        this.m = new g[p];
        this.n = 0;
        this.f = new b[32];
        s();
        c cVar = new c();
        this.l = cVar;
        this.f878c = new d(cVar);
        this.o = new b(this.l);
    }

    public final g a(g.a aVar, String str) {
        g a2 = this.l.f874b.a();
        if (a2 == null) {
            a2 = new g(aVar);
        } else {
            a2.c();
        }
        a2.g = aVar;
        int i2 = this.n;
        int i3 = p;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            p = i4;
            this.m = (g[]) Arrays.copyOf(this.m, i4);
        }
        g[] gVarArr = this.m;
        int i5 = this.n;
        this.n = i5 + 1;
        gVarArr[i5] = a2;
        return a2;
    }

    public void b(g gVar, g gVar2, int i2, float f2, g gVar3, g gVar4, int i3, int i4) {
        float f3;
        b m2 = m();
        if (gVar2 == gVar3) {
            m2.f871d.h(gVar, 1.0f);
            m2.f871d.h(gVar4, 1.0f);
            m2.f871d.h(gVar2, -2.0f);
        } else {
            if (f2 == 0.5f) {
                m2.f871d.h(gVar, 1.0f);
                m2.f871d.h(gVar2, -1.0f);
                m2.f871d.h(gVar3, -1.0f);
                m2.f871d.h(gVar4, 1.0f);
                if (i2 > 0 || i3 > 0) {
                    f3 = (float) ((-i2) + i3);
                }
            } else if (f2 <= 0.0f) {
                m2.f871d.h(gVar, -1.0f);
                m2.f871d.h(gVar2, 1.0f);
                f3 = (float) i2;
            } else if (f2 >= 1.0f) {
                m2.f871d.h(gVar3, -1.0f);
                m2.f871d.h(gVar4, 1.0f);
                f3 = (float) i3;
            } else {
                float f4 = 1.0f - f2;
                m2.f871d.h(gVar, f4 * 1.0f);
                m2.f871d.h(gVar2, f4 * -1.0f);
                m2.f871d.h(gVar3, -1.0f * f2);
                m2.f871d.h(gVar4, 1.0f * f2);
                if (i2 > 0 || i3 > 0) {
                    m2.f869b = (((float) i3) * f2) + (((float) (-i2)) * f4);
                }
            }
            m2.f869b = f3;
        }
        if (i4 != 6) {
            m2.b(this, i4);
        }
        c(m2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x00dc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d  */
    public void c(b bVar) {
        boolean z;
        boolean z2;
        boolean z3;
        g d2;
        g.a aVar = g.a.UNRESTRICTED;
        boolean z4 = true;
        if (this.j + 1 >= this.k || this.i + 1 >= this.f880e) {
            p();
        }
        if (!bVar.f872e) {
            u(bVar);
            if (!(bVar.f868a == null && bVar.f869b == 0.0f && bVar.f871d.f863a == 0)) {
                float f2 = bVar.f869b;
                if (f2 < 0.0f) {
                    bVar.f869b = f2 * -1.0f;
                    a aVar2 = bVar.f871d;
                    int i2 = aVar2.i;
                    int i3 = 0;
                    while (i2 != -1 && i3 < aVar2.f863a) {
                        float[] fArr = aVar2.h;
                        fArr[i2] = fArr[i2] * -1.0f;
                        i2 = aVar2.g[i2];
                        i3++;
                    }
                }
                a aVar3 = bVar.f871d;
                int i4 = aVar3.i;
                float f3 = 0.0f;
                float f4 = 0.0f;
                int i5 = 0;
                g gVar = null;
                g gVar2 = null;
                boolean z5 = false;
                boolean z6 = false;
                for (int i6 = -1; i4 != i6 && i5 < aVar3.f863a; i6 = -1) {
                    float[] fArr2 = aVar3.h;
                    float f5 = fArr2[i4];
                    g gVar3 = aVar3.f865c.f875c[aVar3.f[i4]];
                    if (f5 < 0.0f) {
                        if (f5 > -0.001f) {
                            fArr2[i4] = 0.0f;
                        }
                        if (f5 != 0.0f) {
                            if (gVar3.g == aVar) {
                                if (gVar2 == null || f3 > f5) {
                                    z5 = aVar3.g(gVar3);
                                } else if (!z5 && aVar3.g(gVar3)) {
                                    z5 = true;
                                }
                                gVar2 = gVar3;
                                f3 = f5;
                            } else if (gVar2 == null && f5 < 0.0f) {
                                if (gVar == null || f4 > f5) {
                                    z6 = aVar3.g(gVar3);
                                } else if (!z6 && aVar3.g(gVar3)) {
                                    z6 = true;
                                }
                                gVar = gVar3;
                                f4 = f5;
                            }
                        }
                        i4 = aVar3.g[i4];
                        i5++;
                    } else {
                        if (f5 < 0.001f) {
                            fArr2[i4] = 0.0f;
                        }
                        if (f5 != 0.0f) {
                        }
                        i4 = aVar3.g[i4];
                        i5++;
                    }
                    gVar3.b(aVar3.f864b);
                    f5 = 0.0f;
                    if (f5 != 0.0f) {
                    }
                    i4 = aVar3.g[i4];
                    i5++;
                }
                if (gVar2 != null) {
                    gVar = gVar2;
                }
                if (gVar == null) {
                    z2 = true;
                } else {
                    bVar.g(gVar);
                    z2 = false;
                }
                if (bVar.f871d.f863a == 0) {
                    bVar.f872e = true;
                }
                if (z2) {
                    if (this.i + 1 >= this.f880e) {
                        p();
                    }
                    g a2 = a(g.a.SLACK, null);
                    int i7 = this.f876a + 1;
                    this.f876a = i7;
                    this.i++;
                    a2.f884b = i7;
                    this.l.f875c[i7] = a2;
                    bVar.f868a = a2;
                    i(bVar);
                    b bVar2 = (b) this.o;
                    if (bVar2 != null) {
                        bVar2.f868a = null;
                        bVar2.f871d.b();
                        int i8 = 0;
                        while (true) {
                            a aVar4 = bVar.f871d;
                            if (i8 >= aVar4.f863a) {
                                break;
                            }
                            bVar2.f871d.a(aVar4.e(i8), bVar.f871d.f(i8), true);
                            i8++;
                        }
                        r(this.o);
                        if (a2.f885c == -1) {
                            if (bVar.f868a == a2 && (d2 = bVar.f871d.d(null, a2)) != null) {
                                bVar.g(d2);
                            }
                            if (!bVar.f872e) {
                                bVar.f868a.d(bVar);
                            }
                            this.j--;
                        }
                        z3 = true;
                    } else {
                        throw null;
                    }
                } else {
                    z3 = false;
                }
                g gVar4 = bVar.f868a;
                if (gVar4 == null || (gVar4.g != aVar && bVar.f869b < 0.0f)) {
                    z4 = false;
                }
                if (z4) {
                    z = z3;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            z = false;
        }
        if (!z) {
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
            m2.f869b = (float) i2;
        }
        if (!z) {
            m2.f871d.h(gVar, -1.0f);
            m2.f871d.h(gVar2, 1.0f);
        } else {
            m2.f871d.h(gVar, 1.0f);
            m2.f871d.h(gVar2, -1.0f);
        }
        if (i3 != 6) {
            m2.b(this, i3);
        }
        c(m2);
        return m2;
    }

    public void e(g gVar, int i2) {
        b bVar;
        a aVar;
        float f2;
        int i3 = gVar.f885c;
        if (i3 != -1) {
            b bVar2 = this.f[i3];
            if (!bVar2.f872e) {
                if (bVar2.f871d.f863a == 0) {
                    bVar2.f872e = true;
                } else {
                    bVar = m();
                    if (i2 < 0) {
                        bVar.f869b = (float) (i2 * -1);
                        aVar = bVar.f871d;
                        f2 = 1.0f;
                    } else {
                        bVar.f869b = (float) i2;
                        aVar = bVar.f871d;
                        f2 = -1.0f;
                    }
                    aVar.h(gVar, f2);
                }
            }
            bVar2.f869b = (float) i2;
            return;
        }
        bVar = m();
        bVar.f868a = gVar;
        float f3 = (float) i2;
        gVar.f887e = f3;
        bVar.f869b = f3;
        bVar.f872e = true;
        c(bVar);
    }

    public void f(g gVar, g gVar2, int i2, int i3) {
        b m2 = m();
        g n2 = n();
        n2.f886d = 0;
        m2.d(gVar, gVar2, n2, i2);
        if (i3 != 6) {
            m2.f871d.h(k(i3, null), (float) ((int) (m2.f871d.c(n2) * -1.0f)));
        }
        c(m2);
    }

    public void g(g gVar, g gVar2, int i2, int i3) {
        b m2 = m();
        g n2 = n();
        n2.f886d = 0;
        m2.e(gVar, gVar2, n2, i2);
        if (i3 != 6) {
            m2.f871d.h(k(i3, null), (float) ((int) (m2.f871d.c(n2) * -1.0f)));
        }
        c(m2);
    }

    public void h(g gVar, g gVar2, g gVar3, g gVar4, float f2, int i2) {
        b m2 = m();
        m2.c(gVar, gVar2, gVar3, gVar4, f2);
        if (i2 != 6) {
            m2.b(this, i2);
        }
        c(m2);
    }

    public final void i(b bVar) {
        b[] bVarArr = this.f;
        int i2 = this.j;
        if (bVarArr[i2] != null) {
            this.l.f873a.b(bVarArr[i2]);
        }
        b[] bVarArr2 = this.f;
        int i3 = this.j;
        bVarArr2[i3] = bVar;
        g gVar = bVar.f868a;
        gVar.f885c = i3;
        this.j = i3 + 1;
        gVar.d(bVar);
    }

    public final void j() {
        for (int i2 = 0; i2 < this.j; i2++) {
            b bVar = this.f[i2];
            bVar.f868a.f887e = bVar.f869b;
        }
    }

    public g k(int i2, String str) {
        if (this.i + 1 >= this.f880e) {
            p();
        }
        g a2 = a(g.a.ERROR, str);
        int i3 = this.f876a + 1;
        this.f876a = i3;
        this.i++;
        a2.f884b = i3;
        a2.f886d = i2;
        this.l.f875c[i3] = a2;
        this.f878c.a(a2);
        return a2;
    }

    public g l(Object obj) {
        g gVar = null;
        if (obj == null) {
            return null;
        }
        if (this.i + 1 >= this.f880e) {
            p();
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            gVar = cVar.i;
            if (gVar == null) {
                cVar.e();
                gVar = cVar.i;
            }
            int i2 = gVar.f884b;
            if (i2 == -1 || i2 > this.f876a || this.l.f875c[i2] == null) {
                if (gVar.f884b != -1) {
                    gVar.c();
                }
                int i3 = this.f876a + 1;
                this.f876a = i3;
                this.i++;
                gVar.f884b = i3;
                gVar.g = g.a.UNRESTRICTED;
                this.l.f875c[i3] = gVar;
            }
        }
        return gVar;
    }

    public b m() {
        b a2 = this.l.f873a.a();
        if (a2 == null) {
            a2 = new b(this.l);
        } else {
            a2.f868a = null;
            a2.f871d.b();
            a2.f869b = 0.0f;
            a2.f872e = false;
        }
        g.k++;
        return a2;
    }

    public g n() {
        if (this.i + 1 >= this.f880e) {
            p();
        }
        g a2 = a(g.a.SLACK, null);
        int i2 = this.f876a + 1;
        this.f876a = i2;
        this.i++;
        a2.f884b = i2;
        this.l.f875c[i2] = a2;
        return a2;
    }

    public int o(Object obj) {
        g gVar = ((c) obj).i;
        if (gVar != null) {
            return (int) (gVar.f887e + 0.5f);
        }
        return 0;
    }

    public final void p() {
        int i2 = this.f879d * 2;
        this.f879d = i2;
        this.f = (b[]) Arrays.copyOf(this.f, i2);
        c cVar = this.l;
        cVar.f875c = (g[]) Arrays.copyOf(cVar.f875c, this.f879d);
        int i3 = this.f879d;
        this.h = new boolean[i3];
        this.f880e = i3;
        this.k = i3;
    }

    public void q(a aVar) {
        float f2;
        int i2;
        boolean z;
        u((b) aVar);
        g.a aVar2 = g.a.UNRESTRICTED;
        int i3 = 0;
        while (true) {
            f2 = 0.0f;
            i2 = 1;
            if (i3 >= this.j) {
                z = false;
                break;
            }
            b[] bVarArr = this.f;
            if (bVarArr[i3].f868a.g != aVar2 && bVarArr[i3].f869b < 0.0f) {
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
                while (i7 < this.j) {
                    b bVar = this.f[i7];
                    if (bVar.f868a.g != aVar2 && !bVar.f872e && bVar.f869b < f2) {
                        int i9 = i2;
                        while (i9 < this.i) {
                            g gVar = this.l.f875c[i9];
                            float c2 = bVar.f871d.c(gVar);
                            if (c2 > f2) {
                                for (int i10 = 0; i10 < 7; i10++) {
                                    float f4 = gVar.f[i10] / c2;
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
                    b bVar2 = this.f[i5];
                    bVar2.f868a.f885c = -1;
                    bVar2.g(this.l.f875c[i6]);
                    g gVar2 = bVar2.f868a;
                    gVar2.f885c = i5;
                    gVar2.d(bVar2);
                } else {
                    z2 = true;
                }
                if (i4 > this.i / 2) {
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
        for (int i2 = 0; i2 < this.i; i2++) {
            this.h[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            i3++;
            if (i3 >= this.i * 2) {
                return i3;
            }
            b bVar = (b) aVar;
            g gVar = bVar.f868a;
            if (gVar != null) {
                this.h[gVar.f884b] = true;
            }
            g d2 = bVar.f871d.d(this.h, null);
            if (d2 != null) {
                boolean[] zArr = this.h;
                int i4 = d2.f884b;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (d2 != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.j; i6++) {
                    b bVar2 = this.f[i6];
                    if (bVar2.f868a.g != g.a.UNRESTRICTED && !bVar2.f872e) {
                        a aVar2 = bVar2.f871d;
                        int i7 = aVar2.i;
                        if (i7 != -1) {
                            int i8 = 0;
                            while (true) {
                                if (i7 == -1 || i8 >= aVar2.f863a) {
                                    break;
                                } else if (aVar2.f[i7] == d2.f884b) {
                                    z = true;
                                    break;
                                } else {
                                    i7 = aVar2.g[i7];
                                    i8++;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            float c2 = bVar2.f871d.c(d2);
                            if (c2 < 0.0f) {
                                float f3 = (-bVar2.f869b) / c2;
                                if (f3 < f2) {
                                    i5 = i6;
                                    f2 = f3;
                                }
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    b bVar3 = this.f[i5];
                    bVar3.f868a.f885c = -1;
                    bVar3.g(d2);
                    g gVar2 = bVar3.f868a;
                    gVar2.f885c = i5;
                    gVar2.d(bVar3);
                }
            }
            z2 = true;
        }
        return i3;
    }

    public final void s() {
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.f;
            if (i2 < bVarArr.length) {
                b bVar = bVarArr[i2];
                if (bVar != null) {
                    this.l.f873a.b(bVar);
                }
                this.f[i2] = null;
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
            cVar = this.l;
            g[] gVarArr = cVar.f875c;
            if (i2 >= gVarArr.length) {
                break;
            }
            g gVar = gVarArr[i2];
            if (gVar != null) {
                gVar.c();
            }
            i2++;
        }
        f<g> fVar = cVar.f874b;
        g[] gVarArr2 = this.m;
        int i3 = this.n;
        if (fVar != null) {
            if (i3 > gVarArr2.length) {
                i3 = gVarArr2.length;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                g gVar2 = gVarArr2[i4];
                int i5 = fVar.f882b;
                Object[] objArr = fVar.f881a;
                if (i5 < objArr.length) {
                    objArr[i5] = gVar2;
                    fVar.f882b = i5 + 1;
                }
            }
            this.n = 0;
            Arrays.fill(this.l.f875c, (Object) null);
            HashMap<String, g> hashMap = this.f877b;
            if (hashMap != null) {
                hashMap.clear();
            }
            this.f876a = 0;
            b bVar = (b) this.f878c;
            bVar.f871d.b();
            bVar.f868a = null;
            bVar.f869b = 0.0f;
            this.i = 1;
            for (int i6 = 0; i6 < this.j; i6++) {
                this.f[i6].f870c = false;
            }
            s();
            this.j = 0;
            return;
        }
        throw null;
    }

    public final void u(b bVar) {
        if (this.j > 0) {
            a aVar = bVar.f871d;
            b[] bVarArr = this.f;
            int i2 = aVar.i;
            loop0:
            while (true) {
                int i3 = 0;
                while (i2 != -1 && i3 < aVar.f863a) {
                    g gVar = aVar.f865c.f875c[aVar.f[i2]];
                    if (gVar.f885c != -1) {
                        float f2 = aVar.h[i2];
                        aVar.i(gVar, true);
                        b bVar2 = bVarArr[gVar.f885c];
                        if (!bVar2.f872e) {
                            a aVar2 = bVar2.f871d;
                            int i4 = aVar2.i;
                            int i5 = 0;
                            while (i4 != -1 && i5 < aVar2.f863a) {
                                aVar.a(aVar.f865c.f875c[aVar2.f[i4]], aVar2.h[i4] * f2, true);
                                i4 = aVar2.g[i4];
                                i5++;
                            }
                        }
                        bVar.f869b = (bVar2.f869b * f2) + bVar.f869b;
                        bVar2.f868a.b(bVar);
                        i2 = aVar.i;
                    } else {
                        i2 = aVar.g[i2];
                        i3++;
                    }
                }
            }
            if (bVar.f871d.f863a == 0) {
                bVar.f872e = true;
            }
        }
    }
}
