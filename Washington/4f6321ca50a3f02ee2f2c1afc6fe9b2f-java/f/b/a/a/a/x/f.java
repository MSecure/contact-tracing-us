package f.b.a.a.a.x;

import android.util.Log;
import e.b0.o;
import f.b.b.f.a.p;

public class f implements p<o.b.c> {
    public f(k kVar) {
    }

    @Override // f.b.b.f.a.p
    public void a(Throwable th) {
        Log.e("WorkScheduler", "Failed to schedule UploadCoverTrafficWorker.", th);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.b.f.a.p
    public void b(o.b.c cVar) {
        Log.i("WorkScheduler", "Scheduled UploadCoverTrafficWorker.");
    }
}
