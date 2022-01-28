package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.nearby.zzb;
import com.google.android.gms.internal.nearby.zzd;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzy extends zzb implements zzw {
    zzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.IStatusCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzw
    public final void zza(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, z);
        zzb(1, zza);
    }
}
