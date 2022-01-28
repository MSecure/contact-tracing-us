package f.b.a.a.a.z;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.m.a.e0;
import f.b.a.a.a.j.n;
import f.b.a.a.a.k.j;
import f.b.a.a.a.k.l;
import f.b.a.e.l.b;
import gov.co.cdphe.exposurenotifications.R;

public class p0 extends t0 {
    public n a0;
    public ExposureNotificationViewModel.b b0;
    public boolean c0 = false;
    public boolean d0 = false;
    public final CompoundButton.OnCheckedChangeListener e0 = new a();

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            compoundButton.setOnCheckedChangeListener(null);
            compoundButton.setChecked(!z);
            compoundButton.setOnCheckedChangeListener(p0.this.e0);
            p0 p0Var = p0.this;
            if (!z) {
                p0Var.D0();
            } else if (p0Var.b0 == ExposureNotificationViewModel.b.STORAGE_LOW) {
                p0Var.C0();
            } else {
                p0Var.W.f();
            }
        }
    }

    public final void C0() {
        this.d0 = true;
        b bVar = new b(p0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.onboarding_free_up_storage_title);
        bVar.c(R.string.storage_low_warning);
        bVar.a.f37k = true;
        bVar.d(R.string.btn_cancel, new o(this));
        bVar.e(R.string.manage_storage, new r(this));
        bVar.a.f38l = new m(this);
        bVar.b();
    }

    public final void D0() {
        this.c0 = true;
        b bVar = new b(p0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.exposure_turn_off_title);
        bVar.c(R.string.exposure_turn_off_detail);
        bVar.a.f37k = true;
        bVar.d(R.string.btn_cancel, new p(this));
        bVar.e(R.string.btn_turn_off, new q(this));
        bVar.a.f38l = new g(this);
        bVar.b();
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = q().inflate(R.layout.fragment_exposure_about, (ViewGroup) null, false);
        int i2 = R.id.edge_case_fragment;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.edge_case_fragment);
        if (frameLayout != null) {
            i2 = R.id.exposure_about_detail;
            TextView textView = (TextView) inflate.findViewById(R.id.exposure_about_detail);
            if (textView != null) {
                i2 = R.id.exposure_about_detail_layout;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.exposure_about_detail_layout);
                if (linearLayout != null) {
                    i2 = R.id.exposure_about_settings_button;
                    Button button = (Button) inflate.findViewById(R.id.exposure_about_settings_button);
                    if (button != null) {
                        i2 = R.id.exposure_notification_toggle;
                        SwitchMaterial switchMaterial = (SwitchMaterial) inflate.findViewById(R.id.exposure_notification_toggle);
                        if (switchMaterial != null) {
                            i2 = 16908332;
                            ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                            if (imageButton != null) {
                                FrameLayout frameLayout2 = (FrameLayout) inflate;
                                this.a0 = new n(frameLayout2, frameLayout, textView, linearLayout, button, switchMaterial, imageButton);
                                return frameLayout2;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.m
    public void Q() {
        this.D = true;
        this.a0 = null;
    }

    @Override // e.m.a.m
    public void d0(Bundle bundle) {
        bundle.putBoolean("STATE_TURN_OFF_OPEN", this.c0);
        bundle.putBoolean("STATE_MANAGE_STORAGE_OPEN", this.d0);
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        if (bundle != null) {
            this.c0 = bundle.getBoolean("STATE_TURN_OFF_OPEN", false);
            this.d0 = bundle.getBoolean("STATE_MANAGE_STORAGE_OPEN", false);
        }
        if (this.c0) {
            D0();
        }
        if (this.d0) {
            C0();
        }
        this.W.c.f(C(), new i(this));
        this.W.f336f.f(C(), new f(this));
        this.W.f342l.f(this, new n(this));
        this.W.m.f(this, new l(this));
        this.a0.b.setText(B(R.string.exposure_about_detail, A(R.string.exposure_about_agency)));
        this.a0.f2210f.setContentDescription(A(R.string.navigate_up));
        this.a0.f2210f.setOnClickListener(new h(this));
        this.a0.f2208d.setOnClickListener(new j(this));
        e0 h2 = h();
        if (h2.H(R.id.edge_case_fragment) == null) {
            j jVar = new j();
            l.G0(jVar, false, false);
            e.m.a.a aVar = new e.m.a.a(h2);
            aVar.f(R.id.edge_case_fragment, jVar, null);
            aVar.d();
        }
    }
}
