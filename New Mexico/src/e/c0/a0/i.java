package e.c0.a0;

import androidx.work.impl.WorkDatabase;
import e.v.g;
import e.x.a.b;
import e.x.a.f.a;
/* loaded from: classes.dex */
public class i extends g.b {
    @Override // e.v.g.b
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
