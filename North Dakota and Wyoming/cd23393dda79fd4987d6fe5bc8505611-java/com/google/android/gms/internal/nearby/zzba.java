package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzba extends zzb implements zzay {
    zzba(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzay
    public final void zza(Status status, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, status);
        zzd.zza(zza, z);
        zzb(1, zza);
    }
}
