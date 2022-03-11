package h.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import h.a.a0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b0 {
    public final String a;
    public final a b;
    public final long c;

    /* renamed from: d */
    public final c0 f4072d = null;

    /* renamed from: e */
    public final c0 f4073e;

    /* loaded from: classes.dex */
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
        this.f4073e = c0Var2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return b.n0(this.a, b0Var.a) && b.n0(this.b, b0Var.b) && this.c == b0Var.c && b.n0(this.f4072d, b0Var.f4072d) && b.n0(this.f4073e, b0Var.f4073e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, Long.valueOf(this.c), this.f4072d, this.f4073e});
    }

    public String toString() {
        k u1 = b.u1(this);
        u1.d("description", this.a);
        u1.d("severity", this.b);
        u1.b("timestampNanos", this.c);
        u1.d("channelRef", this.f4072d);
        u1.d("subchannelRef", this.f4073e);
        return u1.toString();
    }
}
