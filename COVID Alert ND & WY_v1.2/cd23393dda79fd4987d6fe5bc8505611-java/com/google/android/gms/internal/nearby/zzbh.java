package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureInformation;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzbh extends zzb implements zzbf {
    zzbh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IExposureInformationListCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzbf
    public final void zza(Status status, List<ExposureInformation> list) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, status);
        zza.writeTypedList(list);
        zzb(1, zza);
    }
}
