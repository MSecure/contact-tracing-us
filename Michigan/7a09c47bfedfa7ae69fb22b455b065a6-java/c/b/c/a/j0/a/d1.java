package c.b.c.a.j0.a;

public final class d1 implements p0 {

    /* renamed from: a  reason: collision with root package name */
    public final r0 f4907a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4908b;

    /* renamed from: c  reason: collision with root package name */
    public final Object[] f4909c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4910d;

    public d1(r0 r0Var, String str, Object[] objArr) {
        char charAt;
        this.f4907a = r0Var;
        this.f4908b = str;
        this.f4909c = objArr;
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
        this.f4910d = charAt2;
    }

    @Override // c.b.c.a.j0.a.p0
    public a1 a() {
        return (this.f4910d & 1) == 1 ? a1.PROTO2 : a1.PROTO3;
    }

    @Override // c.b.c.a.j0.a.p0
    public r0 b() {
        return this.f4907a;
    }

    @Override // c.b.c.a.j0.a.p0
    public boolean c() {
        return (this.f4910d & 2) == 2;
    }
}
