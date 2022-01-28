package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.Strategy;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzby extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzby> CREATOR = new zzcb();
    private final int zza;
    private final zzae zzb;
    private final Strategy zzc;
    private final zzo zzd;
    @Deprecated
    private final String zze;
    @Deprecated
    private final String zzf;
    @Deprecated
    private final boolean zzg;
    private final zzv zzh;
    @Deprecated
    private final boolean zzi;
    @Deprecated
    private final ClientAppContext zzj;
    private final int zzk;

    zzby(int i, zzae zzae, Strategy strategy, IBinder iBinder, String str, String str2, boolean z, IBinder iBinder2, boolean z2, ClientAppContext clientAppContext, int i2) {
        zzo zzo;
        this.zza = i;
        this.zzb = zzae;
        this.zzc = strategy;
        zzv zzv = null;
        if (iBinder == null) {
            zzo = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            if (queryLocalInterface instanceof zzo) {
                zzo = (zzo) queryLocalInterface;
            } else {
                zzo = new zzq(iBinder);
            }
        }
        this.zzd = zzo;
        this.zze = str;
        this.zzf = str2;
        this.zzg = z;
        if (!(iBinder2 == null || iBinder2 == null)) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
            zzv = queryLocalInterface2 instanceof zzv ? (zzv) queryLocalInterface2 : new zzx(iBinder2);
        }
        this.zzh = zzv;
        this.zzi = z2;
        this.zzj = ClientAppContext.zza(clientAppContext, str2, str, z2);
        this.zzk = i2;
    }

    public zzby(zzae zzae, Strategy strategy, IBinder iBinder, IBinder iBinder2, int i) {
        this(2, zzae, strategy, iBinder, null, null, false, iBinder2, false, null, i);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeIBinder(parcel, 4, this.zzd.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        zzv zzv = this.zzh;
        SafeParcelWriter.writeIBinder(parcel, 8, zzv == null ? null : zzv.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzi);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
