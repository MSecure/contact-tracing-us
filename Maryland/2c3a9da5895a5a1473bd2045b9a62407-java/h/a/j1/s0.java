package h.a.j1;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import f.b.b.b.e;
import h.a.c1;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public final class s0 {

    /* renamed from: d  reason: collision with root package name */
    public static final s0 f3855d = new s0(1, 0, Collections.emptySet());
    public final int a;
    public final long b;
    public final Set<c1.b> c;

    public interface a {
        s0 get();
    }

    public s0(int i2, long j2, Set<c1.b> set) {
        this.a = i2;
        this.b = j2;
        this.c = e.q(set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s0.class != obj.getClass()) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return this.a == s0Var.a && this.b == s0Var.b && b.t0(this.c, s0Var.c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), this.c});
    }

    public String toString() {
        k T1 = b.T1(this);
        T1.a("maxAttempts", this.a);
        T1.b("hedgingDelayNanos", this.b);
        T1.d("nonFatalStatusCodes", this.c);
        return T1.toString();
    }
}
