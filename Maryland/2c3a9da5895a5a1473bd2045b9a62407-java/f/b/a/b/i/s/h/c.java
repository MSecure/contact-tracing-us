package f.b.a.b.i.s.h;

import f.b.a.b.i.s.h.f;
import java.util.Set;

public final class c extends f.a {
    public final long a;
    public final long b;
    public final Set<f.b> c;

    public static final class b extends f.a.AbstractC0081a {
        public Long a;
        public Long b;
        public Set<f.b> c;

        @Override // f.b.a.b.i.s.h.f.a.AbstractC0081a
        public f.a a() {
            String str = this.a == null ? " delta" : "";
            if (this.b == null) {
                str = f.a.a.a.a.t(str, " maxAllowedDelay");
            }
            if (this.c == null) {
                str = f.a.a.a.a.t(str, " flags");
            }
            if (str.isEmpty()) {
                return new c(this.a.longValue(), this.b.longValue(), this.c, null);
            }
            throw new IllegalStateException(f.a.a.a.a.t("Missing required properties:", str));
        }

        @Override // f.b.a.b.i.s.h.f.a.AbstractC0081a
        public f.a.AbstractC0081a b(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // f.b.a.b.i.s.h.f.a.AbstractC0081a
        public f.a.AbstractC0081a c(long j2) {
            this.b = Long.valueOf(j2);
            return this;
        }
    }

    public c(long j2, long j3, Set set, a aVar) {
        this.a = j2;
        this.b = j3;
        this.c = set;
    }

    @Override // f.b.a.b.i.s.h.f.a
    public long b() {
        return this.a;
    }

    @Override // f.b.a.b.i.s.h.f.a
    public Set<f.b> c() {
        return this.c;
    }

    @Override // f.b.a.b.i.s.h.f.a
    public long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f.a)) {
            return false;
        }
        f.a aVar = (f.a) obj;
        return this.a == aVar.b() && this.b == aVar.d() && this.c.equals(aVar.c());
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.b;
        return this.c.hashCode() ^ ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003);
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("ConfigValue{delta=");
        h2.append(this.a);
        h2.append(", maxAllowedDelay=");
        h2.append(this.b);
        h2.append(", flags=");
        h2.append(this.c);
        h2.append("}");
        return h2.toString();
    }
}
