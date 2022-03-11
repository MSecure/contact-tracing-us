package e.c0.a0.t;

import e.c0.n;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class r {

    /* renamed from: f  reason: collision with root package name */
    public static final String f1223f = n.e("WorkTimer");
    public final ThreadFactory a;
    public final ScheduledExecutorService b;
    public final Map<String, c> c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, b> f1224d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Object f1225e = new Object();

    /* loaded from: classes.dex */
    public class a implements ThreadFactory {
        public int b = 0;

        public a(r rVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            StringBuilder h2 = f.a.a.a.a.h("WorkManager-WorkTimer-thread-");
            h2.append(this.b);
            newThread.setName(h2.toString());
            this.b++;
            return newThread;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(String str);
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public final r b;
        public final String c;

        public c(r rVar, String str) {
            this.b = rVar;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.b.f1225e) {
                if (this.b.c.remove(this.c) != null) {
                    b remove = this.b.f1224d.remove(this.c);
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
        synchronized (this.f1225e) {
            n.c().a(f1223f, String.format("Starting timer for %s", str), new Throwable[0]);
            b(str);
            c cVar = new c(this, str);
            this.c.put(str, cVar);
            this.f1224d.put(str, bVar);
            this.b.schedule(cVar, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void b(String str) {
        synchronized (this.f1225e) {
            if (this.c.remove(str) != null) {
                n.c().a(f1223f, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.f1224d.remove(str);
            }
        }
    }
}
