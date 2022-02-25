package e.g.b.h.l;

import e.g.b.h.d;
import e.g.b.h.f;

public class i extends o {
    public i(d dVar) {
        super(dVar);
        dVar.f1273d.f();
        dVar.f1274e.f();
        this.f1323f = ((f) dVar).p0;
    }

    @Override // e.g.b.h.l.o, e.g.b.h.l.d
    public void a(d dVar) {
        f fVar = this.f1325h;
        if (fVar.c && !fVar.f1305j) {
            this.f1325h.c((int) ((((float) fVar.f1307l.get(0).f1302g) * ((f) this.b).l0) + 0.5f));
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
            f fVar2 = this.f1325h;
            if (i2 != -1) {
                fVar2.f1307l.add(dVar.P.f1273d.f1325h);
                this.b.P.f1273d.f1325h.f1306k.add(this.f1325h);
                this.f1325h.f1301f = i2;
            } else if (i3 != -1) {
                fVar2.f1307l.add(dVar.P.f1273d.f1326i);
                this.b.P.f1273d.f1326i.f1306k.add(this.f1325h);
                this.f1325h.f1301f = -i3;
            } else {
                fVar2.b = true;
                fVar2.f1307l.add(dVar.P.f1273d.f1326i);
                this.b.P.f1273d.f1326i.f1306k.add(this.f1325h);
            }
            m(this.b.f1273d.f1325h);
            oVar = this.b.f1273d;
        } else {
            f fVar3 = this.f1325h;
            if (i2 != -1) {
                fVar3.f1307l.add(dVar.P.f1274e.f1325h);
                this.b.P.f1274e.f1325h.f1306k.add(this.f1325h);
                this.f1325h.f1301f = i2;
            } else if (i3 != -1) {
                fVar3.f1307l.add(dVar.P.f1274e.f1326i);
                this.b.P.f1274e.f1326i.f1306k.add(this.f1325h);
                this.f1325h.f1301f = -i3;
            } else {
                fVar3.b = true;
                fVar3.f1307l.add(dVar.P.f1274e.f1326i);
                this.b.P.f1274e.f1326i.f1306k.add(this.f1325h);
            }
            m(this.b.f1274e.f1325h);
            oVar = this.b.f1274e;
        }
        m(oVar.f1326i);
    }

    @Override // e.g.b.h.l.o
    public void e() {
        d dVar = this.b;
        if (((f) dVar).p0 == 1) {
            dVar.U = this.f1325h.f1302g;
        } else {
            dVar.V = this.f1325h.f1302g;
        }
    }

    @Override // e.g.b.h.l.o
    public void f() {
        this.f1325h.b();
    }

    @Override // e.g.b.h.l.o
    public boolean k() {
        return false;
    }

    public final void m(f fVar) {
        this.f1325h.f1306k.add(fVar);
        fVar.f1307l.add(this.f1325h);
    }
}
