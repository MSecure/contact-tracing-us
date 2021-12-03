package h.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import h.a.a0;
import java.util.Arrays;

public final class b0 {
    public final String a;
    public final a b;
    public final long c;

    /* renamed from: d  reason: collision with root package name */
    public final c0 f3752d = null;

    /* renamed from: e  reason: collision with root package name */
    public final c0 f3753e;

    public enum a {
        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR
    }

    public b0(String str, a aVar, long j2, c0 c0Var, c0 c0Var2, a0.a aVar2) {
        this.a = str;
        b.z(aVar, "severity");
        this.b = aVar;
        this.c = j2;
        this.f3753e = c0Var2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return b.m0(this.a, b0Var.a) && b.m0(this.b, b0Var.b) && this.c == b0Var.c && b.m0(this.f3752d, b0Var.f3752d) && b.m0(this.f3753e, b0Var.f3753e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, Long.valueOf(this.c), this.f3752d, this.f3753e});
    }

    public String toString() {
        k q1 = b.q1(this);
        q1.d("description", this.a);
        q1.d("severity", this.b);
        q1.b("timestampNanos", this.c);
        q1.d("channelRef", this.f3752d);
        q1.d("subchannelRef", this.f3753e);
        return q1.toString();
    }
}
