package c.b.a.a.d.k.o;

import android.os.RemoteException;
import c.b.a.a.d.k.o.g;
import com.google.android.gms.common.api.Status;

public abstract class g0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f2998a;

    public g0(int i) {
        this.f2998a = i;
    }

    public static Status a(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void b(Status status);

    public abstract void c(e1 e1Var, boolean z);

    public abstract void d(Exception exc);

    public abstract void e(g.a<?> aVar);
}
