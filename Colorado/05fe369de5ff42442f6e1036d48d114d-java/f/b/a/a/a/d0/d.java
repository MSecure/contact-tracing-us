package f.b.a.a.a.d0;

import e.b.a.m;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class d implements i {
    public final /* synthetic */ m a;

    public /* synthetic */ d(m mVar) {
        this.a = mVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        m mVar = this.a;
        mVar.a();
        if (!((Boolean) obj).booleanValue()) {
            return b.O0(Boolean.FALSE);
        }
        l z = l.x(m.h.i0(mVar.a.a(), m.f2140j, mVar.c)).z(new b(mVar), mVar.b);
        a aVar = a.a;
        ExecutorService executorService = mVar.b;
        a.C0108a aVar2 = new a.C0108a(z, Exception.class, aVar);
        ((l.a) z).a(aVar2, b.g1(executorService, aVar2));
        return aVar2.y(e.a, mVar.b);
    }
}
