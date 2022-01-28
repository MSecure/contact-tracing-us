package e.a.a.e;

import c.b.b.a.e;
import gov.michigan.MiCovidExposure.network.DiagnosisKeyDownloader;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class i implements e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyDownloader f6288a;

    public /* synthetic */ i(DiagnosisKeyDownloader diagnosisKeyDownloader) {
        this.f6288a = diagnosisKeyDownloader;
    }

    @Override // c.b.b.a.e
    public final Object a(Object obj) {
        return this.f6288a.groupAsBatches((List) obj);
    }
}
