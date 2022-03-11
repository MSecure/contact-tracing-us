package e.b0.x.r;

import androidx.work.impl.WorkDatabase;
import e.b0.x.s.o;
import e.b0.x.s.q;

public class b implements Runnable {
    public final /* synthetic */ WorkDatabase b;
    public final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1102d;

    public b(c cVar, WorkDatabase workDatabase, String str) {
        this.f1102d = cVar;
        this.b = workDatabase;
        this.c = str;
    }

    public void run() {
        o i2 = ((q) this.b.r()).i(this.c);
        if (i2 != null && i2.b()) {
            synchronized (this.f1102d.f1105e) {
                this.f1102d.f1108h.put(this.c, i2);
                this.f1102d.f1109i.add(i2);
                c cVar = this.f1102d;
                cVar.f1110j.b(cVar.f1109i);
            }
        }
    }
}
