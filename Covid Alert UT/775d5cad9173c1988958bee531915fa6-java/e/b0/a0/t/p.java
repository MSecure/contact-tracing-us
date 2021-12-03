package e.b0.a0.t;

import androidx.work.impl.WorkDatabase;
import e.b0.a0.t.t.a;
import e.b0.j;
import e.b0.n;

public class p implements j {
    public final a a;
    public final e.b0.a0.r.a b;
    public final e.b0.a0.s.p c;

    static {
        n.e("WMFgUpdater");
    }

    public p(WorkDatabase workDatabase, e.b0.a0.r.a aVar, a aVar2) {
        this.b = aVar;
        this.a = aVar2;
        this.c = workDatabase.r();
    }
}
