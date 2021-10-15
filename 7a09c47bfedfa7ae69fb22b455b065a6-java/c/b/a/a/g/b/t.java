package c.b.a.a.g.b;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f3414a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f3415b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f3414a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f3415b = cls2 != null;
    }

    public static boolean a() {
        return f3414a != null && !f3415b;
    }
}
