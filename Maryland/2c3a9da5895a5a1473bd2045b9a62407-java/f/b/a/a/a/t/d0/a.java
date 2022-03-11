package f.b.a.a.a.t.d0;

import f.b.a.c.b.o.b;
import f.b.a.c.f.b.e;
import f.b.a.c.f.b.g;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import l.b.a.d;

public final /* synthetic */ class a implements i {
    public final /* synthetic */ c a;

    public /* synthetic */ a(c cVar) {
        this.a = cVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        int i2;
        c cVar = this.a;
        Objects.requireNonNull(cVar);
        int i3 = c.f2287i;
        int[] iArr = new int[3];
        iArr[2] = c.f2286h;
        iArr[1] = 3;
        iArr[0] = i3;
        double[][][] dArr = (double[][][]) Array.newInstance(double.class, iArr);
        Iterator it = ((List) obj).iterator();
        while (true) {
            int i4 = -1;
            if (!it.hasNext()) {
                break;
            }
            e eVar = (e) it.next();
            if (cVar.c.get(Integer.valueOf(eVar.f2630d)).doubleValue() != 0.0d && !d.y(eVar.b).u(cVar.f2291d.b().w(c.f2289k))) {
                d b = cVar.f2291d.b();
                d y = d.y(eVar.b);
                int i5 = 0;
                while (i5 < c.f2287i - 1 && y.u(b.w(c.f2285g.get(i5)))) {
                    i5++;
                }
                int i6 = eVar.f2631e;
                for (g gVar : eVar.c) {
                    double d2 = (double) gVar.b;
                    int i7 = 0;
                    while (i7 < c.f2286h + i4 && d2 > c.f2283e.get(i7).doubleValue()) {
                        i7++;
                    }
                    double[] dArr2 = dArr[i5][i6];
                    dArr2[i7] = dArr2[i7] + ((double) gVar.f2634d);
                    i6 = i6;
                    i4 = -1;
                }
            }
        }
        int[] iArr2 = new int[(c.f2287i * 3 * c.f2286h * c.f2288j)];
        for (int i8 = 0; i8 < c.f2287i; i8++) {
            for (int i9 = 0; i9 < 3; i9++) {
                for (int i10 = 0; i10 < c.f2286h; i10++) {
                    double d3 = dArr[i8][i9][i10];
                    if (d3 >= c.f2284f.get(0).doubleValue()) {
                        i2 = 0;
                        while (i2 < c.f2288j - 1) {
                            int i11 = i2 + 1;
                            if (d3 <= c.f2284f.get(i11).doubleValue()) {
                                break;
                            }
                            i2 = i11;
                        }
                    } else {
                        i2 = -1;
                    }
                    if (i2 >= 0) {
                        int i12 = c.f2286h;
                        int i13 = c.f2288j;
                        int i14 = i12 * i9 * i13;
                        iArr2[(i13 * i10) + i14 + (i8 * 3 * i12 * i13) + i2] = 1;
                    }
                }
            }
        }
        return b.d1(b.h(iArr2));
    }
}
