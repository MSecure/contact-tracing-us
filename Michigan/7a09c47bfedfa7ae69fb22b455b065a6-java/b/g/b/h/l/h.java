package b.g.b.h.l;

import b.g.b.h.d;
import b.g.b.h.f;

public class h extends m {
    public h(d dVar) {
        super(dVar);
        dVar.f1514d.f();
        dVar.f1515e.f();
        this.f1562f = ((f) dVar).h0;
    }

    @Override // b.g.b.h.l.d, b.g.b.h.l.m
    public void a(d dVar) {
        f fVar = this.h;
        if (fVar.f1543c && !fVar.j) {
            this.h.c((int) ((((float) fVar.l.get(0).f1547g) * ((f) this.f1558b).d0) + 0.5f));
        }
    }

    @Override // b.g.b.h.l.m
    public void d() {
        m mVar;
        d dVar = this.f1558b;
        f fVar = (f) dVar;
        int i = fVar.e0;
        int i2 = fVar.f0;
        if (fVar.h0 == 1) {
            f fVar2 = this.h;
            if (i != -1) {
                fVar2.l.add(dVar.I.f1514d.h);
                this.f1558b.I.f1514d.h.k.add(this.h);
                this.h.f1546f = i;
            } else if (i2 != -1) {
                fVar2.l.add(dVar.I.f1514d.i);
                this.f1558b.I.f1514d.i.k.add(this.h);
                this.h.f1546f = -i2;
            } else {
                fVar2.f1542b = true;
                fVar2.l.add(dVar.I.f1514d.i);
                this.f1558b.I.f1514d.i.k.add(this.h);
            }
            m(this.f1558b.f1514d.h);
            mVar = this.f1558b.f1514d;
        } else {
            f fVar3 = this.h;
            if (i != -1) {
                fVar3.l.add(dVar.I.f1515e.h);
                this.f1558b.I.f1515e.h.k.add(this.h);
                this.h.f1546f = i;
            } else if (i2 != -1) {
                fVar3.l.add(dVar.I.f1515e.i);
                this.f1558b.I.f1515e.i.k.add(this.h);
                this.h.f1546f = -i2;
            } else {
                fVar3.f1542b = true;
                fVar3.l.add(dVar.I.f1515e.i);
                this.f1558b.I.f1515e.i.k.add(this.h);
            }
            m(this.f1558b.f1515e.h);
            mVar = this.f1558b.f1515e;
        }
        m(mVar.i);
    }

    @Override // b.g.b.h.l.m
    public void e() {
        d dVar = this.f1558b;
        if (((f) dVar).h0 == 1) {
            dVar.N = this.h.f1547g;
        } else {
            dVar.O = this.h.f1547g;
        }
    }

    @Override // b.g.b.h.l.m
    public void f() {
        this.h.b();
    }

    @Override // b.g.b.h.l.m
    public boolean k() {
        return false;
    }

    public final void m(f fVar) {
        this.h.k.add(fVar);
        fVar.l.add(this.h);
    }
}
