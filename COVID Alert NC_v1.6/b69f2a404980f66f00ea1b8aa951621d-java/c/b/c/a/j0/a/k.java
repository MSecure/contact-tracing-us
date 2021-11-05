package c.b.c.a.j0.a;

import c.b.c.a.j0.a.j;
import c.b.c.a.j0.a.k0;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class k implements e1 {

    /* renamed from: a  reason: collision with root package name */
    public final j f3595a;

    /* renamed from: b  reason: collision with root package name */
    public int f3596b;

    /* renamed from: c  reason: collision with root package name */
    public int f3597c;

    /* renamed from: d  reason: collision with root package name */
    public int f3598d = 0;

    public k(j jVar) {
        a0.b(jVar, "input");
        this.f3595a = jVar;
        jVar.f3589c = this;
    }

    @Override // c.b.c.a.j0.a.e1
    public String A() {
        U(2);
        j.b bVar = (j.b) this.f3595a;
        int r = bVar.r();
        if (r > 0 && r <= bVar.f - bVar.h) {
            String str = new String(bVar.f3590d, bVar.h, r, a0.f3518a);
            bVar.h += r;
            return str;
        } else if (r == 0) {
            return "";
        } else {
            if (r < 0) {
                throw b0.f();
            }
            throw b0.h();
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public long B() {
        U(0);
        return ((j.b) this.f3595a).s();
    }

    @Override // c.b.c.a.j0.a.e1
    public String C() {
        U(2);
        j.b bVar = (j.b) this.f3595a;
        int r = bVar.r();
        if (r > 0) {
            int i = bVar.f;
            int i2 = bVar.h;
            if (r <= i - i2) {
                String a2 = q1.f3635a.a(bVar.f3590d, i2, r);
                bVar.h += r;
                return a2;
            }
        }
        if (r == 0) {
            return "";
        }
        if (r <= 0) {
            throw b0.f();
        }
        throw b0.h();
    }

    @Override // c.b.c.a.j0.a.e1
    public int D() {
        U(5);
        return ((j.b) this.f3595a).p();
    }

    @Override // c.b.c.a.j0.a.e1
    public void E(List<Long> list) {
        int m;
        int m2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int i = this.f3596b & 7;
            if (i == 1) {
                do {
                    i0Var.c(((j.b) this.f3595a).q());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
            } else if (i == 2) {
                int r = ((j.b) this.f3595a).r();
                W(r);
                int d2 = this.f3595a.d() + r;
                do {
                    i0Var.c(((j.b) this.f3595a).q());
                } while (this.f3595a.d() < d2);
            } else {
                throw b0.d();
            }
        } else {
            int i2 = this.f3596b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((j.b) this.f3595a).q()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
            } else if (i2 == 2) {
                int r2 = ((j.b) this.f3595a).r();
                W(r2);
                int d3 = this.f3595a.d() + r2;
                do {
                    list.add(Long.valueOf(((j.b) this.f3595a).q()));
                } while (this.f3595a.d() < d3);
            } else {
                throw b0.d();
            }
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public void F(List<Integer> list) {
        int i;
        int m;
        int m2;
        if (list instanceof z) {
            z zVar = (z) list;
            int i2 = this.f3596b & 7;
            if (i2 == 0) {
                do {
                    zVar.c(((j.b) this.f3595a).r());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    zVar.c(((j.b) this.f3595a).r());
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f3596b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(((j.b) this.f3595a).r()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
                return;
            } else if (i3 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    list.add(Integer.valueOf(((j.b) this.f3595a).r()));
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        }
        T(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public boolean G() {
        U(0);
        return this.f3595a.h();
    }

    @Override // c.b.c.a.j0.a.e1
    public void H(List<Integer> list) {
        int i;
        int m;
        int m2;
        if (list instanceof z) {
            z zVar = (z) list;
            int i2 = this.f3596b & 7;
            if (i2 == 0) {
                do {
                    zVar.c(((j.b) this.f3595a).r());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    zVar.c(((j.b) this.f3595a).r());
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f3596b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(((j.b) this.f3595a).r()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
                return;
            } else if (i3 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    list.add(Integer.valueOf(((j.b) this.f3595a).r()));
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        }
        T(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public int I() {
        int i = this.f3598d;
        if (i != 0) {
            this.f3596b = i;
            this.f3598d = 0;
        } else {
            this.f3596b = this.f3595a.m();
        }
        int i2 = this.f3596b;
        if (i2 == 0 || i2 == this.f3597c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // c.b.c.a.j0.a.e1
    public void J(List<String> list) {
        S(list, false);
    }

    @Override // c.b.c.a.j0.a.e1
    public long K() {
        U(1);
        return ((j.b) this.f3595a).q();
    }

    @Override // c.b.c.a.j0.a.e1
    public <T> T L(f1<T> f1Var, q qVar) {
        U(3);
        return (T) Q(f1Var, qVar);
    }

    @Override // c.b.c.a.j0.a.e1
    public <T> T M(f1<T> f1Var, q qVar) {
        U(2);
        return (T) R(f1Var, qVar);
    }

    @Override // c.b.c.a.j0.a.e1
    public <K, V> void N(Map<K, V> map, k0.a<K, V> aVar, q qVar) {
        U(2);
        this.f3595a.g(((j.b) this.f3595a).r());
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.c.a.j0.a.e1
    public <T> void O(List<T> list, f1<T> f1Var, q qVar) {
        int m;
        int i = this.f3596b;
        if ((i & 7) == 3) {
            do {
                list.add(Q(f1Var, qVar));
                if (!this.f3595a.e() && this.f3598d == 0) {
                    m = this.f3595a.m();
                } else {
                    return;
                }
            } while (m == i);
            this.f3598d = m;
            return;
        }
        throw b0.d();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.c.a.j0.a.e1
    public <T> void P(List<T> list, f1<T> f1Var, q qVar) {
        int m;
        int i = this.f3596b;
        if ((i & 7) == 2) {
            do {
                list.add(R(f1Var, qVar));
                if (!this.f3595a.e() && this.f3598d == 0) {
                    m = this.f3595a.m();
                } else {
                    return;
                }
            } while (m == i);
            this.f3598d = m;
            return;
        }
        throw b0.d();
    }

    public final <T> T Q(f1<T> f1Var, q qVar) {
        int i = this.f3597c;
        this.f3597c = ((this.f3596b >>> 3) << 3) | 4;
        try {
            T e2 = f1Var.e();
            f1Var.j(e2, this, qVar);
            f1Var.f(e2);
            if (this.f3596b == this.f3597c) {
                return e2;
            }
            throw b0.g();
        } finally {
            this.f3597c = i;
        }
    }

    public final <T> T R(f1<T> f1Var, q qVar) {
        int r = ((j.b) this.f3595a).r();
        j jVar = this.f3595a;
        if (jVar.f3587a < jVar.f3588b) {
            int g = jVar.g(r);
            T e2 = f1Var.e();
            this.f3595a.f3587a++;
            f1Var.j(e2, this, qVar);
            f1Var.f(e2);
            this.f3595a.a(0);
            j jVar2 = this.f3595a;
            jVar2.f3587a--;
            j.b bVar = (j.b) jVar2;
            bVar.k = g;
            bVar.u();
            return e2;
        }
        throw new b0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public void S(List<String> list, boolean z) {
        int m;
        int m2;
        if ((this.f3596b & 7) != 2) {
            throw b0.d();
        } else if (!(list instanceof g0) || z) {
            do {
                list.add(z ? C() : A());
                if (!this.f3595a.e()) {
                    m = this.f3595a.m();
                } else {
                    return;
                }
            } while (m == this.f3596b);
            this.f3598d = m;
        } else {
            g0 g0Var = (g0) list;
            do {
                g0Var.n(c());
                if (!this.f3595a.e()) {
                    m2 = this.f3595a.m();
                } else {
                    return;
                }
            } while (m2 == this.f3596b);
            this.f3598d = m2;
        }
    }

    public final void T(int i) {
        if (this.f3595a.d() != i) {
            throw b0.h();
        }
    }

    public final void U(int i) {
        if ((this.f3596b & 7) != i) {
            throw b0.d();
        }
    }

    public final void V(int i) {
        if ((i & 3) != 0) {
            throw b0.g();
        }
    }

    public final void W(int i) {
        if ((i & 7) != 0) {
            throw b0.g();
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public void a(List<Long> list) {
        int i;
        int m;
        int m2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int i2 = this.f3596b & 7;
            if (i2 == 0) {
                do {
                    i0Var.c(((j.b) this.f3595a).s());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    i0Var.c(((j.b) this.f3595a).s());
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f3596b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(((j.b) this.f3595a).s()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
                return;
            } else if (i3 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    list.add(Long.valueOf(((j.b) this.f3595a).s()));
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        }
        T(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public void b(List<String> list) {
        S(list, true);
    }

    @Override // c.b.c.a.j0.a.e1
    public i c() {
        byte[] bArr;
        U(2);
        j.b bVar = (j.b) this.f3595a;
        int r = bVar.r();
        if (r > 0) {
            int i = bVar.f;
            int i2 = bVar.h;
            if (r <= i - i2) {
                i h = i.h(bVar.f3590d, i2, r);
                bVar.h += r;
                return h;
            }
        }
        if (r == 0) {
            return i.f3564c;
        }
        if (r > 0) {
            int i3 = bVar.f;
            int i4 = bVar.h;
            if (r <= i3 - i4) {
                int i5 = r + i4;
                bVar.h = i5;
                bArr = Arrays.copyOfRange(bVar.f3590d, i4, i5);
                return i.t(bArr);
            }
        }
        if (r > 0) {
            throw b0.h();
        } else if (r == 0) {
            bArr = a0.f3519b;
            return i.t(bArr);
        } else {
            throw b0.f();
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public void d(List<Integer> list) {
        int i;
        int m;
        int m2;
        if (list instanceof z) {
            z zVar = (z) list;
            int i2 = this.f3596b & 7;
            if (i2 == 0) {
                do {
                    zVar.c(this.f3595a.k());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    zVar.c(this.f3595a.k());
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f3596b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f3595a.k()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
                return;
            } else if (i3 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    list.add(Integer.valueOf(this.f3595a.k()));
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        }
        T(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public int e() {
        U(0);
        return ((j.b) this.f3595a).r();
    }

    @Override // c.b.c.a.j0.a.e1
    public void f(List<Float> list) {
        int m;
        int m2;
        if (list instanceof w) {
            w wVar = (w) list;
            int i = this.f3596b & 7;
            if (i == 2) {
                int r = ((j.b) this.f3595a).r();
                V(r);
                int d2 = this.f3595a.d() + r;
                do {
                    wVar.c(this.f3595a.j());
                } while (this.f3595a.d() < d2);
            } else if (i == 5) {
                do {
                    wVar.c(this.f3595a.j());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
            } else {
                throw b0.d();
            }
        } else {
            int i2 = this.f3596b & 7;
            if (i2 == 2) {
                int r2 = ((j.b) this.f3595a).r();
                V(r2);
                int d3 = this.f3595a.d() + r2;
                do {
                    list.add(Float.valueOf(this.f3595a.j()));
                } while (this.f3595a.d() < d3);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.f3595a.j()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
            } else {
                throw b0.d();
            }
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public int g() {
        U(0);
        return ((j.b) this.f3595a).r();
    }

    @Override // c.b.c.a.j0.a.e1
    public int h() {
        U(0);
        return ((j.b) this.f3595a).r();
    }

    @Override // c.b.c.a.j0.a.e1
    public int i() {
        return this.f3596b;
    }

    @Override // c.b.c.a.j0.a.e1
    public long j() {
        U(0);
        return ((j.b) this.f3595a).s();
    }

    @Override // c.b.c.a.j0.a.e1
    public void k(List<Integer> list) {
        int m;
        int m2;
        if (list instanceof z) {
            z zVar = (z) list;
            int i = this.f3596b & 7;
            if (i == 2) {
                int r = ((j.b) this.f3595a).r();
                V(r);
                int d2 = this.f3595a.d() + r;
                do {
                    zVar.c(((j.b) this.f3595a).p());
                } while (this.f3595a.d() < d2);
            } else if (i == 5) {
                do {
                    zVar.c(((j.b) this.f3595a).p());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
            } else {
                throw b0.d();
            }
        } else {
            int i2 = this.f3596b & 7;
            if (i2 == 2) {
                int r2 = ((j.b) this.f3595a).r();
                V(r2);
                int d3 = this.f3595a.d() + r2;
                do {
                    list.add(Integer.valueOf(((j.b) this.f3595a).p()));
                } while (this.f3595a.d() < d3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(((j.b) this.f3595a).p()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
            } else {
                throw b0.d();
            }
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public long l() {
        U(1);
        return ((j.b) this.f3595a).q();
    }

    @Override // c.b.c.a.j0.a.e1
    public double m() {
        U(1);
        return this.f3595a.i();
    }

    @Override // c.b.c.a.j0.a.e1
    public void n(List<Integer> list) {
        int m;
        int m2;
        if (list instanceof z) {
            z zVar = (z) list;
            int i = this.f3596b & 7;
            if (i == 2) {
                int r = ((j.b) this.f3595a).r();
                V(r);
                int d2 = this.f3595a.d() + r;
                do {
                    zVar.c(((j.b) this.f3595a).p());
                } while (this.f3595a.d() < d2);
            } else if (i == 5) {
                do {
                    zVar.c(((j.b) this.f3595a).p());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
            } else {
                throw b0.d();
            }
        } else {
            int i2 = this.f3596b & 7;
            if (i2 == 2) {
                int r2 = ((j.b) this.f3595a).r();
                V(r2);
                int d3 = this.f3595a.d() + r2;
                do {
                    list.add(Integer.valueOf(((j.b) this.f3595a).p()));
                } while (this.f3595a.d() < d3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(((j.b) this.f3595a).p()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
            } else {
                throw b0.d();
            }
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public boolean o() {
        int i;
        if (this.f3595a.e() || (i = this.f3596b) == this.f3597c) {
            return false;
        }
        return this.f3595a.n(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public int p() {
        U(0);
        return this.f3595a.k();
    }

    @Override // c.b.c.a.j0.a.e1
    public void q(List<Long> list) {
        int i;
        int m;
        int m2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int i2 = this.f3596b & 7;
            if (i2 == 0) {
                do {
                    i0Var.c(this.f3595a.l());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    i0Var.c(this.f3595a.l());
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f3596b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f3595a.l()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
                return;
            } else if (i3 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    list.add(Long.valueOf(this.f3595a.l()));
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        }
        T(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public float r() {
        U(5);
        return this.f3595a.j();
    }

    @Override // c.b.c.a.j0.a.e1
    public long s() {
        U(0);
        return this.f3595a.l();
    }

    @Override // c.b.c.a.j0.a.e1
    public int t() {
        U(5);
        return ((j.b) this.f3595a).p();
    }

    @Override // c.b.c.a.j0.a.e1
    public void u(List<i> list) {
        int m;
        if ((this.f3596b & 7) == 2) {
            do {
                list.add(c());
                if (!this.f3595a.e()) {
                    m = this.f3595a.m();
                } else {
                    return;
                }
            } while (m == this.f3596b);
            this.f3598d = m;
            return;
        }
        throw b0.d();
    }

    @Override // c.b.c.a.j0.a.e1
    public void v(List<Integer> list) {
        int i;
        int m;
        int m2;
        if (list instanceof z) {
            z zVar = (z) list;
            int i2 = this.f3596b & 7;
            if (i2 == 0) {
                do {
                    zVar.c(((j.b) this.f3595a).r());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    zVar.c(((j.b) this.f3595a).r());
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f3596b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(((j.b) this.f3595a).r()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
                return;
            } else if (i3 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    list.add(Integer.valueOf(((j.b) this.f3595a).r()));
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        }
        T(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public void w(List<Double> list) {
        int m;
        int m2;
        if (list instanceof n) {
            n nVar = (n) list;
            int i = this.f3596b & 7;
            if (i == 1) {
                do {
                    nVar.c(this.f3595a.i());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
            } else if (i == 2) {
                int r = ((j.b) this.f3595a).r();
                W(r);
                int d2 = this.f3595a.d() + r;
                do {
                    nVar.c(this.f3595a.i());
                } while (this.f3595a.d() < d2);
            } else {
                throw b0.d();
            }
        } else {
            int i2 = this.f3596b & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.f3595a.i()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
            } else if (i2 == 2) {
                int r2 = ((j.b) this.f3595a).r();
                W(r2);
                int d3 = this.f3595a.d() + r2;
                do {
                    list.add(Double.valueOf(this.f3595a.i()));
                } while (this.f3595a.d() < d3);
            } else {
                throw b0.d();
            }
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public void x(List<Long> list) {
        int i;
        int m;
        int m2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int i2 = this.f3596b & 7;
            if (i2 == 0) {
                do {
                    i0Var.c(((j.b) this.f3595a).s());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    i0Var.c(((j.b) this.f3595a).s());
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f3596b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(((j.b) this.f3595a).s()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
                return;
            } else if (i3 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    list.add(Long.valueOf(((j.b) this.f3595a).s()));
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        }
        T(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public void y(List<Boolean> list) {
        int i;
        int m;
        int m2;
        if (list instanceof f) {
            f fVar = (f) list;
            int i2 = this.f3596b & 7;
            if (i2 == 0) {
                do {
                    fVar.c(this.f3595a.h());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    fVar.c(this.f3595a.h());
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f3596b & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f3595a.h()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
                return;
            } else if (i3 == 2) {
                i = this.f3595a.d() + ((j.b) this.f3595a).r();
                do {
                    list.add(Boolean.valueOf(this.f3595a.h()));
                } while (this.f3595a.d() < i);
            } else {
                throw b0.d();
            }
        }
        T(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public void z(List<Long> list) {
        int m;
        int m2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int i = this.f3596b & 7;
            if (i == 1) {
                do {
                    i0Var.c(((j.b) this.f3595a).q());
                    if (!this.f3595a.e()) {
                        m2 = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f3596b);
                this.f3598d = m2;
            } else if (i == 2) {
                int r = ((j.b) this.f3595a).r();
                W(r);
                int d2 = this.f3595a.d() + r;
                do {
                    i0Var.c(((j.b) this.f3595a).q());
                } while (this.f3595a.d() < d2);
            } else {
                throw b0.d();
            }
        } else {
            int i2 = this.f3596b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((j.b) this.f3595a).q()));
                    if (!this.f3595a.e()) {
                        m = this.f3595a.m();
                    } else {
                        return;
                    }
                } while (m == this.f3596b);
                this.f3598d = m;
            } else if (i2 == 2) {
                int r2 = ((j.b) this.f3595a).r();
                W(r2);
                int d3 = this.f3595a.d() + r2;
                do {
                    list.add(Long.valueOf(((j.b) this.f3595a).q()));
                } while (this.f3595a.d() < d3);
            } else {
                throw b0.d();
            }
        }
    }
}
