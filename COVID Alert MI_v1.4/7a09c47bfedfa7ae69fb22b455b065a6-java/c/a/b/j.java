package c.a.b;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import c.a.b.g;
import c.a.b.x.b;
import java.util.concurrent.BlockingQueue;

public class j extends Thread {

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<o<?>> f2822b;

    /* renamed from: c  reason: collision with root package name */
    public final i f2823c;

    /* renamed from: d  reason: collision with root package name */
    public final b f2824d;

    /* renamed from: e  reason: collision with root package name */
    public final r f2825e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f2826f = false;

    public j(BlockingQueue<o<?>> blockingQueue, i iVar, b bVar, r rVar) {
        this.f2822b = blockingQueue;
        this.f2823c = iVar;
        this.f2824d = bVar;
        this.f2825e = rVar;
    }

    public final void a() {
        o<?> take = this.f2822b.take();
        SystemClock.elapsedRealtime();
        try {
            take.addMarker("network-queue-take");
            if (take.isCanceled()) {
                take.finish("network-discard-cancelled");
            } else {
                TrafficStats.setThreadStatsTag(take.getTrafficStatsTag());
                l f2 = ((b) this.f2823c).f(take);
                take.addMarker("network-http-complete");
                if (!f2.f2831e || !take.hasHadResponseDelivered()) {
                    q<?> parseNetworkResponse = take.parseNetworkResponse(f2);
                    take.addMarker("network-parse-complete");
                    if (take.shouldCache() && parseNetworkResponse.f2848b != null) {
                        this.f2824d.b(take.getCacheKey(), parseNetworkResponse.f2848b);
                        take.addMarker("network-cache-written");
                    }
                    take.markDelivered();
                    ((g) this.f2825e).a(take, parseNetworkResponse);
                    take.notifyListenerResponseReceived(parseNetworkResponse);
                    return;
                }
                take.finish("not-modified");
            }
            take.notifyListenerResponseNotUsable();
        } catch (v e2) {
            SystemClock.elapsedRealtime();
            v parseNetworkError = take.parseNetworkError(e2);
            g gVar = (g) this.f2825e;
            if (gVar != null) {
                take.addMarker("post-error");
                gVar.f2815a.execute(new g.b(take, new q(parseNetworkError), null));
                take.notifyListenerResponseNotUsable();
                return;
            }
            throw null;
        } catch (Exception e3) {
            w.a("Unhandled exception %s", e3.toString());
            v vVar = new v(e3);
            SystemClock.elapsedRealtime();
            g gVar2 = (g) this.f2825e;
            if (gVar2 != null) {
                take.addMarker("post-error");
                gVar2.f2815a.execute(new g.b(take, new q(vVar), null));
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
                if (this.f2826f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                w.a("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
