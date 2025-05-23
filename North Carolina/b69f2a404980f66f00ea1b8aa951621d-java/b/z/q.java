package b.z;

import androidx.work.ListenableWorker;
import b.z.w;
import b.z.y.r.p;
import java.util.concurrent.TimeUnit;

public final class q extends w {

    public static final class a extends w.a<a, q> {
        public a(Class<? extends ListenableWorker> cls, long j, TimeUnit timeUnit) {
            super(cls);
            p pVar = this.f1941c;
            long millis = timeUnit.toMillis(j);
            if (pVar != null) {
                long j2 = 900000;
                if (millis < 900000) {
                    m.c().f(p.r, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
                    millis = 900000;
                }
                if (millis < 900000) {
                    m.c().f(p.r, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
                } else {
                    j2 = millis;
                }
                if (millis < 300000) {
                    m.c().f(p.r, String.format("Flex duration lesser than minimum allowed value; Changed to %s", 300000L), new Throwable[0]);
                    millis = 300000;
                }
                if (millis > j2) {
                    m.c().f(p.r, String.format("Flex duration greater than interval duration; Changed to %s", Long.valueOf(j2)), new Throwable[0]);
                    millis = j2;
                }
                pVar.h = j2;
                pVar.i = millis;
                return;
            }
            throw null;
        }

        /* Return type fixed from 'b.z.w' to match base method */
        @Override // b.z.w.a
        public q b() {
            if (!this.f1939a || !this.f1941c.j.f1900c) {
                p pVar = this.f1941c;
                if (!pVar.q || !pVar.j.f1900c) {
                    return new q(this);
                }
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* Return type fixed from 'b.z.w$a' to match base method */
        @Override // b.z.w.a
        public a c() {
            return this;
        }
    }

    public q(a aVar) {
        super(aVar.f1940b, aVar.f1941c, aVar.f1942d);
    }
}
