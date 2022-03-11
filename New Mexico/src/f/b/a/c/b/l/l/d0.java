package f.b.a.c.b.l.l;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import f.b.a.c.b.l.b;
import f.b.a.c.b.l.l.e;
import f.b.a.c.i.i;
/* loaded from: classes.dex */
public abstract class d0<T> extends n {
    public final i<T> b;

    public d0(int i2, i<T> iVar) {
        super(i2);
        this.b = iVar;
    }

    @Override // f.b.a.c.b.l.l.w
    public void b(Status status) {
        this.b.a(new b(status));
    }

    @Override // f.b.a.c.b.l.l.w
    public void d(Exception exc) {
        this.b.a(exc);
    }

    @Override // f.b.a.c.b.l.l.w
    public final void e(e.a<?> aVar) {
        try {
            h(aVar);
        } catch (DeadObjectException e2) {
            this.b.a(new b(w.a(e2)));
            throw e2;
        } catch (RemoteException e3) {
            this.b.a(new b(w.a(e3)));
        } catch (RuntimeException e4) {
            this.b.a(e4);
        }
    }

    public abstract void h(e.a<?> aVar);
}
