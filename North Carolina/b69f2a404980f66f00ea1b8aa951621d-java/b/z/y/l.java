package b.z.y;

import b.z.m;
import b.z.y.s.r.c;

public class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f1974b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f1975c;

    public l(n nVar, c cVar) {
        this.f1975c = nVar;
        this.f1974b = cVar;
    }

    public void run() {
        try {
            m.c().a(n.u, String.format("Starting work for %s", this.f1975c.f.f2093c), new Throwable[0]);
            this.f1975c.s = this.f1975c.g.startWork();
            this.f1974b.m(this.f1975c.s);
        } catch (Throwable th) {
            this.f1974b.l(th);
        }
    }
}
