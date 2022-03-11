package f.b.a.a.a.t;

import e.f.a.b;
import f.b.a.a.a.t.y;
import java.util.Objects;

public final /* synthetic */ class d implements e.f.a.d {
    public final /* synthetic */ y a;

    public /* synthetic */ d(y yVar) {
        this.a = yVar;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        y yVar = this.a;
        Objects.requireNonNull(yVar);
        y.a aVar = new y.a(yVar.c, new c(yVar, bVar), new f(yVar, bVar), yVar.a);
        yVar.b.a(aVar);
        return aVar;
    }
}
