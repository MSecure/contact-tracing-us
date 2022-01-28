package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;

@Deprecated
public final class zzi extends a {
    public static final Parcelable.Creator<zzi> CREATOR = new zzh();
    public final int zza;
    public final zzq zzb;
    @Deprecated
    public final String zzc;
    @Deprecated
    public final ClientAppContext zzd;

    public zzi(int i, IBinder iBinder, String str, ClientAppContext clientAppContext) {
        zzq zzq;
        this.zza = i;
        if (iBinder == null) {
            zzq = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzs(iBinder);
        }
        this.zzb = zzq;
        this.zzc = str;
        this.zzd = ClientAppContext.zza(clientAppContext, null, str, false);
    }

    public zzi(IBinder iBinder) {
        this(1, iBinder, null, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.zza);
        t.p3(parcel, 2, this.zzb.asBinder(), false);
        t.w3(parcel, 3, this.zzc, false);
        t.v3(parcel, 4, this.zzd, i, false);
        t.w4(parcel, m);
    }
}
