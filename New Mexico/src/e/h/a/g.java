package e.h.a;

import java.util.Arrays;
/* loaded from: classes.dex */
public class g implements Comparable<g> {
    public static int o;
    public boolean b;

    /* renamed from: f */
    public float f1357f;

    /* renamed from: j */
    public a f1361j;
    public int c = -1;

    /* renamed from: d */
    public int f1355d = -1;

    /* renamed from: e */
    public int f1356e = 0;

    /* renamed from: g */
    public boolean f1358g = false;

    /* renamed from: h */
    public float[] f1359h = new float[9];

    /* renamed from: i */
    public float[] f1360i = new float[9];

    /* renamed from: k */
    public b[] f1362k = new b[16];

    /* renamed from: l */
    public int f1363l = 0;
    public int m = 0;
    public int n = -1;

    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public g(a aVar) {
        this.f1361j = aVar;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.f1363l;
            if (i2 >= i3) {
                b[] bVarArr = this.f1362k;
                if (i3 >= bVarArr.length) {
                    this.f1362k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f1362k;
                int i4 = this.f1363l;
                bVarArr2[i4] = bVar;
                this.f1363l = i4 + 1;
                return;
            } else if (this.f1362k[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 >= (r0 - 1)) goto L_0x0019;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
        r5 = r4.f1362k;
        r2 = r1 + 1;
        r5[r1] = r5[r2];
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        r4.f1363l--;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void b(b bVar) {
        int i2 = this.f1363l;
        int i3 = 0;
        while (i3 < i2) {
            if (this.f1362k[i3] == bVar) {
                break;
            }
            i3++;
        }
    }

    public void c() {
        this.f1361j = a.UNKNOWN;
        this.f1356e = 0;
        this.c = -1;
        this.f1355d = -1;
        this.f1357f = 0.0f;
        this.f1358g = false;
        this.n = -1;
        int i2 = this.f1363l;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1362k[i3] = null;
        }
        this.f1363l = 0;
        this.m = 0;
        this.b = false;
        Arrays.fill(this.f1360i, 0.0f);
    }

    @Override // java.lang.Comparable
    public int compareTo(g gVar) {
        return this.c - gVar.c;
    }

    public void e(d dVar, float f2) {
        this.f1357f = f2;
        this.f1358g = true;
        this.n = -1;
        int i2 = this.f1363l;
        this.f1355d = -1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1362k[i3].k(dVar, this, false);
        }
        this.f1363l = 0;
    }

    public final void f(d dVar, b bVar) {
        int i2 = this.f1363l;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1362k[i3].l(dVar, bVar, false);
        }
        this.f1363l = 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("");
        h2.append(this.c);
        return h2.toString();
    }
}
