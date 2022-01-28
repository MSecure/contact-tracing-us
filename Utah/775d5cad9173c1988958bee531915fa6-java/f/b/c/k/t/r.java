package f.b.c.k.t;

import android.util.SparseArray;
import f.b.a.c.b.o.b;
import f.b.c.k.r.f;
import f.b.c.k.s.c0;
import f.b.c.k.s.d0;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class r {

    /* renamed from: j  reason: collision with root package name */
    public static final long f3351j = TimeUnit.MINUTES.toSeconds(5);

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ int f3352k = 0;
    public final f0 a;
    public e0 b;
    public final k0 c;

    /* renamed from: d  reason: collision with root package name */
    public g f3353d;

    /* renamed from: e  reason: collision with root package name */
    public g0 f3354e;

    /* renamed from: f  reason: collision with root package name */
    public final j0 f3355f;

    /* renamed from: g  reason: collision with root package name */
    public final c1 f3356g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<d1> f3357h = new SparseArray<>();

    /* renamed from: i  reason: collision with root package name */
    public final Map<c0, Integer> f3358i = new HashMap();

    public r(f0 f0Var, g0 g0Var, f fVar) {
        b.O0(f0Var.f(), "LocalStore was passed an unstarted persistence implementation", new Object[0]);
        this.a = f0Var;
        c1 e2 = f0Var.e();
        this.f3356g = e2;
        new d0(0, e2.f()).a += 2;
        this.b = f0Var.b(fVar);
        k0 d2 = f0Var.d();
        this.c = d2;
        g gVar = new g(d2, this.b, f0Var.a());
        this.f3353d = gVar;
        this.f3354e = g0Var;
        ((e) g0Var).a = gVar;
        j0 j0Var = new j0();
        this.f3355f = j0Var;
        f0Var.c().c(j0Var);
    }
}
