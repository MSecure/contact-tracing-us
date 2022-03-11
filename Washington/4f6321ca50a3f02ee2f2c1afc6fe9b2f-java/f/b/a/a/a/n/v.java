package f.b.a.a.a.n;

import android.util.Log;
import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import f.b.a.a.a.s.u;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class v implements g {
    public final /* synthetic */ ProvideDiagnosisKeysWorker a;

    public /* synthetic */ v(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.a = provideDiagnosisKeysWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker = this.a;
        Exception exc = (Exception) obj;
        Objects.requireNonNull(provideDiagnosisKeysWorker);
        Log.e("ProvideDiagnosisKeysWkr", "Failure to provide diagnosis keys", exc);
        provideDiagnosisKeysWorker.f362l.k(u.d.TASK_PROVIDE_DIAGNOSIS_KEYS, exc);
        return new ListenableWorker.a.C0002a();
    }
}
