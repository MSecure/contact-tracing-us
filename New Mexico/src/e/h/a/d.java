package e.h.a;

import e.h.a.b;
import e.h.a.g;
import e.h.a.i.c;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes.dex */
public class d {
    public static boolean p;
    public static int q;
    public static long r;
    public a c;

    /* renamed from: f */
    public b[] f1343f;

    /* renamed from: l */
    public final c f1349l;
    public a o;
    public boolean a = false;
    public int b = 0;

    /* renamed from: d */
    public int f1341d = 32;

    /* renamed from: e */
    public int f1342e = 32;

    /* renamed from: g */
    public boolean f1344g = false;

    /* renamed from: h */
    public boolean[] f1345h = new boolean[32];

    /* renamed from: i */
    public int f1346i = 1;

    /* renamed from: j */
    public int f1347j = 0;

    /* renamed from: k */
    public int f1348k = 32;
    public g[] m = new g[q];
    public int n = 0;

    /* loaded from: classes.dex */
    public interface a {
        g a(d dVar, boolean[] zArr);

        void b(g gVar);

        void clear();

        boolean isEmpty();
    }

    public d() {
        this.f1343f = null;
        this.f1343f = new b[32];
        t();
        c cVar = new c();
        this.f1349l = cVar;
        this.c = new f(cVar);
        this.o = new b(cVar);
    }

    public final g a(g.a aVar, String str) {
        g a2 = this.f1349l.c.a();
        if (a2 == null) {
            a2 = new g(aVar);
        } else {
            a2.c();
        }
        a2.f1361j = aVar;
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
        b m = m();
        if (gVar2 == gVar3) {
            m.f1338d.f(gVar, 1.0f);
            m.f1338d.f(gVar4, 1.0f);
            m.f1338d.f(gVar2, -2.0f);
        } else {
            if (f2 == 0.5f) {
                m.f1338d.f(gVar, 1.0f);
                m.f1338d.f(gVar2, -1.0f);
                m.f1338d.f(gVar3, -1.0f);
                m.f1338d.f(gVar4, 1.0f);
                if (i2 > 0 || i3 > 0) {
                    i5 = (-i2) + i3;
                    f3 = (float) i5;
                }
            } else if (f2 <= 0.0f) {
                m.f1338d.f(gVar, -1.0f);
                m.f1338d.f(gVar2, 1.0f);
                f3 = (float) i2;
            } else if (f2 >= 1.0f) {
                m.f1338d.f(gVar4, -1.0f);
                m.f1338d.f(gVar3, 1.0f);
                i5 = -i3;
                f3 = (float) i5;
            } else {
                float f4 = 1.0f - f2;
                m.f1338d.f(gVar, f4 * 1.0f);
                m.f1338d.f(gVar2, f4 * -1.0f);
                m.f1338d.f(gVar3, -1.0f * f2);
                m.f1338d.f(gVar4, 1.0f * f2);
                if (i2 > 0 || i3 > 0) {
                    m.b = (((float) i3) * f2) + (((float) (-i2)) * f4);
                }
            }
            m.b = f3;
        }
        if (i4 != 8) {
            m.c(this, i4);
        }
        c(m);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b0  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void c(b bVar) {
        boolean z;
        boolean z2;
        boolean z3;
        g gVar;
        g i2;
        g.a aVar = g.a.UNRESTRICTED;
        boolean z4 = true;
        if (this.f1347j + 1 >= this.f1348k || this.f1346i + 1 >= this.f1342e) {
            p();
        }
        if (!bVar.f1339e) {
            if (this.f1343f.length != 0) {
                boolean z5 = false;
                while (!z5) {
                    int k2 = bVar.f1338d.k();
                    for (int i3 = 0; i3 < k2; i3++) {
                        g g2 = bVar.f1338d.g(i3);
                        if (g2.f1355d != -1 || g2.f1358g) {
                            bVar.c.add(g2);
                        }
                    }
                    int size = bVar.c.size();
                    if (size > 0) {
                        for (int i4 = 0; i4 < size; i4++) {
                            g gVar2 = bVar.c.get(i4);
                            if (gVar2.f1358g) {
                                bVar.k(this, gVar2, true);
                            } else {
                                bVar.l(this, this.f1343f[gVar2.f1355d], true);
                            }
                        }
                        bVar.c.clear();
                    } else {
                        z5 = true;
                    }
                }
                if (bVar.a != null && bVar.f1338d.k() == 0) {
                    bVar.f1339e = true;
                    this.a = true;
                }
            }
            if (!bVar.isEmpty()) {
                float f2 = bVar.b;
                if (f2 < 0.0f) {
                    bVar.b = f2 * -1.0f;
                    bVar.f1338d.j();
                }
                int k3 = bVar.f1338d.k();
                g gVar3 = null;
                g gVar4 = null;
                float f3 = 0.0f;
                boolean z6 = false;
                float f4 = 0.0f;
                boolean z7 = false;
                for (int i5 = 0; i5 < k3; i5++) {
                    float a2 = bVar.f1338d.a(i5);
                    g g3 = bVar.f1338d.g(i5);
                    if (g3.f1361j == aVar) {
                        if (gVar3 == null || f3 > a2) {
                            z6 = bVar.h(g3);
                            f3 = a2;
                            gVar3 = g3;
                        } else if (!z6 && bVar.h(g3)) {
                            f3 = a2;
                            gVar3 = g3;
                            z6 = true;
                        }
                    } else if (gVar3 == null && a2 < 0.0f) {
                        if (gVar4 == null || f4 > a2) {
                            z7 = bVar.h(g3);
                            f4 = a2;
                            gVar4 = g3;
                        } else if (!z7 && bVar.h(g3)) {
                            f4 = a2;
                            gVar4 = g3;
                            z7 = true;
                        }
                    }
                }
                if (gVar3 == null) {
                    gVar3 = gVar4;
                }
                if (gVar3 == null) {
                    z2 = true;
                } else {
                    bVar.j(gVar3);
                    z2 = false;
                }
                if (bVar.f1338d.k() == 0) {
                    bVar.f1339e = true;
                }
                if (z2) {
                    if (this.f1346i + 1 >= this.f1342e) {
                        p();
                    }
                    g a3 = a(g.a.SLACK, null);
                    int i6 = this.b + 1;
                    this.b = i6;
                    this.f1346i++;
                    a3.c = i6;
                    this.f1349l.f1340d[i6] = a3;
                    bVar.a = a3;
                    int i7 = this.f1347j;
                    i(bVar);
                    if (this.f1347j == i7 + 1) {
                        b bVar2 = (b) this.o;
                        Objects.requireNonNull(bVar2);
                        bVar2.a = null;
                        bVar2.f1338d.clear();
                        for (int i8 = 0; i8 < bVar.f1338d.k(); i8++) {
                            bVar2.f1338d.h(bVar.f1338d.g(i8), bVar.f1338d.a(i8), true);
                        }
                        s(this.o);
                        if (a3.f1355d == -1) {
                            if (bVar.a == a3 && (i2 = bVar.i(null, a3)) != null) {
                                bVar.j(i2);
                            }
                            if (!bVar.f1339e) {
                                bVar.a.f(this, bVar);
                            }
                            this.f1349l.b.b(bVar);
                            this.f1347j--;
                        }
                        z3 = true;
                        gVar = bVar.a;
                        if (gVar != null || (gVar.f1361j != aVar && bVar.b < 0.0f)) {
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
                gVar = bVar.a;
                if (gVar != null) {
                }
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
        if (i3 == 8 && gVar2.f1358g && gVar.f1355d == -1) {
            gVar.e(this, gVar2.f1357f + ((float) i2));
            return null;
        }
        b m = m();
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            m.b = (float) i2;
        }
        if (!z) {
            m.f1338d.f(gVar, -1.0f);
            m.f1338d.f(gVar2, 1.0f);
        } else {
            m.f1338d.f(gVar, 1.0f);
            m.f1338d.f(gVar2, -1.0f);
        }
        if (i3 != 8) {
            m.c(this, i3);
        }
        c(m);
        return m;
    }

    public void e(g gVar, int i2) {
        b bVar;
        b.a aVar;
        float f2;
        int i3 = gVar.f1355d;
        if (i3 == -1) {
            gVar.e(this, (float) i2);
            for (int i4 = 0; i4 < this.b + 1; i4++) {
                g gVar2 = this.f1349l.f1340d[i4];
            }
            return;
        }
        if (i3 != -1) {
            b bVar2 = this.f1343f[i3];
            if (!bVar2.f1339e) {
                if (bVar2.f1338d.k() == 0) {
                    bVar2.f1339e = true;
                } else {
                    bVar = m();
                    if (i2 < 0) {
                        bVar.b = (float) (i2 * -1);
                        aVar = bVar.f1338d;
                        f2 = 1.0f;
                    } else {
                        bVar.b = (float) i2;
                        aVar = bVar.f1338d;
                        f2 = -1.0f;
                    }
                    aVar.f(gVar, f2);
                }
            }
            bVar2.b = (float) i2;
            return;
        }
        bVar = m();
        bVar.a = gVar;
        float f3 = (float) i2;
        gVar.f1357f = f3;
        bVar.b = f3;
        bVar.f1339e = true;
        c(bVar);
    }

    public void f(g gVar, g gVar2, int i2, int i3) {
        b m = m();
        g n = n();
        n.f1356e = 0;
        m.e(gVar, gVar2, n, i2);
        if (i3 != 8) {
            m.f1338d.f(k(i3, null), (float) ((int) (m.f1338d.b(n) * -1.0f)));
        }
        c(m);
    }

    public void g(g gVar, g gVar2, int i2, int i3) {
        b m = m();
        g n = n();
        n.f1356e = 0;
        m.f(gVar, gVar2, n, i2);
        if (i3 != 8) {
            m.f1338d.f(k(i3, null), (float) ((int) (m.f1338d.b(n) * -1.0f)));
        }
        c(m);
    }

    public void h(g gVar, g gVar2, g gVar3, g gVar4, float f2, int i2) {
        b m = m();
        m.d(gVar, gVar2, gVar3, gVar4, f2);
        if (i2 != 8) {
            m.c(this, i2);
        }
        c(m);
    }

    public final void i(b bVar) {
        int i2;
        if (bVar.f1339e) {
            bVar.a.e(this, bVar.b);
        } else {
            b[] bVarArr = this.f1343f;
            int i3 = this.f1347j;
            bVarArr[i3] = bVar;
            g gVar = bVar.a;
            gVar.f1355d = i3;
            this.f1347j = i3 + 1;
            gVar.f(this, bVar);
        }
        if (this.a) {
            int i4 = 0;
            while (i4 < this.f1347j) {
                if (this.f1343f[i4] == null) {
                    System.out.println("WTF");
                }
                b[] bVarArr2 = this.f1343f;
                if (bVarArr2[i4] != null && bVarArr2[i4].f1339e) {
                    b bVar2 = bVarArr2[i4];
                    bVar2.a.e(this, bVar2.b);
                    this.f1349l.b.b(bVar2);
                    this.f1343f[i4] = null;
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (true) {
                        i2 = this.f1347j;
                        if (i5 >= i2) {
                            break;
                        }
                        b[] bVarArr3 = this.f1343f;
                        int i7 = i5 - 1;
                        bVarArr3[i7] = bVarArr3[i5];
                        if (bVarArr3[i7].a.f1355d == i5) {
                            bVarArr3[i7].a.f1355d = i7;
                        }
                        i5++;
                        i6 = i5;
                    }
                    if (i6 < i2) {
                        this.f1343f[i6] = null;
                    }
                    this.f1347j = i2 - 1;
                    i4--;
                }
                i4++;
            }
            this.a = false;
        }
    }

    public final void j() {
        for (int i2 = 0; i2 < this.f1347j; i2++) {
            b bVar = this.f1343f[i2];
            bVar.a.f1357f = bVar.b;
        }
    }

    public g k(int i2, String str) {
        if (this.f1346i + 1 >= this.f1342e) {
            p();
        }
        g a2 = a(g.a.ERROR, str);
        int i3 = this.b + 1;
        this.b = i3;
        this.f1346i++;
        a2.c = i3;
        a2.f1356e = i2;
        this.f1349l.f1340d[i3] = a2;
        this.c.b(a2);
        return a2;
    }

    public g l(Object obj) {
        g gVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f1346i + 1 >= this.f1342e) {
            p();
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            gVar = cVar.f1382i;
            if (gVar == null) {
                cVar.i();
                gVar = cVar.f1382i;
            }
            int i2 = gVar.c;
            if (i2 == -1 || i2 > this.b || this.f1349l.f1340d[i2] == null) {
                if (i2 != -1) {
                    gVar.c();
                }
                int i3 = this.b + 1;
                this.b = i3;
                this.f1346i++;
                gVar.c = i3;
                gVar.f1361j = g.a.UNRESTRICTED;
                this.f1349l.f1340d[i3] = gVar;
            }
        }
        return gVar;
    }

    public b m() {
        b a2 = this.f1349l.b.a();
        if (a2 == null) {
            a2 = new b(this.f1349l);
            r++;
        } else {
            a2.a = null;
            a2.f1338d.clear();
            a2.b = 0.0f;
            a2.f1339e = false;
        }
        g.o++;
        return a2;
    }

    public g n() {
        if (this.f1346i + 1 >= this.f1342e) {
            p();
        }
        g a2 = a(g.a.SLACK, null);
        int i2 = this.b + 1;
        this.b = i2;
        this.f1346i++;
        a2.c = i2;
        this.f1349l.f1340d[i2] = a2;
        return a2;
    }

    public int o(Object obj) {
        g gVar = ((c) obj).f1382i;
        if (gVar != null) {
            return (int) (gVar.f1357f + 0.5f);
        }
        return 0;
    }

    public final void p() {
        int i2 = this.f1341d * 2;
        this.f1341d = i2;
        this.f1343f = (b[]) Arrays.copyOf(this.f1343f, i2);
        c cVar = this.f1349l;
        cVar.f1340d = (g[]) Arrays.copyOf(cVar.f1340d, this.f1341d);
        int i3 = this.f1341d;
        this.f1345h = new boolean[i3];
        this.f1342e = i3;
        this.f1348k = i3;
    }

    public void q() {
        if (this.c.isEmpty()) {
            j();
            return;
        }
        if (this.f1344g) {
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f1347j) {
                    z = true;
                    break;
                } else if (!this.f1343f[i2].f1339e) {
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
            if (i3 >= this.f1347j) {
                z = false;
                break;
            }
            b[] bVarArr = this.f1343f;
            if (bVarArr[i3].a.f1361j != aVar2 && bVarArr[i3].b < 0.0f) {
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
                while (i5 < this.f1347j) {
                    b bVar = this.f1343f[i5];
                    if (bVar.a.f1361j != aVar2 && !bVar.f1339e && bVar.b < f2) {
                        int k2 = bVar.f1338d.k();
                        int i9 = 0;
                        while (i9 < k2) {
                            g g2 = bVar.f1338d.g(i9);
                            float b = bVar.f1338d.b(g2);
                            if (b > f2) {
                                for (int i10 = 0; i10 < 9; i10++) {
                                    float f4 = g2.f1359h[i10] / b;
                                    if ((f4 < f3 && i10 == i8) || i10 > i8) {
                                        i7 = g2.c;
                                        i8 = i10;
                                        f3 = f4;
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
                    b bVar2 = this.f1343f[i6];
                    bVar2.a.f1355d = -1;
                    bVar2.j(this.f1349l.f1340d[i7]);
                    g gVar = bVar2.a;
                    gVar.f1355d = i6;
                    gVar.f(this, bVar2);
                } else {
                    z2 = true;
                }
                if (i4 > this.f1346i / 2) {
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
        for (int i2 = 0; i2 < this.f1346i; i2++) {
            this.f1345h[i2] = false;
        }
        boolean z = false;
        int i3 = 0;
        while (!z) {
            i3++;
            if (i3 >= this.f1346i * 2) {
                return i3;
            }
            g gVar = ((b) aVar).a;
            if (gVar != null) {
                this.f1345h[gVar.c] = true;
            }
            g a2 = aVar.a(this, this.f1345h);
            if (a2 != null) {
                boolean[] zArr = this.f1345h;
                int i4 = a2.c;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (a2 != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.f1347j; i6++) {
                    b bVar = this.f1343f[i6];
                    if (bVar.a.f1361j != g.a.UNRESTRICTED && !bVar.f1339e && bVar.f1338d.d(a2)) {
                        float b = bVar.f1338d.b(a2);
                        if (b < 0.0f) {
                            float f3 = (-bVar.b) / b;
                            if (f3 < f2) {
                                i5 = i6;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    b bVar2 = this.f1343f[i5];
                    bVar2.a.f1355d = -1;
                    bVar2.j(a2);
                    g gVar2 = bVar2.a;
                    gVar2.f1355d = i5;
                    gVar2.f(this, bVar2);
                }
            } else {
                z = true;
            }
        }
        return i3;
    }

    public final void t() {
        for (int i2 = 0; i2 < this.f1347j; i2++) {
            b bVar = this.f1343f[i2];
            if (bVar != null) {
                this.f1349l.b.b(bVar);
            }
            this.f1343f[i2] = null;
        }
    }

    public void u() {
        c cVar;
        int i2 = 0;
        while (true) {
            cVar = this.f1349l;
            g[] gVarArr = cVar.f1340d;
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
        Arrays.fill(this.f1349l.f1340d, (Object) null);
        this.b = 0;
        this.c.clear();
        this.f1346i = 1;
        for (int i6 = 0; i6 < this.f1347j; i6++) {
            b[] bVarArr = this.f1343f;
            if (bVarArr[i6] != null) {
                Objects.requireNonNull(bVarArr[i6]);
            }
        }
        t();
        this.f1347j = 0;
        this.o = new b(this.f1349l);
    }
}
