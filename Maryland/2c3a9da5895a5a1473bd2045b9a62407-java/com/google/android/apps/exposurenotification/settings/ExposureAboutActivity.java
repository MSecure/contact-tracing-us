package com.google.android.apps.exposurenotification.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
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
import e.m.a.f0;
import e.p.b0;
import f.b.a.a.a.i.c;
import f.b.a.a.a.x.f;
import f.b.a.a.a.x.g;
import f.b.a.a.a.x.h;
import f.b.a.a.a.x.i;
import f.b.a.a.a.x.j;
import f.b.a.a.a.x.k;
import f.b.a.a.a.x.k0;
import f.b.a.a.a.x.l;
import f.b.a.a.a.x.m;
import gov.md.covid19.exposurenotifications.R;

public class ExposureAboutActivity extends k0 {
    public c s;
    public ExposureNotificationViewModel t;
    public boolean u = false;
    public final BroadcastReceiver v = new a();
    public final CompoundButton.OnCheckedChangeListener w = new b();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            ExposureAboutActivity.this.t.d();
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            compoundButton.setOnCheckedChangeListener(null);
            compoundButton.setChecked(!z);
            compoundButton.setOnCheckedChangeListener(ExposureAboutActivity.this.w);
            ExposureAboutActivity exposureAboutActivity = ExposureAboutActivity.this;
            if (z) {
                exposureAboutActivity.t.f();
            } else {
                exposureAboutActivity.x();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.x.k0, e.m.a.r, e.i.a.h
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.activity_exposure_about, (ViewGroup) null, false);
        int i2 = R.id.edge_case_fragment;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.edge_case_fragment);
        if (frameLayout != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.exposure_about_detail);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.exposure_about_detail_layout);
                if (linearLayout != null) {
                    Button button = (Button) inflate.findViewById(R.id.exposure_about_settings_button);
                    if (button != null) {
                        SwitchMaterial switchMaterial = (SwitchMaterial) inflate.findViewById(R.id.exposure_notification_toggle);
                        if (switchMaterial != null) {
                            ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                            if (imageButton != null) {
                                FrameLayout frameLayout2 = (FrameLayout) inflate;
                                this.s = new c(frameLayout2, frameLayout, textView, linearLayout, button, switchMaterial, imageButton);
                                setContentView(frameLayout2);
                                this.t = (ExposureNotificationViewModel) new b0(this).a(ExposureNotificationViewModel.class);
                                if (bundle != null) {
                                    this.u = bundle.getBoolean("STATE_TURN_OFF_OPEN", false);
                                }
                                if (this.u) {
                                    x();
                                }
                                this.t.f340d.f(this, new j(this));
                                this.t.f343g.f(this, new h(this));
                                this.t.f345i.f(this, new k(this));
                                this.t.e(this);
                                this.s.b.setText(getString(R.string.exposure_about_detail, new Object[]{getString(R.string.exposure_about_agency)}));
                                this.s.f2100f.setContentDescription(getString(R.string.navigate_up));
                                this.s.f2100f.setOnClickListener(new m(this));
                                this.s.f2098d.setOnClickListener(new l(this));
                                IntentFilter intentFilter = new IntentFilter();
                                intentFilter.addAction("android.location.PROVIDERS_CHANGED");
                                intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                                registerReceiver(this.v, intentFilter);
                                f0 o = o();
                                if (o.I(R.id.edge_case_fragment) == null) {
                                    f.b.a.a.a.j.h hVar = new f.b.a.a.a.j.h();
                                    f.b.a.a.a.j.j.C0(hVar, false, false);
                                    e.m.a.a aVar = new e.m.a.a(o);
                                    aVar.f(R.id.edge_case_fragment, hVar, null);
                                    aVar.c();
                                    return;
                                }
                                return;
                            }
                            i2 = 16908332;
                        } else {
                            i2 = R.id.exposure_notification_toggle;
                        }
                    } else {
                        i2 = R.id.exposure_about_settings_button;
                    }
                } else {
                    i2 = R.id.exposure_about_detail_layout;
                }
            } else {
                i2 = R.id.exposure_about_detail;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.b.a.j, e.m.a.r
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.v);
    }

    @Override // e.m.a.r
    public void onResume() {
        super.onResume();
        this.t.d();
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.h
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("STATE_TURN_OFF_OPEN", this.u);
    }

    public final void x() {
        this.u = true;
        f.b.a.d.m.b bVar = new f.b.a.d.m.b(this);
        bVar.f(R.string.exposure_turn_off_title);
        bVar.c(R.string.exposure_turn_off_detail);
        bVar.a.f34k = true;
        bVar.d(R.string.btn_cancel, new g(this));
        bVar.e(R.string.btn_turn_off, new f(this));
        bVar.a.f35l = new i(this);
        bVar.b();
    }
}
