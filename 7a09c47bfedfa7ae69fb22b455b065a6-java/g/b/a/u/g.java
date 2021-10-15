package g.b.a.u;

import g.b.a.p;
import g.b.a.t.b;
import g.b.a.t.h;
import g.b.a.v.c;
import g.b.a.w.e;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.w.o;

public class g extends c {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f6587b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f6588c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h f6589d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ p f6590e;

    public g(b bVar, e eVar, h hVar, p pVar) {
        this.f6587b = bVar;
        this.f6588c = eVar;
        this.f6589d = hVar;
        this.f6590e = pVar;
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        return (this.f6587b == null || !jVar.b()) ? this.f6588c.b(jVar) : this.f6587b.b(jVar);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public <R> R f(l<R> lVar) {
        return lVar == k.f6657b ? (R) this.f6589d : lVar == k.f6656a ? (R) this.f6590e : lVar == k.f6658c ? (R) this.f6588c.f(lVar) : lVar.a(this);
    }

    @Override // g.b.a.w.e
    public boolean k(j jVar) {
        return (this.f6587b == null || !jVar.b()) ? this.f6588c.k(jVar) : this.f6587b.k(jVar);
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        return ((this.f6587b == null || !jVar.b()) ? this.f6588c : this.f6587b).n(jVar);
    }
}
