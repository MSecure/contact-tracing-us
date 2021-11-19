package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public abstract class zzha extends zza implements zzhb {
    public zzha() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.nearby.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zza((zzia) zzd.zza(parcel, zzia.CREATOR));
            return true;
        } else if (i == 3) {
            zza((zzig) zzd.zza(parcel, zzig.CREATOR));
            return true;
        } else if (i == 4) {
            zza((zzii) zzd.zza(parcel, zzii.CREATOR));
            return true;
        } else if (i != 5) {
            return false;
        } else {
            zza((zzhy) zzd.zza(parcel, zzhy.CREATOR));
            return true;
        }
    }
}
