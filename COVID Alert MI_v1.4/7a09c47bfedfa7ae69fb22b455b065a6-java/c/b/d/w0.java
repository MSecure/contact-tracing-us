package c.b.d;

public final class w0 implements e2 {

    /* renamed from: b  reason: collision with root package name */
    public static final h1 f5902b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final h1 f5903a;

    public static class a implements h1 {
        @Override // c.b.d.h1
        public boolean a(Class<?> cls) {
            return false;
        }

        @Override // c.b.d.h1
        public g1 b(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    }

    public static class b implements h1 {

        /* renamed from: a  reason: collision with root package name */
        public h1[] f5904a;

        public b(h1... h1VarArr) {
            this.f5904a = h1VarArr;
        }

        @Override // c.b.d.h1
        public boolean a(Class<?> cls) {
            for (h1 h1Var : this.f5904a) {
                if (h1Var.a(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // c.b.d.h1
        public g1 b(Class<?> cls) {
            h1[] h1VarArr = this.f5904a;
            for (h1 h1Var : h1VarArr) {
                if (h1Var.a(cls)) {
                    return h1Var.b(cls);
                }
            }
            StringBuilder h = c.a.a.a.a.h("No factory is available for message type: ");
            h.append(cls.getName());
            throw new UnsupportedOperationException(h.toString());
        }
    }

    public w0() {
        h1 h1Var;
        h1[] h1VarArr = new h1[2];
        h1VarArr[0] = j0.f5328a;
        try {
            h1Var = (h1) Class.forName("c.b.d.q").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            h1Var = f5902b;
        }
        h1VarArr[1] = h1Var;
        b bVar = new b(h1VarArr);
        n0.b(bVar, "messageInfoFactory");
        this.f5903a = bVar;
    }
}
