package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.y.c0;
import f.b.a.a.a.y.j;
import f.b.b.a.g;

public final /* synthetic */ class w2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ c0.c b;

    public /* synthetic */ w2(ShareDiagnosisViewModel shareDiagnosisViewModel, c0.c cVar) {
        this.a = shareDiagnosisViewModel;
        this.b = cVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        c0.c cVar = this.b;
        shareDiagnosisViewModel.o.j(Boolean.valueOf(c0.c.SHARED.equals(cVar)));
        j.b bVar = (j.b) ((c0) obj).p();
        bVar.c = cVar;
        return bVar.a();
    }
}
