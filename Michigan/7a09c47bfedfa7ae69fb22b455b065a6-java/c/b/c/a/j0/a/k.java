package c.b.c.a.j0.a;

import c.b.c.a.j0.a.j;
import c.b.c.a.j0.a.k0;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class k implements e1 {

    /* renamed from: a  reason: collision with root package name */
    public final j f4970a;

    /* renamed from: b  reason: collision with root package name */
    public int f4971b;

    /* renamed from: c  reason: collision with root package name */
    public int f4972c;

    /* renamed from: d  reason: collision with root package name */
    public int f4973d = 0;

    public k(j jVar) {
        a0.b(jVar, "input");
        this.f4970a = jVar;
        jVar.f4962c = this;
    }

    @Override // c.b.c.a.j0.a.e1
    public String A() {
        S(2);
        j.b bVar = (j.b) this.f4970a;
        int r = bVar.r();
        if (r > 0) {
            int i = bVar.f4965f;
            int i2 = bVar.h;
            if (r <= i - i2) {
                String a2 = q1.f5014a.a(bVar.f4963d, i2, r);
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
    public int B() {
        S(5);
        return ((j.b) this.f4970a).p();
    }

    @Override // c.b.c.a.j0.a.e1
    public void C(List<Long> list) {
        int m;
        int m2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int i = this.f4971b & 7;
            if (i == 1) {
                do {
                    i0Var.c(((j.b) this.f4970a).q());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
            } else if (i == 2) {
                int r = ((j.b) this.f4970a).r();
                U(r);
                int d2 = this.f4970a.d() + r;
                do {
                    i0Var.c(((j.b) this.f4970a).q());
                } while (this.f4970a.d() < d2);
            } else {
                throw b0.d();
            }
        } else {
            int i2 = this.f4971b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((j.b) this.f4970a).q()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
            } else if (i2 == 2) {
                int r2 = ((j.b) this.f4970a).r();
                U(r2);
                int d3 = this.f4970a.d() + r2;
                do {
                    list.add(Long.valueOf(((j.b) this.f4970a).q()));
                } while (this.f4970a.d() < d3);
            } else {
                throw b0.d();
            }
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public void D(List<Integer> list) {
        int i;
        int m;
        int m2;
        if (list instanceof z) {
            z zVar = (z) list;
            int i2 = this.f4971b & 7;
            if (i2 == 0) {
                do {
                    zVar.c(((j.b) this.f4970a).r());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    zVar.c(((j.b) this.f4970a).r());
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f4971b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(((j.b) this.f4970a).r()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
                return;
            } else if (i3 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    list.add(Integer.valueOf(((j.b) this.f4970a).r()));
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        }
        R(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public boolean E() {
        S(0);
        return this.f4970a.h();
    }

    @Override // c.b.c.a.j0.a.e1
    public void F(List<Integer> list) {
        int i;
        int m;
        int m2;
        if (list instanceof z) {
            z zVar = (z) list;
            int i2 = this.f4971b & 7;
            if (i2 == 0) {
                do {
                    zVar.c(((j.b) this.f4970a).r());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    zVar.c(((j.b) this.f4970a).r());
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f4971b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(((j.b) this.f4970a).r()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
                return;
            } else if (i3 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    list.add(Integer.valueOf(((j.b) this.f4970a).r()));
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        }
        R(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public int G() {
        int i = this.f4973d;
        if (i != 0) {
            this.f4971b = i;
            this.f4973d = 0;
        } else {
            this.f4971b = this.f4970a.m();
        }
        int i2 = this.f4971b;
        if (i2 == 0 || i2 == this.f4972c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // c.b.c.a.j0.a.e1
    public void H(List<String> list) {
        Q(list, false);
    }

    @Override // c.b.c.a.j0.a.e1
    public long I() {
        S(1);
        return ((j.b) this.f4970a).q();
    }

    @Override // c.b.c.a.j0.a.e1
    public <T> T J(f1<T> f1Var, q qVar) {
        S(3);
        return (T) O(f1Var, qVar);
    }

    @Override // c.b.c.a.j0.a.e1
    public <T> T K(f1<T> f1Var, q qVar) {
        S(2);
        return (T) P(f1Var, qVar);
    }

    @Override // c.b.c.a.j0.a.e1
    public <K, V> void L(Map<K, V> map, k0.a<K, V> aVar, q qVar) {
        S(2);
        this.f4970a.g(((j.b) this.f4970a).r());
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.c.a.j0.a.e1
    public <T> void M(List<T> list, f1<T> f1Var, q qVar) {
        int m;
        int i = this.f4971b;
        if ((i & 7) == 3) {
            do {
                list.add(O(f1Var, qVar));
                if (!this.f4970a.e() && this.f4973d == 0) {
                    m = this.f4970a.m();
                } else {
                    return;
                }
            } while (m == i);
            this.f4973d = m;
            return;
        }
        throw b0.d();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.c.a.j0.a.e1
    public <T> void N(List<T> list, f1<T> f1Var, q qVar) {
        int m;
        int i = this.f4971b;
        if ((i & 7) == 2) {
            do {
                list.add(P(f1Var, qVar));
                if (!this.f4970a.e() && this.f4973d == 0) {
                    m = this.f4970a.m();
                } else {
                    return;
                }
            } while (m == i);
            this.f4973d = m;
            return;
        }
        throw b0.d();
    }

    public final <T> T O(f1<T> f1Var, q qVar) {
        int i = this.f4972c;
        this.f4972c = ((this.f4971b >>> 3) << 3) | 4;
        try {
            T c2 = f1Var.c();
            f1Var.j(c2, this, qVar);
            f1Var.g(c2);
            if (this.f4971b == this.f4972c) {
                return c2;
            }
            throw b0.g();
        } finally {
            this.f4972c = i;
        }
    }

    public final <T> T P(f1<T> f1Var, q qVar) {
        int r = ((j.b) this.f4970a).r();
        j jVar = this.f4970a;
        if (jVar.f4960a < jVar.f4961b) {
            int g2 = jVar.g(r);
            T c2 = f1Var.c();
            this.f4970a.f4960a++;
            f1Var.j(c2, this, qVar);
            f1Var.g(c2);
            this.f4970a.a(0);
            j jVar2 = this.f4970a;
            jVar2.f4960a--;
            j.b bVar = (j.b) jVar2;
            bVar.k = g2;
            bVar.u();
            return c2;
        }
        throw new b0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public void Q(List<String> list, boolean z) {
        int m;
        int m2;
        if ((this.f4971b & 7) != 2) {
            throw b0.d();
        } else if (!(list instanceof g0) || z) {
            do {
                list.add(z ? A() : y());
                if (!this.f4970a.e()) {
                    m = this.f4970a.m();
                } else {
                    return;
                }
            } while (m == this.f4971b);
            this.f4973d = m;
        } else {
            g0 g0Var = (g0) list;
            do {
                g0Var.L(c());
                if (!this.f4970a.e()) {
                    m2 = this.f4970a.m();
                } else {
                    return;
                }
            } while (m2 == this.f4971b);
            this.f4973d = m2;
        }
    }

    public final void R(int i) {
        if (this.f4970a.d() != i) {
            throw b0.h();
        }
    }

    public final void S(int i) {
        if ((this.f4971b & 7) != i) {
            throw b0.d();
        }
    }

    public final void T(int i) {
        if ((i & 3) != 0) {
            throw b0.g();
        }
    }

    public final void U(int i) {
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
            int i2 = this.f4971b & 7;
            if (i2 == 0) {
                do {
                    i0Var.c(((j.b) this.f4970a).s());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    i0Var.c(((j.b) this.f4970a).s());
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f4971b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(((j.b) this.f4970a).s()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
                return;
            } else if (i3 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    list.add(Long.valueOf(((j.b) this.f4970a).s()));
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        }
        R(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public void b(List<String> list) {
        Q(list, true);
    }

    @Override // c.b.c.a.j0.a.e1
    public i c() {
        byte[] bArr;
        S(2);
        j.b bVar = (j.b) this.f4970a;
        int r = bVar.r();
        if (r > 0) {
            int i = bVar.f4965f;
            int i2 = bVar.h;
            if (r <= i - i2) {
                i g2 = i.g(bVar.f4963d, i2, r);
                bVar.h += r;
                return g2;
            }
        }
        if (r == 0) {
            return i.f4933c;
        }
        if (r > 0) {
            int i3 = bVar.f4965f;
            int i4 = bVar.h;
            if (r <= i3 - i4) {
                int i5 = r + i4;
                bVar.h = i5;
                bArr = Arrays.copyOfRange(bVar.f4963d, i4, i5);
                return i.v(bArr);
            }
        }
        if (r > 0) {
            throw b0.h();
        } else if (r == 0) {
            bArr = a0.f4886b;
            return i.v(bArr);
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
            int i2 = this.f4971b & 7;
            if (i2 == 0) {
                do {
                    zVar.c(this.f4970a.k());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    zVar.c(this.f4970a.k());
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f4971b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f4970a.k()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
                return;
            } else if (i3 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    list.add(Integer.valueOf(this.f4970a.k()));
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        }
        R(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public int e() {
        S(0);
        return ((j.b) this.f4970a).r();
    }

    @Override // c.b.c.a.j0.a.e1
    public void f(List<Float> list) {
        int m;
        int m2;
        if (list instanceof w) {
            w wVar = (w) list;
            int i = this.f4971b & 7;
            if (i == 2) {
                int r = ((j.b) this.f4970a).r();
                T(r);
                int d2 = this.f4970a.d() + r;
                do {
                    wVar.c(this.f4970a.j());
                } while (this.f4970a.d() < d2);
            } else if (i == 5) {
                do {
                    wVar.c(this.f4970a.j());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
            } else {
                throw b0.d();
            }
        } else {
            int i2 = this.f4971b & 7;
            if (i2 == 2) {
                int r2 = ((j.b) this.f4970a).r();
                T(r2);
                int d3 = this.f4970a.d() + r2;
                do {
                    list.add(Float.valueOf(this.f4970a.j()));
                } while (this.f4970a.d() < d3);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.f4970a.j()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
            } else {
                throw b0.d();
            }
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public int g() {
        S(0);
        return ((j.b) this.f4970a).r();
    }

    @Override // c.b.c.a.j0.a.e1
    public int h() {
        S(0);
        return ((j.b) this.f4970a).r();
    }

    @Override // c.b.c.a.j0.a.e1
    public int i() {
        return this.f4971b;
    }

    @Override // c.b.c.a.j0.a.e1
    public long j() {
        S(0);
        return ((j.b) this.f4970a).s();
    }

    @Override // c.b.c.a.j0.a.e1
    public void k(List<Integer> list) {
        int m;
        int m2;
        if (list instanceof z) {
            z zVar = (z) list;
            int i = this.f4971b & 7;
            if (i == 2) {
                int r = ((j.b) this.f4970a).r();
                T(r);
                int d2 = this.f4970a.d() + r;
                do {
                    zVar.c(((j.b) this.f4970a).p());
                } while (this.f4970a.d() < d2);
            } else if (i == 5) {
                do {
                    zVar.c(((j.b) this.f4970a).p());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
            } else {
                throw b0.d();
            }
        } else {
            int i2 = this.f4971b & 7;
            if (i2 == 2) {
                int r2 = ((j.b) this.f4970a).r();
                T(r2);
                int d3 = this.f4970a.d() + r2;
                do {
                    list.add(Integer.valueOf(((j.b) this.f4970a).p()));
                } while (this.f4970a.d() < d3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(((j.b) this.f4970a).p()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
            } else {
                throw b0.d();
            }
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public long l() {
        S(1);
        return ((j.b) this.f4970a).q();
    }

    @Override // c.b.c.a.j0.a.e1
    public void m(List<Integer> list) {
        int m;
        int m2;
        if (list instanceof z) {
            z zVar = (z) list;
            int i = this.f4971b & 7;
            if (i == 2) {
                int r = ((j.b) this.f4970a).r();
                T(r);
                int d2 = this.f4970a.d() + r;
                do {
                    zVar.c(((j.b) this.f4970a).p());
                } while (this.f4970a.d() < d2);
            } else if (i == 5) {
                do {
                    zVar.c(((j.b) this.f4970a).p());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
            } else {
                throw b0.d();
            }
        } else {
            int i2 = this.f4971b & 7;
            if (i2 == 2) {
                int r2 = ((j.b) this.f4970a).r();
                T(r2);
                int d3 = this.f4970a.d() + r2;
                do {
                    list.add(Integer.valueOf(((j.b) this.f4970a).p()));
                } while (this.f4970a.d() < d3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(((j.b) this.f4970a).p()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
            } else {
                throw b0.d();
            }
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public boolean n() {
        int i;
        if (this.f4970a.e() || (i = this.f4971b) == this.f4972c) {
            return false;
        }
        return this.f4970a.n(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public int o() {
        S(0);
        return this.f4970a.k();
    }

    @Override // c.b.c.a.j0.a.e1
    public void p(List<Long> list) {
        int i;
        int m;
        int m2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int i2 = this.f4971b & 7;
            if (i2 == 0) {
                do {
                    i0Var.c(this.f4970a.l());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    i0Var.c(this.f4970a.l());
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f4971b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f4970a.l()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
                return;
            } else if (i3 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    list.add(Long.valueOf(this.f4970a.l()));
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        }
        R(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public long q() {
        S(0);
        return this.f4970a.l();
    }

    @Override // c.b.c.a.j0.a.e1
    public int r() {
        S(5);
        return ((j.b) this.f4970a).p();
    }

    @Override // c.b.c.a.j0.a.e1
    public double readDouble() {
        S(1);
        return this.f4970a.i();
    }

    @Override // c.b.c.a.j0.a.e1
    public float readFloat() {
        S(5);
        return this.f4970a.j();
    }

    @Override // c.b.c.a.j0.a.e1
    public void s(List<i> list) {
        int m;
        if ((this.f4971b & 7) == 2) {
            do {
                list.add(c());
                if (!this.f4970a.e()) {
                    m = this.f4970a.m();
                } else {
                    return;
                }
            } while (m == this.f4971b);
            this.f4973d = m;
            return;
        }
        throw b0.d();
    }

    @Override // c.b.c.a.j0.a.e1
    public void t(List<Integer> list) {
        int i;
        int m;
        int m2;
        if (list instanceof z) {
            z zVar = (z) list;
            int i2 = this.f4971b & 7;
            if (i2 == 0) {
                do {
                    zVar.c(((j.b) this.f4970a).r());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    zVar.c(((j.b) this.f4970a).r());
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f4971b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(((j.b) this.f4970a).r()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
                return;
            } else if (i3 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    list.add(Integer.valueOf(((j.b) this.f4970a).r()));
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        }
        R(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public void u(List<Double> list) {
        int m;
        int m2;
        if (list instanceof n) {
            n nVar = (n) list;
            int i = this.f4971b & 7;
            if (i == 1) {
                do {
                    nVar.c(this.f4970a.i());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
            } else if (i == 2) {
                int r = ((j.b) this.f4970a).r();
                U(r);
                int d2 = this.f4970a.d() + r;
                do {
                    nVar.c(this.f4970a.i());
                } while (this.f4970a.d() < d2);
            } else {
                throw b0.d();
            }
        } else {
            int i2 = this.f4971b & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.f4970a.i()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
            } else if (i2 == 2) {
                int r2 = ((j.b) this.f4970a).r();
                U(r2);
                int d3 = this.f4970a.d() + r2;
                do {
                    list.add(Double.valueOf(this.f4970a.i()));
                } while (this.f4970a.d() < d3);
            } else {
                throw b0.d();
            }
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public void v(List<Long> list) {
        int i;
        int m;
        int m2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int i2 = this.f4971b & 7;
            if (i2 == 0) {
                do {
                    i0Var.c(((j.b) this.f4970a).s());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    i0Var.c(((j.b) this.f4970a).s());
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f4971b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(((j.b) this.f4970a).s()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
                return;
            } else if (i3 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    list.add(Long.valueOf(((j.b) this.f4970a).s()));
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        }
        R(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public void w(List<Boolean> list) {
        int i;
        int m;
        int m2;
        if (list instanceof f) {
            f fVar = (f) list;
            int i2 = this.f4971b & 7;
            if (i2 == 0) {
                do {
                    fVar.c(this.f4970a.h());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
                return;
            } else if (i2 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    fVar.c(this.f4970a.h());
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        } else {
            int i3 = this.f4971b & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f4970a.h()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
                return;
            } else if (i3 == 2) {
                i = this.f4970a.d() + ((j.b) this.f4970a).r();
                do {
                    list.add(Boolean.valueOf(this.f4970a.h()));
                } while (this.f4970a.d() < i);
            } else {
                throw b0.d();
            }
        }
        R(i);
    }

    @Override // c.b.c.a.j0.a.e1
    public void x(List<Long> list) {
        int m;
        int m2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int i = this.f4971b & 7;
            if (i == 1) {
                do {
                    i0Var.c(((j.b) this.f4970a).q());
                    if (!this.f4970a.e()) {
                        m2 = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m2 == this.f4971b);
                this.f4973d = m2;
            } else if (i == 2) {
                int r = ((j.b) this.f4970a).r();
                U(r);
                int d2 = this.f4970a.d() + r;
                do {
                    i0Var.c(((j.b) this.f4970a).q());
                } while (this.f4970a.d() < d2);
            } else {
                throw b0.d();
            }
        } else {
            int i2 = this.f4971b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((j.b) this.f4970a).q()));
                    if (!this.f4970a.e()) {
                        m = this.f4970a.m();
                    } else {
                        return;
                    }
                } while (m == this.f4971b);
                this.f4973d = m;
            } else if (i2 == 2) {
                int r2 = ((j.b) this.f4970a).r();
                U(r2);
                int d3 = this.f4970a.d() + r2;
                do {
                    list.add(Long.valueOf(((j.b) this.f4970a).q()));
                } while (this.f4970a.d() < d3);
            } else {
                throw b0.d();
            }
        }
    }

    @Override // c.b.c.a.j0.a.e1
    public String y() {
        S(2);
        j.b bVar = (j.b) this.f4970a;
        int r = bVar.r();
        if (r > 0 && r <= bVar.f4965f - bVar.h) {
            String str = new String(bVar.f4963d, bVar.h, r, a0.f4885a);
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
    public long z() {
        S(0);
        return ((j.b) this.f4970a).s();
    }
}
