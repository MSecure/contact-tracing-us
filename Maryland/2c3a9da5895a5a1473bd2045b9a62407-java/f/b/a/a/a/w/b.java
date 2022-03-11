package f.b.a.a.a.w;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import e.t.l;
import e.v.a.f.f;
import f.b.a.a.a.o.p;
import f.b.a.a.a.u.u;
import f.b.a.a.a.y.q;
import f.b.a.a.a.y.s;
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
        p pVar = countryCheckingWorker.f412h;
        u.d dVar = u.d.TASK_COUNTRY_CHECKING;
        pVar.i(dVar);
        if (((Boolean) obj).booleanValue()) {
            countryCheckingWorker.f410f.a();
        }
        d dVar2 = countryCheckingWorker.f410f;
        s sVar = dVar2.b;
        d w = dVar2.c.b().w(c.e(14));
        f.b.a.a.a.y.p pVar2 = sVar.a;
        long E = w.E();
        q qVar = (q) pVar2;
        qVar.a.b();
        f a2 = qVar.c.a();
        a2.b.bindLong(1, E);
        qVar.a.c();
        try {
            a2.d();
            qVar.a.l();
            countryCheckingWorker.f412h.g(dVar);
            return f.b.a.c.b.o.b.d1(new ListenableWorker.a.c());
        } finally {
            qVar.a.g();
            l lVar = qVar.c;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        }
    }
}
