package c.b.d;

import c.b.d.x0;
import java.util.List;
import java.util.Map;

public final class l implements a2 {

    /* renamed from: a  reason: collision with root package name */
    public final k f3983a;

    /* renamed from: b  reason: collision with root package name */
    public int f3984b;

    /* renamed from: c  reason: collision with root package name */
    public int f3985c;

    /* renamed from: d  reason: collision with root package name */
    public int f3986d = 0;

    public l(k kVar) {
        m0.b(kVar, "input");
        this.f3983a = kVar;
        kVar.f3937d = this;
    }

    @Override // c.b.d.a2
    public String A() {
        X(2);
        return this.f3983a.E();
    }

    @Override // c.b.d.a2
    public long B() {
        X(0);
        return this.f3983a.v();
    }

    @Override // c.b.d.a2
    public String C() {
        X(2);
        return this.f3983a.F();
    }

    @Override // c.b.d.a2
    public int D() {
        X(5);
        return this.f3983a.q();
    }

    @Override // c.b.d.a2
    public void E(List<Long> list) {
        int G;
        int G2;
        if (list instanceof u0) {
            u0 u0Var = (u0) list;
            int i = this.f3984b & 7;
            if (i == 1) {
                do {
                    u0Var.c(this.f3983a.r());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
            } else if (i == 2) {
                int H = this.f3983a.H();
                Z(H);
                int e2 = this.f3983a.e() + H;
                do {
                    u0Var.c(this.f3983a.r());
                } while (this.f3983a.e() < e2);
            } else {
                throw n0.d();
            }
        } else {
            int i2 = this.f3984b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f3983a.r()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
            } else if (i2 == 2) {
                int H2 = this.f3983a.H();
                Z(H2);
                int e3 = this.f3983a.e() + H2;
                do {
                    list.add(Long.valueOf(this.f3983a.r()));
                } while (this.f3983a.e() < e3);
            } else {
                throw n0.d();
            }
        }
    }

    @Override // c.b.d.a2
    public void F(List<Integer> list) {
        int i;
        int G;
        int G2;
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            int i2 = this.f3984b & 7;
            if (i2 == 0) {
                do {
                    l0Var.c(this.f3983a.u());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    l0Var.c(this.f3983a.u());
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        } else {
            int i3 = this.f3984b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3983a.u()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
                return;
            } else if (i3 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    list.add(Integer.valueOf(this.f3983a.u()));
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        }
        W(i);
    }

    @Override // c.b.d.a2
    public boolean G() {
        X(0);
        return this.f3983a.m();
    }

    @Override // c.b.d.a2
    public void H(List<Integer> list) {
        int i;
        int G;
        int G2;
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            int i2 = this.f3984b & 7;
            if (i2 == 0) {
                do {
                    l0Var.c(this.f3983a.p());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    l0Var.c(this.f3983a.p());
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        } else {
            int i3 = this.f3984b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3983a.p()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
                return;
            } else if (i3 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    list.add(Integer.valueOf(this.f3983a.p()));
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        }
        W(i);
    }

    @Override // c.b.d.a2
    public int I() {
        int i = this.f3986d;
        if (i != 0) {
            this.f3984b = i;
            this.f3986d = 0;
        } else {
            this.f3984b = this.f3983a.G();
        }
        int i2 = this.f3984b;
        if (i2 == 0 || i2 == this.f3985c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // c.b.d.a2
    public void J(List<String> list) {
        V(list, false);
    }

    @Override // c.b.d.a2
    public long K() {
        X(1);
        return this.f3983a.B();
    }

    @Override // c.b.d.a2
    public <K, V> void L(Map<K, V> map, x0.a<K, V> aVar, z zVar) {
        X(2);
        this.f3983a.l(this.f3983a.H());
        throw null;
    }

    @Override // c.b.d.a2
    public <T> T M(c2<T> c2Var, z zVar) {
        X(3);
        return (T) T(c2Var, zVar);
    }

    @Override // c.b.d.a2
    public boolean N() {
        return this.f3983a.f3938e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.d.a2
    public <T> void O(List<T> list, c2<T> c2Var, z zVar) {
        int G;
        int i = this.f3984b;
        if ((i & 7) == 3) {
            do {
                list.add(T(c2Var, zVar));
                if (!this.f3983a.f() && this.f3986d == 0) {
                    G = this.f3983a.G();
                } else {
                    return;
                }
            } while (G == i);
            this.f3986d = G;
            return;
        }
        throw n0.d();
    }

    @Override // c.b.d.a2
    public <T> T P(Class<T> cls, z zVar) {
        X(2);
        return (T) U(y1.f4411c.a(cls), zVar);
    }

    @Override // c.b.d.a2
    public <T> T Q(Class<T> cls, z zVar) {
        X(3);
        return (T) T(y1.f4411c.a(cls), zVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.d.a2
    public <T> void R(List<T> list, c2<T> c2Var, z zVar) {
        int G;
        int i = this.f3984b;
        if ((i & 7) == 2) {
            do {
                list.add(U(c2Var, zVar));
                if (!this.f3983a.f() && this.f3986d == 0) {
                    G = this.f3983a.G();
                } else {
                    return;
                }
            } while (G == i);
            this.f3986d = G;
            return;
        }
        throw n0.d();
    }

    @Override // c.b.d.a2
    public <T> T S(c2<T> c2Var, z zVar) {
        X(2);
        return (T) U(c2Var, zVar);
    }

    public final <T> T T(c2<T> c2Var, z zVar) {
        int i = this.f3985c;
        this.f3985c = ((this.f3984b >>> 3) << 3) | 4;
        try {
            T e2 = c2Var.e();
            c2Var.h(e2, this, zVar);
            c2Var.f(e2);
            if (this.f3984b == this.f3985c) {
                return e2;
            }
            throw n0.g();
        } finally {
            this.f3985c = i;
        }
    }

    public final <T> T U(c2<T> c2Var, z zVar) {
        int H = this.f3983a.H();
        k kVar = this.f3983a;
        if (kVar.f3934a < kVar.f3935b) {
            int l = kVar.l(H);
            T e2 = c2Var.e();
            this.f3983a.f3934a++;
            c2Var.h(e2, this, zVar);
            c2Var.f(e2);
            this.f3983a.a(0);
            k kVar2 = this.f3983a;
            kVar2.f3934a--;
            kVar2.k(l);
            return e2;
        }
        throw n0.h();
    }

    public void V(List<String> list, boolean z) {
        int G;
        int G2;
        if ((this.f3984b & 7) != 2) {
            throw n0.d();
        } else if (!(list instanceof s0) || z) {
            do {
                list.add(z ? C() : A());
                if (!this.f3983a.f()) {
                    G = this.f3983a.G();
                } else {
                    return;
                }
            } while (G == this.f3984b);
            this.f3986d = G;
        } else {
            s0 s0Var = (s0) list;
            do {
                s0Var.l(c());
                if (!this.f3983a.f()) {
                    G2 = this.f3983a.G();
                } else {
                    return;
                }
            } while (G2 == this.f3984b);
            this.f3986d = G2;
        }
    }

    public final void W(int i) {
        if (this.f3983a.e() != i) {
            throw n0.i();
        }
    }

    public final void X(int i) {
        if ((this.f3984b & 7) != i) {
            throw n0.d();
        }
    }

    public final void Y(int i) {
        if ((i & 3) != 0) {
            throw n0.g();
        }
    }

    public final void Z(int i) {
        if ((i & 7) != 0) {
            throw n0.g();
        }
    }

    @Override // c.b.d.a2
    public void a(List<Long> list) {
        int i;
        int G;
        int G2;
        if (list instanceof u0) {
            u0 u0Var = (u0) list;
            int i2 = this.f3984b & 7;
            if (i2 == 0) {
                do {
                    u0Var.c(this.f3983a.I());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    u0Var.c(this.f3983a.I());
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        } else {
            int i3 = this.f3984b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f3983a.I()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
                return;
            } else if (i3 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    list.add(Long.valueOf(this.f3983a.I()));
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        }
        W(i);
    }

    @Override // c.b.d.a2
    public void b(List<String> list) {
        V(list, true);
    }

    @Override // c.b.d.a2
    public j c() {
        X(2);
        return this.f3983a.n();
    }

    @Override // c.b.d.a2
    public void d(List<Integer> list) {
        int i;
        int G;
        int G2;
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            int i2 = this.f3984b & 7;
            if (i2 == 0) {
                do {
                    l0Var.c(this.f3983a.C());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    l0Var.c(this.f3983a.C());
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        } else {
            int i3 = this.f3984b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3983a.C()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
                return;
            } else if (i3 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    list.add(Integer.valueOf(this.f3983a.C()));
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        }
        W(i);
    }

    @Override // c.b.d.a2
    public int e() {
        X(0);
        return this.f3983a.p();
    }

    @Override // c.b.d.a2
    public void f(List<Float> list) {
        int G;
        int G2;
        if (list instanceof h0) {
            h0 h0Var = (h0) list;
            int i = this.f3984b & 7;
            if (i == 2) {
                int H = this.f3983a.H();
                Y(H);
                int e2 = this.f3983a.e() + H;
                do {
                    h0Var.c(this.f3983a.s());
                } while (this.f3983a.e() < e2);
            } else if (i == 5) {
                do {
                    h0Var.c(this.f3983a.s());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
            } else {
                throw n0.d();
            }
        } else {
            int i2 = this.f3984b & 7;
            if (i2 == 2) {
                int H2 = this.f3983a.H();
                Y(H2);
                int e3 = this.f3983a.e() + H2;
                do {
                    list.add(Float.valueOf(this.f3983a.s()));
                } while (this.f3983a.e() < e3);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.f3983a.s()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
            } else {
                throw n0.d();
            }
        }
    }

    @Override // c.b.d.a2
    public int g() {
        X(0);
        return this.f3983a.H();
    }

    @Override // c.b.d.a2
    public int h() {
        X(0);
        return this.f3983a.u();
    }

    @Override // c.b.d.a2
    public int i() {
        return this.f3984b;
    }

    @Override // c.b.d.a2
    public long j() {
        X(0);
        return this.f3983a.I();
    }

    @Override // c.b.d.a2
    public void k(List<Integer> list) {
        int G;
        int G2;
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            int i = this.f3984b & 7;
            if (i == 2) {
                int H = this.f3983a.H();
                Y(H);
                int e2 = this.f3983a.e() + H;
                do {
                    l0Var.c(this.f3983a.q());
                } while (this.f3983a.e() < e2);
            } else if (i == 5) {
                do {
                    l0Var.c(this.f3983a.q());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
            } else {
                throw n0.d();
            }
        } else {
            int i2 = this.f3984b & 7;
            if (i2 == 2) {
                int H2 = this.f3983a.H();
                Y(H2);
                int e3 = this.f3983a.e() + H2;
                do {
                    list.add(Integer.valueOf(this.f3983a.q()));
                } while (this.f3983a.e() < e3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f3983a.q()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
            } else {
                throw n0.d();
            }
        }
    }

    @Override // c.b.d.a2
    public long l() {
        X(1);
        return this.f3983a.r();
    }

    @Override // c.b.d.a2
    public double m() {
        X(1);
        return this.f3983a.o();
    }

    @Override // c.b.d.a2
    public void n(List<Integer> list) {
        int G;
        int G2;
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            int i = this.f3984b & 7;
            if (i == 2) {
                int H = this.f3983a.H();
                Y(H);
                int e2 = this.f3983a.e() + H;
                do {
                    l0Var.c(this.f3983a.A());
                } while (this.f3983a.e() < e2);
            } else if (i == 5) {
                do {
                    l0Var.c(this.f3983a.A());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
            } else {
                throw n0.d();
            }
        } else {
            int i2 = this.f3984b & 7;
            if (i2 == 2) {
                int H2 = this.f3983a.H();
                Y(H2);
                int e3 = this.f3983a.e() + H2;
                do {
                    list.add(Integer.valueOf(this.f3983a.A()));
                } while (this.f3983a.e() < e3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f3983a.A()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
            } else {
                throw n0.d();
            }
        }
    }

    @Override // c.b.d.a2
    public boolean o() {
        int i;
        if (this.f3983a.f() || (i = this.f3984b) == this.f3985c) {
            return false;
        }
        return this.f3983a.J(i);
    }

    @Override // c.b.d.a2
    public int p() {
        X(0);
        return this.f3983a.C();
    }

    @Override // c.b.d.a2
    public void q(List<Long> list) {
        int i;
        int G;
        int G2;
        if (list instanceof u0) {
            u0 u0Var = (u0) list;
            int i2 = this.f3984b & 7;
            if (i2 == 0) {
                do {
                    u0Var.c(this.f3983a.D());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    u0Var.c(this.f3983a.D());
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        } else {
            int i3 = this.f3984b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f3983a.D()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
                return;
            } else if (i3 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    list.add(Long.valueOf(this.f3983a.D()));
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        }
        W(i);
    }

    @Override // c.b.d.a2
    public float r() {
        X(5);
        return this.f3983a.s();
    }

    @Override // c.b.d.a2
    public long s() {
        X(0);
        return this.f3983a.D();
    }

    @Override // c.b.d.a2
    public int t() {
        X(5);
        return this.f3983a.A();
    }

    @Override // c.b.d.a2
    public void u(List<j> list) {
        int G;
        if ((this.f3984b & 7) == 2) {
            do {
                list.add(c());
                if (!this.f3983a.f()) {
                    G = this.f3983a.G();
                } else {
                    return;
                }
            } while (G == this.f3984b);
            this.f3986d = G;
            return;
        }
        throw n0.d();
    }

    @Override // c.b.d.a2
    public void v(List<Integer> list) {
        int i;
        int G;
        int G2;
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            int i2 = this.f3984b & 7;
            if (i2 == 0) {
                do {
                    l0Var.c(this.f3983a.H());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    l0Var.c(this.f3983a.H());
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        } else {
            int i3 = this.f3984b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3983a.H()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
                return;
            } else if (i3 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    list.add(Integer.valueOf(this.f3983a.H()));
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        }
        W(i);
    }

    @Override // c.b.d.a2
    public void w(List<Double> list) {
        int G;
        int G2;
        if (list instanceof t) {
            t tVar = (t) list;
            int i = this.f3984b & 7;
            if (i == 1) {
                do {
                    tVar.c(this.f3983a.o());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
            } else if (i == 2) {
                int H = this.f3983a.H();
                Z(H);
                int e2 = this.f3983a.e() + H;
                do {
                    tVar.c(this.f3983a.o());
                } while (this.f3983a.e() < e2);
            } else {
                throw n0.d();
            }
        } else {
            int i2 = this.f3984b & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.f3983a.o()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
            } else if (i2 == 2) {
                int H2 = this.f3983a.H();
                Z(H2);
                int e3 = this.f3983a.e() + H2;
                do {
                    list.add(Double.valueOf(this.f3983a.o()));
                } while (this.f3983a.e() < e3);
            } else {
                throw n0.d();
            }
        }
    }

    @Override // c.b.d.a2
    public void x(List<Long> list) {
        int i;
        int G;
        int G2;
        if (list instanceof u0) {
            u0 u0Var = (u0) list;
            int i2 = this.f3984b & 7;
            if (i2 == 0) {
                do {
                    u0Var.c(this.f3983a.v());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    u0Var.c(this.f3983a.v());
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        } else {
            int i3 = this.f3984b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f3983a.v()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
                return;
            } else if (i3 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    list.add(Long.valueOf(this.f3983a.v()));
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        }
        W(i);
    }

    @Override // c.b.d.a2
    public void y(List<Boolean> list) {
        int i;
        int G;
        int G2;
        if (list instanceof g) {
            g gVar = (g) list;
            int i2 = this.f3984b & 7;
            if (i2 == 0) {
                do {
                    gVar.c(this.f3983a.m());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
                return;
            } else if (i2 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    gVar.c(this.f3983a.m());
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        } else {
            int i3 = this.f3984b & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f3983a.m()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
                return;
            } else if (i3 == 2) {
                i = this.f3983a.e() + this.f3983a.H();
                do {
                    list.add(Boolean.valueOf(this.f3983a.m()));
                } while (this.f3983a.e() < i);
            } else {
                throw n0.d();
            }
        }
        W(i);
    }

    @Override // c.b.d.a2
    public void z(List<Long> list) {
        int G;
        int G2;
        if (list instanceof u0) {
            u0 u0Var = (u0) list;
            int i = this.f3984b & 7;
            if (i == 1) {
                do {
                    u0Var.c(this.f3983a.B());
                    if (!this.f3983a.f()) {
                        G2 = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G2 == this.f3984b);
                this.f3986d = G2;
            } else if (i == 2) {
                int H = this.f3983a.H();
                Z(H);
                int e2 = this.f3983a.e() + H;
                do {
                    u0Var.c(this.f3983a.B());
                } while (this.f3983a.e() < e2);
            } else {
                throw n0.d();
            }
        } else {
            int i2 = this.f3984b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f3983a.B()));
                    if (!this.f3983a.f()) {
                        G = this.f3983a.G();
                    } else {
                        return;
                    }
                } while (G == this.f3984b);
                this.f3986d = G;
            } else if (i2 == 2) {
                int H2 = this.f3983a.H();
                Z(H2);
                int e3 = this.f3983a.e() + H2;
                do {
                    list.add(Long.valueOf(this.f3983a.B()));
                } while (this.f3983a.e() < e3);
            } else {
                throw n0.d();
            }
        }
    }
}
