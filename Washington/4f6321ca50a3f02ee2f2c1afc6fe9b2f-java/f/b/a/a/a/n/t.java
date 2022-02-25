package f.b.a.a.a.n;

import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;

public final /* synthetic */ class t implements i {
    public final /* synthetic */ ProvideDiagnosisKeysWorker a;

    public /* synthetic */ t(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.a = provideDiagnosisKeysWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker = this.a;
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = provideDiagnosisKeysWorker.f358h;
        if (((DiagnosisKeysDataMapping) obj).equals(diagnosisKeysDataMapping)) {
            return s.c;
        }
        f0 f0Var = provideDiagnosisKeysWorker.f357g;
        return m.h.g0(f0Var.a.h(diagnosisKeysDataMapping).d(new c(f0Var)).f(new g(f0Var)), ProvideDiagnosisKeysWorker.o, provideDiagnosisKeysWorker.f360j);
    }
}
