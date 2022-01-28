package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public abstract class zzgu extends zza implements zzgv {
    public zzgu() {
        super("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.nearby.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zza((zzic) zzd.zza(parcel, zzic.CREATOR));
            return true;
        } else if (i != 3) {
            return false;
        } else {
            zza((zziw) zzd.zza(parcel, zziw.CREATOR));
            return true;
        }
    }
}
