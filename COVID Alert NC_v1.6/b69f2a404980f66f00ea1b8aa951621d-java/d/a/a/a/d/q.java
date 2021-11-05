package d.a.a.a.d;

import c.b.b.e.a.i;
import c.b.b.e.a.u;
import gov.nc.dhhs.exposurenotification.exposure.ExposureHomeViewModel;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class q implements i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExposureHomeViewModel f4626a;

    public /* synthetic */ q(ExposureHomeViewModel exposureHomeViewModel) {
        this.f4626a = exposureHomeViewModel;
    }

    @Override // c.b.b.e.a.i
    public final u a(Object obj) {
        return this.f4626a.checkForRespondedTokensAsync((List) obj);
    }
}
