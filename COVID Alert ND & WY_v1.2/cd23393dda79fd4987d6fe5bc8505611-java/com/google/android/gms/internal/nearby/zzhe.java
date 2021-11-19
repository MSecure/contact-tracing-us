package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzhe extends zzb implements zzhc {
    zzhe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzhc
    public final void zza(zzie zzie) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzie);
        zzb(2, zza);
    }
}
