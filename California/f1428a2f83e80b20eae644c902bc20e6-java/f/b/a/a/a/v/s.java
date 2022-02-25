package f.b.a.a.a.v;

import android.widget.CompoundButton;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsActivity;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import e.b0.n;

public final /* synthetic */ class s implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ PrivateAnalyticsViewModel a;

    public /* synthetic */ s(PrivateAnalyticsViewModel privateAnalyticsViewModel) {
        this.a = privateAnalyticsViewModel;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        PrivateAnalyticsViewModel privateAnalyticsViewModel = this.a;
        int i2 = PrivateAnalyticsActivity.r;
        if (z) {
            privateAnalyticsViewModel.f397d.a(new n.a(SubmitPrivateAnalyticsWorker.class).a());
        }
        privateAnalyticsViewModel.c.h(z);
    }
}
