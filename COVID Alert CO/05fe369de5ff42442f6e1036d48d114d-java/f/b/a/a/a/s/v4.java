package f.b.a.a.a.s;

import androidx.recyclerview.widget.RecyclerView;
import e.p.t;
import f.b.a.a.a.b0.h0;
import f.b.b.a.a;
import f.b.b.a.l;
import java.util.List;

public final /* synthetic */ class v4 implements t {
    public final /* synthetic */ q6 a;
    public final /* synthetic */ z4 b;

    public /* synthetic */ v4(q6 q6Var, z4 z4Var) {
        this.a = q6Var;
        this.b = z4Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        q6 q6Var = this.a;
        z4 z4Var = this.b;
        List<h0> list = (List) obj;
        int i2 = 0;
        q6Var.a0.f2207d.setVisibility(list.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = q6Var.a0.b;
        if (list.isEmpty()) {
            i2 = 8;
        }
        recyclerView.setVisibility(i2);
        z4Var.f2401e = list;
        z4Var.a.b();
        int i3 = q6Var.b0.f402g;
        l c = i3 > -1 ? l.c(Integer.valueOf(i3)) : a.b;
        if (c.b()) {
            q6Var.C0(z4Var, ((Integer) c.a()).intValue());
        }
    }
}
