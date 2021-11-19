package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzio extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzio> CREATOR = new zzir();
    private String zza;

    private zzio() {
    }

    zzio(String str) {
        this.zza = str;
    }

    public final String zza() {
        return this.zza;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzio) {
            return Objects.equal(this.zza, ((zzio) obj).zza);
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
