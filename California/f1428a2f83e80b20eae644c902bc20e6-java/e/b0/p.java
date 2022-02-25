package e.b0;

import android.os.Build;
import androidx.work.ListenableWorker;
import e.b0.u;
import e.b0.x.s.o;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class p extends u {

    public static final class a extends u.a<a, p> {
        public a(Class<? extends ListenableWorker> cls, long j2, TimeUnit timeUnit) {
            super(cls);
            o oVar = this.c;
            long millis = timeUnit.toMillis(j2);
            Objects.requireNonNull(oVar);
            long j3 = 900000;
            if (millis < 900000) {
                l.c().f(o.r, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
                millis = 900000;
            }
            if (millis < 900000) {
                l.c().f(o.r, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
            } else {
                j3 = millis;
            }
            if (millis < 300000) {
                l.c().f(o.r, String.format("Flex duration lesser than minimum allowed value; Changed to %s", 300000L), new Throwable[0]);
                millis = 300000;
            }
            if (millis > j3) {
                l.c().f(o.r, String.format("Flex duration greater than interval duration; Changed to %s", Long.valueOf(j3)), new Throwable[0]);
                millis = j3;
            }
            oVar.f1118h = j3;
            oVar.f1119i = millis;
        }

        /* Return type fixed from 'e.b0.u' to match base method */
        @Override // e.b0.u.a
        public p b() {
            int i2 = Build.VERSION.SDK_INT;
            if (!this.a || i2 < 23 || !this.c.f1120j.c) {
                o oVar = this.c;
                if (!oVar.q || i2 < 23 || !oVar.f1120j.c) {
                    return new p(this);
                }
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* Return type fixed from 'e.b0.u$a' to match base method */
        @Override // e.b0.u.a
        public a c() {
            return this;
        }
    }

    public p(a aVar) {
        super(aVar.b, aVar.c, aVar.f1005d);
    }
}
