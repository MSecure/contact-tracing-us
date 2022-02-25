package f.b.a.a.a.r;

import android.util.Log;
import androidx.work.ListenableWorker;
import f.b.a.a.a.r.e0.b;
import f.b.a.a.a.r.e0.c;
import f.b.a.a.a.r.e0.d;
import f.b.a.a.a.r.e0.f;
import f.b.a.a.a.w.k0;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;

public class b0 {
    public final ExecutorService a;
    public final SecureRandom b;
    public final z c;

    /* renamed from: d  reason: collision with root package name */
    public final y f2198d;

    /* renamed from: e  reason: collision with root package name */
    public final k0 f2199e;

    /* renamed from: f  reason: collision with root package name */
    public final t f2200f;

    /* renamed from: g  reason: collision with root package name */
    public final b f2201g;

    /* renamed from: h  reason: collision with root package name */
    public final d f2202h;

    /* renamed from: i  reason: collision with root package name */
    public final c f2203i;

    public b0(ExecutorService executorService, SecureRandom secureRandom, b bVar, d dVar, z zVar, y yVar, k0 k0Var, c cVar, t tVar) {
        this.a = executorService;
        this.b = secureRandom;
        this.f2201g = bVar;
        this.f2202h = dVar;
        this.c = zVar;
        this.f2198d = yVar;
        this.f2199e = k0Var;
        this.f2203i = cVar;
        this.f2200f = tVar;
    }

    public u<ListenableWorker.a> a(f fVar, s sVar, double d2, c0 c0Var) {
        String c2 = fVar.c();
        l y = l.x(fVar.b(sVar)).y(new j(this, d2, c0Var), this.a).y(new g(this), this.a).y(new h(this, c2, c0Var), this.a).y(new f(fVar, c2), this.a);
        i iVar = new i(c2);
        ExecutorService executorService = this.a;
        a.b bVar = new a.b(y, Exception.class, iVar);
        ((l.a) y).a(bVar, f.b.a.c.b.o.b.A1(executorService, bVar));
        return bVar;
    }

    public final boolean b(double d2) {
        if (this.b.nextDouble() <= d2) {
            return true;
        }
        Log.i("PrioSubmitter", "Skipping sample. samplingRate=" + d2);
        return false;
    }
}
