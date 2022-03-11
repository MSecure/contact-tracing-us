package f.b.a.a.a.t;

import f.b.a.a.a.u.c;
import f.b.a.a.a.u.d;
import java.util.Objects;

public final /* synthetic */ class g implements f.b.b.a.g {
    public final /* synthetic */ a0 a;

    public /* synthetic */ g(a0 a0Var) {
        this.a = a0Var;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        a0 a0Var = this.a;
        c cVar = (c) obj;
        Objects.requireNonNull(a0Var);
        Objects.requireNonNull(cVar, "Null createPacketsParameters");
        d a2 = a0Var.f2274f.a(cVar);
        Objects.requireNonNull(a2, "Null createPacketsResponse");
        return new q(cVar, a2, null);
    }
}
