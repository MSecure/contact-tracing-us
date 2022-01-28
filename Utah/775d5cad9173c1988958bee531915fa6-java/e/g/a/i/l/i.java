package e.g.a.i.l;

import e.g.a.i.d;
import e.g.a.i.f;

public class i extends o {
    public i(d dVar) {
        super(dVar);
        dVar.f1307d.f();
        dVar.f1308e.f();
        this.f1357f = ((f) dVar).u0;
    }

    @Override // e.g.a.i.l.d, e.g.a.i.l.o
    public void a(d dVar) {
        f fVar = this.f1359h;
        if (fVar.c && !fVar.f1339j) {
            this.f1359h.c((int) ((((float) fVar.f1341l.get(0).f1336g) * ((f) this.b).q0) + 0.5f));
        }
    }

    @Override // e.g.a.i.l.o
    public void d() {
        o oVar;
        d dVar = this.b;
        f fVar = (f) dVar;
        int i2 = fVar.r0;
        int i3 = fVar.s0;
        if (fVar.u0 == 1) {
            f fVar2 = this.f1359h;
            if (i2 != -1) {
                fVar2.f1341l.add(dVar.U.f1307d.f1359h);
                this.b.U.f1307d.f1359h.f1340k.add(this.f1359h);
                this.f1359h.f1335f = i2;
            } else if (i3 != -1) {
                fVar2.f1341l.add(dVar.U.f1307d.f1360i);
                this.b.U.f1307d.f1360i.f1340k.add(this.f1359h);
                this.f1359h.f1335f = -i3;
            } else {
                fVar2.b = true;
                fVar2.f1341l.add(dVar.U.f1307d.f1360i);
                this.b.U.f1307d.f1360i.f1340k.add(this.f1359h);
            }
            m(this.b.f1307d.f1359h);
            oVar = this.b.f1307d;
        } else {
            f fVar3 = this.f1359h;
            if (i2 != -1) {
                fVar3.f1341l.add(dVar.U.f1308e.f1359h);
                this.b.U.f1308e.f1359h.f1340k.add(this.f1359h);
                this.f1359h.f1335f = i2;
            } else if (i3 != -1) {
                fVar3.f1341l.add(dVar.U.f1308e.f1360i);
                this.b.U.f1308e.f1360i.f1340k.add(this.f1359h);
                this.f1359h.f1335f = -i3;
            } else {
                fVar3.b = true;
                fVar3.f1341l.add(dVar.U.f1308e.f1360i);
                this.b.U.f1308e.f1360i.f1340k.add(this.f1359h);
            }
            m(this.b.f1308e.f1359h);
            oVar = this.b.f1308e;
        }
        m(oVar.f1360i);
    }

    @Override // e.g.a.i.l.o
    public void e() {
        d dVar = this.b;
        if (((f) dVar).u0 == 1) {
            dVar.Z = this.f1359h.f1336g;
        } else {
            dVar.a0 = this.f1359h.f1336g;
        }
    }

    @Override // e.g.a.i.l.o
    public void f() {
        this.f1359h.b();
    }

    @Override // e.g.a.i.l.o
    public boolean k() {
        return false;
    }

    public final void m(f fVar) {
        this.f1359h.f1340k.add(fVar);
        fVar.f1341l.add(this.f1359h);
    }
}
