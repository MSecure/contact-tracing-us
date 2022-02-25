package f.b.a.a.a.q;

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
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.p.b0;
import f.b.a.d.m.b;
import f.b.b.a.a;
import f.b.b.a.l;
import gov.wa.doh.exposurenotifications.R;

public class y extends v {
    public ExposureNotificationViewModel Z;
    public OnboardingViewModel a0;
    public LinearLayout b0;
    public Button c0;
    public NestedScrollView d0;
    public boolean e0 = false;
    public boolean f0 = false;
    public l<Boolean> g0 = a.b;

    public final void A0(boolean z) {
        LinearLayout linearLayout;
        float f2;
        if (!this.g0.b() || this.g0.a().booleanValue() != z) {
            this.g0 = l.c(Boolean.valueOf(z));
            if (z) {
                this.c0.setText(R.string.btn_turn_on);
                this.c0.setOnClickListener(new i(this));
                linearLayout = this.b0;
                f2 = 0.0f;
            } else {
                this.c0.setText(R.string.btn_continue);
                this.c0.setOnClickListener(new b(this));
                linearLayout = this.b0;
                f2 = v().getDimension(R.dimen.onboarding_button_elevation);
            }
            linearLayout.setElevation(f2);
            if (this.c0.isAccessibilityFocused()) {
                this.c0.sendAccessibilityEvent(32);
            }
        }
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_onboarding_permission_disabled, viewGroup, false);
    }

    @Override // e.m.a.l
    public void d0(Bundle bundle) {
        bundle.putBoolean("OnboardingPermissionDisabledFragment.SAVED_INSTANCE_STATE_SKIP_DIALOG_SHOWN", this.e0);
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.onboarding_opt_in_title);
        this.Z = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        this.a0 = (OnboardingViewModel) new b0(this).a(OnboardingViewModel.class);
        String z = z(R.string.learn_more);
        URLSpan uRLSpan = new URLSpan(z(R.string.app_analytics_link));
        String A = A(R.string.onboarding_metrics_description, z);
        SpannableString spannableString = new SpannableString(A);
        int indexOf = A.indexOf(z);
        spannableString.setSpan(uRLSpan, indexOf, z.length() + indexOf, 33);
        TextView textView = (TextView) view.findViewById(R.id.app_analytics_detail);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R.id.onboarding_app_analytics_switch);
        ((TextView) view.findViewById(R.id.onboarding_exposure_notifications_detail)).setText(A(R.string.onboarding_exposure_notifications_detail, z(R.string.app_name)));
        this.Z.f333f.f(B(), new l(this, switchMaterial, (ViewSwitcher) view.findViewById(R.id.onboarding_buttons_loading_switcher)));
        this.Z.f335h.f(B(), new a(this));
        this.b0 = (LinearLayout) view.findViewById(R.id.onboarding_buttons);
        this.c0 = (Button) view.findViewById(R.id.onboarding_next_button);
        this.d0 = (NestedScrollView) view.findViewById(R.id.onboarding_scroll);
        A0(false);
        this.d0.setOnScrollChangeListener(new d(this));
        this.d0.getViewTreeObserver().addOnGlobalLayoutListener(new f(this));
        Button button = (Button) view.findViewById(R.id.onboarding_no_thanks_button);
        button.setOnClickListener(new h(this));
        if (bundle != null && bundle.getBoolean("OnboardingPermissionDisabledFragment.SAVED_INSTANCE_STATE_SKIP_DIALOG_SHOWN", false)) {
            z0();
        }
        this.Z.f331d.f(B(), new c(this, button, (ProgressBar) view.findViewById(R.id.onboarding_progress_bar)));
        this.a0.d().f(B(), new g(this));
    }

    public final void z0() {
        if (!this.e0) {
            this.e0 = true;
            b bVar = new b(this.W);
            bVar.f(R.string.onboarding_confirm_later_title);
            bVar.c(R.string.onboarding_confirm_later_detail);
            bVar.a.f26k = true;
            bVar.d(R.string.btn_no_go_back, new e(this));
            bVar.e(R.string.btn_yes_continue, new j(this));
            bVar.a.f27l = new k(this);
            bVar.b();
        }
    }
}
