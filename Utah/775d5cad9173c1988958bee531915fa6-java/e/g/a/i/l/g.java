package e.g.a.i.l;

import e.g.a.i.l.f;

public class g extends f {
    public int m;

    public g(o oVar) {
        super(oVar);
        this.f1334e = oVar instanceof k ? f.a.HORIZONTAL_DIMENSION : f.a.VERTICAL_DIMENSION;
    }

    @Override // e.g.a.i.l.f
    public void c(int i2) {
        if (!this.f1339j) {
            this.f1339j = true;
            this.f1336g = i2;
            for (d dVar : this.f1340k) {
                dVar.a(dVar);
            }
        }
    }
}
