package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzbk extends zzb implements zzbi {
    zzbk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzbi
    public final void zza(Status status, ExposureSummary exposureSummary) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, status);
        zzd.zza(zza, exposureSummary);
        zzb(1, zza);
    }
}
