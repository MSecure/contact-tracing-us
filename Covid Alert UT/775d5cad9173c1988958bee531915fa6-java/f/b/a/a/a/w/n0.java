package f.b.a.a.a.w;

import android.widget.Button;
import e.q.t;
import java.util.List;

public final /* synthetic */ class n0 implements t {
    public final /* synthetic */ f1 a;

    public /* synthetic */ n0(f1 f1Var) {
        this.a = f1Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        f1 f1Var = this.a;
        List list = (List) obj;
        int i2 = 8;
        f1Var.b0.r.c.setVisibility(list.isEmpty() ? 8 : 0);
        Button button = f1Var.b0.n.f2381d;
        if (!list.isEmpty()) {
            i2 = 0;
        }
        button.setVisibility(i2);
    }
}
