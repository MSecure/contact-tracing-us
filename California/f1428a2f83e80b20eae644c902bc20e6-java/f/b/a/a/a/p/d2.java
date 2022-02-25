package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.c.a.c.a;
import e.t.i;
import f.b.a.a.a.w.c0;
import f.b.a.a.a.w.u;
import f.b.a.a.a.w.y;
import java.util.Objects;

public final /* synthetic */ class d2 implements a {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ d2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // e.c.a.c.a
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        Long l2 = (Long) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (l2.longValue() <= 0) {
            return shareDiagnosisViewModel.r;
        }
        c0 c0Var = shareDiagnosisViewModel.c;
        long longValue = l2.longValue();
        u uVar = (u) c0Var.a;
        Objects.requireNonNull(uVar);
        i v = i.v("SELECT * FROM DiagnosisEntity WHERE id = ?", 1);
        v.A(1, longValue);
        return uVar.a.f1854e.b(new String[]{"DiagnosisEntity"}, false, new y(uVar, v));
    }
}
