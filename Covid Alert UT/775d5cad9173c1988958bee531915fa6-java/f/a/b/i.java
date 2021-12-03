package f.a.b;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import f.a.b.f;
import f.a.b.w.b;
import f.a.b.w.h;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class i extends Thread {
    public final BlockingQueue<n<?>> b;
    public final h c;

    /* renamed from: d  reason: collision with root package name */
    public final b f2133d;

    /* renamed from: e  reason: collision with root package name */
    public final q f2134e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f2135f = false;

    public i(BlockingQueue<n<?>> blockingQueue, h hVar, b bVar, q qVar) {
        this.b = blockingQueue;
        this.c = hVar;
        this.f2133d = bVar;
        this.f2134e = qVar;
    }

    public final void a() {
        boolean z;
        n<?> take = this.b.take();
        SystemClock.elapsedRealtime();
        try {
            take.a("network-queue-take");
            take.m();
            TrafficStats.setThreadStatsTag(take.f2139e);
            k f2 = ((b) this.c).f(take);
            take.a("network-http-complete");
            if (f2.f2137e) {
                synchronized (take.f2140f) {
                    z = take.f2145k;
                }
                if (z) {
                    take.c("not-modified");
                    take.n();
                    return;
                }
            }
            p<?> q = take.q(f2);
            take.a("network-parse-complete");
            if (take.f2144j && q.b != null) {
                b bVar = this.f2133d;
                take.h();
                Objects.requireNonNull((h) bVar);
                take.a("network-cache-written");
            }
            synchronized (take.f2140f) {
                take.f2145k = true;
            }
            ((f) this.f2134e).a(take, q, null);
            take.o(q);
        } catch (u e2) {
            SystemClock.elapsedRealtime();
            Objects.requireNonNull(take);
            f fVar = (f) this.f2134e;
            Objects.requireNonNull(fVar);
            take.a("post-error");
            fVar.a.execute(new f.b(take, new p(e2), null));
            take.n();
        } catch (Exception e3) {
            v.a("Unhandled exception %s", e3.toString());
            u uVar = new u(e3);
            SystemClock.elapsedRealtime();
            f fVar2 = (f) this.f2134e;
            Objects.requireNonNull(fVar2);
            take.a("post-error");
            fVar2.a.execute(new f.b(take, new p(uVar), null));
            take.n();
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f2135f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.a("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
