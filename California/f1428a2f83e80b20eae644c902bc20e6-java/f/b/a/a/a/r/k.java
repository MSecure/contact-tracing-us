package f.b.a.a.a.r;

import android.util.Log;
import f.b.a.c.b.o.b;
import f.b.b.a.g;
import f.b.b.b.c;
import f.b.b.f.a.j;
import f.b.b.f.a.l;
import java.util.ArrayList;
import java.util.Objects;

public final /* synthetic */ class k implements g {
    public final /* synthetic */ z a;

    public /* synthetic */ k(z zVar) {
        this.a = zVar;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        String str;
        z zVar = this.a;
        a0 a0Var = (a0) obj;
        Objects.requireNonNull(zVar);
        boolean c = a0Var.c();
        a0Var.b();
        a0Var.a();
        double j2 = a0Var.j();
        double i2 = a0Var.i();
        double n = a0Var.n();
        double m = a0Var.m();
        double g2 = a0Var.g();
        double f2 = a0Var.f();
        if (!c) {
            str = "Private analytics not enabled";
        } else if (!zVar.f2237e.a.getBoolean("ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY", false)) {
            str = "Private analytics enabled but not turned on";
        } else {
            ArrayList arrayList = new ArrayList();
            if (zVar.b(j2)) {
                arrayList.add(zVar.a(zVar.f2240h, i2, a0Var));
            }
            if (zVar.b(n)) {
                arrayList.add(zVar.a(zVar.f2239g, m, a0Var));
            }
            if (zVar.b(g2)) {
                arrayList.add(zVar.a(zVar.f2241i, f2, a0Var));
            }
            return l.x(new j.a(c.r(arrayList), false)).y(a.a, zVar.a);
        }
        Log.i("PrioSubmitter", str);
        return b.c1(null);
    }
}
