package f.b.a.a.a.b0;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import f.b.a.a.a.g0.p;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class i0 implements g {
    public final /* synthetic */ ProvideDiagnosisKeysWorker a;

    public /* synthetic */ i0(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.a = provideDiagnosisKeysWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker = this.a;
        Exception exc = (Exception) obj;
        Objects.requireNonNull(provideDiagnosisKeysWorker);
        ProvideDiagnosisKeysWorker.p.d("Failure to provide diagnosis keys", exc);
        provideDiagnosisKeysWorker.n.k(p.d.TASK_PROVIDE_DIAGNOSIS_KEYS, exc);
        return new ListenableWorker.a.C0003a();
    }
}
