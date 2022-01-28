package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzis extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzis> CREATOR = new zziv();
    private String zza;
    private PayloadTransferUpdate zzb;

    private zzis() {
    }

    zzis(String str, PayloadTransferUpdate payloadTransferUpdate) {
        this.zza = str;
        this.zzb = payloadTransferUpdate;
    }

    public final String zza() {
        return this.zza;
    }

    public final PayloadTransferUpdate zzb() {
        return this.zzb;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzis) {
            zzis zzis = (zzis) obj;
            return Objects.equal(this.zza, zzis.zza) && Objects.equal(this.zzb, zzis.zzb);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
