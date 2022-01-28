package c.b.a.a.g.h;

import b.x.t;
import c.b.a.a.g.h.e1;
import c.b.a.a.g.h.t1;
import java.util.Iterator;
import java.util.Map;

public final class g3<T> implements q3<T> {

    /* renamed from: a  reason: collision with root package name */
    public final c3 f3895a;

    /* renamed from: b  reason: collision with root package name */
    public final d4<?, ?> f3896b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3897c;

    /* renamed from: d  reason: collision with root package name */
    public final g1<?> f3898d;

    public g3(d4<?, ?> d4Var, g1<?> g1Var, c3 c3Var) {
        this.f3896b = d4Var;
        if (((i1) g1Var) != null) {
            this.f3897c = c3Var instanceof t1.d;
            this.f3898d = g1Var;
            this.f3895a = c3Var;
            return;
        }
        throw null;
    }

    @Override // c.b.a.a.g.h.q3
    public final void a(T t) {
        if (((f4) this.f3896b) != null) {
            t.zzxz.f3856e = false;
            if (((i1) this.f3898d) != null) {
                t.zzyg.l();
                return;
            }
            throw null;
        }
        throw null;
    }

    @Override // c.b.a.a.g.h.q3
    public final boolean b(T t, T t2) {
        f4 f4Var = (f4) this.f3896b;
        if (f4Var != null) {
            c4 c4Var = t.zzxz;
            if (f4Var == null) {
                throw null;
            } else if (!c4Var.equals(t2.zzxz)) {
                return false;
            } else {
                if (!this.f3897c) {
                    return true;
                }
                i1 i1Var = (i1) this.f3898d;
                if (i1Var != null) {
                    j1<t1.c> j1Var = t.zzyg;
                    if (i1Var != null) {
                        return j1Var.equals(t2.zzyg);
                    }
                    throw null;
                }
                throw null;
            }
        } else {
            throw null;
        }
    }

    @Override // c.b.a.a.g.h.q3
    public final T c() {
        return (T) ((t1.a) this.f3895a.a()).j();
    }

    @Override // c.b.a.a.g.h.q3
    public final int d(T t) {
        if (((f4) this.f3896b) != null) {
            int hashCode = t.zzxz.hashCode();
            if (!this.f3897c) {
                return hashCode;
            }
            if (((i1) this.f3898d) != null) {
                return (hashCode * 53) + t.zzyg.hashCode();
            }
            throw null;
        }
        throw null;
    }

    @Override // c.b.a.a.g.h.q3
    public final int e(T t) {
        if (((f4) this.f3896b) != null) {
            c4 c4Var = t.zzxz;
            int i = c4Var.f3855d;
            if (i == -1) {
                i = 0;
                for (int i2 = 0; i2 < c4Var.f3852a; i2++) {
                    i += b1.t(3, (q0) c4Var.f3854c[i2]) + b1.J(2, c4Var.f3853b[i2] >>> 3) + (b1.o(8) << 1);
                }
                c4Var.f3855d = i;
            }
            int i3 = i + 0;
            if (!this.f3897c) {
                return i3;
            }
            if (((i1) this.f3898d) != null) {
                j1<t1.c> j1Var = t.zzyg;
                int i4 = 0;
                for (int i5 = 0; i5 < j1Var.f3910a.h(); i5++) {
                    i4 += j1.k(j1Var.f3910a.e(i5));
                }
                for (Map.Entry<T, Object> entry : j1Var.f3910a.i()) {
                    i4 += j1.k(entry);
                }
                return i3 + i4;
            }
            throw null;
        }
        throw null;
    }

    @Override // c.b.a.a.g.h.q3
    public final boolean f(T t) {
        if (((i1) this.f3898d) != null) {
            return t.zzyg.a();
        }
        throw null;
    }

    @Override // c.b.a.a.g.h.q3
    public final void g(T t, byte[] bArr, int i, int i2, n0 n0Var) {
        T t2 = t;
        c4 c4Var = t2.zzxz;
        if (c4Var == c4.f3851f) {
            c4Var = c4.e();
            t2.zzxz = c4Var;
        }
        j1<t1.c> k = t.k();
        t1.f<?, ?> fVar = null;
        while (i < i2) {
            int U3 = t.U3(bArr, i, n0Var);
            int i3 = n0Var.f3967a;
            if (i3 == 11) {
                int i4 = 0;
                q0 q0Var = null;
                while (U3 < i2) {
                    U3 = t.U3(bArr, U3, n0Var);
                    int i5 = n0Var.f3967a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (fVar != null) {
                                U3 = t.Q3(n3.f3973c.a(fVar.f4040a.getClass()), bArr, U3, i2, n0Var);
                                k.e(fVar.f4041b, n0Var.f3969c);
                            } else if (i7 == 2) {
                                U3 = t.K4(bArr, U3, n0Var);
                                q0Var = (q0) n0Var.f3969c;
                            }
                        }
                    } else if (i7 == 0) {
                        U3 = t.U3(bArr, U3, n0Var);
                        i4 = n0Var.f3967a;
                        g1<?> g1Var = this.f3898d;
                        e1 e1Var = n0Var.f3970d;
                        c3 c3Var = this.f3895a;
                        if (((i1) g1Var) != null) {
                            fVar = e1Var.f3870a.get(new e1.a(c3Var, i4));
                        } else {
                            throw null;
                        }
                    }
                    if (i5 == 12) {
                        break;
                    }
                    U3 = t.I3(i5, bArr, U3, i2, n0Var);
                }
                if (q0Var != null) {
                    c4Var.a((i4 << 3) | 2, q0Var);
                }
                i = U3;
            } else if ((i3 & 7) == 2) {
                g1<?> g1Var2 = this.f3898d;
                e1 e1Var2 = n0Var.f3970d;
                c3 c3Var2 = this.f3895a;
                int i8 = i3 >>> 3;
                if (((i1) g1Var2) != null) {
                    t1.f<?, ?> fVar2 = e1Var2.f3870a.get(new e1.a(c3Var2, i8));
                    if (fVar2 != null) {
                        i = t.Q3(n3.f3973c.a(fVar2.f4040a.getClass()), bArr, U3, i2, n0Var);
                        k.e(fVar2.f4041b, n0Var.f3969c);
                    } else {
                        i = t.K3(i3, bArr, U3, i2, c4Var, n0Var);
                    }
                    fVar = fVar2;
                } else {
                    throw null;
                }
            } else {
                i = t.I3(i3, bArr, U3, i2, n0Var);
            }
        }
        if (i != i2) {
            throw c2.e();
        }
    }

    @Override // c.b.a.a.g.h.q3
    public final void h(T t, T t2) {
        s3.h(this.f3896b, t, t2);
        if (this.f3897c) {
            s3.f(this.f3898d, t, t2);
        }
    }

    @Override // c.b.a.a.g.h.q3
    public final void i(T t, v4 v4Var) {
        if (((i1) this.f3898d) != null) {
            Iterator<Map.Entry<t1.c, Object>> b2 = t.zzyg.b();
            while (b2.hasNext()) {
                Map.Entry<t1.c, Object> next = b2.next();
                t1.c key = next.getKey();
                if (key.K() != w4.MESSAGE || key.w() || key.N()) {
                    throw new IllegalStateException("Found invalid MessageSet item.");
                }
                ((d1) v4Var).e(key.h(), next instanceof f2 ? ((f2) next).f3893b.getValue().a() : next.getValue());
            }
            if (((f4) this.f3896b) != null) {
                c4 c4Var = t.zzxz;
                if (c4Var != null) {
                    d1 d1Var = (d1) v4Var;
                    if (d1Var != null) {
                        for (int i = 0; i < c4Var.f3852a; i++) {
                            d1Var.e(c4Var.f3853b[i] >>> 3, c4Var.f3854c[i]);
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
}
