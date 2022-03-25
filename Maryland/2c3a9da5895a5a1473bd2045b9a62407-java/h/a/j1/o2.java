package h.a.j1;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import f.b.b.b.e;
import h.a.c1;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public final class o2 {

    /* renamed from: f  reason: collision with root package name */
    public static final o2 f3794f = new o2(1, 0, 0, 1.0d, Collections.emptySet());
    public final int a;
    public final long b;
    public final long c;

    /* renamed from: d  reason: collision with root package name */
    public final double f3795d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<c1.b> f3796e;

    public interface a {
        o2 get();
    }

    public o2(int i2, long j2, long j3, double d2, Set<c1.b> set) {
        this.a = i2;
        this.b = j2;
        this.c = j3;
        this.f3795d = d2;
        this.f3796e = e.q(set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o2)) {
            return false;
        }
        o2 o2Var = (o2) obj;
        return this.a == o2Var.a && this.b == o2Var.b && this.c == o2Var.c && Double.compare(this.f3795d, o2Var.f3795d) == 0 && b.t0(this.f3796e, o2Var.f3796e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Double.valueOf(this.f3795d), this.f3796e});
    }

    public String toString() {
        k T1 = b.T1(this);
        T1.a("maxAttempts", this.a);
        T1.b("initialBackoffNanos", this.b);
        T1.b("maxBackoffNanos", this.c);
        T1.d("backoffMultiplier", String.valueOf(this.f3795d));
        T1.d("retryableStatusCodes", this.f3796e);
        return T1.toString();
    }
}
