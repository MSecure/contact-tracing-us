package h.a.j1;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import f.b.b.b.e;
import h.a.c1;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
/* loaded from: classes.dex */
public final class o2 {

    /* renamed from: f */
    public static final o2 f4268f = new o2(1, 0, 0, 1.0d, Collections.emptySet());
    public final int a;
    public final long b;
    public final long c;

    /* renamed from: d */
    public final double f4269d;

    /* renamed from: e */
    public final Set<c1.b> f4270e;

    /* loaded from: classes.dex */
    public interface a {
        o2 get();
    }

    public o2(int i2, long j2, long j3, double d2, Set<c1.b> set) {
        this.a = i2;
        this.b = j2;
        this.c = j3;
        this.f4269d = d2;
        this.f4270e = e.q(set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o2)) {
            return false;
        }
        o2 o2Var = (o2) obj;
        return this.a == o2Var.a && this.b == o2Var.b && this.c == o2Var.c && Double.compare(this.f4269d, o2Var.f4269d) == 0 && b.n0(this.f4270e, o2Var.f4270e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Double.valueOf(this.f4269d), this.f4270e});
    }

    public String toString() {
        k u1 = b.u1(this);
        u1.a("maxAttempts", this.a);
        u1.b("initialBackoffNanos", this.b);
        u1.b("maxBackoffNanos", this.c);
        u1.d("backoffMultiplier", String.valueOf(this.f4269d));
        u1.d("retryableStatusCodes", this.f4270e);
        return u1.toString();
    }
}
