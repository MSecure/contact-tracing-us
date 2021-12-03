package f.b.c.k.w;

import f.b.a.c.i.d;
import f.b.a.c.i.h;
import f.b.c.k.w.b;
import h.a.f;
import h.a.n0;
import java.util.Objects;

public final /* synthetic */ class p implements d {
    public final t a;
    public final f[] b;
    public final d0 c;

    public p(t tVar, f[] fVarArr, d0 d0Var) {
        this.a = tVar;
        this.b = fVarArr;
        this.c = d0Var;
    }

    @Override // f.b.a.c.i.d
    public void a(h hVar) {
        int i2;
        t tVar = this.a;
        f[] fVarArr = this.b;
        d0 d0Var = this.c;
        n0.f<String> fVar = t.f3425f;
        fVarArr[0] = (f) hVar.l();
        f fVar2 = fVarArr[0];
        q qVar = new q(tVar, d0Var, fVarArr);
        Objects.requireNonNull(tVar);
        n0 n0Var = new n0();
        n0Var.h(t.f3425f, "gl-java/ fire/21.6.0 grpc/");
        n0Var.h(t.f3426g, tVar.f3427d);
        c0 c0Var = tVar.f3428e;
        if (c0Var != null) {
            l lVar = (l) c0Var;
            if (!(lVar.a.get() == null || lVar.b.get() == null || (i2 = lVar.a.get().a("fire-fst").b) == 0)) {
                n0Var.h(l.c, Integer.toString(i2));
                n0Var.h(l.f3402d, lVar.b.get().a());
            }
        }
        fVar2.d(qVar, n0Var);
        b.c cVar = (b.c) d0Var;
        cVar.a.a(new e(cVar));
        fVarArr[0].b(1);
    }
}
