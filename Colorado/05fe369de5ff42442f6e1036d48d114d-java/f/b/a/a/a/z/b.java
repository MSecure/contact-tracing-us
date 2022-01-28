package f.b.a.a.a.z;

import android.widget.CompoundButton;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;

public final /* synthetic */ class b implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ AppAnalyticsViewModel a;

    public /* synthetic */ b(AppAnalyticsViewModel appAnalyticsViewModel) {
        this.a = appAnalyticsViewModel;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AppAnalyticsViewModel appAnalyticsViewModel = this.a;
        int i2 = m0.b0;
        appAnalyticsViewModel.c.p(z);
    }
}
