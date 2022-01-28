package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzhd extends zzb implements zzhb {
    zzhd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzhb
    public final void zza(zzia zzia) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzia);
        zzb(2, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzhb
    public final void zza(zzig zzig) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzig);
        zzb(3, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzhb
    public final void zza(zzii zzii) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzii);
        zzb(4, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzhb
    public final void zza(zzhy zzhy) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzhy);
        zzb(5, zza);
    }
}
