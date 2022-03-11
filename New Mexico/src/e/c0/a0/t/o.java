package e.c0.a0.t;

import android.content.Context;
import e.c0.a0.d;
import e.c0.a0.s.q;
import e.c0.a0.t.s.a;
import e.c0.a0.t.s.c;
import e.c0.i;
import e.c0.v;
import java.util.UUID;
/* loaded from: classes.dex */
public class o implements Runnable {
    public final /* synthetic */ c b;
    public final /* synthetic */ UUID c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ i f1220d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f1221e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ p f1222f;

    public o(p pVar, c cVar, UUID uuid, i iVar, Context context) {
        this.f1222f = pVar;
        this.b = cVar;
        this.c = uuid;
        this.f1220d = iVar;
        this.f1221e = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!(this.b.b instanceof a.c)) {
                String uuid = this.c.toString();
                v g2 = ((q) this.f1222f.c).g(uuid);
                if (g2 == null || g2.a()) {
                    throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                ((d) this.f1222f.b).f(uuid, this.f1220d);
                this.f1221e.startService(e.c0.a0.r.c.b(this.f1221e, uuid, this.f1220d));
            }
            this.b.j(null);
        } catch (Throwable th) {
            this.b.k(th);
        }
    }
}
