package c.b.a.a.g.b;

public final class u1 implements v2 {

    /* renamed from: b  reason: collision with root package name */
    public static final d2 f3433b = new v1();

    /* renamed from: a  reason: collision with root package name */
    public final d2 f3434a;

    public u1() {
        d2 d2Var;
        d2[] d2VarArr = new d2[2];
        d2VarArr[0] = y0.f3477a;
        try {
            d2Var = (d2) Class.forName("c.b.d.q").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            d2Var = f3433b;
        }
        d2VarArr[1] = d2Var;
        w1 w1Var = new w1(d2VarArr);
        b1.e(w1Var, "messageInfoFactory");
        this.f3434a = w1Var;
    }

    @Override // c.b.a.a.g.b.v2
    public final <T> u2<T> a(Class<T> cls) {
        z1 z1Var;
        h3<?, ?> h3Var;
        p1 p1Var;
        k2 k2Var;
        h3<?, ?> h3Var2;
        h3<?, ?> h3Var3;
        w2.D(cls);
        c2 a2 = this.f3434a.a(cls);
        if (!a2.a()) {
            boolean z = false;
            m0<?> m0Var = null;
            if (z0.class.isAssignableFrom(cls)) {
                if (a2.b() == 1) {
                    z = true;
                }
                if (z) {
                    k2Var = m2.f3347b;
                    p1Var = p1.f3389b;
                    h3Var3 = w2.f3458d;
                    m0Var = p0.f3386a;
                } else {
                    k2Var = m2.f3347b;
                    p1Var = p1.f3389b;
                    h3Var3 = w2.f3458d;
                }
                h3Var = h3Var3;
                z1Var = b2.f3232b;
            } else {
                if (a2.b() == 1) {
                    z = true;
                }
                if (z) {
                    k2Var = m2.f3346a;
                    p1Var = p1.f3388a;
                    h3Var2 = w2.f3456b;
                    m0Var = p0.f3387b;
                    if (m0Var == null) {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                } else {
                    k2Var = m2.f3346a;
                    p1Var = p1.f3388a;
                    h3Var2 = w2.f3457c;
                }
                z1Var = b2.f3231a;
                h3Var = h3Var2;
            }
            return h2.q(cls, a2, k2Var, p1Var, h3Var, m0Var, z1Var);
        } else if (z0.class.isAssignableFrom(cls)) {
            return new i2(w2.f3458d, p0.f3386a, a2.c());
        } else {
            h3<?, ?> h3Var4 = w2.f3456b;
            m0<?> m0Var2 = p0.f3387b;
            if (m0Var2 != null) {
                return new i2(h3Var4, m0Var2, a2.c());
            }
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
    }
}
