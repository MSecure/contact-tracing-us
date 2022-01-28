package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;

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
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.zza);
        i.j.y1(parcel, 2, this.zzb, i, false);
        i.j.t1(parcel, 3, this.zzc.asBinder(), false);
        i.j.z1(parcel, 4, this.zzd, false);
        i.j.z1(parcel, 5, this.zze, false);
        i.j.o1(parcel, 6, this.zzf);
        i.j.y1(parcel, 7, this.zzg, i, false);
        i.j.F1(parcel, e2);
    }
}
