package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzca extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzca> CREATOR = new zzcc();
    public boolean zza;
    private final int zzb;
    private final zzo zzc;
    private final zzw zzd;
    @Deprecated
    private String zze;
    @Deprecated
    private final ClientAppContext zzf;

    zzca(int i, IBinder iBinder, IBinder iBinder2, boolean z, String str, ClientAppContext clientAppContext) {
        zzo zzo;
        zzw zzw;
        this.zzb = i;
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
        if (iBinder2 == null) {
            zzw = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            if (queryLocalInterface2 instanceof zzw) {
                zzw = (zzw) queryLocalInterface2;
            } else {
                zzw = new zzy(iBinder2);
            }
        }
        this.zzd = zzw;
        this.zza = z;
        this.zze = str;
        this.zzf = ClientAppContext.zza(clientAppContext, null, str, false);
    }

    public zzca(IBinder iBinder, IBinder iBinder2) {
        this(1, iBinder, iBinder2, false, null, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzb);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzc.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzd.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zza);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
