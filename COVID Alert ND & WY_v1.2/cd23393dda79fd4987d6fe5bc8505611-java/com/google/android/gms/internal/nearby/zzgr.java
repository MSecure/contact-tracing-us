package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzgr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgr> CREATOR = new zzgs();
    private String zza;

    private zzgr() {
    }

    zzgr(String str) {
        this.zza = str;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgr) {
            return Objects.equal(this.zza, ((zzgr) obj).zza);
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
