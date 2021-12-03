package f.b.a.a.a.b0;

import com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker;
import f.b.a.a.a.l0.h0;
import f.b.b.a.a;
import f.b.b.a.g;
import f.b.b.a.l;
import java.util.Objects;

public final /* synthetic */ class z implements g {
    public final /* synthetic */ PreAuthTEKsReceivedWorker a;
    public final /* synthetic */ g b;

    public /* synthetic */ z(PreAuthTEKsReceivedWorker preAuthTEKsReceivedWorker, g gVar) {
        this.a = preAuthTEKsReceivedWorker;
        this.b = gVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        PreAuthTEKsReceivedWorker preAuthTEKsReceivedWorker = this.a;
        g<h0, h0> gVar = this.b;
        l lVar = (l) obj;
        Objects.requireNonNull(preAuthTEKsReceivedWorker);
        return lVar.b() ? l.c(preAuthTEKsReceivedWorker.f370g.a(((h0) lVar.a()).e(), gVar)) : a.b;
    }
}
