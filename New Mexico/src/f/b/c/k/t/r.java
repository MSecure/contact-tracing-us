package f.b.c.k.t;

import android.util.SparseArray;
import f.b.a.c.b.o.b;
import f.b.c.k.r.f;
import f.b.c.k.s.c0;
import f.b.c.k.s.d0;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: j */
    public static final long f3606j = TimeUnit.MINUTES.toSeconds(5);

    /* renamed from: k */
    public static final /* synthetic */ int f3607k;
    public final f0 a;
    public e0 b;
    public final k0 c;

    /* renamed from: d */
    public g f3608d;

    /* renamed from: e */
    public g0 f3609e;

    /* renamed from: f */
    public final j0 f3610f;

    /* renamed from: g */
    public final c1 f3611g;

    /* renamed from: h */
    public final SparseArray<d1> f3612h = new SparseArray<>();

    /* renamed from: i */
    public final Map<c0, Integer> f3613i = new HashMap();

    public r(f0 f0Var, g0 g0Var, f fVar) {
        b.P0(f0Var.f(), "LocalStore was passed an unstarted persistence implementation", new Object[0]);
        this.a = f0Var;
        c1 e2 = f0Var.e();
        this.f3611g = e2;
        new d0(0, e2.f()).a += 2;
        this.b = f0Var.b(fVar);
        k0 d2 = f0Var.d();
        this.c = d2;
        g gVar = new g(d2, this.b, f0Var.a());
        this.f3608d = gVar;
        this.f3609e = g0Var;
        ((e) g0Var).a = gVar;
        j0 j0Var = new j0();
        this.f3610f = j0Var;
        f0Var.c().c(j0Var);
    }
}
