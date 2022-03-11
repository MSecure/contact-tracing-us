package f.b.a.b.i.s.h;

import f.b.a.b.d;
import f.b.a.b.i.s.h.c;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class f {

    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: f.b.a.b.i.s.h.f$a$a */
        /* loaded from: classes.dex */
        public static abstract class AbstractC0080a {
            public abstract a a();

            public abstract AbstractC0080a b(long j2);

            public abstract AbstractC0080a c(long j2);
        }

        public static AbstractC0080a a() {
            c.b bVar = new c.b();
            Set<b> emptySet = Collections.emptySet();
            Objects.requireNonNull(emptySet, "Null flags");
            bVar.c = emptySet;
            return bVar;
        }

        public abstract long b();

        public abstract Set<b> c();

        public abstract long d();
    }

    /* loaded from: classes.dex */
    public enum b {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public abstract f.b.a.b.i.u.a a();

    public long b(d dVar, long j2, int i2) {
        long a2 = j2 - a().a();
        a aVar = c().get(dVar);
        long b2 = aVar.b();
        int i3 = i2 - 1;
        return Math.min(Math.max((long) (Math.pow(3.0d, (double) i3) * ((double) b2) * Math.max(1.0d, Math.log(10000.0d) / Math.log((double) ((b2 > 1 ? b2 : 2) * ((long) i3))))), a2), aVar.d());
    }

    public abstract Map<d, a> c();
}
