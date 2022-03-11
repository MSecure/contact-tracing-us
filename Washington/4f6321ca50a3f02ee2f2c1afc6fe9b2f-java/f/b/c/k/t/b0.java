package f.b.c.k.t;

import f.b.a.c.b.o.b;
import f.b.c.k.r.f;
import f.b.c.k.x.n;
import java.util.HashMap;
import java.util.Map;

public final class b0 extends f0 {
    public final Map<f, a0> b = new HashMap();
    public final z c = new z();

    /* renamed from: d  reason: collision with root package name */
    public final d0 f3076d = new d0(this);

    /* renamed from: e  reason: collision with root package name */
    public final c0 f3077e = new c0(this);

    /* renamed from: f  reason: collision with root package name */
    public i0 f3078f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3079g;

    @Override // f.b.c.k.t.f0
    public f a() {
        return this.c;
    }

    @Override // f.b.c.k.t.f0
    public e0 b(f fVar) {
        a0 a0Var = this.b.get(fVar);
        if (a0Var != null) {
            return a0Var;
        }
        a0 a0Var2 = new a0(this);
        this.b.put(fVar, a0Var2);
        return a0Var2;
    }

    @Override // f.b.c.k.t.f0
    public i0 c() {
        return this.f3078f;
    }

    @Override // f.b.c.k.t.f0
    public k0 d() {
        return this.f3077e;
    }

    @Override // f.b.c.k.t.f0
    public c1 e() {
        return this.f3076d;
    }

    @Override // f.b.c.k.t.f0
    public boolean f() {
        return this.f3079g;
    }

    @Override // f.b.c.k.t.f0
    public <T> T g(String str, n<T> nVar) {
        this.f3078f.g();
        try {
            return nVar.get();
        } finally {
            this.f3078f.e();
        }
    }

    @Override // f.b.c.k.t.f0
    public void h(String str, Runnable runnable) {
        this.f3078f.g();
        try {
            runnable.run();
        } finally {
            this.f3078f.e();
        }
    }

    @Override // f.b.c.k.t.f0
    public void i() {
        b.a1(!this.f3079g, "MemoryPersistence double-started!", new Object[0]);
        this.f3079g = true;
    }
}
