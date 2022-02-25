package e.g.b;

import java.util.Arrays;

public class g {
    public static int n = 1;
    public boolean a;
    public int b = -1;
    public int c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f1237d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f1238e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1239f = false;

    /* renamed from: g  reason: collision with root package name */
    public float[] f1240g = new float[9];

    /* renamed from: h  reason: collision with root package name */
    public float[] f1241h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    public a f1242i;

    /* renamed from: j  reason: collision with root package name */
    public b[] f1243j = new b[16];

    /* renamed from: k  reason: collision with root package name */
    public int f1244k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f1245l = 0;
    public int m = -1;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public g(a aVar) {
        this.f1242i = aVar;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.f1244k;
            if (i2 >= i3) {
                b[] bVarArr = this.f1243j;
                if (i3 >= bVarArr.length) {
                    this.f1243j = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f1243j;
                int i4 = this.f1244k;
                bVarArr2[i4] = bVar;
                this.f1244k = i4 + 1;
                return;
            } else if (this.f1243j[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public final void b(b bVar) {
        int i2 = this.f1244k;
        int i3 = 0;
        while (i3 < i2) {
            if (this.f1243j[i3] == bVar) {
                while (i3 < i2 - 1) {
                    b[] bVarArr = this.f1243j;
                    int i4 = i3 + 1;
                    bVarArr[i3] = bVarArr[i4];
                    i3 = i4;
                }
                this.f1244k--;
                return;
            }
            i3++;
        }
    }

    public void c() {
        this.f1242i = a.UNKNOWN;
        this.f1237d = 0;
        this.b = -1;
        this.c = -1;
        this.f1238e = 0.0f;
        this.f1239f = false;
        this.m = -1;
        int i2 = this.f1244k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1243j[i3] = null;
        }
        this.f1244k = 0;
        this.f1245l = 0;
        this.a = false;
        Arrays.fill(this.f1241h, 0.0f);
    }

    public void d(d dVar, float f2) {
        this.f1238e = f2;
        this.f1239f = true;
        this.m = -1;
        int i2 = this.f1244k;
        this.c = -1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1243j[i3].k(dVar, this, false);
        }
        this.f1244k = 0;
    }

    public final void e(d dVar, b bVar) {
        int i2 = this.f1244k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1243j[i3].l(dVar, bVar, false);
        }
        this.f1244k = 0;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("");
        h2.append(this.b);
        return h2.toString();
    }
}
