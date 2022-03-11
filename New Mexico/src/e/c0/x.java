package e.c0;

import android.os.Build;
import androidx.work.ListenableWorker;
import e.c0.a0.s.o;
import e.c0.p;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public abstract class x {
    public UUID a;
    public o b;
    public Set<String> c;

    /* loaded from: classes.dex */
    public static abstract class a<B extends a<?, ?>, W extends x> {
        public o c;
        public boolean a = false;

        /* renamed from: d */
        public Set<String> f1261d = new HashSet();
        public UUID b = UUID.randomUUID();

        public a(Class<? extends ListenableWorker> cls) {
            this.c = new o(this.b.toString(), cls.getName());
            this.f1261d.add(cls.getName());
            c();
        }

        public final W a() {
            W b = b();
            d dVar = this.c.f1197j;
            int i2 = Build.VERSION.SDK_INT;
            boolean z = (i2 >= 24 && dVar.a()) || dVar.f1241d || dVar.b || (i2 >= 23 && dVar.c);
            if (!this.c.q || !z) {
                this.b = UUID.randomUUID();
                o oVar = new o(this.c);
                this.c = oVar;
                oVar.a = this.b.toString();
                return b;
            }
            throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
        }

        public abstract W b();

        public abstract B c();

        public final B d(a aVar, long j2, TimeUnit timeUnit) {
            this.a = true;
            o oVar = this.c;
            oVar.f1199l = aVar;
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
            this.c.f1194g = timeUnit.toMillis(j2);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.c.f1194g) {
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
