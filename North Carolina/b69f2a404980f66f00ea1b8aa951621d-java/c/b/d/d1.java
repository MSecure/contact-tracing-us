package c.b.d;

public final class d1 {

    /* renamed from: a  reason: collision with root package name */
    public static final a1 f3842a;

    /* renamed from: b  reason: collision with root package name */
    public static final a1 f3843b = new c1();

    static {
        a1 a1Var;
        try {
            a1Var = (a1) Class.forName("c.b.d.b1").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            a1Var = null;
        }
        f3842a = a1Var;
    }
}
