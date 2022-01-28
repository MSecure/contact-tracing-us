package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzbr extends zzb implements zzbp {
    zzbr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzbp
    public final void zza(Status status, List<ExposureWindow> list) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, status);
        zza.writeTypedList(list);
        zzb(1, zza);
    }
}
