package c.a.b;

import android.os.Process;
import c.a.b.b;
import c.a.b.g;
import c.a.b.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class d extends Thread {
    public static final boolean h = w.f2239a;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<o<?>> f2196b;

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<o<?>> f2197c;

    /* renamed from: d  reason: collision with root package name */
    public final b f2198d;

    /* renamed from: e  reason: collision with root package name */
    public final r f2199e;
    public volatile boolean f = false;
    public final a g;

    public static class a implements o.b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<o<?>>> f2200a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final d f2201b;

        public a(d dVar) {
            this.f2201b = dVar;
        }

        public static boolean a(a aVar, o oVar) {
            synchronized (aVar) {
                String cacheKey = oVar.getCacheKey();
                if (aVar.f2200a.containsKey(cacheKey)) {
                    List<o<?>> list = aVar.f2200a.get(cacheKey);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    oVar.addMarker("waiting-for-response");
                    list.add(oVar);
                    aVar.f2200a.put(cacheKey, list);
                    if (w.f2239a) {
                        w.a("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                    }
                    return true;
                }
                aVar.f2200a.put(cacheKey, null);
                oVar.setNetworkRequestCompleteListener(aVar);
                if (w.f2239a) {
                    w.a("new request, sending to network %s", cacheKey);
                }
                return false;
            }
        }

        public synchronized void b(o<?> oVar) {
            String cacheKey = oVar.getCacheKey();
            List<o<?>> remove = this.f2200a.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (w.f2239a) {
                    w.b("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                o<?> remove2 = remove.remove(0);
                this.f2200a.put(cacheKey, remove);
                remove2.setNetworkRequestCompleteListener(this);
                try {
                    this.f2201b.f2197c.put(remove2);
                } catch (InterruptedException e2) {
                    w.a("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    d dVar = this.f2201b;
                    dVar.f = true;
                    dVar.interrupt();
                }
            }
        }
    }

    public d(BlockingQueue<o<?>> blockingQueue, BlockingQueue<o<?>> blockingQueue2, b bVar, r rVar) {
        this.f2196b = blockingQueue;
        this.f2197c = blockingQueue2;
        this.f2198d = bVar;
        this.f2199e = rVar;
        this.g = new a(this);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x00a9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void a() {
        List list;
        ?? r5;
        o<?> take = this.f2196b.take();
        take.addMarker("cache-queue-take");
        if (take.isCanceled()) {
            take.finish("cache-discard-canceled");
            return;
        }
        b.a c2 = this.f2198d.c(take.getCacheKey());
        if (c2 == null) {
            take.addMarker("cache-miss");
            if (a.a(this.g, take)) {
                return;
            }
        } else {
            boolean z = false;
            if (c2.f2193e < System.currentTimeMillis()) {
                take.addMarker("cache-hit-expired");
                take.setCacheEntry(c2);
                if (a.a(this.g, take)) {
                    return;
                }
            } else {
                take.addMarker("cache-hit");
                byte[] bArr = c2.f2189a;
                Map<String, String> map = c2.g;
                if (map == null) {
                    list = null;
                } else {
                    if (map.isEmpty()) {
                        r5 = Collections.emptyList();
                    } else {
                        r5 = new ArrayList(map.size());
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            r5.add(new h(entry.getKey(), entry.getValue()));
                        }
                    }
                    list = r5;
                }
                q<?> parseNetworkResponse = take.parseNetworkResponse(new l(200, bArr, map, list, false, 0));
                take.addMarker("cache-hit-parsed");
                if (c2.f < System.currentTimeMillis()) {
                    z = true;
                }
                if (z) {
                    take.addMarker("cache-hit-refresh-needed");
                    take.setCacheEntry(c2);
                    parseNetworkResponse.f2237d = true;
                    if (!a.a(this.g, take)) {
                        r rVar = this.f2199e;
                        c cVar = new c(this, take);
                        g gVar = (g) rVar;
                        if (gVar != null) {
                            take.markDelivered();
                            take.addMarker("post-response");
                            gVar.f2206a.execute(new g.b(take, parseNetworkResponse, cVar));
                            return;
                        }
                        throw null;
                    }
                }
                ((g) this.f2199e).a(take, parseNetworkResponse);
                return;
            }
        }
        this.f2197c.put(take);
    }

    public void run() {
        if (h) {
            w.b("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f2198d.a();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                w.a("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
