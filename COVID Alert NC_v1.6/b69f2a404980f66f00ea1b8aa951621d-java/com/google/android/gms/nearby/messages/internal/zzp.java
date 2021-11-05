package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import c.b.a.a.e.c.a;
import c.b.a.a.e.c.s1;
import com.google.android.gms.common.api.Status;

public abstract class zzp extends a implements zzq {
    public zzp() {
        super("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    @Override // c.b.a.a.e.c.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zza((Status) s1.a(parcel, Status.CREATOR));
        return true;
    }
}
