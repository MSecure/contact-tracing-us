package e.c.a.u;

import e.c.a.p;
import e.c.a.t.b;
import e.c.a.t.h;
import e.c.a.v.c;
import e.c.a.w.e;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.w.o;

public class g extends c {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f5119b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f5120c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h f5121d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ p f5122e;

    public g(b bVar, e eVar, h hVar, p pVar) {
        this.f5119b = bVar;
        this.f5120c = eVar;
        this.f5121d = hVar;
        this.f5122e = pVar;
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        return (this.f5119b == null || !jVar.b()) ? this.f5120c.b(jVar) : this.f5119b.b(jVar);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public <R> R f(l<R> lVar) {
        return lVar == k.f5178b ? (R) this.f5121d : lVar == k.f5177a ? (R) this.f5122e : lVar == k.f5179c ? (R) this.f5120c.f(lVar) : lVar.a(this);
    }

    @Override // e.c.a.w.e
    public boolean i(j jVar) {
        return (this.f5119b == null || !jVar.b()) ? this.f5120c.i(jVar) : this.f5119b.i(jVar);
    }

    @Override // e.c.a.w.e
    public long l(j jVar) {
        return ((this.f5119b == null || !jVar.b()) ? this.f5120c : this.f5119b).l(jVar);
    }
}
