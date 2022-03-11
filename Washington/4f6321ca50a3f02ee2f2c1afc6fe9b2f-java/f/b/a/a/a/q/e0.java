package f.b.a.a.a.q;

import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.b0.t;
import e.n.a.b;
import e.p.u;
import f.b.a.a.a.w.k0;
import i.a.a;

public final class e0 implements b<OnboardingViewModel> {
    public final a<k0> a;
    public final a<t> b;

    public e0(a<k0> aVar, a<t> aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    /* Return type fixed from 'e.p.a0' to match base method */
    @Override // e.n.a.b
    public OnboardingViewModel a(u uVar) {
        return new OnboardingViewModel(this.a.get(), this.b.get());
    }
}
