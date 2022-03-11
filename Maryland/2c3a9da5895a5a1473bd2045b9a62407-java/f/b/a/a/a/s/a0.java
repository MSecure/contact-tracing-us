package f.b.a.a.a.s;

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
import e.p.b0;
import f.b.a.a.a.i.p;
import gov.md.covid19.exposurenotifications.R;

public class a0 extends w {
    public p a0;
    public OnboardingViewModel b0;
    public RelativeLayout c0;
    public Button d0;
    public NestedScrollView e0;
    public boolean f0 = false;

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                    this.a0 = new p(constraintLayout, relativeLayout, button, nestedScrollView);
                    return constraintLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        this.a0 = null;
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        this.b0 = (OnboardingViewModel) new b0(this).a(OnboardingViewModel.class);
        p pVar = this.a0;
        this.c0 = pVar.b;
        this.d0 = pVar.c;
        this.e0 = pVar.f2125d;
        z0(false);
        this.e0.setOnScrollChangeListener(new p(this));
        this.e0.getViewTreeObserver().addOnGlobalLayoutListener(new q(this));
        m.h.A0(m.h.R(this.b0.c.f2359f), u.a).f(B(), new m(this));
    }

    public final void z0(boolean z) {
        RelativeLayout relativeLayout;
        float f2;
        if (z) {
            this.d0.setText(R.string.btn_got_it);
            this.d0.setOnClickListener(new o(this));
            relativeLayout = this.c0;
            f2 = 0.0f;
        } else {
            this.d0.setText(R.string.btn_continue);
            this.d0.setOnClickListener(new n(this));
            relativeLayout = this.c0;
            f2 = v().getDimension(R.dimen.onboarding_button_elevation);
        }
        relativeLayout.setElevation(f2);
        if (this.d0.isAccessibilityFocused()) {
            this.d0.sendAccessibilityEvent(32);
        }
    }
}
