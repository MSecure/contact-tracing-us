package e.z.x.r;

import androidx.work.impl.WorkDatabase;
import e.z.x.s.o;
import e.z.x.s.q;

public class b implements Runnable {
    public final /* synthetic */ WorkDatabase b;
    public final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1977d;

    public b(c cVar, WorkDatabase workDatabase, String str) {
        this.f1977d = cVar;
        this.b = workDatabase;
        this.c = str;
    }

    public void run() {
        o i2 = ((q) this.b.r()).i(this.c);
        if (i2 != null && i2.b()) {
            synchronized (this.f1977d.f1980e) {
                this.f1977d.f1983h.put(this.c, i2);
                this.f1977d.f1984i.add(i2);
                c cVar = this.f1977d;
                cVar.f1985j.b(cVar.f1984i);
            }
        }
    }
}
