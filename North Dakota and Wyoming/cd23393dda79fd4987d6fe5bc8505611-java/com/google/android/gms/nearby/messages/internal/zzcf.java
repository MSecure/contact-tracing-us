package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzcf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcf> CREATOR = new zzch();
    private final int zza;
    private final zzn zzb;
    private final zzo zzc;
    private final PendingIntent zzd;
    @Deprecated
    private final int zze;
    @Deprecated
    private final String zzf;
    @Deprecated
    private final String zzg;
    @Deprecated
    private final boolean zzh;
    @Deprecated
    private final ClientAppContext zzi;

    public zzcf(int i, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, int i2, String str, String str2, boolean z, ClientAppContext clientAppContext) {
        zzn zzn;
        this.zza = i;
        zzo zzo = null;
        if (iBinder == null) {
            zzn = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            if (queryLocalInterface instanceof zzn) {
                zzn = (zzn) queryLocalInterface;
            } else {
                zzn = new zzp(iBinder);
            }
        }
        this.zzb = zzn;
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            if (queryLocalInterface2 instanceof zzo) {
                zzo = (zzo) queryLocalInterface2;
            } else {
                zzo = new zzq(iBinder2);
            }
        }
        this.zzc = zzo;
        this.zzd = pendingIntent;
        this.zze = i2;
        this.zzf = str;
        this.zzg = str2;
        this.zzh = z;
        this.zzi = ClientAppContext.zza(clientAppContext, str2, str, z);
    }

    public zzcf(IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent) {
        this(1, iBinder, iBinder2, pendingIntent, 0, null, null, false, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        zzn zzn = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzn == null ? null : zzn.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
