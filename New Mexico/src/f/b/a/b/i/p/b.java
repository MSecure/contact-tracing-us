package f.b.a.b.i.p;

import f.a.a.a.a;
import f.b.a.b.i.p.g;
import java.util.Objects;
/* loaded from: classes.dex */
public final class b extends g {
    public final g.a a;
    public final long b;

    public b(g.a aVar, long j2) {
        Objects.requireNonNull(aVar, "Null status");
        this.a = aVar;
        this.b = j2;
    }

    @Override // f.b.a.b.i.p.g
    public long b() {
        return this.b;
    }

    @Override // f.b.a.b.i.p.g
    public g.a c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a.equals(gVar.c()) && this.b == gVar.b();
    }

    public int hashCode() {
        long j2 = this.b;
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder h2 = a.h("BackendResponse{status=");
        h2.append(this.a);
        h2.append(", nextRequestWaitMillis=");
        h2.append(this.b);
        h2.append("}");
        return h2.toString();
    }
}
