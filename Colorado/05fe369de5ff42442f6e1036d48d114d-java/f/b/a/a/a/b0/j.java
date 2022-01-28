package f.b.a.a.a.b0;

import f.a.a.a.a;
import java.util.Objects;

public final class j extends t {
    public final String a;
    public final long b;

    public j(String str, long j2) {
        Objects.requireNonNull(str, "Null countryCode");
        this.a = str;
        this.b = j2;
    }

    @Override // f.b.a.a.a.b0.t
    public String a() {
        return this.a;
    }

    @Override // f.b.a.a.a.b0.t
    public long b() {
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
        return this.a.equals(tVar.a()) && this.b == tVar.b();
    }

    public int hashCode() {
        long j2 = this.b;
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder i2 = a.i("CountryEntity{countryCode=");
        i2.append(this.a);
        i2.append(", lastSeenTimestampMillis=");
        i2.append(this.b);
        i2.append("}");
        return i2.toString();
    }
}
