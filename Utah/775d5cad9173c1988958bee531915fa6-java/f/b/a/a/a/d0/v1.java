package f.b.a.a.a.d0;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.a.e.a;
import e.a.e.b;
import f.b.a.a.a.l0.h0;
import java.util.Objects;

public final /* synthetic */ class v1 implements b {
    public final /* synthetic */ i6 a;

    public /* synthetic */ v1(i6 i6Var) {
        this.a = i6Var;
    }

    @Override // e.a.e.b
    public final void a(Object obj) {
        i6 i6Var = this.a;
        Objects.requireNonNull(i6Var);
        if (((a) obj).b == -1) {
            i6Var.b0.v();
            return;
        }
        ShareDiagnosisViewModel shareDiagnosisViewModel = i6Var.b0;
        shareDiagnosisViewModel.o(new o4(shareDiagnosisViewModel, h0.c.NOT_ATTEMPTED));
    }
}
