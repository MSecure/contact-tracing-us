package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzht extends zzb implements zzhr {
    zzht(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzhr
    public final void zza(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzb(2, zza);
    }
}
