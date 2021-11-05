package b.g.b;

import java.util.Arrays;

public class g {
    public static int m = 1;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1479a;

    /* renamed from: b  reason: collision with root package name */
    public String f1480b;

    /* renamed from: c  reason: collision with root package name */
    public int f1481c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f1482d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f1483e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f1484f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f1485g = new float[8];
    public float[] h = new float[8];
    public a i;
    public b[] j = new b[8];
    public int k = 0;
    public int l = 0;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public g(a aVar) {
        this.i = aVar;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.k;
            if (i2 >= i3) {
                b[] bVarArr = this.j;
                if (i3 >= bVarArr.length) {
                    this.j = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.j;
                int i4 = this.k;
                bVarArr2[i4] = bVar;
                this.k = i4 + 1;
                return;
            } else if (this.j[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public final void b(b bVar) {
        int i2 = this.k;
        int i3 = 0;
        while (i3 < i2) {
            if (this.j[i3] == bVar) {
                while (i3 < i2 - 1) {
                    b[] bVarArr = this.j;
                    int i4 = i3 + 1;
                    bVarArr[i3] = bVarArr[i4];
                    i3 = i4;
                }
                this.k--;
                return;
            }
            i3++;
        }
    }

    public void c() {
        this.f1480b = null;
        this.i = a.UNKNOWN;
        this.f1483e = 0;
        this.f1481c = -1;
        this.f1482d = -1;
        this.f1484f = 0.0f;
        this.k = 0;
        this.l = 0;
        this.f1479a = false;
        Arrays.fill(this.h, 0.0f);
    }

    public final void d(b bVar) {
        int i2 = this.k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.j[i3].i(bVar, false);
        }
        this.k = 0;
    }

    public String toString() {
        StringBuilder h2 = c.a.a.a.a.h("");
        h2.append(this.f1480b);
        return h2.toString();
    }
}
