package h.a.j1;

import f.a.a.a.a;
import h.a.c1;
import h.a.f;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class r implements Runnable {
    public final /* synthetic */ long b;
    public final /* synthetic */ f.a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ p f3834d;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public r(p pVar, long j2, f.a aVar) {
        this.f3834d = pVar;
        this.b = j2;
        this.c = aVar;
    }

    public void run() {
        p pVar = this.f3834d;
        long j2 = this.b;
        Objects.requireNonNull(pVar);
        y0 y0Var = new y0();
        pVar.f3802i.k(y0Var);
        long abs = Math.abs(j2);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long nanos = abs / timeUnit.toNanos(1);
        long abs2 = Math.abs(j2) % timeUnit.toNanos(1);
        StringBuilder h2 = a.h("deadline exceeded after ");
        if (j2 < 0) {
            h2.append('-');
        }
        h2.append(nanos);
        h2.append(String.format(".%09d", Long.valueOf(abs2)));
        h2.append("s. ");
        h2.append(y0Var);
        p.e(this.f3834d, c1.f3616i.a(h2.toString()), this.c);
    }
}
