package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.a.e.a;
import e.a.e.b;
import f.b.a.a.a.b0.h0;
import java.util.Objects;

public final /* synthetic */ class v1 implements b {
    public final /* synthetic */ j6 a;

    public /* synthetic */ v1(j6 j6Var) {
        this.a = j6Var;
    }

    @Override // e.a.e.b
    public final void a(Object obj) {
        j6 j6Var = this.a;
        Objects.requireNonNull(j6Var);
        if (((a) obj).b == -1) {
            j6Var.a0.v();
            return;
        }
        ShareDiagnosisViewModel shareDiagnosisViewModel = j6Var.a0;
        shareDiagnosisViewModel.o(new o4(shareDiagnosisViewModel, h0.c.NOT_ATTEMPTED));
    }
}
