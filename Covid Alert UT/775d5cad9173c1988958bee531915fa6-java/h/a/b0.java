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
    public final c0 f3817d = null;

    /* renamed from: e  reason: collision with root package name */
    public final c0 f3818e;

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
        this.f3818e = c0Var2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return b.m0(this.a, b0Var.a) && b.m0(this.b, b0Var.b) && this.c == b0Var.c && b.m0(this.f3817d, b0Var.f3817d) && b.m0(this.f3818e, b0Var.f3818e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, Long.valueOf(this.c), this.f3817d, this.f3818e});
    }

    public String toString() {
        k t1 = b.t1(this);
        t1.d("description", this.a);
        t1.d("severity", this.b);
        t1.b("timestampNanos", this.c);
        t1.d("channelRef", this.f3817d);
        t1.d("subchannelRef", this.f3818e);
        return t1.toString();
    }
}
