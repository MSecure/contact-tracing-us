package c.b.d;

public final class i2 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    public final y1 f5315a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5316b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f5317c;

    /* renamed from: d  reason: collision with root package name */
    public final e0[] f5318d;

    /* renamed from: e  reason: collision with root package name */
    public final i1 f5319e;

    public i2(y1 y1Var, boolean z, int[] iArr, e0[] e0VarArr, Object obj) {
        this.f5315a = y1Var;
        this.f5316b = z;
        this.f5317c = iArr;
        this.f5318d = e0VarArr;
        n0.b(obj, "defaultInstance");
        this.f5319e = (i1) obj;
    }

    @Override // c.b.d.g1
    public y1 a() {
        return this.f5315a;
    }

    @Override // c.b.d.g1
    public i1 b() {
        return this.f5319e;
    }

    @Override // c.b.d.g1
    public boolean c() {
        return this.f5316b;
    }
}
