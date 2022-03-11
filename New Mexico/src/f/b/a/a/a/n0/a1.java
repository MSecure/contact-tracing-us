package f.b.a.a.a.n0;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import f.b.a.a.a.a0.s;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.t.c0;
import f.b.a.a.a.t.k0;
import f.b.a.a.a.t.z;
import f.b.b.a.l;
import java.security.SecureRandom;
/* loaded from: classes.dex */
public class a1 {

    /* renamed from: l */
    public static final f.b.a.a.a.t.p0.a f2312l = f.b.a.a.a.t.p0.a.e("Preferences");
    public static e m;
    public final SharedPreferences a;
    public final f.b.a.a.a.t.q0.a b;
    public final SecureRandom c;

    /* renamed from: d */
    public final LiveData<Boolean> f2313d;

    /* renamed from: e */
    public final LiveData<Boolean> f2314e;

    /* renamed from: f */
    public final LiveData<Boolean> f2315f;

    /* renamed from: g */
    public final LiveData<Boolean> f2316g;

    /* renamed from: h */
    public final LiveData<f.b.a.a.a.j0.d> f2317h;

    /* renamed from: i */
    public final LiveData<f> f2318i;

    /* renamed from: j */
    public final LiveData<f> f2319j;

    /* renamed from: k */
    public final LiveData<Boolean> f2320k;

    /* loaded from: classes.dex */
    public class a extends k0<f.b.a.a.a.j0.d> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SharedPreferences sharedPreferences, String... strArr) {
            super(sharedPreferences, strArr);
            a1.this = r1;
        }

        @Override // f.b.a.a.a.t.k0
        public void m() {
            l(a1.this.b());
        }
    }

    /* loaded from: classes.dex */
    public class b extends k0<f> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SharedPreferences sharedPreferences, String... strArr) {
            super(sharedPreferences, strArr);
            a1.this = r1;
        }

        @Override // f.b.a.a.a.t.k0
        public void m() {
            l(a1.this.f());
        }
    }

    /* loaded from: classes.dex */
    public class c extends k0<f> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SharedPreferences sharedPreferences, String... strArr) {
            super(sharedPreferences, strArr);
            a1.this = r1;
        }

        @Override // f.b.a.a.a.t.k0
        public void m() {
            l(a1.this.e());
        }
    }

    /* loaded from: classes.dex */
    public class d extends k0<String> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SharedPreferences sharedPreferences, String... strArr) {
            super(sharedPreferences, strArr);
            a1.this = r1;
        }

        @Override // f.b.a.a.a.t.k0
        public void m() {
            l(a1.this.q());
        }
    }

    /* loaded from: classes.dex */
    public interface e {
    }

    /* loaded from: classes.dex */
    public enum f {
        NEW(0),
        SEEN(1),
        DISMISSED(2);
        
        public final int b;

        f(int i2) {
            this.b = i2;
        }
    }

    /* loaded from: classes.dex */
    public enum g {
        UNKNOWN(0),
        CLICKED(1),
        DISMISSED(2);
        
        public final int b;

        g(int i2) {
            this.b = i2;
        }
    }

    /* loaded from: classes.dex */
    public enum h {
        UNKNOWN(0),
        ONBOARDED(1),
        SKIPPED(2);
        
        public final int b;

        h(int i2) {
            this.b = i2;
        }
    }

    /* loaded from: classes.dex */
    public enum i {
        UNKNOWN(0),
        VACCINATED(1),
        NOT_VACCINATED(2);
        
        public final int b;

        i(int i2) {
            this.b = i2;
        }
    }

    public a1(Context context, f.b.a.a.a.t.q0.a aVar, SecureRandom secureRandom) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ExposureNotificationSharedPreferences.SHARED_PREFERENCES_FILE", 0);
        this.a = sharedPreferences;
        this.b = aVar;
        this.c = secureRandom;
        this.f2313d = new z(sharedPreferences, "ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", false);
        this.f2314e = new z(sharedPreferences, "ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY", false);
        new z(sharedPreferences, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", false);
        this.f2315f = new c0(sharedPreferences, "ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY");
        this.f2316g = new c0(sharedPreferences, "ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY");
        this.f2320k = new z(sharedPreferences, "ExposureNotificationSharedPreferences.IS_IN_APP_SMS_NOTICE_SEEN", false);
        this.f2317h = new a(sharedPreferences, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY");
        this.f2318i = new b(sharedPreferences, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY");
        this.f2319j = new c(sharedPreferences, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY");
        new d(sharedPreferences, "ExposureNotificationSharedPreferences.PROVIDE_DIAGNOSIS_KEY_TO_LOG_KEY");
    }

    public void a() {
        this.a.edit().remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_INTERACTION_CLASSIFICATION_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY").remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_EXPOSURE_TIME").remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_REPORT_TYPE").remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_VERIFICATION_CODE_TIME").remove("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_SUBMITTED_KEYS_TIME").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS").remove("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS_TIME_MS").apply();
    }

    public f.b.a.a.a.j0.d b() {
        return new f.b.a.a.a.j0.a(this.a.getInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", 0), this.a.getString("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", "No Exposure"), this.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY", 0));
    }

    public int c() {
        return this.a.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY", 0);
    }

    public l.b.a.e d() {
        return l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY", 0));
    }

    public f e() {
        SharedPreferences sharedPreferences = this.a;
        f fVar = f.NEW;
        int i2 = sharedPreferences.getInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY", 0);
        if (i2 != 1) {
            return i2 != 2 ? fVar : f.DISMISSED;
        }
        return f.SEEN;
    }

    public f f() {
        SharedPreferences sharedPreferences = this.a;
        f fVar = f.NEW;
        int i2 = sharedPreferences.getInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY", 0);
        if (i2 != 1) {
            return i2 != 2 ? fVar : f.DISMISSED;
        }
        return f.SEEN;
    }

    public boolean g() {
        return this.a.getBoolean("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", false);
    }

    public i h() {
        SharedPreferences sharedPreferences = this.a;
        i iVar = i.UNKNOWN;
        int i2 = sharedPreferences.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS", 0);
        if (i2 != 1) {
            return i2 != 2 ? iVar : i.NOT_VACCINATED;
        }
        return i.VACCINATED;
    }

    public l.b.a.e i() {
        return l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS_TIME_MS", 0));
    }

    public boolean j() {
        return this.a.getBoolean("ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY", false);
    }

    public l.b.a.e k() {
        return (l.b.a.e) l.b.a.d.f(this.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_EXPOSURE_TIME", 0)).b(l.b.a.e.f4611d);
    }

    public j0.d l() {
        int i2 = this.a.getInt("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_REPORT_TYPE", -1);
        if (i2 < 0) {
            return null;
        }
        j0.d.values();
        if (i2 >= 4) {
            return null;
        }
        return j0.d.values()[i2];
    }

    public l.b.a.e m() {
        return l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_VERIFICATION_CODE_TIME", 0));
    }

    public l.b.a.e n() {
        return l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_SUBMITTED_KEYS_TIME", 0));
    }

    public l.b.a.e o() {
        return l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_WORKER_RUN_TIME_FOR_BIWEEKLY", 0));
    }

    public l.b.a.e p() {
        return l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_WORKER_RUN_TIME", 0));
    }

    public String q() {
        return this.a.getString("ExposureNotificationSharedPreferences.PROVIDE_DIAGNOSIS_KEY_TO_LOG_KEY", "");
    }

    public l<l.b.a.e> r() {
        return !this.a.contains("ExposureNotificationSharedPreferences.ANALYTICS_LOGGING_LAST_TIMESTAMP") ? f.b.b.a.a.b : l.c(l.b.a.e.z(this.a.getLong("ExposureNotificationSharedPreferences.ANALYTICS_LOGGING_LAST_TIMESTAMP", 0)));
    }

    public void s() {
        this.a.edit().putLong("ExposureNotificationSharedPreferences.ANALYTICS_LOGGING_LAST_TIMESTAMP", this.b.c().G()).commit();
    }

    public void t(boolean z) {
        this.a.edit().putBoolean("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", z).commit();
        e eVar = m;
        if (eVar != null) {
            h hVar = ((f.b.a.a.a.a0.c) eVar).a;
            if (z) {
                s.f2188j.f("Firelog analytics logging enabled");
                return;
            }
            s.f2188j.f("Firelog analytics logging disabled");
            hVar.a();
        }
    }

    public void u(l.b.a.e eVar, g gVar, int i2) {
        if (j() && i2 > 0) {
            this.a.edit().putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY", eVar.G()).putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY", gVar.b).putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_INTERACTION_CLASSIFICATION_KEY", i2).apply();
        }
    }

    public void v(j0.d dVar) {
        if (j()) {
            this.a.edit().putInt("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_REPORT_TYPE", dVar != null ? dVar.ordinal() : -1).apply();
        }
    }

    public void w(l.b.a.e eVar) {
        if (j()) {
            this.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_VERIFICATION_CODE_TIME", eVar.G()).apply();
        }
    }

    public void x(l.b.a.e eVar) {
        if (j()) {
            this.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_SUBMITTED_KEYS_TIME", eVar.G()).apply();
        }
    }

    public void y(boolean z) {
        f.b.a.a.a.t.p0.a aVar = f2312l;
        aVar.a("PrivateAnalyticsState changed, isEnabled= " + z);
        this.a.edit().putBoolean("ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY", z).commit();
    }
}
