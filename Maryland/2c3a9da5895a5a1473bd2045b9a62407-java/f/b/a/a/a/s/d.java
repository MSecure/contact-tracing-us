package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.p.r;
import f.b.a.a.a.l.l0;
import java.util.Objects;

public final /* synthetic */ class d implements r {
    public final /* synthetic */ y a;

    public /* synthetic */ d(y yVar) {
        this.a = yVar;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        y yVar = this.a;
        Objects.requireNonNull(yVar);
        if (((Boolean) obj).booleanValue()) {
            OnboardingViewModel onboardingViewModel = yVar.c0;
            onboardingViewModel.c.k(yVar.a0.c.isChecked());
            yVar.a0.f2119e.setDisplayedChild(1);
            yVar.c0.c(true);
            if (yVar.h0) {
                c0.z0(yVar);
            } else {
                l0.z0(yVar);
            }
        } else {
            yVar.a0.f2119e.setDisplayedChild(0);
        }
    }
}
