package f.b.a.a.a.p;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import f.b.a.a.a.p.r;
import f.b.a.a.a.v.p;
import f.b.b.a.g;

public final /* synthetic */ class m implements g {
    public final /* synthetic */ FirelogAnalyticsWorker a;

    public /* synthetic */ m(FirelogAnalyticsWorker firelogAnalyticsWorker) {
        this.a = firelogAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        r.a aVar = (r.a) obj;
        this.a.f362e.h(p.d.TASK_FIRELOG_ANALYTICS);
        return new ListenableWorker.a.c();
    }
}
