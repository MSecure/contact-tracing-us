package f.b.c.k.s;

import android.content.Context;
import f.b.a.c.i.i;
import f.b.c.k.h;
import f.b.c.k.r.a;
import f.b.c.k.r.f;
import f.b.c.k.s.d;
import f.b.c.k.s.t;
import f.b.c.k.t.d;
import f.b.c.k.t.e;
import f.b.c.k.t.f0;
import f.b.c.k.t.r;
import f.b.c.k.t.v;
import f.b.c.k.w.c0;
import f.b.c.k.w.j;
import f.b.c.k.w.l0;
import f.b.c.k.x.c;
import f.b.c.k.x.m;
import java.util.concurrent.atomic.AtomicBoolean;

public final class n {
    public final e a;
    public final a b;
    public final c c;

    /* renamed from: d  reason: collision with root package name */
    public b0 f3046d;

    /* renamed from: e  reason: collision with root package name */
    public final c0 f3047e;

    /* renamed from: f  reason: collision with root package name */
    public d f3048f;

    public n(Context context, e eVar, h hVar, a aVar, c cVar, c0 c0Var) {
        this.a = eVar;
        this.b = aVar;
        this.c = cVar;
        this.f3047e = c0Var;
        i iVar = new i();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        cVar.b(new l(this, iVar, context, hVar));
        aVar.c(new m(this, atomicBoolean, iVar, cVar));
    }

    public final void a(Context context, f fVar, h hVar) {
        m.a(m.a.DEBUG, "FirestoreClient", "Initializing. user=%s", fVar.a);
        d.a aVar = new d.a(context, this.c, this.a, new j(this.a, this.c, this.b, context, this.f3047e), fVar, 100, hVar);
        t a0Var = hVar.c ? new a0() : new t();
        f0 b2 = a0Var.b(aVar);
        a0Var.a = b2;
        b2.i();
        a0Var.b = new r(a0Var.a, new e(), aVar.f3018e);
        f.b.c.k.w.h hVar2 = new f.b.c.k.w.h(aVar.a);
        a0Var.f3015f = hVar2;
        a0Var.f3013d = new l0(new t.b(null), a0Var.b, aVar.f3017d, aVar.b, hVar2);
        b0 b0Var = new b0(a0Var.b, a0Var.f3013d, aVar.f3018e, 100);
        a0Var.c = b0Var;
        a0Var.f3014e = new g(b0Var);
        r rVar = a0Var.b;
        rVar.a.h("Start MutationQueue", new f.b.c.k.t.j(rVar));
        a0Var.f3013d.b();
        f.b.c.k.t.d a2 = a0Var.a(aVar);
        a0Var.f3016g = a2;
        this.f3048f = a2;
        this.f3046d = a0Var.c;
        if (a2 != null) {
            v.d dVar = (v.d) a2;
            if (v.this.b.a != -1) {
                dVar.a();
            }
        }
    }
}
