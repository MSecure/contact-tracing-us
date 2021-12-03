package e.g.a;

import java.util.Arrays;

public class g implements Comparable<g> {
    public static int o = 1;
    public boolean b;
    public int c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f1271d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f1272e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f1273f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1274g = false;

    /* renamed from: h  reason: collision with root package name */
    public float[] f1275h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    public float[] f1276i = new float[9];

    /* renamed from: j  reason: collision with root package name */
    public a f1277j;

    /* renamed from: k  reason: collision with root package name */
    public b[] f1278k = new b[16];

    /* renamed from: l  reason: collision with root package name */
    public int f1279l = 0;
    public int m = 0;
    public int n = -1;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public g(a aVar) {
        this.f1277j = aVar;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.f1279l;
            if (i2 >= i3) {
                b[] bVarArr = this.f1278k;
                if (i3 >= bVarArr.length) {
                    this.f1278k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f1278k;
                int i4 = this.f1279l;
                bVarArr2[i4] = bVar;
                this.f1279l = i4 + 1;
                return;
            } else if (this.f1278k[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public final void b(b bVar) {
        int i2 = this.f1279l;
        int i3 = 0;
        while (i3 < i2) {
            if (this.f1278k[i3] == bVar) {
                while (i3 < i2 - 1) {
                    b[] bVarArr = this.f1278k;
                    int i4 = i3 + 1;
                    bVarArr[i3] = bVarArr[i4];
                    i3 = i4;
                }
                this.f1279l--;
                return;
            }
            i3++;
        }
    }

    public void c() {
        this.f1277j = a.UNKNOWN;
        this.f1272e = 0;
        this.c = -1;
        this.f1271d = -1;
        this.f1273f = 0.0f;
        this.f1274g = false;
        this.n = -1;
        int i2 = this.f1279l;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1278k[i3] = null;
        }
        this.f1279l = 0;
        this.m = 0;
        this.b = false;
        Arrays.fill(this.f1276i, 0.0f);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(g gVar) {
        return this.c - gVar.c;
    }

    public void e(d dVar, float f2) {
        this.f1273f = f2;
        this.f1274g = true;
        this.n = -1;
        int i2 = this.f1279l;
        this.f1271d = -1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1278k[i3].k(dVar, this, false);
        }
        this.f1279l = 0;
    }

    public final void f(d dVar, b bVar) {
        int i2 = this.f1279l;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1278k[i3].l(dVar, bVar, false);
        }
        this.f1279l = 0;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("");
        h2.append(this.c);
        return h2.toString();
    }
}
