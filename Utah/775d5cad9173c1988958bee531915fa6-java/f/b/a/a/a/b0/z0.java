package f.b.a.a.a.b0;

import android.content.SharedPreferences;
import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker;
import f.b.a.a.a.h0.a;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.s.u;
import f.b.a.c.f.b.d;
import f.b.b.a.g;
import f.b.b.a.l;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;
import java.util.Set;
import l.b.a.e;

public final /* synthetic */ class z0 implements g {
    public final /* synthetic */ StateUpdatedWorker a;

    public /* synthetic */ z0(StateUpdatedWorker stateUpdatedWorker) {
        this.a = stateUpdatedWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        StateUpdatedWorker stateUpdatedWorker = this.a;
        Set<d> set = (Set) obj;
        if (!stateUpdatedWorker.r.a.getBoolean("ExposureNotificationSharedPreferences.BLE_LOC_OFF_NOTIFICATION_SEEN", false) && ((a) stateUpdatedWorker.r.a()).a == 0 && !stateUpdatedWorker.r.f()) {
            long j2 = stateUpdatedWorker.r.a.getLong("ExposureNotificationSharedPreferences.BEGIN_TIMESTAMP_BLE_LOC_OFF", -1);
            l c = j2 != -1 ? l.c(e.z(j2)) : f.b.b.a.a.b;
            if (!set.contains(d.LOCATION_DISABLED) && !set.contains(d.BLUETOOTH_DISABLED) && !set.contains(d.BLUETOOTH_SUPPORT_UNKNOWN)) {
                c = f.b.b.a.a.b;
            } else if (!c.b()) {
                c = l.c(stateUpdatedWorker.q.c());
            }
            if (c.b()) {
                l.b.a.d c2 = l.b.a.d.c((l.b.a.x.d) c.a(), stateUpdatedWorker.q.c());
                l.b.a.d dVar = StateUpdatedWorker.u;
                int e2 = g.b.a.c.c.d.e(c2.b, dVar.b);
                if (e2 == 0) {
                    e2 = c2.c - dVar.c;
                }
                if (e2 >= 0) {
                    if (stateUpdatedWorker.g(set) != 0) {
                        stateUpdatedWorker.m.c(stateUpdatedWorker.f388g, R.string.updated_permission_disabled_notification_title, stateUpdatedWorker.g(set), u.a(stateUpdatedWorker.f388g), u.b(stateUpdatedWorker.f388g));
                    }
                    v0 v0Var = stateUpdatedWorker.r;
                    v0Var.a.edit().putBoolean("ExposureNotificationSharedPreferences.BLE_LOC_OFF_NOTIFICATION_SEEN", true).apply();
                    v0Var.a.edit().remove("ExposureNotificationSharedPreferences.BEGIN_TIMESTAMP_BLE_LOC_OFF").apply();
                }
            }
            v0 v0Var2 = stateUpdatedWorker.r;
            Objects.requireNonNull(v0Var2);
            boolean b = c.b();
            SharedPreferences.Editor edit = v0Var2.a.edit();
            (b ? edit.putLong("ExposureNotificationSharedPreferences.BEGIN_TIMESTAMP_BLE_LOC_OFF", ((e) c.a()).G()) : edit.remove("ExposureNotificationSharedPreferences.BEGIN_TIMESTAMP_BLE_LOC_OFF")).apply();
        }
        return new ListenableWorker.a.c();
    }
}
