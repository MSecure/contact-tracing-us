package c.b.c.a.j0.a;

public final class j0 implements g1 {

    /* renamed from: b  reason: collision with root package name */
    public static final q0 f3592b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final q0 f3593a;

    public class a implements q0 {
        @Override // c.b.c.a.j0.a.q0
        public boolean a(Class<?> cls) {
            return false;
        }

        @Override // c.b.c.a.j0.a.q0
        public p0 b(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    }

    public static class b implements q0 {

        /* renamed from: a  reason: collision with root package name */
        public q0[] f3594a;

        public b(q0... q0VarArr) {
            this.f3594a = q0VarArr;
        }

        @Override // c.b.c.a.j0.a.q0
        public boolean a(Class<?> cls) {
            for (q0 q0Var : this.f3594a) {
                if (q0Var.a(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // c.b.c.a.j0.a.q0
        public p0 b(Class<?> cls) {
            q0[] q0VarArr = this.f3594a;
            for (q0 q0Var : q0VarArr) {
                if (q0Var.a(cls)) {
                    return q0Var.b(cls);
                }
            }
            StringBuilder g = c.a.a.a.a.g("No factory is available for message type: ");
            g.append(cls.getName());
            throw new UnsupportedOperationException(g.toString());
        }
    }

    public j0() {
        q0 q0Var;
        q0[] q0VarArr = new q0[2];
        q0VarArr[0] = x.f3670a;
        try {
            q0Var = (q0) Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            q0Var = f3592b;
        }
        q0VarArr[1] = q0Var;
        b bVar = new b(q0VarArr);
        a0.b(bVar, "messageInfoFactory");
        this.f3593a = bVar;
    }
}
