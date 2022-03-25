package com.google.android.apps.exposurenotification.settings;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.p.b0;
import f.b.a.a.a.i.b;
import f.b.a.a.a.x.c;
import f.b.a.a.a.x.d;
import f.b.a.a.a.x.e;
import f.b.a.a.a.x.j0;
import gov.md.covid19.exposurenotifications.R;

public class AppAnalyticsActivity extends j0 {
    public static final /* synthetic */ int t = 0;
    public b s;

    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.x.j0, e.m.a.r, e.i.a.h
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.activity_app_analytics, (ViewGroup) null, false);
        int i2 = R.id.app_analytics_learn_mode;
        Button button = (Button) inflate.findViewById(R.id.app_analytics_learn_mode);
        if (button != null) {
            i2 = R.id.app_analytics_switch;
            SwitchMaterial switchMaterial = (SwitchMaterial) inflate.findViewById(R.id.app_analytics_switch);
            if (switchMaterial != null) {
                i2 = 16908332;
                ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                if (imageButton != null) {
                    FrameLayout frameLayout = (FrameLayout) inflate;
                    this.s = new b(frameLayout, button, switchMaterial, imageButton);
                    setContentView(frameLayout);
                    AppAnalyticsViewModel appAnalyticsViewModel = (AppAnalyticsViewModel) new b0(this).a(AppAnalyticsViewModel.class);
                    this.s.f2097d.setContentDescription(getString(R.string.navigate_up));
                    this.s.f2097d.setOnClickListener(new d(this));
                    appAnalyticsViewModel.c.c.f(this, new e(this, appAnalyticsViewModel));
                    this.s.b.setOnClickListener(new c(this));
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
