package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzgy extends zzb implements zzgw {
    zzgy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzgw
    public final void zza(zziq zziq) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zziq);
        zzb(2, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzgw
    public final void zza(zzii zzii) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzii);
        zzb(3, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzgw
    public final void zza(zzis zzis) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzis);
        zzb(4, zza);
    }
}
