package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;

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
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.zza);
        i.j.y1(parcel, 2, this.zzb, i, false);
        i.j.u1(parcel, 3, this.zzc);
        i.j.F1(parcel, e2);
    }
}
