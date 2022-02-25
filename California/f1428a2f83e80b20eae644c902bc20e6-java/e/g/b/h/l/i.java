package e.g.b.h.l;

import e.g.b.h.d;
import e.g.b.h.f;

public class i extends o {
    public i(d dVar) {
        super(dVar);
        dVar.f1274d.f();
        dVar.f1275e.f();
        this.f1324f = ((f) dVar).p0;
    }

    @Override // e.g.b.h.l.o, e.g.b.h.l.d
    public void a(d dVar) {
        f fVar = this.f1326h;
        if (fVar.c && !fVar.f1306j) {
            this.f1326h.c((int) ((((float) fVar.f1308l.get(0).f1303g) * ((f) this.b).l0) + 0.5f));
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
            f fVar2 = this.f1326h;
            if (i2 != -1) {
                fVar2.f1308l.add(dVar.P.f1274d.f1326h);
                this.b.P.f1274d.f1326h.f1307k.add(this.f1326h);
                this.f1326h.f1302f = i2;
            } else if (i3 != -1) {
                fVar2.f1308l.add(dVar.P.f1274d.f1327i);
                this.b.P.f1274d.f1327i.f1307k.add(this.f1326h);
                this.f1326h.f1302f = -i3;
            } else {
                fVar2.b = true;
                fVar2.f1308l.add(dVar.P.f1274d.f1327i);
                this.b.P.f1274d.f1327i.f1307k.add(this.f1326h);
            }
            m(this.b.f1274d.f1326h);
            oVar = this.b.f1274d;
        } else {
            f fVar3 = this.f1326h;
            if (i2 != -1) {
                fVar3.f1308l.add(dVar.P.f1275e.f1326h);
                this.b.P.f1275e.f1326h.f1307k.add(this.f1326h);
                this.f1326h.f1302f = i2;
            } else if (i3 != -1) {
                fVar3.f1308l.add(dVar.P.f1275e.f1327i);
                this.b.P.f1275e.f1327i.f1307k.add(this.f1326h);
                this.f1326h.f1302f = -i3;
            } else {
                fVar3.b = true;
                fVar3.f1308l.add(dVar.P.f1275e.f1327i);
                this.b.P.f1275e.f1327i.f1307k.add(this.f1326h);
            }
            m(this.b.f1275e.f1326h);
            oVar = this.b.f1275e;
        }
        m(oVar.f1327i);
    }

    @Override // e.g.b.h.l.o
    public void e() {
        d dVar = this.b;
        if (((f) dVar).p0 == 1) {
            dVar.U = this.f1326h.f1303g;
        } else {
            dVar.V = this.f1326h.f1303g;
        }
    }

    @Override // e.g.b.h.l.o
    public void f() {
        this.f1326h.b();
    }

    @Override // e.g.b.h.l.o
    public boolean k() {
        return false;
    }

    public final void m(f fVar) {
        this.f1326h.f1307k.add(fVar);
        fVar.f1308l.add(this.f1326h);
    }
}
