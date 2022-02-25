package f.b.a.a.a.q;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.p.b0;
import gov.ca.covid19.exposurenotifications.R;

public class a0 extends w {
    public OnboardingViewModel Z;
    public RelativeLayout a0;
    public Button b0;
    public NestedScrollView c0;
    public boolean d0 = false;

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_onboarding_permission_enabled, viewGroup, false);
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        this.Z = (OnboardingViewModel) new b0(this).a(OnboardingViewModel.class);
        this.a0 = (RelativeLayout) view.findViewById(R.id.onboarding_buttons);
        this.b0 = (Button) view.findViewById(R.id.onboarding_next_button);
        this.c0 = (NestedScrollView) view.findViewById(R.id.onboarding_scroll);
        z0(false);
        this.c0.setOnScrollChangeListener(new p(this));
        this.c0.getViewTreeObserver().addOnGlobalLayoutListener(new q(this));
        this.Z.d().f(B(), new m(this));
    }

    public final void z0(boolean z) {
        RelativeLayout relativeLayout;
        float f2;
        if (z) {
            this.b0.setText(R.string.btn_got_it);
            this.b0.setOnClickListener(new o(this));
            relativeLayout = this.a0;
            f2 = 0.0f;
        } else {
            this.b0.setText(R.string.btn_continue);
            this.b0.setOnClickListener(new n(this));
            relativeLayout = this.a0;
            f2 = v().getDimension(R.dimen.onboarding_button_elevation);
        }
        relativeLayout.setElevation(f2);
        if (this.b0.isAccessibilityFocused()) {
            this.b0.sendAccessibilityEvent(32);
        }
    }
}
