package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import f.b.a.a.a.n.u;
import f.b.a.a.a.y.c0;
import f.b.a.a.a.y.q0;
import f.b.b.a.g;
import java.util.Objects;
import l.b.a.d;

public final /* synthetic */ class c2 implements g {
    public final /* synthetic */ ShareDiagnosisViewModel a;

    public /* synthetic */ c2(ShareDiagnosisViewModel shareDiagnosisViewModel) {
        this.a = shareDiagnosisViewModel;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a;
        u uVar = (u) obj;
        Objects.requireNonNull(shareDiagnosisViewModel);
        String str = "Upload success: " + uVar;
        shareDiagnosisViewModel.j(new j2(uVar));
        shareDiagnosisViewModel.o.j(Boolean.TRUE);
        q0 q0Var = shareDiagnosisViewModel.f389h;
        d b = shareDiagnosisViewModel.f390i.b();
        if (q0Var.f()) {
            q0Var.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_SUBMITTED_KEYS_TIME", b.E()).apply();
        }
        return c0.c.SHARED;
    }
}
