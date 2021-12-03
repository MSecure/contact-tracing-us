package h.a.k1.p.m;

public final class h {
    public int a;
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f4255d = new int[10];

    public boolean a(int i2) {
        return ((1 << i2) & this.a) != 0;
    }

    public h b(int i2, int i3, int i4) {
        int[] iArr = this.f4255d;
        if (i2 >= iArr.length) {
            return this;
        }
        int i5 = 1 << i2;
        this.a |= i5;
        this.b = (i3 & 1) != 0 ? this.b | i5 : this.b & (~i5);
        this.c = (i3 & 2) != 0 ? this.c | i5 : this.c & (~i5);
        iArr[i2] = i4;
        return this;
    }
}
