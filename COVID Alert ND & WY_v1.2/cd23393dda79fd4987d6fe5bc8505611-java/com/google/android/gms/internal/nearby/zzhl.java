package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzhl extends zzb implements zzhj {
    zzhl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzhj
    public final void zza(zzim zzim) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzim);
        zzb(2, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzhj
    public final void zza(zzio zzio) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzio);
        zzb(3, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzhj
    public final void zza(zziy zziy) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zziy);
        zzb(4, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzhj
    public final void zza(zzik zzik) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzik);
        zzb(5, zza);
    }
}
