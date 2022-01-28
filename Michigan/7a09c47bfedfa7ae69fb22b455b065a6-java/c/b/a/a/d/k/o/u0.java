package c.b.a.a.d.k.o;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c.b.a.a.d.c;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.b;
import c.b.a.a.d.k.h;
import c.b.a.a.d.k.o.g;
import c.b.a.a.j.j;
import com.google.android.gms.common.api.Status;

public final class u0<ResultT> extends u {

    /* renamed from: b  reason: collision with root package name */
    public final r<a.b, ResultT> f3051b;

    /* renamed from: c  reason: collision with root package name */
    public final j<ResultT> f3052c;

    /* renamed from: d  reason: collision with root package name */
    public final p f3053d;

    public u0(int i, r<a.b, ResultT> rVar, j<ResultT> jVar, p pVar) {
        super(i);
        this.f3052c = jVar;
        this.f3051b = rVar;
        this.f3053d = pVar;
        if (i == 2 && rVar.shouldAutoResolveMissingFeatures()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // c.b.a.a.d.k.o.g0
    public final void b(Status status) {
        j<ResultT> jVar = this.f3052c;
        if (((a) this.f3053d) != null) {
            jVar.a(status.f5983e != null ? new h(status) : new b(status));
            return;
        }
        throw null;
    }

    @Override // c.b.a.a.d.k.o.g0
    public final void c(e1 e1Var, boolean z) {
        j<ResultT> jVar = this.f3052c;
        e1Var.f2974b.put(jVar, Boolean.valueOf(z));
        jVar.f4109a.b(new g1(e1Var, jVar));
    }

    @Override // c.b.a.a.d.k.o.g0
    public final void d(Exception exc) {
        this.f3052c.a(exc);
    }

    @Override // c.b.a.a.d.k.o.g0
    public final void e(g.a<?> aVar) {
        try {
            this.f3051b.doExecute(aVar.f2984b, this.f3052c);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            b(g0.a(e3));
        } catch (RuntimeException e4) {
            this.f3052c.a(e4);
        }
    }

    @Override // c.b.a.a.d.k.o.u
    public final c[] f(g.a<?> aVar) {
        return this.f3051b.zaa();
    }

    @Override // c.b.a.a.d.k.o.u
    public final boolean g(g.a<?> aVar) {
        return this.f3051b.shouldAutoResolveMissingFeatures();
    }
}
