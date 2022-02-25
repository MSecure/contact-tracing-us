package f.b.a.a.a.x;

import e.b.a.m;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class c implements i {
    public final /* synthetic */ l a;

    public /* synthetic */ c(l lVar) {
        this.a = lVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        l lVar = this.a;
        Objects.requireNonNull(lVar);
        if (!((Boolean) obj).booleanValue()) {
            return b.c1(Boolean.FALSE);
        }
        l z = l.x(m.h.g0(lVar.a.a(), l.f2286f, lVar.c)).z(new a(lVar), lVar.b);
        b bVar = b.a;
        ExecutorService executorService = lVar.b;
        a.C0105a aVar = new a.C0105a(z, Exception.class, bVar);
        ((l.a) z).a(aVar, b.A1(executorService, aVar));
        return aVar.y(d.a, lVar.b);
    }
}
