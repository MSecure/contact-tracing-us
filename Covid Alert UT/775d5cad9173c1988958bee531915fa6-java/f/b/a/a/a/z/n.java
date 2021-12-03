package f.b.a.a.a.z;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import f.b.a.a.a.g0.p;
import f.b.b.a.g;

public final /* synthetic */ class n implements g {
    public final /* synthetic */ FirelogAnalyticsWorker a;

    public /* synthetic */ n(FirelogAnalyticsWorker firelogAnalyticsWorker) {
        this.a = firelogAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        this.a.f365g.k(p.d.TASK_FIRELOG_ANALYTICS, (Exception) obj);
        return new ListenableWorker.a.C0003a();
    }
}
