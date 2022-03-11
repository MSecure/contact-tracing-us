package e.c0.x.r;

import androidx.work.impl.WorkDatabase;
import e.c0.x.s.o;
import e.c0.x.s.q;

public class b implements Runnable {
    public final /* synthetic */ WorkDatabase b;
    public final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1122d;

    public b(c cVar, WorkDatabase workDatabase, String str) {
        this.f1122d = cVar;
        this.b = workDatabase;
        this.c = str;
    }

    public void run() {
        o i2 = ((q) this.b.r()).i(this.c);
        if (i2 != null && i2.b()) {
            synchronized (this.f1122d.f1125e) {
                this.f1122d.f1128h.put(this.c, i2);
                this.f1122d.f1129i.add(i2);
                c cVar = this.f1122d;
                cVar.f1130j.b(cVar.f1129i);
            }
        }
    }
}
