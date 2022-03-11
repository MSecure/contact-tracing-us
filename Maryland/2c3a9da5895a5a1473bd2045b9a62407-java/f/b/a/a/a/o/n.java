package f.b.a.a.a.o;

import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import f.b.a.a.a.u.u;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;

public final /* synthetic */ class n implements i {
    public final /* synthetic */ FirelogAnalyticsWorker a;

    public /* synthetic */ n(FirelogAnalyticsWorker firelogAnalyticsWorker) {
        this.a = firelogAnalyticsWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        FirelogAnalyticsWorker firelogAnalyticsWorker = this.a;
        firelogAnalyticsWorker.f362e.i(u.d.TASK_FIRELOG_ANALYTICS);
        if (!((Boolean) obj).booleanValue()) {
            return new s.a(new FirelogAnalyticsWorker.b(null));
        }
        return firelogAnalyticsWorker.f362e.c();
    }
}
