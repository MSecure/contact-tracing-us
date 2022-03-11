package e.h.a;

import e.h.a.d;
import e.h.a.g;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b implements d.a {

    /* renamed from: d */
    public a f1338d;
    public g a = null;
    public float b = 0.0f;
    public ArrayList<g> c = new ArrayList<>();

    /* renamed from: e */
    public boolean f1339e = false;

    /* loaded from: classes.dex */
    public interface a {
        float a(int i2);

        float b(g gVar);

        float c(g gVar, boolean z);

        void clear();

        boolean d(g gVar);

        float e(b bVar, boolean z);

        void f(g gVar, float f2);

        g g(int i2);

        void h(g gVar, float f2, boolean z);

        void i(float f2);

        void j();

        int k();
    }

    public b() {
    }

    public b(c cVar) {
        this.f1338d = new a(this, cVar);
    }

    @Override // e.h.a.d.a
    public g a(d dVar, boolean[] zArr) {
        return i(zArr, null);
    }

    @Override // e.h.a.d.a
    public void b(g gVar) {
        float f2;
        int i2 = gVar.f1356e;
        if (i2 != 1) {
            if (i2 == 2) {
                f2 = 1000.0f;
            } else if (i2 == 3) {
                f2 = 1000000.0f;
            } else if (i2 == 4) {
                f2 = 1.0E9f;
            } else if (i2 == 5) {
                f2 = 1.0E12f;
            }
            this.f1338d.f(gVar, f2);
        }
        f2 = 1.0f;
        this.f1338d.f(gVar, f2);
    }

    public b c(d dVar, int i2) {
        this.f1338d.f(dVar.k(i2, "ep"), 1.0f);
        this.f1338d.f(dVar.k(i2, "em"), -1.0f);
        return this;
    }

    @Override // e.h.a.d.a
    public void clear() {
        this.f1338d.clear();
        this.a = null;
        this.b = 0.0f;
    }

    public b d(g gVar, g gVar2, g gVar3, g gVar4, float f2) {
        this.f1338d.f(gVar, -1.0f);
        this.f1338d.f(gVar2, 1.0f);
        this.f1338d.f(gVar3, f2);
        this.f1338d.f(gVar4, -f2);
        return this;
    }

    public b e(g gVar, g gVar2, g gVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.b = (float) i2;
        }
        if (!z) {
            this.f1338d.f(gVar, -1.0f);
            this.f1338d.f(gVar2, 1.0f);
            this.f1338d.f(gVar3, 1.0f);
        } else {
            this.f1338d.f(gVar, 1.0f);
            this.f1338d.f(gVar2, -1.0f);
            this.f1338d.f(gVar3, -1.0f);
        }
        return this;
    }

    public b f(g gVar, g gVar2, g gVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.b = (float) i2;
        }
        if (!z) {
            this.f1338d.f(gVar, -1.0f);
            this.f1338d.f(gVar2, 1.0f);
            this.f1338d.f(gVar3, -1.0f);
        } else {
            this.f1338d.f(gVar, 1.0f);
            this.f1338d.f(gVar2, -1.0f);
            this.f1338d.f(gVar3, 1.0f);
        }
        return this;
    }

    public b g(g gVar, g gVar2, g gVar3, g gVar4, float f2) {
        this.f1338d.f(gVar3, 0.5f);
        this.f1338d.f(gVar4, 0.5f);
        this.f1338d.f(gVar, -0.5f);
        this.f1338d.f(gVar2, -0.5f);
        this.b = -f2;
        return this;
    }

    public final boolean h(g gVar) {
        return gVar.m <= 1;
    }

    public final g i(boolean[] zArr, g gVar) {
        g.a aVar;
        int k2 = this.f1338d.k();
        g gVar2 = null;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < k2; i2++) {
            float a2 = this.f1338d.a(i2);
            if (a2 < 0.0f) {
                g g2 = this.f1338d.g(i2);
                if ((zArr == null || !zArr[g2.c]) && g2 != gVar && (((aVar = g2.f1361j) == g.a.SLACK || aVar == g.a.ERROR) && a2 < f2)) {
                    f2 = a2;
                    gVar2 = g2;
                }
            }
        }
        return gVar2;
    }

    @Override // e.h.a.d.a
    public boolean isEmpty() {
        return this.a == null && this.b == 0.0f && this.f1338d.k() == 0;
    }

    public void j(g gVar) {
        g gVar2 = this.a;
        if (gVar2 != null) {
            this.f1338d.f(gVar2, -1.0f);
            this.a.f1355d = -1;
            this.a = null;
        }
        float c = this.f1338d.c(gVar, true) * -1.0f;
        this.a = gVar;
        if (c != 1.0f) {
            this.b /= c;
            this.f1338d.i(c);
        }
    }

    public void k(d dVar, g gVar, boolean z) {
        if (gVar.f1358g) {
            float b = this.f1338d.b(gVar);
            this.b = (gVar.f1357f * b) + this.b;
            this.f1338d.c(gVar, z);
            if (z) {
                gVar.b(this);
            }
            if (this.f1338d.k() == 0) {
                this.f1339e = true;
                dVar.a = true;
            }
        }
    }

    public void l(d dVar, b bVar, boolean z) {
        float e2 = this.f1338d.e(bVar, z);
        this.b = (bVar.b * e2) + this.b;
        if (z) {
            bVar.a.b(this);
        }
        if (this.a != null && this.f1338d.k() == 0) {
            this.f1339e = true;
            dVar.a = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public String toString() {
        String str;
        boolean z;
        float a2;
        int i2;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        if (this.a == null) {
            str = "0";
        } else {
            StringBuilder h2 = f.a.a.a.a.h("");
            h2.append(this.a);
            str = h2.toString();
        }
        String x = f.a.a.a.a.x(str, " = ");
        if (this.b != 0.0f) {
            StringBuilder h3 = f.a.a.a.a.h(x);
            h3.append(this.b);
            x = h3.toString();
            z = true;
        } else {
            z = false;
        }
        int k2 = this.f1338d.k();
        for (int i3 = 0; i3 < k2; i3++) {
            g g2 = this.f1338d.g(i3);
            if (!(g2 == null || (a2 = this.f1338d.a(i3)) == 0.0f)) {
                String gVar = g2.toString();
                if (!z) {
                    if (a2 < 0.0f) {
                        sb2 = f.a.a.a.a.h(x);
                        str2 = "- ";
                        sb2.append(str2);
                        x = sb2.toString();
                        a2 *= -1.0f;
                    }
                    if (a2 == 1.0f) {
                        sb = new StringBuilder();
                    } else {
                        sb = new StringBuilder();
                        sb.append(x);
                        sb.append(a2);
                        x = " ";
                    }
                    x = f.a.a.a.a.e(sb, x, gVar);
                    z = true;
                } else {
                    sb2 = f.a.a.a.a.h(x);
                    if (i2 > 0) {
                        sb2.append(" + ");
                        x = sb2.toString();
                        if (a2 == 1.0f) {
                        }
                        x = f.a.a.a.a.e(sb, x, gVar);
                        z = true;
                    } else {
                        str2 = " - ";
                        sb2.append(str2);
                        x = sb2.toString();
                        a2 *= -1.0f;
                        if (a2 == 1.0f) {
                        }
                        x = f.a.a.a.a.e(sb, x, gVar);
                        z = true;
                    }
                }
            }
        }
        return !z ? f.a.a.a.a.x(x, "0.0") : x;
    }
}
