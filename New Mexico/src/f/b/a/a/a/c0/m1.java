package f.b.a.a.a.c0;

import f.b.a.a.a.n0.l;
import f.b.a.a.a.n0.m;
import f.b.a.a.a.n0.m0;
import f.b.a.a.a.n0.p0;
import f.b.a.a.a.n0.r0;
import f.b.a.a.a.n0.v0;
import f.b.a.a.a.y.q;
import f.b.b.b.a;
import f.b.b.b.c;
import f.b.b.f.a.p;
/* loaded from: classes.dex */
public class m1 implements p<Void> {
    public final /* synthetic */ c a;
    public final /* synthetic */ n1 b;

    public m1(n1 n1Var, c cVar) {
        this.b = n1Var;
        this.a = cVar;
    }

    @Override // f.b.b.f.a.p
    public void a(Void r6) {
        a t = this.a.listIterator();
        while (t.hasNext()) {
            q qVar = (q) t.next();
            if (qVar.c()) {
                n1.f2196h.a(String.format("Mark last successful download [%s] for server [%s]", qVar.d(), qVar.b()));
                p0 p0Var = this.b.b;
                l lVar = new l(qVar.b(), qVar.d());
                m0 m0Var = (m0) p0Var.a;
                m0Var.a.b();
                m0Var.a.c();
                try {
                    m0Var.b.e(lVar);
                    m0Var.a.l();
                } finally {
                    m0Var.a.g();
                }
            }
            qVar.a().delete();
        }
        n1 n1Var = this.b;
        v0 v0Var = n1Var.c;
        m mVar = new m(n1Var.f2203g.c());
        r0 r0Var = (r0) v0Var.a;
        r0Var.a.b();
        r0Var.a.c();
        try {
            r0Var.b.e(mVar);
            r0Var.a.l();
        } finally {
            r0Var.a.g();
        }
    }

    @Override // f.b.b.f.a.p
    public void b(Throwable th) {
        a t = this.a.listIterator();
        while (t.hasNext()) {
            ((q) t.next()).a().delete();
        }
    }
}
