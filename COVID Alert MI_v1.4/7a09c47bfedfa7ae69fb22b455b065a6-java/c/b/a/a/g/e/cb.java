package c.b.a.a.g.e;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c.b.a.a.d.k.o.l;
import c.b.a.a.d.m.c;
import c.b.a.a.d.m.f;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.zza;

public final class cb extends f<n2> {
    public cb(Context context, Looper looper, c.b.a.a.d.k.o.f fVar, l lVar, c cVar) {
        super(context, looper, 236, cVar, fVar, lVar);
    }

    @Override // c.b.a.a.d.m.b
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.INearbyExposureNotificationService");
        return queryLocalInterface instanceof n2 ? (n2) queryLocalInterface : new m2(iBinder);
    }

    @Override // c.b.a.a.d.m.b
    public final c.b.a.a.d.c[] getApiFeatures() {
        return new c.b.a.a.d.c[]{zza.zzb, zza.zzc, zza.zzd, zza.zze, zza.zzf, zza.zzh, zza.zzg, zza.zzi, zza.zzj};
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    public final int getMinApkVersion() {
        return 201516000;
    }

    @Override // c.b.a.a.d.m.b
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.exposurenotification.internal.INearbyExposureNotificationService";
    }

    @Override // c.b.a.a.d.m.b
    public final String getStartServiceAction() {
        return "com.google.android.gms.nearby.exposurenotification.START";
    }

    @Override // c.b.a.a.d.m.b
    public final boolean getUseDynamicLookup() {
        return true;
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }
}
