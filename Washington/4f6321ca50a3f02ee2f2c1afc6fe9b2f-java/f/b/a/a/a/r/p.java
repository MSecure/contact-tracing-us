package f.b.a.a.a.r;

import f.b.a.a.a.w.k0;
import l.b.a.d;

public final class p extends s {
    public final d a;
    public final int b;
    public final d c;

    /* renamed from: d  reason: collision with root package name */
    public final k0.g f2214d;

    public p(d dVar, int i2, d dVar2, k0.g gVar, a aVar) {
        this.a = dVar;
        this.b = i2;
        this.c = dVar2;
        this.f2214d = gVar;
    }

    @Override // f.b.a.a.a.r.s
    public d a() {
        return this.c;
    }

    @Override // f.b.a.a.a.r.s
    public k0.g b() {
        return this.f2214d;
    }

    @Override // f.b.a.a.a.r.s
    public int c() {
        return this.b;
    }

    @Override // f.b.a.a.a.r.s
    public d d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.a.equals(sVar.d()) && this.b == sVar.c() && this.c.equals(sVar.a()) && this.f2214d.equals(sVar.b());
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.f2214d.hashCode();
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("MetricsSnapshot{exposureNotificationLastShownTime=");
        h2.append(this.a);
        h2.append(", exposureNotificationLastShownClassification=");
        h2.append(this.b);
        h2.append(", exposureNotificationLastInteractionTime=");
        h2.append(this.c);
        h2.append(", exposureNotificationLastInteractionType=");
        h2.append(this.f2214d);
        h2.append("}");
        return h2.toString();
    }
}
