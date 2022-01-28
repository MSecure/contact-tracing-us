package f.b.a.a.a.s;

import e.q.t;

public final /* synthetic */ class g implements t {
    public final /* synthetic */ z a;
    public final /* synthetic */ t b;

    public /* synthetic */ g(z zVar, t tVar) {
        this.a = zVar;
        this.b = tVar;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        z zVar = this.a;
        t tVar = this.b;
        if (zVar.f2346l.compareAndSet(true, false)) {
            tVar.a(obj);
        }
    }
}
