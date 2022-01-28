package f.b.a.d.a;

import android.text.TextUtils;
import f.b.a.a.a.f0.q;
import f.b.a.d.a.g0;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.Objects;

public final /* synthetic */ class o implements i {
    public final /* synthetic */ g0 a;

    public /* synthetic */ o(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        g0 g0Var = this.a;
        h0 h0Var = (h0) obj;
        Objects.requireNonNull(g0Var);
        if (!h0Var.c()) {
            ((q) g0Var.f2805f).a.f("Private analytics not enabled");
            return new s.a(new g0.a());
        } else if (!g0Var.f2804e.b()) {
            ((q) g0Var.f2805f).a.f("Private analytics enabled but not turned on");
            return new s.a(new g0.a());
        } else if (TextUtils.isEmpty(h0Var.d()) || TextUtils.isEmpty(h0Var.g())) {
            ((q) g0Var.f2805f).a.f("Private analytics enabled but missing a facilitator/PHA certificate");
            return new s.a(new g0.a());
        } else {
            ((q) g0Var.f2805f).a.a("Private analytics enabled, proceeding with packet submission.");
            return l.x(g0Var.f2808i.get()).z(new i(g0Var, h0Var), g0Var.a);
        }
    }
}
