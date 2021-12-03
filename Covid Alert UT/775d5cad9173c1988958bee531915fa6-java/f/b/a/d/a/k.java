package f.b.a.d.a;

import f.b.a.a.a.f0.q;
import f.b.a.d.a.g0;
import f.b.b.a.g;
import f.b.b.f.a.u;

public final /* synthetic */ class k implements g {
    public final /* synthetic */ g0 a;
    public final /* synthetic */ String b;

    public /* synthetic */ k(g0 g0Var, String str) {
        this.a = g0Var;
        this.b = str;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        g0 g0Var = this.a;
        String str = this.b;
        u uVar = (u) obj;
        d0 d0Var = g0Var.f2805f;
        ((q) d0Var).a.a(String.format("Workflow for prioDataPoint %s finished successfully.", str));
        return g0.c.SUCCESS;
    }
}
