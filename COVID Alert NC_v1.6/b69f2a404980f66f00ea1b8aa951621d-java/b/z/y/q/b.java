package b.z.y.q;

import androidx.work.impl.WorkDatabase;
import b.z.y.r.p;
import b.z.y.r.r;

public class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f2056b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2057c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f2058d;

    public b(c cVar, WorkDatabase workDatabase, String str) {
        this.f2058d = cVar;
        this.f2056b = workDatabase;
        this.f2057c = str;
    }

    public void run() {
        p i = ((r) this.f2056b.h()).i(this.f2057c);
        if (i != null && i.b()) {
            synchronized (this.f2058d.f2062e) {
                this.f2058d.h.put(this.f2057c, i);
                this.f2058d.i.add(i);
                this.f2058d.j.b(this.f2058d.i);
            }
        }
    }
}
