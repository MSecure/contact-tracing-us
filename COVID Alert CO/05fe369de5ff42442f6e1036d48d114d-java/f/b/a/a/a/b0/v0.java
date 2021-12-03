package f.b.a.a.a.b0;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.i.o;
import f.b.a.a.a.i.r;
import f.b.a.a.a.i.z;
import f.b.a.a.a.p.s;
import f.b.b.a.l;
import java.security.SecureRandom;

public class v0 {

    /* renamed from: l  reason: collision with root package name */
    public static final f.b.a.a.a.i.e0.a f2114l = f.b.a.a.a.i.e0.a.e("Preferences");
    public static e m;
    public final SharedPreferences a;
    public final f.b.a.a.a.i.f0.a b;
    public final SecureRandom c;

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<Boolean> f2115d;

    /* renamed from: e  reason: collision with root package name */
    public final LiveData<Boolean> f2116e;

    /* renamed from: f  reason: collision with root package name */
    public final LiveData<Boolean> f2117f;

    /* renamed from: g  reason: collision with root package name */
    public final LiveData<Boolean> f2118g;

    /* renamed from: h  reason: collision with root package name */
    public final LiveData<f.b.a.a.a.x.d> f2119h;

    /* renamed from: i  reason: collision with root package name */
    public final LiveData<f> f2120i;

    /* renamed from: j  reason: collision with root package name */
    public final LiveData<f> f2121j;

    /* renamed from: k  reason: collision with root package name */
    public final LiveData<Boolean> f2122k;

    public class a extends z<f.b.a.a.a.x.d> {
        public a(SharedPreferences sharedPreferences, String... strArr) {
            super(sharedPreferences, strArr);
        }

        @Override // f.b.a.a.a.i.z
        public void m() {
            l(v0.this.a());
        }
    }

    public class b extends z<f> {
        public b(SharedPreferences sharedPreferences, String... strArr) {
            super(sharedPreferences, strArr);
        }

        @Override // f.b.a.a.a.i.z
        public void m() {
            l(v0.this.e());
        }
    }

    public class c extends z<f> {
        public c(SharedPreferences sharedPreferences, String... strArr) {
            super(sharedPreferences, strArr);
        }

        @Override // f.b.a.a.a.i.z
        public void m() {
            l(v0.this.d());
        }
    }

    public class d extends z<String> {
        public d(SharedPreferences sharedPreferences, String... strArr) {
            super(sharedPreferences, strArr);
        }

        @Override // f.b.a.a.a.i.z
        public void m() {
            l(v0.this.m());
        }
    }

    public interface e {
    }

    public enum f {
        NEW(0),
        SEEN(1),
        DISMISSED(2);
        
        public final int b;

        /* access modifiers changed from: public */
        f(int i2) {
            this.b = i2;
        }
    }

    public enum g {
        UNKNOWN(0),
        CLICKED(1),
        DISMISSED(2);
        
        public final int b;

        /* access modifiers changed from: public */
        g(int i2) {
            this.b = i2;
        }
    }

    public enum h {
        UNKNOWN(0),
        ONBOARDED(1),
        SKIPPED(2);
        
        public final int b;

        /* access modifiers changed from: public */
        h(int i2) {
            this.b = i2;
        }
    }

    public enum i {
        UNKNOWN(0),
        VACCINATED(1),
        NOT_VACCINATED(2);
        
        public final int b;

        /* access modifiers changed from: public */
        i(int i2) {
            this.b = i2;
        }
    }

    public v0(Context context, f.b.a.a.a.i.f0.a aVar, SecureRandom secureRandom) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ExposureNotificationSharedPreferences.SHARED_PREFERENCES_FILE", 0);
        this.a = sharedPreferences;
        this.b = aVar;
        this.c = secureRandom;
        this.f2115d = new o(sharedPreferences, "ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", false);
        this.f2116e = new o(sharedPreferences, "ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY", false);
        new o(sharedPreferences, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", false);
        this.f2117f = new r(sharedPreferences, "ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY");
        this.f2118g = new r(sharedPreferences, "ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY");
        this.f2122k = new o(sharedPreferences, "ExposureNotificationSharedPreferences.IS_IN_APP_SMS_NOTICE_SEEN", false);
        this.f2119h = new a(sharedPreferences, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY");
        this.f2120i = new b(sharedPreferences, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY");
        this.f2121j = new c(sharedPreferences, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY");
        new d(sharedPreferences, "ExposureNotificationSharedPreferences.PROVIDE_DIAGNOSIS_KEY_TO_LOG_KEY");
    }

    public f.b.a.a.a.x.d a() {
        return new f.b.a.a.a.x.a(this.a.getInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", 0), this.a.getString("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", "No Exposure"), this.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY", 0));
    }

    public int b() {
        return this.a.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY", 0);
    }

    public l.b.a.e c() {
        return l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY", 0));
    }

    public f d() {
        SharedPreferences sharedPreferences = this.a;
        f fVar = f.NEW;
        int i2 = sharedPreferences.getInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY", 0);
        if (i2 != 1) {
            return i2 != 2 ? fVar : f.DISMISSED;
        }
        return f.SEEN;
    }

    public f e() {
        SharedPreferences sharedPreferences = this.a;
        f fVar = f.NEW;
        int i2 = sharedPreferences.getInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY", 0);
        if (i2 != 1) {
            return i2 != 2 ? fVar : f.DISMISSED;
        }
        return f.SEEN;
    }

    public boolean f() {
        return this.a.getBoolean("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", false);
    }

    public boolean g() {
        return this.a.getBoolean("ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY", false);
    }

    public h0.d h() {
        int i2 = this.a.getInt("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_REPORT_TYPE", -1);
        if (i2 < 0) {
            return null;
        }
        h0.d.values();
        if (i2 >= 4) {
            return null;
        }
        return h0.d.values()[i2];
    }

    public l.b.a.e i() {
        return l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_VERIFICATION_CODE_TIME", 0));
    }

    public l.b.a.e j() {
        return l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_SUBMITTED_KEYS_TIME", 0));
    }

    public l.b.a.e k() {
        return l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_WORKER_RUN_TIME_FOR_BIWEEKLY", 0));
    }

    public l.b.a.e l() {
        return l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_WORKER_RUN_TIME", 0));
    }

    public String m() {
        return this.a.getString("ExposureNotificationSharedPreferences.PROVIDE_DIAGNOSIS_KEY_TO_LOG_KEY", "");
    }

    public l<l.b.a.e> n() {
        return !this.a.contains("ExposureNotificationSharedPreferences.ANALYTICS_LOGGING_LAST_TIMESTAMP") ? f.b.b.a.a.b : l.c(l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.ANALYTICS_LOGGING_LAST_TIMESTAMP", 0)));
    }

    public void o() {
        this.a.edit().putLong("ExposureNotificationSharedPreferences.ANALYTICS_LOGGING_LAST_TIMESTAMP", this.b.c().G()).commit();
    }

    public void p(boolean z) {
        this.a.edit().putBoolean("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", z).commit();
        e eVar = m;
        if (eVar != null) {
            h hVar = ((f.b.a.a.a.p.c) eVar).a;
            if (z) {
                s.f2323j.f("Firelog analytics logging enabled");
                return;
            }
            s.f2323j.f("Firelog analytics logging disabled");
            hVar.a();
        }
    }

    public void q(l.b.a.e eVar, g gVar, int i2) {
        if (g() && i2 > 0) {
            this.a.edit().putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY", eVar.G()).putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY", gVar.b).putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_INTERACTION_CLASSIFICATION_KEY", i2).apply();
        }
    }

    public void r(h0.d dVar) {
        if (g()) {
            this.a.edit().putInt("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_REPORT_TYPE", dVar != null ? dVar.ordinal() : -1).apply();
        }
    }

    public void s(l.b.a.e eVar) {
        if (g()) {
            this.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_VERIFICATION_CODE_TIME", eVar.G()).apply();
        }
    }

    public void t(l.b.a.e eVar) {
        if (g()) {
            this.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_SUBMITTED_KEYS_TIME", eVar.G()).apply();
        }
    }

    public void u(boolean z) {
        f.b.a.a.a.i.e0.a aVar = f2114l;
        aVar.a("PrivateAnalyticsState changed, isEnabled= " + z);
        this.a.edit().putBoolean("ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY", z).commit();
    }
}
