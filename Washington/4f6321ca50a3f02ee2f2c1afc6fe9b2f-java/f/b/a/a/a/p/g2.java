package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.w.b0;
import f.b.a.a.a.w.j;
import f.b.b.a.g;

public final /* synthetic */ class g2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ b0.c b;

    public /* synthetic */ g2(ShareDiagnosisViewModel shareDiagnosisViewModel, b0.c cVar) {
        this.a = shareDiagnosisViewModel;
        this.b = cVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        b0.c cVar = this.b;
        shareDiagnosisViewModel.m.j(Boolean.valueOf(b0.c.SHARED.equals(cVar)));
        j.b bVar = (j.b) ((b0) obj).p();
        bVar.c = cVar;
        return bVar.a();
    }
}
