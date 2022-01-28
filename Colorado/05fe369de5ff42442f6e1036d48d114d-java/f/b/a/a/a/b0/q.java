package f.b.a.a.a.b0;

import f.a.a.a.a;
import java.util.Objects;

public final class q extends i1 {
    public final String a;
    public final long b;

    public q(String str, long j2) {
        Objects.requireNonNull(str, "Null workerTaskNameAndStatus");
        this.a = str;
        this.b = j2;
    }

    @Override // f.b.a.a.a.b0.i1
    public long a() {
        return this.b;
    }

    @Override // f.b.a.a.a.b0.i1
    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        return this.a.equals(i1Var.b()) && this.b == i1Var.a();
    }

    public int hashCode() {
        long j2 = this.b;
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder i2 = a.i("WorkerStatusEntity{workerTaskNameAndStatus=");
        i2.append(this.a);
        i2.append(", lastRunTimestampMillis=");
        i2.append(this.b);
        i2.append("}");
        return i2.toString();
    }
}
