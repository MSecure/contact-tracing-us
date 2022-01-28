package c.b.a.a.e.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c.b.a.a.c.k.o.f;
import c.b.a.a.c.k.o.l;
import c.b.a.a.c.l.c;
import c.b.a.a.c.l.g;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.zza;

public final class cb extends g<n2> {
    public cb(Context context, Looper looper, f fVar, l lVar, c cVar) {
        super(context, looper, 236, cVar, fVar, lVar);
    }

    @Override // c.b.a.a.c.l.b
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.INearbyExposureNotificationService");
        return queryLocalInterface instanceof n2 ? (n2) queryLocalInterface : new m2(iBinder);
    }

    @Override // c.b.a.a.c.l.b
    public final c.b.a.a.c.c[] getApiFeatures() {
        return new c.b.a.a.c.c[]{zza.zzb, zza.zzc, zza.zzd, zza.zze, zza.zzf, zza.zzh, zza.zzg, zza.zzi, zza.zzj};
    }

    @Override // c.b.a.a.c.l.g, c.b.a.a.c.l.b, c.b.a.a.c.k.a.f
    public final int getMinApkVersion() {
        return 201516000;
    }

    @Override // c.b.a.a.c.l.b
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.exposurenotification.internal.INearbyExposureNotificationService";
    }

    @Override // c.b.a.a.c.l.b
    public final String getStartServiceAction() {
        return "com.google.android.gms.nearby.exposurenotification.START";
    }

    @Override // c.b.a.a.c.l.b
    public final boolean getUseDynamicLookup() {
        return true;
    }

    @Override // c.b.a.a.c.l.b, c.b.a.a.c.k.a.f
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }
}
