package b.b0.y.s;

import androidx.work.impl.WorkDatabase;
import b.b0.y.r.d;
import b.b0.y.r.f;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final WorkDatabase f1263a;

    public e(WorkDatabase workDatabase) {
        this.f1263a = workDatabase;
    }

    public final int a(String str) {
        this.f1263a.beginTransaction();
        try {
            Long a2 = ((f) this.f1263a.d()).a(str);
            int i = 0;
            int intValue = a2 != null ? a2.intValue() : 0;
            if (intValue != Integer.MAX_VALUE) {
                i = intValue + 1;
            }
            ((f) this.f1263a.d()).b(new d(str, (long) i));
            this.f1263a.setTransactionSuccessful();
            return intValue;
        } finally {
            this.f1263a.endTransaction();
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
            ((f) this.f1263a.d()).b(new d("next_job_scheduler_id", (long) (i + 1)));
        }
        return i;
    }
}
