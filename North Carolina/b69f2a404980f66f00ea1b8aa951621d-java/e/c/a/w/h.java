package e.c.a.w;

import c.b.a.a.c.n.c;
import e.c.a.b;

public final class h implements f {

    /* renamed from: b  reason: collision with root package name */
    public final int f5175b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5176c;

    public h(int i, b bVar, g gVar) {
        c.T1(bVar, "dayOfWeek");
        this.f5175b = i;
        this.f5176c = bVar.s();
    }

    @Override // e.c.a.w.f
    public d p(d dVar) {
        int d2 = dVar.d(a.DAY_OF_WEEK);
        if (this.f5175b < 2 && d2 == this.f5176c) {
            return dVar;
        }
        if ((this.f5175b & 1) == 0) {
            int i = d2 - this.f5176c;
            return dVar.o((long) (i >= 0 ? 7 - i : -i), b.DAYS);
        }
        int i2 = this.f5176c - d2;
        return dVar.k((long) (i2 >= 0 ? 7 - i2 : -i2), b.DAYS);
    }
}
