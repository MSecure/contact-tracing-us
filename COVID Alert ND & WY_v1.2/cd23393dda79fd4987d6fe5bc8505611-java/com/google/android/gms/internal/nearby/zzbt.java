package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzbt extends zzb implements zzbq {
    zzbt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.INearbyExposureNotificationService");
    }

    @Override // com.google.android.gms.internal.nearby.zzbq
    public final void zza(zzch zzch) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzch);
        zzb(1, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzbq
    public final void zza(zzcl zzcl) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcl);
        zzb(2, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzbq
    public final void zza(zzbz zzbz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzbz);
        zzb(3, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzbq
    public final void zza(zzau zzau) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzau);
        zzb(4, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzbq
    public final void zza(zzcd zzcd) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcd);
        zzb(5, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzbq
    public final void zza(zzaq zzaq) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzaq);
        zzb(13, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzbq
    public final void zza(zzam zzam) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzam);
        zzb(7, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzbq
    public final void zza(zzai zzai) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzai);
        zzb(8, zza);
    }
}
