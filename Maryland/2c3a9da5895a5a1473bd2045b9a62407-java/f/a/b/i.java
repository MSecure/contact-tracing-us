package f.a.b;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import f.a.b.f;
import f.a.b.w.b;
import f.a.b.w.h;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class i extends Thread {
    public final BlockingQueue<n<?>> b;
    public final h c;

    /* renamed from: d  reason: collision with root package name */
    public final b f2048d;

    /* renamed from: e  reason: collision with root package name */
    public final q f2049e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f2050f = false;

    public i(BlockingQueue<n<?>> blockingQueue, h hVar, b bVar, q qVar) {
        this.b = blockingQueue;
        this.c = hVar;
        this.f2048d = bVar;
        this.f2049e = qVar;
    }

    public final void a() {
        boolean z;
        n<?> take = this.b.take();
        SystemClock.elapsedRealtime();
        try {
            take.a("network-queue-take");
            take.m();
            TrafficStats.setThreadStatsTag(take.f2054e);
            k f2 = ((b) this.c).f(take);
            take.a("network-http-complete");
            if (f2.f2052e) {
                synchronized (take.f2055f) {
                    z = take.f2060k;
                }
                if (z) {
                    take.c("not-modified");
                    take.n();
                    return;
                }
            }
            p<?> q = take.q(f2);
            take.a("network-parse-complete");
            if (take.f2059j && q.b != null) {
                b bVar = this.f2048d;
                take.h();
                Objects.requireNonNull((h) bVar);
                take.a("network-cache-written");
            }
            synchronized (take.f2055f) {
                take.f2060k = true;
            }
            ((f) this.f2049e).a(take, q, null);
            take.o(q);
        } catch (u e2) {
            SystemClock.elapsedRealtime();
            Objects.requireNonNull(take);
            f fVar = (f) this.f2049e;
            Objects.requireNonNull(fVar);
            take.a("post-error");
            fVar.a.execute(new f.b(take, new p(e2), null));
            take.n();
        } catch (Exception e3) {
            Log.e("Volley", v.a("Unhandled exception %s", e3.toString()), e3);
            u uVar = new u(e3);
            SystemClock.elapsedRealtime();
            f fVar2 = (f) this.f2049e;
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
                if (this.f2050f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.b("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
