package e.c0.a0.t;

import androidx.work.impl.WorkDatabase;
import e.c0.a0.l;
import e.c0.a0.s.d;
import e.c0.a0.s.f;
import e.c0.a0.s.q;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends d {
    public final /* synthetic */ l c;

    public c(l lVar) {
        this.c = lVar;
    }

    @Override // e.c0.a0.t.d
    public void b() {
        WorkDatabase workDatabase = this.c.c;
        workDatabase.c();
        try {
            Iterator it = ((ArrayList) ((q) workDatabase.r()).c()).iterator();
            while (it.hasNext()) {
                a(this.c, (String) it.next());
            }
            WorkDatabase workDatabase2 = this.c.c;
            ((f) workDatabase2.n()).b(new d("last_cancel_all_time_ms", System.currentTimeMillis()));
            workDatabase.l();
        } finally {
            workDatabase.g();
        }
    }
}
