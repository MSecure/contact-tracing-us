package b.b0.y.s;

import b.b0.m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class q {

    /* renamed from: f  reason: collision with root package name */
    public static final String f1297f = m.e("WorkTimer");

    /* renamed from: a  reason: collision with root package name */
    public final ThreadFactory f1298a = new a(this);

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f1299b = Executors.newSingleThreadScheduledExecutor(this.f1298a);

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, c> f1300c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, b> f1301d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Object f1302e = new Object();

    public class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public int f1303a = 0;

        public a(q qVar) {
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            StringBuilder h = c.a.a.a.a.h("WorkManager-WorkTimer-thread-");
            h.append(this.f1303a);
            newThread.setName(h.toString());
            this.f1303a++;
            return newThread;
        }
    }

    public interface b {
        void b(String str);
    }

    public static class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final q f1304b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1305c;

        public c(q qVar, String str) {
            this.f1304b = qVar;
            this.f1305c = str;
        }

        public void run() {
            synchronized (this.f1304b.f1302e) {
                if (this.f1304b.f1300c.remove(this.f1305c) != null) {
                    b remove = this.f1304b.f1301d.remove(this.f1305c);
                    if (remove != null) {
                        remove.b(this.f1305c);
                    }
                } else {
                    m.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.f1305c), new Throwable[0]);
                }
            }
        }
    }

    public void a(String str, long j, b bVar) {
        synchronized (this.f1302e) {
            m.c().a(f1297f, String.format("Starting timer for %s", str), new Throwable[0]);
            b(str);
            c cVar = new c(this, str);
            this.f1300c.put(str, cVar);
            this.f1301d.put(str, bVar);
            this.f1299b.schedule(cVar, j, TimeUnit.MILLISECONDS);
        }
    }

    public void b(String str) {
        synchronized (this.f1302e) {
            if (this.f1300c.remove(str) != null) {
                m.c().a(f1297f, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.f1301d.remove(str);
            }
        }
    }
}
