package f.b.a.a.a.e0;

import android.widget.Button;
import e.q.t;

public final /* synthetic */ class r implements t {
    public final /* synthetic */ i0 a;

    public /* synthetic */ r(i0 i0Var) {
        this.a = i0Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        i0 i0Var = this.a;
        Boolean bool = (Boolean) obj;
        i0Var.j0.setEnabled(!bool.booleanValue());
        i0Var.g0.f2422h.setEnabled(!bool.booleanValue());
        int i2 = 0;
        i0Var.g0.f2423i.setVisibility(bool.booleanValue() ? 0 : 4);
        Button button = i0Var.j0;
        if (bool.booleanValue()) {
            i2 = 4;
        }
        button.setVisibility(i2);
    }
}
