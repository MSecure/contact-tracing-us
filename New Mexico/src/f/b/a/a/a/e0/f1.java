package f.b.a.a.a.e0;

import f.b.a.e.l.a;
import f.b.a.e.l.s;
import java.util.Objects;
import l.b.a.e;
import l.b.a.r;
import l.b.a.t;
import l.b.a.v.c;
/* loaded from: classes.dex */
public final /* synthetic */ class f1 implements s {
    public final /* synthetic */ n6 a;

    public /* synthetic */ f1(n6 n6Var) {
        this.a = n6Var;
    }

    @Override // f.b.a.e.l.s
    public final void a(Object obj) {
        n6 n6Var = this.a;
        c O0 = n6Var.O0();
        e z = e.z(((Long) obj).longValue());
        r rVar = r.f4641g;
        Objects.requireNonNull(z);
        String b = O0.b(t.I(z, rVar));
        n6Var.k0.m.setText(b);
        a.c cVar = n6Var.g0;
        Objects.requireNonNull(cVar);
        if (!n6Var.P0(b, new a(cVar))) {
            n6Var.R0(b);
        }
    }
}
