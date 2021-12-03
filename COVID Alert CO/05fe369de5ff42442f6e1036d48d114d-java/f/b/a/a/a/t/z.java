package f.b.a.a.a.t;

import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.p.t;
import e.z.n;
import f.b.a.a.a.m.f1;
import java.util.Objects;

public final /* synthetic */ class z implements t {
    public final /* synthetic */ k0 a;

    public /* synthetic */ z(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        k0 k0Var = this.a;
        Objects.requireNonNull(k0Var);
        if (((Boolean) obj).booleanValue()) {
            k0Var.X.f422e.b(new n.a(SubmitPrivateAnalyticsWorker.class).a());
            f1.C0(k0Var);
        }
    }
}
