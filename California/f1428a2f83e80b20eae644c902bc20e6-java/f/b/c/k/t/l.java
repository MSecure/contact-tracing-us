package f.b.c.k.t;

import f.b.a.c.b.o.b;
import f.b.c.k.u.i;
import f.b.c.k.u.m;
import f.b.c.k.u.p.e;
import f.b.c.k.u.p.f;
import f.b.c.k.u.p.g;
import f.b.c.k.u.p.h;
import f.b.c.k.x.n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final /* synthetic */ class l implements n {
    public final r a;
    public final g b;

    public l(r rVar, g gVar) {
        this.a = rVar;
        this.b = gVar;
    }

    @Override // f.b.c.k.x.n
    public Object get() {
        r rVar = this.a;
        g gVar = this.b;
        int i2 = r.f3090k;
        f fVar = gVar.a;
        rVar.b.b(fVar, gVar.f3112d);
        f fVar2 = gVar.a;
        Iterator it = ((HashSet) fVar2.b()).iterator();
        while (it.hasNext()) {
            f.b.c.k.u.f fVar3 = (f.b.c.k.u.f) it.next();
            i b2 = rVar.c.b(fVar3);
            m i3 = gVar.f3113e.i(fVar3);
            b.a1(i3 != null, "docVersions should contain every doc in the write.", new Object[0]);
            if (b2 == null || b2.b.compareTo(i3) < 0) {
                if (b2 != null) {
                    b.a1(b2.a.equals(fVar3), "applyToRemoteDocument: key %s doesn't match maybeDoc key %s", fVar3, b2.a);
                }
                int size = fVar2.f3111d.size();
                List<h> list = gVar.c;
                b.a1(list.size() == size, "Mismatch between mutations length (%d) and results length (%d)", Integer.valueOf(size), Integer.valueOf(list.size()));
                i iVar = b2;
                for (int i4 = 0; i4 < size; i4++) {
                    e eVar = fVar2.f3111d.get(i4);
                    if (eVar.a.equals(fVar3)) {
                        iVar = eVar.b(iVar, list.get(i4));
                    }
                }
                if (iVar == null) {
                    b.a1(b2 == null, "Mutation batch %s applied to document %s resulted in null.", fVar2, b2);
                } else {
                    rVar.c.a(iVar, gVar.b);
                }
            }
        }
        rVar.b.j(fVar2);
        rVar.b.c();
        g gVar2 = rVar.f3091d;
        return gVar2.b(gVar2.a.d(fVar.b()));
    }
}
