package f.b.a.d.a;

import android.text.TextUtils;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.u.q;
import f.b.a.c.b.o.b;
import f.b.b.a.g;
import f.b.b.f.a.l;
import java.util.Objects;

public final /* synthetic */ class i implements g {
    public final /* synthetic */ g0 a;

    public /* synthetic */ i(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        a aVar;
        String str;
        g0 g0Var = this.a;
        h0 h0Var = (h0) obj;
        Objects.requireNonNull(g0Var);
        if (!h0Var.c()) {
            aVar = ((q) g0Var.f2751f).a;
            str = "Private analytics not enabled";
        } else if (!g0Var.f2750e.b()) {
            aVar = ((q) g0Var.f2751f).a;
            str = "Private analytics enabled but not turned on";
        } else if (TextUtils.isEmpty(h0Var.d()) || TextUtils.isEmpty(h0Var.g())) {
            aVar = ((q) g0Var.f2751f).a;
            str = "Private analytics enabled but missing a facilitator/PHA certificate";
        } else {
            ((q) g0Var.f2751f).a.a("Private analytics enabled, proceeding with packet submission.");
            return l.x(g0Var.f2754i.get()).y(new o(g0Var, h0Var), g0Var.a);
        }
        aVar.f(str);
        return b.O0(null);
    }
}
