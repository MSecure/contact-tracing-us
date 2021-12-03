package f.b.a.a.a.d0;

import e.b.a.m;
import e.t.l;
import e.v.a.f.f;
import f.b.a.a.a.b0.a1;
import f.b.a.a.a.b0.f1;
import f.b.a.a.a.b0.o0;
import f.b.a.a.a.b0.r0;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.q.i1;
import f.b.a.a.a.q.m1;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.d;
import l.b.a.e;

public class m {

    /* renamed from: h  reason: collision with root package name */
    public static final a f2138h = a.e("WorkerStartupManager");

    /* renamed from: i  reason: collision with root package name */
    public static final d f2139i = d.n(10);

    /* renamed from: j  reason: collision with root package name */
    public static final d f2140j = d.n(10);

    /* renamed from: k  reason: collision with root package name */
    public static final d f2141k = d.f(14);

    /* renamed from: l  reason: collision with root package name */
    public static final d f2142l = d.f(30);
    public final i1 a;
    public final ExecutorService b;
    public final ScheduledExecutorService c;

    /* renamed from: d  reason: collision with root package name */
    public final m1 f2143d;

    /* renamed from: e  reason: collision with root package name */
    public final r0 f2144e;

    /* renamed from: f  reason: collision with root package name */
    public final f1 f2145f;

    /* renamed from: g  reason: collision with root package name */
    public final f.b.a.a.a.i.f0.a f2146g;

    public m(i1 i1Var, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, m1 m1Var, r0 r0Var, f1 f1Var, f.b.a.a.a.i.f0.a aVar) {
        this.a = i1Var;
        this.b = executorService;
        this.c = scheduledExecutorService;
        this.f2143d = m1Var;
        this.f2144e = r0Var;
        this.f2145f = f1Var;
        this.f2146g = aVar;
    }

    public final void a() {
        r0 r0Var = this.f2144e;
        e w = this.f2146g.c().w(f2141k);
        o0 o0Var = (o0) r0Var.a;
        o0Var.a.b();
        f a2 = o0Var.c.a();
        a2.b.bindLong(1, m.h.Z(w));
        o0Var.a.c();
        try {
            a2.d();
            o0Var.a.l();
            f1 f1Var = this.f2145f;
            e w2 = this.f2146g.c().w(f2142l);
            a1 a1Var = (a1) f1Var.a;
            a1Var.a.b();
            f a3 = a1Var.c.a();
            a3.b.bindLong(1, m.h.Z(w2));
            a1Var.a.c();
            try {
                a3.d();
                a1Var.a.l();
                f1 f1Var2 = this.f2145f;
                e c2 = this.f2146g.c();
                a1 a1Var2 = (a1) f1Var2.a;
                a1Var2.a.b();
                f a4 = a1Var2.f2079d.a();
                a4.b.bindLong(1, m.h.Z(c2));
                a1Var2.a.c();
                try {
                    a4.d();
                    a1Var2.a.l();
                } finally {
                    a1Var2.a.g();
                    l lVar = a1Var2.f2079d;
                    if (a4 == lVar.c) {
                        lVar.a.set(false);
                    }
                }
            } finally {
                a1Var.a.g();
                l lVar2 = a1Var.c;
                if (a3 == lVar2.c) {
                    lVar2.a.set(false);
                }
            }
        } finally {
            o0Var.a.g();
            l lVar3 = o0Var.c;
            if (a2 == lVar3.c) {
                lVar3.a.set(false);
            }
        }
    }

    public u<Boolean> b() {
        f.b.b.f.a.l z = f.b.b.f.a.l.x(m.h.i0(this.a.b(), f2139i, this.c)).z(new d(this), this.b);
        c cVar = new c(this);
        ExecutorService executorService = this.b;
        a.C0108a aVar = new a.C0108a(z, Exception.class, cVar);
        ((l.a) z).a(aVar, b.g1(executorService, aVar));
        return aVar;
    }
}
