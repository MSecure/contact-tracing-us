package f.b.a.a.a.m;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import f.b.a.a.a.s.u;
import f.b.b.a.g;

public final /* synthetic */ class l implements g {
    public final /* synthetic */ FirelogAnalyticsWorker a;

    public /* synthetic */ l(FirelogAnalyticsWorker firelogAnalyticsWorker) {
        this.a = firelogAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        Void r2 = (Void) obj;
        this.a.f352e.g(u.d.TASK_FIRELOG_ANALYTICS);
        return new ListenableWorker.a.c();
    }
}
