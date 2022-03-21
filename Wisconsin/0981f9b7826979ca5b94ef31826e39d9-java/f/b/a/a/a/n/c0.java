package f.b.a.a.a.n;

import f.b.a.a.a.k.q;
import f.b.a.a.a.w.e0;
import f.b.a.a.a.w.g0;
import f.b.a.a.a.w.k;
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
                g0 g0Var = this.b.b;
                k kVar = new k(qVar.b(), qVar.d());
                e0 e0Var = (e0) g0Var.a;
                e0Var.a.b();
                e0Var.a.c();
                try {
                    e0Var.b.e(kVar);
                    e0Var.a.l();
                } finally {
                    e0Var.a.g();
                }
            }
            qVar.a().delete();
        }
    }
}
