package f.b.g;

public class m0<K, V> {
    public final a<K, V> a;
    public final K b;
    public final V c;

    public static class a<K, V> {
        public final y1 a;
        public final K b;
        public final y1 c;

        /* renamed from: d  reason: collision with root package name */
        public final V f3671d;

        public a(y1 y1Var, K k2, y1 y1Var2, V v) {
            this.a = y1Var;
            this.b = k2;
            this.c = y1Var2;
            this.f3671d = v;
        }
    }

    public m0(y1 y1Var, K k2, y1 y1Var2, V v) {
        this.a = new a<>(y1Var, k2, y1Var2, v);
        this.b = k2;
        this.c = v;
    }

    public static <K, V> int a(a<K, V> aVar, K k2, V v) {
        return v.d(aVar.c, 2, v) + v.d(aVar.a, 1, k2);
    }
}
