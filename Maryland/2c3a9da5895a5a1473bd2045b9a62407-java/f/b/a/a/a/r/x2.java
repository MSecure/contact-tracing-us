package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.y.a;
import f.b.a.a.a.y.c0;
import f.b.a.a.a.y.d0;
import f.b.a.a.a.y.v;
import f.b.b.a.g;

public final /* synthetic */ class x2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ g b;

    public /* synthetic */ x2(ShareDiagnosisViewModel shareDiagnosisViewModel, g gVar) {
        this.a = shareDiagnosisViewModel;
        this.b = gVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        g gVar = this.b;
        d0 d0Var = shareDiagnosisViewModel.c;
        long e2 = ((c0) obj).e();
        a aVar = new a(d0Var, gVar);
        v vVar = (v) d0Var.a;
        vVar.a.c();
        try {
            Long b2 = v.b(vVar, e2, aVar);
            vVar.a.l();
            return b2;
        } finally {
            vVar.a.g();
        }
    }
}
