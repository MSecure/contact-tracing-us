package c.b.a.a.g.h;

public final class o3 implements a3 {

    /* renamed from: a  reason: collision with root package name */
    public final c3 f3984a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3985b;

    /* renamed from: c  reason: collision with root package name */
    public final Object[] f3986c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3987d;

    public o3(c3 c3Var, String str, Object[] objArr) {
        this.f3984a = c3Var;
        this.f3985b = str;
        this.f3986c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f3987d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 >= 55296) {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            } else {
                this.f3987d = i | (charAt2 << i2);
                return;
            }
        }
    }

    @Override // c.b.a.a.g.h.a3
    public final int a() {
        return (this.f3987d & 1) == 1 ? 1 : 2;
    }

    @Override // c.b.a.a.g.h.a3
    public final c3 b() {
        return this.f3984a;
    }

    @Override // c.b.a.a.g.h.a3
    public final boolean c() {
        return (this.f3987d & 2) == 2;
    }
}
