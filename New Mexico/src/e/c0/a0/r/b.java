package e.c0.a0.r;

import androidx.work.impl.WorkDatabase;
import e.c0.a0.s.o;
import e.c0.a0.s.q;
/* loaded from: classes.dex */
public class b implements Runnable {
    public final /* synthetic */ WorkDatabase b;
    public final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1180d;

    public b(c cVar, WorkDatabase workDatabase, String str) {
        this.f1180d = cVar;
        this.b = workDatabase;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        o i2 = ((q) this.b.r()).i(this.c);
        if (i2 != null && i2.b()) {
            synchronized (this.f1180d.f1183e) {
                this.f1180d.f1186h.put(this.c, i2);
                this.f1180d.f1187i.add(i2);
                c cVar = this.f1180d;
                cVar.f1188j.b(cVar.f1187i);
            }
        }
    }
}
