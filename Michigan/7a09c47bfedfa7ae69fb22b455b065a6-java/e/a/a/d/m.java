package e.a.a.d;

import c.b.b.e.a.i;
import c.b.b.e.a.u;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import gov.michigan.MiCovidExposure.nearby.ProvideDiagnosisKeysWorker;

/* compiled from: lambda */
public final /* synthetic */ class m implements i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProvideDiagnosisKeysWorker f6269a;

    public /* synthetic */ m(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.f6269a = provideDiagnosisKeysWorker;
    }

    @Override // c.b.b.e.a.i
    public final u a(Object obj) {
        return this.f6269a.checkDiagnosisKeyDataMappingForUpdate((DiagnosisKeysDataMapping) obj);
    }
}
