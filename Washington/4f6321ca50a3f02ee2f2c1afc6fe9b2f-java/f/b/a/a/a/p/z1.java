package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.w.a;
import f.b.a.a.a.w.b0;
import f.b.a.a.a.w.c0;
import f.b.a.a.a.w.u;
import f.b.b.a.g;

public final /* synthetic */ class z1 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ g b;

    public /* synthetic */ z1(ShareDiagnosisViewModel shareDiagnosisViewModel, g gVar) {
        this.a = shareDiagnosisViewModel;
        this.b = gVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        g gVar = this.b;
        c0 c0Var = shareDiagnosisViewModel.c;
        long e2 = ((b0) obj).e();
        a aVar = new a(c0Var, gVar);
        u uVar = (u) c0Var.a;
        uVar.a.c();
        try {
            Long b2 = u.b(uVar, e2, aVar);
            uVar.a.l();
            return b2;
        } finally {
            uVar.a.g();
        }
    }
}
