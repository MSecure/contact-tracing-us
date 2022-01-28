package f.b.a.a.a.b0;

import com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.y.e0;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;

public final /* synthetic */ class t implements i {
    public final /* synthetic */ PreAuthTEKsReceivedWorker a;

    public /* synthetic */ t(PreAuthTEKsReceivedWorker preAuthTEKsReceivedWorker) {
        this.a = preAuthTEKsReceivedWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        h0.d dVar;
        PreAuthTEKsReceivedWorker preAuthTEKsReceivedWorker = this.a;
        e0 e0Var = (e0) obj;
        preAuthTEKsReceivedWorker.m.t(preAuthTEKsReceivedWorker.f375l.c());
        try {
            dVar = h0.d.a(e0Var.p());
        } catch (IllegalArgumentException | NullPointerException unused) {
            dVar = null;
        }
        preAuthTEKsReceivedWorker.m.r(dVar);
        return l.x(preAuthTEKsReceivedWorker.f370g.e()).y(new z(preAuthTEKsReceivedWorker, new y(e0Var)), preAuthTEKsReceivedWorker.f372i);
    }
}
