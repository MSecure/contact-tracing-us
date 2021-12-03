package e.b0.a0.t;

import androidx.work.impl.WorkDatabase;
import e.b0.a0.d;
import e.b0.a0.s.p;
import e.b0.a0.s.q;
import e.b0.n;
import e.b0.v;

public class l implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1134e = n.e("StopWorkRunnable");
    public final e.b0.a0.l b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1135d;

    public l(e.b0.a0.l lVar, String str, boolean z) {
        this.b = lVar;
        this.c = str;
        this.f1135d = z;
    }

    public void run() {
        boolean containsKey;
        boolean z;
        e.b0.a0.l lVar = this.b;
        WorkDatabase workDatabase = lVar.c;
        d dVar = lVar.f1029f;
        p r = workDatabase.r();
        workDatabase.c();
        try {
            String str = this.c;
            synchronized (dVar.f1011l) {
                containsKey = dVar.f1006g.containsKey(str);
            }
            if (this.f1135d) {
                z = this.b.f1029f.i(this.c);
            } else {
                if (!containsKey) {
                    q qVar = (q) r;
                    if (qVar.g(this.c) == v.RUNNING) {
                        qVar.p(v.ENQUEUED, this.c);
                    }
                }
                z = this.b.f1029f.j(this.c);
            }
            n.c().a(f1134e, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.c, Boolean.valueOf(z)), new Throwable[0]);
            workDatabase.l();
        } finally {
            workDatabase.g();
        }
    }
}
