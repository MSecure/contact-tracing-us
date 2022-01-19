package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public abstract class zzcp extends zza implements zzcm {
    public zzcp() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean z = false;
        if (i != 1) {
            return false;
        }
        Status status = (Status) zzd.zza(parcel, Status.CREATOR);
        if (parcel.readInt() != 0) {
            z = true;
        }
        zza(status, z);
        return true;
    }
}
