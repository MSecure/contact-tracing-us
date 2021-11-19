package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzia extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzia> CREATOR = new zzid();
    private String zza;
    private String zzb;
    private String zzc;
    private boolean zzd;
    private byte[] zze;
    private byte[] zzf;
    private byte[] zzg;
    private boolean zzh;

    private zzia() {
    }

    zzia(String str, String str2, String str3, boolean z, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z;
        this.zze = bArr;
        this.zzf = bArr2;
        this.zzg = bArr3;
        this.zzh = z2;
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzd;
    }

    public final byte[] zze() {
        return this.zzf;
    }

    public final byte[] zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Boolean.valueOf(this.zzd), Integer.valueOf(Arrays.hashCode(this.zze)), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(Arrays.hashCode(this.zzg)), Boolean.valueOf(this.zzh));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzia) {
            zzia zzia = (zzia) obj;
            return Objects.equal(this.zza, zzia.zza) && Objects.equal(this.zzb, zzia.zzb) && Objects.equal(this.zzc, zzia.zzc) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzia.zzd)) && Arrays.equals(this.zze, zzia.zze) && Arrays.equals(this.zzf, zzia.zzf) && Arrays.equals(this.zzg, zzia.zzg) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(zzia.zzh));
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
