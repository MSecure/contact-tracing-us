package b.b0.y;

import b.b0.m;
import b.b0.y.s.r.c;

public class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f1101b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f1102c;

    public l(n nVar, c cVar) {
        this.f1102c = nVar;
        this.f1101b = cVar;
    }

    public void run() {
        try {
            m.c().a(n.u, String.format("Starting work for %s", this.f1102c.f1110f.f1236c), new Throwable[0]);
            this.f1102c.s = this.f1102c.f1111g.startWork();
            this.f1101b.m(this.f1102c.s);
        } catch (Throwable th) {
            this.f1101b.l(th);
        }
    }
}
