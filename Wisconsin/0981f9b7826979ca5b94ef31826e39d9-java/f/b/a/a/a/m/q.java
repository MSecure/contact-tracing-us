package f.b.a.a.a.m;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import e.b.a.m;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.s.a;
import f.b.a.a.a.s.e;
import f.b.a.a.a.s.i;
import f.b.a.a.a.s.s;
import f.b.a.a.a.s.u;
import f.b.a.a.a.w.g;
import f.b.a.a.a.w.h;
import f.b.a.a.a.w.k0;
import f.b.a.a.a.w.n;
import f.b.a.a.a.w.o0;
import f.b.a.a.a.w.p0;
import f.b.a.a.a.w.r0;
import f.b.a.b.f;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import f.b.b.f.a.v;
import f.b.f.d0;
import gov.wi.covid19.exposurenotifications.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import l.b.a.c;
import l.b.a.d;

public class q implements p {
    public final String a;
    public final String b;
    public final k0 c;

    /* renamed from: d  reason: collision with root package name */
    public final f<e> f2132d;

    /* renamed from: e  reason: collision with root package name */
    public final a f2133e;

    /* renamed from: f  reason: collision with root package name */
    public final g f2134f;

    /* renamed from: g  reason: collision with root package name */
    public final v f2135g;

    /* renamed from: h  reason: collision with root package name */
    public final r0 f2136h;

    public q(Context context, k0 k0Var, f<e> fVar, g gVar, a aVar, r0 r0Var, v vVar) {
        String string = context.getResources().getString(R.string.enx_regionIdentifier);
        this.a = string;
        String t = f.a.a.a.a.t("ENX.", string);
        this.b = t;
        this.f2132d = fVar;
        this.c = k0Var;
        this.f2133e = aVar;
        this.f2134f = gVar;
        this.f2135g = vVar;
        this.f2136h = r0Var;
        Log.i(t, "Using firelog analytics logger.");
        c cVar = new c(this, gVar);
        synchronized (k0Var) {
            k0.f2279j = cVar;
        }
    }

    @Override // f.b.a.a.a.m.p
    public void a(s.c cVar) {
        Log.i(this.b, cVar.toString());
        l x = l.x(this.f2135g.submit((Runnable) new e(this, (e) e.newBuilder().addUiInteraction((s) s.newBuilder().setEventType(cVar).build()).build())));
        b bVar = new b(this);
        v vVar = this.f2135g;
        a.b bVar2 = new a.b(x, Exception.class, bVar);
        x.a(bVar2, b.A1(vVar, bVar2));
    }

    @Override // f.b.a.a.a.m.p
    public u<?> b(i.d dVar, int i2) {
        e n = n(dVar, i2);
        String str = this.b;
        Log.i(str, dVar + " succeeded with payload size: " + i2);
        return this.f2135g.submit((Runnable) new g(this, n));
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Type inference failed for r0v7. Raw type applied. Possible types: f.b.b.f.a.u<?>, f.b.b.f.a.u<java.lang.Void> */
    /* JADX DEBUG: Type inference failed for r0v28. Raw type applied. Possible types: f.b.b.f.a.u<?>, f.b.b.f.a.u<java.lang.Void> */
    /* JADX DEBUG: Type inference failed for r0v29. Raw type applied. Possible types: f.b.b.f.a.u<?>, f.b.b.f.a.u<java.lang.Void> */
    @Override // f.b.a.a.a.m.p
    public u<Void> c() {
        if (!this.c.a.getBoolean("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", false)) {
            return f.b.b.f.a.s.c;
        }
        d b2 = this.f2133e.b();
        f.b.b.a.l<d> h2 = this.c.h();
        if (!h2.b()) {
            Log.i(this.b, "Skipped firelog upload - no last timestamp, resetting");
            this.c.i();
            return f.b.b.f.a.s.c;
        } else if (c.b(h2.a(), b2).o() < 4) {
            Log.i(this.b, "Skipped firelog upload - less than 4 hours");
            return f.b.b.f.a.s.c;
        } else {
            int o = (int) c.b(h2.a(), b2).n(30).o();
            this.c.i();
            f.b.a.a.a.w.d dVar = (f.b.a.a.a.w.d) this.f2134f.a;
            Objects.requireNonNull(dVar);
            e.t.i v = e.t.i.v("SELECT * FROM AnalyticsLoggingEntity", 0);
            dVar.a.b();
            Cursor b3 = e.t.p.b.b(dVar.a, v, false, null);
            try {
                int b0 = m.h.b0(b3, "key");
                int b02 = m.h.b0(b3, "eventProto");
                ArrayList arrayList = new ArrayList(b3.getCount());
                while (b3.moveToNext()) {
                    arrayList.add(new h(b3.getLong(b0), b3.getString(b02)));
                }
                b3.close();
                v.V();
                e.b newBuilder = e.newBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        newBuilder.mergeFrom(f.b.b.c.a.a.a(((f.b.a.a.a.w.f) it.next()).a()));
                    } catch (d0 e2) {
                        String str = this.b;
                        Log.e(str, "Error reading from AnalyticsLoggingRepository: " + e2);
                        return new s.a(e2);
                    }
                }
                return l.x(m.h.f0(new j(this, (e) newBuilder.setBuildId(141003).setHoursSinceLastBatch(o).setRegionIdentifier(this.a).build()))).y(new h(this), this.f2135g);
            } catch (Throwable th) {
                b3.close();
                v.V();
                throw th;
            }
        }
    }

    @Override // f.b.a.a.a.m.p
    public u<?> d(a.b bVar, Exception exc) {
        int i2 = exc instanceof f.b.a.c.b.l.b ? ((f.b.a.c.b.l.b) exc).b.c : -2;
        String str = this.b;
        Log.e(str, bVar + " failed.", exc);
        return this.f2135g.submit((Runnable) new f(this, (e) e.newBuilder().addApiCall((f.b.a.a.a.s.a) f.b.a.a.a.s.a.newBuilder().setApiCallType(bVar).setStatusCode(i2).build()).build()));
    }

    @Override // f.b.a.a.a.m.p
    public u<?> e(i.d dVar, Throwable th) {
        return this.f2135g.submit((Runnable) new i(this, m(dVar, th)));
    }

    @Override // f.b.a.a.a.m.p
    public u<?> f(a.b bVar) {
        String str = this.b;
        Log.i(str, bVar + " succeeded.");
        return this.f2135g.submit((Runnable) new a(this, (e) e.newBuilder().addApiCall((f.b.a.a.a.s.a) f.b.a.a.a.s.a.newBuilder().setApiCallType(bVar).setStatusCode(0).build()).build()));
    }

    @Override // f.b.a.a.a.m.p
    public void g(u.d dVar) {
        o((e) e.newBuilder().addWorkManagerTask((f.b.a.a.a.s.u) f.b.a.a.a.s.u.newBuilder().setWorkerTask(dVar).setStatus(u.c.STATUS_SUCCESS).build()).build());
        String str = this.b;
        Log.i(str, dVar + " finished with status: SUCCESS");
    }

    @Override // f.b.a.a.a.m.p
    public void h(u.d dVar) {
        u.c cVar = u.c.STATUS_ABANDONED;
        o((e) e.newBuilder().addWorkManagerTask((f.b.a.a.a.s.u) f.b.a.a.a.s.u.newBuilder().setWorkerTask(dVar).setStatus(cVar).build()).build());
        String str = this.b;
        Log.e(str, dVar + " finished with status: " + cVar);
    }

    /* JADX INFO: finally extract failed */
    @Override // f.b.a.a.a.m.p
    public void i(u.d dVar) {
        r0 r0Var = this.f2136h;
        u.c cVar = u.c.STATUS_STARTED;
        String str = cVar.toString();
        String str2 = dVar.name() + ":" + str;
        p0 p0Var = (p0) r0Var.a;
        Objects.requireNonNull(p0Var);
        e.t.i v = e.t.i.v("SELECT lastRunTimestampMillis FROM WorkerStatusEntity WHERE workerTaskNameAndStatus =  ?", 1);
        if (str2 == null) {
            v.N(1);
        } else {
            v.P(1, str2);
        }
        p0Var.a.b();
        Long l2 = null;
        int i2 = 0;
        Cursor b2 = e.t.p.b.b(p0Var.a, v, false, null);
        try {
            if (b2.moveToFirst()) {
                if (!b2.isNull(0)) {
                    l2 = Long.valueOf(b2.getLong(0));
                }
            }
            f.b.b.a.l c2 = l2 != null ? f.b.b.a.l.c(d.x(l2.longValue())) : f.b.b.a.a.b;
            if (c2.b()) {
                i2 = (int) c.b((l.b.a.w.d) c2.a(), this.f2133e.b()).n(30).o();
            }
            r0 r0Var2 = this.f2136h;
            String str3 = cVar.toString();
            d b3 = this.f2133e.b();
            o0 o0Var = r0Var2.a;
            n nVar = new n(dVar.name() + ":" + str3, b3.D());
            p0 p0Var2 = (p0) o0Var;
            p0Var2.a.b();
            p0Var2.a.c();
            try {
                p0Var2.b.e(nVar);
                p0Var2.a.l();
                p0Var2.a.g();
                o((e) e.newBuilder().addWorkManagerTask((f.b.a.a.a.s.u) f.b.a.a.a.s.u.newBuilder().setWorkerTask(dVar).setStatus(cVar).setHoursSinceLastRun(i2).build()).build());
                Log.i(this.b, dVar + " started");
            } catch (Throwable th) {
                p0Var2.a.g();
                throw th;
            }
        } finally {
            b2.close();
            v.V();
        }
    }

    @Override // f.b.a.a.a.m.p
    public void j(i.d dVar, int i2) {
        o(n(dVar, i2));
        String str = this.b;
        Log.i(str, dVar + " succeeded with payload size: " + i2);
    }

    @Override // f.b.a.a.a.m.p
    public void k(u.d dVar, Throwable th) {
        u.c cVar = u.c.STATUS_FAIL;
        if (th instanceof TimeoutException) {
            cVar = u.c.STATUS_TIMEOUT;
        }
        o((e) e.newBuilder().addWorkManagerTask((f.b.a.a.a.s.u) f.b.a.a.a.s.u.newBuilder().setWorkerTask(dVar).setStatus(cVar).build()).build());
        String str = this.b;
        Log.e(str, dVar + " failed with status: " + cVar);
    }

    @Override // f.b.a.a.a.m.p
    public void l(i.d dVar, Throwable th) {
        o(m(dVar, th));
    }

    public final e m(i.d dVar, Throwable th) {
        i.c cVar = i.c.RESULT_FAILED_UNKNOWN;
        int h0 = m.h.h0(th);
        String d0 = m.h.d0(th);
        String e0 = m.h.e0(th);
        int i2 = h0 / 100;
        if (i2 == 5) {
            cVar = i.c.RESULT_FAILED_GENERIC_5XX;
        } else if (i2 == 4) {
            cVar = i.c.RESULT_FAILED_GENERIC_4XX;
        }
        String str = this.b;
        Log.e(str, dVar + " failed.  Result:[" + cVar + "] HTTP status:[" + h0 + "] Server error:[" + d0 + ":" + e0 + "]");
        return (e) e.newBuilder().addRpcCall((i) i.newBuilder().setRpcCallType(dVar).setRpcCallResult(cVar).build()).build();
    }

    public final e n(i.d dVar, int i2) {
        return (e) e.newBuilder().addRpcCall((i) i.newBuilder().setRpcCallType(dVar).setPayloadSize(i2).setRpcCallResult(i.c.RESULT_SUCCESS).build()).build();
    }

    /* JADX INFO: finally extract failed */
    public final void o(e eVar) {
        if (this.c.a.getBoolean("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", false)) {
            f.b.a.a.a.w.c cVar = this.f2134f.a;
            h hVar = new h(0, f.b.b.c.a.a.c(eVar.toByteArray()));
            f.b.a.a.a.w.d dVar = (f.b.a.a.a.w.d) cVar;
            dVar.a.b();
            dVar.a.c();
            try {
                dVar.b.e(hVar);
                dVar.a.l();
                dVar.a.g();
                if (!this.c.h().b()) {
                    this.c.i();
                }
                Log.i(this.b, "App analytics enabled. Sending log event.");
            } catch (Throwable th) {
                dVar.a.g();
                throw th;
            }
        }
    }
}
