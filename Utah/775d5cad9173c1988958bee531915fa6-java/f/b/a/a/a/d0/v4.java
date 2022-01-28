package f.b.a.a.a.d0;

import androidx.recyclerview.widget.RecyclerView;
import e.q.t;
import f.b.a.a.a.l0.h0;
import f.b.b.a.a;
import f.b.b.a.l;
import java.util.List;

public final /* synthetic */ class v4 implements t {
    public final /* synthetic */ o6 a;
    public final /* synthetic */ z4 b;

    public /* synthetic */ v4(o6 o6Var, z4 z4Var) {
        this.a = o6Var;
        this.b = z4Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        o6 o6Var = this.a;
        z4 z4Var = this.b;
        List<h0> list = (List) obj;
        int i2 = 0;
        o6Var.b0.f2402d.setVisibility(list.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = o6Var.b0.b;
        if (list.isEmpty()) {
            i2 = 8;
        }
        recyclerView.setVisibility(i2);
        z4Var.f2197e = list;
        z4Var.a.b();
        int i3 = o6Var.c0.f398g;
        l c = i3 > -1 ? l.c(Integer.valueOf(i3)) : a.b;
        if (c.b()) {
            o6Var.I0(z4Var, ((Integer) c.a()).intValue());
        }
    }
}
