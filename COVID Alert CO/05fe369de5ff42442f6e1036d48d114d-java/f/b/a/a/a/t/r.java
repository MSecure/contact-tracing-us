package f.b.a.a.a.t;

import android.widget.Button;
import e.p.t;

public final /* synthetic */ class r implements t {
    public final /* synthetic */ g0 a;

    public /* synthetic */ r(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        g0 g0Var = this.a;
        Boolean bool = (Boolean) obj;
        g0Var.i0.setEnabled(!bool.booleanValue());
        g0Var.f0.f2227h.setEnabled(!bool.booleanValue());
        int i2 = 0;
        g0Var.f0.f2228i.setVisibility(bool.booleanValue() ? 0 : 4);
        Button button = g0Var.i0;
        if (bool.booleanValue()) {
            i2 = 4;
        }
        button.setVisibility(i2);
    }
}
