package f.b.a.a.a.k;

import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import e.n.a.b;
import e.p.u;
import f.b.a.a.a.y.m0;
import f.b.a.a.a.y.q0;
import i.a.a;

public final class p implements b<ExposureHomeViewModel> {
    public final a<q0> a;
    public final a<m0> b;

    public p(a<q0> aVar, a<m0> aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    /* Return type fixed from 'e.p.a0' to match base method */
    @Override // e.n.a.b
    public ExposureHomeViewModel a(u uVar) {
        return new ExposureHomeViewModel(this.a.get(), this.b.get());
    }
}
