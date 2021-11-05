package b.g.b.h.l;

import b.g.b.h.c;
import b.g.b.h.d;

public abstract class m implements d {

    /* renamed from: a  reason: collision with root package name */
    public int f1557a;

    /* renamed from: b  reason: collision with root package name */
    public d f1558b;

    /* renamed from: c  reason: collision with root package name */
    public k f1559c;

    /* renamed from: d  reason: collision with root package name */
    public d.a f1560d;

    /* renamed from: e  reason: collision with root package name */
    public g f1561e = new g(this);

    /* renamed from: f  reason: collision with root package name */
    public int f1562f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1563g = false;
    public f h = new f(this);
    public f i = new f(this);
    public a j = a.NONE;

    public enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public m(d dVar) {
        this.f1558b = dVar;
    }

    @Override // b.g.b.h.l.d
    public void a(d dVar) {
    }

    public final void b(f fVar, f fVar2, int i2) {
        fVar.l.add(fVar2);
        fVar.f1546f = i2;
        fVar2.k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i2, g gVar) {
        fVar.l.add(fVar2);
        fVar.l.add(this.f1561e);
        fVar.h = i2;
        fVar.i = gVar;
        fVar2.k.add(fVar);
        gVar.k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i2, int i3) {
        int i4;
        if (i3 == 0) {
            d dVar = this.f1558b;
            int i5 = dVar.n;
            i4 = Math.max(dVar.m, i2);
            if (i5 > 0) {
                i4 = Math.min(i5, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        } else {
            d dVar2 = this.f1558b;
            int i6 = dVar2.q;
            i4 = Math.max(dVar2.p, i2);
            if (i6 > 0) {
                i4 = Math.min(i6, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        }
        return i4;
    }

    public final f h(c cVar) {
        m mVar;
        m mVar2;
        c cVar2 = cVar.f1501c;
        if (cVar2 == null) {
            return null;
        }
        d dVar = cVar2.f1499a;
        int ordinal = cVar2.f1500b.ordinal();
        if (ordinal == 1) {
            mVar = dVar.f1514d;
        } else if (ordinal != 2) {
            if (ordinal == 3) {
                mVar2 = dVar.f1514d;
            } else if (ordinal == 4) {
                mVar2 = dVar.f1515e;
            } else if (ordinal != 5) {
                return null;
            } else {
                return dVar.f1515e.k;
            }
            return mVar2.i;
        } else {
            mVar = dVar.f1515e;
        }
        return mVar.h;
    }

    public final f i(c cVar, int i2) {
        c cVar2 = cVar.f1501c;
        if (cVar2 == null) {
            return null;
        }
        d dVar = cVar2.f1499a;
        m mVar = i2 == 0 ? dVar.f1514d : dVar.f1515e;
        int ordinal = cVar.f1501c.f1500b.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return mVar.h;
        }
        if (ordinal == 3 || ordinal == 4) {
            return mVar.i;
        }
        return null;
    }

    public long j() {
        g gVar = this.f1561e;
        if (gVar.j) {
            return (long) gVar.f1547g;
        }
        return 0;
    }

    public abstract boolean k();

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r4.f1557a == 3) goto L_0x00b7;
     */
    public void l(c cVar, c cVar2, int i2) {
        float f2;
        d.a aVar;
        g gVar;
        int i3;
        int i4;
        f h2 = h(cVar);
        f h3 = h(cVar2);
        if (h2.j && h3.j) {
            int b2 = cVar.b() + h2.f1547g;
            int b3 = h3.f1547g - cVar2.b();
            int i5 = b3 - b2;
            g gVar2 = this.f1561e;
            if (!gVar2.j && this.f1560d == (aVar = d.a.MATCH_CONSTRAINT)) {
                int i6 = this.f1557a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        int g2 = g(gVar2.m, i2);
                        gVar = this.f1561e;
                        i3 = Math.min(g2, i5);
                    } else if (i6 == 2) {
                        d dVar = this.f1558b.I;
                        if (dVar != null) {
                            m mVar = i2 == 0 ? dVar.f1514d : dVar.f1515e;
                            if (mVar.f1561e.j) {
                                d dVar2 = this.f1558b;
                                i4 = (int) ((((float) mVar.f1561e.f1547g) * (i2 == 0 ? dVar2.o : dVar2.r)) + 0.5f);
                            }
                        }
                    } else if (i6 == 3) {
                        d dVar3 = this.f1558b;
                        j jVar = dVar3.f1514d;
                        if (jVar.f1560d == aVar && jVar.f1557a == 3) {
                            l lVar = dVar3.f1515e;
                            if (lVar.f1560d == aVar) {
                            }
                        }
                        d dVar4 = this.f1558b;
                        g gVar3 = (i2 == 0 ? dVar4.f1515e : dVar4.f1514d).f1561e;
                        if (gVar3.j) {
                            float f3 = this.f1558b.L;
                            i3 = i2 == 1 ? (int) ((((float) gVar3.f1547g) / f3) + 0.5f) : (int) ((f3 * ((float) gVar3.f1547g)) + 0.5f);
                            gVar = this.f1561e;
                        }
                    }
                    gVar.c(i3);
                } else {
                    i4 = i5;
                }
                gVar = this.f1561e;
                i3 = g(i4, i2);
                gVar.c(i3);
            }
            g gVar4 = this.f1561e;
            if (gVar4.j) {
                if (gVar4.f1547g == i5) {
                    this.h.c(b2);
                    this.i.c(b3);
                    return;
                }
                d dVar5 = this.f1558b;
                if (i2 == 0) {
                    f2 = dVar5.S;
                } else {
                    f2 = dVar5.T;
                }
                if (h2 == h3) {
                    b2 = h2.f1547g;
                    b3 = h3.f1547g;
                    f2 = 0.5f;
                }
                this.h.c((int) ((((float) ((b3 - b2) - this.f1561e.f1547g)) * f2) + ((float) b2) + 0.5f));
                this.i.c(this.h.f1547g + this.f1561e.f1547g);
            }
        }
    }
}
