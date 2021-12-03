package f.b.c.k.t;

import f.b.a.c.b.o.b;
import f.b.c.k.u.p.f;
import f.b.c.k.x.n;

public final /* synthetic */ class m implements n {
    public final r a;
    public final int b;

    public m(r rVar, int i2) {
        this.a = rVar;
        this.b = i2;
    }

    @Override // f.b.c.k.x.n
    public Object get() {
        r rVar = this.a;
        f i2 = rVar.b.i(this.b);
        b.M0(i2 != null, "Attempt to reject nonexistent batch!", new Object[0]);
        rVar.b.j(i2);
        rVar.b.c();
        g gVar = rVar.f3290d;
        return gVar.b(gVar.a.d(i2.b()));
    }
}
