package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import c.b.a.a.e.c.a;
import c.b.a.a.e.c.s1;

public abstract class zzo extends a implements zzl {
    public zzo() {
        super("com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    @Override // c.b.a.a.e.c.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zza((zzag) s1.a(parcel, zzag.CREATOR));
        } else if (i == 2) {
            zzb((zzag) s1.a(parcel, zzag.CREATOR));
        } else if (i != 4) {
            return false;
        } else {
            zza(parcel.createTypedArrayList(Update.CREATOR));
        }
        return true;
    }
}
