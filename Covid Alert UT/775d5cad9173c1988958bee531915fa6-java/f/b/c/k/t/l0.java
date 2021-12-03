package f.b.c.k.t;

import f.b.a.c.b.o.b;
import f.b.c.k.t.z;
import f.b.c.k.u.l;

public final class l0 implements f {
    public final z.a a = new z.a();
    public final r0 b;

    public l0(r0 r0Var) {
        this.b = r0Var;
    }

    public void a(l lVar) {
        b.O0(lVar.n() % 2 == 1, "Expected a collection path.", new Object[0]);
        if (this.a.a(lVar)) {
            String h2 = lVar.h();
            this.b.f3364i.execSQL("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)", new Object[]{h2, b.l0((l) lVar.q())});
        }
    }
}
