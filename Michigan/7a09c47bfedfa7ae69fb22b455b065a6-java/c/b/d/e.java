package c.b.d;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f5247a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f5248b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f5247a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f5248b = cls2 != null;
    }

    public static boolean a() {
        return f5247a != null && !f5248b;
    }
}
