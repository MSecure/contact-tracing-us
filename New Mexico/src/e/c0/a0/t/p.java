package e.c0.a0.t;

import androidx.work.impl.WorkDatabase;
import e.c0.a0.t.t.a;
import e.c0.j;
import e.c0.n;
/* loaded from: classes.dex */
public class p implements j {
    public final a a;
    public final e.c0.a0.r.a b;
    public final e.c0.a0.s.p c;

    static {
        n.e("WMFgUpdater");
    }

    public p(WorkDatabase workDatabase, e.c0.a0.r.a aVar, a aVar2) {
        this.b = aVar;
        this.a = aVar2;
        this.c = workDatabase.r();
    }
}
