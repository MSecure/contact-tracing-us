package c.a.b;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import c.a.b.g;
import c.a.b.x.b;
import java.util.concurrent.BlockingQueue;

public class j extends Thread {

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<o<?>> f2213b;

    /* renamed from: c  reason: collision with root package name */
    public final i f2214c;

    /* renamed from: d  reason: collision with root package name */
    public final b f2215d;

    /* renamed from: e  reason: collision with root package name */
    public final r f2216e;
    public volatile boolean f = false;

    public j(BlockingQueue<o<?>> blockingQueue, i iVar, b bVar, r rVar) {
        this.f2213b = blockingQueue;
        this.f2214c = iVar;
        this.f2215d = bVar;
        this.f2216e = rVar;
    }

    public final void a() {
        o<?> take = this.f2213b.take();
        SystemClock.elapsedRealtime();
        try {
            take.addMarker("network-queue-take");
            if (take.isCanceled()) {
                take.finish("network-discard-cancelled");
            } else {
                TrafficStats.setThreadStatsTag(take.getTrafficStatsTag());
                l f2 = ((b) this.f2214c).f(take);
                take.addMarker("network-http-complete");
                if (!f2.f2221e || !take.hasHadResponseDelivered()) {
                    q<?> parseNetworkResponse = take.parseNetworkResponse(f2);
                    take.addMarker("network-parse-complete");
                    if (take.shouldCache() && parseNetworkResponse.f2235b != null) {
                        this.f2215d.b(take.getCacheKey(), parseNetworkResponse.f2235b);
                        take.addMarker("network-cache-written");
                    }
                    take.markDelivered();
                    ((g) this.f2216e).a(take, parseNetworkResponse);
                    take.notifyListenerResponseReceived(parseNetworkResponse);
                    return;
                }
                take.finish("not-modified");
            }
            take.notifyListenerResponseNotUsable();
        } catch (v e2) {
            SystemClock.elapsedRealtime();
            v parseNetworkError = take.parseNetworkError(e2);
            g gVar = (g) this.f2216e;
            if (gVar != null) {
                take.addMarker("post-error");
                gVar.f2206a.execute(new g.b(take, new q(parseNetworkError), null));
                take.notifyListenerResponseNotUsable();
                return;
            }
            throw null;
        } catch (Exception e3) {
            w.a("Unhandled exception %s", e3.toString());
            v vVar = new v(e3);
            SystemClock.elapsedRealtime();
            g gVar2 = (g) this.f2216e;
            if (gVar2 != null) {
                take.addMarker("post-error");
                gVar2.f2206a.execute(new g.b(take, new q(vVar), null));
                take.notifyListenerResponseNotUsable();
                return;
            }
            throw null;
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                w.a("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
