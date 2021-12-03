package l.b.a.x;

import g.b.a.c.c.d;
import l.b.a.c;

public final class h implements f {
    public final int b;
    public final int c;

    public h(int i2, c cVar, g gVar) {
        d.u(cVar, "dayOfWeek");
        this.b = i2;
        this.c = cVar.q();
    }

    @Override // l.b.a.x.f
    public d n(d dVar) {
        int b2 = dVar.b(a.DAY_OF_WEEK);
        int i2 = this.b;
        if (i2 < 2 && b2 == this.c) {
            return dVar;
        }
        if ((i2 & 1) == 0) {
            int i3 = b2 - this.c;
            return dVar.m((long) (i3 >= 0 ? 7 - i3 : -i3), b.DAYS);
        }
        int i4 = this.c - b2;
        return dVar.h((long) (i4 >= 0 ? 7 - i4 : -i4), b.DAYS);
    }
}
