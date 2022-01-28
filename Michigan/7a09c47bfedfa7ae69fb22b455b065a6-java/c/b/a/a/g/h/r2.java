package c.b.a.a.g.h;

public final class r2 implements z2 {

    /* renamed from: a  reason: collision with root package name */
    public z2[] f4017a;

    public r2(z2... z2VarArr) {
        this.f4017a = z2VarArr;
    }

    @Override // c.b.a.a.g.h.z2
    public final a3 a(Class<?> cls) {
        z2[] z2VarArr = this.f4017a;
        for (z2 z2Var : z2VarArr) {
            if (z2Var.b(cls)) {
                return z2Var.a(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }

    @Override // c.b.a.a.g.h.z2
    public final boolean b(Class<?> cls) {
        for (z2 z2Var : this.f4017a) {
            if (z2Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
