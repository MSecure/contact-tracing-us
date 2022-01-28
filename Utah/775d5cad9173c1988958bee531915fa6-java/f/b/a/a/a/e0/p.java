package f.b.a.a.a.e0;

import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.q.t;
import f.b.a.a.a.w.f1;
import java.util.Objects;

public final /* synthetic */ class p implements t {
    public final /* synthetic */ i0 a;

    public /* synthetic */ p(i0 i0Var) {
        this.a = i0Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        i0 i0Var = this.a;
        Objects.requireNonNull(i0Var);
        if (((Boolean) obj).booleanValue()) {
            OnboardingViewModel onboardingViewModel = i0Var.a0;
            onboardingViewModel.f417d.p(i0Var.g0.c.isChecked());
            i0Var.g0.f2419e.setDisplayedChild(1);
            i0Var.a0.c(true);
            if (i0Var.l0) {
                m0.K0(i0Var);
            } else {
                f1.I0(i0Var);
            }
        } else {
            i0Var.g0.f2419e.setDisplayedChild(0);
        }
    }
}
