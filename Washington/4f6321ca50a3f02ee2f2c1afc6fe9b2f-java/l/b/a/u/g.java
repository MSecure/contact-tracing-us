package l.b.a.u;

import l.b.a.p;
import l.b.a.t.b;
import l.b.a.t.h;
import l.b.a.v.c;
import l.b.a.w.e;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.w.o;

public class g extends c {
    public final /* synthetic */ b b;
    public final /* synthetic */ e c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h f4163d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ p f4164e;

    public g(b bVar, e eVar, h hVar, p pVar) {
        this.b = bVar;
        this.c = eVar;
        this.f4163d = hVar;
        this.f4164e = pVar;
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        return (this.b == null || !jVar.a()) ? this.c.a(jVar) : this.b.a(jVar);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public <R> R c(l<R> lVar) {
        return lVar == k.b ? (R) this.f4163d : lVar == k.a ? (R) this.f4164e : lVar == k.c ? (R) this.c.c(lVar) : lVar.a(this);
    }

    @Override // l.b.a.w.e
    public boolean f(j jVar) {
        return (this.b == null || !jVar.a()) ? this.c.f(jVar) : this.b.f(jVar);
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        return ((this.b == null || !jVar.a()) ? this.c : this.b).i(jVar);
    }
}
