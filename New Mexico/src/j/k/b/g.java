package j.k.b;
/* loaded from: classes.dex */
public class g {
    public static final h a;

    static {
        h hVar = null;
        try {
            hVar = (h) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (hVar == null) {
            hVar = new h();
        }
        a = hVar;
    }
}
