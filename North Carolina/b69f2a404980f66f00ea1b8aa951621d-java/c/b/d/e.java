package c.b.d;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f3844a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f3845b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f3844a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f3845b = cls2 != null;
    }

    public static boolean a() {
        return f3844a != null && !f3845b;
    }
}
