package e.c0;

import androidx.work.ListenableWorker;
import e.c0.p;
import e.c0.x.s.o;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class u {
    public UUID a;
    public o b;
    public Set<String> c;

    public static abstract class a<B extends a<?, ?>, W extends u> {
        public boolean a = false;
        public UUID b = UUID.randomUUID();
        public o c;

        /* renamed from: d  reason: collision with root package name */
        public Set<String> f1024d = new HashSet();

        public a(Class<? extends ListenableWorker> cls) {
            this.c = new o(this.b.toString(), cls.getName());
            this.f1024d.add(cls.getName());
            c();
        }

        public final W a() {
            W b2 = b();
            this.b = UUID.randomUUID();
            o oVar = new o(this.c);
            this.c = oVar;
            oVar.a = this.b.toString();
            return b2;
        }

        public abstract W b();

        public abstract B c();

        public final B d(a aVar, long j2, TimeUnit timeUnit) {
            this.a = true;
            o oVar = this.c;
            oVar.f1141l = aVar;
            long millis = timeUnit.toMillis(j2);
            if (millis > 18000000) {
                l.c().f(o.r, "Backoff delay duration exceeds maximum value", new Throwable[0]);
                millis = 18000000;
            }
            if (millis < 10000) {
                l.c().f(o.r, "Backoff delay duration less than minimum value", new Throwable[0]);
                millis = 10000;
            }
            oVar.m = millis;
            return (p.a) this;
        }
    }

    public u(UUID uuid, o oVar, Set<String> set) {
        this.a = uuid;
        this.b = oVar;
        this.c = set;
    }

    public String a() {
        return this.a.toString();
    }
}
