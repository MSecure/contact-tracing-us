package b.z.y.s;

import b.z.m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class q {
    public static final String f = m.e("WorkTimer");

    /* renamed from: a  reason: collision with root package name */
    public final ThreadFactory f2149a = new a(this);

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f2150b = Executors.newSingleThreadScheduledExecutor(this.f2149a);

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, c> f2151c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, b> f2152d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Object f2153e = new Object();

    public class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public int f2154a = 0;

        public a(q qVar) {
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            StringBuilder g = c.a.a.a.a.g("WorkManager-WorkTimer-thread-");
            g.append(this.f2154a);
            newThread.setName(g.toString());
            this.f2154a++;
            return newThread;
        }
    }

    public interface b {
        void b(String str);
    }

    public static class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final q f2155b;

        /* renamed from: c  reason: collision with root package name */
        public final String f2156c;

        public c(q qVar, String str) {
            this.f2155b = qVar;
            this.f2156c = str;
        }

        public void run() {
            synchronized (this.f2155b.f2153e) {
                if (this.f2155b.f2151c.remove(this.f2156c) != null) {
                    b remove = this.f2155b.f2152d.remove(this.f2156c);
                    if (remove != null) {
                        remove.b(this.f2156c);
                    }
                } else {
                    m.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.f2156c), new Throwable[0]);
                }
            }
        }
    }

    public void a(String str, long j, b bVar) {
        synchronized (this.f2153e) {
            m.c().a(f, String.format("Starting timer for %s", str), new Throwable[0]);
            b(str);
            c cVar = new c(this, str);
            this.f2151c.put(str, cVar);
            this.f2152d.put(str, bVar);
            this.f2150b.schedule(cVar, j, TimeUnit.MILLISECONDS);
        }
    }

    public void b(String str) {
        synchronized (this.f2153e) {
            if (this.f2151c.remove(str) != null) {
                m.c().a(f, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.f2152d.remove(str);
            }
        }
    }
}
