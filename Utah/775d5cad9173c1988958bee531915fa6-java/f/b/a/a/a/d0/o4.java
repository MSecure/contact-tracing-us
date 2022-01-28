package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.l0.k;
import f.b.b.a.g;

public final /* synthetic */ class o4 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ h0.c b;

    public /* synthetic */ o4(ShareDiagnosisViewModel shareDiagnosisViewModel, h0.c cVar) {
        this.a = shareDiagnosisViewModel;
        this.b = cVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        h0.c cVar = this.b;
        shareDiagnosisViewModel.t.j(Boolean.valueOf(h0.c.SHARED.equals(cVar)));
        k.b bVar = (k.b) ((h0) obj).r();
        bVar.c = cVar;
        return bVar.a();
    }
}
