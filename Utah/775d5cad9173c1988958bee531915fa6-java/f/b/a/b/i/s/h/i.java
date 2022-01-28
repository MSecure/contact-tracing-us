package f.b.a.b.i.s.h;

import f.b.a.b.i.p.g;
import f.b.a.b.i.s.i.h;
import f.b.a.b.i.t.b;

public final /* synthetic */ class i implements b.a {
    public final l a;
    public final g b;
    public final Iterable c;

    /* renamed from: d  reason: collision with root package name */
    public final f.b.a.b.i.i f2604d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2605e;

    public i(l lVar, g gVar, Iterable iterable, f.b.a.b.i.i iVar, int i2) {
        this.a = lVar;
        this.b = gVar;
        this.c = iterable;
        this.f2604d = iVar;
        this.f2605e = i2;
    }

    @Override // f.b.a.b.i.t.b.a
    public Object a() {
        l lVar = this.a;
        g gVar = this.b;
        Iterable<h> iterable = this.c;
        f.b.a.b.i.i iVar = this.f2604d;
        int i2 = this.f2605e;
        if (gVar.c() == g.a.TRANSIENT_ERROR) {
            lVar.c.y(iterable);
            lVar.f2606d.a(iVar, i2 + 1);
            return null;
        }
        lVar.c.j(iterable);
        if (gVar.c() == g.a.OK) {
            lVar.c.D(iVar, gVar.b() + lVar.f2609g.a());
        }
        if (!lVar.c.r(iVar)) {
            return null;
        }
        lVar.f2606d.a(iVar, 1);
        return null;
    }
}
