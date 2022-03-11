package f.b.a.a.a.a0;

import android.content.Context;
import e.b.a.m;
import f.b.a.a.a.h0.a;
import f.b.a.a.a.h0.d;
import f.b.a.a.a.h0.n;
import f.b.a.a.a.h0.p;
import f.b.a.a.a.t.p0.a;
import f.b.a.c.b.l.b;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import gov.nm.covid19.exposurenotifications.R;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public class t implements r {
    public static final a a = a.e("LogcatAnalyticsLogger");

    public t(Context context) {
        context.getApplicationContext().getResources().getString(R.string.enx_regionIdentifier);
        a.f("Using logcat analytics logger.");
    }

    @Override // f.b.a.a.a.a0.r
    public void a(n.c cVar) {
        if (cVar == n.c.LOW_STORAGE_WARNING_SHOWN) {
            a.c(cVar.toString());
        } else {
            a.f(cVar.toString());
        }
    }

    @Override // f.b.a.a.a.a0.r
    public u<Void> b(boolean z) {
        a.f("LogcatAnalytics logger - no batch upload operation specified");
        return s.c;
    }

    @Override // f.b.a.a.a.a0.r
    public u<?> c(d.EnumC0076d dVar, int i2) {
        j(dVar, i2);
        return s.c;
    }

    @Override // f.b.a.a.a.a0.r
    public u<?> d(a.b bVar, Exception exc) {
        if (!(exc instanceof b) || ((b) exc).b.c != 6) {
            f.b.a.a.a.t.p0.a aVar = a;
            aVar.d(bVar + " failed.", exc);
        } else {
            f.b.a.a.a.t.p0.a aVar2 = a;
            aVar2.f(bVar + " requires resolution");
        }
        return s.c;
    }

    @Override // f.b.a.a.a.a0.r
    public u<?> e(d.EnumC0076d dVar, Throwable th) {
        l(dVar, th);
        return s.c;
    }

    @Override // f.b.a.a.a.a0.r
    public u<?> f(a.b bVar) {
        f.b.a.a.a.t.p0.a aVar = a;
        aVar.f(bVar + " succeeded.");
        return s.c;
    }

    @Override // f.b.a.a.a.a0.r
    public void g(p.d dVar) {
        f.b.a.a.a.t.p0.a aVar = a;
        aVar.f(dVar + " finished with status: " + p.c.STATUS_SUCCESS);
    }

    @Override // f.b.a.a.a.a0.r
    public void h(p.d dVar) {
        f.b.a.a.a.t.p0.a aVar = a;
        aVar.c(dVar + " finished with status: " + p.c.STATUS_ABANDONED);
    }

    @Override // f.b.a.a.a.a0.r
    public void i(p.d dVar) {
        f.b.a.a.a.t.p0.a aVar = a;
        aVar.f(dVar + " started.");
    }

    @Override // f.b.a.a.a.a0.r
    public void j(d.EnumC0076d dVar, int i2) {
        f.b.a.a.a.t.p0.a aVar = a;
        aVar.f(dVar + " succeeded with payload size: " + i2);
    }

    @Override // f.b.a.a.a.a0.r
    public void k(p.d dVar, Throwable th) {
        p.c cVar = p.c.STATUS_FAIL;
        if (th instanceof TimeoutException) {
            cVar = p.c.STATUS_TIMEOUT;
        }
        f.b.a.a.a.t.p0.a aVar = a;
        aVar.c(dVar + " failed with status: " + cVar);
    }

    @Override // f.b.a.a.a.a0.r
    public void l(d.EnumC0076d dVar, Throwable th) {
        d.c r0 = m.e.r0(th);
        int p0 = m.e.p0(th);
        String k0 = m.e.k0(th);
        String l0 = m.e.l0(th);
        f.b.a.a.a.t.p0.a aVar = a;
        aVar.c(dVar + " failed.  Result:[" + r0 + "] HTTP status:[" + p0 + "] Server error:[" + k0 + ":" + l0 + "]");
    }
}
