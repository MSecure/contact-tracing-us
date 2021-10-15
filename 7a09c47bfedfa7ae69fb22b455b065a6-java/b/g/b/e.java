package b.g.b;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.Comparator;

public class e extends b {

    /* renamed from: f  reason: collision with root package name */
    public int f1473f = RecyclerView.a0.FLAG_IGNORE;

    /* renamed from: g  reason: collision with root package name */
    public g[] f1474g = new g[RecyclerView.a0.FLAG_IGNORE];
    public g[] h = new g[RecyclerView.a0.FLAG_IGNORE];
    public int i = 0;
    public b j = new b(this);
    public c k;

    public class a implements Comparator<g> {
        public a(e eVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(g gVar, g gVar2) {
            return gVar.f1481c - gVar2.f1481c;
        }
    }

    public class b implements Comparable {

        /* renamed from: b  reason: collision with root package name */
        public g f1475b;

        public b(e eVar) {
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f1475b.f1481c - ((g) obj).f1481c;
        }

        public String toString() {
            String str = "[ ";
            if (this.f1475b != null) {
                for (int i = 0; i < 8; i++) {
                    StringBuilder h = c.a.a.a.a.h(str);
                    h.append(this.f1475b.h[i]);
                    h.append(" ");
                    str = h.toString();
                }
            }
            return str + "] " + this.f1475b;
        }
    }

    public e(c cVar) {
        super(cVar);
        this.k = cVar;
    }

    @Override // b.g.b.b, b.g.b.d.a
    public void a(g gVar) {
        this.j.f1475b = gVar;
        Arrays.fill(gVar.h, 0.0f);
        gVar.h[gVar.f1483e] = 1.0f;
        j(gVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        if (r8 < r4) goto L_0x0056;
     */
    @Override // b.g.b.b, b.g.b.d.a
    public g b(d dVar, boolean[] zArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < this.i; i3++) {
            g[] gVarArr = this.f1474g;
            g gVar = gVarArr[i3];
            if (!zArr[gVar.f1481c]) {
                b bVar = this.j;
                bVar.f1475b = gVar;
                int i4 = 7;
                boolean z = true;
                if (i2 != -1) {
                    g gVar2 = gVarArr[i2];
                    if (bVar != null) {
                        while (true) {
                            if (i4 < 0) {
                                break;
                            }
                            float f2 = gVar2.h[i4];
                            float f3 = bVar.f1475b.h[i4];
                            if (f3 == f2) {
                                i4--;
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    } else {
                        throw null;
                    }
                } else if (bVar != null) {
                    while (true) {
                        if (i4 < 0) {
                            break;
                        }
                        float f4 = bVar.f1475b.h[i4];
                        if (f4 > 0.0f) {
                            break;
                        } else if (f4 < 0.0f) {
                            break;
                        } else {
                            i4--;
                        }
                    }
                    if (!z) {
                    }
                } else {
                    throw null;
                }
                i2 = i3;
            }
        }
        if (i2 == -1) {
            return null;
        }
        return this.f1474g[i2];
    }

    @Override // b.g.b.b, b.g.b.d.a
    public void clear() {
        this.i = 0;
        this.f1459b = 0.0f;
    }

    @Override // b.g.b.b
    public void i(b bVar, boolean z) {
        boolean z2;
        g gVar = bVar.f1458a;
        if (gVar != null) {
            a aVar = bVar.f1461d;
            int i2 = aVar.i;
            int i3 = aVar.f1451a;
            while (i2 != -1 && i3 > 0) {
                a aVar2 = bVar.f1461d;
                int i4 = aVar2.f1456f[i2];
                float f2 = aVar2.h[i2];
                g gVar2 = this.k.f1465c[i4];
                b bVar2 = this.j;
                bVar2.f1475b = gVar2;
                boolean z3 = true;
                if (gVar2.f1479a) {
                    for (int i5 = 0; i5 < 8; i5++) {
                        float[] fArr = bVar2.f1475b.h;
                        fArr[i5] = (gVar.h[i5] * f2) + fArr[i5];
                        if (Math.abs(fArr[i5]) < 1.0E-4f) {
                            bVar2.f1475b.h[i5] = 0.0f;
                        } else {
                            z3 = false;
                        }
                    }
                    if (z3) {
                        e.this.k(bVar2.f1475b);
                    }
                    z2 = false;
                } else {
                    for (int i6 = 0; i6 < 8; i6++) {
                        float f3 = gVar.h[i6];
                        if (f3 != 0.0f) {
                            float f4 = f3 * f2;
                            if (Math.abs(f4) < 1.0E-4f) {
                                f4 = 0.0f;
                            }
                            bVar2.f1475b.h[i6] = f4;
                        } else {
                            bVar2.f1475b.h[i6] = 0.0f;
                        }
                    }
                    z2 = true;
                }
                if (z2) {
                    j(gVar2);
                }
                this.f1459b = (bVar.f1459b * f2) + this.f1459b;
                i2 = bVar.f1461d.f1457g[i2];
            }
            k(gVar);
        }
    }

    public final void j(g gVar) {
        int i2;
        int i3 = this.i + 1;
        g[] gVarArr = this.f1474g;
        if (i3 > gVarArr.length) {
            g[] gVarArr2 = (g[]) Arrays.copyOf(gVarArr, gVarArr.length * 2);
            this.f1474g = gVarArr2;
            this.h = (g[]) Arrays.copyOf(gVarArr2, gVarArr2.length * 2);
        }
        g[] gVarArr3 = this.f1474g;
        int i4 = this.i;
        gVarArr3[i4] = gVar;
        int i5 = i4 + 1;
        this.i = i5;
        if (i5 > 1 && gVarArr3[i5 - 1].f1481c > gVar.f1481c) {
            int i6 = 0;
            while (true) {
                i2 = this.i;
                if (i6 >= i2) {
                    break;
                }
                this.h[i6] = this.f1474g[i6];
                i6++;
            }
            Arrays.sort(this.h, 0, i2, new a(this));
            for (int i7 = 0; i7 < this.i; i7++) {
                this.f1474g[i7] = this.h[i7];
            }
        }
        gVar.f1479a = true;
        gVar.a(this);
    }

    public final void k(g gVar) {
        int i2 = 0;
        while (i2 < this.i) {
            if (this.f1474g[i2] == gVar) {
                while (true) {
                    int i3 = this.i;
                    if (i2 < i3 - 1) {
                        g[] gVarArr = this.f1474g;
                        int i4 = i2 + 1;
                        gVarArr[i2] = gVarArr[i4];
                        i2 = i4;
                    } else {
                        this.i = i3 - 1;
                        gVar.f1479a = false;
                        return;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    @Override // b.g.b.b
    public String toString() {
        String str = "" + " goal -> (" + this.f1459b + ") : ";
        for (int i2 = 0; i2 < this.i; i2++) {
            this.j.f1475b = this.f1474g[i2];
            StringBuilder h2 = c.a.a.a.a.h(str);
            h2.append(this.j);
            h2.append(" ");
            str = h2.toString();
        }
        return str;
    }
}
