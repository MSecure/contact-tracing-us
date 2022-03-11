package e.g.b.h.l;

import e.g.b.h.l.f;

public class g extends f {
    public int m;

    public g(o oVar) {
        super(oVar);
        this.f1300e = oVar instanceof k ? f.a.HORIZONTAL_DIMENSION : f.a.VERTICAL_DIMENSION;
    }

    @Override // e.g.b.h.l.f
    public void c(int i2) {
        if (!this.f1305j) {
            this.f1305j = true;
            this.f1302g = i2;
            for (d dVar : this.f1306k) {
                dVar.a(dVar);
            }
        }
    }
}
