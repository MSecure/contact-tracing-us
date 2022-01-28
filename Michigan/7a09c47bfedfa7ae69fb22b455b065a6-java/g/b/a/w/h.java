package g.b.a.w;

import b.x.t;
import g.b.a.b;

public final class h implements f {

    /* renamed from: b  reason: collision with root package name */
    public final int f6654b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6655c;

    public h(int i, b bVar, g gVar) {
        t.y2(bVar, "dayOfWeek");
        this.f6654b = i;
        this.f6655c = bVar.p();
    }

    @Override // g.b.a.w.f
    public d t(d dVar) {
        int d2 = dVar.d(a.DAY_OF_WEEK);
        if (this.f6654b < 2 && d2 == this.f6655c) {
            return dVar;
        }
        if ((this.f6654b & 1) == 0) {
            int i = d2 - this.f6655c;
            return dVar.s((long) (i >= 0 ? 7 - i : -i), b.DAYS);
        }
        int i2 = this.f6655c - d2;
        return dVar.m((long) (i2 >= 0 ? 7 - i2 : -i2), b.DAYS);
    }
}
