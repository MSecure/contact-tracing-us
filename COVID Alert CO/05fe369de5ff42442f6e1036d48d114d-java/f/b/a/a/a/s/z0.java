package f.b.a.a.a.s;

import f.b.a.e.k.a;
import f.b.a.e.k.s;
import java.util.Objects;
import l.b.a.e;
import l.b.a.r;
import l.b.a.t;
import l.b.a.v.c;

public final /* synthetic */ class z0 implements s {
    public final /* synthetic */ a6 a;

    public /* synthetic */ z0(a6 a6Var) {
        this.a = a6Var;
    }

    @Override // f.b.a.e.k.s
    public final void a(Object obj) {
        a6 a6Var = this.a;
        c F0 = a6Var.F0();
        e z = e.z(((Long) obj).longValue());
        r rVar = r.f4321g;
        Objects.requireNonNull(z);
        String b = F0.b(t.I(z, rVar));
        a6Var.g0.m.setText(b);
        a.c cVar = a6Var.d0;
        Objects.requireNonNull(cVar);
        if (!a6Var.G0(b, new a(cVar))) {
            a6Var.I0(b);
        }
    }
}
