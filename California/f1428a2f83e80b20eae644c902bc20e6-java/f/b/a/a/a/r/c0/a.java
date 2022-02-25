package f.b.a.a.a.r.c0;

import f.b.a.c.b.o.b;
import f.b.a.c.f.b.d;
import f.b.a.c.f.b.f;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class a implements i {
    public final /* synthetic */ b a;

    public /* synthetic */ a(b bVar) {
        this.a = bVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        double d2;
        int i2;
        b bVar = this.a;
        List<d> list = (List) obj;
        Objects.requireNonNull(bVar);
        int i3 = b.f2203i;
        int[] iArr = new int[3];
        iArr[2] = b.f2202h;
        iArr[1] = 3;
        iArr[0] = i3;
        double[][][] dArr = (double[][][]) Array.newInstance(double.class, iArr);
        int i4 = 0;
        while (true) {
            d2 = 0.0d;
            if (i4 >= b.f2203i) {
                break;
            }
            for (int i5 = 0; i5 < 3; i5++) {
                for (int i6 = 0; i6 < b.f2202h; i6++) {
                    dArr[i4][i5][i6] = 0.0d;
                }
            }
            i4++;
        }
        for (d dVar : list) {
            if (bVar.c.get(Integer.valueOf(dVar.f2523d)).doubleValue() != d2 && !l.b.a.d.x(dVar.b).t(bVar.f2207d.b().v(b.f2205k))) {
                l.b.a.d b = bVar.f2207d.b();
                l.b.a.d x = l.b.a.d.x(dVar.b);
                int i7 = 0;
                while (i7 < b.f2203i - 1 && x.t(b.v(b.f2201g.get(i7)))) {
                    i7++;
                }
                int i8 = dVar.f2524e;
                for (f fVar : dVar.c) {
                    double d3 = (double) fVar.b;
                    int i9 = 0;
                    while (i9 < b.f2202h - 1 && d3 > b.f2199e.get(i9).doubleValue()) {
                        i9++;
                    }
                    double[] dArr2 = dArr[i7][i8];
                    dArr2[i9] = dArr2[i9] + ((double) fVar.f2526d);
                    d2 = 0.0d;
                }
            }
        }
        int[] iArr2 = new int[(b.f2203i * 3 * b.f2202h * b.f2204j)];
        for (int i10 = 0; i10 < b.f2203i; i10++) {
            for (int i11 = 0; i11 < 3; i11++) {
                for (int i12 = 0; i12 < b.f2202h; i12++) {
                    double d4 = dArr[i10][i11][i12];
                    int i13 = 0;
                    while (true) {
                        i2 = b.f2204j;
                        if (i13 >= i2 - 1 || d4 <= b.f2200f.get(i13).doubleValue()) {
                            int i14 = b.f2202h;
                            int i15 = i14 * i11 * i2;
                            iArr2[(i2 * i12) + i15 + (i10 * 3 * i14 * i2) + i13] = 1;
                        } else {
                            i13++;
                        }
                    }
                    int i142 = b.f2202h;
                    int i152 = i142 * i11 * i2;
                    iArr2[(i2 * i12) + i152 + (i10 * 3 * i142 * i2) + i13] = 1;
                }
            }
        }
        return b.c1(b.h(iArr2));
    }
}
