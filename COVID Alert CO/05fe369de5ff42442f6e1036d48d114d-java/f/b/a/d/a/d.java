package f.b.a.d.a;

import e.f.a.b;
import f.a.a.a.a;
import f.a.b.p;
import f.a.b.u;
import f.b.a.a.a.u.q;

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
        if (sVar.f2773d.b()) {
            sVar.f2773d.a().b(uVar);
        }
        d0 d0Var = sVar.f2774e;
        StringBuilder i2 = a.i("Remote Config Fetch Failed: ");
        i2.append(f.b.a.c.b.o.b.C0(uVar).toString());
        ((q) d0Var).a.a(i2.toString());
        bVar.a(null);
    }
}
