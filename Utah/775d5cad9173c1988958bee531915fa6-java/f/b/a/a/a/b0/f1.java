package f.b.a.a.a.b0;

import f.b.a.a.a.l0.k0;
import f.b.a.a.a.l0.l;
import f.b.a.a.a.l0.m;
import f.b.a.a.a.l0.m0;
import f.b.a.a.a.l0.o0;
import f.b.a.a.a.l0.r0;
import f.b.a.a.a.x.q;
import f.b.b.b.a;
import f.b.b.b.c;
import f.b.b.f.a.p;

public class f1 implements p<Void> {
    public final /* synthetic */ c a;
    public final /* synthetic */ g1 b;

    public f1(g1 g1Var, c cVar) {
        this.b = g1Var;
        this.a = cVar;
    }

    @Override // f.b.b.f.a.p
    public void a(Throwable th) {
        a t = this.a.listIterator();
        while (t.hasNext()) {
            ((q) t.next()).a().delete();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.b.f.a.p
    public void b(Void r6) {
        a t = this.a.listIterator();
        while (t.hasNext()) {
            q qVar = (q) t.next();
            if (qVar.c()) {
                g1.f2161h.a(String.format("Mark last successful download [%s] for server [%s]", qVar.d(), qVar.b()));
                m0 m0Var = this.b.b;
                l lVar = new l(qVar.b(), qVar.d());
                k0 k0Var = (k0) m0Var.a;
                k0Var.a.b();
                k0Var.a.c();
                try {
                    k0Var.b.e(lVar);
                    k0Var.a.l();
                } finally {
                    k0Var.a.g();
                }
            }
            qVar.a().delete();
        }
        g1 g1Var = this.b;
        r0 r0Var = g1Var.c;
        m mVar = new m(g1Var.f2168g.c());
        o0 o0Var = (o0) r0Var.a;
        o0Var.a.b();
        o0Var.a.c();
        try {
            o0Var.b.e(mVar);
            o0Var.a.l();
        } finally {
            o0Var.a.g();
        }
    }
}
