package f.b.a.a.a.u.t;

import android.content.SharedPreferences;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.x.a;
import f.b.a.a.a.x.d;
import f.b.a.c.b.o.b;
import f.b.a.d.a.e0;
import f.b.b.f.a.u;
import java.util.List;
import l.b.a.e;

public class j implements e0 {
    public final v0 a;

    public j(v0 v0Var) {
        this.a = v0Var;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        v0.i iVar = v0.i.VACCINATED;
        int[] iArr = new int[15];
        SharedPreferences sharedPreferences = this.a.a;
        v0.i iVar2 = v0.i.UNKNOWN;
        int i2 = sharedPreferences.getInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS", 0);
        if (i2 == 1) {
            iVar2 = iVar;
        } else if (i2 == 2) {
            iVar2 = v0.i.NOT_VACCINATED;
        }
        e z = e.z(this.a.a.getLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS_TIME_MS", 0));
        e l2 = this.a.l();
        d a2 = this.a.a();
        boolean z2 = iVar2 == iVar;
        boolean z3 = ((a) a2).a != 0;
        if (z.t(l2)) {
            iArr[0] = 1;
            if (z2) {
                iArr[1] = 1;
                if (z3) {
                    iArr[7] = 1;
                    iArr[6] = 1;
                    iArr[12] = 1;
                    iArr[13] = 1;
                } else {
                    iArr[3] = 1;
                    iArr[4] = 1;
                }
            } else {
                iArr[2] = 1;
                if (z3) {
                    iArr[6] = 1;
                    iArr[8] = 1;
                    iArr[12] = 1;
                    iArr[14] = 1;
                } else {
                    iArr[3] = 1;
                    iArr[5] = 1;
                }
            }
        }
        return b.O0(b.h(iArr));
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "KeysUploadedVaccineStatus-v1";
    }
}
