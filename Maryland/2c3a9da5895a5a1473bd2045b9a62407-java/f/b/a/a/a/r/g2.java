package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.c.a.c.a;
import e.t.i;
import f.b.a.a.a.y.d0;
import f.b.a.a.a.y.v;
import f.b.a.a.a.y.z;
import java.util.Objects;

public final /* synthetic */ class g2 implements a {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ g2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // e.c.a.c.a
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Long l2 = (Long) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (l2.longValue() <= 0) {
            return shareDiagnosisViewModel.t;
        }
        d0 d0Var = shareDiagnosisViewModel.c;
        long longValue = l2.longValue();
        v vVar = (v) d0Var.a;
        Objects.requireNonNull(vVar);
        i v = i.v("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
        v.A(1, longValue);
        return vVar.a.f1886e.b(new String[]{"DiagnosisEntity"}, false, new z(vVar, v));
    }
}
