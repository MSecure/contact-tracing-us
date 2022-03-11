package f.b.a.a.a.w;

import f.a.a.a.a;
import java.util.Objects;

public final class m extends m0 {
    public final long a;
    public final String b;

    public m(long j2, long j3, String str) {
        this.a = j3;
        Objects.requireNonNull(str, "Null revisionToken");
        this.b = str;
    }

    @Override // f.b.a.a.a.w.m0
    public long a() {
        return this.a;
    }

    @Override // f.b.a.a.a.w.m0
    public long b() {
        return 0;
    }

    @Override // f.b.a.a.a.w.m0
    public String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return 0 == m0Var.b() && this.a == m0Var.a() && this.b.equals(m0Var.c());
    }

    public int hashCode() {
        long j2 = this.a;
        return this.b.hashCode() ^ ((((((int) 0) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RevisionTokenEntity{id=");
        sb.append(0L);
        sb.append(", createdTimestampMs=");
        sb.append(this.a);
        sb.append(", revisionToken=");
        return a.e(sb, this.b, "}");
    }
}
