package f.b.a.a.a.e0;

import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.b0.p;
import e.q.t;
import f.b.a.a.a.w.f1;
import java.util.Objects;

public final /* synthetic */ class a0 implements t {
    public final /* synthetic */ m0 a;

    public /* synthetic */ a0(m0 m0Var) {
        this.a = m0Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        m0 m0Var = this.a;
        Objects.requireNonNull(m0Var);
        if (((Boolean) obj).booleanValue()) {
            m0Var.X.f419f.c(new p.a(SubmitPrivateAnalyticsWorker.class).a());
            f1.I0(m0Var);
        }
    }
}
