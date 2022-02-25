package e.g.b;

import java.util.Arrays;

public class g {
    public static int n = 1;
    public boolean a;
    public int b = -1;
    public int c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f1238d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f1239e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1240f = false;

    /* renamed from: g  reason: collision with root package name */
    public float[] f1241g = new float[9];

    /* renamed from: h  reason: collision with root package name */
    public float[] f1242h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    public a f1243i;

    /* renamed from: j  reason: collision with root package name */
    public b[] f1244j = new b[16];

    /* renamed from: k  reason: collision with root package name */
    public int f1245k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f1246l = 0;
    public int m = -1;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public g(a aVar) {
        this.f1243i = aVar;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.f1245k;
            if (i2 >= i3) {
                b[] bVarArr = this.f1244j;
                if (i3 >= bVarArr.length) {
                    this.f1244j = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f1244j;
                int i4 = this.f1245k;
                bVarArr2[i4] = bVar;
                this.f1245k = i4 + 1;
                return;
            } else if (this.f1244j[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public final void b(b bVar) {
        int i2 = this.f1245k;
        int i3 = 0;
        while (i3 < i2) {
            if (this.f1244j[i3] == bVar) {
                while (i3 < i2 - 1) {
                    b[] bVarArr = this.f1244j;
                    int i4 = i3 + 1;
                    bVarArr[i3] = bVarArr[i4];
                    i3 = i4;
                }
                this.f1245k--;
                return;
            }
            i3++;
        }
    }

    public void c() {
        this.f1243i = a.UNKNOWN;
        this.f1238d = 0;
        this.b = -1;
        this.c = -1;
        this.f1239e = 0.0f;
        this.f1240f = false;
        this.m = -1;
        int i2 = this.f1245k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1244j[i3] = null;
        }
        this.f1245k = 0;
        this.f1246l = 0;
        this.a = false;
        Arrays.fill(this.f1242h, 0.0f);
    }

    public void d(d dVar, float f2) {
        this.f1239e = f2;
        this.f1240f = true;
        this.m = -1;
        int i2 = this.f1245k;
        this.c = -1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1244j[i3].k(dVar, this, false);
        }
        this.f1245k = 0;
    }

    public final void e(d dVar, b bVar) {
        int i2 = this.f1245k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1244j[i3].l(dVar, bVar, false);
        }
        this.f1245k = 0;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("");
        h2.append(this.b);
        return h2.toString();
    }
}
