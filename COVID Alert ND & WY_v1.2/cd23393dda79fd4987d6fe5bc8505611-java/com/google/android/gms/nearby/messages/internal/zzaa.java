package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.nearby.zza;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public abstract class zzaa extends zza implements zzab {
    public zzaa() {
        super("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.nearby.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        b_();
        return true;
    }
}
