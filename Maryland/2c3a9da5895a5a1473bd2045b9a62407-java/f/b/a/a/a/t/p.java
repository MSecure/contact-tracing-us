package f.b.a.a.a.t;

import android.content.SharedPreferences;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.b.a.m;
import f.b.a.a.a.u.u;
import f.b.a.a.a.y.q0;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import f.b.b.f.a.w;
import java.util.Objects;
import l.b.a.c;
import l.b.a.d;

public final /* synthetic */ class p implements i {
    public final /* synthetic */ SubmitPrivateAnalyticsWorker a;

    public /* synthetic */ p(SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker) {
        this.a = submitPrivateAnalyticsWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker = this.a;
        submitPrivateAnalyticsWorker.f405g.i(u.d.TASK_SUBMIT_PRIVATE_ANALYTICS);
        if (!((Boolean) obj).booleanValue() || !v.b()) {
            return new s.a(new SubmitPrivateAnalyticsWorker.b(null));
        }
        q0 q0Var = submitPrivateAnalyticsWorker.f407i;
        d w = submitPrivateAnalyticsWorker.f408j.b().w(c.e(14));
        SharedPreferences.Editor edit = q0Var.a.edit();
        boolean z = false;
        if (q0Var.c().compareTo(w) < 0) {
            edit.remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY");
        }
        if (d.y(q0Var.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY", 0)).compareTo(w) < 0) {
            edit.remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_INTERACTION_CLASSIFICATION_KEY");
        }
        if (d.y(q0Var.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_VERIFICATION_CODE_TIME", 0)).compareTo(w) < 0) {
            edit.remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_VERIFICATION_CODE_TIME");
        }
        if (d.y(q0Var.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_SUBMITTED_KEYS_TIME", 0)).compareTo(w) < 0) {
            z = true;
        }
        if (z) {
            edit.remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_SUBMITTED_KEYS_TIME");
        }
        edit.apply();
        a0 a0Var = submitPrivateAnalyticsWorker.f403e;
        y yVar = a0Var.c;
        Objects.requireNonNull(yVar);
        l y = l.x(m.h.f0(new d(yVar))).y(new b(yVar), yVar.f2318d);
        e eVar = e.a;
        w wVar = yVar.f2318d;
        a.b bVar = new a.b(y, Exception.class, eVar);
        ((l.a) y).a(bVar, b.z1(wVar, bVar));
        return l.x(bVar).y(new l(a0Var), a0Var.a);
    }
}
