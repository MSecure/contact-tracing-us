package c.b.d;

import c.b.d.y0;
import java.util.List;
import java.util.Map;

public final class l implements b2 {

    /* renamed from: a  reason: collision with root package name */
    public final k f5363a;

    /* renamed from: b  reason: collision with root package name */
    public int f5364b;

    /* renamed from: c  reason: collision with root package name */
    public int f5365c;

    /* renamed from: d  reason: collision with root package name */
    public int f5366d = 0;

    public l(k kVar) {
        n0.b(kVar, "input");
        this.f5363a = kVar;
        kVar.f5339d = this;
    }

    @Override // c.b.d.b2
    public String A() {
        V(2);
        return this.f5363a.F();
    }

    @Override // c.b.d.b2
    public int B() {
        V(5);
        return this.f5363a.q();
    }

    @Override // c.b.d.b2
    public void C(List<Long> list) {
        int G;
        int G2;
        if (list instanceof v0) {
            v0 v0Var = (v0) list;
            int i = this.f5364b & 7;
            if (i == 1) {
                do {
                    v0Var.c(this.f5363a.r());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
            } else if (i == 2) {
                int H = this.f5363a.H();
                X(H);
                int e2 = this.f5363a.e() + H;
                do {
                    v0Var.c(this.f5363a.r());
                } while (this.f5363a.e() < e2);
            } else {
                throw o0.d();
            }
        } else {
            int i2 = this.f5364b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f5363a.r()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
            } else if (i2 == 2) {
                int H2 = this.f5363a.H();
                X(H2);
                int e3 = this.f5363a.e() + H2;
                do {
                    list.add(Long.valueOf(this.f5363a.r()));
                } while (this.f5363a.e() < e3);
            } else {
                throw o0.d();
            }
        }
    }

    @Override // c.b.d.b2
    public void D(List<Integer> list) {
        int i;
        int G;
        int G2;
        if (list instanceof m0) {
            m0 m0Var = (m0) list;
            int i2 = this.f5364b & 7;
            if (i2 == 0) {
                do {
                    m0Var.c(this.f5363a.u());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    m0Var.c(this.f5363a.u());
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        } else {
            int i3 = this.f5364b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f5363a.u()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
                return;
            } else if (i3 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    list.add(Integer.valueOf(this.f5363a.u()));
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        }
        U(i);
    }

    @Override // c.b.d.b2
    public boolean E() {
        V(0);
        return this.f5363a.m();
    }

    @Override // c.b.d.b2
    public void F(List<Integer> list) {
        int i;
        int G;
        int G2;
        if (list instanceof m0) {
            m0 m0Var = (m0) list;
            int i2 = this.f5364b & 7;
            if (i2 == 0) {
                do {
                    m0Var.c(this.f5363a.p());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    m0Var.c(this.f5363a.p());
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        } else {
            int i3 = this.f5364b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f5363a.p()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
                return;
            } else if (i3 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    list.add(Integer.valueOf(this.f5363a.p()));
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        }
        U(i);
    }

    @Override // c.b.d.b2
    public int G() {
        int i = this.f5366d;
        if (i != 0) {
            this.f5364b = i;
            this.f5366d = 0;
        } else {
            this.f5364b = this.f5363a.G();
        }
        int i2 = this.f5364b;
        if (i2 == 0 || i2 == this.f5365c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // c.b.d.b2
    public void H(List<String> list) {
        T(list, false);
    }

    @Override // c.b.d.b2
    public long I() {
        V(1);
        return this.f5363a.B();
    }

    @Override // c.b.d.b2
    public <K, V> void J(Map<K, V> map, y0.a<K, V> aVar, z zVar) {
        V(2);
        this.f5363a.l(this.f5363a.H());
        throw null;
    }

    @Override // c.b.d.b2
    public <T> T K(d2<T> d2Var, z zVar) {
        V(3);
        return (T) R(d2Var, zVar);
    }

    @Override // c.b.d.b2
    public boolean L() {
        return this.f5363a.f5340e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.d.b2
    public <T> void M(List<T> list, d2<T> d2Var, z zVar) {
        int G;
        int i = this.f5364b;
        if ((i & 7) == 3) {
            do {
                list.add(R(d2Var, zVar));
                if (!this.f5363a.f() && this.f5366d == 0) {
                    G = this.f5363a.G();
                } else {
                    return;
                }
            } while (G == i);
            this.f5366d = G;
            return;
        }
        throw o0.d();
    }

    @Override // c.b.d.b2
    public <T> T N(Class<T> cls, z zVar) {
        V(2);
        return (T) S(z1.f5964c.a(cls), zVar);
    }

    @Override // c.b.d.b2
    public <T> T O(Class<T> cls, z zVar) {
        V(3);
        return (T) R(z1.f5964c.a(cls), zVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.d.b2
    public <T> void P(List<T> list, d2<T> d2Var, z zVar) {
        int G;
        int i = this.f5364b;
        if ((i & 7) == 2) {
            do {
                list.add(S(d2Var, zVar));
                if (!this.f5363a.f() && this.f5366d == 0) {
                    G = this.f5363a.G();
                } else {
                    return;
                }
            } while (G == i);
            this.f5366d = G;
            return;
        }
        throw o0.d();
    }

    @Override // c.b.d.b2
    public <T> T Q(d2<T> d2Var, z zVar) {
        V(2);
        return (T) S(d2Var, zVar);
    }

    public final <T> T R(d2<T> d2Var, z zVar) {
        int i = this.f5365c;
        this.f5365c = ((this.f5364b >>> 3) << 3) | 4;
        try {
            T c2 = d2Var.c();
            d2Var.h(c2, this, zVar);
            d2Var.g(c2);
            if (this.f5364b == this.f5365c) {
                return c2;
            }
            throw o0.g();
        } finally {
            this.f5365c = i;
        }
    }

    public final <T> T S(d2<T> d2Var, z zVar) {
        int H = this.f5363a.H();
        k kVar = this.f5363a;
        if (kVar.f5336a < kVar.f5337b) {
            int l = kVar.l(H);
            T c2 = d2Var.c();
            this.f5363a.f5336a++;
            d2Var.h(c2, this, zVar);
            d2Var.g(c2);
            this.f5363a.a(0);
            k kVar2 = this.f5363a;
            kVar2.f5336a--;
            kVar2.k(l);
            return c2;
        }
        throw o0.h();
    }

    public void T(List<String> list, boolean z) {
        int G;
        int G2;
        if ((this.f5364b & 7) != 2) {
            throw o0.d();
        } else if (!(list instanceof t0) || z) {
            do {
                list.add(z ? A() : y());
                if (!this.f5363a.f()) {
                    G = this.f5363a.G();
                } else {
                    return;
                }
            } while (G == this.f5364b);
            this.f5366d = G;
        } else {
            t0 t0Var = (t0) list;
            do {
                t0Var.D(c());
                if (!this.f5363a.f()) {
                    G2 = this.f5363a.G();
                } else {
                    return;
                }
            } while (G2 == this.f5364b);
            this.f5366d = G2;
        }
    }

    public final void U(int i) {
        if (this.f5363a.e() != i) {
            throw o0.i();
        }
    }

    public final void V(int i) {
        if ((this.f5364b & 7) != i) {
            throw o0.d();
        }
    }

    public final void W(int i) {
        if ((i & 3) != 0) {
            throw o0.g();
        }
    }

    public final void X(int i) {
        if ((i & 7) != 0) {
            throw o0.g();
        }
    }

    @Override // c.b.d.b2
    public void a(List<Long> list) {
        int i;
        int G;
        int G2;
        if (list instanceof v0) {
            v0 v0Var = (v0) list;
            int i2 = this.f5364b & 7;
            if (i2 == 0) {
                do {
                    v0Var.c(this.f5363a.I());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    v0Var.c(this.f5363a.I());
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        } else {
            int i3 = this.f5364b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f5363a.I()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
                return;
            } else if (i3 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    list.add(Long.valueOf(this.f5363a.I()));
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        }
        U(i);
    }

    @Override // c.b.d.b2
    public void b(List<String> list) {
        T(list, true);
    }

    @Override // c.b.d.b2
    public j c() {
        V(2);
        return this.f5363a.n();
    }

    @Override // c.b.d.b2
    public void d(List<Integer> list) {
        int i;
        int G;
        int G2;
        if (list instanceof m0) {
            m0 m0Var = (m0) list;
            int i2 = this.f5364b & 7;
            if (i2 == 0) {
                do {
                    m0Var.c(this.f5363a.C());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    m0Var.c(this.f5363a.C());
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        } else {
            int i3 = this.f5364b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f5363a.C()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
                return;
            } else if (i3 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    list.add(Integer.valueOf(this.f5363a.C()));
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        }
        U(i);
    }

    @Override // c.b.d.b2
    public int e() {
        V(0);
        return this.f5363a.p();
    }

    @Override // c.b.d.b2
    public void f(List<Float> list) {
        int G;
        int G2;
        if (list instanceof h0) {
            h0 h0Var = (h0) list;
            int i = this.f5364b & 7;
            if (i == 2) {
                int H = this.f5363a.H();
                W(H);
                int e2 = this.f5363a.e() + H;
                do {
                    h0Var.c(this.f5363a.s());
                } while (this.f5363a.e() < e2);
            } else if (i == 5) {
                do {
                    h0Var.c(this.f5363a.s());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
            } else {
                throw o0.d();
            }
        } else {
            int i2 = this.f5364b & 7;
            if (i2 == 2) {
                int H2 = this.f5363a.H();
                W(H2);
                int e3 = this.f5363a.e() + H2;
                do {
                    list.add(Float.valueOf(this.f5363a.s()));
                } while (this.f5363a.e() < e3);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.f5363a.s()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
            } else {
                throw o0.d();
            }
        }
    }

    @Override // c.b.d.b2
    public int g() {
        V(0);
        return this.f5363a.H();
    }

    @Override // c.b.d.b2
    public int h() {
        V(0);
        return this.f5363a.u();
    }

    @Override // c.b.d.b2
    public int i() {
        return this.f5364b;
    }

    @Override // c.b.d.b2
    public long j() {
        V(0);
        return this.f5363a.I();
    }

    @Override // c.b.d.b2
    public void k(List<Integer> list) {
        int G;
        int G2;
        if (list instanceof m0) {
            m0 m0Var = (m0) list;
            int i = this.f5364b & 7;
            if (i == 2) {
                int H = this.f5363a.H();
                W(H);
                int e2 = this.f5363a.e() + H;
                do {
                    m0Var.c(this.f5363a.q());
                } while (this.f5363a.e() < e2);
            } else if (i == 5) {
                do {
                    m0Var.c(this.f5363a.q());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
            } else {
                throw o0.d();
            }
        } else {
            int i2 = this.f5364b & 7;
            if (i2 == 2) {
                int H2 = this.f5363a.H();
                W(H2);
                int e3 = this.f5363a.e() + H2;
                do {
                    list.add(Integer.valueOf(this.f5363a.q()));
                } while (this.f5363a.e() < e3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f5363a.q()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
            } else {
                throw o0.d();
            }
        }
    }

    @Override // c.b.d.b2
    public long l() {
        V(1);
        return this.f5363a.r();
    }

    @Override // c.b.d.b2
    public void m(List<Integer> list) {
        int G;
        int G2;
        if (list instanceof m0) {
            m0 m0Var = (m0) list;
            int i = this.f5364b & 7;
            if (i == 2) {
                int H = this.f5363a.H();
                W(H);
                int e2 = this.f5363a.e() + H;
                do {
                    m0Var.c(this.f5363a.A());
                } while (this.f5363a.e() < e2);
            } else if (i == 5) {
                do {
                    m0Var.c(this.f5363a.A());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
            } else {
                throw o0.d();
            }
        } else {
            int i2 = this.f5364b & 7;
            if (i2 == 2) {
                int H2 = this.f5363a.H();
                W(H2);
                int e3 = this.f5363a.e() + H2;
                do {
                    list.add(Integer.valueOf(this.f5363a.A()));
                } while (this.f5363a.e() < e3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f5363a.A()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
            } else {
                throw o0.d();
            }
        }
    }

    @Override // c.b.d.b2
    public boolean n() {
        int i;
        if (this.f5363a.f() || (i = this.f5364b) == this.f5365c) {
            return false;
        }
        return this.f5363a.J(i);
    }

    @Override // c.b.d.b2
    public int o() {
        V(0);
        return this.f5363a.C();
    }

    @Override // c.b.d.b2
    public void p(List<Long> list) {
        int i;
        int G;
        int G2;
        if (list instanceof v0) {
            v0 v0Var = (v0) list;
            int i2 = this.f5364b & 7;
            if (i2 == 0) {
                do {
                    v0Var.c(this.f5363a.D());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    v0Var.c(this.f5363a.D());
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        } else {
            int i3 = this.f5364b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f5363a.D()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
                return;
            } else if (i3 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    list.add(Long.valueOf(this.f5363a.D()));
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        }
        U(i);
    }

    @Override // c.b.d.b2
    public long q() {
        V(0);
        return this.f5363a.D();
    }

    @Override // c.b.d.b2
    public int r() {
        V(5);
        return this.f5363a.A();
    }

    @Override // c.b.d.b2
    public double readDouble() {
        V(1);
        return this.f5363a.o();
    }

    @Override // c.b.d.b2
    public float readFloat() {
        V(5);
        return this.f5363a.s();
    }

    @Override // c.b.d.b2
    public void s(List<j> list) {
        int G;
        if ((this.f5364b & 7) == 2) {
            do {
                list.add(c());
                if (!this.f5363a.f()) {
                    G = this.f5363a.G();
                } else {
                    return;
                }
            } while (G == this.f5364b);
            this.f5366d = G;
            return;
        }
        throw o0.d();
    }

    @Override // c.b.d.b2
    public void t(List<Integer> list) {
        int i;
        int G;
        int G2;
        if (list instanceof m0) {
            m0 m0Var = (m0) list;
            int i2 = this.f5364b & 7;
            if (i2 == 0) {
                do {
                    m0Var.c(this.f5363a.H());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    m0Var.c(this.f5363a.H());
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        } else {
            int i3 = this.f5364b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f5363a.H()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
                return;
            } else if (i3 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    list.add(Integer.valueOf(this.f5363a.H()));
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        }
        U(i);
    }

    @Override // c.b.d.b2
    public void u(List<Double> list) {
        int G;
        int G2;
        if (list instanceof t) {
            t tVar = (t) list;
            int i = this.f5364b & 7;
            if (i == 1) {
                do {
                    tVar.c(this.f5363a.o());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
            } else if (i == 2) {
                int H = this.f5363a.H();
                X(H);
                int e2 = this.f5363a.e() + H;
                do {
                    tVar.c(this.f5363a.o());
                } while (this.f5363a.e() < e2);
            } else {
                throw o0.d();
            }
        } else {
            int i2 = this.f5364b & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.f5363a.o()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
            } else if (i2 == 2) {
                int H2 = this.f5363a.H();
                X(H2);
                int e3 = this.f5363a.e() + H2;
                do {
                    list.add(Double.valueOf(this.f5363a.o()));
                } while (this.f5363a.e() < e3);
            } else {
                throw o0.d();
            }
        }
    }

    @Override // c.b.d.b2
    public void v(List<Long> list) {
        int i;
        int G;
        int G2;
        if (list instanceof v0) {
            v0 v0Var = (v0) list;
            int i2 = this.f5364b & 7;
            if (i2 == 0) {
                do {
                    v0Var.c(this.f5363a.v());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    v0Var.c(this.f5363a.v());
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        } else {
            int i3 = this.f5364b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f5363a.v()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
                return;
            } else if (i3 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    list.add(Long.valueOf(this.f5363a.v()));
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        }
        U(i);
    }

    @Override // c.b.d.b2
    public void w(List<Boolean> list) {
        int i;
        int G;
        int G2;
        if (list instanceof g) {
            g gVar = (g) list;
            int i2 = this.f5364b & 7;
            if (i2 == 0) {
                do {
                    gVar.c(this.f5363a.m());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    gVar.c(this.f5363a.m());
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        } else {
            int i3 = this.f5364b & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f5363a.m()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
                return;
            } else if (i3 == 2) {
                i = this.f5363a.e() + this.f5363a.H();
                do {
                    list.add(Boolean.valueOf(this.f5363a.m()));
                } while (this.f5363a.e() < i);
            } else {
                throw o0.d();
            }
        }
        U(i);
    }

    @Override // c.b.d.b2
    public void x(List<Long> list) {
        int G;
        int G2;
        if (list instanceof v0) {
            v0 v0Var = (v0) list;
            int i = this.f5364b & 7;
            if (i == 1) {
                do {
                    v0Var.c(this.f5363a.B());
                    if (!this.f5363a.f()) {
                        G2 = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f5364b);
                this.f5366d = G2;
            } else if (i == 2) {
                int H = this.f5363a.H();
                X(H);
                int e2 = this.f5363a.e() + H;
                do {
                    v0Var.c(this.f5363a.B());
                } while (this.f5363a.e() < e2);
            } else {
                throw o0.d();
            }
        } else {
            int i2 = this.f5364b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f5363a.B()));
                    if (!this.f5363a.f()) {
                        G = this.f5363a.G();
                    } else {
                        return;
                    }
                } while (G == this.f5364b);
                this.f5366d = G;
            } else if (i2 == 2) {
                int H2 = this.f5363a.H();
                X(H2);
                int e3 = this.f5363a.e() + H2;
                do {
                    list.add(Long.valueOf(this.f5363a.B()));
                } while (this.f5363a.e() < e3);
            } else {
                throw o0.d();
            }
        }
    }

    @Override // c.b.d.b2
    public String y() {
        V(2);
        return this.f5363a.E();
    }

    @Override // c.b.d.b2
    public long z() {
        V(0);
        return this.f5363a.v();
    }
}
