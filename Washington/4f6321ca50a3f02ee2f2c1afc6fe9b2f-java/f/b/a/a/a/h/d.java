package f.b.a.a.a.h;

import e.p.r;

public final /* synthetic */ class d implements r {
    public final /* synthetic */ q a;
    public final /* synthetic */ r b;

    public /* synthetic */ d(q qVar, r rVar) {
        this.a = qVar;
        this.b = rVar;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        q qVar = this.a;
        r rVar = this.b;
        if (qVar.f2075l.compareAndSet(true, false)) {
            rVar.a(obj);
        }
    }
}
