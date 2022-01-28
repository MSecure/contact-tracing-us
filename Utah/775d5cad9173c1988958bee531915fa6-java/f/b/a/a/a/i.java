package f.b.a.a.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.b.a.m;
import e.o.a.b;
import f.b.a.a.a.f0.n;
import f.b.a.a.a.f0.r;
import f.b.a.a.a.f0.s.c;
import f.b.a.a.a.f0.s.e;
import f.b.a.a.a.f0.s.f;
import f.b.a.a.a.f0.s.g;
import f.b.a.a.a.f0.s.h;
import f.b.a.a.a.f0.s.j;
import f.b.a.a.a.f0.s.k;
import f.b.a.a.a.f0.s.m;
import f.b.a.a.a.f0.s.o;
import f.b.a.a.a.f0.s.p;
import f.b.a.d.a.c0;
import f.b.a.d.a.d0;
import f.b.a.d.a.f0;
import f.b.a.d.a.g0;
import f.b.b.f.a.w;
import g.b.a.c.c.d;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public class i implements b {
    public final /* synthetic */ k a;

    public i(k kVar) {
        this.a = kVar;
    }

    @Override // e.o.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        k kVar = this.a.s;
        Objects.requireNonNull(kVar);
        m mVar = kVar.n;
        Context t = d.t(kVar.c);
        n nVar = new n(kVar.E.get(), kVar.p(), kVar.D.get(), kVar.m());
        w wVar = kVar.t.get();
        p pVar = new p(kVar.b());
        g gVar = new g(kVar.z.get(), kVar.w.get(), kVar.i(), m.e.e1(kVar.f2257e));
        o oVar = new o(kVar.b());
        f.b.a.a.a.f0.s.d dVar = new f.b.a.a.a.f0.s.d(kVar.b());
        e eVar = new e(kVar.b());
        f.b.a.a.a.f0.s.i iVar = new f.b.a.a.a.f0.s.i(kVar.b());
        k kVar2 = new k(kVar.b());
        f fVar = new f(kVar.b());
        j jVar = new j(kVar.b());
        h hVar = new h(kVar.b());
        f.b.a.a.a.f0.s.n nVar2 = new f.b.a.a.a.f0.s.n(kVar.b());
        Objects.requireNonNull(mVar);
        c cVar = new c(mVar, nVar, pVar, gVar, oVar, dVar, iVar, fVar, t, jVar, eVar, kVar2, hVar, nVar2, wVar);
        f0 o = kVar.o();
        r rVar = kVar.o;
        Context t2 = d.t(kVar.c);
        r rVar2 = kVar.o;
        Context t3 = d.t(kVar.c);
        Objects.requireNonNull(rVar2);
        String string = t3.getString(R.string.enx_healthAuthorityID);
        Objects.requireNonNull(string, "Cannot return null from a non-@Nullable @Provides method");
        d0.a f1 = m.e.f1(kVar.o);
        Objects.requireNonNull(rVar);
        return new SubmitPrivateAnalyticsWorker(context, workerParameters, new g0(cVar, o, new c0(new f.b.a.d.a.r(t2, string, f1), kVar.N.get(), m.e.f1(kVar.o)), kVar.n(), m.e.f1(kVar.o), kVar.g()), kVar.u.get(), kVar.t(), m.e.e1(kVar.f2257e), kVar.b(), kVar.m(), kVar.g());
    }
}
