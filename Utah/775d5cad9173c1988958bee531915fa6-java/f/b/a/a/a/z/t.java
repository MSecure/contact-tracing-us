package f.b.a.a.a.z;

import android.content.Context;
import e.b.a.m;
import f.b.a.a.a.g0.a;
import f.b.a.a.a.g0.d;
import f.b.a.a.a.g0.n;
import f.b.a.a.a.g0.p;
import f.b.a.a.a.s.d0.a;
import f.b.a.c.b.l.b;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import gov.ut.covid19.exposurenotifications.R;
import java.util.concurrent.TimeoutException;

public class t implements r {
    public static final a a = a.e("LogcatAnalyticsLogger");

    public t(Context context) {
        context.getApplicationContext().getResources().getString(R.string.enx_regionIdentifier);
        a.f("Using logcat analytics logger.");
    }

    @Override // f.b.a.a.a.z.r
    public void a(n.c cVar) {
        if (cVar == n.c.LOW_STORAGE_WARNING_SHOWN) {
            a.c(cVar.toString());
        } else {
            a.f(cVar.toString());
        }
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: f.b.b.f.a.u<?>, f.b.b.f.a.u<java.lang.Void> */
    @Override // f.b.a.a.a.z.r
    public u<Void> b(boolean z) {
        a.f("LogcatAnalytics logger - no batch upload operation specified");
        return s.c;
    }

    @Override // f.b.a.a.a.z.r
    public u<?> c(d.EnumC0074d dVar, int i2) {
        j(dVar, i2);
        return s.c;
    }

    @Override // f.b.a.a.a.z.r
    public u<?> d(a.b bVar, Exception exc) {
        if (!(exc instanceof b) || ((b) exc).b.c != 6) {
            f.b.a.a.a.s.d0.a aVar = a;
            aVar.d(bVar + " failed.", exc);
        } else {
            f.b.a.a.a.s.d0.a aVar2 = a;
            aVar2.f(bVar + " requires resolution");
        }
        return s.c;
    }

    @Override // f.b.a.a.a.z.r
    public u<?> e(d.EnumC0074d dVar, Throwable th) {
        l(dVar, th);
        return s.c;
    }

    @Override // f.b.a.a.a.z.r
    public u<?> f(a.b bVar) {
        f.b.a.a.a.s.d0.a aVar = a;
        aVar.f(bVar + " succeeded.");
        return s.c;
    }

    @Override // f.b.a.a.a.z.r
    public void g(p.d dVar) {
        f.b.a.a.a.s.d0.a aVar = a;
        aVar.f(dVar + " finished with status: " + p.c.STATUS_SUCCESS);
    }

    @Override // f.b.a.a.a.z.r
    public void h(p.d dVar) {
        f.b.a.a.a.s.d0.a aVar = a;
        aVar.c(dVar + " finished with status: " + p.c.STATUS_ABANDONED);
    }

    @Override // f.b.a.a.a.z.r
    public void i(p.d dVar) {
        f.b.a.a.a.s.d0.a aVar = a;
        aVar.f(dVar + " started.");
    }

    @Override // f.b.a.a.a.z.r
    public void j(d.EnumC0074d dVar, int i2) {
        f.b.a.a.a.s.d0.a aVar = a;
        aVar.f(dVar + " succeeded with payload size: " + i2);
    }

    @Override // f.b.a.a.a.z.r
    public void k(p.d dVar, Throwable th) {
        p.c cVar = p.c.STATUS_FAIL;
        if (th instanceof TimeoutException) {
            cVar = p.c.STATUS_TIMEOUT;
        }
        f.b.a.a.a.s.d0.a aVar = a;
        aVar.c(dVar + " failed with status: " + cVar);
    }

    @Override // f.b.a.a.a.z.r
    public void l(d.EnumC0074d dVar, Throwable th) {
        d.c p0 = m.e.p0(th);
        int n0 = m.e.n0(th);
        String j0 = m.e.j0(th);
        String k0 = m.e.k0(th);
        f.b.a.a.a.s.d0.a aVar = a;
        aVar.c(dVar + " failed.  Result:[" + p0 + "] HTTP status:[" + n0 + "] Server error:[" + j0 + ":" + k0 + "]");
    }
}
