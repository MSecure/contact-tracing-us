package f.b.a.a.a.u;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import e.t.l;
import e.v.a.f.f;
import f.b.a.a.a.m.p;
import f.b.a.a.a.s.u;
import f.b.a.a.a.w.o;
import f.b.a.a.a.w.r;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import l.b.a.c;
import l.b.a.d;

public final /* synthetic */ class b implements i {
    public final /* synthetic */ CountryCheckingWorker a;

    public /* synthetic */ b(CountryCheckingWorker countryCheckingWorker) {
        this.a = countryCheckingWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        CountryCheckingWorker countryCheckingWorker = this.a;
        p pVar = countryCheckingWorker.f396h;
        u.d dVar = u.d.TASK_COUNTRY_CHECKING;
        pVar.i(dVar);
        if (((Boolean) obj).booleanValue()) {
            countryCheckingWorker.f394f.a();
        }
        d dVar2 = countryCheckingWorker.f394f;
        r rVar = dVar2.b;
        d v = dVar2.c.b().v(c.e(14));
        o oVar = rVar.a;
        long D = v.D();
        f.b.a.a.a.w.p pVar2 = (f.b.a.a.a.w.p) oVar;
        pVar2.a.b();
        f a2 = pVar2.c.a();
        a2.b.bindLong(1, D);
        pVar2.a.c();
        try {
            a2.d();
            pVar2.a.l();
            countryCheckingWorker.f396h.g(dVar);
            return f.b.a.c.b.o.b.c1(new ListenableWorker.a.c());
        } finally {
            pVar2.a.g();
            l lVar = pVar2.c;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        }
    }
}
