package c.b.d;

public final class v0 implements d2 {

    /* renamed from: b  reason: collision with root package name */
    public static final g1 f4359b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final g1 f4360a;

    public static class a implements g1 {
        @Override // c.b.d.g1
        public boolean a(Class<?> cls) {
            return false;
        }

        @Override // c.b.d.g1
        public f1 b(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    }

    public static class b implements g1 {

        /* renamed from: a  reason: collision with root package name */
        public g1[] f4361a;

        public b(g1... g1VarArr) {
            this.f4361a = g1VarArr;
        }

        @Override // c.b.d.g1
        public boolean a(Class<?> cls) {
            for (g1 g1Var : this.f4361a) {
                if (g1Var.a(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // c.b.d.g1
        public f1 b(Class<?> cls) {
            g1[] g1VarArr = this.f4361a;
            for (g1 g1Var : g1VarArr) {
                if (g1Var.a(cls)) {
                    return g1Var.b(cls);
                }
            }
            StringBuilder g = c.a.a.a.a.g("No factory is available for message type: ");
            g.append(cls.getName());
            throw new UnsupportedOperationException(g.toString());
        }
    }

    public v0() {
        g1 g1Var;
        g1[] g1VarArr = new g1[2];
        g1VarArr[0] = i0.f3906a;
        try {
            g1Var = (g1) Class.forName("c.b.d.q").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            g1Var = f4359b;
        }
        g1VarArr[1] = g1Var;
        b bVar = new b(g1VarArr);
        m0.b(bVar, "messageInfoFactory");
        this.f4360a = bVar;
    }
}
