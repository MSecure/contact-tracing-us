package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import c.b.a.a.e.c.a;
import c.b.a.a.e.c.s1;

public abstract class zzx extends a implements zzy {
    public zzx() {
        super("com.google.android.gms.nearby.messages.internal.IStatusCallback");
    }

    @Override // c.b.a.a.e.c.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zza(s1.d(parcel));
        return true;
    }
}
