package f.b.a.a.a.s;

import f.b.a.a.a.b0.h0;
import f.b.a.a.a.i.x;
import java.util.Objects;

public final /* synthetic */ class p0 implements x.a {
    public final /* synthetic */ y5 a;

    public /* synthetic */ p0(y5 y5Var) {
        this.a = y5Var;
    }

    @Override // f.b.a.a.a.i.x.a
    public final void a(Object obj, Object obj2) {
        y5 y5Var = this.a;
        h0 h0Var = (h0) obj;
        Objects.requireNonNull(y5Var);
        boolean z = true;
        if (((Boolean) obj2).booleanValue() || a5.a(h0Var)) {
            y5Var.b0.b.setDisplayedChild(0);
        } else {
            y5Var.b0.b.setDisplayedChild(1);
        }
        if (!a5.b(h0Var) || !h0.c.NOT_ATTEMPTED.equals(h0Var.m())) {
            z = false;
        }
        y5Var.d0 = z;
    }
}
