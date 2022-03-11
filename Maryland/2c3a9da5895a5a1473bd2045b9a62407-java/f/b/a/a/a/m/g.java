package f.b.a.a.a.m;

import e.f.a.b;
import e.f.a.d;
import f.a.a.a.a;
import f.b.a.a.a.q.j;
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
        StringBuilder h2 = a.h("Getting index file from ");
        h2.append(oVar.b());
        h2.toString();
        j jVar2 = new j(oVar.b().toString(), jVar, iVar, rVar.c);
        jVar2.f2059j = false;
        rVar.b.a(jVar2);
        return jVar2;
    }
}
