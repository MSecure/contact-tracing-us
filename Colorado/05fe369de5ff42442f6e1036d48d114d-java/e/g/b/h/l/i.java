package e.g.b.h.l;

import e.g.b.h.d;
import e.g.b.h.f;

public class i extends o {
    public i(d dVar) {
        super(dVar);
        dVar.f1097d.f();
        dVar.f1098e.f();
        this.f1147f = ((f) dVar).p0;
    }

    @Override // e.g.b.h.l.o, e.g.b.h.l.d
    public void a(d dVar) {
        f fVar = this.f1149h;
        if (fVar.c && !fVar.f1129j) {
            this.f1149h.c((int) ((((float) fVar.f1131l.get(0).f1126g) * ((f) this.b).l0) + 0.5f));
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
            f fVar2 = this.f1149h;
            if (i2 != -1) {
                fVar2.f1131l.add(dVar.P.f1097d.f1149h);
                this.b.P.f1097d.f1149h.f1130k.add(this.f1149h);
                this.f1149h.f1125f = i2;
            } else if (i3 != -1) {
                fVar2.f1131l.add(dVar.P.f1097d.f1150i);
                this.b.P.f1097d.f1150i.f1130k.add(this.f1149h);
                this.f1149h.f1125f = -i3;
            } else {
                fVar2.b = true;
                fVar2.f1131l.add(dVar.P.f1097d.f1150i);
                this.b.P.f1097d.f1150i.f1130k.add(this.f1149h);
            }
            m(this.b.f1097d.f1149h);
            oVar = this.b.f1097d;
        } else {
            f fVar3 = this.f1149h;
            if (i2 != -1) {
                fVar3.f1131l.add(dVar.P.f1098e.f1149h);
                this.b.P.f1098e.f1149h.f1130k.add(this.f1149h);
                this.f1149h.f1125f = i2;
            } else if (i3 != -1) {
                fVar3.f1131l.add(dVar.P.f1098e.f1150i);
                this.b.P.f1098e.f1150i.f1130k.add(this.f1149h);
                this.f1149h.f1125f = -i3;
            } else {
                fVar3.b = true;
                fVar3.f1131l.add(dVar.P.f1098e.f1150i);
                this.b.P.f1098e.f1150i.f1130k.add(this.f1149h);
            }
            m(this.b.f1098e.f1149h);
            oVar = this.b.f1098e;
        }
        m(oVar.f1150i);
    }

    @Override // e.g.b.h.l.o
    public void e() {
        d dVar = this.b;
        if (((f) dVar).p0 == 1) {
            dVar.U = this.f1149h.f1126g;
        } else {
            dVar.V = this.f1149h.f1126g;
        }
    }

    @Override // e.g.b.h.l.o
    public void f() {
        this.f1149h.b();
    }

    @Override // e.g.b.h.l.o
    public boolean k() {
        return false;
    }

    public final void m(f fVar) {
        this.f1149h.f1130k.add(fVar);
        fVar.f1131l.add(this.f1149h);
    }
}
