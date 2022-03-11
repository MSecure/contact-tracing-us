package f.b.a.b.i;

import android.content.Context;
import f.b.a.b.i.g;
import f.b.a.b.i.p.j;
import f.b.a.b.i.q.a.b;
import f.b.a.b.i.s.d;
import f.b.a.b.i.s.h.f;
import f.b.a.b.i.s.h.l;
import f.b.a.b.i.s.h.m;
import f.b.a.b.i.s.h.p;
import f.b.a.b.i.s.h.q;
import f.b.a.b.i.s.h.r;
import f.b.a.b.i.s.i.a0;
import f.b.a.b.i.s.i.e;
import f.b.a.b.i.s.i.f;
import f.b.a.b.i.s.i.g;
import f.b.a.b.i.s.i.t;
import f.b.a.b.i.s.i.u;
import f.b.a.b.i.u.b;
import f.b.a.b.i.u.c;
import java.util.Objects;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class c extends n {
    public i.a.a<Executor> b;
    public i.a.a<Context> c;

    /* renamed from: d */
    public i.a.a f2615d;

    /* renamed from: e */
    public i.a.a f2616e;

    /* renamed from: f */
    public i.a.a f2617f;

    /* renamed from: g */
    public i.a.a<t> f2618g;

    /* renamed from: h */
    public i.a.a<f> f2619h;

    /* renamed from: i */
    public i.a.a<r> f2620i;

    /* renamed from: j */
    public i.a.a<f.b.a.b.i.s.c> f2621j;

    /* renamed from: k */
    public i.a.a<l> f2622k;

    /* renamed from: l */
    public i.a.a<p> f2623l;
    public i.a.a<m> m;

    public c(Context context, a aVar) {
        i.a.a<Executor> aVar2 = g.a.a;
        Object obj = f.b.a.b.i.q.a.a.c;
        this.b = !(aVar2 instanceof f.b.a.b.i.q.a.a) ? new f.b.a.b.i.q.a.a<>(aVar2) : aVar2;
        Objects.requireNonNull(context, "instance cannot be null");
        b bVar = new b(context);
        this.c = bVar;
        f.b.a.b.i.u.b bVar2 = b.a.a;
        f.b.a.b.i.u.c cVar = c.a.a;
        j jVar = new j(bVar, bVar2, cVar);
        this.f2615d = jVar;
        i.a.a lVar = new f.b.a.b.i.p.l(bVar, jVar);
        this.f2616e = !(lVar instanceof f.b.a.b.i.q.a.a) ? new f.b.a.b.i.q.a.a(lVar) : lVar;
        a0 a0Var = new a0(this.c, e.a.a, f.a.a);
        this.f2617f = a0Var;
        u uVar = new u(bVar2, cVar, g.a.a, a0Var);
        i.a.a<t> aVar3 = uVar instanceof f.b.a.b.i.q.a.a ? uVar : new f.b.a.b.i.q.a.a<>(uVar);
        this.f2618g = aVar3;
        f.b.a.b.i.s.f fVar = new f.b.a.b.i.s.f(bVar2);
        this.f2619h = fVar;
        i.a.a<Context> aVar4 = this.c;
        f.b.a.b.i.s.g gVar = new f.b.a.b.i.s.g(aVar4, aVar3, fVar, cVar);
        this.f2620i = gVar;
        i.a.a<Executor> aVar5 = this.b;
        i.a.a aVar6 = this.f2616e;
        d dVar = new d(aVar5, aVar6, gVar, aVar3, aVar3);
        this.f2621j = dVar;
        m mVar = new m(aVar4, aVar6, aVar3, gVar, aVar5, aVar3, bVar2);
        this.f2622k = mVar;
        q qVar = new q(aVar5, aVar3, gVar, aVar3);
        this.f2623l = qVar;
        i.a.a<m> oVar = new o(bVar2, cVar, dVar, mVar, qVar);
        this.m = !(oVar instanceof f.b.a.b.i.q.a.a) ? new f.b.a.b.i.q.a.a<>(oVar) : oVar;
    }
}
