package c.b.c.a.j0.a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f4903a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f4904b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f4903a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f4904b = cls2 != null;
    }

    public static boolean a() {
        return f4903a != null && !f4904b;
    }
}
