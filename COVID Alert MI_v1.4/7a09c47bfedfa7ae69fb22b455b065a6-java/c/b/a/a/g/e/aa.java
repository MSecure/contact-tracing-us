package c.b.a.a.g.e;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c.b.a.a.d.g;
import c.b.a.a.d.k.o.l;
import c.b.a.a.d.m.c;
import c.b.a.a.d.m.f;

public final class aa extends f<ra> {
    public aa(Context context, Looper looper, c.b.a.a.d.k.o.f fVar, l lVar, c cVar) {
        super(context, looper, 69, cVar, fVar, lVar);
    }

    @Override // c.b.a.a.d.m.b
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
        return queryLocalInterface instanceof ra ? (ra) queryLocalInterface : new ab(iBinder);
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    public final int getMinApkVersion() {
        return g.f2932a;
    }

    @Override // c.b.a.a.d.m.b
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService";
    }

    @Override // c.b.a.a.d.m.b
    public final String getStartServiceAction() {
        return "com.google.android.gms.nearby.bootstrap.service.NearbyBootstrapService.START";
    }

    @Override // c.b.a.a.d.m.b
    public final boolean usesClientTelemetry() {
        return true;
    }
}
