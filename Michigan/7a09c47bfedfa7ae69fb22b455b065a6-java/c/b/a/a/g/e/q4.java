package c.b.a.a.g.e;

import b.x.t;
import java.util.Arrays;

public final class q4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f3692a;

    /* renamed from: b  reason: collision with root package name */
    public final long f3693b;

    public q4(String str, long j) {
        this.f3692a = str;
        this.f3693b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q4) {
            q4 q4Var = (q4) obj;
            return t.j1(this.f3692a, q4Var.f3692a) && t.j1(Long.valueOf(this.f3693b), Long.valueOf(q4Var.f3693b));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3692a, Long.valueOf(this.f3693b)});
    }
}
