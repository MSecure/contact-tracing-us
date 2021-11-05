package b.g.a;

import java.util.Arrays;

public class g {
    public static int k = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f883a;

    /* renamed from: b  reason: collision with root package name */
    public int f884b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f885c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f886d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f887e;
    public float[] f = new float[7];
    public a g;
    public b[] h = new b[8];
    public int i = 0;
    public int j = 0;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public g(a aVar) {
        this.g = aVar;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.i;
            if (i2 >= i3) {
                b[] bVarArr = this.h;
                if (i3 >= bVarArr.length) {
                    this.h = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.h;
                int i4 = this.i;
                bVarArr2[i4] = bVar;
                this.i = i4 + 1;
                return;
            } else if (this.h[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public final void b(b bVar) {
        int i2 = this.i;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.h[i3] == bVar) {
                for (int i4 = 0; i4 < (i2 - i3) - 1; i4++) {
                    b[] bVarArr = this.h;
                    int i5 = i3 + i4;
                    bVarArr[i5] = bVarArr[i5 + 1];
                }
                this.i--;
                return;
            }
        }
    }

    public void c() {
        this.f883a = null;
        this.g = a.UNKNOWN;
        this.f886d = 0;
        this.f884b = -1;
        this.f885c = -1;
        this.f887e = 0.0f;
        this.i = 0;
        this.j = 0;
    }

    public final void d(b bVar) {
        int i2 = this.i;
        for (int i3 = 0; i3 < i2; i3++) {
            b[] bVarArr = this.h;
            a aVar = bVarArr[i3].f871d;
            b bVar2 = bVarArr[i3];
            while (true) {
                int i4 = aVar.i;
                int i5 = 0;
                while (i4 != -1 && i5 < aVar.f863a) {
                    int i6 = aVar.f[i4];
                    g gVar = bVar.f868a;
                    if (i6 == gVar.f884b) {
                        float f2 = aVar.h[i4];
                        aVar.i(gVar, false);
                        a aVar2 = bVar.f871d;
                        int i7 = aVar2.i;
                        int i8 = 0;
                        while (i7 != -1 && i8 < aVar2.f863a) {
                            aVar.a(aVar.f865c.f875c[aVar2.f[i7]], aVar2.h[i7] * f2, false);
                            i7 = aVar2.g[i7];
                            i8++;
                        }
                        bVar2.f869b = (bVar.f869b * f2) + bVar2.f869b;
                    } else {
                        i4 = aVar.g[i4];
                        i5++;
                    }
                }
            }
        }
        this.i = 0;
    }

    public String toString() {
        StringBuilder g2 = c.a.a.a.a.g("");
        g2.append(this.f883a);
        return g2.toString();
    }
}
