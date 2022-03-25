package e.g.b.h.l;

import e.g.b.h.l.f;

public class g extends f {
    public int m;

    public g(o oVar) {
        super(oVar);
        this.f1313e = oVar instanceof k ? f.a.HORIZONTAL_DIMENSION : f.a.VERTICAL_DIMENSION;
    }

    @Override // e.g.b.h.l.f
    public void c(int i2) {
        if (!this.f1318j) {
            this.f1318j = true;
            this.f1315g = i2;
            for (d dVar : this.f1319k) {
                dVar.a(dVar);
            }
        }
    }
}
