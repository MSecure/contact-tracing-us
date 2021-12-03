package f.b.a.a.a.e0;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.b.a.m;
import e.q.f0;
import f.b.a.a.a.m0.b;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.t.s;
import gov.ut.covid19.exposurenotifications.R;

public class k0 extends g0 {
    public s b0;
    public OnboardingViewModel c0;
    public RelativeLayout d0;
    public Button e0;
    public NestedScrollView f0;
    public boolean g0 = false;

    public final void I0(boolean z) {
        RelativeLayout relativeLayout;
        float f2;
        if (z) {
            this.e0.setText(R.string.btn_got_it);
            this.e0.setOnClickListener(new u(this));
            relativeLayout = this.d0;
            f2 = 0.0f;
        } else {
            this.e0.setText(R.string.btn_continue);
            this.e0.setOnClickListener(new y(this));
            relativeLayout = this.d0;
            f2 = A().getDimension(R.dimen.bottom_button_container_elevation);
        }
        relativeLayout.setElevation(f2);
        if (this.e0.isAccessibilityFocused()) {
            this.e0.sendAccessibilityEvent(32);
        }
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_permission_enabled, viewGroup, false);
        int i2 = R.id.app_analytics_detail;
        TextView textView = (TextView) inflate.findViewById(R.id.app_analytics_detail);
        if (textView != null) {
            i2 = R.id.app_analytics_section;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.app_analytics_section);
            if (linearLayout != null) {
                i2 = R.id.onboarding_app_analytics_switch;
                SwitchMaterial switchMaterial = (SwitchMaterial) inflate.findViewById(R.id.onboarding_app_analytics_switch);
                if (switchMaterial != null) {
                    i2 = R.id.onboarding_buttons;
                    RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.onboarding_buttons);
                    if (relativeLayout != null) {
                        i2 = R.id.onboarding_next_button;
                        Button button = (Button) inflate.findViewById(R.id.onboarding_next_button);
                        if (button != null) {
                            i2 = R.id.onboarding_scroll;
                            NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.onboarding_scroll);
                            if (nestedScrollView != null) {
                                LinearLayout linearLayout2 = (LinearLayout) inflate;
                                this.b0 = new s(linearLayout2, textView, linearLayout, switchMaterial, relativeLayout, button, nestedScrollView);
                                return linearLayout2;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.b0 = null;
    }

    @Override // e.n.a.m
    public void g0() {
        this.D = true;
        OnboardingViewModel onboardingViewModel = this.c0;
        onboardingViewModel.c.a().f(new b0(onboardingViewModel, t0().getResources()));
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        this.c0 = (OnboardingViewModel) new f0(this).a(OnboardingViewModel.class);
        s sVar = this.b0;
        this.d0 = sVar.f2426e;
        this.e0 = sVar.f2427f;
        this.f0 = sVar.f2428g;
        String E = E(R.string.learn_more);
        String E2 = E(R.string.app_analytics_link);
        a aVar = b.a;
        f.b.a.a.a.m0.a aVar2 = new f.b.a.a.a.m0.a(E2);
        String F = F(R.string.onboarding_metrics_description, E);
        SpannableString spannableString = new SpannableString(F);
        int indexOf = F.indexOf(E);
        spannableString.setSpan(aVar2, indexOf, E.length() + indexOf, 33);
        this.b0.b.setText(spannableString);
        this.b0.b.setMovementMethod(LinkMovementMethod.getInstance());
        this.c0.f420g.f(G(), new x(this));
        I0(false);
        this.f0.setOnScrollChangeListener(new w(this));
        this.f0.getViewTreeObserver().addOnGlobalLayoutListener(new v(this));
        OnboardingViewModel onboardingViewModel = this.c0;
        m.e.R0(m.e.U(onboardingViewModel.f417d.f2315g), new c0(onboardingViewModel)).f(G(), new z(this));
    }
}
