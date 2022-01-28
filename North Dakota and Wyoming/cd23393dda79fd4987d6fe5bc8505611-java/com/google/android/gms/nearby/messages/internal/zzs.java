package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.nearby.zzb;
import com.google.android.gms.internal.nearby.zzd;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzs extends zzb implements zzt {
    zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzt
    public final void zza(zzby zzby) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzby);
        zzb(1, zza);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzt
    public final void zza(zzcd zzcd) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcd);
        zzb(2, zza);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzt
    public final void zza(SubscribeRequest subscribeRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, subscribeRequest);
        zzb(3, zza);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzt
    public final void zza(zzcf zzcf) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzcf);
        zzb(4, zza);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzt
    public final void zza(zzg zzg) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzg);
        zzb(7, zza);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzt
    public final void zza(zzca zzca) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzca);
        zzb(8, zza);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzt
    public final void zza(zzi zzi) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzi);
        zzb(9, zza);
    }
}
