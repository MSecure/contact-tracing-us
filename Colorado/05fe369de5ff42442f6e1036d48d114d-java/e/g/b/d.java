package e.g.b;

import e.g.b.b;
import e.g.b.g;
import e.g.b.h.c;
import java.util.Arrays;
import java.util.Objects;

public class d {
    public static boolean p = false;
    public static int q = 1000;
    public static long r;
    public boolean a;
    public int b;
    public a c;

    /* renamed from: d  reason: collision with root package name */
    public int f1047d;

    /* renamed from: e  reason: collision with root package name */
    public int f1048e;

    /* renamed from: f  reason: collision with root package name */
    public b[] f1049f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1050g;

    /* renamed from: h  reason: collision with root package name */
    public boolean[] f1051h;

    /* renamed from: i  reason: collision with root package name */
    public int f1052i;

    /* renamed from: j  reason: collision with root package name */
    public int f1053j;

    /* renamed from: k  reason: collision with root package name */
    public int f1054k;

    /* renamed from: l  reason: collision with root package name */
    public final c f1055l;
    public g[] m;
    public int n;
    public a o;

    public interface a {
        void a(g gVar);

        g b(d dVar, boolean[] zArr);

        void clear();

        boolean isEmpty();
    }

    public d() {
        this.a = false;
        this.b = 0;
        this.f1047d = 32;
        this.f1048e = 32;
        this.f1049f = null;
        this.f1050g = false;
        this.f1051h = new boolean[32];
        this.f1052i = 1;
        this.f1053j = 0;
        this.f1054k = 32;
        this.m = new g[q];
        this.n = 0;
        this.f1049f = new b[32];
        t();
        c cVar = new c();
        this.f1055l = cVar;
        this.c = new f(cVar);
        this.o = new b(cVar);
    }

    public final g a(g.a aVar, String str) {
        g a2 = this.f1055l.c.a();
        if (a2 == null) {
            a2 = new g(aVar);
        } else {
            a2.c();
        }
        a2.f1066i = aVar;
        int i2 = this.n;
        int i3 = q;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            q = i4;
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
        int i5;
        b m2 = m();
        if (gVar2 == gVar3) {
            m2.f1044d.c(gVar, 1.0f);
            m2.f1044d.c(gVar4, 1.0f);
            m2.f1044d.c(gVar2, -2.0f);
        } else {
            if (f2 == 0.5f) {
                m2.f1044d.c(gVar, 1.0f);
                m2.f1044d.c(gVar2, -1.0f);
                m2.f1044d.c(gVar3, -1.0f);
                m2.f1044d.c(gVar4, 1.0f);
                if (i2 > 0 || i3 > 0) {
                    i5 = (-i2) + i3;
                }
            } else if (f2 <= 0.0f) {
                m2.f1044d.c(gVar, -1.0f);
                m2.f1044d.c(gVar2, 1.0f);
                f3 = (float) i2;
                m2.b = f3;
            } else if (f2 >= 1.0f) {
                m2.f1044d.c(gVar4, -1.0f);
                m2.f1044d.c(gVar3, 1.0f);
                i5 = -i3;
            } else {
                float f4 = 1.0f - f2;
                m2.f1044d.c(gVar, f4 * 1.0f);
                m2.f1044d.c(gVar2, f4 * -1.0f);
                m2.f1044d.c(gVar3, -1.0f * f2);
                m2.f1044d.c(gVar4, 1.0f * f2);
                if (i2 > 0 || i3 > 0) {
                    m2.b = (((float) i3) * f2) + (((float) (-i2)) * f4);
                }
            }
            f3 = (float) i5;
            m2.b = f3;
        }
        if (i4 != 8) {
            m2.c(this, i4);
        }
        c(m2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x01af A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01b0  */
    public void c(b bVar) {
        boolean z;
        boolean z2;
        boolean z3;
        g i2;
        g.a aVar = g.a.UNRESTRICTED;
        boolean z4 = true;
        if (this.f1053j + 1 >= this.f1054k || this.f1052i + 1 >= this.f1048e) {
            p();
        }
        if (!bVar.f1045e) {
            if (this.f1049f.length != 0) {
                boolean z5 = false;
                while (!z5) {
                    int k2 = bVar.f1044d.k();
                    for (int i3 = 0; i3 < k2; i3++) {
                        g f2 = bVar.f1044d.f(i3);
                        if (f2.c != -1 || f2.f1063f) {
                            bVar.c.add(f2);
                        }
                    }
                    int size = bVar.c.size();
                    if (size > 0) {
                        for (int i4 = 0; i4 < size; i4++) {
                            g gVar = bVar.c.get(i4);
                            if (gVar.f1063f) {
                                bVar.k(this, gVar, true);
                            } else {
                                bVar.l(this, this.f1049f[gVar.c], true);
                            }
                        }
                        bVar.c.clear();
                    } else {
                        z5 = true;
                    }
                }
                if (bVar.a != null && bVar.f1044d.k() == 0) {
                    bVar.f1045e = true;
                    this.a = true;
                }
            }
            if (!bVar.isEmpty()) {
                float f3 = bVar.b;
                if (f3 < 0.0f) {
                    bVar.b = f3 * -1.0f;
                    bVar.f1044d.j();
                }
                int k3 = bVar.f1044d.k();
                g gVar2 = null;
                g gVar3 = null;
                float f4 = 0.0f;
                boolean z6 = false;
                float f5 = 0.0f;
                boolean z7 = false;
                for (int i5 = 0; i5 < k3; i5++) {
                    float a2 = bVar.f1044d.a(i5);
                    g f6 = bVar.f1044d.f(i5);
                    if (f6.f1066i == aVar) {
                        if (gVar2 == null || f4 > a2) {
                            z6 = bVar.h(f6);
                            f4 = a2;
                            gVar2 = f6;
                        } else if (!z6 && bVar.h(f6)) {
                            f4 = a2;
                            gVar2 = f6;
                            z6 = true;
                        }
                    } else if (gVar2 == null && a2 < 0.0f) {
                        if (gVar3 == null || f5 > a2) {
                            z7 = bVar.h(f6);
                            f5 = a2;
                            gVar3 = f6;
                        } else if (!z7 && bVar.h(f6)) {
                            f5 = a2;
                            gVar3 = f6;
                            z7 = true;
                        }
                    }
                }
                if (gVar2 == null) {
                    gVar2 = gVar3;
                }
                if (gVar2 == null) {
                    z2 = true;
                } else {
                    bVar.j(gVar2);
                    z2 = false;
                }
                if (bVar.f1044d.k() == 0) {
                    bVar.f1045e = true;
                }
                if (z2) {
                    if (this.f1052i + 1 >= this.f1048e) {
                        p();
                    }
                    g a3 = a(g.a.SLACK, null);
                    int i6 = this.b + 1;
                    this.b = i6;
                    this.f1052i++;
                    a3.b = i6;
                    this.f1055l.f1046d[i6] = a3;
                    bVar.a = a3;
                    int i7 = this.f1053j;
                    i(bVar);
                    if (this.f1053j == i7 + 1) {
                        b bVar2 = (b) this.o;
                        Objects.requireNonNull(bVar2);
                        bVar2.a = null;
                        bVar2.f1044d.clear();
                        for (int i8 = 0; i8 < bVar.f1044d.k(); i8++) {
                            bVar2.f1044d.e(bVar.f1044d.f(i8), bVar.f1044d.a(i8), true);
                        }
                        s(this.o);
                        if (a3.c == -1) {
                            if (bVar.a == a3 && (i2 = bVar.i(null, a3)) != null) {
                                bVar.j(i2);
                            }
                            if (!bVar.f1045e) {
                                bVar.a.e(this, bVar);
                            }
                            this.f1055l.b.b(bVar);
                            this.f1053j--;
                        }
                        z3 = true;
                        g gVar4 = bVar.a;
                        if (gVar4 == null || (gVar4.f1066i != aVar && bVar.b < 0.0f)) {
                            z4 = false;
                        }
                        if (!z4) {
                            z = z3;
                        } else {
                            return;
                        }
                    }
                }
                z3 = false;
                g gVar42 = bVar.a;
                z4 = false;
                if (!z4) {
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
        if (i3 == 8 && gVar2.f1063f && gVar.c == -1) {
            gVar.d(this, gVar2.f1062e + ((float) i2));
            return null;
        }
        b m2 = m();
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            m2.b = (float) i2;
        }
        if (!z) {
            m2.f1044d.c(gVar, -1.0f);
            m2.f1044d.c(gVar2, 1.0f);
        } else {
            m2.f1044d.c(gVar, 1.0f);
            m2.f1044d.c(gVar2, -1.0f);
        }
        if (i3 != 8) {
            m2.c(this, i3);
        }
        c(m2);
        return m2;
    }

    public void e(g gVar, int i2) {
        b bVar;
        b.a aVar;
        float f2;
        int i3 = gVar.c;
        if (i3 == -1) {
            gVar.d(this, (float) i2);
            for (int i4 = 0; i4 < this.b + 1; i4++) {
                g gVar2 = this.f1055l.f1046d[i4];
            }
            return;
        }
        if (i3 != -1) {
            b bVar2 = this.f1049f[i3];
            if (!bVar2.f1045e) {
                if (bVar2.f1044d.k() == 0) {
                    bVar2.f1045e = true;
                } else {
                    bVar = m();
                    if (i2 < 0) {
                        bVar.b = (float) (i2 * -1);
                        aVar = bVar.f1044d;
                        f2 = 1.0f;
                    } else {
                        bVar.b = (float) i2;
                        aVar = bVar.f1044d;
                        f2 = -1.0f;
                    }
                    aVar.c(gVar, f2);
                }
            }
            bVar2.b = (float) i2;
            return;
        }
        bVar = m();
        bVar.a = gVar;
        float f3 = (float) i2;
        gVar.f1062e = f3;
        bVar.b = f3;
        bVar.f1045e = true;
        c(bVar);
    }

    public void f(g gVar, g gVar2, int i2, int i3) {
        b m2 = m();
        g n2 = n();
        n2.f1061d = 0;
        m2.e(gVar, gVar2, n2, i2);
        if (i3 != 8) {
            m2.f1044d.c(k(i3, null), (float) ((int) (m2.f1044d.g(n2) * -1.0f)));
        }
        c(m2);
    }

    public void g(g gVar, g gVar2, int i2, int i3) {
        b m2 = m();
        g n2 = n();
        n2.f1061d = 0;
        m2.f(gVar, gVar2, n2, i2);
        if (i3 != 8) {
            m2.f1044d.c(k(i3, null), (float) ((int) (m2.f1044d.g(n2) * -1.0f)));
        }
        c(m2);
    }

    public void h(g gVar, g gVar2, g gVar3, g gVar4, float f2, int i2) {
        b m2 = m();
        m2.d(gVar, gVar2, gVar3, gVar4, f2);
        if (i2 != 8) {
            m2.c(this, i2);
        }
        c(m2);
    }

    public final void i(b bVar) {
        int i2;
        if (bVar.f1045e) {
            bVar.a.d(this, bVar.b);
        } else {
            b[] bVarArr = this.f1049f;
            int i3 = this.f1053j;
            bVarArr[i3] = bVar;
            g gVar = bVar.a;
            gVar.c = i3;
            this.f1053j = i3 + 1;
            gVar.e(this, bVar);
        }
        if (this.a) {
            int i4 = 0;
            while (i4 < this.f1053j) {
                if (this.f1049f[i4] == null) {
                    System.out.println("WTF");
                }
                b[] bVarArr2 = this.f1049f;
                if (bVarArr2[i4] != null && bVarArr2[i4].f1045e) {
                    b bVar2 = bVarArr2[i4];
                    bVar2.a.d(this, bVar2.b);
                    this.f1055l.b.b(bVar2);
                    this.f1049f[i4] = null;
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (true) {
                        i2 = this.f1053j;
                        if (i5 >= i2) {
                            break;
                        }
                        b[] bVarArr3 = this.f1049f;
                        int i7 = i5 - 1;
                        bVarArr3[i7] = bVarArr3[i5];
                        if (bVarArr3[i7].a.c == i5) {
                            bVarArr3[i7].a.c = i7;
                        }
                        i6 = i5;
                        i5++;
                    }
                    if (i6 < i2) {
                        this.f1049f[i6] = null;
                    }
                    this.f1053j = i2 - 1;
                    i4--;
                }
                i4++;
            }
            this.a = false;
        }
    }

    public final void j() {
        for (int i2 = 0; i2 < this.f1053j; i2++) {
            b bVar = this.f1049f[i2];
            bVar.a.f1062e = bVar.b;
        }
    }

    public g k(int i2, String str) {
        if (this.f1052i + 1 >= this.f1048e) {
            p();
        }
        g a2 = a(g.a.ERROR, str);
        int i3 = this.b + 1;
        this.b = i3;
        this.f1052i++;
        a2.b = i3;
        a2.f1061d = i2;
        this.f1055l.f1046d[i3] = a2;
        this.c.a(a2);
        return a2;
    }

    public g l(Object obj) {
        g gVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f1052i + 1 >= this.f1048e) {
            p();
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            gVar = cVar.f1088i;
            if (gVar == null) {
                cVar.i();
                gVar = cVar.f1088i;
            }
            int i2 = gVar.b;
            if (i2 == -1 || i2 > this.b || this.f1055l.f1046d[i2] == null) {
                if (i2 != -1) {
                    gVar.c();
                }
                int i3 = this.b + 1;
                this.b = i3;
                this.f1052i++;
                gVar.b = i3;
                gVar.f1066i = g.a.UNRESTRICTED;
                this.f1055l.f1046d[i3] = gVar;
            }
        }
        return gVar;
    }

    public b m() {
        b a2 = this.f1055l.b.a();
        if (a2 == null) {
            a2 = new b(this.f1055l);
            r++;
        } else {
            a2.a = null;
            a2.f1044d.clear();
            a2.b = 0.0f;
            a2.f1045e = false;
        }
        g.n++;
        return a2;
    }

    public g n() {
        if (this.f1052i + 1 >= this.f1048e) {
            p();
        }
        g a2 = a(g.a.SLACK, null);
        int i2 = this.b + 1;
        this.b = i2;
        this.f1052i++;
        a2.b = i2;
        this.f1055l.f1046d[i2] = a2;
        return a2;
    }

    public int o(Object obj) {
        g gVar = ((c) obj).f1088i;
        if (gVar != null) {
            return (int) (gVar.f1062e + 0.5f);
        }
        return 0;
    }

    public final void p() {
        int i2 = this.f1047d * 2;
        this.f1047d = i2;
        this.f1049f = (b[]) Arrays.copyOf(this.f1049f, i2);
        c cVar = this.f1055l;
        cVar.f1046d = (g[]) Arrays.copyOf(cVar.f1046d, this.f1047d);
        int i3 = this.f1047d;
        this.f1051h = new boolean[i3];
        this.f1048e = i3;
        this.f1054k = i3;
    }

    public void q() {
        if (this.c.isEmpty()) {
            j();
            return;
        }
        if (this.f1050g) {
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f1053j) {
                    z = true;
                    break;
                } else if (!this.f1049f[i2].f1045e) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                j();
                return;
            }
        }
        r(this.c);
    }

    public void r(a aVar) {
        float f2;
        int i2;
        boolean z;
        g.a aVar2 = g.a.UNRESTRICTED;
        int i3 = 0;
        while (true) {
            f2 = 0.0f;
            i2 = 1;
            if (i3 >= this.f1053j) {
                z = false;
                break;
            }
            b[] bVarArr = this.f1049f;
            if (bVarArr[i3].a.f1066i != aVar2 && bVarArr[i3].b < 0.0f) {
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
                int i5 = 0;
                int i6 = -1;
                int i7 = -1;
                int i8 = 0;
                while (i5 < this.f1053j) {
                    b bVar = this.f1049f[i5];
                    if (bVar.a.f1066i != aVar2 && !bVar.f1045e && bVar.b < f2) {
                        int k2 = bVar.f1044d.k();
                        int i9 = 0;
                        while (i9 < k2) {
                            g f4 = bVar.f1044d.f(i9);
                            float g2 = bVar.f1044d.g(f4);
                            if (g2 > f2) {
                                for (int i10 = 0; i10 < 9; i10++) {
                                    float f5 = f4.f1064g[i10] / g2;
                                    if ((f5 < f3 && i10 == i8) || i10 > i8) {
                                        i7 = f4.b;
                                        i8 = i10;
                                        f3 = f5;
                                        i6 = i5;
                                    }
                                }
                            }
                            i9++;
                            f2 = 0.0f;
                        }
                    }
                    i5++;
                    f2 = 0.0f;
                }
                if (i6 != -1) {
                    b bVar2 = this.f1049f[i6];
                    bVar2.a.c = -1;
                    bVar2.j(this.f1055l.f1046d[i7]);
                    g gVar = bVar2.a;
                    gVar.c = i6;
                    gVar.e(this, bVar2);
                } else {
                    z2 = true;
                }
                if (i4 > this.f1052i / 2) {
                    z2 = true;
                }
                f2 = 0.0f;
                i2 = 1;
            }
        }
        s(aVar);
        j();
    }

    public final int s(a aVar) {
        for (int i2 = 0; i2 < this.f1052i; i2++) {
            this.f1051h[i2] = false;
        }
        boolean z = false;
        int i3 = 0;
        while (!z) {
            i3++;
            if (i3 >= this.f1052i * 2) {
                return i3;
            }
            g gVar = ((b) aVar).a;
            if (gVar != null) {
                this.f1051h[gVar.b] = true;
            }
            g b2 = aVar.b(this, this.f1051h);
            if (b2 != null) {
                boolean[] zArr = this.f1051h;
                int i4 = b2.b;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (b2 != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.f1053j; i6++) {
                    b bVar = this.f1049f[i6];
                    if (bVar.a.f1066i != g.a.UNRESTRICTED && !bVar.f1045e && bVar.f1044d.h(b2)) {
                        float g2 = bVar.f1044d.g(b2);
                        if (g2 < 0.0f) {
                            float f3 = (-bVar.b) / g2;
                            if (f3 < f2) {
                                i5 = i6;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    b bVar2 = this.f1049f[i5];
                    bVar2.a.c = -1;
                    bVar2.j(b2);
                    g gVar2 = bVar2.a;
                    gVar2.c = i5;
                    gVar2.e(this, bVar2);
                }
            } else {
                z = true;
            }
        }
        return i3;
    }

    public final void t() {
        for (int i2 = 0; i2 < this.f1053j; i2++) {
            b bVar = this.f1049f[i2];
            if (bVar != null) {
                this.f1055l.b.b(bVar);
            }
            this.f1049f[i2] = null;
        }
    }

    public void u() {
        c cVar;
        int i2 = 0;
        while (true) {
            cVar = this.f1055l;
            g[] gVarArr = cVar.f1046d;
            if (i2 >= gVarArr.length) {
                break;
            }
            g gVar = gVarArr[i2];
            if (gVar != null) {
                gVar.c();
            }
            i2++;
        }
        e<g> eVar = cVar.c;
        g[] gVarArr2 = this.m;
        int i3 = this.n;
        Objects.requireNonNull(eVar);
        if (i3 > gVarArr2.length) {
            i3 = gVarArr2.length;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            g gVar2 = gVarArr2[i4];
            int i5 = eVar.b;
            Object[] objArr = eVar.a;
            if (i5 < objArr.length) {
                objArr[i5] = gVar2;
                eVar.b = i5 + 1;
            }
        }
        this.n = 0;
        Arrays.fill(this.f1055l.f1046d, (Object) null);
        this.b = 0;
        this.c.clear();
        this.f1052i = 1;
        for (int i6 = 0; i6 < this.f1053j; i6++) {
            b[] bVarArr = this.f1049f;
            if (bVarArr[i6] != null) {
                Objects.requireNonNull(bVarArr[i6]);
            }
        }
        t();
        this.f1053j = 0;
        this.o = new b(this.f1055l);
    }
}
