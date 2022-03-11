package f.b.a.a.a.s;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.b.a.m;
import e.p.b0;
import f.b.a.a.a.i.o;
import f.b.a.d.m.b;
import f.b.b.a.a;
import f.b.b.a.l;
import gov.md.covid19.exposurenotifications.R;

public class y extends v {
    public o a0;
    public ExposureNotificationViewModel b0;
    public OnboardingViewModel c0;
    public LinearLayout d0;
    public Button e0;
    public NestedScrollView f0;
    public boolean g0 = false;
    public boolean h0 = false;
    public l<Boolean> i0 = a.b;

    public final void A0(boolean z) {
        LinearLayout linearLayout;
        float f2;
        if (!this.i0.b() || this.i0.a().booleanValue() != z) {
            this.i0 = l.c(Boolean.valueOf(z));
            if (z) {
                this.e0.setText(R.string.btn_turn_on);
                this.e0.setOnClickListener(new i(this));
                linearLayout = this.d0;
                f2 = 0.0f;
            } else {
                this.e0.setText(R.string.btn_continue);
                this.e0.setOnClickListener(new b(this));
                linearLayout = this.d0;
                f2 = v().getDimension(R.dimen.onboarding_button_elevation);
            }
            linearLayout.setElevation(f2);
            if (this.e0.isAccessibilityFocused()) {
                this.e0.sendAccessibilityEvent(32);
            }
        }
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                                            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                                            this.a0 = new o(constraintLayout, textView, switchMaterial, linearLayout, viewSwitcher, textView2, button, button2, progressBar, nestedScrollView);
                                            return constraintLayout;
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

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        this.a0 = null;
    }

    @Override // e.m.a.l
    public void d0(Bundle bundle) {
        bundle.putBoolean("OnboardingPermissionDisabledFragment.SAVED_INSTANCE_STATE_SKIP_DIALOG_SHOWN", this.g0);
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.onboarding_opt_in_title);
        this.b0 = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        this.c0 = (OnboardingViewModel) new b0(this).a(OnboardingViewModel.class);
        String z = z(R.string.learn_more);
        URLSpan uRLSpan = new URLSpan(z(R.string.app_analytics_link));
        String A = A(R.string.onboarding_metrics_description, z);
        SpannableString spannableString = new SpannableString(A);
        int indexOf = A.indexOf(z);
        spannableString.setSpan(uRLSpan, indexOf, z.length() + indexOf, 33);
        this.a0.b.setText(spannableString);
        this.a0.b.setMovementMethod(LinkMovementMethod.getInstance());
        this.a0.f2120f.setText(A(R.string.onboarding_exposure_notifications_detail, z(R.string.app_name)));
        this.b0.f343g.f(B(), new d(this));
        this.b0.f345i.f(B(), new a(this));
        o oVar = this.a0;
        this.d0 = oVar.f2118d;
        this.e0 = oVar.f2121g;
        this.f0 = oVar.f2124j;
        A0(false);
        this.f0.setOnScrollChangeListener(new c(this));
        this.f0.getViewTreeObserver().addOnGlobalLayoutListener(new f(this));
        this.a0.f2122h.setOnClickListener(new h(this));
        if (bundle != null && bundle.getBoolean("OnboardingPermissionDisabledFragment.SAVED_INSTANCE_STATE_SKIP_DIALOG_SHOWN", false)) {
            z0();
        }
        this.b0.f341e.f(B(), new j(this));
        m.h.A0(m.h.R(this.c0.c.f2359f), u.a).f(B(), new g(this));
    }

    public final void z0() {
        if (!this.g0) {
            this.g0 = true;
            b bVar = new b(this.X);
            bVar.f(R.string.onboarding_confirm_later_title);
            bVar.c(R.string.onboarding_confirm_later_detail);
            bVar.a.f34k = true;
            bVar.d(R.string.btn_no_go_back, new e(this));
            bVar.e(R.string.btn_yes_continue, new k(this));
            bVar.a.f35l = new l(this);
            bVar.b();
        }
    }
}
