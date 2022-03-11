package f.b.a.c.b.l.l;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import f.b.a.c.b.l.l.e;
/* loaded from: classes.dex */
public abstract class w {
    public final int a;

    public w(int i2) {
        this.a = i2;
    }

    public static Status a(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void b(Status status);

    public abstract void c(i0 i0Var, boolean z);

    public abstract void d(Exception exc);

    public abstract void e(e.a<?> aVar);
}
