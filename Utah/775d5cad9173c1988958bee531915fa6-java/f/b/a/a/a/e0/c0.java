package f.b.a.a.a.e0;

import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.c.a.c.a;
import java.util.Objects;

public final /* synthetic */ class c0 implements a {
    public final /* synthetic */ OnboardingViewModel a;

    public /* synthetic */ c0(OnboardingViewModel onboardingViewModel) {
        this.a = onboardingViewModel;
    }

    @Override // e.c.a.c.a
    public final Object a(Object obj) {
        OnboardingViewModel onboardingViewModel = this.a;
        Objects.requireNonNull(onboardingViewModel);
        return Boolean.valueOf(!((Boolean) obj).booleanValue() && onboardingViewModel.f418e.a());
    }
}
