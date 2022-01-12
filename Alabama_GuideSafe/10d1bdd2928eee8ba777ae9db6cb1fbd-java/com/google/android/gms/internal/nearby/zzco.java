package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzco extends zzb implements zzcm {
    public zzco(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzcm
    public final void zza(Status status, boolean z) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, status);
        a_.writeInt(z ? 1 : 0);
        zzc(1, a_);
    }
}
