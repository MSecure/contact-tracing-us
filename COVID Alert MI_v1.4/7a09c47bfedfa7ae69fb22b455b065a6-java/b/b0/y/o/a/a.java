package b.b0.y.o.a;

import b.b0.m;
import b.b0.y.r.p;

public class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f1119b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f1120c;

    public a(b bVar, p pVar) {
        this.f1120c = bVar;
        this.f1119b = pVar;
    }

    public void run() {
        m.c().a(b.f1121d, String.format("Scheduling work %s", this.f1119b.f1234a), new Throwable[0]);
        this.f1120c.f1122a.d(this.f1119b);
    }
}
