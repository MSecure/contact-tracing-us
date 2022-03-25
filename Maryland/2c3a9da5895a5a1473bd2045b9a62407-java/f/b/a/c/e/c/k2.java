package f.b.a.c.e.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import f.b.a.c.b.l.l.d;
import f.b.a.c.b.l.l.j;
import f.b.a.c.b.m.c;
import f.b.a.c.b.m.f;
import f.b.a.c.f.a;

public final class k2 extends f<k1> {
    public k2(Context context, Looper looper, d dVar, j jVar, c cVar) {
        super(context, looper, 236, cVar, dVar, jVar);
    }

    @Override // f.b.a.c.b.l.a.e, f.b.a.c.b.m.b
    public final boolean o() {
        return a.a(this.c);
    }

    @Override // f.b.a.c.b.l.a.e, f.b.a.c.b.m.b
    public final int p() {
        return 201516000;
    }

    @Override // f.b.a.c.b.m.b
    public final /* bridge */ /* synthetic */ IInterface q(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.INearbyExposureNotificationService");
        return queryLocalInterface instanceof k1 ? (k1) queryLocalInterface : new j1(iBinder);
    }

    @Override // f.b.a.c.b.m.b
    public final f.b.a.c.b.c[] r() {
        return new f.b.a.c.b.c[]{f.b.a.c.f.c.f2640f, f.b.a.c.f.c.f2641g, f.b.a.c.f.c.f2642h, f.b.a.c.f.c.f2643i, f.b.a.c.f.c.f2644j, f.b.a.c.f.c.f2646l, f.b.a.c.f.c.f2645k, f.b.a.c.f.c.m, f.b.a.c.f.c.n, f.b.a.c.f.c.o};
    }

    @Override // f.b.a.c.b.m.b
    public final String u() {
        return "com.google.android.gms.nearby.exposurenotification.internal.INearbyExposureNotificationService";
    }

    @Override // f.b.a.c.b.m.b
    public final String v() {
        return "com.google.android.gms.nearby.exposurenotification.START";
    }

    @Override // f.b.a.c.b.m.b
    public final boolean w() {
        return true;
    }
}
