package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.s.d0.a;
import f.b.a.c.b.l.b;
import f.b.b.b.c;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class t2 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ t2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        a aVar = ShareDiagnosisViewModel.O;
        Objects.requireNonNull(shareDiagnosisViewModel);
        ShareDiagnosisViewModel.O.a("Certifying and uploading keys...");
        l y = l.x(shareDiagnosisViewModel.e()).y(new v3(shareDiagnosisViewModel, (c) obj), shareDiagnosisViewModel.y).z(new h4(shareDiagnosisViewModel), shareDiagnosisViewModel.x).z(new e3(shareDiagnosisViewModel), shareDiagnosisViewModel.y).z(new z3(shareDiagnosisViewModel), shareDiagnosisViewModel.x).y(new k3(shareDiagnosisViewModel), shareDiagnosisViewModel.y);
        i4 i4Var = new i4(shareDiagnosisViewModel);
        ExecutorService executorService = shareDiagnosisViewModel.y;
        a.b bVar = new a.b(y, b.class, i4Var);
        y.a(bVar, f.b.a.c.b.o.b.j1(executorService, bVar));
        return bVar;
    }
}
