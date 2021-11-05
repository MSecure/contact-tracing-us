package c.b.c.a.j0.a;

public final class d1 implements p0 {

    /* renamed from: a  reason: collision with root package name */
    public final r0 f3538a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3539b;

    /* renamed from: c  reason: collision with root package name */
    public final Object[] f3540c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3541d;

    public d1(r0 r0Var, String str, Object[] objArr) {
        char charAt;
        this.f3538a = r0Var;
        this.f3539b = str;
        this.f3540c = objArr;
        int charAt2 = str.charAt(0);
        if (charAt2 >= 55296) {
            int i = charAt2 & 8191;
            int i2 = 13;
            int i3 = 1;
            while (true) {
                int i4 = i3 + 1;
                charAt = str.charAt(i3);
                if (charAt < 55296) {
                    break;
                }
                i |= (charAt & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
            charAt2 = i | (charAt << i2);
        }
        this.f3541d = charAt2;
    }

    @Override // c.b.c.a.j0.a.p0
    public a1 a() {
        return (this.f3541d & 1) == 1 ? a1.PROTO2 : a1.PROTO3;
    }

    @Override // c.b.c.a.j0.a.p0
    public r0 b() {
        return this.f3538a;
    }

    @Override // c.b.c.a.j0.a.p0
    public boolean c() {
        return (this.f3541d & 2) == 2;
    }
}
