package f.b.g;

import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class e1 {
    public static final e1 c = new e1();
    public final k1 a = new l0();
    public final ConcurrentMap<Class<?>, j1<?>> b = new ConcurrentHashMap();

    public <T> j1<T> a(Class<T> cls) {
        j1<T> j1Var;
        o0 o0Var;
        s<?> sVar;
        r1<?, ?> r1Var;
        j0 j0Var;
        x0 x0Var;
        o0 o0Var2;
        r1<?, ?> r1Var2;
        j0 j0Var2;
        x0 x0Var2;
        w0 w0Var;
        Class<?> cls2;
        Charset charset = c0.a;
        Objects.requireNonNull(cls, "messageType");
        j1<T> j1Var2 = (j1<T>) this.b.get(cls);
        if (j1Var2 != null) {
            return j1Var2;
        }
        l0 l0Var = (l0) this.a;
        Objects.requireNonNull(l0Var);
        Class<?> cls3 = l1.a;
        if (z.class.isAssignableFrom(cls) || (cls2 = l1.a) == null || cls2.isAssignableFrom(cls)) {
            r0 b2 = l0Var.a.b(cls);
            if (b2.c()) {
                if (z.class.isAssignableFrom(cls)) {
                    r1<?, ?> r1Var3 = l1.f3598d;
                    s<?> sVar2 = u.a;
                    w0Var = new w0(r1Var3, u.a, b2.b());
                } else {
                    r1<?, ?> r1Var4 = l1.b;
                    s<?> sVar3 = u.b;
                    if (sVar3 != null) {
                        w0Var = new w0(r1Var4, sVar3, b2.b());
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
                j1Var = w0Var;
            } else {
                d1 d1Var = d1.PROTO2;
                boolean z = true;
                s<?> sVar4 = null;
                if (z.class.isAssignableFrom(cls)) {
                    if (b2.a() != d1Var) {
                        z = false;
                    }
                    if (z) {
                        x0Var2 = z0.b;
                        j0Var2 = j0.b;
                        r1Var2 = l1.f3598d;
                        s<?> sVar5 = u.a;
                        sVar4 = u.a;
                    } else {
                        x0Var2 = z0.b;
                        j0Var2 = j0.b;
                        r1Var2 = l1.f3598d;
                    }
                    o0Var2 = q0.b;
                } else {
                    if (b2.a() != d1Var) {
                        z = false;
                    }
                    if (z) {
                        x0 x0Var3 = z0.a;
                        j0 j0Var3 = j0.a;
                        r1<?, ?> r1Var5 = l1.b;
                        s<?> sVar6 = u.b;
                        if (sVar6 != null) {
                            o0Var = q0.a;
                            sVar = sVar6;
                            x0Var = x0Var3;
                            r1Var = r1Var5;
                            j0Var = j0Var3;
                            j1Var = v0.A(b2, x0Var, j0Var, r1Var, sVar, o0Var);
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    } else {
                        x0Var2 = z0.a;
                        j0Var2 = j0.a;
                        r1Var2 = l1.c;
                        o0Var2 = q0.a;
                    }
                }
                o0Var = o0Var2;
                sVar = sVar4;
                j0Var = j0Var2;
                r1Var = r1Var2;
                x0Var = x0Var2;
                j1Var = v0.A(b2, x0Var, j0Var, r1Var, sVar, o0Var);
            }
            j1<T> j1Var3 = (j1<T>) this.b.putIfAbsent(cls, j1Var);
            return j1Var3 != null ? j1Var3 : j1Var;
        }
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    public <T> j1<T> b(T t) {
        return a(t.getClass());
    }
}
