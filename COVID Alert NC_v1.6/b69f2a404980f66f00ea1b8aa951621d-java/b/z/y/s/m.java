package b.z.y.s;

import android.content.Context;
import b.z.g;
import b.z.u;
import b.z.y.d;
import b.z.y.r.r;
import b.z.y.s.r.a;
import b.z.y.s.r.c;
import java.util.UUID;

public class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f2135b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UUID f2136c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f2137d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f2138e;
    public final /* synthetic */ n f;

    public m(n nVar, c cVar, UUID uuid, g gVar, Context context) {
        this.f = nVar;
        this.f2135b = cVar;
        this.f2136c = uuid;
        this.f2137d = gVar;
        this.f2138e = context;
    }

    public void run() {
        try {
            if (!(this.f2135b.f2158b instanceof a.c)) {
                String uuid = this.f2136c.toString();
                u g = ((r) this.f.f2141c).g(uuid);
                if (g == null || g.b()) {
                    throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                ((d) this.f.f2140b).f(uuid, this.f2137d);
                this.f2138e.startService(b.z.y.q.c.b(this.f2138e, uuid, this.f2137d));
            }
            this.f2135b.k(null);
        } catch (Throwable th) {
            this.f2135b.l(th);
        }
    }
}
