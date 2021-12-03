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
    public static final o2 f4013f = new o2(1, 0, 0, 1.0d, Collections.emptySet());
    public final int a;
    public final long b;
    public final long c;

    /* renamed from: d  reason: collision with root package name */
    public final double f4014d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<c1.b> f4015e;

    public interface a {
        o2 get();
    }

    public o2(int i2, long j2, long j3, double d2, Set<c1.b> set) {
        this.a = i2;
        this.b = j2;
        this.c = j3;
        this.f4014d = d2;
        this.f4015e = e.q(set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o2)) {
            return false;
        }
        o2 o2Var = (o2) obj;
        return this.a == o2Var.a && this.b == o2Var.b && this.c == o2Var.c && Double.compare(this.f4014d, o2Var.f4014d) == 0 && b.m0(this.f4015e, o2Var.f4015e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Double.valueOf(this.f4014d), this.f4015e});
    }

    public String toString() {
        k t1 = b.t1(this);
        t1.a("maxAttempts", this.a);
        t1.b("initialBackoffNanos", this.b);
        t1.b("maxBackoffNanos", this.c);
        t1.d("backoffMultiplier", String.valueOf(this.f4014d));
        t1.d("retryableStatusCodes", this.f4015e);
        return t1.toString();
    }
}
