package f.b.a.a.a.d0;

import android.os.CancellationSignal;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.u.n.d;
import f.b.a.a.a.l0.a1;
import f.b.a.a.a.l0.c1;
import f.b.a.a.a.l0.f1;
import f.b.a.a.a.l0.h0;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.List;
import java.util.Objects;
import l.b.a.e;

public final /* synthetic */ class s2 implements i {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ s2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        List list = (List) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (!list.isEmpty()) {
            return new s.a(new ShareDiagnosisViewModel.d((h0) list.get(0)));
        }
        f1 f1Var = shareDiagnosisViewModel.f399d;
        e c = shareDiagnosisViewModel.f405j.c();
        a1 a1Var = (a1) f1Var.a;
        Objects.requireNonNull(a1Var);
        e.u.i t = e.u.i.t("SELECT nonce FROM VerificationCodeRequestEntity WHERE expiresAtTime > ? ORDER BY expiresAtTime DESC", 1);
        t.x(1, m.e.b0(c));
        CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(a1Var.a, false, new c1(a1Var, t, cancellationSignal), t, true, cancellationSignal);
    }
}
