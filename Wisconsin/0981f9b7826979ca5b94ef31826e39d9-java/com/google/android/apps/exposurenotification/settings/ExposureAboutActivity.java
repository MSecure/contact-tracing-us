package com.google.android.apps.exposurenotification.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.b0;
import f.b.a.a.a.v.f;
import f.b.a.a.a.v.g;
import f.b.a.a.a.v.h;
import f.b.a.a.a.v.i;
import f.b.a.a.a.v.j;
import f.b.a.a.a.v.k;
import f.b.a.a.a.v.l;
import f.b.a.a.a.v.m;
import f.b.a.a.a.v.m0;
import f.b.a.a.a.v.n;
import f.b.a.a.a.v.o;
import gov.wi.covid19.exposurenotifications.R;

public class ExposureAboutActivity extends m0 {
    public static final /* synthetic */ int v = 0;
    public ExposureNotificationViewModel r;
    public boolean s = false;
    public final BroadcastReceiver t = new a();
    public final CompoundButton.OnCheckedChangeListener u = new b();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            ExposureAboutActivity.this.r.d();
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            compoundButton.setOnCheckedChangeListener(null);
            compoundButton.setChecked(!z);
            compoundButton.setOnCheckedChangeListener(ExposureAboutActivity.this.u);
            ExposureAboutActivity exposureAboutActivity = ExposureAboutActivity.this;
            if (z) {
                exposureAboutActivity.r.e();
            } else {
                exposureAboutActivity.w();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, e.m.a.o
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1111) {
            if (i3 == -1) {
                this.r.g();
            } else {
                this.r.f();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.v.m0, e.m.a.o, e.i.a.f
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_exposure_about);
        this.r = (ExposureNotificationViewModel) new b0(this).a(ExposureNotificationViewModel.class);
        if (bundle != null) {
            this.s = bundle.getBoolean("STATE_TURN_OFF_OPEN", false);
        }
        if (this.s) {
            w();
        }
        this.r.c.f(this, new l(this));
        this.r.f335h.f(this, new h(this));
        this.r.f336i.f(this, new m(this));
        ((TextView) findViewById(R.id.exposure_about_detail)).setText(getString(R.string.exposure_about_detail, new Object[]{getString(R.string.exposure_about_agency)}));
        View findViewById = findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.navigate_up));
        findViewById.setOnClickListener(new k(this));
        ((Button) findViewById(R.id.exposure_about_settings_button)).setOnClickListener(new n(this));
        ((Button) findViewById(R.id.exposure_about_device_settings)).setOnClickListener(new j(this));
        ((Button) findViewById(R.id.exposure_about_manage_storage)).setOnClickListener(new o(this));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.location.PROVIDERS_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        registerReceiver(this.t, intentFilter);
    }

    @Override // e.b.a.j, e.m.a.o
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.t);
    }

    @Override // e.m.a.o
    public void onResume() {
        super.onResume();
        this.r.d();
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.f
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("STATE_TURN_OFF_OPEN", this.s);
    }

    public final void w() {
        this.s = true;
        f.b.a.d.m.b bVar = new f.b.a.d.m.b(this);
        bVar.f(R.string.exposure_turn_off_title);
        bVar.c(R.string.exposure_turn_off_detail);
        bVar.a.f26k = true;
        bVar.d(R.string.btn_cancel, new f(this));
        bVar.e(R.string.btn_turn_off, new i(this));
        bVar.a.f27l = new g(this);
        bVar.b();
    }
}
