package e.c0.x.t;

import androidx.work.impl.WorkDatabase;
import e.c0.l;
import e.c0.s;
import e.c0.x.d;
import e.c0.x.s.p;
import e.c0.x.s.q;

public class k implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1155e = l.e("StopWorkRunnable");
    public final e.c0.x.l b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1156d;

    public k(e.c0.x.l lVar, String str, boolean z) {
        this.b = lVar;
        this.c = str;
        this.f1156d = z;
    }

    public void run() {
        boolean containsKey;
        boolean z;
        e.c0.x.l lVar = this.b;
        WorkDatabase workDatabase = lVar.c;
        d dVar = lVar.f1050f;
        p r = workDatabase.r();
        workDatabase.c();
        try {
            String str = this.c;
            synchronized (dVar.f1034k) {
                containsKey = dVar.f1029f.containsKey(str);
            }
            if (this.f1156d) {
                z = this.b.f1050f.h(this.c);
            } else {
                if (!containsKey) {
                    q qVar = (q) r;
                    if (qVar.g(this.c) == s.RUNNING) {
                        qVar.p(s.ENQUEUED, this.c);
                    }
                }
                z = this.b.f1050f.i(this.c);
            }
            l.c().a(f1155e, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.c, Boolean.valueOf(z)), new Throwable[0]);
            workDatabase.l();
        } finally {
            workDatabase.g();
        }
    }
}
