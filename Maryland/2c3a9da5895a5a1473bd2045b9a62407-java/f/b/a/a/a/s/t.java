package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.c0.n;
import e.p.r;
import f.b.a.a.a.l.l0;
import java.util.Objects;

public final /* synthetic */ class t implements r {
    public final /* synthetic */ c0 a;

    public /* synthetic */ t(c0 c0Var) {
        this.a = c0Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        c0 c0Var = this.a;
        Objects.requireNonNull(c0Var);
        if (((Boolean) obj).booleanValue()) {
            c0Var.b0.f401d.a(new n.a(SubmitPrivateAnalyticsWorker.class).a());
            l0.z0(c0Var);
        }
    }
}
