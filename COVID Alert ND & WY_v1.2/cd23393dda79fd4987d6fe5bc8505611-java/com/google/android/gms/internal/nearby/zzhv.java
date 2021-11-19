package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public abstract class zzhv extends zza implements zzhs {
    public zzhv() {
        super("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.nearby.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        zza((zziu) zzd.zza(parcel, zziu.CREATOR));
        return true;
    }
}
