package f.b.a.a.a.r;

import android.content.SharedPreferences;
import android.util.Log;
import f.a.a.a.a;
import f.b.a.a.a.w.k0;
import f.b.a.c.b.o.b;
import f.b.b.a.g;
import f.b.b.b.c;
import f.b.b.f.a.j;
import f.b.b.f.a.l;
import java.util.ArrayList;
import java.util.Objects;
import l.b.a.d;

public final /* synthetic */ class k implements g {
    public final /* synthetic */ b0 a;

    public /* synthetic */ k(b0 b0Var) {
        this.a = b0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x007f  */
    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        k0.g gVar;
        String str;
        String str2;
        k0.g gVar2;
        b0 b0Var = this.a;
        c0 c0Var = (c0) obj;
        Objects.requireNonNull(b0Var);
        boolean c = c0Var.c();
        double j2 = c0Var.j();
        double i2 = c0Var.i();
        double n = c0Var.n();
        double m = c0Var.m();
        double g2 = c0Var.g();
        double f2 = c0Var.f();
        k0 k0Var = b0Var.f2199e;
        d x = d.x(k0Var.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY", 0));
        Objects.requireNonNull(x, "Null exposureNotificationLastShownTime");
        Integer valueOf = Integer.valueOf(k0Var.a.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY", 0));
        d x2 = d.x(k0Var.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY", 0));
        Objects.requireNonNull(x2, "Null exposureNotificationLastInteractionTime");
        SharedPreferences sharedPreferences = k0Var.a;
        k0.g gVar3 = k0.g.UNKNOWN;
        int i3 = sharedPreferences.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY", 0);
        if (i3 == 1) {
            gVar2 = k0.g.CLICKED;
        } else if (i3 != 2) {
            gVar = gVar3;
            str = valueOf != null ? " exposureNotificationLastShownClassification" : "";
            if (!str.isEmpty()) {
                p pVar = new p(x, valueOf.intValue(), x2, gVar, null);
                if (!c) {
                    str2 = "Private analytics not enabled";
                } else if (!b0Var.f2199e.f()) {
                    str2 = "Private analytics enabled but not turned on";
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (b0Var.b(j2)) {
                        arrayList.add(b0Var.a(b0Var.f2202h, pVar, i2, c0Var));
                    }
                    if (b0Var.b(n)) {
                        arrayList.add(b0Var.a(b0Var.f2201g, pVar, m, c0Var));
                    }
                    if (b0Var.b(g2)) {
                        arrayList.add(b0Var.a(b0Var.f2203i, pVar, f2, c0Var));
                    }
                    return l.x(new j.a(c.r(arrayList), false)).y(a.a, b0Var.a);
                }
                Log.i("PrioSubmitter", str2);
                return b.c1(null);
            }
            throw new IllegalStateException(a.t("Missing required properties:", str));
        } else {
            gVar2 = k0.g.DISMISSED;
        }
        gVar = gVar2;
        if (valueOf != null) {
        }
        if (!str.isEmpty()) {
        }
    }
}
