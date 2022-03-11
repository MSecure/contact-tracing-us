package f.b.a.a.a.z;

import e.b.a.m;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.p.f0;
import f.b.a.a.a.p.i0;
import f.b.a.a.a.y.m0;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.c;

public class m {

    /* renamed from: g  reason: collision with root package name */
    public static final c f2370g = c.m(10);

    /* renamed from: h  reason: collision with root package name */
    public static final c f2371h = c.m(10);

    /* renamed from: i  reason: collision with root package name */
    public static final c f2372i = c.e(14);
    public final f0 a;
    public final ExecutorService b;
    public final ScheduledExecutorService c;

    /* renamed from: d  reason: collision with root package name */
    public final i0 f2373d;

    /* renamed from: e  reason: collision with root package name */
    public final m0 f2374e;

    /* renamed from: f  reason: collision with root package name */
    public final a f2375f;

    public m(f0 f0Var, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, i0 i0Var, m0 m0Var, a aVar) {
        this.a = f0Var;
        this.b = executorService;
        this.c = scheduledExecutorService;
        this.f2373d = i0Var;
        this.f2374e = m0Var;
        this.f2375f = aVar;
    }

    public u<Boolean> a() {
        l z = l.x(m.h.g0(this.a.b(), f2370g, this.c)).z(new d(this), this.b);
        c cVar = new c(this);
        ExecutorService executorService = this.b;
        a.C0109a aVar = new a.C0109a(z, Exception.class, cVar);
        ((l.a) z).a(aVar, b.z1(executorService, aVar));
        return aVar;
    }
}
