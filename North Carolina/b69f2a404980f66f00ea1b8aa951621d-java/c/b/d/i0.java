package c.b.d;

import c.a.a.a.a;

public class i0 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    public static final i0 f3906a = new i0();

    @Override // c.b.d.g1
    public boolean a(Class<?> cls) {
        return j0.class.isAssignableFrom(cls);
    }

    @Override // c.b.d.g1
    public f1 b(Class<?> cls) {
        if (j0.class.isAssignableFrom(cls)) {
            try {
                return (f1) j0.e(cls.asSubclass(j0.class)).a();
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
