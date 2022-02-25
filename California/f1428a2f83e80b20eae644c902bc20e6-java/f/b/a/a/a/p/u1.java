package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.c.b.l.b;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;
import l.b.a.c;

public final /* synthetic */ class u1 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ u1(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        c cVar = ShareDiagnosisViewModel.z;
        l y = l.x(shareDiagnosisViewModel.d()).y(new a2((f.b.b.b.c) obj), shareDiagnosisViewModel.p).z(new m2(shareDiagnosisViewModel), shareDiagnosisViewModel.o).z(new b2(shareDiagnosisViewModel), shareDiagnosisViewModel.p).z(new v1(shareDiagnosisViewModel), shareDiagnosisViewModel.o).y(new s2(shareDiagnosisViewModel), shareDiagnosisViewModel.p);
        l2 l2Var = new l2(shareDiagnosisViewModel);
        ExecutorService executorService = shareDiagnosisViewModel.p;
        a.b bVar = new a.b(y, b.class, l2Var);
        ((l.a) y).a(bVar, f.b.a.c.b.o.b.A1(executorService, bVar));
        return bVar;
    }
}
