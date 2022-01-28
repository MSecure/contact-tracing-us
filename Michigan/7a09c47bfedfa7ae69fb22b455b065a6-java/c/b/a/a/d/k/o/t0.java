package c.b.a.a.d.k.o;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c.b.a.a.d.k.b;
import c.b.a.a.d.k.o.g;
import c.b.a.a.j.j;
import com.google.android.gms.common.api.Status;

public abstract class t0<T> extends u {

    /* renamed from: b  reason: collision with root package name */
    public final j<T> f3050b;

    public t0(int i, j<T> jVar) {
        super(i);
        this.f3050b = jVar;
    }

    @Override // c.b.a.a.d.k.o.g0
    public void b(Status status) {
        this.f3050b.a(new b(status));
    }

    @Override // c.b.a.a.d.k.o.g0
    public void d(Exception exc) {
        this.f3050b.a(exc);
    }

    @Override // c.b.a.a.d.k.o.g0
    public final void e(g.a<?> aVar) {
        try {
            h(aVar);
        } catch (DeadObjectException e2) {
            this.f3050b.a(new b(g0.a(e2)));
            throw e2;
        } catch (RemoteException e3) {
            this.f3050b.a(new b(g0.a(e3)));
        } catch (RuntimeException e4) {
            this.f3050b.a(e4);
        }
    }

    public abstract void h(g.a<?> aVar);
}
