package f.b.a.a.a.t;

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
import f.b.a.a.a.c0.b;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.j.r;
import f.b.a.a.a.m.f1;
import gov.co.cdphe.exposurenotifications.R;

public class g0 extends d0 {
    public r f0;
    public ExposureNotificationViewModel.b g0;
    public LinearLayout h0;
    public Button i0;
    public NestedScrollView j0;
    public boolean k0 = false;

    @Override // f.b.a.a.a.t.b0
    public void B0() {
        this.a0.c.a.edit().putBoolean("ExposureNotificationSharedPreferences.IS_IN_APP_SMS_NOTICE_SEEN", true).apply();
        if (ExposureNotificationViewModel.b.STORAGE_LOW.equals(this.g0)) {
            C0();
        } else {
            this.W.f();
        }
    }

    @Override // f.b.a.a.a.t.b0
    public void E0() {
        this.a0.c(false);
        f1.C0(this);
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                                            this.f0 = new r(linearLayout2, textView, switchMaterial, linearLayout, viewSwitcher, textView2, button, button2, progressBar, nestedScrollView);
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

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.f0 = null;
    }

    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.t.b0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        r rVar = this.f0;
        this.h0 = rVar.f2223d;
        this.i0 = rVar.f2226g;
        this.j0 = rVar.f2229j;
        String A = A(R.string.learn_more);
        String A2 = A(R.string.app_analytics_link);
        a aVar = b.a;
        f.b.a.a.a.c0.a aVar2 = new f.b.a.a.a.c0.a(A2);
        String B = B(R.string.onboarding_metrics_description, A);
        SpannableString spannableString = new SpannableString(B);
        int indexOf = B.indexOf(A);
        spannableString.setSpan(aVar2, indexOf, A.length() + indexOf, 33);
        this.f0.b.setText(spannableString);
        this.f0.b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f0.f2225f.setText(A(R.string.onboarding_exposure_notifications_detail));
        NestedScrollView nestedScrollView = this.j0;
        LinearLayout linearLayout = this.h0;
        Button button = this.i0;
        F0(nestedScrollView, linearLayout, button, false);
        nestedScrollView.setOnScrollChangeListener(new c(this, nestedScrollView, linearLayout, button));
        nestedScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new e(this, nestedScrollView, linearLayout, button));
        this.W.f336f.f(C(), new p(this));
        this.W.f342l.f(C(), new m(this));
        this.W.m.f(C(), new q(this));
        this.W.c.f(C(), new s(this));
        this.f0.f2227h.setOnClickListener(new o(this));
        this.W.f334d.f(C(), new r(this));
        OnboardingViewModel onboardingViewModel = this.a0;
        m.h.G0(m.h.S(onboardingViewModel.c.f2118g), new a0(onboardingViewModel)).f(C(), new t(this));
    }
}
