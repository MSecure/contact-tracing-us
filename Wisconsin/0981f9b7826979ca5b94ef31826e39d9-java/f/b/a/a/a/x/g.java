package f.b.a.a.a.x;

import android.util.Log;
import e.b0.o;
import f.b.b.f.a.p;

public class g implements p<o.b.c> {
    public g(j jVar) {
    }

    @Override // f.b.b.f.a.p
    public void a(Throwable th) {
        Log.e("WorkScheduler", "Failed to schedule ProvideDiagnosisKeysWorker.", th);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.b.f.a.p
    public void b(o.b.c cVar) {
        Log.i("WorkScheduler", "Scheduled ProvideDiagnosisKeysWorker.");
    }
}
