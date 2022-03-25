package f.b.a.c.e.c;

import f.b.a.c.b.c;
import f.b.a.c.b.l.l.l;
import f.b.a.c.f.b.b;
import f.b.a.c.i.a;
import f.b.a.c.i.h;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class e implements a {
    public final t a;
    public final List b;
    public final b c;

    public e(t tVar, List list, b bVar, String str) {
        this.a = tVar;
        this.b = list;
        this.c = bVar;
    }

    @Override // f.b.a.c.i.a
    public final Object a(h hVar) {
        t tVar = this.a;
        List list = this.b;
        b bVar = this.c;
        Objects.requireNonNull(tVar);
        if (((Long) hVar.k()).longValue() >= 17203704004L) {
            f.b.a.c.f.b.a aVar = new f.b.a.c.f.b.a(list);
            l.a a2 = l.a();
            a2.a = new f(tVar, bVar, aVar, "TYZWQ32170AXEUVCDW7A");
            a2.b = new c[]{f.b.a.c.f.c.m};
            return f.b.a.c.b.o.b.Y1(tVar.j(1, a2.a()), t.f2595j);
        }
        l.a a3 = l.a();
        a3.a = new f3(tVar, list, bVar, "TYZWQ32170AXEUVCDW7A");
        a3.b = new c[]{f.b.a.c.f.c.f2640f};
        return tVar.j(1, a3.a());
    }
}
