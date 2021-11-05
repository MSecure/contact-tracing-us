package c.b.a.a.c.k.o;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import c.b.a.a.c.k.o.g;
import com.google.android.gms.common.api.Status;

public abstract class y {

    /* renamed from: a  reason: collision with root package name */
    public final int f2410a;

    public y(int i) {
        this.f2410a = i;
    }

    public static Status e(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (remoteException instanceof TransactionTooLargeException) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void a(Status status);

    public abstract void b(g.a<?> aVar);

    public abstract void c(t tVar, boolean z);

    public abstract void d(Exception exc);
}
