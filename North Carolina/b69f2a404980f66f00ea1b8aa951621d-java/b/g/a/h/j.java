package b.g.a.h;

import b.g.a.e;
import b.g.a.g;
import b.g.a.h.c;
import c.a.a.a.a;

public class j extends l {

    /* renamed from: c  reason: collision with root package name */
    public c f925c;

    /* renamed from: d  reason: collision with root package name */
    public j f926d;

    /* renamed from: e  reason: collision with root package name */
    public float f927e;
    public j f;
    public float g;
    public int h = 0;
    public j i;
    public k j = null;
    public int k = 1;
    public k l = null;
    public int m = 1;

    public j(c cVar) {
        this.f925c = cVar;
    }

    @Override // b.g.a.h.l
    public void d() {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        j jVar6;
        j jVar7;
        float f2;
        float f3;
        float f4;
        j jVar8;
        float f5;
        c.b bVar = c.b.RIGHT;
        boolean z = true;
        if (this.f930b != 1 && this.h != 4) {
            k kVar = this.j;
            if (kVar != null) {
                if (kVar.f930b == 1) {
                    this.f927e = ((float) this.k) * kVar.f928c;
                } else {
                    return;
                }
            }
            k kVar2 = this.l;
            if (kVar2 != null) {
                if (kVar2.f930b == 1) {
                    float f6 = kVar2.f928c;
                } else {
                    return;
                }
            }
            if (this.h == 1 && ((jVar8 = this.f926d) == null || jVar8.f930b == 1)) {
                j jVar9 = this.f926d;
                if (jVar9 == null) {
                    this.f = this;
                    f5 = this.f927e;
                } else {
                    this.f = jVar9.f;
                    f5 = jVar9.g + this.f927e;
                }
                this.g = f5;
                a();
                return;
            }
            if (this.h == 2 && (jVar4 = this.f926d) != null && jVar4.f930b == 1 && (jVar5 = this.i) != null && (jVar6 = jVar5.f926d) != null && jVar6.f930b == 1) {
                this.f = jVar4.f;
                jVar5.f = jVar6.f;
                c.b bVar2 = this.f925c.f899c;
                int i2 = 0;
                if (!(bVar2 == bVar || bVar2 == c.b.BOTTOM)) {
                    z = false;
                }
                if (z) {
                    f2 = this.f926d.g;
                    jVar7 = this.i.f926d;
                } else {
                    f2 = this.i.f926d.g;
                    jVar7 = this.f926d;
                }
                float f7 = f2 - jVar7.g;
                c cVar = this.f925c;
                c.b bVar3 = cVar.f899c;
                if (bVar3 == c.b.LEFT || bVar3 == bVar) {
                    f3 = f7 - ((float) this.f925c.f898b.n());
                    f4 = this.f925c.f898b.V;
                } else {
                    f3 = f7 - ((float) cVar.f898b.h());
                    f4 = this.f925c.f898b.W;
                }
                int b2 = this.f925c.b();
                int b3 = this.i.f925c.b();
                if (this.f925c.f900d == this.i.f925c.f900d) {
                    f4 = 0.5f;
                    b3 = 0;
                } else {
                    i2 = b2;
                }
                float f8 = (float) i2;
                float f9 = (float) b3;
                float f10 = (f3 - f8) - f9;
                if (z) {
                    j jVar10 = this.i;
                    jVar10.g = (f10 * f4) + jVar10.f926d.g + f9;
                    this.g = (this.f926d.g - f8) - ((1.0f - f4) * f10);
                } else {
                    this.g = (f10 * f4) + this.f926d.g + f8;
                    j jVar11 = this.i;
                    jVar11.g = (jVar11.f926d.g - f9) - ((1.0f - f4) * f10);
                }
            } else if (this.h == 3 && (jVar = this.f926d) != null && jVar.f930b == 1 && (jVar2 = this.i) != null && (jVar3 = jVar2.f926d) != null && jVar3.f930b == 1) {
                this.f = jVar.f;
                jVar2.f = jVar3.f;
                this.g = jVar.g + this.f927e;
                jVar2.g = jVar3.g + jVar2.f927e;
            } else if (this.h == 5) {
                this.f925c.f898b.u();
                return;
            } else {
                return;
            }
            a();
            this.i.a();
        }
    }

    public void e(e eVar) {
        g gVar = this.f925c.i;
        j jVar = this.f;
        if (jVar == null) {
            eVar.e(gVar, (int) (this.g + 0.5f));
        } else {
            eVar.d(gVar, eVar.l(jVar.f925c), (int) (this.g + 0.5f), 6);
        }
    }

    public void f(int i2, j jVar, int i3) {
        this.h = i2;
        this.f926d = jVar;
        this.f927e = (float) i3;
        jVar.f929a.add(this);
    }

    public void g(j jVar, int i2) {
        this.f926d = jVar;
        this.f927e = (float) i2;
        jVar.f929a.add(this);
    }

    public void h(j jVar, int i2, k kVar) {
        this.f926d = jVar;
        jVar.f929a.add(this);
        this.j = kVar;
        this.k = i2;
        kVar.f929a.add(this);
    }

    public void i() {
        this.f930b = 0;
        this.f929a.clear();
        this.f926d = null;
        this.f927e = 0.0f;
        this.j = null;
        this.k = 1;
        this.l = null;
        this.m = 1;
        this.f = null;
        this.g = 0.0f;
        this.i = null;
        this.h = 0;
    }

    public void j(j jVar, float f2) {
        if (this.f930b == 0 || !(this.f == jVar || this.g == f2)) {
            this.f = jVar;
            this.g = f2;
            if (this.f930b == 1) {
                b();
            }
            a();
        }
    }

    public String k(int i2) {
        return i2 == 1 ? "DIRECT" : i2 == 2 ? "CENTER" : i2 == 3 ? "MATCH" : i2 == 4 ? "CHAIN" : i2 == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public String toString() {
        String str;
        StringBuilder sb;
        if (this.f930b != 1) {
            sb = a.g("{ ");
            sb.append(this.f925c);
            str = " UNRESOLVED} type: ";
        } else if (this.f == this) {
            sb = a.g("[");
            sb.append(this.f925c);
            sb.append(", RESOLVED: ");
            sb.append(this.g);
            str = "]  type: ";
        } else {
            sb = a.g("[");
            sb.append(this.f925c);
            sb.append(", RESOLVED: ");
            sb.append(this.f);
            sb.append(":");
            sb.append(this.g);
            str = "] type: ";
        }
        sb.append(str);
        sb.append(k(this.h));
        return sb.toString();
    }
}
