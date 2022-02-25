package f.b.a.a.a.r;

import f.b.a.a.a.s.c;
import f.b.a.a.a.s.d;

public final class p extends t {
    public final c a;
    public final d b;

    public p(c cVar, d dVar, a aVar) {
        this.a = cVar;
        this.b = dVar;
    }

    @Override // f.b.a.a.a.r.t
    public c a() {
        return this.a;
    }

    @Override // f.b.a.a.a.r.t
    public d b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.a.equals(tVar.a()) && this.b.equals(tVar.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("PrioPacketPayload{createPacketsParameters=");
        h2.append(this.a);
        h2.append(", createPacketsResponse=");
        h2.append(this.b);
        h2.append("}");
        return h2.toString();
    }
}
