package f.b.a.a.a.r;

import f.b.a.a.a.s.c;
import f.b.a.a.a.s.d;

public final class q extends v {
    public final c a;
    public final d b;

    public q(c cVar, d dVar, a aVar) {
        this.a = cVar;
        this.b = dVar;
    }

    @Override // f.b.a.a.a.r.v
    public c a() {
        return this.a;
    }

    @Override // f.b.a.a.a.r.v
    public d b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.a.equals(vVar.a()) && this.b.equals(vVar.b());
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
