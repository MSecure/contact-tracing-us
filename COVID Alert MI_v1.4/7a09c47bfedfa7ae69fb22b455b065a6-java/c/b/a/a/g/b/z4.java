package c.b.a.a.g.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c.b.a.a.d.k.e;
import c.b.a.a.d.m.c;
import c.b.a.a.d.m.f;

public final class z4 extends f<c5> {
    public z4(Context context, Looper looper, c cVar, e.a aVar, e.b bVar) {
        super(context, looper, 40, cVar, aVar, bVar);
    }

    @Override // c.b.a.a.d.m.b
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
        return queryLocalInterface instanceof c5 ? (c5) queryLocalInterface : new d5(iBinder);
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    public final int getMinApkVersion() {
        return 11925000;
    }

    @Override // c.b.a.a.d.m.b
    public final String getServiceDescriptor() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }

    @Override // c.b.a.a.d.m.b
    public final String getStartServiceAction() {
        return "com.google.android.gms.clearcut.service.START";
    }
}
