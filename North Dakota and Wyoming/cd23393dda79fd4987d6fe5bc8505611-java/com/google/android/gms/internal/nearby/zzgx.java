package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzgx extends zzb implements zzgv {
    zzgx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzgv
    public final void zza(zzic zzic) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzic);
        zzb(2, zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzgv
    public final void zza(zziw zziw) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zziw);
        zzb(3, zza);
    }
}
