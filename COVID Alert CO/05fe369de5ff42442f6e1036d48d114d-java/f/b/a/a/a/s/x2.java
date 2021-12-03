package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.o.j0;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;
import l.b.a.d;
import l.b.a.e;

public final /* synthetic */ class x2 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;
    public final /* synthetic */ j0 b;

    public /* synthetic */ x2(ShareDiagnosisViewModel shareDiagnosisViewModel, j0 j0Var) {
        this.a = shareDiagnosisViewModel;
        this.b = j0Var;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        long j2;
        long j3;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        j0 j0Var = this.b;
        e eVar = (e) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (eVar == null) {
            return shareDiagnosisViewModel.f404e.a(j0Var);
        }
        d b2 = ShareDiagnosisViewModel.Q.b();
        d c = d.c(eVar, shareDiagnosisViewModel.f409j.c());
        Objects.requireNonNull(b2);
        long j4 = c.b;
        int i2 = c.c;
        if (j4 == Long.MIN_VALUE) {
            b2 = b2.q(Long.MAX_VALUE, (long) (-i2));
            j3 = 1;
            j2 = 0;
        } else {
            j3 = -j4;
            j2 = (long) (-i2);
        }
        long j5 = b2.q(j3, j2).b / 60;
        return new s.a(new ShareDiagnosisViewModel.c(shareDiagnosisViewModel.f406g.getQuantityString(R.plurals.self_report_code_already_requested, (int) j5, Long.valueOf(j5))));
    }
}
