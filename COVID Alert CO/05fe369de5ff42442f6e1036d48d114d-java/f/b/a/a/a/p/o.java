package f.b.a.a.a.p;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import f.b.a.a.a.v.p;
import f.b.b.a.g;

public final /* synthetic */ class o implements g {
    public final /* synthetic */ FirelogAnalyticsWorker a;

    public /* synthetic */ o(FirelogAnalyticsWorker firelogAnalyticsWorker) {
        this.a = firelogAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        this.a.f362e.g(p.d.TASK_FIRELOG_ANALYTICS);
        return new ListenableWorker.a.c();
    }
}
