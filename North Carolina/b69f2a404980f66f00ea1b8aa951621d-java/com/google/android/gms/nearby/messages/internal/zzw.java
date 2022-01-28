package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import c.b.a.a.e.c.a;

public abstract class zzw extends a implements zzt {
    public zzw() {
        super("com.google.android.gms.nearby.messages.internal.IPublishCallback");
    }

    @Override // c.b.a.a.e.c.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zza();
        return true;
    }
}
