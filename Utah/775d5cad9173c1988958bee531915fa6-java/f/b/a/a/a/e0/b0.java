package f.b.a.a.a.e0;

import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.q.s;
import f.b.a.c.i.f;
import f.b.b.a.l;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class b0 implements f {
    public final /* synthetic */ OnboardingViewModel a;
    public final /* synthetic */ Resources b;

    public /* synthetic */ b0(OnboardingViewModel onboardingViewModel, Resources resources) {
        this.a = onboardingViewModel;
        this.b = resources;
    }

    @Override // f.b.a.c.i.f
    public final void b(Object obj) {
        Boolean bool;
        s<l<Boolean>> sVar;
        Bundle bundle;
        OnboardingViewModel onboardingViewModel = this.a;
        Resources resources = this.b;
        f.b.a.c.f.b.f fVar = (f.b.a.c.f.b.f) obj;
        Objects.requireNonNull(onboardingViewModel);
        if (resources.getBoolean(R.bool.enx_enableV1toENXMigration)) {
            sVar = onboardingViewModel.f420g;
            boolean z = false;
            if (!(fVar == null || (bundle = fVar.b) == null)) {
                z = bundle.containsKey("METRICS_OPT_IN");
            }
            bool = Boolean.valueOf(!z);
        } else {
            sVar = onboardingViewModel.f420g;
            bool = Boolean.FALSE;
        }
        sVar.j(l.c(bool));
    }
}
