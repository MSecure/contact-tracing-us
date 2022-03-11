package f.b.a.a.a.n0;

import f.a.a.a.a;
import java.util.Objects;
/* loaded from: classes.dex */
public final class j extends u {
    public final String a;
    public final long b;

    public j(String str, long j2) {
        Objects.requireNonNull(str, "Null countryCode");
        this.a = str;
        this.b = j2;
    }

    @Override // f.b.a.a.a.n0.u
    public String a() {
        return this.a;
    }

    @Override // f.b.a.a.a.n0.u
    public long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.a.equals(uVar.a()) && this.b == uVar.b();
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
