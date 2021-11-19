package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.zzo;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzik extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzik> CREATOR = new zzin();
    private String zza;
    private int zzb;
    private zzo zzc;

    private zzik() {
    }

    zzik(String str, int i, zzo zzo) {
        this.zza = str;
        this.zzb = i;
        this.zzc = zzo;
    }

    public final String zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzo zzc() {
        return this.zzc;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), this.zzc);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzik) {
            zzik zzik = (zzik) obj;
            return Objects.equal(this.zza, zzik.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzik.zzb)) && Objects.equal(this.zzc, zzik.zzc);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
