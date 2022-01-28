package f.b.a.a.a.j0;

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
import e.n.a.e0;
import f.b.a.a.a.t.n;
import f.b.a.a.a.u.j;
import f.b.a.a.a.u.l;
import f.b.a.e.m.b;
import gov.ut.covid19.exposurenotifications.R;

public class o0 extends s0 {
    public n b0;
    public ExposureNotificationViewModel.b c0;
    public boolean d0 = false;
    public boolean e0 = false;
    public final CompoundButton.OnCheckedChangeListener f0 = new a();

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            compoundButton.setOnCheckedChangeListener(null);
            compoundButton.setChecked(!z);
            compoundButton.setOnCheckedChangeListener(o0.this.f0);
            o0 o0Var = o0.this;
            if (!z) {
                o0Var.J0();
            } else if (o0Var.c0 == ExposureNotificationViewModel.b.STORAGE_LOW) {
                o0Var.I0();
            } else {
                o0Var.W.f();
            }
        }
    }

    public final void I0() {
        this.e0 = true;
        b bVar = new b(t0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.onboarding_free_up_storage_title);
        bVar.c(R.string.storage_low_warning);
        bVar.a.f38k = true;
        bVar.d(R.string.btn_cancel, new o(this));
        bVar.e(R.string.manage_storage, new r(this));
        bVar.a.f39l = new m(this);
        bVar.b();
    }

    public final void J0() {
        this.d0 = true;
        b bVar = new b(t0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.exposure_turn_off_title);
        bVar.c(R.string.exposure_turn_off_detail);
        bVar.a.f38k = true;
        bVar.d(R.string.btn_cancel, new p(this));
        bVar.e(R.string.btn_turn_off, new q(this));
        bVar.a.f39l = new g(this);
        bVar.b();
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = s().inflate(R.layout.fragment_exposure_about, (ViewGroup) null, false);
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
                                this.b0 = new n(frameLayout2, frameLayout, textView, linearLayout, button, switchMaterial, imageButton);
                                return frameLayout2;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.n.a.m
    public void U() {
        this.D = true;
        this.b0 = null;
    }

    @Override // e.n.a.m
    public void h0(Bundle bundle) {
        bundle.putBoolean("STATE_TURN_OFF_OPEN", this.d0);
        bundle.putBoolean("STATE_MANAGE_STORAGE_OPEN", this.e0);
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        if (bundle != null) {
            this.d0 = bundle.getBoolean("STATE_TURN_OFF_OPEN", false);
            this.e0 = bundle.getBoolean("STATE_MANAGE_STORAGE_OPEN", false);
        }
        if (this.d0) {
            J0();
        }
        if (this.e0) {
            I0();
        }
        this.W.c.f(G(), new i(this));
        this.W.f341f.f(G(), new f(this));
        this.W.f347l.f(this, new n(this));
        this.W.m.f(this, new l(this));
        this.b0.b.setText(F(R.string.exposure_about_detail, E(R.string.exposure_about_agency)));
        this.b0.f2405f.setContentDescription(E(R.string.navigate_up));
        this.b0.f2405f.setOnClickListener(new h(this));
        this.b0.f2403d.setOnClickListener(new j(this));
        e0 h2 = h();
        if (h2.H(R.id.edge_case_fragment) == null) {
            j jVar = new j();
            l.L0(jVar, false, false);
            e.n.a.a aVar = new e.n.a.a(h2);
            aVar.f(R.id.edge_case_fragment, jVar, null);
            aVar.d();
        }
    }
}
