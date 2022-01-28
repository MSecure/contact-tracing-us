package b.b0.y.q;

import androidx.work.impl.WorkDatabase;
import b.b0.y.r.p;
import b.b0.y.r.r;

public class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f1197b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f1198c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1199d;

    public b(c cVar, WorkDatabase workDatabase, String str) {
        this.f1199d = cVar;
        this.f1197b = workDatabase;
        this.f1198c = str;
    }

    public void run() {
        p i = ((r) this.f1197b.h()).i(this.f1198c);
        if (i != null && i.b()) {
            synchronized (this.f1199d.f1203e) {
                this.f1199d.h.put(this.f1198c, i);
                this.f1199d.i.add(i);
                this.f1199d.j.b(this.f1199d.i);
            }
        }
    }
}
