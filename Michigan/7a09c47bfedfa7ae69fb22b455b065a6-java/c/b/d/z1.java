package c.b.d;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class z1 {

    /* renamed from: c  reason: collision with root package name */
    public static final z1 f5964c = new z1();

    /* renamed from: a  reason: collision with root package name */
    public final e2 f5965a = new w0();

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentMap<Class<?>, d2<?>> f5966b = new ConcurrentHashMap();

    public <T> d2<T> a(Class<T> cls) {
        d2<T> d2Var;
        b1 b1Var;
        a0<?> a0Var;
        p2<?, ?> p2Var;
        u0 u0Var;
        r1 r1Var;
        u0 u0Var2;
        r1 r1Var2;
        a0<?> a0Var2;
        p2<?, ?> p2Var2;
        p1 p1Var;
        n0.b(cls, "messageType");
        d2<T> d2Var2 = (d2<T>) this.f5966b.get(cls);
        if (d2Var2 != null) {
            return d2Var2;
        }
        w0 w0Var = (w0) this.f5965a;
        if (w0Var != null) {
            f2.E(cls);
            g1 b2 = w0Var.f5903a.b(cls);
            if (b2.c()) {
                if (k0.class.isAssignableFrom(cls)) {
                    p1Var = new p1(f2.f5272d, d0.f5245a, b2.b());
                } else {
                    p2<?, ?> p2Var3 = f2.f5270b;
                    a0<?> a0Var3 = d0.f5246b;
                    if (a0Var3 != null) {
                        p1Var = new p1(p2Var3, a0Var3, b2.b());
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
                d2Var = p1Var;
            } else {
                y1 y1Var = y1.PROTO2;
                boolean z = true;
                if (k0.class.isAssignableFrom(cls)) {
                    if (b2.a() != y1Var) {
                        z = false;
                    }
                    if (z) {
                        r1Var2 = u1.f5882b;
                        u0Var2 = u0.f5879b;
                        p2Var2 = f2.f5272d;
                        a0Var2 = d0.f5245a;
                    } else {
                        r1Var2 = u1.f5882b;
                        a0Var2 = null;
                        u0Var2 = u0.f5879b;
                        p2Var2 = f2.f5272d;
                    }
                    p2Var = p2Var2;
                    a0Var = a0Var2;
                    b1Var = e1.f5256b;
                } else {
                    if (b2.a() != y1Var) {
                        z = false;
                    }
                    if (z) {
                        r1Var2 = u1.f5881a;
                        u0Var2 = u0.f5878a;
                        p2<?, ?> p2Var4 = f2.f5270b;
                        a0<?> a0Var4 = d0.f5246b;
                        if (a0Var4 != null) {
                            p2Var = p2Var4;
                            b1Var = e1.f5255a;
                            a0Var = a0Var4;
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    } else {
                        r1 r1Var3 = u1.f5881a;
                        u0 u0Var3 = u0.f5878a;
                        a0Var = null;
                        p2Var = f2.f5271c;
                        b1Var = e1.f5255a;
                        r1Var = r1Var3;
                        u0Var = u0Var3;
                        d2Var = o1.z(b2, r1Var, u0Var, p2Var, a0Var, b1Var);
                    }
                }
                r1Var = r1Var2;
                u0Var = u0Var2;
                d2Var = o1.z(b2, r1Var, u0Var, p2Var, a0Var, b1Var);
            }
            n0.b(cls, "messageType");
            n0.b(d2Var, "schema");
            d2<T> d2Var3 = (d2<T>) this.f5966b.putIfAbsent(cls, d2Var);
            return d2Var3 != null ? d2Var3 : d2Var;
        }
        throw null;
    }

    public <T> d2<T> b(T t) {
        return a(t.getClass());
    }
}
