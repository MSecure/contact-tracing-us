package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public abstract class zzhi extends zza implements zzhj {
    public zzhi() {
        super("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.nearby.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zza((zzim) zzd.zza(parcel, zzim.CREATOR));
            return true;
        } else if (i == 3) {
            zza((zzio) zzd.zza(parcel, zzio.CREATOR));
            return true;
        } else if (i == 4) {
            zza((zziy) zzd.zza(parcel, zziy.CREATOR));
            return true;
        } else if (i != 5) {
            return false;
        } else {
            zza((zzik) zzd.zza(parcel, zzik.CREATOR));
            return true;
        }
    }
}
