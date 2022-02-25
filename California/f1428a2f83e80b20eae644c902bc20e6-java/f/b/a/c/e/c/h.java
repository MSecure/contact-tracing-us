package f.b.a.c.e.c;

import f.b.a.c.b.c;
import f.b.a.c.b.l.l.l;
import f.b.a.c.f.b.b;
import f.b.a.c.i.a;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class h implements a {
    public final s2 a;
    public final List b;
    public final b c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2491d;

    public h(s2 s2Var, List list, b bVar, String str) {
        this.a = s2Var;
        this.b = list;
        this.c = bVar;
        this.f2491d = str;
    }

    @Override // f.b.a.c.i.a
    public final Object a(f.b.a.c.i.h hVar) {
        s2 s2Var = this.a;
        List list = this.b;
        b bVar = this.c;
        String str = this.f2491d;
        Objects.requireNonNull(s2Var);
        if (((Long) hVar.k()).longValue() >= 17203704004L) {
            f.b.a.c.f.b.a aVar = new f.b.a.c.f.b.a(list);
            l.a a2 = l.a();
            a2.a = new g(s2Var, bVar, aVar, str);
            a2.b = new c[]{f.b.a.c.f.c.m};
            return s2Var.k(1, a2.a());
        }
        l.a a3 = l.a();
        a3.a = new d(s2Var, list, bVar, str);
        a3.b = new c[]{f.b.a.c.f.c.f2532f};
        return s2Var.k(1, a3.a());
    }
}
