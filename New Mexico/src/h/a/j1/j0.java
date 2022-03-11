package h.a.j1;

import f.b.a.c.b.o.b;
import h.a.c;
import h.a.c1;
import h.a.d0;
import h.a.j1.v;
import h.a.n0;
import h.a.o0;
/* loaded from: classes.dex */
public class j0 implements w {
    public final c1 a;
    public final v.a b;

    public j0(c1 c1Var, v.a aVar) {
        b.p(!c1Var.e(), "error must not be OK");
        this.a = c1Var;
        this.b = aVar;
    }

    @Override // h.a.c0
    public d0 c() {
        throw new UnsupportedOperationException("Not a real transport");
    }

    @Override // h.a.j1.w
    public u g(o0<?, ?> o0Var, n0 n0Var, c cVar) {
        return new i0(this.a, this.b);
    }
}
