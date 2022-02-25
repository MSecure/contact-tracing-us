package f.b.a.a.a.q;

import android.widget.ViewSwitcher;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.p.r;
import f.b.a.a.a.j.e0;
import java.util.Objects;

public final /* synthetic */ class l implements r {
    public final /* synthetic */ y a;
    public final /* synthetic */ SwitchMaterial b;
    public final /* synthetic */ ViewSwitcher c;

    public /* synthetic */ l(y yVar, SwitchMaterial switchMaterial, ViewSwitcher viewSwitcher) {
        this.a = yVar;
        this.b = switchMaterial;
        this.c = viewSwitcher;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        y yVar = this.a;
        SwitchMaterial switchMaterial = this.b;
        ViewSwitcher viewSwitcher = this.c;
        Objects.requireNonNull(yVar);
        if (((Boolean) obj).booleanValue()) {
            OnboardingViewModel onboardingViewModel = yVar.a0;
            onboardingViewModel.c.f(switchMaterial.isChecked());
            viewSwitcher.setDisplayedChild(1);
            yVar.a0.c(true);
            if (yVar.f0) {
                c0.z0(yVar);
            } else {
                e0.z0(yVar);
            }
        } else {
            viewSwitcher.setDisplayedChild(0);
        }
    }
}
