package f.b.a.a.a.v;

import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;
import e.n.a.b;
import e.p.u;
import f.b.a.a.a.w.n0;
import i.a.a;

public final class i0 implements b<AppAnalyticsViewModel> {
    public final a<n0> a;

    public i0(a<n0> aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'e.p.a0' to match base method */
    @Override // e.n.a.b
    public AppAnalyticsViewModel a(u uVar) {
        return new AppAnalyticsViewModel(this.a.get());
    }
}
