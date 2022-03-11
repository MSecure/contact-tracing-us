package f.b.a.a.a.r;

import f.b.a.a.a.s.c;
import f.b.a.a.a.s.d;
import java.util.Objects;

public final /* synthetic */ class g implements f.b.b.a.g {
    public final /* synthetic */ b0 a;

    public /* synthetic */ g(b0 b0Var) {
        this.a = b0Var;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        b0 b0Var = this.a;
        c cVar = (c) obj;
        Objects.requireNonNull(b0Var);
        Objects.requireNonNull(cVar, "Null createPacketsParameters");
        d a2 = b0Var.f2200f.a(cVar);
        Objects.requireNonNull(a2, "Null createPacketsResponse");
        return new q(cVar, a2, null);
    }
}
