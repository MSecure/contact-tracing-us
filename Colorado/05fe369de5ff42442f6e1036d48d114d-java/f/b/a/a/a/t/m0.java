package f.b.a.a.a.t;

import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.n.a.b;
import e.p.y;
import e.z.t;
import f.b.a.a.a.b0.v0;
import f.b.a.d.a.a0;
import i.a.a;

public final class m0 implements b<OnboardingViewModel> {
    public final a<v0> a;
    public final a<a0> b;
    public final a<t> c;

    public m0(a<v0> aVar, a<a0> aVar2, a<t> aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    /* Return type fixed from 'e.p.e0' to match base method */
    @Override // e.n.a.b
    public OnboardingViewModel a(y yVar) {
        return new OnboardingViewModel(this.a.get(), this.b.get(), this.c.get());
    }
}
