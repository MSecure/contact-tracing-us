package f.b.a.a.a.t;

import androidx.work.ListenableWorker;
import f.b.a.a.a.t.d0.b;
import f.b.a.a.a.t.d0.c;
import f.b.a.a.a.t.d0.d;
import f.b.a.a.a.t.d0.e;
import f.b.a.a.a.t.d0.f;
import f.b.a.a.a.t.d0.g;
import f.b.a.a.a.y.q0;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;

public class a0 {
    public final ExecutorService a;
    public final SecureRandom b;
    public final y c;

    /* renamed from: d  reason: collision with root package name */
    public final x f2272d;

    /* renamed from: e  reason: collision with root package name */
    public final q0 f2273e;

    /* renamed from: f  reason: collision with root package name */
    public final s f2274f;

    /* renamed from: g  reason: collision with root package name */
    public final c f2275g;

    /* renamed from: h  reason: collision with root package name */
    public final f f2276h;

    /* renamed from: i  reason: collision with root package name */
    public final e f2277i;

    /* renamed from: j  reason: collision with root package name */
    public final b f2278j;

    /* renamed from: k  reason: collision with root package name */
    public final d f2279k;

    public a0(ExecutorService executorService, SecureRandom secureRandom, c cVar, f fVar, e eVar, b bVar, d dVar, y yVar, x xVar, q0 q0Var, s sVar) {
        this.a = executorService;
        this.b = secureRandom;
        this.f2275g = cVar;
        this.f2276h = fVar;
        this.f2277i = eVar;
        this.f2278j = bVar;
        this.f2279k = dVar;
        this.c = yVar;
        this.f2272d = xVar;
        this.f2273e = q0Var;
        this.f2274f = sVar;
    }

    public u<ListenableWorker.a> a(g gVar, double d2, b0 b0Var) {
        String b2 = gVar.b();
        l y = l.x(gVar.a()).y(new k(this, d2, b0Var), this.a).y(new g(this), this.a).y(new i(this, b2, b0Var), this.a).y(new h(b2), this.a);
        j jVar = new j(b2);
        ExecutorService executorService = this.a;
        a.b bVar = new a.b(y, Exception.class, jVar);
        ((l.a) y).a(bVar, f.b.a.c.b.o.b.z1(executorService, bVar));
        return bVar;
    }

    public final boolean b(g gVar, double d2) {
        if (this.b.nextDouble() <= d2) {
            return true;
        }
        gVar.b();
        return false;
    }
}
