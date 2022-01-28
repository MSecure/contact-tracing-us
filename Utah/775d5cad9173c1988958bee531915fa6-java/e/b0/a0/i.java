package e.b0.a0;

import androidx.work.impl.WorkDatabase;
import e.u.g;
import e.w.a.b;
import e.w.a.f.a;

public class i extends g.b {
    @Override // e.u.g.b
    public void a(b bVar) {
        ((a) bVar).b.beginTransaction();
        try {
            int i2 = WorkDatabase.f306l;
            ((a) bVar).b.execSQL("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + (System.currentTimeMillis() - WorkDatabase.f305k) + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
            ((a) bVar).b.setTransactionSuccessful();
        } finally {
            ((a) bVar).b.endTransaction();
        }
    }
}
