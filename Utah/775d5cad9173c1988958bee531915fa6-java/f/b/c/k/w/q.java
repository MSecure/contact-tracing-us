package f.b.c.k.w;

import f.b.c.k.w.b;
import h.a.c1;
import h.a.f;
import h.a.n0;

public class q extends f.a<RespT> {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ f[] b;
    public final /* synthetic */ t c;

    public q(t tVar, d0 d0Var, f[] fVarArr) {
        this.c = tVar;
        this.a = d0Var;
        this.b = fVarArr;
    }

    @Override // h.a.f.a
    public void a(c1 c1Var, n0 n0Var) {
        try {
            b.c cVar = (b.c) this.a;
            cVar.a.a(new f(cVar, c1Var));
        } catch (Throwable th) {
            this.c.a.c(th);
        }
    }

    @Override // h.a.f.a
    public void b(n0 n0Var) {
        try {
            b.c cVar = (b.c) this.a;
            cVar.a.a(new c(cVar, n0Var));
        } catch (Throwable th) {
            this.c.a.c(th);
        }
    }

    @Override // h.a.f.a
    public void c(RespT respt) {
        try {
            b.c cVar = (b.c) this.a;
            cVar.a.a(new d(cVar, respt));
            this.b[0].b(1);
        } catch (Throwable th) {
            this.c.a.c(th);
        }
    }

    @Override // h.a.f.a
    public void d() {
    }
}
