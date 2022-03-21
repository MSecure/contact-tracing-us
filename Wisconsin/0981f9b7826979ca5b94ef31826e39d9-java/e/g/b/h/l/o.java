package e.g.b.h.l;

import e.g.b.h.c;
import e.g.b.h.d;

public abstract class o implements d {
    public int a;
    public d b;
    public l c;

    /* renamed from: d  reason: collision with root package name */
    public d.a f1321d;

    /* renamed from: e  reason: collision with root package name */
    public g f1322e = new g(this);

    /* renamed from: f  reason: collision with root package name */
    public int f1323f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1324g = false;

    /* renamed from: h  reason: collision with root package name */
    public f f1325h = new f(this);

    /* renamed from: i  reason: collision with root package name */
    public f f1326i = new f(this);

    /* renamed from: j  reason: collision with root package name */
    public a f1327j = a.NONE;

    public enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public o(d dVar) {
        this.b = dVar;
    }

    @Override // e.g.b.h.l.d
    public void a(d dVar) {
    }

    public final void b(f fVar, f fVar2, int i2) {
        fVar.f1307l.add(fVar2);
        fVar.f1301f = i2;
        fVar2.f1306k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i2, g gVar) {
        fVar.f1307l.add(fVar2);
        fVar.f1307l.add(this.f1322e);
        fVar.f1303h = i2;
        fVar.f1304i = gVar;
        fVar2.f1306k.add(fVar);
        gVar.f1306k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i2, int i3) {
        int i4;
        if (i3 == 0) {
            d dVar = this.b;
            int i5 = dVar.p;
            i4 = Math.max(dVar.o, i2);
            if (i5 > 0) {
                i4 = Math.min(i5, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        } else {
            d dVar2 = this.b;
            int i6 = dVar2.s;
            i4 = Math.max(dVar2.r, i2);
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
        c cVar2 = cVar.f1261f;
        if (cVar2 == null) {
            return null;
        }
        d dVar = cVar2.f1259d;
        int ordinal = cVar2.f1260e.ordinal();
        if (ordinal == 1) {
            oVar = dVar.f1273d;
        } else if (ordinal != 2) {
            if (ordinal == 3) {
                oVar2 = dVar.f1273d;
            } else if (ordinal == 4) {
                oVar2 = dVar.f1274e;
            } else if (ordinal != 5) {
                return null;
            } else {
                return dVar.f1274e.f1316k;
            }
            return oVar2.f1326i;
        } else {
            oVar = dVar.f1274e;
        }
        return oVar.f1325h;
    }

    public final f i(c cVar, int i2) {
        c cVar2 = cVar.f1261f;
        if (cVar2 == null) {
            return null;
        }
        d dVar = cVar2.f1259d;
        o oVar = i2 == 0 ? dVar.f1273d : dVar.f1274e;
        int ordinal = cVar2.f1260e.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return oVar.f1325h;
        }
        if (ordinal == 3 || ordinal == 4) {
            return oVar.f1326i;
        }
        return null;
    }

    public long j() {
        g gVar = this.f1322e;
        if (gVar.f1305j) {
            return (long) gVar.f1302g;
        }
        return 0;
    }

    public abstract boolean k();

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (r14.a == 3) goto L_0x00b5;
     */
    public void l(c cVar, c cVar2, int i2) {
        float f2;
        d.a aVar;
        int i3;
        int i4;
        f h2 = h(cVar);
        f h3 = h(cVar2);
        if (h2.f1305j && h3.f1305j) {
            int d2 = cVar.d() + h2.f1302g;
            int d3 = h3.f1302g - cVar2.d();
            int i5 = d3 - d2;
            g gVar = this.f1322e;
            if (!gVar.f1305j && this.f1321d == (aVar = d.a.MATCH_CONSTRAINT)) {
                int i6 = this.a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        int g2 = g(gVar.m, i2);
                        g gVar2 = this.f1322e;
                        i3 = Math.min(g2, i5);
                        gVar = gVar2;
                    } else if (i6 == 2) {
                        d dVar = this.b;
                        d dVar2 = dVar.P;
                        if (dVar2 != null) {
                            g gVar3 = (i2 == 0 ? dVar2.f1273d : dVar2.f1274e).f1322e;
                            if (gVar3.f1305j) {
                                i4 = (int) ((((float) gVar3.f1302g) * (i2 == 0 ? dVar.q : dVar.t)) + 0.5f);
                            }
                        }
                    } else if (i6 == 3) {
                        d dVar3 = this.b;
                        o oVar = dVar3.f1273d;
                        if (oVar.f1321d == aVar && oVar.a == 3) {
                            m mVar = dVar3.f1274e;
                            if (mVar.f1321d == aVar) {
                            }
                        }
                        if (i2 == 0) {
                            oVar = dVar3.f1274e;
                        }
                        g gVar4 = oVar.f1322e;
                        if (gVar4.f1305j) {
                            float f3 = dVar3.S;
                            i3 = i2 == 1 ? (int) ((((float) gVar4.f1302g) / f3) + 0.5f) : (int) ((f3 * ((float) gVar4.f1302g)) + 0.5f);
                        }
                    }
                    gVar.c(i3);
                } else {
                    i4 = i5;
                }
                i3 = g(i4, i2);
                gVar.c(i3);
            }
            g gVar5 = this.f1322e;
            if (gVar5.f1305j) {
                int i7 = gVar5.f1302g;
                if (i7 == i5) {
                    this.f1325h.c(d2);
                    this.f1326i.c(d3);
                    return;
                }
                if (i2 == 0) {
                    f2 = this.b.Z;
                } else {
                    f2 = this.b.a0;
                }
                if (h2 == h3) {
                    d2 = h2.f1302g;
                    d3 = h3.f1302g;
                    f2 = 0.5f;
                }
                this.f1325h.c((int) ((((float) ((d3 - d2) - i7)) * f2) + ((float) d2) + 0.5f));
                this.f1326i.c(this.f1325h.f1302g + this.f1322e.f1302g);
            }
        }
    }
}
