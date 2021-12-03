package f.b.a.a.a.j0;

import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import e.q.t;

public final /* synthetic */ class w implements t {
    public final /* synthetic */ z0 a;
    public final /* synthetic */ PrivateAnalyticsViewModel b;

    public /* synthetic */ w(z0 z0Var, PrivateAnalyticsViewModel privateAnalyticsViewModel) {
        this.a = z0Var;
        this.b = privateAnalyticsViewModel;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        z0 z0Var = this.a;
        PrivateAnalyticsViewModel privateAnalyticsViewModel = this.b;
        z0Var.b0.f2435d.setOnCheckedChangeListener(null);
        z0Var.b0.f2435d.setChecked(((Boolean) obj).booleanValue());
        z0Var.b0.f2435d.setOnCheckedChangeListener(new v(privateAnalyticsViewModel));
    }
}
