package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.m.a.a;
import e.m.a.m;
import e.p.t;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class o0 implements t {
    public final /* synthetic */ y5 a;

    public /* synthetic */ o0(y5 y5Var) {
        this.a = y5Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        m mVar;
        y5 y5Var = this.a;
        ShareDiagnosisViewModel.b bVar = (ShareDiagnosisViewModel.b) obj;
        if (!y5Var.c0) {
            a aVar = new a(y5Var.h());
            switch (bVar.ordinal()) {
                case 1:
                    mVar = new b6();
                    break;
                case 2:
                    mVar = new a6();
                    break;
                case 3:
                    mVar = new v5();
                    break;
                case 4:
                    mVar = new j6();
                    break;
                case 5:
                    mVar = new g6();
                    break;
                case 6:
                    mVar = new d6();
                    break;
                case 7:
                    mVar = new m6();
                    break;
                case 8:
                    mVar = new p5();
                    break;
                case 9:
                    mVar = new f6();
                    break;
                case 10:
                    mVar = new l6();
                    break;
                default:
                    mVar = new t5();
                    break;
            }
            aVar.f(R.id.notify_others_fragment, mVar, "ShareDiagnosisFragment.NOTIFY_OTHERS_FRAGMENT_TAG");
            aVar.f1471f = 4097;
            aVar.d();
            return;
        }
        y5Var.c0 = false;
    }
}
