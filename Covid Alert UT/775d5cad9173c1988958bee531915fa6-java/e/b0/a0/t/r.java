package e.b0.a0.t;

import e.b0.n;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class r {

    /* renamed from: f  reason: collision with root package name */
    public static final String f1144f = n.e("WorkTimer");
    public final ThreadFactory a;
    public final ScheduledExecutorService b;
    public final Map<String, c> c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, b> f1145d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Object f1146e = new Object();

    public class a implements ThreadFactory {
        public int b = 0;

        public a(r rVar) {
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            StringBuilder h2 = f.a.a.a.a.h("WorkManager-WorkTimer-thread-");
            h2.append(this.b);
            newThread.setName(h2.toString());
            this.b++;
            return newThread;
        }
    }

    public interface b {
        void b(String str);
    }

    public static class c implements Runnable {
        public final r b;
        public final String c;

        public c(r rVar, String str) {
            this.b = rVar;
            this.c = str;
        }

        public void run() {
            synchronized (this.b.f1146e) {
                if (this.b.c.remove(this.c) != null) {
                    b remove = this.b.f1145d.remove(this.c);
                    if (remove != null) {
                        remove.b(this.c);
                    }
                } else {
                    n.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.c), new Throwable[0]);
                }
            }
        }
    }

    public r() {
        a aVar = new a(this);
        this.a = aVar;
        this.b = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    public void a(String str, long j2, b bVar) {
        synchronized (this.f1146e) {
            n.c().a(f1144f, String.format("Starting timer for %s", str), new Throwable[0]);
            b(str);
            c cVar = new c(this, str);
            this.c.put(str, cVar);
            this.f1145d.put(str, bVar);
            this.b.schedule(cVar, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void b(String str) {
        synchronized (this.f1146e) {
            if (this.c.remove(str) != null) {
                n.c().a(f1144f, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.f1145d.remove(str);
            }
        }
    }
}
