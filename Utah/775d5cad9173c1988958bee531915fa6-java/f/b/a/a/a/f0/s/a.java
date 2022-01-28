package f.b.a.a.a.f0.s;

import f.b.a.c.b.o.b;
import f.b.a.c.f.b.e;
import f.b.a.c.f.b.g;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class a implements i {
    public final /* synthetic */ g a;

    public /* synthetic */ a(g gVar) {
        this.a = gVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        int i2;
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        int i3 = g.f2244i;
        int[] iArr = new int[3];
        iArr[2] = g.f2243h;
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
            if (gVar.c.get(Integer.valueOf(eVar.f2774d)).doubleValue() != 0.0d && !l.b.a.e.z(eVar.b).u(gVar.f2248d.c().w(g.f2246k))) {
                l.b.a.e c = gVar.f2248d.c();
                l.b.a.e z = l.b.a.e.z(eVar.b);
                int i5 = 0;
                while (i5 < g.f2244i - 1 && z.u(c.w(g.f2242g.get(i5)))) {
                    i5++;
                }
                int i6 = eVar.f2775e;
                for (g gVar2 : eVar.c) {
                    double d2 = (double) gVar2.b;
                    int i7 = 0;
                    while (i7 < g.f2243h + i4 && d2 > g.f2240e.get(i7).doubleValue()) {
                        i7++;
                    }
                    double[] dArr2 = dArr[i5][i6];
                    dArr2[i7] = dArr2[i7] + ((double) gVar2.f2778d);
                    i6 = i6;
                    i4 = -1;
                }
            }
        }
        int[] iArr2 = new int[(g.f2244i * 3 * g.f2243h * g.f2245j)];
        for (int i8 = 0; i8 < g.f2244i; i8++) {
            for (int i9 = 0; i9 < 3; i9++) {
                for (int i10 = 0; i10 < g.f2243h; i10++) {
                    double d3 = dArr[i8][i9][i10];
                    if (d3 >= g.f2241f.get(0).doubleValue()) {
                        i2 = 0;
                        while (i2 < g.f2245j - 1) {
                            int i11 = i2 + 1;
                            if (d3 <= g.f2241f.get(i11).doubleValue()) {
                                break;
                            }
                            i2 = i11;
                        }
                    } else {
                        i2 = -1;
                    }
                    if (i2 >= 0) {
                        int i12 = g.f2243h;
                        int i13 = g.f2245j;
                        int i14 = i12 * i9 * i13;
                        iArr2[(i13 * i10) + i14 + (i8 * 3 * i12 * i13) + i2] = 1;
                    }
                }
            }
        }
        return b.Q0(b.h(iArr2));
    }
}
