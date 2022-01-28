package f.b.a.a.a.u;

import android.content.SharedPreferences;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import f.b.a.a.a.b0.v0;
import f.b.a.d.a.g0;
import f.b.a.d.a.r;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.Calendar;
import l.b.a.d;
import l.b.a.e;

public final /* synthetic */ class j implements i {
    public final /* synthetic */ SubmitPrivateAnalyticsWorker a;

    public /* synthetic */ j(SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker) {
        this.a = submitPrivateAnalyticsWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker = this.a;
        Boolean bool = (Boolean) obj;
        if (submitPrivateAnalyticsWorker.f429j.b()) {
            submitPrivateAnalyticsWorker.f429j.a().c();
        }
        e w = submitPrivateAnalyticsWorker.f427h.c().w(d.f(14));
        e l2 = submitPrivateAnalyticsWorker.f426g.l();
        e eVar = l2.t(w) ? l2 : w;
        v0 v0Var = submitPrivateAnalyticsWorker.f426g;
        SharedPreferences.Editor edit = v0Var.a.edit();
        boolean z = true;
        if (v0Var.c().compareTo(eVar) < 0) {
            edit.remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_EXPOSURE_TIME");
        }
        if (e.z(v0Var.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY", 0)).compareTo(eVar) < 0) {
            edit.remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_INTERACTION_CLASSIFICATION_KEY");
        }
        if (e.z(v0Var.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS_TIME_MS", 0)).compareTo(eVar) < 0) {
            edit.remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS_TIME_MS");
            edit.remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS");
        }
        edit.apply();
        if (g0.a(submitPrivateAnalyticsWorker.f430k, Calendar.getInstance())) {
            e k2 = submitPrivateAnalyticsWorker.f426g.k();
            if (l2.t(w)) {
                w = k2;
            }
            v0 v0Var2 = submitPrivateAnalyticsWorker.f426g;
            SharedPreferences.Editor edit2 = v0Var2.a.edit();
            if (v0Var2.c().compareTo(w) < 0) {
                edit2.remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY");
            }
            if (v0Var2.i().compareTo(w) < 0) {
                edit2.remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_VERIFICATION_CODE_TIME").remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_REPORT_TYPE");
            }
            if (v0Var2.j().compareTo(w) >= 0) {
                z = false;
            }
            if (z) {
                edit2.remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_SUBMITTED_KEYS_TIME");
            }
            edit2.apply();
        }
        if (!bool.booleanValue() || !r.c()) {
            SubmitPrivateAnalyticsWorker.f423l.a("API not enabled or device attestation unavailable.");
            return new s.a(new SubmitPrivateAnalyticsWorker.b(null));
        }
        SubmitPrivateAnalyticsWorker.f423l.a("Private analytics enabled and device attestation available.");
        g0 g0Var = submitPrivateAnalyticsWorker.f424e;
        return l.x(g0Var.c.a()).y(new f.b.a.d.a.i(g0Var), g0Var.a);
    }
}
