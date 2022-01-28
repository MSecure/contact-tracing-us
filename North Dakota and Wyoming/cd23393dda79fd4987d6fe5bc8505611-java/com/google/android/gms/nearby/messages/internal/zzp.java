package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.nearby.zzb;
import com.google.android.gms.internal.nearby.zzd;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzp extends zzb implements zzn {
    zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzn
    public final void zza(zzae zzae) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzae);
        zzb(1, zza);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzn
    public final void zzb(zzae zzae) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzae);
        zzb(2, zza);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzn
    public final void zza(List<Update> list) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzb(4, zza);
    }
}
