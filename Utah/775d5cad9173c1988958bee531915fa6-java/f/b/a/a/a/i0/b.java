package f.b.a.a.a.i0;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import e.u.l;
import e.w.a.f.f;
import f.b.a.a.a.g0.p;
import f.b.a.a.a.l0.s;
import f.b.a.a.a.z.r;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import l.b.a.d;
import l.b.a.e;

public final /* synthetic */ class b implements i {
    public final /* synthetic */ CountryCheckingWorker a;

    public /* synthetic */ b(CountryCheckingWorker countryCheckingWorker) {
        this.a = countryCheckingWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        CountryCheckingWorker countryCheckingWorker = this.a;
        r rVar = countryCheckingWorker.f435j;
        p.d dVar = p.d.TASK_COUNTRY_CHECKING;
        rVar.i(dVar);
        if (((Boolean) obj).booleanValue()) {
            countryCheckingWorker.f433h.a();
        }
        c cVar = countryCheckingWorker.f433h;
        f.b.a.a.a.l0.u uVar = cVar.b;
        e w = cVar.c.c().w(d.f(14));
        f.b.a.a.a.l0.r rVar2 = uVar.a;
        long G = w.G();
        s sVar = (s) rVar2;
        sVar.a.b();
        f a2 = sVar.c.a();
        a2.b.bindLong(1, G);
        sVar.a.c();
        try {
            a2.d();
            sVar.a.l();
            countryCheckingWorker.f435j.g(dVar);
            return f.b.a.c.b.o.b.Q0(new ListenableWorker.a.c());
        } finally {
            sVar.a.g();
            l lVar = sVar.c;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        }
    }
}
