package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzhu extends zzb implements zzhs {
    zzhu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzhs
    public final void zza(zziu zziu) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zziu);
        zzb(2, zza);
    }
}
