package f.b.a.d.a;

import f.b.a.a.a.u.t.l;
import f.b.a.c.b.o.b;
import f.b.b.a.g;
import f.b.b.b.c;
import f.b.b.f.a.j;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public final /* synthetic */ class o implements g {
    public final /* synthetic */ g0 a;
    public final /* synthetic */ h0 b;

    public /* synthetic */ o(g0 g0Var, h0 h0Var) {
        this.a = g0Var;
        this.b = h0Var;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        g0 g0Var = this.a;
        h0 h0Var = this.b;
        Objects.requireNonNull(g0Var);
        l lVar = (l) ((u) obj);
        ArrayList arrayList = new ArrayList(g0Var.b(lVar.a, h0Var));
        if (g0.a(g0Var.f2753h, Calendar.getInstance())) {
            arrayList.addAll(g0Var.b(lVar.b, h0Var));
        }
        return b.r1(new j.a(c.r(arrayList), false), f.a, g0Var.a);
    }
}
