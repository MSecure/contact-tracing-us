package e.g.b.h.l;

import e.g.b.h.d;
import e.g.b.h.f;

public class i extends o {
    public i(d dVar) {
        super(dVar);
        dVar.f1286d.f();
        dVar.f1287e.f();
        this.f1336f = ((f) dVar).p0;
    }

    @Override // e.g.b.h.l.o, e.g.b.h.l.d
    public void a(d dVar) {
        f fVar = this.f1338h;
        if (fVar.c && !fVar.f1318j) {
            this.f1338h.c((int) ((((float) fVar.f1320l.get(0).f1315g) * ((f) this.b).l0) + 0.5f));
        }
    }

    @Override // e.g.b.h.l.o
    public void d() {
        o oVar;
        d dVar = this.b;
        f fVar = (f) dVar;
        int i2 = fVar.m0;
        int i3 = fVar.n0;
        if (fVar.p0 == 1) {
            f fVar2 = this.f1338h;
            if (i2 != -1) {
                fVar2.f1320l.add(dVar.P.f1286d.f1338h);
                this.b.P.f1286d.f1338h.f1319k.add(this.f1338h);
                this.f1338h.f1314f = i2;
            } else if (i3 != -1) {
                fVar2.f1320l.add(dVar.P.f1286d.f1339i);
                this.b.P.f1286d.f1339i.f1319k.add(this.f1338h);
                this.f1338h.f1314f = -i3;
            } else {
                fVar2.b = true;
                fVar2.f1320l.add(dVar.P.f1286d.f1339i);
                this.b.P.f1286d.f1339i.f1319k.add(this.f1338h);
            }
            m(this.b.f1286d.f1338h);
            oVar = this.b.f1286d;
        } else {
            f fVar3 = this.f1338h;
            if (i2 != -1) {
                fVar3.f1320l.add(dVar.P.f1287e.f1338h);
                this.b.P.f1287e.f1338h.f1319k.add(this.f1338h);
                this.f1338h.f1314f = i2;
            } else if (i3 != -1) {
                fVar3.f1320l.add(dVar.P.f1287e.f1339i);
                this.b.P.f1287e.f1339i.f1319k.add(this.f1338h);
                this.f1338h.f1314f = -i3;
            } else {
                fVar3.b = true;
                fVar3.f1320l.add(dVar.P.f1287e.f1339i);
                this.b.P.f1287e.f1339i.f1319k.add(this.f1338h);
            }
            m(this.b.f1287e.f1338h);
            oVar = this.b.f1287e;
        }
        m(oVar.f1339i);
    }

    @Override // e.g.b.h.l.o
    public void e() {
        d dVar = this.b;
        if (((f) dVar).p0 == 1) {
            dVar.U = this.f1338h.f1315g;
        } else {
            dVar.V = this.f1338h.f1315g;
        }
    }

    @Override // e.g.b.h.l.o
    public void f() {
        this.f1338h.b();
    }

    @Override // e.g.b.h.l.o
    public boolean k() {
        return false;
    }

    public final void m(f fVar) {
        this.f1338h.f1319k.add(fVar);
        fVar.f1320l.add(this.f1338h);
    }
}
