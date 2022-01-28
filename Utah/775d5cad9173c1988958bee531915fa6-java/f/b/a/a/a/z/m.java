package f.b.a.a.a.z;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import f.b.a.a.a.g0.p;
import f.b.a.a.a.z.r;
import f.b.b.a.g;

public final /* synthetic */ class m implements g {
    public final /* synthetic */ FirelogAnalyticsWorker a;

    public /* synthetic */ m(FirelogAnalyticsWorker firelogAnalyticsWorker) {
        this.a = firelogAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        r.a aVar = (r.a) obj;
        this.a.f365g.h(p.d.TASK_FIRELOG_ANALYTICS);
        return new ListenableWorker.a.c();
    }
}
