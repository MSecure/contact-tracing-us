package com.google.android.gms.internal.common;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class zzb implements IInterface {
    public final IBinder zza;
    public final String zzb;

    public zzb(IBinder iBinder, String str) {
        this.zza = iBinder;
        this.zzb = str;
    }

    public IBinder asBinder() {
        return this.zza;
    }
}
