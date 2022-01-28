package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.n.a.a;
import e.n.a.m;
import e.q.t;
import gov.ut.covid19.exposurenotifications.R;

public final /* synthetic */ class o0 implements t {
    public final /* synthetic */ x5 a;

    public /* synthetic */ o0(x5 x5Var) {
        this.a = x5Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        m mVar;
        x5 x5Var = this.a;
        ShareDiagnosisViewModel.b bVar = (ShareDiagnosisViewModel.b) obj;
        if (!x5Var.d0) {
            a aVar = new a(x5Var.h());
            switch (bVar.ordinal()) {
                case 1:
                    mVar = new a6();
                    break;
                case 2:
                    mVar = new z5();
                    break;
                case 3:
                    mVar = new u5();
                    break;
                case 4:
                    mVar = new i6();
                    break;
                case 5:
                    mVar = new f6();
                    break;
                case 6:
                    mVar = new c6();
                    break;
                case 7:
                    mVar = new l6();
                    break;
                case 8:
                    mVar = new o5();
                    break;
                case 9:
                    mVar = new e6();
                    break;
                case 10:
                    mVar = new k6();
                    break;
                default:
                    mVar = new s5();
                    break;
            }
            aVar.f(R.id.notify_others_fragment, mVar, "ShareDiagnosisFragment.NOTIFY_OTHERS_FRAGMENT_TAG");
            aVar.f1744f = 4097;
            aVar.d();
            return;
        }
        x5Var.d0 = false;
    }
}
