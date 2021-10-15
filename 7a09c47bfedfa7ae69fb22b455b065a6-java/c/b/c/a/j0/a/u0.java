package c.b.c.a.j0.a;

import b.x.t;
import c.b.c.a.j0.a.d0;
import c.b.c.a.j0.a.u;
import c.b.c.a.j0.a.y;
import java.util.Iterator;
import java.util.Map;

public final class u0<T> implements f1<T> {

    /* renamed from: a  reason: collision with root package name */
    public final r0 f5040a;

    /* renamed from: b  reason: collision with root package name */
    public final l1<?, ?> f5041b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5042c;

    /* renamed from: d  reason: collision with root package name */
    public final r<?> f5043d;

    public u0(l1<?, ?> l1Var, r<?> rVar, r0 r0Var) {
        this.f5041b = l1Var;
        if (((s) rVar) != null) {
            this.f5042c = r0Var instanceof y.c;
            this.f5043d = rVar;
            this.f5040a = r0Var;
            return;
        }
        throw null;
    }

    @Override // c.b.c.a.j0.a.f1
    public void a(T t, T t2) {
        h1.D(this.f5041b, t, t2);
        if (this.f5042c) {
            h1.B(this.f5043d, t, t2);
        }
    }

    @Override // c.b.c.a.j0.a.f1
    public boolean b(T t, T t2) {
        n1 n1Var = (n1) this.f5041b;
        if (n1Var != null) {
            m1 m1Var = t.unknownFields;
            if (n1Var == null) {
                throw null;
            } else if (!m1Var.equals(t2.unknownFields)) {
                return false;
            } else {
                if (!this.f5042c) {
                    return true;
                }
                s sVar = (s) this.f5043d;
                if (sVar != null) {
                    u<y.d> uVar = t.extensions;
                    if (sVar != null) {
                        return uVar.equals(t2.extensions);
                    }
                    throw null;
                }
                throw null;
            }
        } else {
            throw null;
        }
    }

    @Override // c.b.c.a.j0.a.f1
    public T c() {
        return (T) ((y.a) this.f5040a.newBuilderForType()).c();
    }

    @Override // c.b.c.a.j0.a.f1
    public int d(T t) {
        if (((n1) this.f5041b) != null) {
            int hashCode = t.unknownFields.hashCode();
            if (!this.f5042c) {
                return hashCode;
            }
            if (((s) this.f5043d) != null) {
                return (hashCode * 53) + t.extensions.hashCode();
            }
            throw null;
        }
        throw null;
    }

    @Override // c.b.c.a.j0.a.f1
    public final boolean e(T t) {
        if (((s) this.f5043d) != null) {
            return t.extensions.i();
        }
        throw null;
    }

    @Override // c.b.c.a.j0.a.f1
    public int f(T t) {
        if (((n1) this.f5041b) != null) {
            m1 m1Var = t.unknownFields;
            int i = m1Var.f4987d;
            if (i == -1) {
                i = 0;
                for (int i2 = 0; i2 < m1Var.f4984a; i2++) {
                    i += l.d(3, (i) m1Var.f4986c[i2]) + l.H(2, m1Var.f4985b[i2] >>> 3) + (l.G(1) * 2);
                }
                m1Var.f4987d = i;
            }
            int i3 = i + 0;
            if (!this.f5042c) {
                return i3;
            }
            if (((s) this.f5043d) != null) {
                u<y.d> uVar = t.extensions;
                int i4 = 0;
                for (int i5 = 0; i5 < uVar.f5037a.e(); i5++) {
                    i4 += uVar.g(uVar.f5037a.d(i5));
                }
                for (Object obj : uVar.f5037a.f()) {
                    i4 += uVar.g((Map.Entry) obj);
                }
                return i3 + i4;
            }
            throw null;
        }
        throw null;
    }

    @Override // c.b.c.a.j0.a.f1
    public void g(T t) {
        if (((n1) this.f5041b) != null) {
            t.unknownFields.f4988e = false;
            if (((s) this.f5043d) != null) {
                t.extensions.l();
                return;
            }
            throw null;
        }
        throw null;
    }

    @Override // c.b.c.a.j0.a.f1
    public void h(T t, byte[] bArr, int i, int i2, e eVar) {
        T t2 = t;
        m1 m1Var = t2.unknownFields;
        if (m1Var == m1.f4983f) {
            m1Var = m1.b();
            t2.unknownFields = m1Var;
        }
        t.n();
        y.e eVar2 = null;
        while (i < i2) {
            int X0 = t.X0(bArr, i, eVar);
            int i3 = eVar.f4911a;
            if (i3 == 11) {
                int i4 = 0;
                i iVar = null;
                while (X0 < i2) {
                    X0 = t.X0(bArr, X0, eVar);
                    int i5 = eVar.f4911a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (eVar2 != null) {
                                b1 b1Var = b1.f4890c;
                                throw null;
                            } else if (i7 == 2) {
                                X0 = t.h0(bArr, X0, eVar);
                                iVar = (i) eVar.f4913c;
                            }
                        }
                    } else if (i7 == 0) {
                        X0 = t.X0(bArr, X0, eVar);
                        i4 = eVar.f4911a;
                        eVar2 = (y.e) this.f5043d.b(eVar.f4914d, this.f5040a, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    X0 = t.M2(i5, bArr, X0, i2, eVar);
                }
                if (iVar != null) {
                    m1Var.c((i4 << 3) | 2, iVar);
                }
                i = X0;
            } else if ((i3 & 7) == 2) {
                eVar2 = (y.e) this.f5043d.b(eVar.f4914d, this.f5040a, i3 >>> 3);
                if (eVar2 == null) {
                    i = t.T0(i3, bArr, X0, i2, m1Var, eVar);
                } else {
                    b1 b1Var2 = b1.f4890c;
                    throw null;
                }
            } else {
                i = t.M2(i3, bArr, X0, i2, eVar);
            }
        }
        if (i != i2) {
            throw b0.g();
        }
    }

    @Override // c.b.c.a.j0.a.f1
    public void i(T t, u1 u1Var) {
        if (((s) this.f5043d) != null) {
            Iterator<Map.Entry<y.d, Object>> k = t.extensions.k();
            while (k.hasNext()) {
                Map.Entry<y.d, Object> next = k.next();
                y.d key = next.getKey();
                if (key.j() != t1.MESSAGE || key.e() || key.l()) {
                    throw new IllegalStateException("Found invalid MessageSet item.");
                }
                ((m) u1Var).j(key.a(), next instanceof d0.b ? ((d0.b) next).f4905b.getValue().b() : next.getValue());
            }
            if (((n1) this.f5041b) != null) {
                m1 m1Var = t.unknownFields;
                if (m1Var != null) {
                    m mVar = (m) u1Var;
                    if (mVar != null) {
                        for (int i = 0; i < m1Var.f4984a; i++) {
                            mVar.j(m1Var.f4985b[i] >>> 3, m1Var.f4986c[i]);
                        }
                        return;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    @Override // c.b.c.a.j0.a.f1
    public void j(T t, e1 e1Var, q qVar) {
        l1<UT, UB> l1Var = (l1<UT, UB>) this.f5041b;
        r<ET> rVar = (r<ET>) this.f5043d;
        UB b2 = l1Var.b(t);
        u<ET> c2 = rVar.c(t);
        do {
            try {
                if (e1Var.G() == Integer.MAX_VALUE) {
                    break;
                }
            } finally {
                l1Var.e(t, b2);
            }
        } while (k(e1Var, qVar, rVar, c2, l1Var, b2));
    }

    public final <UT, UB, ET extends u.a<ET>> boolean k(e1 e1Var, q qVar, r<ET> rVar, u<ET> uVar, l1<UT, UB> l1Var, UB ub) {
        int i = e1Var.i();
        if (i == 11) {
            int i2 = 0;
            Object obj = null;
            i iVar = null;
            while (e1Var.G() != Integer.MAX_VALUE) {
                int i3 = e1Var.i();
                if (i3 == 16) {
                    i2 = e1Var.g();
                    obj = rVar.b(qVar, this.f5040a, i2);
                } else if (i3 == 26) {
                    if (obj != null) {
                        s sVar = (s) rVar;
                        y.e eVar = (y.e) obj;
                        throw null;
                    }
                    iVar = e1Var.c();
                } else if (!e1Var.n()) {
                    break;
                }
            }
            if (e1Var.i() != 12) {
                throw b0.a();
            } else if (iVar == null) {
                return true;
            } else {
                if (obj != null) {
                    s sVar2 = (s) rVar;
                    y.e eVar2 = (y.e) obj;
                    throw null;
                }
                l1Var.a(ub, i2, iVar);
                return true;
            }
        } else if ((i & 7) != 2) {
            return e1Var.n();
        } else {
            Object b2 = rVar.b(qVar, this.f5040a, i >>> 3);
            if (b2 == null) {
                return l1Var.c(ub, e1Var);
            }
            y.e eVar3 = (y.e) b2;
            throw null;
        }
    }
}
