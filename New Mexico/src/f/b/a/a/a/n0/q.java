package f.b.a.a.a.n0;

import f.a.a.a.a;
import java.util.Objects;
/* loaded from: classes.dex */
public final class q extends p1 {
    public final String a;
    public final long b;

    public q(String str, long j2) {
        Objects.requireNonNull(str, "Null workerTaskNameAndStatus");
        this.a = str;
        this.b = j2;
    }

    @Override // f.b.a.a.a.n0.p1
    public long a() {
        return this.b;
    }

    @Override // f.b.a.a.a.n0.p1
    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p1)) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return this.a.equals(p1Var.b()) && this.b == p1Var.a();
    }

    public int hashCode() {
        long j2 = this.b;
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder h2 = a.h("WorkerStatusEntity{workerTaskNameAndStatus=");
        h2.append(this.a);
        h2.append(", lastRunTimestampMillis=");
        h2.append(this.b);
        h2.append("}");
        return h2.toString();
    }
}
