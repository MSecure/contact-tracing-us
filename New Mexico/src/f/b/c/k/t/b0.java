package f.b.c.k.t;

import f.b.a.c.b.o.b;
import f.b.c.k.r.f;
import f.b.c.k.x.n;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class b0 extends f0 {
    public final Map<f, a0> b = new HashMap();
    public final z c = new z();

    /* renamed from: d */
    public final d0 f3585d = new d0(this);

    /* renamed from: e */
    public final c0 f3586e = new c0(this);

    /* renamed from: f */
    public i0 f3587f;

    /* renamed from: g */
    public boolean f3588g;

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
        return this.f3587f;
    }

    @Override // f.b.c.k.t.f0
    public k0 d() {
        return this.f3586e;
    }

    @Override // f.b.c.k.t.f0
    public c1 e() {
        return this.f3585d;
    }

    @Override // f.b.c.k.t.f0
    public boolean f() {
        return this.f3588g;
    }

    @Override // f.b.c.k.t.f0
    public <T> T g(String str, n<T> nVar) {
        this.f3587f.g();
        try {
            return nVar.get();
        } finally {
            this.f3587f.e();
        }
    }

    @Override // f.b.c.k.t.f0
    public void h(String str, Runnable runnable) {
        this.f3587f.g();
        try {
            runnable.run();
        } finally {
            this.f3587f.e();
        }
    }

    @Override // f.b.c.k.t.f0
    public void i() {
        b.P0(!this.f3588g, "MemoryPersistence double-started!", new Object[0]);
        this.f3588g = true;
    }
}
