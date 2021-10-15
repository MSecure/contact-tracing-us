package e.a.a.e;

import c.b.b.e.a.i;
import c.b.b.e.a.u;
import gov.michigan.MiCovidExposure.network.DiagnosisKeyUploader;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class t implements i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyUploader f6311a;

    public /* synthetic */ t(DiagnosisKeyUploader diagnosisKeyUploader) {
        this.f6311a = diagnosisKeyUploader;
    }

    @Override // c.b.b.e.a.i
    public final u a(Object obj) {
        return this.f6311a.submitToServers((List) obj);
    }
}
