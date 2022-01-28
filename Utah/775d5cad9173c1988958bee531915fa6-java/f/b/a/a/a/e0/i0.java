package f.b.a.a.a.e0;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.b.a.m;
import f.b.a.a.a.m0.b;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.t.r;
import f.b.a.a.a.w.f1;
import gov.ut.covid19.exposurenotifications.R;

public class i0 extends f0 {
    public r g0;
    public ExposureNotificationViewModel.b h0;
    public LinearLayout i0;
    public Button j0;
    public NestedScrollView k0;
    public boolean l0 = false;

    @Override // f.b.a.a.a.e0.d0
    public void G0() {
        this.a0.f417d.a.edit().putBoolean("ExposureNotificationSharedPreferences.IS_IN_APP_SMS_NOTICE_SEEN", true).apply();
        if (ExposureNotificationViewModel.b.STORAGE_LOW.equals(this.h0)) {
            H0();
        } else {
            this.W.f();
        }
    }

    @Override // f.b.a.a.a.e0.d0
    public void J0() {
        this.a0.c(false);
        f1.I0(this);
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_permission_disabled, viewGroup, false);
        int i2 = R.id.app_analytics_detail;
        TextView textView = (TextView) inflate.findViewById(R.id.app_analytics_detail);
        if (textView != null) {
            i2 = R.id.onboarding_app_analytics_switch;
            SwitchMaterial switchMaterial = (SwitchMaterial) inflate.findViewById(R.id.onboarding_app_analytics_switch);
            if (switchMaterial != null) {
                i2 = R.id.onboarding_buttons;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.onboarding_buttons);
                if (linearLayout != null) {
                    i2 = R.id.onboarding_buttons_loading_switcher;
                    ViewSwitcher viewSwitcher = (ViewSwitcher) inflate.findViewById(R.id.onboarding_buttons_loading_switcher);
                    if (viewSwitcher != null) {
                        i2 = R.id.onboarding_exposure_notifications_detail;
                        TextView textView2 = (TextView) inflate.findViewById(R.id.onboarding_exposure_notifications_detail);
                        if (textView2 != null) {
                            i2 = R.id.onboarding_next_button;
                            Button button = (Button) inflate.findViewById(R.id.onboarding_next_button);
                            if (button != null) {
                                i2 = R.id.onboarding_no_thanks_button;
                                Button button2 = (Button) inflate.findViewById(R.id.onboarding_no_thanks_button);
                                if (button2 != null) {
                                    i2 = R.id.onboarding_progress_bar;
                                    ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.onboarding_progress_bar);
                                    if (progressBar != null) {
                                        i2 = R.id.onboarding_scroll;
                                        NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.onboarding_scroll);
                                        if (nestedScrollView != null) {
                                            LinearLayout linearLayout2 = (LinearLayout) inflate;
                                            this.g0 = new r(linearLayout2, textView, switchMaterial, linearLayout, viewSwitcher, textView2, button, button2, progressBar, nestedScrollView);
                                            return linearLayout2;
                                        }
                                    }
                                }
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
        this.g0 = null;
    }

    @Override // f.b.a.a.a.w.z0, f.b.a.a.a.e0.d0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        r rVar = this.g0;
        this.i0 = rVar.f2418d;
        this.j0 = rVar.f2421g;
        this.k0 = rVar.f2424j;
        String E = E(R.string.learn_more);
        String E2 = E(R.string.app_analytics_link);
        a aVar = b.a;
        f.b.a.a.a.m0.a aVar2 = new f.b.a.a.a.m0.a(E2);
        String F = F(R.string.onboarding_metrics_description, E);
        SpannableString spannableString = new SpannableString(F);
        int indexOf = F.indexOf(E);
        spannableString.setSpan(aVar2, indexOf, E.length() + indexOf, 33);
        this.g0.b.setText(spannableString);
        this.g0.b.setMovementMethod(LinkMovementMethod.getInstance());
        this.g0.f2420f.setText(E(R.string.onboarding_exposure_notifications_detail));
        NestedScrollView nestedScrollView = this.k0;
        LinearLayout linearLayout = this.i0;
        Button button = this.j0;
        K0(nestedScrollView, linearLayout, button, false);
        nestedScrollView.setOnScrollChangeListener(new c(this, nestedScrollView, linearLayout, button));
        nestedScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new e(this, nestedScrollView, linearLayout, button));
        this.W.f341f.f(G(), new p(this));
        this.W.f347l.f(G(), new m(this));
        this.W.m.f(G(), new q(this));
        this.W.c.f(G(), new s(this));
        this.g0.f2422h.setOnClickListener(new o(this));
        this.W.f339d.f(G(), new r(this));
        OnboardingViewModel onboardingViewModel = this.a0;
        m.e.R0(m.e.U(onboardingViewModel.f417d.f2315g), new c0(onboardingViewModel)).f(G(), new t(this));
    }
}
