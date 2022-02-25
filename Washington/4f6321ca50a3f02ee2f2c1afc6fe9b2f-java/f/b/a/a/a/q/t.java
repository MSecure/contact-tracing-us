package f.b.a.a.a.q;

import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.b0.n;
import e.p.r;
import f.b.a.a.a.j.e0;
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
            c0Var.Z.f387d.a(new n.a(SubmitPrivateAnalyticsWorker.class).a());
            e0.z0(c0Var);
        }
    }
}
