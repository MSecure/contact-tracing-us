package c.b.a.a.g.b;

public final class w1 implements d2 {

    /* renamed from: a  reason: collision with root package name */
    public d2[] f3454a;

    public w1(d2... d2VarArr) {
        this.f3454a = d2VarArr;
    }

    @Override // c.b.a.a.g.b.d2
    public final c2 a(Class<?> cls) {
        d2[] d2VarArr = this.f3454a;
        for (d2 d2Var : d2VarArr) {
            if (d2Var.b(cls)) {
                return d2Var.a(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }

    @Override // c.b.a.a.g.b.d2
    public final boolean b(Class<?> cls) {
        for (d2 d2Var : this.f3454a) {
            if (d2Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
