package f.b.a.a.a.r;

import e.f.a.b;
import f.b.a.a.a.r.x;
import java.util.Objects;

public final /* synthetic */ class d implements e.f.a.d {
    public final /* synthetic */ x a;

    public /* synthetic */ d(x xVar) {
        this.a = xVar;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        x xVar = this.a;
        Objects.requireNonNull(xVar);
        x.a aVar = new x.a(xVar.c, new c(xVar, bVar), new e(xVar, bVar), xVar.a);
        xVar.b.a(aVar);
        return aVar;
    }
}
