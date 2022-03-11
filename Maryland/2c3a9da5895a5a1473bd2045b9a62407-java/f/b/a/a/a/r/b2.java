package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.n.r;
import f.b.a.a.a.n.u;
import f.b.a.a.a.y.c0;
import f.b.b.a.g;
import f.b.b.b.c;

public final /* synthetic */ class b2 implements g {
    public final /* synthetic */ c a;

    public /* synthetic */ b2(c cVar) {
        this.a = cVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        c cVar = this.a;
        c0 c0Var = (c0) obj;
        l.b.a.c cVar2 = ShareDiagnosisViewModel.B;
        r.b bVar = (r.b) u.j(cVar, c0Var.n());
        bVar.f2185e = c0Var.h();
        bVar.f2189i = c0Var.i();
        bVar.f2188h = c0Var.b();
        bVar.f2192l = Boolean.valueOf(c0.e.TRAVELED.equals(c0Var.m()));
        return bVar.a();
    }
}
