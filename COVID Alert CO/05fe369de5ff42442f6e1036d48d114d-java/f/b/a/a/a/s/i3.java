package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.b0.e1;
import f.b.a.a.a.i.e0.a;
import f.b.b.a.g;
import java.util.List;

public final /* synthetic */ class i3 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel.e a;

    public /* synthetic */ i3(ShareDiagnosisViewModel.e eVar) {
        this.a = eVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel.e eVar = this.a;
        List list = (List) obj;
        a aVar = ShareDiagnosisViewModel.O;
        if (list.isEmpty() || list.size() < eVar.a().intValue()) {
            return null;
        }
        return ((e1) list.get(0)).e();
    }
}
