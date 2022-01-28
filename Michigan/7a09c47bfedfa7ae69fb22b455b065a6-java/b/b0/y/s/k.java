package b.b0.y.s;

import androidx.work.impl.WorkDatabase;
import b.b0.m;
import b.b0.u;
import b.b0.y.d;
import b.b0.y.r.q;
import b.b0.y.r.r;

public class k implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1276e = m.e("StopWorkRunnable");

    /* renamed from: b  reason: collision with root package name */
    public final b.b0.y.k f1277b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1278c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1279d;

    public k(b.b0.y.k kVar, String str, boolean z) {
        this.f1277b = kVar;
        this.f1278c = str;
        this.f1279d = z;
    }

    public void run() {
        boolean containsKey;
        boolean z;
        b.b0.y.k kVar = this.f1277b;
        WorkDatabase workDatabase = kVar.f1096c;
        d dVar = kVar.f1099f;
        q h = workDatabase.h();
        workDatabase.beginTransaction();
        try {
            String str = this.f1278c;
            synchronized (dVar.l) {
                containsKey = dVar.f1072g.containsKey(str);
            }
            if (this.f1279d) {
                z = this.f1277b.f1099f.i(this.f1278c);
            } else {
                if (!containsKey) {
                    r rVar = (r) h;
                    if (rVar.g(this.f1278c) == u.RUNNING) {
                        rVar.p(u.ENQUEUED, this.f1278c);
                    }
                }
                z = this.f1277b.f1099f.j(this.f1278c);
            }
            m.c().a(f1276e, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.f1278c, Boolean.valueOf(z)), new Throwable[0]);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
        }
    }
}
