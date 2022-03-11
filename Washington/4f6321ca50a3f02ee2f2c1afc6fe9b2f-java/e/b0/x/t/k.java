package e.b0.x.t;

import androidx.work.impl.WorkDatabase;
import e.b0.l;
import e.b0.s;
import e.b0.x.d;
import e.b0.x.s.p;
import e.b0.x.s.q;

public class k implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1135e = l.e("StopWorkRunnable");
    public final e.b0.x.l b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1136d;

    public k(e.b0.x.l lVar, String str, boolean z) {
        this.b = lVar;
        this.c = str;
        this.f1136d = z;
    }

    public void run() {
        boolean containsKey;
        boolean z;
        e.b0.x.l lVar = this.b;
        WorkDatabase workDatabase = lVar.c;
        d dVar = lVar.f1030f;
        p r = workDatabase.r();
        workDatabase.c();
        try {
            String str = this.c;
            synchronized (dVar.f1014k) {
                containsKey = dVar.f1009f.containsKey(str);
            }
            if (this.f1136d) {
                z = this.b.f1030f.h(this.c);
            } else {
                if (!containsKey) {
                    q qVar = (q) r;
                    if (qVar.g(this.c) == s.RUNNING) {
                        qVar.p(s.ENQUEUED, this.c);
                    }
                }
                z = this.b.f1030f.i(this.c);
            }
            l.c().a(f1135e, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.c, Boolean.valueOf(z)), new Throwable[0]);
            workDatabase.l();
        } finally {
            workDatabase.g();
        }
    }
}
