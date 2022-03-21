package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.l.q;
import f.b.a.a.a.l.t;
import f.b.a.a.a.w.b0;
import f.b.b.a.g;
import f.b.b.b.c;

public final /* synthetic */ class a2 implements g {
    public final /* synthetic */ c a;

    public /* synthetic */ a2(c cVar) {
        this.a = cVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        c cVar = this.a;
        b0 b0Var = (b0) obj;
        l.b.a.c cVar2 = ShareDiagnosisViewModel.z;
        q.b bVar = (q.b) t.j(cVar, b0Var.n());
        bVar.f2105e = b0Var.h();
        bVar.f2109i = b0Var.i();
        bVar.f2108h = b0Var.b();
        bVar.f2112l = Boolean.valueOf(b0.e.TRAVELED.equals(b0Var.m()));
        return bVar.a();
    }
}
