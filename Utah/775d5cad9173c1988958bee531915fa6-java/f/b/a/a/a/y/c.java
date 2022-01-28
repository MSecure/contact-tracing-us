package f.b.a.a.a.y;

import e.b.a.m;
import e.f.a.b;
import f.a.b.p;
import f.a.b.u;
import f.b.a.a.a.g0.d;
import f.b.a.a.a.y.f0;

public final /* synthetic */ class c implements p.a {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ b b;

    public /* synthetic */ c(c0 c0Var, b bVar) {
        this.a = c0Var;
        this.b = bVar;
    }

    @Override // f.a.b.p.a
    public final void a(u uVar) {
        c0 c0Var = this.a;
        b bVar = this.b;
        c0Var.f2495g.e(d.EnumC0074d.RPC_TYPE_VERIFICATION, uVar);
        c0.f2488h.c(String.format("Certificate error: [%s]", m.e.k0(uVar)));
        bVar.d(m.e.n0(uVar) >= 500 ? new f0.f(uVar) : new f0.e(uVar));
    }
}
