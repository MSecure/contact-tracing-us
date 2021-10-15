package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import c.b.a.a.g.e.a;

public abstract class zzac extends a implements zzz {
    public zzac() {
        super("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
    }

    @Override // c.b.a.a.g.e.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zza();
        return true;
    }
}
