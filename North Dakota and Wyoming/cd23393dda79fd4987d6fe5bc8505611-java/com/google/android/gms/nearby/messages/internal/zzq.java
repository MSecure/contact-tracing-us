package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.nearby.zzb;
import com.google.android.gms.internal.nearby.zzd;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzq extends zzb implements zzo {
    zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzo
    public final void zza(Status status) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, status);
        zzb(1, zza);
    }
}
