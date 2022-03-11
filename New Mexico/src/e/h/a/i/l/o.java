package e.h.a.i.l;

import e.h.a.i.c;
import e.h.a.i.d;
/* loaded from: classes.dex */
public abstract class o implements d {
    public int a;
    public d b;
    public l c;

    /* renamed from: d */
    public d.a f1439d;

    /* renamed from: e */
    public g f1440e = new g(this);

    /* renamed from: f */
    public int f1441f = 0;

    /* renamed from: g */
    public boolean f1442g = false;

    /* renamed from: h */
    public f f1443h = new f(this);

    /* renamed from: i */
    public f f1444i = new f(this);

    /* renamed from: j */
    public a f1445j = a.NONE;

    /* loaded from: classes.dex */
    public enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public o(d dVar) {
        this.b = dVar;
    }

    @Override // e.h.a.i.l.d
    public void a(d dVar) {
    }

    public final void b(f fVar, f fVar2, int i2) {
        fVar.f1425l.add(fVar2);
        fVar.f1419f = i2;
        fVar2.f1424k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i2, g gVar) {
        fVar.f1425l.add(fVar2);
        fVar.f1425l.add(this.f1440e);
        fVar.f1421h = i2;
        fVar.f1422i = gVar;
        fVar2.f1424k.add(fVar);
        gVar.f1424k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i2, int i3) {
        int i4;
        if (i3 == 0) {
            d dVar = this.b;
            int i5 = dVar.u;
            i4 = Math.max(dVar.t, i2);
            if (i5 > 0) {
                i4 = Math.min(i5, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        } else {
            d dVar2 = this.b;
            int i6 = dVar2.x;
            i4 = Math.max(dVar2.w, i2);
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
        o oVar;
        o oVar2;
        c cVar2 = cVar.f1379f;
        if (cVar2 == null) {
            return null;
        }
        d dVar = cVar2.f1377d;
        int ordinal = cVar2.f1378e.ordinal();
        if (ordinal == 1) {
            oVar = dVar.f1391d;
        } else if (ordinal != 2) {
            if (ordinal == 3) {
                oVar2 = dVar.f1391d;
            } else if (ordinal == 4) {
                oVar2 = dVar.f1392e;
            } else if (ordinal != 5) {
                return null;
            } else {
                return dVar.f1392e.f1434k;
            }
            return oVar2.f1444i;
        } else {
            oVar = dVar.f1392e;
        }
        return oVar.f1443h;
    }

    public final f i(c cVar, int i2) {
        c cVar2 = cVar.f1379f;
        if (cVar2 == null) {
            return null;
        }
        d dVar = cVar2.f1377d;
        o oVar = i2 == 0 ? dVar.f1391d : dVar.f1392e;
        int ordinal = cVar2.f1378e.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return oVar.f1443h;
        }
        if (ordinal == 3 || ordinal == 4) {
            return oVar.f1444i;
        }
        return null;
    }

    public long j() {
        g gVar = this.f1440e;
        if (gVar.f1423j) {
            return (long) gVar.f1420g;
        }
        return 0;
    }

    public abstract boolean k();

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
        if (r14.a == 3) goto L_0x00b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void l(c cVar, c cVar2, int i2) {
        float f2;
        d.a aVar;
        int i3;
        int i4;
        f h2 = h(cVar);
        f h3 = h(cVar2);
        if (h2.f1423j && h3.f1423j) {
            int d2 = cVar.d() + h2.f1420g;
            int d3 = h3.f1420g - cVar2.d();
            int i5 = d3 - d2;
            g gVar = this.f1440e;
            if (!gVar.f1423j && this.f1439d == (aVar = d.a.MATCH_CONSTRAINT)) {
                int i6 = this.a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        int g2 = g(gVar.m, i2);
                        gVar = this.f1440e;
                        i3 = Math.min(g2, i5);
                    } else if (i6 == 2) {
                        d dVar = this.b;
                        d dVar2 = dVar.U;
                        if (dVar2 != null) {
                            g gVar2 = (i2 == 0 ? dVar2.f1391d : dVar2.f1392e).f1440e;
                            if (gVar2.f1423j) {
                                i4 = (int) ((((float) gVar2.f1420g) * (i2 == 0 ? dVar.v : dVar.y)) + 0.5f);
                            }
                        }
                    } else if (i6 == 3) {
                        d dVar3 = this.b;
                        o oVar = dVar3.f1391d;
                        if (oVar.f1439d == aVar && oVar.a == 3) {
                            m mVar = dVar3.f1392e;
                            if (mVar.f1439d == aVar) {
                            }
                        }
                        if (i2 == 0) {
                            oVar = dVar3.f1392e;
                        }
                        g gVar3 = oVar.f1440e;
                        if (gVar3.f1423j) {
                            float f3 = dVar3.X;
                            i3 = i2 == 1 ? (int) ((((float) gVar3.f1420g) / f3) + 0.5f) : (int) ((f3 * ((float) gVar3.f1420g)) + 0.5f);
                        }
                    }
                    gVar.c(i3);
                } else {
                    i4 = i5;
                }
                i3 = g(i4, i2);
                gVar.c(i3);
            }
            g gVar4 = this.f1440e;
            if (gVar4.f1423j) {
                int i7 = gVar4.f1420g;
                if (i7 == i5) {
                    this.f1443h.c(d2);
                    this.f1444i.c(d3);
                    return;
                }
                if (i2 == 0) {
                    f2 = this.b.e0;
                } else {
                    f2 = this.b.f0;
                }
                if (h2 == h3) {
                    d2 = h2.f1420g;
                    d3 = h3.f1420g;
                    f2 = 0.5f;
                }
                this.f1443h.c((int) ((((float) ((d3 - d2) - i7)) * f2) + ((float) d2) + 0.5f));
                this.f1444i.c(this.f1443h.f1420g + this.f1440e.f1420g);
            }
        }
    }
}
