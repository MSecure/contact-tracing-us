package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.nearby.zzb;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzad extends zzb implements zzab {
    zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzab
    public final void b_() throws RemoteException {
        zzb(1, zza());
    }
}
