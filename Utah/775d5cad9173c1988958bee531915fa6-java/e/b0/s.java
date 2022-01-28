package e.b0;

import android.os.Build;
import androidx.work.ListenableWorker;
import e.b0.a0.s.o;
import e.b0.x;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class s extends x {

    public static final class a extends x.a<a, s> {
        public a(Class<? extends ListenableWorker> cls, long j2, TimeUnit timeUnit) {
            super(cls);
            o oVar = this.c;
            long millis = timeUnit.toMillis(j2);
            Objects.requireNonNull(oVar);
            long j3 = 900000;
            if (millis < 900000) {
                n.c().f(o.s, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
                millis = 900000;
            }
            if (millis < 900000) {
                n.c().f(o.s, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
            } else {
                j3 = millis;
            }
            if (millis < 300000) {
                n.c().f(o.s, String.format("Flex duration lesser than minimum allowed value; Changed to %s", 300000L), new Throwable[0]);
                millis = 300000;
            }
            if (millis > j3) {
                n.c().f(o.s, String.format("Flex duration greater than interval duration; Changed to %s", Long.valueOf(j3)), new Throwable[0]);
                millis = j3;
            }
            oVar.f1116h = j3;
            oVar.f1117i = millis;
        }

        /* Return type fixed from 'e.b0.x' to match base method */
        @Override // e.b0.x.a
        public s b() {
            if (!this.a || Build.VERSION.SDK_INT < 23 || !this.c.f1118j.c) {
                return new s(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* Return type fixed from 'e.b0.x$a' to match base method */
        @Override // e.b0.x.a
        public a c() {
            return this;
        }
    }

    public s(a aVar) {
        super(aVar.b, aVar.c, aVar.f1182d);
    }
}
