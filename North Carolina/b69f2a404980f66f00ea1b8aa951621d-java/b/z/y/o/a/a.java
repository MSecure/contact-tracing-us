package b.z.y.o.a;

import b.z.m;
import b.z.y.r.p;

public class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f1988b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f1989c;

    public a(b bVar, p pVar) {
        this.f1989c = bVar;
        this.f1988b = pVar;
    }

    public void run() {
        m.c().a(b.f1990d, String.format("Scheduling work %s", this.f1988b.f2091a), new Throwable[0]);
        this.f1989c.f1991a.d(this.f1988b);
    }
}
