package l.b.a.v;

import l.b.a.q;
import l.b.a.u.b;
import l.b.a.u.h;
import l.b.a.w.c;
import l.b.a.x.e;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.o;

public class g extends c {
    public final /* synthetic */ b b;
    public final /* synthetic */ e c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h f4414d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ q f4415e;

    public g(b bVar, e eVar, h hVar, q qVar) {
        this.b = bVar;
        this.c = eVar;
        this.f4414d = hVar;
        this.f4415e = qVar;
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public o a(j jVar) {
        return (this.b == null || !jVar.a()) ? this.c.a(jVar) : this.b.a(jVar);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public <R> R c(l<R> lVar) {
        return lVar == k.b ? (R) this.f4414d : lVar == k.a ? (R) this.f4415e : lVar == k.c ? (R) this.c.c(lVar) : lVar.a(this);
    }

    @Override // l.b.a.x.e
    public boolean f(j jVar) {
        return (this.b == null || !jVar.a()) ? this.c.f(jVar) : this.b.f(jVar);
    }

    @Override // l.b.a.x.e
    public long i(j jVar) {
        return ((this.b == null || !jVar.a()) ? this.c : this.b).i(jVar);
    }
}
