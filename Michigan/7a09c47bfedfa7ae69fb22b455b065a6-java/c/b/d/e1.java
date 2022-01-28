package c.b.d;

public final class e1 {

    /* renamed from: a  reason: collision with root package name */
    public static final b1 f5255a;

    /* renamed from: b  reason: collision with root package name */
    public static final b1 f5256b = new d1();

    static {
        b1 b1Var;
        try {
            b1Var = (b1) Class.forName("c.b.d.c1").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            b1Var = null;
        }
        f5255a = b1Var;
    }
}
