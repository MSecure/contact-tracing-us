package f.b.a.a.a.u;

import e.f.a.b;
import f.a.b.p;
import f.a.b.u;
import f.b.a.a.a.i.e0.a;

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
        a aVar = n.f2423e;
        StringBuilder i2 = f.a.a.a.a.i("Remote Config Fetch Failed: ");
        i2.append(f.b.a.c.b.o.b.C0(uVar).toString());
        aVar.a(i2.toString());
        bVar.a(null);
    }
}
