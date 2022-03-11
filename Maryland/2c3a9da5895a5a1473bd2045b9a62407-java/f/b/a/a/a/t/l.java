package f.b.a.a.a.t;

import android.util.Log;
import f.b.a.c.b.o.b;
import f.b.b.a.g;
import f.b.b.b.c;
import f.b.b.f.a.j;
import java.util.ArrayList;
import java.util.Objects;

public final /* synthetic */ class l implements g {
    public final /* synthetic */ a0 a;

    public /* synthetic */ l(a0 a0Var) {
        this.a = a0Var;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        String str;
        a0 a0Var = this.a;
        b0 b0Var = (b0) obj;
        Objects.requireNonNull(a0Var);
        boolean e2 = b0Var.e();
        double n = b0Var.n();
        double m = b0Var.m();
        double r = b0Var.r();
        double q = b0Var.q();
        double i2 = b0Var.i();
        double h2 = b0Var.h();
        double b = b0Var.b();
        double a2 = b0Var.a();
        double k2 = b0Var.k();
        double j2 = b0Var.j();
        if (!e2) {
            str = "Private analytics not enabled";
        } else if (!a0Var.f2273e.f()) {
            str = "Private analytics enabled but not turned on";
        } else {
            ArrayList arrayList = new ArrayList();
            if (a0Var.b(a0Var.f2276h, n)) {
                arrayList.add(a0Var.a(a0Var.f2276h, m, b0Var));
            }
            if (a0Var.b(a0Var.f2275g, r)) {
                arrayList.add(a0Var.a(a0Var.f2275g, q, b0Var));
            }
            if (a0Var.b(a0Var.f2277i, i2)) {
                arrayList.add(a0Var.a(a0Var.f2277i, h2, b0Var));
            }
            if (a0Var.b(a0Var.f2278j, b)) {
                arrayList.add(a0Var.a(a0Var.f2278j, a2, b0Var));
            }
            if (a0Var.b(a0Var.f2279k, k2)) {
                arrayList.add(a0Var.a(a0Var.f2279k, j2, b0Var));
            }
            return f.b.b.f.a.l.x(new j.a(c.r(arrayList), false)).y(a.a, a0Var.a);
        }
        Log.i("PrioSubmitter", str);
        return b.d1(null);
    }
}
