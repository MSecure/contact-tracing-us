package f.b.c.k.t;

import f.b.c.d;
import f.b.c.k.u.f;
import f.b.c.k.u.i;
import f.b.c.k.u.p.e;
import f.b.c.k.u.p.j;
import f.b.c.k.x.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final /* synthetic */ class k implements n {
    public final r a;
    public final Set b;
    public final List c;

    /* renamed from: d  reason: collision with root package name */
    public final d f3084d;

    public k(r rVar, Set set, List list, d dVar) {
        this.a = rVar;
        this.b = set;
        this.c = list;
        this.f3084d = dVar;
    }

    @Override // f.b.c.k.x.n
    public Object get() {
        r rVar = this.a;
        Set set = this.b;
        List<e> list = this.c;
        d dVar = this.f3084d;
        g gVar = rVar.f3091d;
        f.b.c.g.a.d<f, i> b2 = gVar.b(gVar.a.d(set));
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            f.b.c.k.u.k c2 = eVar.c(b2.i(eVar.a));
            if (c2 != null) {
                arrayList.add(new j(eVar.a, c2, c2.a(c2.a.u()), f.b.c.k.u.p.k.a(true)));
            }
        }
        f.b.c.k.u.p.f f2 = rVar.b.f(dVar, arrayList, list);
        Iterator it = ((HashSet) f2.b()).iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            i a2 = f2.a(fVar, b2.i(fVar));
            if (a2 != null) {
                b2 = b2.l(a2.a, a2);
            }
        }
        return new t(f2.a, b2);
    }
}
