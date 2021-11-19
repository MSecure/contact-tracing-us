package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzie extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzie> CREATOR = new zzih();
    private String zza;
    private int zzb;
    private byte[] zzc;

    private zzie() {
    }

    zzie(String str, int i, byte[] bArr) {
        this.zza = str;
        this.zzb = i;
        this.zzc = bArr;
    }

    public final String zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final byte[] zzc() {
        return this.zzc;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzie) {
            zzie zzie = (zzie) obj;
            return Objects.equal(this.zza, zzie.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzie.zzb)) && Arrays.equals(this.zzc, zzie.zzc);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
