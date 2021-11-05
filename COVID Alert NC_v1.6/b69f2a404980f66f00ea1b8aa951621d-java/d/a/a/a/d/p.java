package d.a.a.a.d;

import c.b.b.e.a.i;
import c.b.b.e.a.u;
import gov.nc.dhhs.exposurenotification.exposure.ExposureHomeViewModel;
import gov.nc.dhhs.exposurenotification.storage.TokenEntity;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class p implements i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExposureHomeViewModel f4624a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenEntity f4625b;

    public /* synthetic */ p(ExposureHomeViewModel exposureHomeViewModel, TokenEntity tokenEntity) {
        this.f4624a = exposureHomeViewModel;
        this.f4625b = tokenEntity;
    }

    @Override // c.b.b.e.a.i
    public final u a(Object obj) {
        return this.f4624a.a(this.f4625b, (List) obj);
    }
}
