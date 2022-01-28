package f.b.a.a.a.z;

import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import e.p.t;

public final /* synthetic */ class w implements t {
    public final /* synthetic */ a1 a;
    public final /* synthetic */ PrivateAnalyticsViewModel b;

    public /* synthetic */ w(a1 a1Var, PrivateAnalyticsViewModel privateAnalyticsViewModel) {
        this.a = a1Var;
        this.b = privateAnalyticsViewModel;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        a1 a1Var = this.a;
        PrivateAnalyticsViewModel privateAnalyticsViewModel = this.b;
        a1Var.a0.f2237d.setOnCheckedChangeListener(null);
        a1Var.a0.f2237d.setChecked(((Boolean) obj).booleanValue());
        a1Var.a0.f2237d.setOnCheckedChangeListener(new v(privateAnalyticsViewModel));
    }
}
