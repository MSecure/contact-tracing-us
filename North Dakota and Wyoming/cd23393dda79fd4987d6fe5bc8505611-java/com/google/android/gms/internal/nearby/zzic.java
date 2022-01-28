package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzic extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzic> CREATOR = new zzif();
    private String zza;
    private String zzb;
    private byte[] zzc;

    private zzic() {
    }

    zzic(String str, String str2, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final byte[] zzc() {
        return this.zzc;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzic) {
            zzic zzic = (zzic) obj;
            return Objects.equal(this.zza, zzic.zza) && Objects.equal(this.zzb, zzic.zzb) && Arrays.equals(this.zzc, zzic.zzc);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
