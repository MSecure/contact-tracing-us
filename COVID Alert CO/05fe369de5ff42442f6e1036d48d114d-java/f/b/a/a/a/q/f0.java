package f.b.a.a.a.q;

import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import e.b.a.m;
import f.b.a.a.a.v.p;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;

public final /* synthetic */ class f0 implements i {
    public final /* synthetic */ ProvideDiagnosisKeysWorker a;

    public /* synthetic */ f0(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.a = provideDiagnosisKeysWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker = this.a;
        provideDiagnosisKeysWorker.f381l.i(p.d.TASK_PROVIDE_DIAGNOSIS_KEYS);
        if (((Boolean) obj).booleanValue()) {
            return m.h.i0(provideDiagnosisKeysWorker.f376g.a.g(), ProvideDiagnosisKeysWorker.o, provideDiagnosisKeysWorker.f379j);
        }
        return new s.a(new ProvideDiagnosisKeysWorker.b(null));
    }
}
