package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.c.b.l.b;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;
import l.b.a.c;

public final /* synthetic */ class y1 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ y1(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        c cVar = ShareDiagnosisViewModel.B;
        l y = l.x(shareDiagnosisViewModel.d()).y(new b2((f.b.b.b.c) obj), shareDiagnosisViewModel.r).z(new d3(shareDiagnosisViewModel), shareDiagnosisViewModel.q).z(new f2(shareDiagnosisViewModel), shareDiagnosisViewModel.r).z(new k2(shareDiagnosisViewModel), shareDiagnosisViewModel.q).y(new c2(shareDiagnosisViewModel), shareDiagnosisViewModel.r);
        e2 e2Var = new e2(shareDiagnosisViewModel);
        ExecutorService executorService = shareDiagnosisViewModel.r;
        a.b bVar = new a.b(y, b.class, e2Var);
        ((l.a) y).a(bVar, f.b.a.c.b.o.b.z1(executorService, bVar));
        return bVar;
    }
}
