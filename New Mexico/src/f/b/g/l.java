package f.b.g;

import f.b.g.d0;
import f.b.g.m0;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class l implements h1 {
    public final k a;
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f3916d = 0;

    public l(k kVar) {
        Charset charset = c0.a;
        this.a = kVar;
        kVar.f3889d = this;
    }

    @Override // f.b.g.h1
    public void A(List<Boolean> list) {
        int i2;
        int A;
        int A2;
        if (list instanceof h) {
            h hVar = (h) list;
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    hVar.i(this.a.k());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
                return;
            } else if (i3 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    hVar.i(this.a.k());
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 0) {
                do {
                    list.add(Boolean.valueOf(this.a.k()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
                return;
            } else if (i4 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    list.add(Boolean.valueOf(this.a.k()));
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        }
        U(i2);
    }

    @Override // f.b.g.h1
    public void B(List<Long> list) {
        int A;
        int A2;
        if (list instanceof k0) {
            k0 k0Var = (k0) list;
            int i2 = this.b & 7;
            if (i2 == 1) {
                do {
                    k0Var.i(this.a.v());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
            } else if (i2 == 2) {
                int B = this.a.B();
                X(B);
                int d2 = this.a.d() + B;
                do {
                    k0Var.i(this.a.v());
                } while (this.a.d() < d2);
            } else {
                throw d0.d();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.a.v()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
            } else if (i3 == 2) {
                int B2 = this.a.B();
                X(B2);
                int d3 = this.a.d() + B2;
                do {
                    list.add(Long.valueOf(this.a.v()));
                } while (this.a.d() < d3);
            } else {
                throw d0.d();
            }
        }
    }

    @Override // f.b.g.h1
    public String C() {
        V(2);
        return this.a.y();
    }

    @Override // f.b.g.h1
    public long D() {
        V(0);
        return this.a.s();
    }

    @Override // f.b.g.h1
    public String E() {
        V(2);
        return this.a.z();
    }

    @Override // f.b.g.h1
    public int F() {
        V(5);
        return this.a.o();
    }

    @Override // f.b.g.h1
    public void G(List<Long> list) {
        int A;
        int A2;
        if (list instanceof k0) {
            k0 k0Var = (k0) list;
            int i2 = this.b & 7;
            if (i2 == 1) {
                do {
                    k0Var.i(this.a.p());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
            } else if (i2 == 2) {
                int B = this.a.B();
                X(B);
                int d2 = this.a.d() + B;
                do {
                    k0Var.i(this.a.p());
                } while (this.a.d() < d2);
            } else {
                throw d0.d();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.a.p()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
            } else if (i3 == 2) {
                int B2 = this.a.B();
                X(B2);
                int d3 = this.a.d() + B2;
                do {
                    list.add(Long.valueOf(this.a.p()));
                } while (this.a.d() < d3);
            } else {
                throw d0.d();
            }
        }
    }

    @Override // f.b.g.h1
    public void H(List<Integer> list) {
        int i2;
        int A;
        int A2;
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    b0Var.i(this.a.r());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
                return;
            } else if (i3 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    b0Var.i(this.a.r());
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.r()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
                return;
            } else if (i4 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    list.add(Integer.valueOf(this.a.r()));
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        }
        U(i2);
    }

    @Override // f.b.g.h1
    public <T> T I(Class<T> cls, r rVar) {
        V(3);
        return (T) R(e1.c.a(cls), rVar);
    }

    @Override // f.b.g.h1
    public boolean J() {
        V(0);
        return this.a.k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b.g.h1
    public <T> void K(List<T> list, j1<T> j1Var, r rVar) {
        int A;
        int i2 = this.b;
        if ((i2 & 7) == 2) {
            do {
                list.add(S(j1Var, rVar));
                if (!this.a.e() && this.f3916d == 0) {
                    A = this.a.A();
                } else {
                    return;
                }
            } while (A == i2);
            this.f3916d = A;
            return;
        }
        throw d0.d();
    }

    @Override // f.b.g.h1
    public void L(List<Integer> list) {
        int i2;
        int A;
        int A2;
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    b0Var.i(this.a.n());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
                return;
            } else if (i3 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    b0Var.i(this.a.n());
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.n()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
                return;
            } else if (i4 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    list.add(Integer.valueOf(this.a.n()));
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        }
        U(i2);
    }

    @Override // f.b.g.h1
    public int M() {
        int i2 = this.f3916d;
        if (i2 != 0) {
            this.b = i2;
            this.f3916d = 0;
        } else {
            this.b = this.a.A();
        }
        int i3 = this.b;
        if (i3 == 0 || i3 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i3 >>> 3;
    }

    @Override // f.b.g.h1
    public void N(List<String> list) {
        T(list, false);
    }

    @Override // f.b.g.h1
    public long O() {
        V(1);
        return this.a.v();
    }

    @Override // f.b.g.h1
    public <T> T P(j1<T> j1Var, r rVar) {
        V(2);
        return (T) S(j1Var, rVar);
    }

    public final Object Q(y1 y1Var, Class<?> cls, r rVar) {
        switch (y1Var.ordinal()) {
            case 0:
                return Double.valueOf(readDouble());
            case 1:
                return Float.valueOf(readFloat());
            case 2:
                return Long.valueOf(D());
            case 3:
                return Long.valueOf(l());
            case 4:
                return Integer.valueOf(j());
            case 5:
                return Long.valueOf(n());
            case 6:
                return Integer.valueOf(F());
            case 7:
                return Boolean.valueOf(J());
            case 8:
                return E();
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return y(cls, rVar);
            case 11:
                return e();
            case 12:
                return Integer.valueOf(i());
            case 13:
                return Integer.valueOf(g());
            case 14:
                return Integer.valueOf(u());
            case 15:
                return Long.valueOf(O());
            case 16:
                return Integer.valueOf(q());
            case 17:
                return Long.valueOf(t());
        }
    }

    public final <T> T R(j1<T> j1Var, r rVar) {
        int i2 = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            T g2 = j1Var.g();
            j1Var.c(g2, this, rVar);
            j1Var.i(g2);
            if (this.b == this.c) {
                return g2;
            }
            throw d0.g();
        } finally {
            this.c = i2;
        }
    }

    public final <T> T S(j1<T> j1Var, r rVar) {
        int B = this.a.B();
        k kVar = this.a;
        if (kVar.a < kVar.b) {
            int j2 = kVar.j(B);
            T g2 = j1Var.g();
            this.a.a++;
            j1Var.c(g2, this, rVar);
            j1Var.i(g2);
            this.a.a(0);
            k kVar2 = this.a;
            kVar2.a--;
            kVar2.i(j2);
            return g2;
        }
        throw new d0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public void T(List<String> list, boolean z) {
        int A;
        int A2;
        if ((this.b & 7) != 2) {
            throw d0.d();
        } else if (!(list instanceof i0) || z) {
            do {
                list.add(z ? E() : C());
                if (!this.a.e()) {
                    A = this.a.A();
                } else {
                    return;
                }
            } while (A == this.b);
            this.f3916d = A;
        } else {
            i0 i0Var = (i0) list;
            do {
                i0Var.e(e());
                if (!this.a.e()) {
                    A2 = this.a.A();
                } else {
                    return;
                }
            } while (A2 == this.b);
            this.f3916d = A2;
        }
    }

    public final void U(int i2) {
        if (this.a.d() != i2) {
            throw d0.h();
        }
    }

    public final void V(int i2) {
        if ((this.b & 7) != i2) {
            throw d0.d();
        }
    }

    public final void W(int i2) {
        if ((i2 & 3) != 0) {
            throw d0.g();
        }
    }

    public final void X(int i2) {
        if ((i2 & 7) != 0) {
            throw d0.g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b.g.h1
    /* Code decompiled incorrectly, please refer to instructions dump */
    public <K, V> void a(Map<K, V> map, m0.a<K, V> aVar, r rVar) {
        V(2);
        int j2 = this.a.j(this.a.B());
        Object obj = aVar.b;
        Object obj2 = aVar.f3926d;
        while (true) {
            try {
                int M = M();
                if (M == Integer.MAX_VALUE || this.a.e()) {
                    break;
                } else if (M == 1) {
                    obj = Q(aVar.a, null, null);
                } else if (M != 2) {
                    try {
                        if (!p()) {
                            throw new d0("Unable to parse map entry.");
                            break;
                        }
                    } catch (d0.a unused) {
                        if (!p()) {
                            throw new d0("Unable to parse map entry.");
                        }
                    }
                } else {
                    obj2 = Q(aVar.c, aVar.f3926d.getClass(), rVar);
                }
            } finally {
                this.a.i(j2);
            }
        }
    }

    @Override // f.b.g.h1
    public void b(List<Long> list) {
        int i2;
        int A;
        int A2;
        if (list instanceof k0) {
            k0 k0Var = (k0) list;
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    k0Var.i(this.a.C());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
                return;
            } else if (i3 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    k0Var.i(this.a.C());
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(this.a.C()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
                return;
            } else if (i4 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    list.add(Long.valueOf(this.a.C()));
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        }
        U(i2);
    }

    @Override // f.b.g.h1
    public void c(List<String> list) {
        T(list, true);
    }

    @Override // f.b.g.h1
    public <T> T d(j1<T> j1Var, r rVar) {
        V(3);
        return (T) R(j1Var, rVar);
    }

    @Override // f.b.g.h1
    public j e() {
        V(2);
        return this.a.l();
    }

    @Override // f.b.g.h1
    public void f(List<Integer> list) {
        int i2;
        int A;
        int A2;
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    b0Var.i(this.a.w());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
                return;
            } else if (i3 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    b0Var.i(this.a.w());
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.w()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
                return;
            } else if (i4 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    list.add(Integer.valueOf(this.a.w()));
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        }
        U(i2);
    }

    @Override // f.b.g.h1
    public int g() {
        V(0);
        return this.a.n();
    }

    @Override // f.b.g.h1
    public void h(List<Float> list) {
        int A;
        int A2;
        if (list instanceof x) {
            x xVar = (x) list;
            int i2 = this.b & 7;
            if (i2 == 2) {
                int B = this.a.B();
                W(B);
                int d2 = this.a.d() + B;
                do {
                    xVar.i(this.a.q());
                } while (this.a.d() < d2);
            } else if (i2 == 5) {
                do {
                    xVar.i(this.a.q());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
            } else {
                throw d0.d();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 2) {
                int B2 = this.a.B();
                W(B2);
                int d3 = this.a.d() + B2;
                do {
                    list.add(Float.valueOf(this.a.q()));
                } while (this.a.d() < d3);
            } else if (i3 == 5) {
                do {
                    list.add(Float.valueOf(this.a.q()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
            } else {
                throw d0.d();
            }
        }
    }

    @Override // f.b.g.h1
    public int i() {
        V(0);
        return this.a.B();
    }

    @Override // f.b.g.h1
    public int j() {
        V(0);
        return this.a.r();
    }

    @Override // f.b.g.h1
    public int k() {
        return this.b;
    }

    @Override // f.b.g.h1
    public long l() {
        V(0);
        return this.a.C();
    }

    @Override // f.b.g.h1
    public void m(List<Integer> list) {
        int A;
        int A2;
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            int i2 = this.b & 7;
            if (i2 == 2) {
                int B = this.a.B();
                W(B);
                int d2 = this.a.d() + B;
                do {
                    b0Var.i(this.a.o());
                } while (this.a.d() < d2);
            } else if (i2 == 5) {
                do {
                    b0Var.i(this.a.o());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
            } else {
                throw d0.d();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 2) {
                int B2 = this.a.B();
                W(B2);
                int d3 = this.a.d() + B2;
                do {
                    list.add(Integer.valueOf(this.a.o()));
                } while (this.a.d() < d3);
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.a.o()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
            } else {
                throw d0.d();
            }
        }
    }

    @Override // f.b.g.h1
    public long n() {
        V(1);
        return this.a.p();
    }

    @Override // f.b.g.h1
    public void o(List<Integer> list) {
        int A;
        int A2;
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            int i2 = this.b & 7;
            if (i2 == 2) {
                int B = this.a.B();
                W(B);
                int d2 = this.a.d() + B;
                do {
                    b0Var.i(this.a.u());
                } while (this.a.d() < d2);
            } else if (i2 == 5) {
                do {
                    b0Var.i(this.a.u());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
            } else {
                throw d0.d();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 2) {
                int B2 = this.a.B();
                W(B2);
                int d3 = this.a.d() + B2;
                do {
                    list.add(Integer.valueOf(this.a.u()));
                } while (this.a.d() < d3);
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.a.u()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
            } else {
                throw d0.d();
            }
        }
    }

    @Override // f.b.g.h1
    public boolean p() {
        int i2;
        if (this.a.e() || (i2 = this.b) == this.c) {
            return false;
        }
        return this.a.D(i2);
    }

    @Override // f.b.g.h1
    public int q() {
        V(0);
        return this.a.w();
    }

    @Override // f.b.g.h1
    public void r(List<Long> list) {
        int i2;
        int A;
        int A2;
        if (list instanceof k0) {
            k0 k0Var = (k0) list;
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    k0Var.i(this.a.x());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
                return;
            } else if (i3 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    k0Var.i(this.a.x());
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(this.a.x()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
                return;
            } else if (i4 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    list.add(Long.valueOf(this.a.x()));
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        }
        U(i2);
    }

    @Override // f.b.g.h1
    public double readDouble() {
        V(1);
        return this.a.m();
    }

    @Override // f.b.g.h1
    public float readFloat() {
        V(5);
        return this.a.q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b.g.h1
    public <T> void s(List<T> list, j1<T> j1Var, r rVar) {
        int A;
        int i2 = this.b;
        if ((i2 & 7) == 3) {
            do {
                list.add(R(j1Var, rVar));
                if (!this.a.e() && this.f3916d == 0) {
                    A = this.a.A();
                } else {
                    return;
                }
            } while (A == i2);
            this.f3916d = A;
            return;
        }
        throw d0.d();
    }

    @Override // f.b.g.h1
    public long t() {
        V(0);
        return this.a.x();
    }

    @Override // f.b.g.h1
    public int u() {
        V(5);
        return this.a.u();
    }

    @Override // f.b.g.h1
    public void v(List<j> list) {
        int A;
        if ((this.b & 7) == 2) {
            do {
                list.add(e());
                if (!this.a.e()) {
                    A = this.a.A();
                } else {
                    return;
                }
            } while (A == this.b);
            this.f3916d = A;
            return;
        }
        throw d0.d();
    }

    @Override // f.b.g.h1
    public void w(List<Integer> list) {
        int i2;
        int A;
        int A2;
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    b0Var.i(this.a.B());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
                return;
            } else if (i3 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    b0Var.i(this.a.B());
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.B()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
                return;
            } else if (i4 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    list.add(Integer.valueOf(this.a.B()));
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        }
        U(i2);
    }

    @Override // f.b.g.h1
    public void x(List<Double> list) {
        int A;
        int A2;
        if (list instanceof o) {
            o oVar = (o) list;
            int i2 = this.b & 7;
            if (i2 == 1) {
                do {
                    oVar.i(this.a.m());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
            } else if (i2 == 2) {
                int B = this.a.B();
                X(B);
                int d2 = this.a.d() + B;
                do {
                    oVar.i(this.a.m());
                } while (this.a.d() < d2);
            } else {
                throw d0.d();
            }
        } else {
            int i3 = this.b & 7;
            if (i3 == 1) {
                do {
                    list.add(Double.valueOf(this.a.m()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
            } else if (i3 == 2) {
                int B2 = this.a.B();
                X(B2);
                int d3 = this.a.d() + B2;
                do {
                    list.add(Double.valueOf(this.a.m()));
                } while (this.a.d() < d3);
            } else {
                throw d0.d();
            }
        }
    }

    @Override // f.b.g.h1
    public <T> T y(Class<T> cls, r rVar) {
        V(2);
        return (T) S(e1.c.a(cls), rVar);
    }

    @Override // f.b.g.h1
    public void z(List<Long> list) {
        int i2;
        int A;
        int A2;
        if (list instanceof k0) {
            k0 k0Var = (k0) list;
            int i3 = this.b & 7;
            if (i3 == 0) {
                do {
                    k0Var.i(this.a.s());
                    if (!this.a.e()) {
                        A2 = this.a.A();
                    } else {
                        return;
                    }
                } while (A2 == this.b);
                this.f3916d = A2;
                return;
            } else if (i3 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    k0Var.i(this.a.s());
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        } else {
            int i4 = this.b & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(this.a.s()));
                    if (!this.a.e()) {
                        A = this.a.A();
                    } else {
                        return;
                    }
                } while (A == this.b);
                this.f3916d = A;
                return;
            } else if (i4 == 2) {
                i2 = this.a.d() + this.a.B();
                do {
                    list.add(Long.valueOf(this.a.s()));
                } while (this.a.d() < i2);
            } else {
                throw d0.d();
            }
        }
        U(i2);
    }
}
