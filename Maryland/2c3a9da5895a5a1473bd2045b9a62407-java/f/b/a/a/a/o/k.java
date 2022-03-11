package f.b.a.a.a.o;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import f.b.a.a.a.u.u;
import f.b.b.a.g;

public final /* synthetic */ class k implements g {
    public final /* synthetic */ FirelogAnalyticsWorker a;

    public /* synthetic */ k(FirelogAnalyticsWorker firelogAnalyticsWorker) {
        this.a = firelogAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        this.a.f362e.k(u.d.TASK_FIRELOG_ANALYTICS, (Exception) obj);
        return new ListenableWorker.a.C0003a();
    }
}
