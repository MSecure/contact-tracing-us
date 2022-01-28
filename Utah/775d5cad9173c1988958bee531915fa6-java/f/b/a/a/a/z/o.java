package f.b.a.a.a.z;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import f.b.a.a.a.g0.p;
import f.b.b.a.g;

public final /* synthetic */ class o implements g {
    public final /* synthetic */ FirelogAnalyticsWorker a;

    public /* synthetic */ o(FirelogAnalyticsWorker firelogAnalyticsWorker) {
        this.a = firelogAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        this.a.f365g.g(p.d.TASK_FIRELOG_ANALYTICS);
        return new ListenableWorker.a.c();
    }
}
