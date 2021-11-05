package c.b.a.a.e.c;

import b.b.k.i;
import java.util.Arrays;

public final class q4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2698a;

    /* renamed from: b  reason: collision with root package name */
    public final long f2699b;

    public q4(String str, long j) {
        this.f2698a = str;
        this.f2699b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q4) {
            q4 q4Var = (q4) obj;
            return i.j.X(this.f2698a, q4Var.f2698a) && i.j.X(Long.valueOf(this.f2699b), Long.valueOf(q4Var.f2699b));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2698a, Long.valueOf(this.f2699b)});
    }
}
