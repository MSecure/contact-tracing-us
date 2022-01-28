package f.b.a.a.a.n0;

import e.b.a.m;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class c implements i {
    public final /* synthetic */ m a;

    public /* synthetic */ c(m mVar) {
        this.a = mVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        m mVar = this.a;
        mVar.a();
        if (!((Boolean) obj).booleanValue()) {
            return b.Q0(Boolean.FALSE);
        }
        l z = l.x(m.e.m0(mVar.a.a(), m.f2337j, mVar.c)).z(new a(mVar), mVar.b);
        d dVar = d.a;
        ExecutorService executorService = mVar.b;
        a.C0108a aVar = new a.C0108a(z, Exception.class, dVar);
        ((l.a) z).a(aVar, b.j1(executorService, aVar));
        return aVar.y(e.a, mVar.b);
    }
}
