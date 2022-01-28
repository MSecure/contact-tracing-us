package e.z.x.t;

import androidx.work.impl.WorkDatabase;
import e.z.l;
import e.z.s;
import e.z.x.d;
import e.z.x.s.p;
import e.z.x.s.q;

public class k implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final String f2010e = l.e("StopWorkRunnable");
    public final e.z.x.l b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2011d;

    public k(e.z.x.l lVar, String str, boolean z) {
        this.b = lVar;
        this.c = str;
        this.f2011d = z;
    }

    public void run() {
        boolean containsKey;
        boolean z;
        e.z.x.l lVar = this.b;
        WorkDatabase workDatabase = lVar.c;
        d dVar = lVar.f1905f;
        p r = workDatabase.r();
        workDatabase.c();
        try {
            String str = this.c;
            synchronized (dVar.f1889k) {
                containsKey = dVar.f1884f.containsKey(str);
            }
            if (this.f2011d) {
                z = this.b.f1905f.h(this.c);
            } else {
                if (!containsKey) {
                    q qVar = (q) r;
                    if (qVar.g(this.c) == s.RUNNING) {
                        qVar.p(s.ENQUEUED, this.c);
                    }
                }
                z = this.b.f1905f.i(this.c);
            }
            l.c().a(f2010e, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.c, Boolean.valueOf(z)), new Throwable[0]);
            workDatabase.l();
        } finally {
            workDatabase.g();
        }
    }
}
