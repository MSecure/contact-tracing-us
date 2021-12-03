package f.b.a.a.a.d0;

import f.b.a.a.a.l0.h0;
import f.b.a.a.a.s.w;
import java.util.Objects;

public final /* synthetic */ class p0 implements w.a {
    public final /* synthetic */ x5 a;

    public /* synthetic */ p0(x5 x5Var) {
        this.a = x5Var;
    }

    @Override // f.b.a.a.a.s.w.a
    public final void a(Object obj, Object obj2) {
        x5 x5Var = this.a;
        h0 h0Var = (h0) obj;
        Objects.requireNonNull(x5Var);
        boolean z = true;
        if (((Boolean) obj2).booleanValue() || a5.a(h0Var)) {
            x5Var.c0.b.setDisplayedChild(0);
        } else {
            x5Var.c0.b.setDisplayedChild(1);
        }
        if (!a5.b(h0Var) || !h0.c.NOT_ATTEMPTED.equals(h0Var.m())) {
            z = false;
        }
        x5Var.e0 = z;
    }
}
