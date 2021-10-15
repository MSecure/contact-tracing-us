package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;

public final class zzch extends a {
    public static final Parcelable.Creator<zzch> CREATOR = new zzcg();
    public final int zza;
    public final zzl zzb;
    public final zzq zzc;
    public final PendingIntent zzd;
    @Deprecated
    public final int zze;
    @Deprecated
    public final String zzf;
    @Deprecated
    public final String zzg;
    @Deprecated
    public final boolean zzh;
    @Deprecated
    public final ClientAppContext zzi;

    public zzch(int i, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, int i2, String str, String str2, boolean z, ClientAppContext clientAppContext) {
        zzl zzl;
        this.zza = i;
        zzq zzq = null;
        if (iBinder == null) {
            zzl = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzl = queryLocalInterface instanceof zzl ? (zzl) queryLocalInterface : new zzn(iBinder);
        }
        this.zzb = zzl;
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzq = queryLocalInterface2 instanceof zzq ? (zzq) queryLocalInterface2 : new zzs(iBinder2);
        }
        this.zzc = zzq;
        this.zzd = pendingIntent;
        this.zze = i2;
        this.zzf = str;
        this.zzg = str2;
        this.zzh = z;
        this.zzi = ClientAppContext.zza(clientAppContext, str2, str, z);
    }

    public zzch(IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent) {
        this(1, iBinder, iBinder2, pendingIntent, 0, null, null, false, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.zza);
        zzl zzl = this.zzb;
        t.p3(parcel, 2, zzl == null ? null : zzl.asBinder(), false);
        t.p3(parcel, 3, this.zzc.asBinder(), false);
        t.v3(parcel, 4, this.zzd, i, false);
        t.q3(parcel, 5, this.zze);
        t.w3(parcel, 6, this.zzf, false);
        t.w3(parcel, 7, this.zzg, false);
        t.j3(parcel, 8, this.zzh);
        t.v3(parcel, 9, this.zzi, i, false);
        t.w4(parcel, m);
    }
}
