package h.a.j1;

import f.b.a.c.b.o.b;
import h.a.j1.j;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public final class h0 implements j {
    public Random a = new Random();
    public long b = TimeUnit.SECONDS.toNanos(1);
    public long c = TimeUnit.MINUTES.toNanos(2);

    /* renamed from: d  reason: collision with root package name */
    public double f3940d = 1.6d;

    /* renamed from: e  reason: collision with root package name */
    public double f3941e = 0.2d;

    /* renamed from: f  reason: collision with root package name */
    public long f3942f = this.b;

    public static final class a implements j.a {
    }

    public long a() {
        long j2 = this.f3942f;
        double d2 = (double) j2;
        this.f3942f = Math.min((long) (this.f3940d * d2), this.c);
        double d3 = this.f3941e;
        double d4 = (-d3) * d2;
        double d5 = d3 * d2;
        b.n(d5 >= d4);
        return j2 + ((long) ((this.a.nextDouble() * (d5 - d4)) + d4));
    }
}
