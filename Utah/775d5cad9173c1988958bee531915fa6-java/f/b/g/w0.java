package f.b.g;

import f.b.a.c.b.o.b;
import f.b.g.f0;
import f.b.g.v;
import f.b.g.z;
import java.util.Iterator;
import java.util.Map;

public final class w0<T> implements j1<T> {
    public final t0 a;
    public final r1<?, ?> b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final s<?> f3717d;

    public w0(r1<?, ?> r1Var, s<?> sVar, t0 t0Var) {
        this.b = r1Var;
        this.c = sVar.e(t0Var);
        this.f3717d = sVar;
        this.a = t0Var;
    }

    @Override // f.b.g.j1
    public void a(T t, T t2) {
        r1<?, ?> r1Var = this.b;
        Class<?> cls = l1.a;
        r1Var.o(t, r1Var.k(r1Var.g(t), r1Var.g(t2)));
        if (this.c) {
            l1.B(this.f3717d, t, t2);
        }
    }

    @Override // f.b.g.j1
    public final boolean b(T t) {
        return this.f3717d.c(t).j();
    }

    @Override // f.b.g.j1
    public void c(T t, h1 h1Var, r rVar) {
        r1<UT, UB> r1Var = (r1<UT, UB>) this.b;
        s<ET> sVar = (s<ET>) this.f3717d;
        UB f2 = r1Var.f(t);
        v<ET> d2 = sVar.d(t);
        do {
            try {
                if (h1Var.M() == Integer.MAX_VALUE) {
                    break;
                }
            } finally {
                r1Var.n(t, f2);
            }
        } while (k(h1Var, rVar, sVar, d2, r1Var, f2));
    }

    @Override // f.b.g.j1
    public boolean d(T t, T t2) {
        if (!this.b.g(t).equals(this.b.g(t2))) {
            return false;
        }
        if (this.c) {
            return this.f3717d.c(t).equals(this.f3717d.c(t2));
        }
        return true;
    }

    @Override // f.b.g.j1
    public void e(T t, byte[] bArr, int i2, int i3, f fVar) {
        T t2 = t;
        s1 s1Var = t2.unknownFields;
        if (s1Var == s1.f3682f) {
            s1Var = s1.e();
            t2.unknownFields = s1Var;
        }
        v<z.d> b2 = t.b();
        z.e eVar = null;
        while (i2 < i3) {
            int g0 = b.g0(bArr, i2, fVar);
            int i4 = fVar.a;
            if (i4 == 11) {
                int i5 = 0;
                j jVar = null;
                while (g0 < i3) {
                    g0 = b.g0(bArr, g0, fVar);
                    int i6 = fVar.a;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 != 2) {
                        if (i7 == 3) {
                            if (eVar != null) {
                                g0 = b.Q(e1.c.a(eVar.c.getClass()), bArr, g0, i3, fVar);
                                b2.o(eVar.f3732d, fVar.c);
                            } else if (i8 == 2) {
                                g0 = b.L(bArr, g0, fVar);
                                jVar = (j) fVar.c;
                            }
                        }
                    } else if (i8 == 0) {
                        g0 = b.g0(bArr, g0, fVar);
                        i5 = fVar.a;
                        eVar = (z.e) this.f3717d.b(fVar.f3607d, this.a, i5);
                    }
                    if (i6 == 12) {
                        break;
                    }
                    g0 = b.q1(i6, bArr, g0, i3, fVar);
                }
                if (jVar != null) {
                    s1Var.f((i5 << 3) | 2, jVar);
                }
                i2 = g0;
            } else if ((i4 & 7) == 2) {
                z.e eVar2 = (z.e) this.f3717d.b(fVar.f3607d, this.a, i4 >>> 3);
                if (eVar2 != null) {
                    i2 = b.Q(e1.c.a(eVar2.c.getClass()), bArr, g0, i3, fVar);
                    b2.o(eVar2.f3732d, fVar.c);
                } else {
                    i2 = b.e0(i4, bArr, g0, i3, s1Var, fVar);
                }
                eVar = eVar2;
            } else {
                i2 = b.q1(i4, bArr, g0, i3, fVar);
            }
        }
        if (i2 != i3) {
            throw d0.g();
        }
    }

    @Override // f.b.g.j1
    public int f(T t) {
        r1<?, ?> r1Var = this.b;
        int i2 = r1Var.i(r1Var.g(t)) + 0;
        if (!this.c) {
            return i2;
        }
        v<?> c2 = this.f3717d.c(t);
        int i3 = 0;
        for (int i4 = 0; i4 < c2.a.d(); i4++) {
            i3 += c2.h(c2.a.c(i4));
        }
        for (Object obj : c2.a.e()) {
            i3 += c2.h((Map.Entry) obj);
        }
        return i2 + i3;
    }

    @Override // f.b.g.j1
    public T g() {
        return (T) this.a.newBuilderForType().buildPartial();
    }

    @Override // f.b.g.j1
    public void h(T t, a2 a2Var) {
        Iterator<Map.Entry<?, Object>> l2 = this.f3717d.c(t).l();
        while (l2.hasNext()) {
            Map.Entry<?, Object> next = l2.next();
            v.a aVar = (v.a) next.getKey();
            if (aVar.j() != z1.MESSAGE || aVar.d() || aVar.k()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            ((n) a2Var).e(aVar.getNumber(), next instanceof f0.b ? ((f0.b) next).b.getValue().b() : next.getValue());
        }
        r1<?, ?> r1Var = this.b;
        r1Var.r(r1Var.g(t), a2Var);
    }

    @Override // f.b.g.j1
    public void i(T t) {
        this.b.j(t);
        this.f3717d.f(t);
    }

    @Override // f.b.g.j1
    public int j(T t) {
        int hashCode = this.b.g(t).hashCode();
        return this.c ? (hashCode * 53) + this.f3717d.c(t).hashCode() : hashCode;
    }

    public final <UT, UB, ET extends v.a<ET>> boolean k(h1 h1Var, r rVar, s<ET> sVar, v<ET> vVar, r1<UT, UB> r1Var, UB ub) {
        int k2 = h1Var.k();
        if (k2 == 11) {
            int i2 = 0;
            Object obj = null;
            j jVar = null;
            while (h1Var.M() != Integer.MAX_VALUE) {
                int k3 = h1Var.k();
                if (k3 == 16) {
                    i2 = h1Var.i();
                    obj = sVar.b(rVar, this.a, i2);
                } else if (k3 == 26) {
                    if (obj != null) {
                        sVar.h(h1Var, obj, rVar, vVar);
                    } else {
                        jVar = h1Var.e();
                    }
                } else if (!h1Var.p()) {
                    break;
                }
            }
            if (h1Var.k() == 12) {
                if (jVar != null) {
                    if (obj != null) {
                        sVar.i(jVar, obj, rVar, vVar);
                    } else {
                        r1Var.d(ub, i2, jVar);
                    }
                }
                return true;
            }
            throw d0.a();
        } else if ((k2 & 7) != 2) {
            return h1Var.p();
        } else {
            Object b2 = sVar.b(rVar, this.a, k2 >>> 3);
            if (b2 == null) {
                return r1Var.l(ub, h1Var);
            }
            sVar.h(h1Var, b2, rVar, vVar);
            return true;
        }
    }
}
