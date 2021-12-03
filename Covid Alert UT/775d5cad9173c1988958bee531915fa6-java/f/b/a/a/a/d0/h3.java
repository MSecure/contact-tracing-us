package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.c.a.c.a;
import e.u.i;
import f.b.a.a.a.l0.a0;
import f.b.a.a.a.l0.e0;
import f.b.a.a.a.l0.i0;
import java.util.Objects;

public final /* synthetic */ class h3 implements a {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ h3(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // e.c.a.c.a
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Long l2 = (Long) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (l2.longValue() <= 0) {
            return shareDiagnosisViewModel.A;
        }
        i0 i0Var = shareDiagnosisViewModel.c;
        long longValue = l2.longValue();
        a0 a0Var = (a0) i0Var.a;
        Objects.requireNonNull(a0Var);
        i t = i.t("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
        t.x(1, longValue);
        return a0Var.a.f1977e.b(new String[]{"DiagnosisEntity"}, false, new e0(a0Var, t));
    }
}
