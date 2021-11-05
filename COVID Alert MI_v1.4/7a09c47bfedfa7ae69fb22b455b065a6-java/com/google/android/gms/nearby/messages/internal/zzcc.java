package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;

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
        int m = t.m(parcel);
        t.q3(parcel, 1, this.zzb);
        t.p3(parcel, 2, this.zzc.asBinder(), false);
        t.p3(parcel, 3, this.zzd.asBinder(), false);
        t.j3(parcel, 4, this.zza);
        t.w3(parcel, 5, this.zze, false);
        t.v3(parcel, 6, this.zzf, i, false);
        t.w4(parcel, m);
    }
}
