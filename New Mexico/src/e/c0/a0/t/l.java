package e.c0.a0.t;

import androidx.work.impl.WorkDatabase;
import e.c0.a0.d;
import e.c0.a0.s.p;
import e.c0.a0.s.q;
import e.c0.n;
import e.c0.v;
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1213e = n.e("StopWorkRunnable");
    public final e.c0.a0.l b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1214d;

    public l(e.c0.a0.l lVar, String str, boolean z) {
        this.b = lVar;
        this.c = str;
        this.f1214d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean containsKey;
        boolean z;
        e.c0.a0.l lVar = this.b;
        WorkDatabase workDatabase = lVar.c;
        d dVar = lVar.f1108f;
        p r = workDatabase.r();
        workDatabase.c();
        try {
            String str = this.c;
            synchronized (dVar.f1090l) {
                containsKey = dVar.f1085g.containsKey(str);
            }
            if (this.f1214d) {
                z = this.b.f1108f.i(this.c);
            } else {
                if (!containsKey) {
                    q qVar = (q) r;
                    if (qVar.g(this.c) == v.RUNNING) {
                        qVar.p(v.ENQUEUED, this.c);
                    }
                }
                z = this.b.f1108f.j(this.c);
            }
            n.c().a(f1213e, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.c, Boolean.valueOf(z)), new Throwable[0]);
            workDatabase.l();
        } finally {
            workDatabase.g();
        }
    }
}
