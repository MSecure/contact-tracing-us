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
    public final c0 f3502d = null;

    /* renamed from: e  reason: collision with root package name */
    public final c0 f3503e;

    public enum a {
        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR
    }

    public b0(String str, a aVar, long j2, c0 c0Var, c0 c0Var2, a0.a aVar2) {
        this.a = str;
        b.A(aVar, "severity");
        this.b = aVar;
        this.c = j2;
        this.f3503e = c0Var2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return b.t0(this.a, b0Var.a) && b.t0(this.b, b0Var.b) && this.c == b0Var.c && b.t0(this.f3502d, b0Var.f3502d) && b.t0(this.f3503e, b0Var.f3503e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, Long.valueOf(this.c), this.f3502d, this.f3503e});
    }

    public String toString() {
        k U1 = b.U1(this);
        U1.d("description", this.a);
        U1.d("severity", this.b);
        U1.b("timestampNanos", this.c);
        U1.d("channelRef", this.f3502d);
        U1.d("subchannelRef", this.f3503e);
        return U1.toString();
    }
}
