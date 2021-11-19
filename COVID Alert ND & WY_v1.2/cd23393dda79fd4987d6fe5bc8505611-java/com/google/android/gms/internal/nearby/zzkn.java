package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzkn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkn> CREATOR = new zzkq();
    public static final zzkn zza = new zzkn("", null);
    private static final String zzb = null;
    private final int zzc;
    private final String zzd;
    private final String zze;

    zzkn(int i, String str, String str2) {
        this.zzc = ((Integer) Preconditions.checkNotNull(Integer.valueOf(i))).intValue();
        this.zzd = str == null ? "" : str;
        this.zze = str2;
    }

    private zzkn(String str, String str2) {
        this(1, str, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkn)) {
            return false;
        }
        zzkn zzkn = (zzkn) obj;
        return Objects.equal(this.zzd, zzkn.zzd) && Objects.equal(this.zze, zzkn.zze);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzd, this.zze);
    }

    public final String toString() {
        String str = this.zzd;
        String str2 = this.zze;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(str2).length());
        sb.append("NearbyDevice{handle=");
        sb.append(str);
        sb.append(", bluetoothAddress=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 3, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
