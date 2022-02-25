package e.g.b;

import e.g.b.d;
import e.g.b.g;
import java.util.ArrayList;

public class b implements d.a {
    public g a = null;
    public float b = 0.0f;
    public ArrayList<g> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public a f1221d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1222e = false;

    public interface a {
        float a(int i2);

        float b(b bVar, boolean z);

        void c(g gVar, float f2);

        void clear();

        float d(g gVar, boolean z);

        void e(g gVar, float f2, boolean z);

        g f(int i2);

        float g(g gVar);

        boolean h(g gVar);

        void i(float f2);

        void j();

        int k();
    }

    public b() {
    }

    public b(c cVar) {
        this.f1221d = new a(this, cVar);
    }

    @Override // e.g.b.d.a
    public void a(g gVar) {
        float f2;
        int i2 = gVar.f1238d;
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
            this.f1221d.c(gVar, f2);
        }
        f2 = 1.0f;
        this.f1221d.c(gVar, f2);
    }

    @Override // e.g.b.d.a
    public g b(d dVar, boolean[] zArr) {
        return i(zArr, null);
    }

    public b c(d dVar, int i2) {
        this.f1221d.c(dVar.k(i2, "ep"), 1.0f);
        this.f1221d.c(dVar.k(i2, "em"), -1.0f);
        return this;
    }

    @Override // e.g.b.d.a
    public void clear() {
        this.f1221d.clear();
        this.a = null;
        this.b = 0.0f;
    }

    public b d(g gVar, g gVar2, g gVar3, g gVar4, float f2) {
        this.f1221d.c(gVar, -1.0f);
        this.f1221d.c(gVar2, 1.0f);
        this.f1221d.c(gVar3, f2);
        this.f1221d.c(gVar4, -f2);
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
            this.f1221d.c(gVar, -1.0f);
            this.f1221d.c(gVar2, 1.0f);
            this.f1221d.c(gVar3, 1.0f);
        } else {
            this.f1221d.c(gVar, 1.0f);
            this.f1221d.c(gVar2, -1.0f);
            this.f1221d.c(gVar3, -1.0f);
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
            this.f1221d.c(gVar, -1.0f);
            this.f1221d.c(gVar2, 1.0f);
            this.f1221d.c(gVar3, -1.0f);
        } else {
            this.f1221d.c(gVar, 1.0f);
            this.f1221d.c(gVar2, -1.0f);
            this.f1221d.c(gVar3, 1.0f);
        }
        return this;
    }

    public b g(g gVar, g gVar2, g gVar3, g gVar4, float f2) {
        this.f1221d.c(gVar3, 0.5f);
        this.f1221d.c(gVar4, 0.5f);
        this.f1221d.c(gVar, -0.5f);
        this.f1221d.c(gVar2, -0.5f);
        this.b = -f2;
        return this;
    }

    public final boolean h(g gVar) {
        return gVar.f1246l <= 1;
    }

    public final g i(boolean[] zArr, g gVar) {
        g.a aVar;
        int k2 = this.f1221d.k();
        g gVar2 = null;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < k2; i2++) {
            float a2 = this.f1221d.a(i2);
            if (a2 < 0.0f) {
                g f3 = this.f1221d.f(i2);
                if ((zArr == null || !zArr[f3.b]) && f3 != gVar && (((aVar = f3.f1243i) == g.a.SLACK || aVar == g.a.ERROR) && a2 < f2)) {
                    f2 = a2;
                    gVar2 = f3;
                }
            }
        }
        return gVar2;
    }

    @Override // e.g.b.d.a
    public boolean isEmpty() {
        return this.a == null && this.b == 0.0f && this.f1221d.k() == 0;
    }

    public void j(g gVar) {
        g gVar2 = this.a;
        if (gVar2 != null) {
            this.f1221d.c(gVar2, -1.0f);
            this.a.c = -1;
            this.a = null;
        }
        float d2 = this.f1221d.d(gVar, true) * -1.0f;
        this.a = gVar;
        if (d2 != 1.0f) {
            this.b /= d2;
            this.f1221d.i(d2);
        }
    }

    public void k(d dVar, g gVar, boolean z) {
        if (gVar.f1240f) {
            float g2 = this.f1221d.g(gVar);
            this.b = (gVar.f1239e * g2) + this.b;
            this.f1221d.d(gVar, z);
            if (z) {
                gVar.b(this);
            }
            if (this.f1221d.k() == 0) {
                this.f1222e = true;
                dVar.a = true;
            }
        }
    }

    public void l(d dVar, b bVar, boolean z) {
        float b2 = this.f1221d.b(bVar, z);
        this.b = (bVar.b * b2) + this.b;
        if (z) {
            bVar.a.b(this);
        }
        if (this.a != null && this.f1221d.k() == 0) {
            this.f1222e = true;
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
        String t = f.a.a.a.a.t(str, " = ");
        if (this.b != 0.0f) {
            StringBuilder h3 = f.a.a.a.a.h(t);
            h3.append(this.b);
            t = h3.toString();
            z = true;
        } else {
            z = false;
        }
        int k2 = this.f1221d.k();
        for (int i3 = 0; i3 < k2; i3++) {
            g f2 = this.f1221d.f(i3);
            if (!(f2 == null || (a2 = this.f1221d.a(i3)) == 0.0f)) {
                String gVar = f2.toString();
                if (!z) {
                    if (a2 < 0.0f) {
                        sb2 = f.a.a.a.a.h(t);
                        str2 = "- ";
                    }
                    if (a2 == 1.0f) {
                        sb = new StringBuilder();
                    } else {
                        sb = new StringBuilder();
                        sb.append(t);
                        sb.append(a2);
                        t = " ";
                    }
                    t = f.a.a.a.a.e(sb, t, gVar);
                    z = true;
                } else {
                    sb2 = f.a.a.a.a.h(t);
                    if (i2 > 0) {
                        sb2.append(" + ");
                        t = sb2.toString();
                        if (a2 == 1.0f) {
                        }
                        t = f.a.a.a.a.e(sb, t, gVar);
                        z = true;
                    } else {
                        str2 = " - ";
                    }
                }
                sb2.append(str2);
                t = sb2.toString();
                a2 *= -1.0f;
                if (a2 == 1.0f) {
                }
                t = f.a.a.a.a.e(sb, t, gVar);
                z = true;
            }
        }
        return !z ? f.a.a.a.a.t(t, "0.0") : t;
    }
}
