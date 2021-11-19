package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

@Deprecated
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzj();
    private final int zza;
    private final zzo zzb;
    @Deprecated
    private final String zzc;
    @Deprecated
    private final ClientAppContext zzd;

    zzg(int i, IBinder iBinder, String str, ClientAppContext clientAppContext) {
        zzo zzo;
        this.zza = i;
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
        this.zzb = zzo;
        this.zzc = str;
        this.zzd = ClientAppContext.zza(clientAppContext, null, str, false);
    }

    zzg(IBinder iBinder) {
        this(1, iBinder, null, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
