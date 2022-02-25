package f.b.a.a.a.x;

import e.b.a.m;
import f.b.a.a.a.n.f0;
import f.b.a.a.a.n.i0;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.c;

public class l {

    /* renamed from: e  reason: collision with root package name */
    public static final c f2285e = c.l(10);

    /* renamed from: f  reason: collision with root package name */
    public static final c f2286f = c.l(10);
    public final f0 a;
    public final ExecutorService b;
    public final ScheduledExecutorService c;

    /* renamed from: d  reason: collision with root package name */
    public final i0 f2287d;

    public l(f0 f0Var, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, i0 i0Var) {
        this.a = f0Var;
        this.b = executorService;
        this.c = scheduledExecutorService;
        this.f2287d = i0Var;
    }

    public u<Boolean> a() {
        return f.b.b.f.a.l.x(m.h.g0(this.a.b(), f2285e, this.c)).z(new c(this), this.b);
    }
}
