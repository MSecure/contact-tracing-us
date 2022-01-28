package e.b0;

import android.os.Build;
import androidx.work.ListenableWorker;
import e.b0.a0.s.o;
import e.b0.p;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class x {
    public UUID a;
    public o b;
    public Set<String> c;

    public static abstract class a<B extends a<?, ?>, W extends x> {
        public boolean a = false;
        public UUID b = UUID.randomUUID();
        public o c;

        /* renamed from: d  reason: collision with root package name */
        public Set<String> f1182d = new HashSet();

        public a(Class<? extends ListenableWorker> cls) {
            this.c = new o(this.b.toString(), cls.getName());
            this.f1182d.add(cls.getName());
            c();
        }

        public final W a() {
            W b2 = b();
            d dVar = this.c.f1118j;
            int i2 = Build.VERSION.SDK_INT;
            boolean z = (i2 >= 24 && dVar.a()) || dVar.f1162d || dVar.b || (i2 >= 23 && dVar.c);
            if (!this.c.q || !z) {
                this.b = UUID.randomUUID();
                o oVar = new o(this.c);
                this.c = oVar;
                oVar.a = this.b.toString();
                return b2;
            }
            throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
        }

        public abstract W b();

        public abstract B c();

        public final B d(a aVar, long j2, TimeUnit timeUnit) {
            this.a = true;
            o oVar = this.c;
            oVar.f1120l = aVar;
            long millis = timeUnit.toMillis(j2);
            if (millis > 18000000) {
                n.c().f(o.s, "Backoff delay duration exceeds maximum value", new Throwable[0]);
                millis = 18000000;
            }
            if (millis < 10000) {
                n.c().f(o.s, "Backoff delay duration less than minimum value", new Throwable[0]);
                millis = 10000;
            }
            oVar.m = millis;
            return c();
        }

        public B e(long j2, TimeUnit timeUnit) {
            this.c.f1115g = timeUnit.toMillis(j2);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.c.f1115g) {
                return (p.a) this;
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }
    }

    public x(UUID uuid, o oVar, Set<String> set) {
        this.a = uuid;
        this.b = oVar;
        this.c = set;
    }

    public String a() {
        return this.a.toString();
    }
}
