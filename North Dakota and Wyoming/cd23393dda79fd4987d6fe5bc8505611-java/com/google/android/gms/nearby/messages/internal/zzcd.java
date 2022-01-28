package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzcd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcd> CREATOR = new zzcg();
    private final int zza;
    private final zzae zzb;
    private final zzo zzc;
    @Deprecated
    private final String zzd;
    @Deprecated
    private final String zze;
    @Deprecated
    private final boolean zzf;
    @Deprecated
    private final ClientAppContext zzg;

    zzcd(int i, zzae zzae, IBinder iBinder, String str, String str2, boolean z, ClientAppContext clientAppContext) {
        zzo zzo;
        this.zza = i;
        this.zzb = zzae;
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
        this.zzc = zzo;
        this.zzd = str;
        this.zze = str2;
        this.zzf = z;
        this.zzg = ClientAppContext.zza(clientAppContext, str2, str, z);
    }

    public zzcd(zzae zzae, IBinder iBinder) {
        this(1, zzae, iBinder, null, null, false, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
