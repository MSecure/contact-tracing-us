package e.b0.a0.t;

import android.content.Context;
import e.b0.a0.d;
import e.b0.a0.s.q;
import e.b0.a0.t.s.a;
import e.b0.a0.t.s.c;
import e.b0.i;
import e.b0.v;
import java.util.UUID;

public class o implements Runnable {
    public final /* synthetic */ c b;
    public final /* synthetic */ UUID c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ i f1141d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f1142e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ p f1143f;

    public o(p pVar, c cVar, UUID uuid, i iVar, Context context) {
        this.f1143f = pVar;
        this.b = cVar;
        this.c = uuid;
        this.f1141d = iVar;
        this.f1142e = context;
    }

    public void run() {
        try {
            if (!(this.b.b instanceof a.c)) {
                String uuid = this.c.toString();
                v g2 = ((q) this.f1143f.c).g(uuid);
                if (g2 == null || g2.a()) {
                    throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                ((d) this.f1143f.b).f(uuid, this.f1141d);
                this.f1142e.startService(e.b0.a0.r.c.b(this.f1142e, uuid, this.f1141d));
            }
            this.b.j(null);
        } catch (Throwable th) {
            this.b.k(th);
        }
    }
}
