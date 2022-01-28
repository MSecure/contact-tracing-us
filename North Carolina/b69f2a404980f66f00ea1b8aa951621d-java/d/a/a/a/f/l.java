package d.a.a.a.f;

import c.b.b.e.a.i;
import c.b.b.e.a.u;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import gov.nc.dhhs.exposurenotification.nearby.ProvideDiagnosisKeysWorker;

/* compiled from: lambda */
public final /* synthetic */ class l implements i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProvideDiagnosisKeysWorker f4656a;

    public /* synthetic */ l(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.f4656a = provideDiagnosisKeysWorker;
    }

    @Override // c.b.b.e.a.i
    public final u a(Object obj) {
        return this.f4656a.checkDiagnosisKeyDataMappingForUpdate((DiagnosisKeysDataMapping) obj);
    }
}
