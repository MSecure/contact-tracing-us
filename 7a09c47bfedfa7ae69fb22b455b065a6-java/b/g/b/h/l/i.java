package b.g.b.h.l;

import b.g.b.h.a;
import b.g.b.h.d;
import b.g.b.h.l.f;

public class i extends m {
    public i(d dVar) {
        super(dVar);
    }

    @Override // b.g.b.h.l.d, b.g.b.h.l.m
    public void a(d dVar) {
        a aVar = (a) this.f1558b;
        int i = aVar.f0;
        int i2 = 0;
        int i3 = -1;
        for (f fVar : this.h.l) {
            int i4 = fVar.f1547g;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (i == 0 || i == 2) {
            this.h.c(i3 + aVar.h0);
        } else {
            this.h.c(i2 + aVar.h0);
        }
    }

    @Override // b.g.b.h.l.m
    public void d() {
        m mVar;
        d dVar = this.f1558b;
        if (dVar instanceof a) {
            f fVar = this.h;
            fVar.f1542b = true;
            a aVar = (a) dVar;
            int i = aVar.f0;
            boolean z = aVar.g0;
            int i2 = 0;
            if (i == 0) {
                fVar.f1545e = f.a.LEFT;
                while (i2 < aVar.e0) {
                    d dVar2 = aVar.d0[i2];
                    if (z || dVar2.V != 8) {
                        f fVar2 = dVar2.f1514d.h;
                        fVar2.k.add(this.h);
                        this.h.l.add(fVar2);
                    }
                    i2++;
                }
            } else if (i != 1) {
                if (i == 2) {
                    fVar.f1545e = f.a.TOP;
                    while (i2 < aVar.e0) {
                        d dVar3 = aVar.d0[i2];
                        if (z || dVar3.V != 8) {
                            f fVar3 = dVar3.f1515e.h;
                            fVar3.k.add(this.h);
                            this.h.l.add(fVar3);
                        }
                        i2++;
                    }
                } else if (i == 3) {
                    fVar.f1545e = f.a.BOTTOM;
                    while (i2 < aVar.e0) {
                        d dVar4 = aVar.d0[i2];
                        if (z || dVar4.V != 8) {
                            f fVar4 = dVar4.f1515e.i;
                            fVar4.k.add(this.h);
                            this.h.l.add(fVar4);
                        }
                        i2++;
                    }
                } else {
                    return;
                }
                m(this.f1558b.f1515e.h);
                mVar = this.f1558b.f1515e;
                m(mVar.i);
            } else {
                fVar.f1545e = f.a.RIGHT;
                while (i2 < aVar.e0) {
                    d dVar5 = aVar.d0[i2];
                    if (z || dVar5.V != 8) {
                        f fVar5 = dVar5.f1514d.i;
                        fVar5.k.add(this.h);
                        this.h.l.add(fVar5);
                    }
                    i2++;
                }
            }
            m(this.f1558b.f1514d.h);
            mVar = this.f1558b.f1514d;
            m(mVar.i);
        }
    }

    @Override // b.g.b.h.l.m
    public void e() {
        d dVar = this.f1558b;
        if (dVar instanceof a) {
            int i = ((a) dVar).f0;
            if (i == 0 || i == 1) {
                this.f1558b.N = this.h.f1547g;
                return;
            }
            dVar.O = this.h.f1547g;
        }
    }

    @Override // b.g.b.h.l.m
    public void f() {
        this.f1559c = null;
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
