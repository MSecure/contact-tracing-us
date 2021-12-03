package f.b.a.d.a;

import f.a.a.a.a;
import f.b.a.a.a.u.q;
import f.b.a.d.a.g0;
import f.b.b.a.g;

public final /* synthetic */ class j implements g {
    public final /* synthetic */ g0 a;
    public final /* synthetic */ String b;

    public /* synthetic */ j(g0 g0Var, String str) {
        this.a = g0Var;
        this.b = str;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        g0 g0Var = this.a;
        String str = this.b;
        d0 d0Var = g0Var.f2751f;
        String c = a.c("Error submitting prioDataPoint", str);
        ((q) d0Var).a.h(c, (Exception) obj);
        return g0.b.FAILURE;
    }
}
