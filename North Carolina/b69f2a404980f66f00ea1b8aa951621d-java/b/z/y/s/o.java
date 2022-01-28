package b.z.y.s;

import b.z.e;
import b.z.m;
import b.z.u;
import b.z.y.r.p;
import b.z.y.r.r;
import b.z.y.s.r.c;
import java.util.UUID;

public class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UUID f2142b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f2143c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f2144d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ p f2145e;

    public o(p pVar, UUID uuid, e eVar, c cVar) {
        this.f2145e = pVar;
        this.f2142b = uuid;
        this.f2143c = eVar;
        this.f2144d = cVar;
    }

    public void run() {
        String uuid = this.f2142b.toString();
        m.c().a(p.f2146c, String.format("Updating progress for %s (%s)", this.f2142b, this.f2143c), new Throwable[0]);
        this.f2145e.f2147a.beginTransaction();
        try {
            p i = ((r) this.f2145e.f2147a.h()).i(uuid);
            if (i != null) {
                if (i.f2092b == u.RUNNING) {
                    b.z.y.r.m mVar = new b.z.y.r.m(uuid, this.f2143c);
                    b.z.y.r.o oVar = (b.z.y.r.o) this.f2145e.f2147a.g();
                    oVar.f2087a.assertNotSuspendingTransaction();
                    oVar.f2087a.beginTransaction();
                    try {
                        oVar.f2088b.insert(mVar);
                        oVar.f2087a.setTransactionSuccessful();
                    } finally {
                        oVar.f2087a.endTransaction();
                    }
                } else {
                    m.c().f(p.f2146c, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", uuid), new Throwable[0]);
                }
                this.f2144d.k(null);
                this.f2145e.f2147a.setTransactionSuccessful();
                this.f2145e.f2147a.endTransaction();
                return;
            }
            throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
        } catch (Throwable th) {
            this.f2145e.f2147a.endTransaction();
            throw th;
        }
    }
}
