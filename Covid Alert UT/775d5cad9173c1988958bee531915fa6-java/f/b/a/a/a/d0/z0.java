package f.b.a.a.a.d0;

import f.b.a.e.l.a;
import f.b.a.e.l.s;
import java.util.Objects;
import l.b.a.e;
import l.b.a.r;
import l.b.a.t;
import l.b.a.v.c;

public final /* synthetic */ class z0 implements s {
    public final /* synthetic */ z5 a;

    public /* synthetic */ z0(z5 z5Var) {
        this.a = z5Var;
    }

    @Override // f.b.a.e.l.s
    public final void a(Object obj) {
        z5 z5Var = this.a;
        c L0 = z5Var.L0();
        e z = e.z(((Long) obj).longValue());
        r rVar = r.f4386g;
        Objects.requireNonNull(z);
        String b = L0.b(t.I(z, rVar));
        z5Var.h0.m.setText(b);
        a.c cVar = z5Var.e0;
        Objects.requireNonNull(cVar);
        if (!z5Var.M0(b, new a(cVar))) {
            z5Var.O0(b);
        }
    }
}
