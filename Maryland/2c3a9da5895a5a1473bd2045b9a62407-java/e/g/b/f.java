package e.g.b;

import e.g.b.b;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class f extends b {

    /* renamed from: f  reason: collision with root package name */
    public int f1245f = 128;

    /* renamed from: g  reason: collision with root package name */
    public g[] f1246g = new g[128];

    /* renamed from: h  reason: collision with root package name */
    public g[] f1247h = new g[128];

    /* renamed from: i  reason: collision with root package name */
    public int f1248i = 0;

    /* renamed from: j  reason: collision with root package name */
    public b f1249j = new b(this);

    public class a implements Comparator<g> {
        public a(f fVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(g gVar, g gVar2) {
            return gVar.b - gVar2.b;
        }
    }

    public class b implements Comparable {
        public g b;

        public b(f fVar) {
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.b.b - ((g) obj).b;
        }

        public String toString() {
            String str = "[ ";
            if (this.b != null) {
                for (int i2 = 0; i2 < 9; i2++) {
                    StringBuilder h2 = f.a.a.a.a.h(str);
                    h2.append(this.b.f1254h[i2]);
                    h2.append(" ");
                    str = h2.toString();
                }
            }
            StringBuilder i3 = f.a.a.a.a.i(str, "] ");
            i3.append(this.b);
            return i3.toString();
        }
    }

    public f(c cVar) {
        super(cVar);
    }

    @Override // e.g.b.b, e.g.b.d.a
    public void a(g gVar) {
        this.f1249j.b = gVar;
        Arrays.fill(gVar.f1254h, 0.0f);
        gVar.f1254h[gVar.f1250d] = 1.0f;
        m(gVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r8 < r7) goto L_0x0057;
     */
    @Override // e.g.b.b, e.g.b.d.a
    public g b(d dVar, boolean[] zArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < this.f1248i; i3++) {
            g[] gVarArr = this.f1246g;
            g gVar = gVarArr[i3];
            if (!zArr[gVar.b]) {
                b bVar = this.f1249j;
                bVar.b = gVar;
                int i4 = 8;
                boolean z = true;
                if (i2 == -1) {
                    Objects.requireNonNull(bVar);
                    while (true) {
                        if (i4 < 0) {
                            break;
                        }
                        float f2 = bVar.b.f1254h[i4];
                        if (f2 > 0.0f) {
                            break;
                        } else if (f2 < 0.0f) {
                            break;
                        } else {
                            i4--;
                        }
                    }
                    if (!z) {
                    }
                } else {
                    g gVar2 = gVarArr[i2];
                    Objects.requireNonNull(bVar);
                    while (true) {
                        if (i4 < 0) {
                            break;
                        }
                        float f3 = gVar2.f1254h[i4];
                        float f4 = bVar.b.f1254h[i4];
                        if (f4 == f3) {
                            i4--;
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
                i2 = i3;
            }
        }
        if (i2 == -1) {
            return null;
        }
        return this.f1246g[i2];
    }

    @Override // e.g.b.b, e.g.b.d.a
    public void clear() {
        this.f1248i = 0;
        this.b = 0.0f;
    }

    @Override // e.g.b.b, e.g.b.d.a
    public boolean isEmpty() {
        return this.f1248i == 0;
    }

    @Override // e.g.b.b
    public void l(d dVar, b bVar, boolean z) {
        g gVar = bVar.a;
        if (gVar != null) {
            b.a aVar = bVar.f1233d;
            int k2 = aVar.k();
            for (int i2 = 0; i2 < k2; i2++) {
                g f2 = aVar.f(i2);
                float a2 = aVar.a(i2);
                b bVar2 = this.f1249j;
                bVar2.b = f2;
                boolean z2 = true;
                if (f2.a) {
                    for (int i3 = 0; i3 < 9; i3++) {
                        float[] fArr = bVar2.b.f1254h;
                        fArr[i3] = (gVar.f1254h[i3] * a2) + fArr[i3];
                        if (Math.abs(fArr[i3]) < 1.0E-4f) {
                            bVar2.b.f1254h[i3] = 0.0f;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        f.this.n(bVar2.b);
                    }
                    z2 = false;
                } else {
                    for (int i4 = 0; i4 < 9; i4++) {
                        float f3 = gVar.f1254h[i4];
                        if (f3 != 0.0f) {
                            float f4 = f3 * a2;
                            if (Math.abs(f4) < 1.0E-4f) {
                                f4 = 0.0f;
                            }
                            bVar2.b.f1254h[i4] = f4;
                        } else {
                            bVar2.b.f1254h[i4] = 0.0f;
                        }
                    }
                }
                if (z2) {
                    m(f2);
                }
                this.b = (bVar.b * a2) + this.b;
            }
            n(gVar);
        }
    }

    public final void m(g gVar) {
        int i2;
        int i3 = this.f1248i + 1;
        g[] gVarArr = this.f1246g;
        if (i3 > gVarArr.length) {
            g[] gVarArr2 = (g[]) Arrays.copyOf(gVarArr, gVarArr.length * 2);
            this.f1246g = gVarArr2;
            this.f1247h = (g[]) Arrays.copyOf(gVarArr2, gVarArr2.length * 2);
        }
        g[] gVarArr3 = this.f1246g;
        int i4 = this.f1248i;
        gVarArr3[i4] = gVar;
        int i5 = i4 + 1;
        this.f1248i = i5;
        if (i5 > 1 && gVarArr3[i5 - 1].b > gVar.b) {
            int i6 = 0;
            while (true) {
                i2 = this.f1248i;
                if (i6 >= i2) {
                    break;
                }
                this.f1247h[i6] = this.f1246g[i6];
                i6++;
            }
            Arrays.sort(this.f1247h, 0, i2, new a(this));
            for (int i7 = 0; i7 < this.f1248i; i7++) {
                this.f1246g[i7] = this.f1247h[i7];
            }
        }
        gVar.a = true;
        gVar.a(this);
    }

    public final void n(g gVar) {
        int i2 = 0;
        while (i2 < this.f1248i) {
            if (this.f1246g[i2] == gVar) {
                while (true) {
                    int i3 = this.f1248i;
                    if (i2 < i3 - 1) {
                        g[] gVarArr = this.f1246g;
                        int i4 = i2 + 1;
                        gVarArr[i2] = gVarArr[i4];
                        i2 = i4;
                    } else {
                        this.f1248i = i3 - 1;
                        gVar.a = false;
                        return;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    @Override // e.g.b.b
    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("", " goal -> (");
        i2.append(this.b);
        i2.append(") : ");
        String sb = i2.toString();
        for (int i3 = 0; i3 < this.f1248i; i3++) {
            this.f1249j.b = this.f1246g[i3];
            StringBuilder h2 = f.a.a.a.a.h(sb);
            h2.append(this.f1249j);
            h2.append(" ");
            sb = h2.toString();
        }
        return sb;
    }
}
