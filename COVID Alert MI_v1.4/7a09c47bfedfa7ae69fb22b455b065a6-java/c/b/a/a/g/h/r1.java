package c.b.a.a.g.h;

public final class r1 implements z2 {

    /* renamed from: a  reason: collision with root package name */
    public static final r1 f4016a = new r1();

    @Override // c.b.a.a.g.h.z2
    public final a3 a(Class<?> cls) {
        if (!t1.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (a3) t1.j(cls.asSubclass(t1.class)).g(3, null, null);
        } catch (Exception e2) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e2);
        }
    }

    @Override // c.b.a.a.g.h.z2
    public final boolean b(Class<?> cls) {
        return t1.class.isAssignableFrom(cls);
    }
}
