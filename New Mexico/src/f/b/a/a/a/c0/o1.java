package f.b.a.a.a.c0;

import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.t.q0.a;
import l.b.a.d;
import l.b.a.f;
import l.b.a.g;
import l.b.a.h;
import l.b.a.r;
/* loaded from: classes.dex */
public class o1 {

    /* renamed from: d */
    public static final d f2204d = d.f(14);
    public final a1 a;
    public final DailySummariesConfig b;
    public final a c;

    public o1(a1 a1Var, DailySummariesConfig dailySummariesConfig, a aVar) {
        this.a = a1Var;
        this.b = dailySummariesConfig;
        this.c = aVar;
    }

    public void a() {
        this.a.a.edit().remove("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY").commit();
    }

    public final d b(f.b.a.a.a.j0.d dVar) {
        d c = d.c(g.F(f.R(dVar.a()), h.f4620h).w(r.f4641g), this.c.c());
        return (c.b > 0 ? 1 : (c.b == 0 ? 0 : -1)) < 0 ? d.f(1) : c;
    }

    public final d c() {
        d f2 = d.f((long) this.b.f478f);
        return f2.s() == 0 ? f2204d : f2;
    }

    public final boolean d(f.b.a.a.a.j0.d dVar) {
        return b(dVar).s() <= c().s();
    }

    public boolean e() {
        f.b.a.a.a.j0.d b = this.a.b();
        return d(b) && f(b);
    }

    public final boolean f(f.b.a.a.a.j0.d dVar) {
        return ((f.b.a.a.a.j0.a) dVar).a != 0 || this.a.g();
    }
}
