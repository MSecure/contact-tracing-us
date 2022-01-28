package f.b.a.a.a.j0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.q.f0;
import f.b.a.a.a.t.j;
import gov.ut.covid19.exposurenotifications.R;

public class m0 extends r0 {
    public static final /* synthetic */ int c0 = 0;
    public j b0;

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = s().inflate(R.layout.fragment_app_analytics, (ViewGroup) null, false);
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
                    this.b0 = new j(frameLayout, button, switchMaterial, imageButton);
                    return frameLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.app_analytics_title);
        AppAnalyticsViewModel appAnalyticsViewModel = (AppAnalyticsViewModel) new f0(this).a(AppAnalyticsViewModel.class);
        this.b0.f2382d.setContentDescription(E(R.string.navigate_up));
        this.b0.f2382d.setOnClickListener(new d(this));
        appAnalyticsViewModel.c.f2312d.f(G(), new e(this, appAnalyticsViewModel));
        this.b0.b.setOnClickListener(new c(this));
    }
}
