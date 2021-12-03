package h.a.j1;

import java.util.IdentityHashMap;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class t2 {

    /* renamed from: d  reason: collision with root package name */
    public static final t2 f4012d = new t2(new a());
    public final IdentityHashMap<c<?>, b> a = new IdentityHashMap<>();
    public final d b;
    public ScheduledExecutorService c;

    public class a implements d {
    }

    public static class b {
        public final Object a;
        public int b;
        public ScheduledFuture<?> c;

        public b(Object obj) {
            this.a = obj;
        }
    }

    public interface c<T> {
        T a();

        void b(T t);
    }

    public interface d {
    }

    public t2(d dVar) {
        this.b = dVar;
    }

    public static <T> T a(c<T> cVar) {
        T t;
        t2 t2Var = f4012d;
        synchronized (t2Var) {
            b bVar = t2Var.a.get(cVar);
            if (bVar == null) {
                bVar = new b(cVar.a());
                t2Var.a.put(cVar, bVar);
            }
            ScheduledFuture<?> scheduledFuture = bVar.c;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                bVar.c = null;
            }
            bVar.b++;
            t = (T) bVar.a;
        }
        return t;
    }

    public static <T> T b(c<T> cVar, T t) {
        t2 t2Var = f4012d;
        synchronized (t2Var) {
            b bVar = t2Var.a.get(cVar);
            if (bVar != null) {
                boolean z = false;
                f.b.a.c.b.o.b.o(t == bVar.a, "Releasing the wrong instance");
                f.b.a.c.b.o.b.F(bVar.b > 0, "Refcount has already reached zero");
                int i2 = bVar.b - 1;
                bVar.b = i2;
                if (i2 == 0) {
                    if (bVar.c == null) {
                        z = true;
                    }
                    f.b.a.c.b.o.b.F(z, "Destroy task already scheduled");
                    if (t2Var.c == null) {
                        Objects.requireNonNull((a) t2Var.b);
                        t2Var.c = Executors.newSingleThreadScheduledExecutor(q0.d("grpc-shared-destroyer-%d", true));
                    }
                    bVar.c = t2Var.c.schedule(new k1(new u2(t2Var, bVar, cVar, t)), 1, TimeUnit.SECONDS);
                }
            } else {
                throw new IllegalArgumentException("No cached instance found for " + cVar);
            }
        }
        return null;
    }
}
