package f.a.b;

import android.os.Process;
import f.a.b.n;
import f.a.b.w.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class c extends Thread {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f2022h = v.a;
    public final BlockingQueue<n<?>> b;
    public final BlockingQueue<n<?>> c;

    /* renamed from: d  reason: collision with root package name */
    public final b f2023d;

    /* renamed from: e  reason: collision with root package name */
    public final q f2024e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f2025f = false;

    /* renamed from: g  reason: collision with root package name */
    public final a f2026g;

    public static class a implements n.b {
        public final Map<String, List<n<?>>> a = new HashMap();
        public final c b;

        public a(c cVar) {
            this.b = cVar;
        }

        public static boolean a(a aVar, n nVar) {
            synchronized (aVar) {
                String h2 = nVar.h();
                if (aVar.a.containsKey(h2)) {
                    List<n<?>> list = aVar.a.get(h2);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    nVar.a("waiting-for-response");
                    list.add(nVar);
                    aVar.a.put(h2, list);
                    if (v.a) {
                        v.a("Request for cacheKey=%s is in flight, putting on hold.", h2);
                    }
                    return true;
                }
                aVar.a.put(h2, null);
                synchronized (nVar.f2035f) {
                    nVar.n = aVar;
                }
                if (v.a) {
                    v.a("new request, sending to network %s", h2);
                }
                return false;
            }
        }

        public synchronized void b(n<?> nVar) {
            String h2 = nVar.h();
            List<n<?>> remove = this.a.remove(h2);
            if (remove != null && !remove.isEmpty()) {
                if (v.a) {
                    v.c("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), h2);
                }
                n<?> remove2 = remove.remove(0);
                this.a.put(h2, remove);
                synchronized (remove2.f2035f) {
                    remove2.n = this;
                }
                try {
                    this.b.c.put(remove2);
                } catch (InterruptedException e2) {
                    v.b("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    c cVar = this.b;
                    cVar.f2025f = true;
                    cVar.interrupt();
                }
            }
        }
    }

    public c(BlockingQueue<n<?>> blockingQueue, BlockingQueue<n<?>> blockingQueue2, b bVar, q qVar) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.f2023d = bVar;
        this.f2024e = qVar;
        this.f2026g = new a(this);
    }

    public final void a() {
        n<?> take = this.b.take();
        take.a("cache-queue-take");
        take.m();
        b bVar = this.f2023d;
        take.h();
        Objects.requireNonNull(bVar);
        take.a("cache-miss");
        if (!a.a(this.f2026g, take)) {
            this.c.put(take);
        }
    }

    public void run() {
        if (f2022h) {
            v.c("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        Objects.requireNonNull((h) this.f2023d);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f2025f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.b("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
