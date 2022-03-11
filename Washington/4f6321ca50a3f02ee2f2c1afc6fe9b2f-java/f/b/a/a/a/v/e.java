package f.b.a.a.a.v;

import com.google.android.apps.exposurenotification.settings.AppAnalyticsActivity;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.p.r;

public final /* synthetic */ class e implements r {
    public final /* synthetic */ SwitchMaterial a;
    public final /* synthetic */ AppAnalyticsViewModel b;

    public /* synthetic */ e(SwitchMaterial switchMaterial, AppAnalyticsViewModel appAnalyticsViewModel) {
        this.a = switchMaterial;
        this.b = appAnalyticsViewModel;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        SwitchMaterial switchMaterial = this.a;
        AppAnalyticsViewModel appAnalyticsViewModel = this.b;
        int i2 = AppAnalyticsActivity.r;
        switchMaterial.setOnCheckedChangeListener(null);
        switchMaterial.setChecked(((Boolean) obj).booleanValue());
        switchMaterial.setOnCheckedChangeListener(new b(appAnalyticsViewModel));
    }
}
