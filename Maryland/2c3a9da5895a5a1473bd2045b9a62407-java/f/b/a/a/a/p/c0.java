package f.b.a.a.a.p;

import f.b.a.a.a.m.q;
import f.b.a.a.a.y.f0;
import f.b.a.a.a.y.h0;
import f.b.a.a.a.y.j0;
import f.b.a.a.a.y.k;
import f.b.a.a.a.y.l;
import f.b.a.a.a.y.m0;
import f.b.b.b.a;
import f.b.b.b.c;
import f.b.b.f.a.p;

public class c0 implements p<Void> {
    public final /* synthetic */ c a;
    public final /* synthetic */ d0 b;

    public c0(d0 d0Var, c cVar) {
        this.b = d0Var;
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
                String.format("Mark last successful download [%s] for server [%s]", qVar.d(), qVar.b());
                h0 h0Var = this.b.b;
                k kVar = new k(qVar.b(), qVar.d());
                f0 f0Var = (f0) h0Var.a;
                f0Var.a.b();
                f0Var.a.c();
                try {
                    f0Var.b.e(kVar);
                    f0Var.a.l();
                } finally {
                    f0Var.a.g();
                }
            }
            qVar.a().delete();
        }
        d0 d0Var = this.b;
        m0 m0Var = d0Var.c;
        l lVar = new l(d0Var.f2224g.b());
        j0 j0Var = (j0) m0Var.a;
        j0Var.a.b();
        j0Var.a.c();
        try {
            j0Var.b.e(lVar);
            j0Var.a.l();
        } finally {
            j0Var.a.g();
        }
    }
}
