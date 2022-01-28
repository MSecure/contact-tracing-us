package c.b.d;

import c.a.a.a.a;

public class j0 implements h1 {

    /* renamed from: a  reason: collision with root package name */
    public static final j0 f5328a = new j0();

    @Override // c.b.d.h1
    public boolean a(Class<?> cls) {
        return k0.class.isAssignableFrom(cls);
    }

    @Override // c.b.d.h1
    public g1 b(Class<?> cls) {
        if (k0.class.isAssignableFrom(cls)) {
            try {
                return (g1) k0.e(cls.asSubclass(k0.class)).a();
            } catch (Exception e2) {
                StringBuilder h = a.h("Unable to get message info for ");
                h.append(cls.getName());
                throw new RuntimeException(h.toString(), e2);
            }
        } else {
            StringBuilder h2 = a.h("Unsupported message type: ");
            h2.append(cls.getName());
            throw new IllegalArgumentException(h2.toString());
        }
    }
}
