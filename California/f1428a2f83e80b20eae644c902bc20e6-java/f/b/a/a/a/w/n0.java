package f.b.a.a.a.w;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import f.b.a.a.a.m.q;
import f.b.a.a.a.t.d;
import f.b.b.a.l;

public class n0 {
    public static a c;
    public final SharedPreferences a;
    public final f.b.a.a.a.h.s.a b;

    public interface a {
    }

    public enum b {
        NEW(0),
        SEEN(1),
        DISMISSED(2);
        
        public final int b;

        /* access modifiers changed from: public */
        b(int i2) {
            this.b = i2;
        }
    }

    public enum c {
        UNKNOWN(0),
        CLICKED(1),
        DISMISSED(2);
        
        public final int b;

        /* access modifiers changed from: public */
        c(int i2) {
            this.b = i2;
        }
    }

    public n0(Context context, f.b.a.a.a.h.s.a aVar) {
        this.a = context.getSharedPreferences("ExposureNotificationSharedPreferences.SHARED_PREFERENCES_FILE", 0);
        this.b = aVar;
    }

    public d a() {
        return new f.b.a.a.a.t.a(this.a.getInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_INDEX_KEY", 0), this.a.getString("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_NAME_KEY", "No Exposure"), this.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_DATE_KEY", 0));
    }

    public b b() {
        SharedPreferences sharedPreferences = this.a;
        b bVar = b.NEW;
        int i2 = sharedPreferences.getInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_DATE_NEW_KEY", 0);
        if (i2 != 1) {
            return i2 != 2 ? bVar : b.DISMISSED;
        }
        return b.SEEN;
    }

    public b c() {
        SharedPreferences sharedPreferences = this.a;
        b bVar = b.NEW;
        int i2 = sharedPreferences.getInt("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_CLASSIFICATION_NEW_KEY", 0);
        if (i2 != 1) {
            return i2 != 2 ? bVar : b.DISMISSED;
        }
        return b.SEEN;
    }

    public l<l.b.a.d> d() {
        return !this.a.contains("ExposureNotificationSharedPreferences.ANALYTICS_LOGGING_LAST_TIMESTAMP") ? f.b.b.a.a.b : l.c(l.b.a.d.x(this.a.getLong("ExposureNotificationSharedPreferences.ANALYTICS_LOGGING_LAST_TIMESTAMP", 0)));
    }

    public void e() {
        this.a.edit().putLong("ExposureNotificationSharedPreferences.ANALYTICS_LOGGING_LAST_TIMESTAMP", this.b.b().D()).commit();
    }

    public void f(boolean z) {
        this.a.edit().putBoolean("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", z).commit();
        a aVar = c;
        if (aVar != null) {
            f.b.a.a.a.m.c cVar = (f.b.a.a.a.m.c) aVar;
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

    public void g(l.b.a.d dVar, c cVar) {
        this.a.edit().putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TIME_KEY", dVar.D()).putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_ACTIVE_INTERACTION_TYPE_KEY", cVar.b).apply();
    }

    public void h(boolean z) {
        this.a.edit().putBoolean("ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY", z).commit();
    }
}
