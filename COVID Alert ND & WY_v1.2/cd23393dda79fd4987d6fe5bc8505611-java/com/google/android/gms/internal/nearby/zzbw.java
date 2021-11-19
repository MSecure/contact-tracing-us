package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzbw extends zzb implements zzbu {
    zzbw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzbu
    public final void zza(Status status, List<TemporaryExposureKey> list) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, status);
        zza.writeTypedList(list);
        zzb(1, zza);
    }
}
