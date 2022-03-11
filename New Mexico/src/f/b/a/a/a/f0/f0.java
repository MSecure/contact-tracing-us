package f.b.a.a.a.f0;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.b.a.m;
import f.b.a.a.a.x.a1;
import f.b.a.e.m.b;
import f.b.b.a.a;
import f.b.b.a.l;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public abstract class f0 extends a1 {
    public static final /* synthetic */ int b0;
    public boolean X = false;
    public boolean Y = false;
    public l<Boolean> Z = a.b;
    public OnboardingViewModel a0;

    public abstract void J0();

    public void K0() {
        if (!this.Y) {
            this.Y = true;
            b bVar = new b(v0(), R.style.ExposureNotificationAlertDialogTheme);
            bVar.f(R.string.onboarding_free_up_storage_title);
            bVar.c(R.string.storage_low_warning);
            bVar.a.f38k = true;
            bVar.d(R.string.btn_cancel, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.f0.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    f0.this.Y = false;
                    dialogInterface.cancel();
                }
            });
            bVar.e(R.string.manage_storage, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.f0.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    f0 f0Var = f0.this;
                    f0Var.Y = false;
                    m.e.U0(f0Var.k());
                }
            });
            bVar.a.f39l = new DialogInterface.OnCancelListener() { // from class: f.b.a.a.a.f0.f
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    f0.this.Y = false;
                }
            };
            bVar.b();
        }
    }

    public void L0() {
        if (!this.X) {
            this.X = true;
            b bVar = new b(v0(), R.style.ExposureNotificationAlertDialogTheme);
            bVar.f(R.string.onboarding_confirm_later_title);
            bVar.c(R.string.onboarding_confirm_later_detail);
            bVar.a.f38k = true;
            bVar.d(R.string.btn_no_go_back, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.f0.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    f0.this.X = false;
                    dialogInterface.cancel();
                }
            });
            bVar.e(R.string.btn_yes_continue, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.f0.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    f0 f0Var = f0.this;
                    f0Var.X = false;
                    f0Var.M0();
                }
            });
            bVar.a.f39l = new DialogInterface.OnCancelListener() { // from class: f.b.a.a.a.f0.b
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    f0.this.X = false;
                }
            };
            bVar.b();
        }
    }

    public abstract void M0();

    public void N0(NestedScrollView nestedScrollView, LinearLayout linearLayout, Button button, boolean z) {
        float f2;
        if (!this.Z.b() || this.Z.a().booleanValue() != z) {
            this.Z = l.c(Boolean.valueOf(z));
            if (z) {
                button.setText(R.string.btn_turn_on);
                button.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.f0.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        f0.this.J0();
                    }
                });
                f2 = 0.0f;
            } else {
                button.setText(R.string.btn_continue);
                button.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.f0.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NestedScrollView nestedScrollView2 = NestedScrollView.this;
                        int i2 = f0.b0;
                        nestedScrollView2.q(130);
                    }
                });
                f2 = B().getDimension(R.dimen.bottom_button_container_elevation);
            }
            linearLayout.setElevation(f2);
            if (button.isAccessibilityFocused()) {
                button.sendAccessibilityEvent(32);
            }
        }
    }

    @Override // e.o.a.m
    public void j0(Bundle bundle) {
        bundle.putBoolean("OnboardingFragment.SAVED_INSTANCE_STATE_SKIP_DIALOG_SHOWN", this.X);
        bundle.putBoolean("OnboardingFragment.SAVED_INSTANCE_STATE_MANAGE_STORAGE_DIALOG_SHOWN", this.Y);
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.onboarding_opt_in_title);
        this.a0 = (OnboardingViewModel) new e.r.f0(u0()).a(OnboardingViewModel.class);
        if (bundle != null) {
            if (bundle.getBoolean("OnboardingFragment.SAVED_INSTANCE_STATE_SKIP_DIALOG_SHOWN", false)) {
                L0();
            }
            if (bundle.getBoolean("OnboardingFragment.SAVED_INSTANCE_STATE_MANAGE_STORAGE_DIALOG_SHOWN", false)) {
                K0();
            }
        }
    }
}
