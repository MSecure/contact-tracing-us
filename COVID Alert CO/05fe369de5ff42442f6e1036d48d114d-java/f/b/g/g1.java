package f.b.g;

public final class g1 implements r0 {
    public final t0 a;
    public final String b;
    public final Object[] c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3549d;

    public g1(t0 t0Var, String str, Object[] objArr) {
        char charAt;
        this.a = t0Var;
        this.b = str;
        this.c = objArr;
        int charAt2 = str.charAt(0);
        if (charAt2 >= 55296) {
            int i2 = charAt2 & 8191;
            int i3 = 13;
            int i4 = 1;
            while (true) {
                int i5 = i4 + 1;
                charAt = str.charAt(i4);
                if (charAt < 55296) {
                    break;
                }
                i2 |= (charAt & 8191) << i3;
                i3 += 13;
                i4 = i5;
            }
            charAt2 = i2 | (charAt << i3);
        }
        this.f3549d = charAt2;
    }

    @Override // f.b.g.r0
    public d1 a() {
        return (this.f3549d & 1) == 1 ? d1.PROTO2 : d1.PROTO3;
    }

    @Override // f.b.g.r0
    public t0 b() {
        return this.a;
    }

    @Override // f.b.g.r0
    public boolean c() {
        return (this.f3549d & 2) == 2;
    }
}
