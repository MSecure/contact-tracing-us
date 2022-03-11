package f.b.a.a.a.e0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.n0.k;
import f.b.b.a.g;
/* loaded from: classes.dex */
public final /* synthetic */ class b5 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ j0.c b;

    public /* synthetic */ b5(ShareDiagnosisViewModel shareDiagnosisViewModel, j0.c cVar) {
        this.a = shareDiagnosisViewModel;
        this.b = cVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        j0.c cVar = this.b;
        shareDiagnosisViewModel.u.j(Boolean.valueOf(j0.c.SHARED.equals(cVar)));
        k.b bVar = (k.b) ((j0) obj).r();
        bVar.c = cVar;
        return bVar.a();
    }
}
