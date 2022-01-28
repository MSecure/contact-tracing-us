package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class SubscribeRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzce();
    private final int zza;
    private final zzn zzb;
    private final Strategy zzc;
    private final zzo zzd;
    private final MessageFilter zze;
    private final PendingIntent zzf;
    @Deprecated
    private final int zzg;
    @Deprecated
    private final String zzh;
    @Deprecated
    private final String zzi;
    private final byte[] zzj;
    @Deprecated
    private final boolean zzk;
    private final zzab zzl;
    @Deprecated
    private final boolean zzm;
    @Deprecated
    private final ClientAppContext zzn;
    private final boolean zzo;
    private final int zzp;
    private final int zzq;

    public SubscribeRequest(int i, IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, int i2, String str, String str2, byte[] bArr, boolean z, IBinder iBinder3, boolean z2, ClientAppContext clientAppContext, boolean z3, int i3, int i4) {
        zzn zzn2;
        zzo zzo2;
        this.zza = i;
        zzab zzab = null;
        if (iBinder == null) {
            zzn2 = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            if (queryLocalInterface instanceof zzn) {
                zzn2 = (zzn) queryLocalInterface;
            } else {
                zzn2 = new zzp(iBinder);
            }
        }
        this.zzb = zzn2;
        this.zzc = strategy;
        if (iBinder2 == null) {
            zzo2 = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            if (queryLocalInterface2 instanceof zzo) {
                zzo2 = (zzo) queryLocalInterface2;
            } else {
                zzo2 = new zzq(iBinder2);
            }
        }
        this.zzd = zzo2;
        this.zze = messageFilter;
        this.zzf = pendingIntent;
        this.zzg = i2;
        this.zzh = str;
        this.zzi = str2;
        this.zzj = bArr;
        this.zzk = z;
        if (!(iBinder3 == null || iBinder3 == null)) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            zzab = queryLocalInterface3 instanceof zzab ? (zzab) queryLocalInterface3 : new zzad(iBinder3);
        }
        this.zzl = zzab;
        this.zzm = z2;
        this.zzn = ClientAppContext.zza(clientAppContext, str2, str, z2);
        this.zzo = z3;
        this.zzp = i3;
        this.zzq = i4;
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, byte[] bArr, IBinder iBinder3, boolean z, int i, int i2) {
        this(3, iBinder, strategy, iBinder2, messageFilter, pendingIntent, 0, null, null, bArr, false, iBinder3, false, null, z, i, i2);
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, byte[] bArr, IBinder iBinder3, boolean z, int i) {
        this(iBinder, strategy, iBinder2, messageFilter, null, null, iBinder3, z, 0, i);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        zzn zzn2 = this.zzb;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 2, zzn2 == null ? null : zzn2.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        zzo zzo2 = this.zzd;
        SafeParcelWriter.writeIBinder(parcel, 4, zzo2 == null ? null : zzo2.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeString(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeByteArray(parcel, 10, this.zzj, false);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzk);
        zzab zzab = this.zzl;
        if (zzab != null) {
            iBinder = zzab.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 12, iBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzm);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzn, i, false);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzo);
        SafeParcelWriter.writeInt(parcel, 16, this.zzp);
        SafeParcelWriter.writeInt(parcel, 17, this.zzq);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
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
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 291 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(str).length() + String.valueOf(valueOf6).length() + String.valueOf(valueOf7).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
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
}
