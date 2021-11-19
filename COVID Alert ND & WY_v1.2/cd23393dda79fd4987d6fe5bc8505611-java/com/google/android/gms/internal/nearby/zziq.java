package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zziq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zziq> CREATOR = new zzit();
    private String zza;
    private zzjc zzb;
    private boolean zzc;

    private zziq() {
    }

    zziq(String str, zzjc zzjc, boolean z) {
        this.zza = str;
        this.zzb = zzjc;
        this.zzc = z;
    }

    public final String zza() {
        return this.zza;
    }

    public final zzjc zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Boolean.valueOf(this.zzc));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zziq) {
            zziq zziq = (zziq) obj;
            return Objects.equal(this.zza, zziq.zza) && Objects.equal(this.zzb, zziq.zzb) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zziq.zzc));
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
