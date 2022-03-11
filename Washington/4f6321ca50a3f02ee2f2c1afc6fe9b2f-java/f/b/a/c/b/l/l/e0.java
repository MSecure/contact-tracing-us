package f.b.a.c.b.l.l;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import f.b.a.c.b.c;
import f.b.a.c.b.l.b;
import f.b.a.c.b.l.h;
import f.b.a.c.b.l.l.e;
import f.b.a.c.i.c0;
import f.b.a.c.i.i;
import f.b.a.c.i.j;
import java.util.Objects;

public final class e0<ResultT> extends n {
    public final l<Object, ResultT> b;
    public final i<ResultT> c;

    /* renamed from: d  reason: collision with root package name */
    public final a f2435d;

    public e0(int i2, l<Object, ResultT> lVar, i<ResultT> iVar, a aVar) {
        super(i2);
        this.c = iVar;
        this.b = lVar;
        this.f2435d = aVar;
        if (i2 == 2 && lVar.b) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // f.b.a.c.b.l.l.w
    public final void b(Status status) {
        i<ResultT> iVar = this.c;
        Objects.requireNonNull(this.f2435d);
        iVar.a(status.f412e != null ? new h(status) : new b(status));
    }

    @Override // f.b.a.c.b.l.l.w
    public final void c(i0 i0Var, boolean z) {
        i<ResultT> iVar = this.c;
        i0Var.b.put(iVar, Boolean.valueOf(z));
        c0<TResult> c0Var = iVar.a;
        j0 j0Var = new j0(i0Var, iVar);
        Objects.requireNonNull(c0Var);
        c0Var.c(j.a, j0Var);
    }

    @Override // f.b.a.c.b.l.l.w
    public final void d(Exception exc) {
        this.c.a(exc);
    }

    @Override // f.b.a.c.b.l.l.w
    public final void e(e.a<?> aVar) {
        try {
            l<Object, ResultT> lVar = this.b;
            ((c0) lVar).c.a.a(aVar.b, this.c);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            b(w.a(e3));
        } catch (RuntimeException e4) {
            this.c.a(e4);
        }
    }

    @Override // f.b.a.c.b.l.l.n
    public final c[] f(e.a<?> aVar) {
        return this.b.a;
    }

    @Override // f.b.a.c.b.l.l.n
    public final boolean g(e.a<?> aVar) {
        return this.b.b;
    }
}
