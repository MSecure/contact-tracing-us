package c.b.d;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class y1 {

    /* renamed from: c  reason: collision with root package name */
    public static final y1 f4411c = new y1();

    /* renamed from: a  reason: collision with root package name */
    public final d2 f4412a = new v0();

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentMap<Class<?>, c2<?>> f4413b = new ConcurrentHashMap();

    public <T> c2<T> a(Class<T> cls) {
        c2<T> c2Var;
        a1 a1Var;
        a0<?> a0Var;
        o2<?, ?> o2Var;
        t0 t0Var;
        q1 q1Var;
        t0 t0Var2;
        q1 q1Var2;
        a0<?> a0Var2;
        o2<?, ?> o2Var2;
        o1 o1Var;
        m0.b(cls, "messageType");
        c2<T> c2Var2 = (c2<T>) this.f4413b.get(cls);
        if (c2Var2 != null) {
            return c2Var2;
        }
        v0 v0Var = (v0) this.f4412a;
        if (v0Var != null) {
            e2.E(cls);
            f1 b2 = v0Var.f4360a.b(cls);
            if (b2.c()) {
                if (j0.class.isAssignableFrom(cls)) {
                    o1Var = new o1(e2.f3853d, d0.f3840a, b2.b());
                } else {
                    o2<?, ?> o2Var3 = e2.f3851b;
                    a0<?> a0Var3 = d0.f3841b;
                    if (a0Var3 != null) {
                        o1Var = new o1(o2Var3, a0Var3, b2.b());
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
                c2Var = o1Var;
            } else {
                x1 x1Var = x1.PROTO2;
                boolean z = true;
                if (j0.class.isAssignableFrom(cls)) {
                    if (b2.a() != x1Var) {
                        z = false;
                    }
                    if (z) {
                        q1Var2 = t1.f4332b;
                        t0Var2 = t0.f4329b;
                        o2Var2 = e2.f3853d;
                        a0Var2 = d0.f3840a;
                    } else {
                        q1Var2 = t1.f4332b;
                        a0Var2 = null;
                        t0Var2 = t0.f4329b;
                        o2Var2 = e2.f3853d;
                    }
                    o2Var = o2Var2;
                    a0Var = a0Var2;
                    a1Var = d1.f3843b;
                } else {
                    if (b2.a() != x1Var) {
                        z = false;
                    }
                    if (z) {
                        q1Var2 = t1.f4331a;
                        t0Var2 = t0.f4328a;
                        o2<?, ?> o2Var4 = e2.f3851b;
                        a0<?> a0Var4 = d0.f3841b;
                        if (a0Var4 != null) {
                            o2Var = o2Var4;
                            a1Var = d1.f3842a;
                            a0Var = a0Var4;
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    } else {
                        q1 q1Var3 = t1.f4331a;
                        t0 t0Var3 = t0.f4328a;
                        a0Var = null;
                        o2Var = e2.f3852c;
                        a1Var = d1.f3842a;
                        q1Var = q1Var3;
                        t0Var = t0Var3;
                        c2Var = n1.z(b2, q1Var, t0Var, o2Var, a0Var, a1Var);
                    }
                }
                q1Var = q1Var2;
                t0Var = t0Var2;
                c2Var = n1.z(b2, q1Var, t0Var, o2Var, a0Var, a1Var);
            }
            m0.b(cls, "messageType");
            m0.b(c2Var, "schema");
            c2<T> c2Var3 = (c2<T>) this.f4413b.putIfAbsent(cls, c2Var);
            return c2Var3 != null ? c2Var3 : c2Var;
        }
        throw null;
    }

    public <T> c2<T> b(T t) {
        return a(t.getClass());
    }
}
