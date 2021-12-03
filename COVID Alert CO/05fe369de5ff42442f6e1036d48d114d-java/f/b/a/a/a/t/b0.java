package f.b.a.a.a.t;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.p.f0;
import f.b.a.a.a.m.z0;
import f.b.a.e.l.b;
import f.b.b.a.a;
import f.b.b.a.l;
import gov.co.cdphe.exposurenotifications.R;

public abstract class b0 extends z0 {
    public static final /* synthetic */ int b0 = 0;
    public boolean X = false;
    public boolean Y = false;
    public l<Boolean> Z = a.b;
    public OnboardingViewModel a0;

    public abstract void B0();

    public void C0() {
        if (!this.Y) {
            this.Y = true;
            b bVar = new b(p0(), R.style.ExposureNotificationAlertDialogTheme);
            bVar.f(R.string.onboarding_free_up_storage_title);
            bVar.c(R.string.storage_low_warning);
            bVar.a.f37k = true;
            bVar.d(R.string.btn_cancel, new h(this));
            bVar.e(R.string.manage_storage, new g(this));
            bVar.a.f38l = new f(this);
            bVar.b();
        }
    }

    public void D0() {
        if (!this.X) {
            this.X = true;
            b bVar = new b(p0(), R.style.ExposureNotificationAlertDialogTheme);
            bVar.f(R.string.onboarding_confirm_later_title);
            bVar.c(R.string.onboarding_confirm_later_detail);
            bVar.a.f37k = true;
            bVar.d(R.string.btn_no_go_back, new j(this));
            bVar.e(R.string.btn_yes_continue, new d(this));
            bVar.a.f38l = new b(this);
            bVar.b();
        }
    }

    public abstract void E0();

    public void F0(NestedScrollView nestedScrollView, LinearLayout linearLayout, Button button, boolean z) {
        float f2;
        if (!this.Z.b() || this.Z.a().booleanValue() != z) {
            this.Z = l.c(Boolean.valueOf(z));
            if (z) {
                button.setText(R.string.btn_turn_on);
                button.setOnClickListener(new a(this));
                f2 = 0.0f;
            } else {
                button.setText(R.string.btn_continue);
                button.setOnClickListener(new i(nestedScrollView));
                f2 = w().getDimension(R.dimen.bottom_button_container_elevation);
            }
            linearLayout.setElevation(f2);
            if (button.isAccessibilityFocused()) {
                button.sendAccessibilityEvent(32);
            }
        }
    }

    @Override // e.m.a.m
    public void d0(Bundle bundle) {
        bundle.putBoolean("OnboardingFragment.SAVED_INSTANCE_STATE_SKIP_DIALOG_SHOWN", this.X);
        bundle.putBoolean("OnboardingFragment.SAVED_INSTANCE_STATE_MANAGE_STORAGE_DIALOG_SHOWN", this.Y);
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.onboarding_opt_in_title);
        this.a0 = (OnboardingViewModel) new f0(o0()).a(OnboardingViewModel.class);
        if (bundle != null) {
            if (bundle.getBoolean("OnboardingFragment.SAVED_INSTANCE_STATE_SKIP_DIALOG_SHOWN", false)) {
                D0();
            }
            if (bundle.getBoolean("OnboardingFragment.SAVED_INSTANCE_STATE_MANAGE_STORAGE_DIALOG_SHOWN", false)) {
                C0();
            }
        }
    }
}
