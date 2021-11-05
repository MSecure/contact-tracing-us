package c.b.d;

public final class h2 implements f1 {

    /* renamed from: a  reason: collision with root package name */
    public final x1 f3898a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3899b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f3900c;

    /* renamed from: d  reason: collision with root package name */
    public final e0[] f3901d;

    /* renamed from: e  reason: collision with root package name */
    public final h1 f3902e;

    public h2(x1 x1Var, boolean z, int[] iArr, e0[] e0VarArr, Object obj) {
        this.f3898a = x1Var;
        this.f3899b = z;
        this.f3900c = iArr;
        this.f3901d = e0VarArr;
        m0.b(obj, "defaultInstance");
        this.f3902e = (h1) obj;
    }

    @Override // c.b.d.f1
    public x1 a() {
        return this.f3898a;
    }

    @Override // c.b.d.f1
    public h1 b() {
        return this.f3902e;
    }

    @Override // c.b.d.f1
    public boolean c() {
        return this.f3899b;
    }
}
