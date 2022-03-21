package f.b.a.a.a.n;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import f.b.a.a.a.s.u;
import f.b.b.a.g;

public final /* synthetic */ class q implements g {
    public final /* synthetic */ ProvideDiagnosisKeysWorker a;

    public /* synthetic */ q(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.a = provideDiagnosisKeysWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        this.a.f362l.g(u.d.TASK_PROVIDE_DIAGNOSIS_KEYS);
        return new ListenableWorker.a.c();
    }
}
