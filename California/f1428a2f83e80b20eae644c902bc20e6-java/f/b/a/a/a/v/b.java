package f.b.a.a.a.v;

import android.widget.CompoundButton;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsActivity;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;

public final /* synthetic */ class b implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ AppAnalyticsViewModel a;

    public /* synthetic */ b(AppAnalyticsViewModel appAnalyticsViewModel) {
        this.a = appAnalyticsViewModel;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AppAnalyticsViewModel appAnalyticsViewModel = this.a;
        int i2 = AppAnalyticsActivity.r;
        appAnalyticsViewModel.c.f(z);
    }
}
