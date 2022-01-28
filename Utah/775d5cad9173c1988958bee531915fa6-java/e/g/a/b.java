package e.g.a;

import e.g.a.d;
import e.g.a.g;
import java.util.ArrayList;

public class b implements d.a {
    public g a = null;
    public float b = 0.0f;
    public ArrayList<g> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public a f1254d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1255e = false;

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
        this.f1254d = new a(this, cVar);
    }

    @Override // e.g.a.d.a
    public g a(d dVar, boolean[] zArr) {
        return i(zArr, null);
    }

    @Override // e.g.a.d.a
    public void b(g gVar) {
        float f2;
        int i2 = gVar.f1272e;
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
            this.f1254d.f(gVar, f2);
        }
        f2 = 1.0f;
        this.f1254d.f(gVar, f2);
    }

    public b c(d dVar, int i2) {
        this.f1254d.f(dVar.k(i2, "ep"), 1.0f);
        this.f1254d.f(dVar.k(i2, "em"), -1.0f);
        return this;
    }

    @Override // e.g.a.d.a
    public void clear() {
        this.f1254d.clear();
        this.a = null;
        this.b = 0.0f;
    }

    public b d(g gVar, g gVar2, g gVar3, g gVar4, float f2) {
        this.f1254d.f(gVar, -1.0f);
        this.f1254d.f(gVar2, 1.0f);
        this.f1254d.f(gVar3, f2);
        this.f1254d.f(gVar4, -f2);
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
            this.f1254d.f(gVar, -1.0f);
            this.f1254d.f(gVar2, 1.0f);
            this.f1254d.f(gVar3, 1.0f);
        } else {
            this.f1254d.f(gVar, 1.0f);
            this.f1254d.f(gVar2, -1.0f);
            this.f1254d.f(gVar3, -1.0f);
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
            this.f1254d.f(gVar, -1.0f);
            this.f1254d.f(gVar2, 1.0f);
            this.f1254d.f(gVar3, -1.0f);
        } else {
            this.f1254d.f(gVar, 1.0f);
            this.f1254d.f(gVar2, -1.0f);
            this.f1254d.f(gVar3, 1.0f);
        }
        return this;
    }

    public b g(g gVar, g gVar2, g gVar3, g gVar4, float f2) {
        this.f1254d.f(gVar3, 0.5f);
        this.f1254d.f(gVar4, 0.5f);
        this.f1254d.f(gVar, -0.5f);
        this.f1254d.f(gVar2, -0.5f);
        this.b = -f2;
        return this;
    }

    public final boolean h(g gVar) {
        return gVar.m <= 1;
    }

    public final g i(boolean[] zArr, g gVar) {
        g.a aVar;
        int k2 = this.f1254d.k();
        g gVar2 = null;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < k2; i2++) {
            float a2 = this.f1254d.a(i2);
            if (a2 < 0.0f) {
                g g2 = this.f1254d.g(i2);
                if ((zArr == null || !zArr[g2.c]) && g2 != gVar && (((aVar = g2.f1277j) == g.a.SLACK || aVar == g.a.ERROR) && a2 < f2)) {
                    f2 = a2;
                    gVar2 = g2;
                }
            }
        }
        return gVar2;
    }

    @Override // e.g.a.d.a
    public boolean isEmpty() {
        return this.a == null && this.b == 0.0f && this.f1254d.k() == 0;
    }

    public void j(g gVar) {
        g gVar2 = this.a;
        if (gVar2 != null) {
            this.f1254d.f(gVar2, -1.0f);
            this.a.f1271d = -1;
            this.a = null;
        }
        float c2 = this.f1254d.c(gVar, true) * -1.0f;
        this.a = gVar;
        if (c2 != 1.0f) {
            this.b /= c2;
            this.f1254d.i(c2);
        }
    }

    public void k(d dVar, g gVar, boolean z) {
        if (gVar.f1274g) {
            float b2 = this.f1254d.b(gVar);
            this.b = (gVar.f1273f * b2) + this.b;
            this.f1254d.c(gVar, z);
            if (z) {
                gVar.b(this);
            }
            if (this.f1254d.k() == 0) {
                this.f1255e = true;
                dVar.a = true;
            }
        }
    }

    public void l(d dVar, b bVar, boolean z) {
        float e2 = this.f1254d.e(bVar, z);
        this.b = (bVar.b * e2) + this.b;
        if (z) {
            bVar.a.b(this);
        }
        if (this.a != null && this.f1254d.k() == 0) {
            this.f1255e = true;
            dVar.a = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
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
        String w = f.a.a.a.a.w(str, " = ");
        if (this.b != 0.0f) {
            StringBuilder h3 = f.a.a.a.a.h(w);
            h3.append(this.b);
            w = h3.toString();
            z = true;
        } else {
            z = false;
        }
        int k2 = this.f1254d.k();
        for (int i3 = 0; i3 < k2; i3++) {
            g g2 = this.f1254d.g(i3);
            if (!(g2 == null || (a2 = this.f1254d.a(i3)) == 0.0f)) {
                String gVar = g2.toString();
                if (!z) {
                    if (a2 < 0.0f) {
                        sb2 = f.a.a.a.a.h(w);
                        str2 = "- ";
                    }
                    if (a2 == 1.0f) {
                        sb = new StringBuilder();
                    } else {
                        sb = new StringBuilder();
                        sb.append(w);
                        sb.append(a2);
                        w = " ";
                    }
                    w = f.a.a.a.a.e(sb, w, gVar);
                    z = true;
                } else {
                    sb2 = f.a.a.a.a.h(w);
                    if (i2 > 0) {
                        sb2.append(" + ");
                        w = sb2.toString();
                        if (a2 == 1.0f) {
                        }
                        w = f.a.a.a.a.e(sb, w, gVar);
                        z = true;
                    } else {
                        str2 = " - ";
                    }
                }
                sb2.append(str2);
                w = sb2.toString();
                a2 *= -1.0f;
                if (a2 == 1.0f) {
                }
                w = f.a.a.a.a.e(sb, w, gVar);
                z = true;
            }
        }
        return !z ? f.a.a.a.a.w(w, "0.0") : w;
    }
}
