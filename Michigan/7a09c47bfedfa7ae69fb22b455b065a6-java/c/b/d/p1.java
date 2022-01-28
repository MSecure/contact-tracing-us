package c.b.d;

import b.x.t;
import c.b.d.f0;
import c.b.d.k0;
import c.b.d.q0;
import c.b.d.x2;
import java.util.Iterator;
import java.util.Map;

public final class p1<T> implements d2<T> {

    /* renamed from: a  reason: collision with root package name */
    public final i1 f5462a;

    /* renamed from: b  reason: collision with root package name */
    public final p2<?, ?> f5463b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5464c;

    /* renamed from: d  reason: collision with root package name */
    public final a0<?> f5465d;

    public p1(p2<?, ?> p2Var, a0<?> a0Var, i1 i1Var) {
        this.f5463b = p2Var;
        this.f5464c = a0Var.e(i1Var);
        this.f5465d = a0Var;
        this.f5462a = i1Var;
    }

    @Override // c.b.d.d2
    public void a(T t, T t2) {
        f2.D(this.f5463b, t, t2);
        if (this.f5464c) {
            a0<?> a0Var = this.f5465d;
            f0<?> c2 = a0Var.c(t2);
            if (!c2.s()) {
                a0Var.d(t).y(c2);
            }
        }
    }

    @Override // c.b.d.d2
    public boolean b(T t, T t2) {
        if (!this.f5463b.g(t).equals(this.f5463b.g(t2))) {
            return false;
        }
        if (this.f5464c) {
            return this.f5465d.c(t).equals(this.f5465d.c(t2));
        }
        return true;
    }

    @Override // c.b.d.d2
    public T c() {
        return (T) this.f5462a.newBuilderForType().buildPartial();
    }

    @Override // c.b.d.d2
    public int d(T t) {
        int hashCode = this.f5463b.g(t).hashCode();
        return this.f5464c ? (hashCode * 53) + this.f5465d.c(t).hashCode() : hashCode;
    }

    @Override // c.b.d.d2
    public final boolean e(T t) {
        return this.f5465d.c(t).t();
    }

    @Override // c.b.d.d2
    public int f(T t) {
        p2<?, ?> p2Var = this.f5463b;
        int i = p2Var.i(p2Var.g(t)) + 0;
        return this.f5464c ? i + this.f5465d.c(t).l() : i;
    }

    @Override // c.b.d.d2
    public void g(T t) {
        this.f5463b.j(t);
        this.f5465d.f(t);
    }

    @Override // c.b.d.d2
    public void h(T t, b2 b2Var, z zVar) {
        p2<UT, UB> p2Var = (p2<UT, UB>) this.f5463b;
        a0<ET> a0Var = (a0<ET>) this.f5465d;
        UB f2 = p2Var.f(t);
        f0<ET> d2 = a0Var.d(t);
        do {
            try {
                if (b2Var.G() == Integer.MAX_VALUE) {
                    break;
                }
            } finally {
                p2Var.n(t, f2);
            }
        } while (k(b2Var, zVar, a0Var, d2, p2Var, f2));
    }

    @Override // c.b.d.d2
    public void i(T t, byte[] bArr, int i, int i2, f fVar) {
        T t2 = t;
        r2 r2Var = t2.f5348b;
        if (r2Var == r2.f5781f) {
            r2Var = r2.b();
            t2.f5348b = r2Var;
        }
        t.k();
        k0.d dVar = null;
        while (i < i2) {
            int Y0 = t.Y0(bArr, i, fVar);
            int i3 = fVar.f5257a;
            if (i3 == 11) {
                int i4 = 0;
                j jVar = null;
                while (Y0 < i2) {
                    Y0 = t.Y0(bArr, Y0, fVar);
                    int i5 = fVar.f5257a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (dVar != null) {
                                z1 z1Var = z1.f5964c;
                                throw null;
                            } else if (i7 == 2) {
                                Y0 = t.i0(bArr, Y0, fVar);
                                jVar = (j) fVar.f5259c;
                            }
                        }
                    } else if (i7 == 0) {
                        Y0 = t.Y0(bArr, Y0, fVar);
                        i4 = fVar.f5257a;
                        dVar = (k0.d) this.f5465d.b(fVar.f5260d, this.f5462a, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    Y0 = t.N2(i5, bArr, Y0, i2, fVar);
                }
                if (jVar != null) {
                    r2Var.c((i4 << 3) | 2, jVar);
                }
                i = Y0;
            } else if ((i3 & 7) == 2) {
                dVar = (k0.d) this.f5465d.b(fVar.f5260d, this.f5462a, i3 >>> 3);
                if (dVar == null) {
                    i = t.U0(i3, bArr, Y0, i2, r2Var, fVar);
                } else {
                    z1 z1Var2 = z1.f5964c;
                    throw null;
                }
            } else {
                i = t.N2(i3, bArr, Y0, i2, fVar);
            }
        }
        if (i != i2) {
            throw o0.g();
        }
    }

    @Override // c.b.d.d2
    public void j(T t, y2 y2Var) {
        Iterator<Map.Entry<?, Object>> w = this.f5465d.c(t).w();
        while (w.hasNext()) {
            Map.Entry<?, Object> next = w.next();
            f0.c cVar = (f0.c) next.getKey();
            if (cVar.j() != x2.c.MESSAGE || cVar.e() || cVar.l()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            ((n) y2Var).i(cVar.a(), next instanceof q0.b ? ((q0.b) next).f5480b.getValue().b() : next.getValue());
        }
        p2<?, ?> p2Var = this.f5463b;
        p2Var.r(p2Var.g(t), y2Var);
    }

    public final <UT, UB, ET extends f0.c<ET>> boolean k(b2 b2Var, z zVar, a0<ET> a0Var, f0<ET> f0Var, p2<UT, UB> p2Var, UB ub) {
        int i = b2Var.i();
        if (i == 11) {
            int i2 = 0;
            Object obj = null;
            j jVar = null;
            while (b2Var.G() != Integer.MAX_VALUE) {
                int i3 = b2Var.i();
                if (i3 == 16) {
                    i2 = b2Var.g();
                    obj = a0Var.b(zVar, this.f5462a, i2);
                } else if (i3 == 26) {
                    if (obj != null) {
                        a0Var.h(b2Var, obj, zVar, f0Var);
                    } else {
                        jVar = b2Var.c();
                    }
                } else if (!b2Var.n()) {
                    break;
                }
            }
            if (b2Var.i() == 12) {
                if (jVar != null) {
                    if (obj != null) {
                        a0Var.i(jVar, obj, zVar, f0Var);
                    } else {
                        p2Var.d(ub, i2, jVar);
                    }
                }
                return true;
            }
            throw o0.a();
        } else if ((i & 7) != 2) {
            return b2Var.n();
        } else {
            Object b2 = a0Var.b(zVar, this.f5462a, i >>> 3);
            if (b2 == null) {
                return p2Var.l(ub, b2Var);
            }
            a0Var.h(b2Var, b2, zVar, f0Var);
            return true;
        }
    }
}
