package f.b.a.a.a.z;

import android.content.Context;
import android.database.Cursor;
import e.b.a.m;
import e.u.i;
import f.b.a.a.a.b0.i1;
import f.b.a.a.a.g0.a;
import f.b.a.a.a.g0.c;
import f.b.a.a.a.g0.d;
import f.b.a.a.a.g0.n;
import f.b.a.a.a.g0.p;
import f.b.a.a.a.l0.g;
import f.b.a.a.a.l0.g1;
import f.b.a.a.a.l0.h;
import f.b.a.a.a.l0.h1;
import f.b.a.a.a.l0.j1;
import f.b.a.a.a.l0.q;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.z.r;
import f.b.a.b.f;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import f.b.b.f.a.w;
import f.b.g.d0;
import gov.ut.covid19.exposurenotifications.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;
import l.b.a.d;
import l.b.a.e;

public class s implements r {

    /* renamed from: j  reason: collision with root package name */
    public static final f.b.a.a.a.s.d0.a f2511j = f.b.a.a.a.s.d0.a.e("FirelogAnalyticsLogger");

    /* renamed from: k  reason: collision with root package name */
    public static final d f2512k = d.n(120);
    public final g.a<i1> a;
    public final String b;
    public final v0 c;

    /* renamed from: d  reason: collision with root package name */
    public final f<c> f2513d;

    /* renamed from: e  reason: collision with root package name */
    public final f.b.a.a.a.s.e0.a f2514e;

    /* renamed from: f  reason: collision with root package name */
    public final h f2515f;

    /* renamed from: g  reason: collision with root package name */
    public final w f2516g;

    /* renamed from: h  reason: collision with root package name */
    public final ScheduledExecutorService f2517h;

    /* renamed from: i  reason: collision with root package name */
    public final j1 f2518i;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public s(Context context, v0 v0Var, g.a<i1> aVar, f<c> fVar, h hVar, f.b.a.a.a.s.e0.a aVar2, j1 j1Var, w wVar, ScheduledExecutorService scheduledExecutorService) {
        this.b = context.getResources().getString(R.string.enx_regionIdentifier);
        this.f2513d = fVar;
        this.c = v0Var;
        this.a = aVar;
        this.f2514e = aVar2;
        this.f2515f = hVar;
        this.f2516g = wVar;
        this.f2517h = scheduledExecutorService;
        this.f2518i = j1Var;
        f2511j.f("Using firelog analytics logger.");
        c cVar = new c(hVar);
        synchronized (v0Var) {
            v0.m = cVar;
        }
    }

    @Override // f.b.a.a.a.z.r
    public void a(n.c cVar) {
        f2511j.f(cVar.toString());
        l x = l.x(this.f2516g.submit((Runnable) new d(this, (c) c.newBuilder().addUiInteraction((n) n.newBuilder().setEventType(cVar).build()).build())));
        k kVar = k.a;
        w wVar = this.f2516g;
        a.b bVar = new a.b(x, Exception.class, kVar);
        x.a(bVar, f.b.a.c.b.o.b.j1(wVar, bVar));
    }

    @Override // f.b.a.a.a.z.r
    public u<?> b(boolean z) {
        f.b.a.a.a.s.d0.a aVar;
        String str;
        g gVar = null;
        if (!z) {
            Iterator it = ((ArrayList) this.f2515f.b()).iterator();
            g gVar2 = null;
            while (it.hasNext()) {
                g gVar3 = (g) it.next();
                try {
                    for (f.b.a.a.a.g0.a aVar2 : c.parseFrom(f.b.b.c.a.a.a(gVar3.a())).getApiCallList()) {
                        if (aVar2.getApiCallType().equals(a.b.CALL_STOP)) {
                            gVar2 = gVar3;
                        }
                    }
                } catch (d0 e2) {
                    f2511j.c("Error decoding EnxLogExtension: " + e2);
                }
            }
            f2511j.a(gVar2 != null ? "findLastStopCallIfExists: Found last stop call: " + gVar2 : "findLastStopCallIfExists: No stop call found");
            gVar = gVar2;
            aVar = f2511j;
            if (gVar != null) {
                str = "!isEnabled but stop call found, partially uploading logs.";
            } else {
                aVar.a("!isEnabled and no stop call found, not uploading logs.");
                return new s.a(new r.a());
            }
        } else {
            aVar = f2511j;
            str = "isEnabled, fully uploading logs.";
        }
        aVar.a(str);
        e c2 = this.f2514e.c();
        f.b.b.a.l<e> n = this.c.n();
        if (!n.b()) {
            f2511j.f("Skipped firelog upload - no last timestamp, resetting");
            this.c.o();
        } else if (d.c(n.a(), c2).s() < 4) {
            f2511j.f("Skipped firelog upload - less than 4 hours");
        } else {
            int s = (int) d.c(n.a(), c2).r(30).s();
            this.c.o();
            List<g> b2 = this.f2515f.b();
            c.b newBuilder = c.newBuilder();
            Iterator it2 = ((ArrayList) b2).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                g gVar4 = (g) it2.next();
                try {
                    newBuilder.mergeFrom(f.b.b.c.a.a.a(gVar4.a()));
                    if (gVar != null && gVar4.b() == gVar.b()) {
                        f2511j.a("Stopping to build EnxLogExtension at " + gVar);
                        break;
                    }
                } catch (d0 e3) {
                    f2511j.c("Error reading from AnalyticsLoggingRepository: " + e3);
                    return new s.a(e3);
                }
            }
            l y = l.x(f.b.a.c.b.o.b.Q0(Boolean.valueOf(this.c.a.getBoolean("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", false)))).z(new j(this, (c) newBuilder.setBuildId(11000112).setHoursSinceLastBatch(s).setRegionIdentifier(this.b).build()), this.f2516g).y(new h(this, gVar), this.f2516g);
            a aVar3 = a.a;
            w wVar = this.f2516g;
            a.b bVar = new a.b(y, b.class, aVar3);
            y.a(bVar, f.b.a.c.b.o.b.j1(wVar, bVar));
            return bVar;
        }
        return f.b.b.f.a.s.c;
    }

    @Override // f.b.a.a.a.z.r
    public u<?> c(d.EnumC0074d dVar, int i2) {
        c n = n(dVar, i2);
        f.b.a.a.a.s.d0.a aVar = f2511j;
        aVar.f(dVar + " succeeded with payload size: " + i2);
        return this.f2516g.submit((Runnable) new f(this, n));
    }

    @Override // f.b.a.a.a.z.r
    public u<?> d(a.b bVar, Exception exc) {
        int i2 = exc instanceof f.b.a.c.b.l.b ? ((f.b.a.c.b.l.b) exc).b.c : -2;
        f.b.a.a.a.s.d0.a aVar = f2511j;
        aVar.d(bVar + " failed.", exc);
        return this.f2516g.submit((Runnable) new e(this, (c) c.newBuilder().addApiCall((f.b.a.a.a.g0.a) f.b.a.a.a.g0.a.newBuilder().setApiCallType(bVar).setStatusCode(i2).build()).build()));
    }

    @Override // f.b.a.a.a.z.r
    public u<?> e(d.EnumC0074d dVar, Throwable th) {
        return this.f2516g.submit((Runnable) new g(this, m(dVar, th)));
    }

    @Override // f.b.a.a.a.z.r
    public u<?> f(a.b bVar) {
        f.b.a.a.a.s.d0.a aVar = f2511j;
        aVar.f(bVar + " succeeded.");
        return this.f2516g.submit((Runnable) new b(this, (c) c.newBuilder().addApiCall((f.b.a.a.a.g0.a) f.b.a.a.a.g0.a.newBuilder().setApiCallType(bVar).setStatusCode(0).build()).build()));
    }

    @Override // f.b.a.a.a.z.r
    public void g(p.d dVar) {
        o((c) c.newBuilder().addWorkManagerTask((p) p.newBuilder().setWorkerTask(dVar).setStatus(p.c.STATUS_SUCCESS).build()).build());
        f.b.a.a.a.s.d0.a aVar = f2511j;
        aVar.f(dVar + " finished with status: SUCCESS");
    }

    @Override // f.b.a.a.a.z.r
    public void h(p.d dVar) {
        p.c cVar = p.c.STATUS_ABANDONED;
        o((c) c.newBuilder().addWorkManagerTask((p) p.newBuilder().setWorkerTask(dVar).setStatus(cVar).build()).build());
        f.b.a.a.a.s.d0.a aVar = f2511j;
        aVar.c(dVar + " finished with status: " + cVar);
    }

    /* JADX INFO: finally extract failed */
    @Override // f.b.a.a.a.z.r
    public void i(p.d dVar) {
        j1 j1Var = this.f2518i;
        p.c cVar = p.c.STATUS_STARTED;
        String str = cVar.toString();
        String str2 = dVar.name() + ":" + str;
        h1 h1Var = (h1) j1Var.a;
        Objects.requireNonNull(h1Var);
        i t = i.t("SELECT lastRunTimestampMillis FROM WorkerStatusEntity WHERE workerTaskNameAndStatus =  ?", 1);
        if (str2 == null) {
            t.J(1);
        } else {
            t.L(1, str2);
        }
        h1Var.a.b();
        Long l2 = null;
        int i2 = 0;
        Cursor b2 = e.u.p.b.b(h1Var.a, t, false, null);
        try {
            if (b2.moveToFirst()) {
                if (!b2.isNull(0)) {
                    l2 = Long.valueOf(b2.getLong(0));
                }
            }
            f.b.b.a.l c2 = l2 != null ? f.b.b.a.l.c(e.z(l2.longValue())) : f.b.b.a.a.b;
            if (c2.b()) {
                i2 = (int) l.b.a.d.c((l.b.a.x.d) c2.a(), this.f2514e.c()).r(30).s();
            }
            j1 j1Var2 = this.f2518i;
            String str3 = cVar.toString();
            e c3 = this.f2514e.c();
            g1 g1Var = j1Var2.a;
            q qVar = new q(dVar.name() + ":" + str3, c3.G());
            h1 h1Var2 = (h1) g1Var;
            h1Var2.a.b();
            h1Var2.a.c();
            try {
                h1Var2.b.e(qVar);
                h1Var2.a.l();
                h1Var2.a.g();
                o((c) c.newBuilder().addWorkManagerTask((p) p.newBuilder().setWorkerTask(dVar).setStatus(cVar).setHoursSinceLastRun(i2).build()).build());
                f2511j.f(dVar + " started");
            } catch (Throwable th) {
                h1Var2.a.g();
                throw th;
            }
        } finally {
            b2.close();
            t.Q();
        }
    }

    @Override // f.b.a.a.a.z.r
    public void j(d.EnumC0074d dVar, int i2) {
        o(n(dVar, i2));
        f.b.a.a.a.s.d0.a aVar = f2511j;
        aVar.f(dVar + " succeeded with payload size: " + i2);
    }

    @Override // f.b.a.a.a.z.r
    public void k(p.d dVar, Throwable th) {
        p.c cVar = p.c.STATUS_FAIL;
        if (th instanceof TimeoutException) {
            cVar = p.c.STATUS_TIMEOUT;
        }
        o((c) c.newBuilder().addWorkManagerTask((p) p.newBuilder().setWorkerTask(dVar).setStatus(cVar).build()).build());
        f.b.a.a.a.s.d0.a aVar = f2511j;
        aVar.c(dVar + " failed with status: " + cVar);
    }

    @Override // f.b.a.a.a.z.r
    public void l(d.EnumC0074d dVar, Throwable th) {
        o(m(dVar, th));
    }

    public final c m(d.EnumC0074d dVar, Throwable th) {
        d.c p0 = m.e.p0(th);
        int n0 = m.e.n0(th);
        String j0 = m.e.j0(th);
        String k0 = m.e.k0(th);
        f.b.a.a.a.s.d0.a aVar = f2511j;
        aVar.c(dVar + " failed.  Result:[" + p0 + "] HTTP status:[" + n0 + "] Server error:[" + j0 + ":" + k0 + "]");
        return (c) c.newBuilder().addRpcCall((f.b.a.a.a.g0.d) f.b.a.a.a.g0.d.newBuilder().setRpcCallType(dVar).setRpcCallResult(p0).build()).build();
    }

    public final c n(d.EnumC0074d dVar, int i2) {
        return (c) c.newBuilder().addRpcCall((f.b.a.a.a.g0.d) f.b.a.a.a.g0.d.newBuilder().setRpcCallType(dVar).setPayloadSize(i2).setRpcCallResult(d.c.RESULT_SUCCESS).build()).build();
    }

    public final void o(c cVar) {
        if (this.c.a.getBoolean("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", false)) {
            this.f2515f.c(cVar);
            if (!this.c.n().b()) {
                this.c.o();
            }
            f2511j.f("App analytics enabled via in-app consent. Sending log event.");
            return;
        }
        f2511j.a("App analytics disabled via in-app consent. Not sending log event.");
    }
}
