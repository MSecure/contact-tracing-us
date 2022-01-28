package c.b.a.a.g.b;

import b.x.t;
import c.b.a.a.g.b.z0;
import java.util.Iterator;
import java.util.Map;

public final class i2<T> implements u2<T> {

    /* renamed from: a  reason: collision with root package name */
    public final e2 f3310a;

    /* renamed from: b  reason: collision with root package name */
    public final h3<?, ?> f3311b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3312c;

    /* renamed from: d  reason: collision with root package name */
    public final m0<?> f3313d;

    public i2(h3<?, ?> h3Var, m0<?> m0Var, e2 e2Var) {
        this.f3311b = h3Var;
        if (((n0) m0Var) != null) {
            this.f3312c = e2Var instanceof z0.c;
            this.f3313d = m0Var;
            this.f3310a = e2Var;
            return;
        }
        throw null;
    }

    @Override // c.b.a.a.g.b.u2
    public final boolean b(T t, T t2) {
        j3 j3Var = (j3) this.f3311b;
        if (j3Var != null) {
            i3 i3Var = t.zzjp;
            if (j3Var == null) {
                throw null;
            } else if (!i3Var.equals(t2.zzjp)) {
                return false;
            } else {
                if (!this.f3312c) {
                    return true;
                }
                n0 n0Var = (n0) this.f3313d;
                if (n0Var != null) {
                    q0<z0.d> q0Var = t.zzjv;
                    if (n0Var != null) {
                        return q0Var.equals(t2.zzjv);
                    }
                    throw null;
                }
                throw null;
            }
        } else {
            throw null;
        }
    }

    @Override // c.b.a.a.g.b.u2
    public final T c() {
        return (T) ((z0.a) this.f3310a.a()).i();
    }

    @Override // c.b.a.a.g.b.u2
    public final int d(T t) {
        if (((j3) this.f3311b) != null) {
            int hashCode = t.zzjp.hashCode();
            if (!this.f3312c) {
                return hashCode;
            }
            if (((n0) this.f3313d) != null) {
                return (hashCode * 53) + t.zzjv.hashCode();
            }
            throw null;
        }
        throw null;
    }

    @Override // c.b.a.a.g.b.u2
    public final void e(T t, T t2) {
        w2.i(this.f3311b, t, t2);
        if (this.f3312c) {
            w2.g(this.f3313d, t, t2);
        }
    }

    @Override // c.b.a.a.g.b.u2
    public final boolean f(T t) {
        if (((n0) this.f3313d) != null) {
            return t.zzjv.b();
        }
        throw null;
    }

    @Override // c.b.a.a.g.b.u2
    public final void g(T t, b4 b4Var) {
        if (((n0) this.f3313d) != null) {
            Iterator<Map.Entry<z0.d, Object>> c2 = t.zzjv.c();
            while (c2.hasNext()) {
                Map.Entry<z0.d, Object> next = c2.next();
                z0.d key = next.getKey();
                if (key.v() != a4.MESSAGE || key.M() || key.z()) {
                    throw new IllegalStateException("Found invalid MessageSet item.");
                }
                ((i0) b4Var).c(key.c(), next instanceof k1 ? ((k1) next).f3332b.getValue().c() : next.getValue());
            }
            if (((j3) this.f3311b) != null) {
                i3 i3Var = t.zzjp;
                if (i3Var != null) {
                    i0 i0Var = (i0) b4Var;
                    if (i0Var != null) {
                        for (int i = 0; i < i3Var.f3315a; i++) {
                            i0Var.c(i3Var.f3316b[i] >>> 3, i3Var.f3317c[i]);
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

    @Override // c.b.a.a.g.b.u2
    public final void h(T t, byte[] bArr, int i, int i2, u uVar) {
        int i3;
        T t2 = t;
        i3 i3Var = t2.zzjp;
        if (i3Var == i3.f3314f) {
            i3Var = i3.e();
            t2.zzjp = i3Var;
        }
        while (i < i2) {
            int S3 = t.S3(bArr, i, uVar);
            int i4 = uVar.f3424a;
            if (i4 != 11) {
                i = (i4 & 7) == 2 ? t.H3(i4, bArr, S3, i2, i3Var, uVar) : t.F3(i4, bArr, S3, i2, uVar);
            } else {
                int i5 = 0;
                y yVar = null;
                while (true) {
                    if (S3 >= i2) {
                        i3 = S3;
                        break;
                    }
                    i3 = t.S3(bArr, S3, uVar);
                    int i6 = uVar.f3424a;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 != 2) {
                        if (i7 == 3 && i8 == 2) {
                            S3 = t.J4(bArr, i3, uVar);
                            yVar = (y) uVar.f3426c;
                        }
                    } else if (i8 == 0) {
                        S3 = t.S3(bArr, i3, uVar);
                        i5 = uVar.f3424a;
                    }
                    if (i6 == 12) {
                        break;
                    }
                    S3 = t.F3(i6, bArr, i3, i2, uVar);
                }
                if (yVar != null) {
                    i3Var.b((i5 << 3) | 2, yVar);
                }
                i = i3;
            }
        }
        if (i != i2) {
            throw f1.d();
        }
    }

    @Override // c.b.a.a.g.b.u2
    public final void i(T t) {
        if (((j3) this.f3311b) != null) {
            t.zzjp.f3319e = false;
            if (((n0) this.f3313d) != null) {
                q0<z0.d> q0Var = t.zzjv;
                if (!q0Var.f3396b) {
                    q0Var.f3395a.j();
                    q0Var.f3396b = true;
                    return;
                }
                return;
            }
            throw null;
        }
        throw null;
    }

    @Override // c.b.a.a.g.b.u2
    public final int j(T t) {
        if (((j3) this.f3311b) != null) {
            i3 i3Var = t.zzjp;
            int i = i3Var.f3318d;
            if (i == -1) {
                i = 0;
                for (int i2 = 0; i2 < i3Var.f3315a; i2++) {
                    i += g0.B(3, (y) i3Var.f3317c[i2]) + g0.W(2, i3Var.f3316b[i2] >>> 3) + (g0.h0(1) << 1);
                }
                i3Var.f3318d = i;
            }
            int i3 = i + 0;
            if (!this.f3312c) {
                return i3;
            }
            if (((n0) this.f3313d) != null) {
                q0<z0.d> q0Var = t.zzjv;
                int i4 = 0;
                for (int i5 = 0; i5 < q0Var.f3395a.f(); i5++) {
                    i4 += q0.k(q0Var.f3395a.d(i5));
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : q0Var.f3395a.g()) {
                    i4 += q0.k(entry);
                }
                return i3 + i4;
            }
            throw null;
        }
        throw null;
    }
}
