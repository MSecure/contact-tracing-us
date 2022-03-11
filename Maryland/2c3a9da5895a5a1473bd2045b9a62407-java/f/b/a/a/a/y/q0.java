package f.b.a.a.a.y;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.lifecycle.LiveData;
import f.b.a.a.a.h.h;
import f.b.a.a.a.h.j;
import f.b.a.a.a.h.p;
import f.b.a.a.a.o.q;
import f.b.b.a.l;

public class q0 {

    /* renamed from: j  reason: collision with root package name */
    public static e f2356j;
    public final SharedPreferences a;
    public final f.b.a.a.a.h.s.a b;
    public final LiveData<Boolean> c;

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<Boolean> f2357d;

    /* renamed from: e  reason: collision with root package name */
    public final LiveData<Boolean> f2358e;

    /* renamed from: f  reason: collision with root package name */
    public final LiveData<Boolean> f2359f;

    /* renamed from: g  reason: collision with root package name */
    public final LiveData<f.b.a.a.a.v.d> f2360g;

    /* renamed from: h  reason: collision with root package name */
    public final LiveData<f> f2361h;

    /* renamed from: i  reason: collision with root package name */
    public final LiveData<f> f2362i;

    public class a extends p<f.b.a.a.a.v.d> {
        public a(SharedPreferences sharedPreferences, String... strArr) {
            super(sharedPreferences, strArr);
        }

        @Override // f.b.a.a.a.h.p
        public void m() {
            l(q0.this.a());
        }
    }

    public class b extends p<f> {
        public b(SharedPreferences sharedPreferences, String... strArr) {
            super(sharedPreferences, strArr);
        }

        @Override // f.b.a.a.a.h.p
        public void m() {
            l(q0.this.e());
        }
    }

    public class c extends p<f> {
        public c(SharedPreferences sharedPreferences, String... strArr) {
            super(sharedPreferences, strArr);
        }

        @Override // f.b.a.a.a.h.p
        public void m() {
            l(q0.this.d());
        }
    }

    public class d extends p<String> {
        public d(SharedPreferences sharedPreferences, String... strArr) {
            super(sharedPreferences, strArr);
        }

        @Override // f.b.a.a.a.h.p
        public void m() {
            l(q0.this.h());
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

    public q0(Context context, f.b.a.a.a.h.s.a aVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ExposureNotificationSharedPreferences.SHARED_PREFERENCES_FILE", 0);
        this.a = sharedPreferences;
        this.b = aVar;
        this.c = new h(sharedPreferences, "ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", false);
        this.f2357d = new h(sharedPreferences, "ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY", false);
        new h(sharedPreferences, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", false);
        this.f2358e = new j(sharedPreferences, "ExposureNotificationSharedPreferences.ONBOARDING_STATE_KEY");
        this.f2359f = new j(sharedPreferences, "ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY");
        this.f2360g = new a(sharedPreferences, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY");
        this.f2361h = new b(sharedPreferences, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY");
        this.f2362i = new c(sharedPreferences, "ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY");
        new d(sharedPreferences, "ExposureNotificationSharedPreferences.PROVIDE_DIAGNOSIS_KEY_TO_LOG_KEY");
    }

    public f.b.a.a.a.v.d a() {
        return new f.b.a.a.a.v.a(this.a.getInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", 0), this.a.getString("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", "No Exposure"), this.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY", 0));
    }

    public int b() {
        return this.a.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_CLASSIFICATION_KEY", 0);
    }

    public l.b.a.d c() {
        return l.b.a.d.y(this.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_SHOWN_TIME_KEY", 0));
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
        return this.a.getBoolean("ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY", false);
    }

    public l.b.a.d g() {
        return l.b.a.d.y(this.a.getLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_WORKER_RUN_TIME", 0));
    }

    public String h() {
        return this.a.getString("ExposureNotificationSharedPreferences.PROVIDE_DIAGNOSIS_KEY_TO_LOG_KEY", "");
    }

    public l<l.b.a.d> i() {
        return !this.a.contains("ExposureNotificationSharedPreferences.ANALYTICS_LOGGING_LAST_TIMESTAMP") ? f.b.b.a.a.b : l.c(l.b.a.d.y(this.a.getLong("ExposureNotificationSharedPreferences.ANALYTICS_LOGGING_LAST_TIMESTAMP", 0)));
    }

    public void j() {
        this.a.edit().putLong("ExposureNotificationSharedPreferences.ANALYTICS_LOGGING_LAST_TIMESTAMP", this.b.b().E()).commit();
    }

    public void k(boolean z) {
        this.a.edit().putBoolean("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", z).commit();
        e eVar = f2356j;
        if (eVar != null) {
            f.b.a.a.a.o.c cVar = (f.b.a.a.a.o.c) eVar;
            q qVar = cVar.a;
            g gVar = cVar.b;
            if (z) {
                Log.i(qVar.b, "Firelog analytics logging enabled");
                return;
            }
            Log.i(qVar.b, "Firelog analytics logging disabled");
            gVar.a();
        }
    }

    public void l(l.b.a.d dVar, g gVar, int i2) {
        if (f() && i2 > 0) {
            this.a.edit().putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY", dVar.E()).putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY", gVar.b).putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_INTERACTION_CLASSIFICATION_KEY", i2).apply();
        }
    }

    public void m(boolean z) {
        this.a.edit().putBoolean("ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY", z).commit();
    }

    public void n(l.b.a.d dVar) {
        if (f()) {
            this.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_WORKER_RUN_TIME", dVar.E()).apply();
        }
    }
}
