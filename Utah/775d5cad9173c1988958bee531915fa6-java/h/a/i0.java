package h.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import h.a.h0;
import h.a.q0;
import java.util.Map;

public abstract class i0 extends h0.c {
    public static final q0.b a = new q0.b(new a());

    public static final class a {
        public String toString() {
            return "service config is unused";
        }
    }

    public abstract String b();

    public abstract int c();

    public abstract boolean d();

    public q0.b e(Map<String, ?> map) {
        return a;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        k t1 = b.t1(this);
        t1.d("policy", b());
        t1.a("priority", c());
        t1.c("available", d());
        return t1.toString();
    }
}
