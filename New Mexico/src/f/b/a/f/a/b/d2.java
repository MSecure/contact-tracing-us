package f.b.a.f.a.b;

import f.b.a.c.b.o.b;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class d2 {
    public byte[] a = new byte[4096];
    public int b;
    public long c;

    /* renamed from: d  reason: collision with root package name */
    public long f3207d;

    /* renamed from: e  reason: collision with root package name */
    public int f3208e;

    /* renamed from: f  reason: collision with root package name */
    public int f3209f;

    /* renamed from: g  reason: collision with root package name */
    public int f3210g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3211h;

    /* renamed from: i  reason: collision with root package name */
    public String f3212i;

    public d2() {
        c();
    }

    public final int a(byte[] bArr, int i2, int i3) {
        int d2 = d(30, bArr, i2, i3);
        if (d2 == -1) {
            return -1;
        }
        if (this.c == -1) {
            long Q1 = b.Q1(this.a, 0);
            this.c = Q1;
            if (Q1 == 67324752) {
                this.f3211h = false;
                this.f3207d = b.Q1(this.a, 18);
                this.f3210g = b.A1(this.a, 8);
                this.f3208e = b.A1(this.a, 26);
                int A1 = this.f3208e + 30 + b.A1(this.a, 28);
                this.f3209f = A1;
                int length = this.a.length;
                if (length < A1) {
                    do {
                        length += length;
                    } while (length < A1);
                    this.a = Arrays.copyOf(this.a, length);
                }
            } else {
                this.f3211h = true;
            }
        }
        int d3 = d(this.f3209f, bArr, i2 + d2, i3 - d2);
        if (d3 == -1) {
            return -1;
        }
        int i4 = d2 + d3;
        if (!this.f3211h && this.f3212i == null) {
            this.f3212i = new String(this.a, 30, this.f3208e);
        }
        return i4;
    }

    public final e3 b() {
        int i2 = this.b;
        int i3 = this.f3209f;
        if (i2 < i3) {
            return new k0(this.f3212i, this.f3207d, this.f3210g, true, this.f3211h, Arrays.copyOf(this.a, i2));
        }
        k0 k0Var = new k0(this.f3212i, this.f3207d, this.f3210g, false, this.f3211h, Arrays.copyOf(this.a, i3));
        c();
        return k0Var;
    }

    public final void c() {
        this.b = 0;
        this.f3208e = -1;
        this.c = -1;
        this.f3211h = false;
        this.f3209f = 30;
        this.f3207d = -1;
        this.f3210g = -1;
        this.f3212i = null;
    }

    public final int d(int i2, byte[] bArr, int i3, int i4) {
        int i5 = this.b;
        if (i5 >= i2) {
            return 0;
        }
        int min = Math.min(i4, i2 - i5);
        System.arraycopy(bArr, i3, this.a, this.b, min);
        int i6 = this.b + min;
        this.b = i6;
        if (i6 < i2) {
            return -1;
        }
        return min;
    }
}
