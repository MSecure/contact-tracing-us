package b.b0.y.s;

import android.content.Context;
import b.b0.g;
import b.b0.u;
import b.b0.y.d;
import b.b0.y.r.r;
import b.b0.y.s.r.a;
import b.b0.y.s.r.c;
import java.util.UUID;

public class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f1282b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UUID f1283c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f1284d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f1285e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ n f1286f;

    public m(n nVar, c cVar, UUID uuid, g gVar, Context context) {
        this.f1286f = nVar;
        this.f1282b = cVar;
        this.f1283c = uuid;
        this.f1284d = gVar;
        this.f1285e = context;
    }

    public void run() {
        try {
            if (!(this.f1282b.f1309b instanceof a.c)) {
                String uuid = this.f1283c.toString();
                u g2 = ((r) this.f1286f.f1289c).g(uuid);
                if (g2 == null || g2.b()) {
                    throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                ((d) this.f1286f.f1288b).f(uuid, this.f1284d);
                this.f1285e.startService(b.b0.y.q.c.b(this.f1285e, uuid, this.f1284d));
            }
            this.f1282b.k(null);
        } catch (Throwable th) {
            this.f1282b.l(th);
        }
    }
}
