package b.b0.y;

import androidx.work.impl.WorkDatabase;
import b.s.h;
import b.w.a.b;
import b.w.a.g.a;

public class h extends h.b {
    @Override // b.s.h.b
    public void a(b bVar) {
        ((a) bVar).f2616b.beginTransaction();
        try {
            ((a) bVar).f2616b.execSQL(WorkDatabase.c());
            ((a) bVar).f2616b.setTransactionSuccessful();
        } finally {
            ((a) bVar).f2616b.endTransaction();
        }
    }
}
