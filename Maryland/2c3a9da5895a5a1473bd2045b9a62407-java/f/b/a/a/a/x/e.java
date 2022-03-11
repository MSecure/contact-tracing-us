package f.b.a.a.a.x;

import com.google.android.apps.exposurenotification.settings.AppAnalyticsActivity;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;
import e.p.r;

public final /* synthetic */ class e implements r {
    public final /* synthetic */ AppAnalyticsActivity a;
    public final /* synthetic */ AppAnalyticsViewModel b;

    public /* synthetic */ e(AppAnalyticsActivity appAnalyticsActivity, AppAnalyticsViewModel appAnalyticsViewModel) {
        this.a = appAnalyticsActivity;
        this.b = appAnalyticsViewModel;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        AppAnalyticsActivity appAnalyticsActivity = this.a;
        AppAnalyticsViewModel appAnalyticsViewModel = this.b;
        appAnalyticsActivity.s.c.setOnCheckedChangeListener(null);
        appAnalyticsActivity.s.c.setChecked(((Boolean) obj).booleanValue());
        appAnalyticsActivity.s.c.setOnCheckedChangeListener(new b(appAnalyticsViewModel));
    }
}
