package c.b.a.a.c.k.o;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c.b.a.a.c.c;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.b;
import c.b.a.a.c.k.h;
import c.b.a.a.c.k.o.g;
import c.b.a.a.g.i;
import com.google.android.gms.common.api.Status;

public final class z0<ResultT> extends v0 {

    /* renamed from: b  reason: collision with root package name */
    public final q<a.b, ResultT> f2413b;

    /* renamed from: c  reason: collision with root package name */
    public final i<ResultT> f2414c;

    /* renamed from: d  reason: collision with root package name */
    public final p f2415d;

    public z0(int i, q<a.b, ResultT> qVar, i<ResultT> iVar, p pVar) {
        super(i);
        this.f2414c = iVar;
        this.f2413b = qVar;
        this.f2415d = pVar;
        if (i == 2 && qVar.shouldAutoResolveMissingFeatures()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // c.b.a.a.c.k.o.y
    public final void a(Status status) {
        i<ResultT> iVar = this.f2414c;
        if (((a) this.f2415d) != null) {
            iVar.a(status.f4434e != null ? new h(status) : new b(status));
            return;
        }
        throw null;
    }

    @Override // c.b.a.a.c.k.o.y
    public final void b(g.a<?> aVar) {
        try {
            this.f2413b.doExecute(aVar.f2342b, this.f2414c);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            a(y.e(e3));
        } catch (RuntimeException e4) {
            this.f2414c.a(e4);
        }
    }

    @Override // c.b.a.a.c.k.o.y
    public final void c(t tVar, boolean z) {
        i<ResultT> iVar = this.f2414c;
        tVar.f2402b.put(iVar, Boolean.valueOf(z));
        iVar.f2856a.b(new v(tVar, iVar));
    }

    @Override // c.b.a.a.c.k.o.y
    public final void d(Exception exc) {
        this.f2414c.a(exc);
    }

    @Override // c.b.a.a.c.k.o.v0
    public final c[] f(g.a<?> aVar) {
        return this.f2413b.zabr();
    }

    @Override // c.b.a.a.c.k.o.v0
    public final boolean g(g.a<?> aVar) {
        return this.f2413b.shouldAutoResolveMissingFeatures();
    }
}
