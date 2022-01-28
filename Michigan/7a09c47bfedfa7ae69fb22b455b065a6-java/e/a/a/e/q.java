package e.a.a.e;

import c.b.b.e.a.i;
import c.b.b.e.a.u;
import gov.michigan.MiCovidExposure.network.DiagnosisKeyUploader;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class q implements i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiagnosisKeyUploader f6307a;

    public /* synthetic */ q(DiagnosisKeyUploader diagnosisKeyUploader) {
        this.f6307a = diagnosisKeyUploader;
    }

    @Override // c.b.b.e.a.i
    public final u a(Object obj) {
        return this.f6307a.addPayloads((List) obj);
    }
}
