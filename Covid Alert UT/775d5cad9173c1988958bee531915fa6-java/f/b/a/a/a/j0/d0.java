package f.b.a.a.a.j0;

import android.view.View;
import e.n.a.r;
import f.b.a.a.a.w.y0;
import f.b.a.c.b.o.b;
import java.util.Objects;

public final /* synthetic */ class d0 implements View.OnClickListener {
    public final /* synthetic */ b1 b;

    public /* synthetic */ d0(b1 b1Var) {
        this.b = b1Var;
    }

    public final void onClick(View view) {
        b1 b1Var = this.b;
        Objects.requireNonNull(b1Var);
        k0 k0Var = new k0();
        r s0 = b1Var.s0();
        b.n(s0 instanceof y0);
        ((y0) s0).B(k0Var);
    }
}
