package f.b.a.a.a.y;

import f.a.a.a.a;
import java.util.Objects;

public final class i extends r {
    public final String a;
    public final long b;

    public i(String str, long j2) {
        Objects.requireNonNull(str, "Null countryCode");
        this.a = str;
        this.b = j2;
    }

    @Override // f.b.a.a.a.y.r
    public String a() {
        return this.a;
    }

    @Override // f.b.a.a.a.y.r
    public long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.a.equals(rVar.a()) && this.b == rVar.b();
    }

    public int hashCode() {
        long j2 = this.b;
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder h2 = a.h("CountryEntity{countryCode=");
        h2.append(this.a);
        h2.append(", lastSeenTimestampMillis=");
        h2.append(this.b);
        h2.append("}");
        return h2.toString();
    }
}
