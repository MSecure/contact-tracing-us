package f.b.a.a.a.v;

import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import e.b0.t;
import e.n.a.b;
import e.p.u;
import f.b.a.a.a.w.n0;
import i.a.a;

public final class s0 implements b<PrivateAnalyticsViewModel> {
    public final a<n0> a;
    public final a<t> b;

    public s0(a<n0> aVar, a<t> aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    /* Return type fixed from 'e.p.a0' to match base method */
    @Override // e.n.a.b
    public PrivateAnalyticsViewModel a(u uVar) {
        return new PrivateAnalyticsViewModel(this.a.get(), this.b.get());
    }
}
