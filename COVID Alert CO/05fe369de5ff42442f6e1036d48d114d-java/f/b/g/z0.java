package f.b.g;

public final class z0 {
    public static final x0 a;
    public static final x0 b = new y0();

    static {
        x0 x0Var;
        try {
            x0Var = (x0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            x0Var = null;
        }
        a = x0Var;
    }
}
