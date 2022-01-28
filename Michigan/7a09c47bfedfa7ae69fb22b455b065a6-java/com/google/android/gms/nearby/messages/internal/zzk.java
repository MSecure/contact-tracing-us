package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;

public final class zzk extends a {
    public static final Parcelable.Creator<zzk> CREATOR = new zzj();
    public final int zza;
    @Deprecated
    public final ClientAppContext zzb;
    public final int zzc;

    public zzk(int i) {
        this(1, null, i);
    }

    public zzk(int i, ClientAppContext clientAppContext, int i2) {
        this.zza = i;
        this.zzb = clientAppContext;
        this.zzc = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.zza);
        t.v3(parcel, 2, this.zzb, i, false);
        t.q3(parcel, 3, this.zzc);
        t.w4(parcel, m);
    }
}
