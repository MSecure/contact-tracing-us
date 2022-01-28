package f.b.a.d.a;

import e.f.a.b;
import f.a.a.a.a;
import f.a.b.p;
import f.a.b.u;
import f.b.a.a.a.f0.q;

public final /* synthetic */ class d implements p.a {
    public final /* synthetic */ s a;
    public final /* synthetic */ b b;

    public /* synthetic */ d(s sVar, b bVar) {
        this.a = sVar;
        this.b = bVar;
    }

    @Override // f.a.b.p.a
    public final void a(u uVar) {
        s sVar = this.a;
        b bVar = this.b;
        if (sVar.f2827d.b()) {
            sVar.f2827d.a().b(uVar);
        }
        d0 d0Var = sVar.f2828e;
        StringBuilder h2 = a.h("Remote Config Fetch Failed: ");
        h2.append(f.b.a.c.b.o.b.E0(uVar).toString());
        ((q) d0Var).a.a(h2.toString());
        bVar.a(null);
    }
}
