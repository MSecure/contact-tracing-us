package c.b.a.a.f;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f3192b;

    /* renamed from: a  reason: collision with root package name */
    public final b f3193a = new b();

    static {
        c cVar = new c();
        synchronized (c.class) {
            f3192b = cVar;
        }
    }

    public static b a() {
        c cVar;
        synchronized (c.class) {
            cVar = f3192b;
        }
        return cVar.f3193a;
    }
}
