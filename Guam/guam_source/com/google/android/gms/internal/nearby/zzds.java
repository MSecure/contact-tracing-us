package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzds extends zzb implements zzdq {
    public zzds(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzdq
    public final void zza(Status status, long j) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, status);
        a_.writeLong(j);
        zzc(1, a_);
    }
}
