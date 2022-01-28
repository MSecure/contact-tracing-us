package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public class zab implements IInterface {
    public final IBinder zaa;
    public final String zab;

    public zab(IBinder iBinder, String str) {
        this.zaa = iBinder;
        this.zab = str;
    }

    public IBinder asBinder() {
        return this.zaa;
    }
}
