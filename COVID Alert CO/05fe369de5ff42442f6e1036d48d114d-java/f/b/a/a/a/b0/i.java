package f.b.a.a.a.b0;

import f.a.a.a.a;
import java.util.Objects;

public final class i extends g {
    public final long a;
    public final String b;

    public i(long j2, String str) {
        this.a = j2;
        Objects.requireNonNull(str, "Null eventProto");
        this.b = str;
    }

    @Override // f.b.a.a.a.b0.g
    public String a() {
        return this.b;
    }

    @Override // f.b.a.a.a.b0.g
    public long b() {
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
        return this.a == gVar.b() && this.b.equals(gVar.a());
    }

    public int hashCode() {
        long j2 = this.a;
        return this.b.hashCode() ^ ((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003);
    }

    public String toString() {
        StringBuilder i2 = a.i("AnalyticsLoggingEntity{key=");
        i2.append(this.a);
        i2.append(", eventProto=");
        return a.f(i2, this.b, "}");
    }
}
