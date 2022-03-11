package f.b.a.a.a.z;

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
        mVar.f2374e.a(mVar.f2375f.b().w(m.f2372i));
        if (!((Boolean) obj).booleanValue()) {
            return b.d1(Boolean.FALSE);
        }
        l z = l.x(m.h.g0(mVar.a.a(), m.f2371h, mVar.c)).z(new b(mVar), mVar.b);
        a aVar = a.a;
        ExecutorService executorService = mVar.b;
        a.C0109a aVar2 = new a.C0109a(z, Exception.class, aVar);
        ((l.a) z).a(aVar2, b.z1(executorService, aVar2));
        return aVar2.y(e.a, mVar.b);
    }
}
