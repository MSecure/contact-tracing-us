package f.b.a.a.a.e0;

import android.view.View;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import f.b.a.a.a.w.f1;

public final /* synthetic */ class u implements View.OnClickListener {
    public final /* synthetic */ k0 b;

    public /* synthetic */ u(k0 k0Var) {
        this.b = k0Var;
    }

    public final void onClick(View view) {
        k0 k0Var = this.b;
        k0Var.c0.c(true);
        if (k0Var.b0.c.getVisibility() == 0) {
            OnboardingViewModel onboardingViewModel = k0Var.c0;
            onboardingViewModel.f417d.p(k0Var.b0.f2425d.isChecked());
        }
        if (k0Var.g0) {
            m0.K0(k0Var);
        } else {
            f1.I0(k0Var);
        }
    }
}
