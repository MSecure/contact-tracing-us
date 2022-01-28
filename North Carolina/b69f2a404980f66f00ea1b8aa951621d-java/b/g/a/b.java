package b.g.a;

import b.g.a.e;
import c.a.a.a.a;

public class b implements e.a {

    /* renamed from: a  reason: collision with root package name */
    public g f868a = null;

    /* renamed from: b  reason: collision with root package name */
    public float f869b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f870c;

    /* renamed from: d  reason: collision with root package name */
    public final a f871d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f872e = false;

    public b(c cVar) {
        this.f871d = new a(this, cVar);
    }

    @Override // b.g.a.e.a
    public void a(g gVar) {
        int i = gVar.f886d;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.f871d.h(gVar, f);
    }

    public b b(e eVar, int i) {
        this.f871d.h(eVar.k(i, "ep"), 1.0f);
        this.f871d.h(eVar.k(i, "em"), -1.0f);
        return this;
    }

    public b c(g gVar, g gVar2, g gVar3, g gVar4, float f) {
        this.f871d.h(gVar, -1.0f);
        this.f871d.h(gVar2, 1.0f);
        this.f871d.h(gVar3, f);
        this.f871d.h(gVar4, -f);
        return this;
    }

    public b d(g gVar, g gVar2, g gVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f869b = (float) i;
        }
        if (!z) {
            this.f871d.h(gVar, -1.0f);
            this.f871d.h(gVar2, 1.0f);
            this.f871d.h(gVar3, 1.0f);
        } else {
            this.f871d.h(gVar, 1.0f);
            this.f871d.h(gVar2, -1.0f);
            this.f871d.h(gVar3, -1.0f);
        }
        return this;
    }

    public b e(g gVar, g gVar2, g gVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f869b = (float) i;
        }
        if (!z) {
            this.f871d.h(gVar, -1.0f);
            this.f871d.h(gVar2, 1.0f);
            this.f871d.h(gVar3, -1.0f);
        } else {
            this.f871d.h(gVar, 1.0f);
            this.f871d.h(gVar2, -1.0f);
            this.f871d.h(gVar3, 1.0f);
        }
        return this;
    }

    public b f(g gVar, g gVar2, g gVar3, g gVar4, float f) {
        this.f871d.h(gVar3, 0.5f);
        this.f871d.h(gVar4, 0.5f);
        this.f871d.h(gVar, -0.5f);
        this.f871d.h(gVar2, -0.5f);
        this.f869b = -f;
        return this;
    }

    public void g(g gVar) {
        g gVar2 = this.f868a;
        if (gVar2 != null) {
            this.f871d.h(gVar2, -1.0f);
            this.f868a = null;
        }
        float i = this.f871d.i(gVar, true) * -1.0f;
        this.f868a = gVar;
        if (i != 1.0f) {
            this.f869b /= i;
            a aVar = this.f871d;
            int i2 = aVar.i;
            int i3 = 0;
            while (i2 != -1 && i3 < aVar.f863a) {
                float[] fArr = aVar.h;
                fArr[i2] = fArr[i2] / i;
                i2 = aVar.g[i2];
                i3++;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0088  */
    public String toString() {
        String str;
        boolean z;
        float f;
        int i;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        if (this.f868a == null) {
            str = "0";
        } else {
            StringBuilder g = a.g("");
            g.append(this.f868a);
            str = g.toString();
        }
        String o = a.o(str, " = ");
        if (this.f869b != 0.0f) {
            StringBuilder g2 = a.g(o);
            g2.append(this.f869b);
            o = g2.toString();
            z = true;
        } else {
            z = false;
        }
        int i2 = this.f871d.f863a;
        for (int i3 = 0; i3 < i2; i3++) {
            g e2 = this.f871d.e(i3);
            if (!(e2 == null || (f = this.f871d.f(i3)) == 0.0f)) {
                String gVar = e2.toString();
                if (!z) {
                    if (f < 0.0f) {
                        sb2 = a.g(o);
                        str2 = "- ";
                    }
                    if (f == 1.0f) {
                        sb = new StringBuilder();
                    } else {
                        sb = new StringBuilder();
                        sb.append(o);
                        sb.append(f);
                        o = " ";
                    }
                    sb.append(o);
                    sb.append(gVar);
                    o = sb.toString();
                    z = true;
                } else {
                    sb2 = a.g(o);
                    if (i > 0) {
                        sb2.append(" + ");
                        o = sb2.toString();
                        if (f == 1.0f) {
                        }
                        sb.append(o);
                        sb.append(gVar);
                        o = sb.toString();
                        z = true;
                    } else {
                        str2 = " - ";
                    }
                }
                sb2.append(str2);
                o = sb2.toString();
                f *= -1.0f;
                if (f == 1.0f) {
                }
                sb.append(o);
                sb.append(gVar);
                o = sb.toString();
                z = true;
            }
        }
        return !z ? a.o(o, "0.0") : o;
    }
}
