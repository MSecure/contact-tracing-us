package f.b.a.a.a.m;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import f.b.a.a.a.s.u;
import f.b.b.a.g;

public final /* synthetic */ class m implements g {
    public final /* synthetic */ FirelogAnalyticsWorker a;

    public /* synthetic */ m(FirelogAnalyticsWorker firelogAnalyticsWorker) {
        this.a = firelogAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        FirelogAnalyticsWorker.b bVar = (FirelogAnalyticsWorker.b) obj;
        this.a.f352e.h(u.d.TASK_FIRELOG_ANALYTICS);
        return new ListenableWorker.a.c();
    }
}
