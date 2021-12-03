package f.d.b;

import j.k.b.e;

public final class e$a implements f {
    @Override // f.d.b.f
    public boolean a(b<?> bVar, int i2, int i3, int i4) {
        e.c(bVar, "fastAdapter");
        if (i2 > i3) {
            if (i3 > 0) {
                b.s(bVar, i4, i3, null, 4, null);
            }
            bVar.t(i4 + i3, i2 - i3);
            return false;
        }
        if (i2 > 0) {
            b.s(bVar, i4, i2, null, 4, null);
            if (i2 >= i3) {
                return false;
            }
            i4 += i2;
            i3 -= i2;
        } else if (i2 != 0) {
            bVar.r();
            return false;
        }
        bVar.u(i4, i3);
        return false;
    }
}
