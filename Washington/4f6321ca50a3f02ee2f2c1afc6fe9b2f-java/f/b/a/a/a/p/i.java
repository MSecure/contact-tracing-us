package f.b.a.a.a.p;

import android.view.View;
import e.p.r;
import f.b.a.a.a.w.b0;
import java.util.List;

public final /* synthetic */ class i implements r {
    public final /* synthetic */ View a;
    public final /* synthetic */ u2 b;

    public /* synthetic */ i(View view, u2 u2Var) {
        this.a = view;
        this.b = u2Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        View view = this.a;
        u2 u2Var = this.b;
        List<b0> list = (List) obj;
        int i2 = f3.b0;
        view.setVisibility(list.isEmpty() ? 8 : 0);
        u2Var.c = list;
        u2Var.a.b();
    }
}
