package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.b.a.m;
import f.b.a.a.a.s.u;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class n implements i {
    public final /* synthetic */ SubmitPrivateAnalyticsWorker a;

    public /* synthetic */ n(SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker) {
        this.a = submitPrivateAnalyticsWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker = this.a;
        submitPrivateAnalyticsWorker.f391g.i(u.d.TASK_SUBMIT_PRIVATE_ANALYTICS);
        if (!((Boolean) obj).booleanValue() || !u.b()) {
            return new s.a(new SubmitPrivateAnalyticsWorker.b(null));
        }
        z zVar = submitPrivateAnalyticsWorker.f389e;
        x xVar = zVar.c;
        Objects.requireNonNull(xVar);
        return l.x(l.x(m.h.f0(new d(xVar))).y(new b(xVar), xVar.f2234d)).y(new k(zVar), zVar.a);
    }
}
