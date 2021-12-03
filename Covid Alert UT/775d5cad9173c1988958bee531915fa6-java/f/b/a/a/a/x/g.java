package f.b.a.a.a.x;

import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.c0.j;
import f.b.a.a.a.s.d0.a;
import java.util.Objects;

public final /* synthetic */ class g implements d {
    public final /* synthetic */ r a;
    public final /* synthetic */ o b;

    public /* synthetic */ g(r rVar, o oVar) {
        this.a = rVar;
        this.b = oVar;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        r rVar = this.a;
        o oVar = this.b;
        Objects.requireNonNull(rVar);
        j jVar = new j(bVar);
        i iVar = new i(bVar);
        a aVar = r.f2457f;
        StringBuilder h2 = f.a.a.a.a.h("Getting index file from ");
        h2.append(oVar.b());
        aVar.a(h2.toString());
        j jVar2 = new j(oVar.b().toString(), jVar, iVar, rVar.c);
        jVar2.f2144j = false;
        rVar.b.a(jVar2);
        return jVar2;
    }
}
