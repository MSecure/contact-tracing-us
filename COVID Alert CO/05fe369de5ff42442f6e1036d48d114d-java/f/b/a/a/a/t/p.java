package f.b.a.a.a.t;

import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.p.t;
import f.b.a.a.a.m.f1;
import java.util.Objects;

public final /* synthetic */ class p implements t {
    public final /* synthetic */ g0 a;

    public /* synthetic */ p(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        g0 g0Var = this.a;
        Objects.requireNonNull(g0Var);
        if (((Boolean) obj).booleanValue()) {
            OnboardingViewModel onboardingViewModel = g0Var.a0;
            onboardingViewModel.c.p(g0Var.f0.c.isChecked());
            g0Var.f0.f2224e.setDisplayedChild(1);
            g0Var.a0.c(true);
            if (g0Var.k0) {
                k0.E0(g0Var);
            } else {
                f1.C0(g0Var);
            }
        } else {
            g0Var.f0.f2224e.setDisplayedChild(0);
        }
    }
}
