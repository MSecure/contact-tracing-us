package f.a.b;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import f.a.b.f;
import f.a.b.w.b;
import f.a.b.w.h;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes.dex */
public class i extends Thread {
    public final BlockingQueue<n<?>> b;
    public final h c;

    /* renamed from: d  reason: collision with root package name */
    public final b f2160d;

    /* renamed from: e  reason: collision with root package name */
    public final q f2161e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f2162f = false;

    public i(BlockingQueue<n<?>> blockingQueue, h hVar, b bVar, q qVar) {
        this.b = blockingQueue;
        this.c = hVar;
        this.f2160d = bVar;
        this.f2161e = qVar;
    }

    public final void a() {
        boolean z;
        n<?> take = this.b.take();
        SystemClock.elapsedRealtime();
        try {
            take.a("network-queue-take");
            take.m();
            TrafficStats.setThreadStatsTag(take.f2166e);
            k f2 = ((b) this.c).f(take);
            take.a("network-http-complete");
            if (f2.f2164e) {
                synchronized (take.f2167f) {
                    z = take.f2172k;
                }
                if (z) {
                    take.c("not-modified");
                    take.n();
                    return;
                }
            }
            p<?> q = take.q(f2);
            take.a("network-parse-complete");
            if (take.f2171j && q.b != null) {
                b bVar = this.f2160d;
                take.h();
                Objects.requireNonNull((h) bVar);
                take.a("network-cache-written");
            }
            synchronized (take.f2167f) {
                take.f2172k = true;
            }
            ((f) this.f2161e).a(take, q, null);
            take.o(q);
        } catch (u e2) {
            SystemClock.elapsedRealtime();
            Objects.requireNonNull(take);
            f fVar = (f) this.f2161e;
            Objects.requireNonNull(fVar);
            take.a("post-error");
            fVar.a.execute(new f.b(take, new p(e2), null));
            take.n();
        } catch (Exception e3) {
            v.a("Unhandled exception %s", e3.toString());
            u uVar = new u(e3);
            SystemClock.elapsedRealtime();
            f fVar2 = (f) this.f2161e;
            Objects.requireNonNull(fVar2);
            take.a("post-error");
            fVar2.a.execute(new f.b(take, new p(uVar), null));
            take.n();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f2162f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.a("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
