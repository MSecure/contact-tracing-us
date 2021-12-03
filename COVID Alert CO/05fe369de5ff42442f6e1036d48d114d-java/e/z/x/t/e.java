package e.z.x.t;

import androidx.work.impl.WorkDatabase;
import e.z.x.s.d;
import e.z.x.s.f;

public class e {
    public final WorkDatabase a;

    public e(WorkDatabase workDatabase) {
        this.a = workDatabase;
    }

    public final int a(String str) {
        this.a.c();
        try {
            Long a2 = ((f) this.a.n()).a(str);
            int i2 = 0;
            int intValue = a2 != null ? a2.intValue() : 0;
            if (intValue != Integer.MAX_VALUE) {
                i2 = intValue + 1;
            }
            ((f) this.a.n()).b(new d(str, (long) i2));
            this.a.l();
            return intValue;
        } finally {
            this.a.g();
        }
    }

    public int b(int i2, int i3) {
        synchronized (e.class) {
            int a2 = a("next_job_scheduler_id");
            if (a2 >= i2) {
                if (a2 <= i3) {
                    i2 = a2;
                }
            }
            ((f) this.a.n()).b(new d("next_job_scheduler_id", (long) (i2 + 1)));
        }
        return i2;
    }
}
