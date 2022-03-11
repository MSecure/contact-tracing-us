package f.b.f;

public final class u {
    public static final s<?> a = new t();
    public static final s<?> b;

    static {
        s<?> sVar;
        try {
            sVar = (s) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            sVar = null;
        }
        b = sVar;
    }
}
