package b.g.b.h.l;

import b.g.b.h.l.f;

public class g extends f {
    public int m;

    public g(m mVar) {
        super(mVar);
        this.f1545e = mVar instanceof j ? f.a.HORIZONTAL_DIMENSION : f.a.VERTICAL_DIMENSION;
    }

    @Override // b.g.b.h.l.f
    public void c(int i) {
        if (!this.j) {
            this.j = true;
            this.f1547g = i;
            for (d dVar : this.k) {
                dVar.a(dVar);
            }
        }
    }
}
