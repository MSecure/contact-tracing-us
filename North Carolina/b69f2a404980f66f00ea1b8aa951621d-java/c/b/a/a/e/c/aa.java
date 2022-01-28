package c.b.a.a.e.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c.b.a.a.c.k.o.f;
import c.b.a.a.c.k.o.l;
import c.b.a.a.c.l.c;
import c.b.a.a.c.l.g;

public final class aa extends g<ra> {
    public aa(Context context, Looper looper, f fVar, l lVar, c cVar) {
        super(context, looper, 69, cVar, fVar, lVar);
    }

    @Override // c.b.a.a.c.l.b
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
        return queryLocalInterface instanceof ra ? (ra) queryLocalInterface : new ab(iBinder);
    }

    @Override // c.b.a.a.c.l.g, c.b.a.a.c.l.b, c.b.a.a.c.k.a.f
    public final int getMinApkVersion() {
        return c.b.a.a.c.g.f2295a;
    }

    @Override // c.b.a.a.c.l.b
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService";
    }

    @Override // c.b.a.a.c.l.b
    public final String getStartServiceAction() {
        return "com.google.android.gms.nearby.bootstrap.service.NearbyBootstrapService.START";
    }
}
