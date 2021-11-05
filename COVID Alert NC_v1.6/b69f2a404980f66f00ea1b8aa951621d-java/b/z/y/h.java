package b.z.y;

import androidx.work.impl.WorkDatabase;
import b.r.h;
import b.u.a.b;
import b.u.a.g.a;

public class h extends h.b {
    @Override // b.r.h.b
    public void a(b bVar) {
        ((a) bVar).f1742b.beginTransaction();
        try {
            ((a) bVar).f1742b.execSQL(WorkDatabase.c());
            ((a) bVar).f1742b.setTransactionSuccessful();
        } finally {
            ((a) bVar).f1742b.endTransaction();
        }
    }
}
