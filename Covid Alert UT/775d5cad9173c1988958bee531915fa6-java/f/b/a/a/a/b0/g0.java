package f.b.a.a.a.b0;

import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;

public final /* synthetic */ class g0 implements i {
    public final /* synthetic */ ProvideDiagnosisKeysWorker a;

    public /* synthetic */ g0(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.a = provideDiagnosisKeysWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker = this.a;
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = provideDiagnosisKeysWorker.f379j;
        if (((DiagnosisKeysDataMapping) obj).equals(diagnosisKeysDataMapping)) {
            ProvideDiagnosisKeysWorker.p.a("DiagnosisKeysDataMapping unchanged, not requesting update");
            return s.c;
        }
        ProvideDiagnosisKeysWorker.p.a("Updated DiagnosisKeysDataMapping detected, calling Nearby.setDiagnosisKeysDataMapping");
        i1 i1Var = provideDiagnosisKeysWorker.f378i;
        return m.e.m0(i1Var.a.i(diagnosisKeysDataMapping).d(new c(i1Var)).f(new g(i1Var)), ProvideDiagnosisKeysWorker.r, provideDiagnosisKeysWorker.f381l);
    }
}
