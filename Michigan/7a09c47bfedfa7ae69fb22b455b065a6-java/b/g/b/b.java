package b.g.b;

import b.g.b.d;
import c.a.a.a.a;

public class b implements d.a {

    /* renamed from: a  reason: collision with root package name */
    public g f1458a = null;

    /* renamed from: b  reason: collision with root package name */
    public float f1459b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1460c;

    /* renamed from: d  reason: collision with root package name */
    public final a f1461d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1462e = false;

    public b(c cVar) {
        this.f1461d = new a(this, cVar);
    }

    @Override // b.g.b.d.a
    public void a(g gVar) {
        float f2;
        int i = gVar.f1483e;
        if (i != 1) {
            if (i == 2) {
                f2 = 1000.0f;
            } else if (i == 3) {
                f2 = 1000000.0f;
            } else if (i == 4) {
                f2 = 1.0E9f;
            } else if (i == 5) {
                f2 = 1.0E12f;
            }
            this.f1461d.h(gVar, f2);
        }
        f2 = 1.0f;
        this.f1461d.h(gVar, f2);
    }

    @Override // b.g.b.d.a
    public g b(d dVar, boolean[] zArr) {
        return this.f1461d.d(zArr, null);
    }

    public b c(d dVar, int i) {
        this.f1461d.h(dVar.k(i, "ep"), 1.0f);
        this.f1461d.h(dVar.k(i, "em"), -1.0f);
        return this;
    }

    @Override // b.g.b.d.a
    public void clear() {
        this.f1461d.b();
        this.f1458a = null;
        this.f1459b = 0.0f;
    }

    public b d(g gVar, g gVar2, g gVar3, g gVar4, float f2) {
        this.f1461d.h(gVar, -1.0f);
        this.f1461d.h(gVar2, 1.0f);
        this.f1461d.h(gVar3, f2);
        this.f1461d.h(gVar4, -f2);
        return this;
    }

    public b e(g gVar, g gVar2, g gVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1459b = (float) i;
        }
        if (!z) {
            this.f1461d.h(gVar, -1.0f);
            this.f1461d.h(gVar2, 1.0f);
            this.f1461d.h(gVar3, 1.0f);
        } else {
            this.f1461d.h(gVar, 1.0f);
            this.f1461d.h(gVar2, -1.0f);
            this.f1461d.h(gVar3, -1.0f);
        }
        return this;
    }

    public b f(g gVar, g gVar2, g gVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1459b = (float) i;
        }
        if (!z) {
            this.f1461d.h(gVar, -1.0f);
            this.f1461d.h(gVar2, 1.0f);
            this.f1461d.h(gVar3, -1.0f);
        } else {
            this.f1461d.h(gVar, 1.0f);
            this.f1461d.h(gVar2, -1.0f);
            this.f1461d.h(gVar3, 1.0f);
        }
        return this;
    }

    public b g(g gVar, g gVar2, g gVar3, g gVar4, float f2) {
        this.f1461d.h(gVar3, 0.5f);
        this.f1461d.h(gVar4, 0.5f);
        this.f1461d.h(gVar, -0.5f);
        this.f1461d.h(gVar2, -0.5f);
        this.f1459b = -f2;
        return this;
    }

    public void h(g gVar) {
        g gVar2 = this.f1458a;
        if (gVar2 != null) {
            this.f1461d.h(gVar2, -1.0f);
            this.f1458a = null;
        }
        float i = this.f1461d.i(gVar, true) * -1.0f;
        this.f1458a = gVar;
        if (i != 1.0f) {
            this.f1459b /= i;
            a aVar = this.f1461d;
            int i2 = aVar.i;
            int i3 = 0;
            while (i2 != -1 && i3 < aVar.f1451a) {
                float[] fArr = aVar.h;
                fArr[i2] = fArr[i2] / i;
                i2 = aVar.f1457g[i2];
                i3++;
            }
        }
    }

    public void i(b bVar, boolean z) {
        a aVar = this.f1461d;
        int i = aVar.i;
        while (true) {
            int i2 = 0;
            while (i != -1 && i2 < aVar.f1451a) {
                int i3 = aVar.f1456f[i];
                g gVar = bVar.f1458a;
                if (i3 == gVar.f1481c) {
                    float f2 = aVar.h[i];
                    aVar.i(gVar, z);
                    a aVar2 = bVar.f1461d;
                    int i4 = aVar2.i;
                    int i5 = 0;
                    while (i4 != -1 && i5 < aVar2.f1451a) {
                        aVar.a(aVar.f1453c.f1465c[aVar2.f1456f[i4]], aVar2.h[i4] * f2, z);
                        i4 = aVar2.f1457g[i4];
                        i5++;
                    }
                    this.f1459b = (bVar.f1459b * f2) + this.f1459b;
                    if (z) {
                        bVar.f1458a.b(this);
                    }
                    i = aVar.i;
                } else {
                    i = aVar.f1457g[i];
                    i2++;
                }
            }
            return;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0088  */
    public String toString() {
        String str;
        boolean z;
        float f2;
        int i;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        if (this.f1458a == null) {
            str = "0";
        } else {
            StringBuilder h = a.h("");
            h.append(this.f1458a);
            str = h.toString();
        }
        String q = a.q(str, " = ");
        if (this.f1459b != 0.0f) {
            StringBuilder h2 = a.h(q);
            h2.append(this.f1459b);
            q = h2.toString();
            z = true;
        } else {
            z = false;
        }
        int i2 = this.f1461d.f1451a;
        for (int i3 = 0; i3 < i2; i3++) {
            g e2 = this.f1461d.e(i3);
            if (!(e2 == null || (f2 = this.f1461d.f(i3)) == 0.0f)) {
                String gVar = e2.toString();
                if (!z) {
                    if (f2 < 0.0f) {
                        sb2 = a.h(q);
                        str2 = "- ";
                    }
                    if (f2 == 1.0f) {
                        sb = new StringBuilder();
                    } else {
                        sb = new StringBuilder();
                        sb.append(q);
                        sb.append(f2);
                        q = " ";
                    }
                    sb.append(q);
                    sb.append(gVar);
                    q = sb.toString();
                    z = true;
                } else {
                    sb2 = a.h(q);
                    if (i > 0) {
                        sb2.append(" + ");
                        q = sb2.toString();
                        if (f2 == 1.0f) {
                        }
                        sb.append(q);
                        sb.append(gVar);
                        q = sb.toString();
                        z = true;
                    } else {
                        str2 = " - ";
                    }
                }
                sb2.append(str2);
                q = sb2.toString();
                f2 *= -1.0f;
                if (f2 == 1.0f) {
                }
                sb.append(q);
                sb.append(gVar);
                q = sb.toString();
                z = true;
            }
        }
        return !z ? a.q(q, "0.0") : q;
    }
}
