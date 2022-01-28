package f.b.a.a.a.b0;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import f.b.a.a.a.g0.p;
import f.b.b.a.g;

public final /* synthetic */ class d0 implements g {
    public final /* synthetic */ ProvideDiagnosisKeysWorker a;

    public /* synthetic */ d0(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.a = provideDiagnosisKeysWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        this.a.n.g(p.d.TASK_PROVIDE_DIAGNOSIS_KEYS);
        return new ListenableWorker.a.c();
    }
}
