package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;

public final class zzcf extends a {
    public static final Parcelable.Creator<zzcf> CREATOR = new zzce();
    public final int zza;
    public final zzag zzb;
    public final zzq zzc;
    @Deprecated
    public final String zzd;
    @Deprecated
    public final String zze;
    @Deprecated
    public final boolean zzf;
    @Deprecated
    public final ClientAppContext zzg;

    public zzcf(int i, zzag zzag, IBinder iBinder, String str, String str2, boolean z, ClientAppContext clientAppContext) {
        zzq zzq;
        this.zza = i;
        this.zzb = zzag;
        if (iBinder == null) {
            zzq = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzs(iBinder);
        }
        this.zzc = zzq;
        this.zzd = str;
        this.zze = str2;
        this.zzf = z;
        this.zzg = ClientAppContext.zza(clientAppContext, str2, str, z);
    }

    public zzcf(zzag zzag, IBinder iBinder) {
        this(1, zzag, iBinder, null, null, false, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.zza);
        t.v3(parcel, 2, this.zzb, i, false);
        t.p3(parcel, 3, this.zzc.asBinder(), false);
        t.w3(parcel, 4, this.zzd, false);
        t.w3(parcel, 5, this.zze, false);
        t.j3(parcel, 6, this.zzf);
        t.v3(parcel, 7, this.zzg, i, false);
        t.w4(parcel, m);
    }
}
