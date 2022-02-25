package f.b.a.a.a.v;

import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsActivity;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.p.r;

public final /* synthetic */ class q implements r {
    public final /* synthetic */ SwitchMaterial a;
    public final /* synthetic */ PrivateAnalyticsViewModel b;

    public /* synthetic */ q(SwitchMaterial switchMaterial, PrivateAnalyticsViewModel privateAnalyticsViewModel) {
        this.a = switchMaterial;
        this.b = privateAnalyticsViewModel;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        SwitchMaterial switchMaterial = this.a;
        PrivateAnalyticsViewModel privateAnalyticsViewModel = this.b;
        int i2 = PrivateAnalyticsActivity.r;
        switchMaterial.setOnCheckedChangeListener(null);
        switchMaterial.setChecked(((Boolean) obj).booleanValue());
        switchMaterial.setOnCheckedChangeListener(new s(privateAnalyticsViewModel));
    }
}
