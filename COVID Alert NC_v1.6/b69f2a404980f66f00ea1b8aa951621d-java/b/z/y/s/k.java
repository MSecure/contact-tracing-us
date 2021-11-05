package b.z.y.s;

import androidx.work.impl.WorkDatabase;
import b.z.m;
import b.z.u;
import b.z.y.d;
import b.z.y.r.q;
import b.z.y.r.r;

public class k implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final String f2129e = m.e("StopWorkRunnable");

    /* renamed from: b  reason: collision with root package name */
    public final b.z.y.k f2130b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2131c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2132d;

    public k(b.z.y.k kVar, String str, boolean z) {
        this.f2130b = kVar;
        this.f2131c = str;
        this.f2132d = z;
    }

    public void run() {
        boolean containsKey;
        boolean z;
        b.z.y.k kVar = this.f2130b;
        WorkDatabase workDatabase = kVar.f1971c;
        d dVar = kVar.f;
        q h = workDatabase.h();
        workDatabase.beginTransaction();
        try {
            String str = this.f2131c;
            synchronized (dVar.l) {
                containsKey = dVar.g.containsKey(str);
            }
            if (this.f2132d) {
                z = this.f2130b.f.i(this.f2131c);
            } else {
                if (!containsKey) {
                    r rVar = (r) h;
                    if (rVar.g(this.f2131c) == u.RUNNING) {
                        rVar.p(u.ENQUEUED, this.f2131c);
                    }
                }
                z = this.f2130b.f.j(this.f2131c);
            }
            m.c().a(f2129e, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.f2131c, Boolean.valueOf(z)), new Throwable[0]);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
        }
    }
}
