package f.b.f;

import java.nio.charset.Charset;

public final class l0 implements k1 {
    public static final s0 b = new a();
    public final s0 a;

    public static class a implements s0 {
        @Override // f.b.f.s0
        public boolean a(Class<?> cls) {
            return false;
        }

        @Override // f.b.f.s0
        public r0 b(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    }

    public static class b implements s0 {
        public s0[] a;

        public b(s0... s0VarArr) {
            this.a = s0VarArr;
        }

        @Override // f.b.f.s0
        public boolean a(Class<?> cls) {
            for (s0 s0Var : this.a) {
                if (s0Var.a(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // f.b.f.s0
        public r0 b(Class<?> cls) {
            s0[] s0VarArr = this.a;
            for (s0 s0Var : s0VarArr) {
                if (s0Var.a(cls)) {
                    return s0Var.b(cls);
                }
            }
            StringBuilder h2 = f.a.a.a.a.h("No factory is available for message type: ");
            h2.append(cls.getName());
            throw new UnsupportedOperationException(h2.toString());
        }
    }

    public l0() {
        s0 s0Var;
        s0[] s0VarArr = new s0[2];
        s0VarArr[0] = y.a;
        try {
            s0Var = (s0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            s0Var = b;
        }
        s0VarArr[1] = s0Var;
        b bVar = new b(s0VarArr);
        Charset charset = c0.a;
        this.a = bVar;
    }
}
