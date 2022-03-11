package f.b.c.k.s;

import android.content.Context;
import f.b.a.c.b.o.b;
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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class n {
    public final e a;
    public final a b;
    public final c c;

    /* renamed from: d */
    public b0 f3563d;

    /* renamed from: e */
    public final c0 f3564e;

    /* renamed from: f */
    public d f3565f;

    public n(Context context, e eVar, h hVar, a aVar, c cVar, c0 c0Var) {
        this.a = eVar;
        this.b = aVar;
        this.c = cVar;
        this.f3564e = c0Var;
        i iVar = new i();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        cVar.b(new Runnable(this, iVar, context, hVar) { // from class: f.b.c.k.s.l
            public final n b;
            public final i c;

            /* renamed from: d  reason: collision with root package name */
            public final Context f3560d;

            /* renamed from: e  reason: collision with root package name */
            public final h f3561e;

            {
                this.b = r1;
                this.c = r2;
                this.f3560d = r3;
                this.f3561e = r4;
            }

            @Override // java.lang.Runnable
            public void run() {
                n nVar = this.b;
                i iVar2 = this.c;
                try {
                    nVar.a(this.f3560d, (f) b.j(iVar2.a), this.f3561e);
                } catch (InterruptedException | ExecutionException e2) {
                    throw new RuntimeException(e2);
                }
            }
        });
        aVar.c(new m(this, atomicBoolean, iVar, cVar));
    }

    public final void a(Context context, f fVar, h hVar) {
        m.a(m.a.DEBUG, "FirestoreClient", "Initializing. user=%s", fVar.a);
        d.a aVar = new d.a(context, this.c, this.a, new j(this.a, this.c, this.b, context, this.f3564e), fVar, 100, hVar);
        t a0Var = hVar.c ? new a0() : new t();
        f0 b = a0Var.b(aVar);
        a0Var.a = b;
        b.i();
        a0Var.b = new r(a0Var.a, new e(), aVar.f3535e);
        f.b.c.k.w.h hVar2 = new f.b.c.k.w.h(aVar.a);
        a0Var.f3532f = hVar2;
        a0Var.f3530d = new l0(new t.b(null), a0Var.b, aVar.f3534d, aVar.b, hVar2);
        b0 b0Var = new b0(a0Var.b, a0Var.f3530d, aVar.f3535e, 100);
        a0Var.c = b0Var;
        a0Var.f3531e = new g(b0Var);
        r rVar = a0Var.b;
        rVar.a.h("Start MutationQueue", new f.b.c.k.t.j(rVar));
        a0Var.f3530d.b();
        f.b.c.k.t.d a = a0Var.a(aVar);
        a0Var.f3533g = a;
        this.f3565f = a;
        this.f3563d = a0Var.c;
        if (a != null) {
            v.d dVar = (v.d) a;
            if (v.this.b.a != -1) {
                dVar.a();
            }
        }
    }
}
