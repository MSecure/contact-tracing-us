package f.b.a.a.a.q;

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
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = provideDiagnosisKeysWorker.f377h;
        if (((DiagnosisKeysDataMapping) obj).equals(diagnosisKeysDataMapping)) {
            ProvideDiagnosisKeysWorker.n.a("DiagnosisKeysDataMapping unchanged, not requesting update");
            return s.c;
        }
        ProvideDiagnosisKeysWorker.n.a("Updated DiagnosisKeysDataMapping detected, calling Nearby.setDiagnosisKeysDataMapping");
        i1 i1Var = provideDiagnosisKeysWorker.f376g;
        return m.h.i0(i1Var.a.i(diagnosisKeysDataMapping).d(new c(i1Var)).f(new g(i1Var)), ProvideDiagnosisKeysWorker.p, provideDiagnosisKeysWorker.f379j);
    }
}
