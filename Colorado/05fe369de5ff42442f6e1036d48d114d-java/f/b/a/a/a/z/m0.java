package f.b.a.a.a.z;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.p.f0;
import f.b.a.a.a.j.j;
import gov.co.cdphe.exposurenotifications.R;

public class m0 extends s0 {
    public static final /* synthetic */ int b0 = 0;
    public j a0;

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = q().inflate(R.layout.fragment_app_analytics, (ViewGroup) null, false);
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
                    this.a0 = new j(frameLayout, button, switchMaterial, imageButton);
                    return frameLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.app_analytics_title);
        AppAnalyticsViewModel appAnalyticsViewModel = (AppAnalyticsViewModel) new f0(this).a(AppAnalyticsViewModel.class);
        this.a0.f2187d.setContentDescription(A(R.string.navigate_up));
        this.a0.f2187d.setOnClickListener(new d(this));
        appAnalyticsViewModel.c.f2115d.f(C(), new e(this, appAnalyticsViewModel));
        this.a0.b.setOnClickListener(new c(this));
    }
}
