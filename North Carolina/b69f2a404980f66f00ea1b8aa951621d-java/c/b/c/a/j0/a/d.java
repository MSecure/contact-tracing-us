package c.b.c.a.j0.a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f3534a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f3535b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f3534a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f3535b = cls2 != null;
    }

    public static boolean a() {
        return f3534a != null && !f3535b;
    }
}
