package com.google.android.apps.exposurenotification.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.p.b0;
import f.b.a.a.a.h.h;
import f.b.a.a.a.v.c;
import f.b.a.a.a.v.d;
import f.b.a.a.a.v.e;
import f.b.a.a.a.v.l0;
import f.b.a.a.a.w.n0;
import gov.ca.covid19.exposurenotifications.R;
import java.util.Objects;

public class AppAnalyticsActivity extends l0 {
    public static final /* synthetic */ int r = 0;

    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.v.l0, e.m.a.o, e.i.a.f
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_app_analytics);
        AppAnalyticsViewModel appAnalyticsViewModel = (AppAnalyticsViewModel) new b0(this).a(AppAnalyticsViewModel.class);
        View findViewById = findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.navigate_up));
        findViewById.setOnClickListener(new d(this));
        n0 n0Var = appAnalyticsViewModel.c;
        Objects.requireNonNull(n0Var);
        new h(n0Var.a, "ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", false).f(this, new e((SwitchMaterial) findViewById(R.id.app_analytics_switch), appAnalyticsViewModel));
        ((Button) findViewById(R.id.app_analytics_learn_mode)).setOnClickListener(new c(this));
    }
}
