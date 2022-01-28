package c.b.d;

import c.b.a.a.c.n.c;
import c.b.d.f0;
import c.b.d.j0;
import c.b.d.p0;
import c.b.d.w2;
import java.util.Iterator;
import java.util.Map;

public final class o1<T> implements c2<T> {

    /* renamed from: a  reason: collision with root package name */
    public final h1 f4018a;

    /* renamed from: b  reason: collision with root package name */
    public final o2<?, ?> f4019b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4020c;

    /* renamed from: d  reason: collision with root package name */
    public final a0<?> f4021d;

    public o1(o2<?, ?> o2Var, a0<?> a0Var, h1 h1Var) {
        this.f4019b = o2Var;
        this.f4020c = a0Var.e(h1Var);
        this.f4021d = a0Var;
        this.f4018a = h1Var;
    }

    @Override // c.b.d.c2
    public void a(T t, T t2) {
        e2.D(this.f4019b, t, t2);
        if (this.f4020c) {
            a0<?> a0Var = this.f4021d;
            f0<?> c2 = a0Var.c(t2);
            if (!c2.s()) {
                a0Var.d(t).y(c2);
            }
        }
    }

    @Override // c.b.d.c2
    public final boolean b(T t) {
        return this.f4021d.c(t).t();
    }

    @Override // c.b.d.c2
    public boolean c(T t, T t2) {
        if (!this.f4019b.g(t).equals(this.f4019b.g(t2))) {
            return false;
        }
        if (this.f4020c) {
            return this.f4021d.c(t).equals(this.f4021d.c(t2));
        }
        return true;
    }

    @Override // c.b.d.c2
    public int d(T t) {
        o2<?, ?> o2Var = this.f4019b;
        int i = o2Var.i(o2Var.g(t)) + 0;
        return this.f4020c ? i + this.f4021d.c(t).l() : i;
    }

    @Override // c.b.d.c2
    public T e() {
        return (T) this.f4018a.newBuilderForType().buildPartial();
    }

    @Override // c.b.d.c2
    public void f(T t) {
        this.f4019b.j(t);
        this.f4021d.f(t);
    }

    @Override // c.b.d.c2
    public int g(T t) {
        int hashCode = this.f4019b.g(t).hashCode();
        return this.f4020c ? (hashCode * 53) + this.f4021d.c(t).hashCode() : hashCode;
    }

    @Override // c.b.d.c2
    public void h(T t, a2 a2Var, z zVar) {
        o2<UT, UB> o2Var = (o2<UT, UB>) this.f4019b;
        a0<ET> a0Var = (a0<ET>) this.f4021d;
        UB f = o2Var.f(t);
        f0<ET> d2 = a0Var.d(t);
        do {
            try {
                if (a2Var.I() == Integer.MAX_VALUE) {
                    break;
                }
            } finally {
                o2Var.n(t, f);
            }
        } while (k(a2Var, zVar, a0Var, d2, o2Var, f));
    }

    @Override // c.b.d.c2
    public void i(T t, byte[] bArr, int i, int i2, f fVar) {
        T t2 = t;
        q2 q2Var = t2.f3921b;
        if (q2Var == q2.f) {
            q2Var = q2.b();
            t2.f3921b = q2Var;
        }
        t.k();
        j0.d dVar = null;
        while (i < i2) {
            int A0 = c.A0(bArr, i, fVar);
            int i3 = fVar.f3854a;
            if (i3 == 11) {
                int i4 = 0;
                j jVar = null;
                while (A0 < i2) {
                    A0 = c.A0(bArr, A0, fVar);
                    int i5 = fVar.f3854a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (dVar != null) {
                                y1 y1Var = y1.f4411c;
                                throw null;
                            } else if (i7 == 2) {
                                A0 = c.K(bArr, A0, fVar);
                                jVar = (j) fVar.f3856c;
                            }
                        }
                    } else if (i7 == 0) {
                        A0 = c.A0(bArr, A0, fVar);
                        i4 = fVar.f3854a;
                        dVar = (j0.d) this.f4021d.b(fVar.f3857d, this.f4018a, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    A0 = c.h2(i5, bArr, A0, i2, fVar);
                }
                if (jVar != null) {
                    q2Var.c((i4 << 3) | 2, jVar);
                }
                i = A0;
            } else if ((i3 & 7) == 2) {
                dVar = (j0.d) this.f4021d.b(fVar.f3857d, this.f4018a, i3 >>> 3);
                if (dVar == null) {
                    i = c.w0(i3, bArr, A0, i2, q2Var, fVar);
                } else {
                    y1 y1Var2 = y1.f4411c;
                    throw null;
                }
            } else {
                i = c.h2(i3, bArr, A0, i2, fVar);
            }
        }
        if (i != i2) {
            throw n0.g();
        }
    }

    @Override // c.b.d.c2
    public void j(T t, x2 x2Var) {
        Iterator<Map.Entry<?, Object>> w = this.f4021d.c(t).w();
        while (w.hasNext()) {
            Map.Entry<?, Object> next = w.next();
            f0.c cVar = (f0.c) next.getKey();
            if (cVar.h() != w2.c.MESSAGE || cVar.c() || cVar.j()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            ((n) x2Var).i(cVar.a(), next instanceof p0.b ? ((p0.b) next).f4024b.getValue().b() : next.getValue());
        }
        o2<?, ?> o2Var = this.f4019b;
        o2Var.r(o2Var.g(t), x2Var);
    }

    public final <UT, UB, ET extends f0.c<ET>> boolean k(a2 a2Var, z zVar, a0<ET> a0Var, f0<ET> f0Var, o2<UT, UB> o2Var, UB ub) {
        int i = a2Var.i();
        if (i == 11) {
            int i2 = 0;
            Object obj = null;
            j jVar = null;
            while (a2Var.I() != Integer.MAX_VALUE) {
                int i3 = a2Var.i();
                if (i3 == 16) {
                    i2 = a2Var.g();
                    obj = a0Var.b(zVar, this.f4018a, i2);
                } else if (i3 == 26) {
                    if (obj != null) {
                        a0Var.h(a2Var, obj, zVar, f0Var);
                    } else {
                        jVar = a2Var.c();
                    }
                } else if (!a2Var.o()) {
                    break;
                }
            }
            if (a2Var.i() == 12) {
                if (jVar != null) {
                    if (obj != null) {
                        a0Var.i(jVar, obj, zVar, f0Var);
                    } else {
                        o2Var.d(ub, i2, jVar);
                    }
                }
                return true;
            }
            throw n0.a();
        } else if ((i & 7) != 2) {
            return a2Var.o();
        } else {
            Object b2 = a0Var.b(zVar, this.f4018a, i >>> 3);
            if (b2 == null) {
                return o2Var.l(ub, a2Var);
            }
            a0Var.h(a2Var, b2, zVar, f0Var);
            return true;
        }
    }
}
