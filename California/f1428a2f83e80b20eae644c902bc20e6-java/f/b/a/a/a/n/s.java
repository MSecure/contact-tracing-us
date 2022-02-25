package f.b.a.a.a.n;

import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import e.b.a.m;
import f.b.a.a.a.s.u;
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
        provideDiagnosisKeysWorker.f362l.i(u.d.TASK_PROVIDE_DIAGNOSIS_KEYS);
        if (((Boolean) obj).booleanValue()) {
            return m.h.g0(provideDiagnosisKeysWorker.f357g.a.g(), ProvideDiagnosisKeysWorker.n, provideDiagnosisKeysWorker.f360j);
        }
        return new s.a(new ProvideDiagnosisKeysWorker.b(null));
    }
}
