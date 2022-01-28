package c.b.a.a.g.b;

public final class r2 implements c2 {

    /* renamed from: a  reason: collision with root package name */
    public final e2 f3403a;

    /* renamed from: b  reason: collision with root package name */
    public final s2 f3404b;

    public r2(e2 e2Var, String str, Object[] objArr) {
        this.f3403a = e2Var;
        this.f3404b = new s2(e2Var.getClass(), str, objArr);
    }

    @Override // c.b.a.a.g.b.c2
    public final boolean a() {
        return (this.f3404b.f3409d & 2) == 2;
    }

    @Override // c.b.a.a.g.b.c2
    public final int b() {
        return (this.f3404b.f3409d & 1) == 1 ? 1 : 2;
    }

    @Override // c.b.a.a.g.b.c2
    public final e2 c() {
        return this.f3403a;
    }
}
