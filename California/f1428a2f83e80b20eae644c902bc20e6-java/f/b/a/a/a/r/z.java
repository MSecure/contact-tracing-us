package f.b.a.a.a.r;

import android.util.Log;
import androidx.work.ListenableWorker;
import f.b.a.a.a.r.c0.b;
import f.b.a.a.a.r.c0.c;
import f.b.a.a.a.r.c0.d;
import f.b.a.a.a.r.c0.f;
import f.b.a.a.a.w.n0;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;

public class z {
    public final ExecutorService a;
    public final SecureRandom b;
    public final x c;

    /* renamed from: d  reason: collision with root package name */
    public final w f2236d;

    /* renamed from: e  reason: collision with root package name */
    public final n0 f2237e;

    /* renamed from: f  reason: collision with root package name */
    public final r f2238f;

    /* renamed from: g  reason: collision with root package name */
    public final b f2239g;

    /* renamed from: h  reason: collision with root package name */
    public final d f2240h;

    /* renamed from: i  reason: collision with root package name */
    public final c f2241i;

    public z(ExecutorService executorService, SecureRandom secureRandom, b bVar, d dVar, x xVar, w wVar, n0 n0Var, c cVar, r rVar) {
        this.a = executorService;
        this.b = secureRandom;
        this.f2239g = bVar;
        this.f2240h = dVar;
        this.c = xVar;
        this.f2236d = wVar;
        this.f2237e = n0Var;
        this.f2241i = cVar;
        this.f2238f = rVar;
    }

    public u<ListenableWorker.a> a(f fVar, double d2, a0 a0Var) {
        String c2 = fVar.c();
        l y = l.x(fVar.a()).y(new j(this, d2, a0Var), this.a).y(new g(this), this.a).y(new h(this, c2, a0Var), this.a).y(new f(fVar, c2), this.a);
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
