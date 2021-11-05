package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;

public final class zzcc extends a {
    public static final Parcelable.Creator<zzcc> CREATOR = new zzcb();
    public boolean zza;
    public final int zzb;
    public final zzq zzc;
    public final zzy zzd;
    @Deprecated
    public String zze;
    @Deprecated
    public final ClientAppContext zzf;

    public zzcc(int i, IBinder iBinder, IBinder iBinder2, boolean z, String str, ClientAppContext clientAppContext) {
        zzq zzq;
        zzy zzy;
        this.zzb = i;
        if (iBinder == null) {
            zzq = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzs(iBinder);
        }
        this.zzc = zzq;
        if (iBinder2 == null) {
            zzy = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            zzy = queryLocalInterface2 instanceof zzy ? (zzy) queryLocalInterface2 : new zzaa(iBinder2);
        }
        this.zzd = zzy;
        this.zza = z;
        this.zze = str;
        this.zzf = ClientAppContext.zza(clientAppContext, null, str, false);
    }

    public zzcc(IBinder iBinder, IBinder iBinder2) {
        this(1, iBinder, iBinder2, false, null, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.zzb);
        i.j.t1(parcel, 2, this.zzc.asBinder(), false);
        i.j.t1(parcel, 3, this.zzd.asBinder(), false);
        i.j.o1(parcel, 4, this.zza);
        i.j.z1(parcel, 5, this.zze, false);
        i.j.y1(parcel, 6, this.zzf, i, false);
        i.j.F1(parcel, e2);
    }
}
