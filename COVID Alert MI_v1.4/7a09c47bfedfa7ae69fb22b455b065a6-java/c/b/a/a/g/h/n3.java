package c.b.a.a.g.h;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class n3 {

    /* renamed from: c  reason: collision with root package name */
    public static final n3 f3973c = new n3();

    /* renamed from: a  reason: collision with root package name */
    public final p3 f3974a = new p2();

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentMap<Class<?>, q3<?>> f3975b = new ConcurrentHashMap();

    public final <T> q3<T> a(Class<T> cls) {
        q3<T> q3Var;
        v2 v2Var;
        g1<?> g1Var;
        d4<?, ?> d4Var;
        m2 m2Var;
        i3 i3Var;
        g1<?> g1Var2;
        d4<?, ?> d4Var2;
        m2 m2Var2;
        g1<?> g1Var3;
        d4<?, ?> d4Var3;
        m2 m2Var3;
        g3 g3Var;
        u1.d(cls, "messageType");
        q3<T> q3Var2 = (q3<T>) this.f3975b.get(cls);
        if (q3Var2 != null) {
            return q3Var2;
        }
        p2 p2Var = (p2) this.f3974a;
        if (p2Var != null) {
            s3.w(cls);
            a3 a2 = p2Var.f3993a.a(cls);
            if (a2.c()) {
                if (t1.class.isAssignableFrom(cls)) {
                    g3Var = new g3(s3.f4032d, k1.f3922a, a2.b());
                } else {
                    d4<?, ?> d4Var4 = s3.f4030b;
                    g1<?> g1Var4 = k1.f3923b;
                    if (g1Var4 != null) {
                        g3Var = new g3(d4Var4, g1Var4, a2.b());
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
                q3Var = g3Var;
            } else {
                boolean z = false;
                if (t1.class.isAssignableFrom(cls)) {
                    if (a2.a() == 1) {
                        z = true;
                    }
                    if (z) {
                        i3Var = k3.f3927b;
                        m2Var3 = m2.f3946b;
                        d4Var3 = s3.f4032d;
                        g1Var3 = k1.f3922a;
                    } else {
                        i3Var = k3.f3927b;
                        g1Var3 = null;
                        m2Var3 = m2.f3946b;
                        d4Var3 = s3.f4032d;
                    }
                    m2Var = m2Var3;
                    d4Var = d4Var3;
                    g1Var = g1Var3;
                    v2Var = x2.f4064b;
                } else {
                    if (a2.a() == 1) {
                        z = true;
                    }
                    if (z) {
                        i3Var = k3.f3926a;
                        m2Var2 = m2.f3945a;
                        d4Var2 = s3.f4030b;
                        g1Var2 = k1.f3923b;
                        if (g1Var2 == null) {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    } else {
                        i3Var = k3.f3926a;
                        g1Var2 = null;
                        m2Var2 = m2.f3945a;
                        d4Var2 = s3.f4031c;
                    }
                    m2Var = m2Var2;
                    d4Var = d4Var2;
                    v2Var = x2.f4063a;
                    g1Var = g1Var2;
                }
                q3Var = e3.n(cls, a2, i3Var, m2Var, d4Var, g1Var, v2Var);
            }
            u1.d(cls, "messageType");
            u1.d(q3Var, "schema");
            q3<T> q3Var3 = (q3<T>) this.f3975b.putIfAbsent(cls, q3Var);
            return q3Var3 != null ? q3Var3 : q3Var;
        }
        throw null;
    }

    public final <T> q3<T> b(T t) {
        return a(t.getClass());
    }
}
