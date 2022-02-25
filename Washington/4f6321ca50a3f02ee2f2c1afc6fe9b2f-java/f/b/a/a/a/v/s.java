package f.b.a.a.a.v;

import android.widget.CompoundButton;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsActivity;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;

public final /* synthetic */ class s implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ PrivateAnalyticsViewModel a;

    public /* synthetic */ s(PrivateAnalyticsViewModel privateAnalyticsViewModel) {
        this.a = privateAnalyticsViewModel;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        PrivateAnalyticsViewModel privateAnalyticsViewModel = this.a;
        int i2 = PrivateAnalyticsActivity.r;
        privateAnalyticsViewModel.c.a();
        privateAnalyticsViewModel.c.b();
        privateAnalyticsViewModel.c.l(z);
    }
}
