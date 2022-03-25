package h.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import h.a.i1.a;
import h.a.w;
import java.util.concurrent.TimeUnit;

public abstract class w<T extends w<T>> extends l0<T> {
    @Override // h.a.l0
    public l0 b(long j2, TimeUnit timeUnit) {
        ((a) this).a.b(j2, timeUnit);
        return this;
    }

    @Override // h.a.l0
    public l0 c() {
        ((a) this).a.c();
        return this;
    }

    public String toString() {
        k T1 = b.T1(this);
        T1.d("delegate", ((a) this).a);
        return T1.toString();
    }
}
