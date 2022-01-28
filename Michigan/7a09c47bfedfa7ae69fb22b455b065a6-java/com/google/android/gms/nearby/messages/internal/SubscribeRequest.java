package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public final class SubscribeRequest extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzcd();
    public final int zza;
    public final zzl zzb;
    public final Strategy zzc;
    public final zzq zzd;
    public final MessageFilter zze;
    public final PendingIntent zzf;
    @Deprecated
    public final int zzg;
    @Deprecated
    public final String zzh;
    @Deprecated
    public final String zzi;
    public final byte[] zzj;
    @Deprecated
    public final boolean zzk;
    public final zzz zzl;
    @Deprecated
    public final boolean zzm;
    @Deprecated
    public final ClientAppContext zzn;
    public final boolean zzo;
    public final int zzp;
    public final int zzq;

    public SubscribeRequest(int i, IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, int i2, String str, String str2, byte[] bArr, boolean z, IBinder iBinder3, boolean z2, ClientAppContext clientAppContext, boolean z3, int i3, int i4) {
        zzl zzl2;
        zzq zzq2;
        this.zza = i;
        zzz zzz = null;
        if (iBinder == null) {
            zzl2 = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzl2 = queryLocalInterface instanceof zzl ? (zzl) queryLocalInterface : new zzn(iBinder);
        }
        this.zzb = zzl2;
        this.zzc = strategy;
        if (iBinder2 == null) {
            zzq2 = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzq2 = queryLocalInterface2 instanceof zzq ? (zzq) queryLocalInterface2 : new zzs(iBinder2);
        }
        this.zzd = zzq2;
        this.zze = messageFilter;
        this.zzf = pendingIntent;
        this.zzg = i2;
        this.zzh = str;
        this.zzi = str2;
        this.zzj = bArr;
        this.zzk = z;
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            zzz = queryLocalInterface3 instanceof zzz ? (zzz) queryLocalInterface3 : new zzab(iBinder3);
        }
        this.zzl = zzz;
        this.zzm = z2;
        this.zzn = ClientAppContext.zza(clientAppContext, str2, str, z2);
        this.zzo = z3;
        this.zzp = i3;
        this.zzq = i4;
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, byte[] bArr, IBinder iBinder3, boolean z, int i) {
        this(iBinder, strategy, iBinder2, messageFilter, null, null, iBinder3, z, 0, i);
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, byte[] bArr, IBinder iBinder3, boolean z, int i, int i2) {
        this(3, iBinder, strategy, iBinder2, messageFilter, pendingIntent, 0, null, null, bArr, false, iBinder3, false, null, z, i, i2);
    }

    public final String toString() {
        String str;
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zzc);
        String valueOf3 = String.valueOf(this.zzd);
        String valueOf4 = String.valueOf(this.zze);
        String valueOf5 = String.valueOf(this.zzf);
        byte[] bArr = this.zzj;
        if (bArr == null) {
            str = null;
        } else {
            int length = bArr.length;
            StringBuilder sb = new StringBuilder(19);
            sb.append("<");
            sb.append(length);
            sb.append(" bytes>");
            str = sb.toString();
        }
        String valueOf6 = String.valueOf(this.zzl);
        boolean z = this.zzm;
        String valueOf7 = String.valueOf(this.zzn);
        boolean z2 = this.zzo;
        String str2 = this.zzh;
        String str3 = this.zzi;
        boolean z3 = this.zzk;
        int i = this.zzq;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + String.valueOf(str2).length() + valueOf7.length() + valueOf6.length() + String.valueOf(str).length() + valueOf5.length() + valueOf4.length() + valueOf3.length() + valueOf2.length() + valueOf.length() + 291);
        sb2.append("SubscribeRequest{messageListener=");
        sb2.append(valueOf);
        sb2.append(", strategy=");
        sb2.append(valueOf2);
        sb2.append(", callback=");
        sb2.append(valueOf3);
        sb2.append(", filter=");
        sb2.append(valueOf4);
        sb2.append(", pendingIntent=");
        sb2.append(valueOf5);
        sb2.append(", hint=");
        sb2.append(str);
        sb2.append(", subscribeCallback=");
        sb2.append(valueOf6);
        sb2.append(", useRealClientApiKey=");
        sb2.append(z);
        sb2.append(", clientAppContext=");
        sb2.append(valueOf7);
        sb2.append(", isDiscardPendingIntent=");
        sb2.append(z2);
        sb2.append(", zeroPartyPackageName=");
        sb2.append(str2);
        sb2.append(", realClientPackageName=");
        sb2.append(str3);
        sb2.append(", isIgnoreNearbyPermission=");
        sb2.append(z3);
        sb2.append(", callingContext=");
        sb2.append(i);
        sb2.append("}");
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.zza);
        zzl zzl2 = this.zzb;
        IBinder iBinder = null;
        t.p3(parcel, 2, zzl2 == null ? null : zzl2.asBinder(), false);
        t.v3(parcel, 3, this.zzc, i, false);
        zzq zzq2 = this.zzd;
        t.p3(parcel, 4, zzq2 == null ? null : zzq2.asBinder(), false);
        t.v3(parcel, 5, this.zze, i, false);
        t.v3(parcel, 6, this.zzf, i, false);
        t.q3(parcel, 7, this.zzg);
        t.w3(parcel, 8, this.zzh, false);
        t.w3(parcel, 9, this.zzi, false);
        t.l3(parcel, 10, this.zzj, false);
        t.j3(parcel, 11, this.zzk);
        zzz zzz = this.zzl;
        if (zzz != null) {
            iBinder = zzz.asBinder();
        }
        t.p3(parcel, 12, iBinder, false);
        t.j3(parcel, 13, this.zzm);
        t.v3(parcel, 14, this.zzn, i, false);
        t.j3(parcel, 15, this.zzo);
        t.q3(parcel, 16, this.zzp);
        t.q3(parcel, 17, this.zzq);
        t.w4(parcel, m);
    }
}
