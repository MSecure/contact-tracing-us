package l.b.a.w;

import l.b.a.b;

public final class h implements f {
    public final int b;
    public final int c;

    public h(int i2, b bVar, g gVar) {
        f.b.a.c.b.o.b.B1(bVar, "dayOfWeek");
        this.b = i2;
        this.c = bVar.q();
    }

    @Override // l.b.a.w.f
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
