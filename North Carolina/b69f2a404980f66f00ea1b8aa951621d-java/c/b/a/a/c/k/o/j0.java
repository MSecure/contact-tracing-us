package c.b.a.a.c.k.o;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c.b.a.a.c.k.b;
import c.b.a.a.c.k.o.g;
import c.b.a.a.g.i;
import com.google.android.gms.common.api.Status;

public abstract class j0<T> extends v0 {

    /* renamed from: b  reason: collision with root package name */
    public final i<T> f2371b;

    public j0(int i, i<T> iVar) {
        super(i);
        this.f2371b = iVar;
    }

    @Override // c.b.a.a.c.k.o.y
    public void a(Status status) {
        this.f2371b.a(new b(status));
    }

    @Override // c.b.a.a.c.k.o.y
    public final void b(g.a<?> aVar) {
        try {
            h(aVar);
        } catch (DeadObjectException e2) {
            this.f2371b.a(new b(y.e(e2)));
            throw e2;
        } catch (RemoteException e3) {
            this.f2371b.a(new b(y.e(e3)));
        } catch (RuntimeException e4) {
            this.f2371b.a(e4);
        }
    }

    @Override // c.b.a.a.c.k.o.y
    public void d(Exception exc) {
        this.f2371b.a(exc);
    }

    public abstract void h(g.a<?> aVar);
}
