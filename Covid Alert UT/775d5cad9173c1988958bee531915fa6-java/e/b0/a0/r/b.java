package e.b0.a0.r;

import androidx.work.impl.WorkDatabase;
import e.b0.a0.s.o;
import e.b0.a0.s.q;

public class b implements Runnable {
    public final /* synthetic */ WorkDatabase b;
    public final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1101d;

    public b(c cVar, WorkDatabase workDatabase, String str) {
        this.f1101d = cVar;
        this.b = workDatabase;
        this.c = str;
    }

    public void run() {
        o i2 = ((q) this.b.r()).i(this.c);
        if (i2 != null && i2.b()) {
            synchronized (this.f1101d.f1104e) {
                this.f1101d.f1107h.put(this.c, i2);
                this.f1101d.f1108i.add(i2);
                c cVar = this.f1101d;
                cVar.f1109j.b(cVar.f1108i);
            }
        }
    }
}
