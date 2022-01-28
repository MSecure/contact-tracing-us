package c.b.c.a.j0.a;

public final class j0 implements g1 {

    /* renamed from: b  reason: collision with root package name */
    public static final q0 f4967b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final q0 f4968a;

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
        public q0[] f4969a;

        public b(q0... q0VarArr) {
            this.f4969a = q0VarArr;
        }

        @Override // c.b.c.a.j0.a.q0
        public boolean a(Class<?> cls) {
            for (q0 q0Var : this.f4969a) {
                if (q0Var.a(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // c.b.c.a.j0.a.q0
        public p0 b(Class<?> cls) {
            q0[] q0VarArr = this.f4969a;
            for (q0 q0Var : q0VarArr) {
                if (q0Var.a(cls)) {
                    return q0Var.b(cls);
                }
            }
            StringBuilder h = c.a.a.a.a.h("No factory is available for message type: ");
            h.append(cls.getName());
            throw new UnsupportedOperationException(h.toString());
        }
    }

    public j0() {
        q0 q0Var;
        q0[] q0VarArr = new q0[2];
        q0VarArr[0] = x.f5059a;
        try {
            q0Var = (q0) Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            q0Var = f4967b;
        }
        q0VarArr[1] = q0Var;
        b bVar = new b(q0VarArr);
        a0.b(bVar, "messageInfoFactory");
        this.f4968a = bVar;
    }
}
