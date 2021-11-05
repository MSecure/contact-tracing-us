package c.b.a.a.g.b;

public final class y0 implements d2 {

    /* renamed from: a  reason: collision with root package name */
    public static final y0 f3477a = new y0();

    @Override // c.b.a.a.g.b.d2
    public final c2 a(Class<?> cls) {
        if (!z0.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (c2) z0.j(cls.asSubclass(z0.class)).g(3, null, null);
        } catch (Exception e2) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e2);
        }
    }

    @Override // c.b.a.a.g.b.d2
    public final boolean b(Class<?> cls) {
        return z0.class.isAssignableFrom(cls);
    }
}
