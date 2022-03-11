package h.a.j1;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class g {
    public static final Logger c = Logger.getLogger(g.class.getName());
    public final String a;
    public final AtomicLong b;

    /* loaded from: classes.dex */
    public final class b {
        public final long a;

        public b(long j2, a aVar) {
            this.a = j2;
        }
    }

    public g(String str, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.b = atomicLong;
        f.b.a.c.b.o.b.p(j2 > 0, "value must be positive");
        this.a = str;
        atomicLong.set(j2);
    }
}
