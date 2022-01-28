package b.z.y.s;

import androidx.work.impl.WorkDatabase;
import b.z.y.r.d;
import b.z.y.r.f;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final WorkDatabase f2116a;

    public e(WorkDatabase workDatabase) {
        this.f2116a = workDatabase;
    }

    public final int a(String str) {
        this.f2116a.beginTransaction();
        try {
            Long a2 = ((f) this.f2116a.d()).a(str);
            int i = 0;
            int intValue = a2 != null ? a2.intValue() : 0;
            if (intValue != Integer.MAX_VALUE) {
                i = intValue + 1;
            }
            ((f) this.f2116a.d()).b(new d(str, (long) i));
            this.f2116a.setTransactionSuccessful();
            return intValue;
        } finally {
            this.f2116a.endTransaction();
        }
    }

    public int b(int i, int i2) {
        synchronized (e.class) {
            int a2 = a("next_job_scheduler_id");
            if (a2 >= i) {
                if (a2 <= i2) {
                    i = a2;
                }
            }
            ((f) this.f2116a.d()).b(new d("next_job_scheduler_id", (long) (i + 1)));
        }
        return i;
    }
}
