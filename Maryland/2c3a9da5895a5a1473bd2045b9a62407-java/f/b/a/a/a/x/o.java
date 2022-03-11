package f.b.a.a.a.x;

import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsActivity;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import e.p.r;

public final /* synthetic */ class o implements r {
    public final /* synthetic */ PrivateAnalyticsActivity a;
    public final /* synthetic */ PrivateAnalyticsViewModel b;

    public /* synthetic */ o(PrivateAnalyticsActivity privateAnalyticsActivity, PrivateAnalyticsViewModel privateAnalyticsViewModel) {
        this.a = privateAnalyticsActivity;
        this.b = privateAnalyticsViewModel;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        PrivateAnalyticsActivity privateAnalyticsActivity = this.a;
        PrivateAnalyticsViewModel privateAnalyticsViewModel = this.b;
        privateAnalyticsActivity.s.f2101d.setOnCheckedChangeListener(null);
        privateAnalyticsActivity.s.f2101d.setChecked(((Boolean) obj).booleanValue());
        privateAnalyticsActivity.s.f2101d.setOnCheckedChangeListener(new q(privateAnalyticsViewModel));
    }
}
