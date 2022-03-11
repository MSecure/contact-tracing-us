package f.b.a.a.a.z;

import android.util.Log;
import e.c0.o;
import f.b.b.f.a.p;

public class k implements p<o.b.c> {
    public k(l lVar) {
    }

    @Override // f.b.b.f.a.p
    public void a(Throwable th) {
        Log.e("WorkScheduler", "Failed to schedule SubmitPrivateAnalyticsWorker.", th);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.b.f.a.p
    public void b(o.b.c cVar) {
        Log.i("WorkScheduler", "Scheduled SubmitPrivateAnalyticsWorker.");
    }
}
