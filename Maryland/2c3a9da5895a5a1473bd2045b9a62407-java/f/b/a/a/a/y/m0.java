package f.b.a.a.a.y;

import com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase;
import e.t.l;
import e.v.a.f.f;
import l.b.a.d;

public class m0 {
    public final i0 a;

    public m0(ExposureNotificationDatabase exposureNotificationDatabase) {
        this.a = exposureNotificationDatabase.q();
    }

    public void a(d dVar) {
        long j2;
        j0 j0Var = (j0) this.a;
        j0Var.a.b();
        f a2 = j0Var.c.a();
        if (dVar == null) {
            j2 = 0;
        } else {
            j2 = dVar.E();
        }
        a2.b.bindLong(1, j2);
        j0Var.a.c();
        try {
            a2.d();
            j0Var.a.l();
        } finally {
            j0Var.a.g();
            l lVar = j0Var.c;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        }
    }
}
