package f.b.a.a.a.z;

import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import e.n.a.b;
import e.p.y;
import f.b.a.a.a.b0.v0;
import f.b.a.d.a.a0;
import i.a.a;

public final class c1 implements b<PrivateAnalyticsViewModel> {
    public final a<v0> a;
    public final a<a0> b;

    public c1(a<v0> aVar, a<a0> aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    /* Return type fixed from 'e.p.e0' to match base method */
    @Override // e.n.a.b
    public PrivateAnalyticsViewModel a(y yVar) {
        return new PrivateAnalyticsViewModel(this.a.get(), this.b.get());
    }
}
