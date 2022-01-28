package b.b0.y.s;

import b.b0.e;
import b.b0.m;
import b.b0.u;
import b.b0.y.r.p;
import b.b0.y.r.r;
import b.b0.y.s.r.c;
import java.util.UUID;

public class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UUID f1290b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f1291c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1292d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ p f1293e;

    public o(p pVar, UUID uuid, e eVar, c cVar) {
        this.f1293e = pVar;
        this.f1290b = uuid;
        this.f1291c = eVar;
        this.f1292d = cVar;
    }

    public void run() {
        String uuid = this.f1290b.toString();
        m.c().a(p.f1294c, String.format("Updating progress for %s (%s)", this.f1290b, this.f1291c), new Throwable[0]);
        this.f1293e.f1295a.beginTransaction();
        try {
            p i = ((r) this.f1293e.f1295a.h()).i(uuid);
            if (i != null) {
                if (i.f1235b == u.RUNNING) {
                    b.b0.y.r.m mVar = new b.b0.y.r.m(uuid, this.f1291c);
                    b.b0.y.r.o oVar = (b.b0.y.r.o) this.f1293e.f1295a.g();
                    oVar.f1230a.assertNotSuspendingTransaction();
                    oVar.f1230a.beginTransaction();
                    try {
                        oVar.f1231b.insert(mVar);
                        oVar.f1230a.setTransactionSuccessful();
                    } finally {
                        oVar.f1230a.endTransaction();
                    }
                } else {
                    m.c().f(p.f1294c, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", uuid), new Throwable[0]);
                }
                this.f1292d.k(null);
                this.f1293e.f1295a.setTransactionSuccessful();
                this.f1293e.f1295a.endTransaction();
                return;
            }
            throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
        } catch (Throwable th) {
            this.f1293e.f1295a.endTransaction();
            throw th;
        }
    }
}
