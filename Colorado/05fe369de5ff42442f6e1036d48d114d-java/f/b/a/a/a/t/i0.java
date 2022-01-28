package f.b.a.a.a.t;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.b.a.m;
import e.p.f0;
import f.b.a.a.a.j.s;
import gov.co.cdphe.exposurenotifications.R;

public class i0 extends e0 {
    public s a0;
    public OnboardingViewModel b0;
    public RelativeLayout c0;
    public Button d0;
    public NestedScrollView e0;
    public boolean f0 = false;

    public final void C0(boolean z) {
        RelativeLayout relativeLayout;
        float f2;
        if (z) {
            this.d0.setText(R.string.btn_got_it);
            this.d0.setOnClickListener(new w(this));
            relativeLayout = this.c0;
            f2 = 0.0f;
        } else {
            this.d0.setText(R.string.btn_continue);
            this.d0.setOnClickListener(new v(this));
            relativeLayout = this.c0;
            f2 = w().getDimension(R.dimen.bottom_button_container_elevation);
        }
        relativeLayout.setElevation(f2);
        if (this.d0.isAccessibilityFocused()) {
            this.d0.sendAccessibilityEvent(32);
        }
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_permission_enabled, viewGroup, false);
        int i2 = R.id.onboarding_buttons;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.onboarding_buttons);
        if (relativeLayout != null) {
            i2 = R.id.onboarding_next_button;
            Button button = (Button) inflate.findViewById(R.id.onboarding_next_button);
            if (button != null) {
                i2 = R.id.onboarding_scroll;
                NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.onboarding_scroll);
                if (nestedScrollView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                    this.a0 = new s(constraintLayout, relativeLayout, button, nestedScrollView);
                    return constraintLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.a0 = null;
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        this.b0 = (OnboardingViewModel) new f0(this).a(OnboardingViewModel.class);
        s sVar = this.a0;
        this.c0 = sVar.b;
        this.d0 = sVar.c;
        this.e0 = sVar.f2230d;
        C0(false);
        this.e0.setOnScrollChangeListener(new x(this));
        this.e0.getViewTreeObserver().addOnGlobalLayoutListener(new y(this));
        OnboardingViewModel onboardingViewModel = this.b0;
        m.h.G0(m.h.S(onboardingViewModel.c.f2118g), new a0(onboardingViewModel)).f(C(), new u(this));
    }
}
