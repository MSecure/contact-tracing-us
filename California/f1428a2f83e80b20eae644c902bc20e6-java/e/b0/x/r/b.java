package e.b0.x.r;

import androidx.work.impl.WorkDatabase;
import e.b0.x.s.o;
import e.b0.x.s.q;

public class b implements Runnable {
    public final /* synthetic */ WorkDatabase b;
    public final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1103d;

    public b(c cVar, WorkDatabase workDatabase, String str) {
        this.f1103d = cVar;
        this.b = workDatabase;
        this.c = str;
    }

    public void run() {
        o i2 = ((q) this.b.r()).i(this.c);
        if (i2 != null && i2.b()) {
            synchronized (this.f1103d.f1106e) {
                this.f1103d.f1109h.put(this.c, i2);
                this.f1103d.f1110i.add(i2);
                c cVar = this.f1103d;
                cVar.f1111j.b(cVar.f1110i);
            }
        }
    }
}
