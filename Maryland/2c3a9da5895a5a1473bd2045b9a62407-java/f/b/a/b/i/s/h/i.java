package f.b.a.b.i.s.h;

import f.b.a.b.i.p.g;
import f.b.a.b.i.s.i.h;
import f.b.a.b.i.t.b;

public final /* synthetic */ class i implements b.a {
    public final l a;
    public final g b;
    public final Iterable c;

    /* renamed from: d  reason: collision with root package name */
    public final f.b.a.b.i.i f2461d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2462e;

    public i(l lVar, g gVar, Iterable iterable, f.b.a.b.i.i iVar, int i2) {
        this.a = lVar;
        this.b = gVar;
        this.c = iterable;
        this.f2461d = iVar;
        this.f2462e = i2;
    }

    @Override // f.b.a.b.i.t.b.a
    public Object a() {
        l lVar = this.a;
        g gVar = this.b;
        Iterable<h> iterable = this.c;
        f.b.a.b.i.i iVar = this.f2461d;
        int i2 = this.f2462e;
        if (gVar.c() == g.a.TRANSIENT_ERROR) {
            lVar.c.B(iterable);
            lVar.f2463d.a(iVar, i2 + 1);
            return null;
        }
        lVar.c.j(iterable);
        if (gVar.c() == g.a.OK) {
            lVar.c.H(iVar, gVar.b() + lVar.f2466g.a());
        }
        if (!lVar.c.t(iVar)) {
            return null;
        }
        lVar.f2463d.a(iVar, 1);
        return null;
    }
}
