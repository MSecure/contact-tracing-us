package f.b.a.a.a.w;

import f.a.a.a.a;
import java.util.Objects;

public final class n extends q0 {
    public final String a;
    public final long b;

    public n(String str, long j2) {
        Objects.requireNonNull(str, "Null workerTaskNameAndStatus");
        this.a = str;
        this.b = j2;
    }

    @Override // f.b.a.a.a.w.q0
    public long a() {
        return this.b;
    }

    @Override // f.b.a.a.a.w.q0
    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return this.a.equals(q0Var.b()) && this.b == q0Var.a();
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
