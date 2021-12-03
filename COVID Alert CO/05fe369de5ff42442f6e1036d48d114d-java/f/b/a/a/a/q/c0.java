package f.b.a.a.a.q;

import com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.i.y;
import f.b.a.a.a.o.a0;
import f.b.a.a.a.o.e0;
import f.b.a.c.b.o.b;
import f.b.b.a.l;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class c0 implements i {
    public final /* synthetic */ PreAuthTEKsReceivedWorker a;
    public final /* synthetic */ List b;

    public /* synthetic */ c0(PreAuthTEKsReceivedWorker preAuthTEKsReceivedWorker, List list) {
        this.a = preAuthTEKsReceivedWorker;
        this.b = list;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        PreAuthTEKsReceivedWorker preAuthTEKsReceivedWorker = this.a;
        List list = this.b;
        l lVar = (l) obj;
        Objects.requireNonNull(preAuthTEKsReceivedWorker);
        if (!lVar.b()) {
            return new s.a(new PreAuthTEKsReceivedWorker.a());
        }
        h0 h0Var = (h0) lVar.a();
        a0.b bVar = (a0.b) e0.j(list, h0Var.p(), y.a(preAuthTEKsReceivedWorker.f371i));
        bVar.f2279e = h0Var.j();
        bVar.f2283i = h0Var.k();
        bVar.f2282h = h0Var.b();
        bVar.d(h0.e.TRAVELED.equals(h0Var.o()));
        return b.O0(bVar.a());
    }
}
