package g.b;

public final class a<T> implements i.a.a<T> {
    public static final Object a = new Object();

    public static Object a(Object obj, Object obj2) {
        if (!(obj != a && !(obj instanceof b)) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }
}
