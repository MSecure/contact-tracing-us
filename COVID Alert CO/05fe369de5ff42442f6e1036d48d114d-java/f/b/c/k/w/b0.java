package f.b.c.k.w;

import android.content.Context;
import e.b.a.m;
import f.b.a.c.i.c0;
import f.b.a.c.i.e0;
import f.b.a.c.i.h;
import f.b.c.k.s.e;
import f.b.c.k.x.c;
import f.b.c.k.x.j;
import f.b.c.k.x.m;
import h.a.b;
import h.a.k0;
import h.a.n;
import java.util.concurrent.Executor;

public class b0 {
    public h<k0> a;
    public final c b;
    public h.a.c c;

    /* renamed from: d  reason: collision with root package name */
    public c.b f3328d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f3329e;

    /* renamed from: f  reason: collision with root package name */
    public final e f3330f;

    /* renamed from: g  reason: collision with root package name */
    public final b f3331g;

    public b0(c cVar, Context context, e eVar, b bVar) {
        this.b = cVar;
        this.f3329e = context;
        this.f3330f = eVar;
        this.f3331g = bVar;
        b();
    }

    public final void a() {
        if (this.f3328d != null) {
            m.a(m.a.DEBUG, "GrpcCallProvider", "Clearing the connectivityAttemptTimer", new Object[0]);
            this.f3328d.a();
            this.f3328d = null;
        }
    }

    public final void b() {
        Executor executor = j.c;
        y yVar = new y(this);
        m.h.p(executor, "Executor must not be null");
        m.h.p(yVar, "Callback must not be null");
        c0 c0Var = new c0();
        executor.execute(new e0(c0Var, yVar));
        this.a = c0Var;
    }

    public final void c(k0 k0Var) {
        n j2 = k0Var.j(true);
        m.a aVar = m.a.DEBUG;
        f.b.c.k.x.m.a(aVar, "GrpcCallProvider", "Current gRPC connectivity state: " + j2, new Object[0]);
        a();
        if (j2 == n.CONNECTING) {
            f.b.c.k.x.m.a(aVar, "GrpcCallProvider", "Setting the connectivityAttemptTimer", new Object[0]);
            this.f3328d = this.b.a(c.d.CONNECTIVITY_ATTEMPT_TIMER, 15000, new v(this, k0Var));
        }
        k0Var.k(j2, new w(this, k0Var));
    }
}
