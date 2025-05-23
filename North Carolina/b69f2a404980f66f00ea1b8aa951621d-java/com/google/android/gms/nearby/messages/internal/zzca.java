package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.messages.Strategy;

public final class zzca extends a {
    public static final Parcelable.Creator<zzca> CREATOR = new zzbz();
    public final int zza;
    public final zzag zzb;
    public final Strategy zzc;
    public final zzq zzd;
    @Deprecated
    public final String zze;
    @Deprecated
    public final String zzf;
    @Deprecated
    public final boolean zzg;
    public final zzt zzh;
    @Deprecated
    public final boolean zzi;
    @Deprecated
    public final ClientAppContext zzj;
    public final int zzk;

    public zzca(int i, zzag zzag, Strategy strategy, IBinder iBinder, String str, String str2, boolean z, IBinder iBinder2, boolean z2, ClientAppContext clientAppContext, int i2) {
        zzq zzq;
        this.zza = i;
        this.zzb = zzag;
        this.zzc = strategy;
        zzt zzt = null;
        if (iBinder == null) {
            zzq = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzs(iBinder);
        }
        this.zzd = zzq;
        this.zze = str;
        this.zzf = str2;
        this.zzg = z;
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
            zzt = queryLocalInterface2 instanceof zzt ? (zzt) queryLocalInterface2 : new zzv(iBinder2);
        }
        this.zzh = zzt;
        this.zzi = z2;
        this.zzj = ClientAppContext.zza(clientAppContext, str2, str, z2);
        this.zzk = i2;
    }

    public zzca(zzag zzag, Strategy strategy, IBinder iBinder, IBinder iBinder2, int i) {
        this(2, zzag, strategy, iBinder, null, null, false, iBinder2, false, null, i);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.zza);
        i.j.y1(parcel, 2, this.zzb, i, false);
        i.j.y1(parcel, 3, this.zzc, i, false);
        i.j.t1(parcel, 4, this.zzd.asBinder(), false);
        i.j.z1(parcel, 5, this.zze, false);
        i.j.z1(parcel, 6, this.zzf, false);
        i.j.o1(parcel, 7, this.zzg);
        zzt zzt = this.zzh;
        i.j.t1(parcel, 8, zzt == null ? null : zzt.asBinder(), false);
        i.j.o1(parcel, 9, this.zzi);
        i.j.y1(parcel, 10, this.zzj, i, false);
        i.j.u1(parcel, 11, this.zzk);
        i.j.F1(parcel, e2);
    }
}
