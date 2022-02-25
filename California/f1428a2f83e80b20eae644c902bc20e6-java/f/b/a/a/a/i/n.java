package f.b.a.a.a.i;

import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import e.n.a.b;
import e.p.u;
import f.b.a.a.a.w.n0;
import i.a.a;

public final class n implements b<ExposureHomeViewModel> {
    public final a<n0> a;

    public n(a<n0> aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'e.p.a0' to match base method */
    @Override // e.n.a.b
    public ExposureHomeViewModel a(u uVar) {
        return new ExposureHomeViewModel(this.a.get());
    }
}
