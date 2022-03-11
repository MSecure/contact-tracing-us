package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import e.b.a.m;
import f.b.a.a.a.u.u;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;

public final /* synthetic */ class s implements i {
    public final /* synthetic */ ProvideDiagnosisKeysWorker a;

    public /* synthetic */ s(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.a = provideDiagnosisKeysWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker = this.a;
        provideDiagnosisKeysWorker.f372l.i(u.d.TASK_PROVIDE_DIAGNOSIS_KEYS);
        if (((Boolean) obj).booleanValue()) {
            return m.h.g0(provideDiagnosisKeysWorker.f367g.a.f(), ProvideDiagnosisKeysWorker.n, provideDiagnosisKeysWorker.f370j);
        }
        return new s.a(new ProvideDiagnosisKeysWorker.b(null));
    }
}
