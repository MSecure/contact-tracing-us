package c.b.c.a.j0.a;

import c.a.a.a.a;
import c.b.c.a.j0.a.y;

public class x implements q0 {

    /* renamed from: a  reason: collision with root package name */
    public static final x f3670a = new x();

    @Override // c.b.c.a.j0.a.q0
    public boolean a(Class<?> cls) {
        return y.class.isAssignableFrom(cls);
    }

    @Override // c.b.c.a.j0.a.q0
    public p0 b(Class<?> cls) {
        if (y.class.isAssignableFrom(cls)) {
            try {
                return (p0) y.g(cls.asSubclass(y.class)).f(y.f.BUILD_MESSAGE_INFO, null, null);
            } catch (Exception e2) {
                StringBuilder g = a.g("Unable to get message info for ");
                g.append(cls.getName());
                throw new RuntimeException(g.toString(), e2);
            }
        } else {
            StringBuilder g2 = a.g("Unsupported message type: ");
            g2.append(cls.getName());
            throw new IllegalArgumentException(g2.toString());
        }
    }
}
