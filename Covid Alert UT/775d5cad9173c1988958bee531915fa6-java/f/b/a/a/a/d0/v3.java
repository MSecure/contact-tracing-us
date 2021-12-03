package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.s.x;
import f.b.a.a.a.y.a0;
import f.b.a.a.a.y.e0;
import f.b.b.a.g;
import f.b.b.b.c;
import java.util.Objects;

public final /* synthetic */ class v3 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ c b;

    public /* synthetic */ v3(ShareDiagnosisViewModel shareDiagnosisViewModel, c cVar) {
        this.a = shareDiagnosisViewModel;
        this.b = cVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        c cVar = this.b;
        h0 h0Var = (h0) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        a0.b bVar = (a0.b) e0.j(cVar, h0Var.p(), x.a(shareDiagnosisViewModel.f407l));
        bVar.f2471e = h0Var.j();
        bVar.f2475i = h0Var.k();
        bVar.f2474h = h0Var.b();
        bVar.d(h0.e.TRAVELED.equals(h0Var.o()));
        bVar.f2472f = h0Var.n().b();
        return bVar.a();
    }
}
