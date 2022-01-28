package f.b.a.a.a.j0;

import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;
import e.q.t;

public final /* synthetic */ class e implements t {
    public final /* synthetic */ m0 a;
    public final /* synthetic */ AppAnalyticsViewModel b;

    public /* synthetic */ e(m0 m0Var, AppAnalyticsViewModel appAnalyticsViewModel) {
        this.a = m0Var;
        this.b = appAnalyticsViewModel;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        m0 m0Var = this.a;
        AppAnalyticsViewModel appAnalyticsViewModel = this.b;
        m0Var.b0.c.setOnCheckedChangeListener(null);
        m0Var.b0.c.setChecked(((Boolean) obj).booleanValue());
        m0Var.b0.c.setOnCheckedChangeListener(new b(appAnalyticsViewModel));
    }
}
