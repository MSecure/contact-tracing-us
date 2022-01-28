package d.a.a.a.g;

import c.b.b.a.e;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKeyDownloader;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class g implements e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyDownloader f4674a;

    public /* synthetic */ g(DiagnosisKeyDownloader diagnosisKeyDownloader) {
        this.f4674a = diagnosisKeyDownloader;
    }

    @Override // c.b.b.a.e
    public final Object a(Object obj) {
        return this.f4674a.groupAsBatches((List) obj);
    }
}
