package f.b.a.a.a.f0;

import e.f.a.b;
import f.a.b.p;
import f.a.b.u;
import f.b.a.a.a.s.d0.a;

public final /* synthetic */ class d implements p.a {
    public final /* synthetic */ n a;
    public final /* synthetic */ b b;

    public /* synthetic */ d(n nVar, b bVar) {
        this.a = nVar;
        this.b = bVar;
    }

    @Override // f.a.b.p.a
    public final void a(u uVar) {
        n nVar = this.a;
        b bVar = this.b;
        if (nVar.c.b()) {
            nVar.c.a().b(uVar);
        }
        a aVar = n.f2219e;
        StringBuilder h2 = f.a.a.a.a.h("Remote Config Fetch Failed: ");
        h2.append(f.b.a.c.b.o.b.E0(uVar).toString());
        aVar.a(h2.toString());
        bVar.a(null);
    }
}
