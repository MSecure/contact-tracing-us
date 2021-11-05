package c.b.c.a.j0.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b1 {

    /* renamed from: c  reason: collision with root package name */
    public static final b1 f3523c = new b1();

    /* renamed from: a  reason: collision with root package name */
    public final g1 f3524a = new j0();

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentMap<Class<?>, f1<?>> f3525b = new ConcurrentHashMap();

    public <T> f1<T> a(Class<T> cls) {
        f1<T> f1Var;
        m0 m0Var;
        r<?> rVar;
        l1<?, ?> l1Var;
        h0 h0Var;
        v0 v0Var;
        h0 h0Var2;
        v0 v0Var2;
        r<?> rVar2;
        l1<?, ?> l1Var2;
        u0 u0Var;
        a0.b(cls, "messageType");
        f1<T> f1Var2 = (f1<T>) this.f3525b.get(cls);
        if (f1Var2 != null) {
            return f1Var2;
        }
        j0 j0Var = (j0) this.f3524a;
        if (j0Var != null) {
            h1.E(cls);
            p0 b2 = j0Var.f3593a.b(cls);
            if (b2.c()) {
                if (y.class.isAssignableFrom(cls)) {
                    u0Var = new u0(h1.f3563d, t.f3640a, b2.b());
                } else {
                    l1<?, ?> l1Var3 = h1.f3561b;
                    r<?> rVar3 = t.f3641b;
                    if (rVar3 != null) {
                        u0Var = new u0(l1Var3, rVar3, b2.b());
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
                f1Var = u0Var;
            } else {
                a1 a1Var = a1.PROTO2;
                boolean z = true;
                if (y.class.isAssignableFrom(cls)) {
                    if (b2.a() != a1Var) {
                        z = false;
                    }
                    if (z) {
                        v0Var2 = x0.f3672b;
                        h0Var2 = h0.f3558b;
                        l1Var2 = h1.f3563d;
                        rVar2 = t.f3640a;
                    } else {
                        v0Var2 = x0.f3672b;
                        rVar2 = null;
                        h0Var2 = h0.f3558b;
                        l1Var2 = h1.f3563d;
                    }
                    l1Var = l1Var2;
                    rVar = rVar2;
                    m0Var = o0.f3616b;
                } else {
                    if (b2.a() != a1Var) {
                        z = false;
                    }
                    if (z) {
                        v0Var2 = x0.f3671a;
                        h0Var2 = h0.f3557a;
                        l1<?, ?> l1Var4 = h1.f3561b;
                        r<?> rVar4 = t.f3641b;
                        if (rVar4 != null) {
                            l1Var = l1Var4;
                            m0Var = o0.f3615a;
                            rVar = rVar4;
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    } else {
                        v0 v0Var3 = x0.f3671a;
                        h0 h0Var3 = h0.f3557a;
                        rVar = null;
                        l1Var = h1.f3562c;
                        m0Var = o0.f3615a;
                        v0Var = v0Var3;
                        h0Var = h0Var3;
                        f1Var = t0.z(b2, v0Var, h0Var, l1Var, rVar, m0Var);
                    }
                }
                v0Var = v0Var2;
                h0Var = h0Var2;
                f1Var = t0.z(b2, v0Var, h0Var, l1Var, rVar, m0Var);
            }
            a0.b(cls, "messageType");
            a0.b(f1Var, "schema");
            f1<T> f1Var3 = (f1<T>) this.f3525b.putIfAbsent(cls, f1Var);
            return f1Var3 != null ? f1Var3 : f1Var;
        }
        throw null;
    }

    public <T> f1<T> b(T t) {
        return a(t.getClass());
    }
}
