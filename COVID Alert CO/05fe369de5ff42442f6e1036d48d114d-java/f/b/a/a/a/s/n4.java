package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.b0.b;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.b0.i0;
import f.b.a.a.a.b0.k;
import f.b.a.a.a.o.e0;
import f.b.b.f.a.d0;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class n4 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ n4(ShareDiagnosisViewModel shareDiagnosisViewModel, String str, boolean z) {
        this.a = shareDiagnosisViewModel;
        this.b = str;
        this.c = z;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        String str = this.b;
        boolean z = this.c;
        e0 e0Var = (e0) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        k.b bVar = (k.b) h0.q();
        bVar.f2104d = str;
        bVar.m = Boolean.valueOf(z);
        bVar.c = h0.c.NOT_ATTEMPTED;
        bVar.f2105e = e0Var.h();
        if (e0Var.o() != null) {
            bVar.g(true);
            bVar.f2108h = e0Var.o();
            bVar.c(h0.b.YES);
        }
        if (e0Var.p() != null) {
            bVar.f2107g = h0.d.a(e0Var.p());
        }
        if (shareDiagnosisViewModel.M) {
            shareDiagnosisViewModel.M = false;
        }
        shareDiagnosisViewModel.f407h.s(shareDiagnosisViewModel.f409j.c());
        i0 i0Var = shareDiagnosisViewModel.c;
        b bVar2 = new b(i0Var, bVar.a());
        ExecutorService executorService = i0Var.b;
        d0 d0Var = new d0(bVar2);
        executorService.execute(d0Var);
        return d0Var;
    }
}
