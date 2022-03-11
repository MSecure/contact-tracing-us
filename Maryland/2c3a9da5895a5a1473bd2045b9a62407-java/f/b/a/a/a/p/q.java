package f.b.a.a.a.p;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import f.b.a.a.a.u.u;
import f.b.b.a.g;

public final /* synthetic */ class q implements g {
    public final /* synthetic */ ProvideDiagnosisKeysWorker a;

    public /* synthetic */ q(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.a = provideDiagnosisKeysWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        this.a.f372l.g(u.d.TASK_PROVIDE_DIAGNOSIS_KEYS);
        return new ListenableWorker.a.c();
    }
}
