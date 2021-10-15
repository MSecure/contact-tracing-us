package c.b.a.a.g.b;

public final class t2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f3418a;

    /* renamed from: b  reason: collision with root package name */
    public int f3419b = 0;

    public t2(String str) {
        this.f3418a = str;
    }

    public final int a() {
        String str = this.f3418a;
        int i = this.f3419b;
        this.f3419b = i + 1;
        char charAt = str.charAt(i);
        if (charAt < 55296) {
            return charAt;
        }
        int i2 = charAt & 8191;
        int i3 = 13;
        while (true) {
            String str2 = this.f3418a;
            int i4 = this.f3419b;
            this.f3419b = i4 + 1;
            char charAt2 = str2.charAt(i4);
            if (charAt2 < 55296) {
                return i2 | (charAt2 << i3);
            }
            i2 |= (charAt2 & 8191) << i3;
            i3 += 13;
        }
    }
}
