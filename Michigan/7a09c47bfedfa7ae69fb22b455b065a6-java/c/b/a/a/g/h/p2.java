package c.b.a.a.g.h;

public final class p2 implements p3 {

    /* renamed from: b  reason: collision with root package name */
    public static final z2 f3992b = new s2();

    /* renamed from: a  reason: collision with root package name */
    public final z2 f3993a;

    public p2() {
        z2 z2Var;
        z2[] z2VarArr = new z2[2];
        z2VarArr[0] = r1.f4016a;
        try {
            z2Var = (z2) Class.forName("c.b.d.q").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            z2Var = f3992b;
        }
        z2VarArr[1] = z2Var;
        r2 r2Var = new r2(z2VarArr);
        u1.d(r2Var, "messageInfoFactory");
        this.f3993a = r2Var;
    }
}
