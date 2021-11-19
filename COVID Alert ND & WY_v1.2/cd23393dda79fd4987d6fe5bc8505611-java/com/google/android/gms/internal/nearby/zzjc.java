package com.google.android.gms.internal.nearby;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzjc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjc> CREATOR = new zzjh();
    private long zza;
    private int zzb;
    private byte[] zzc;
    private ParcelFileDescriptor zzd;
    private String zze;
    private long zzf;
    private ParcelFileDescriptor zzg;
    private Uri zzh;

    private zzjc() {
        this.zzf = -1;
    }

    zzjc(long j, int i, byte[] bArr, ParcelFileDescriptor parcelFileDescriptor, String str, long j2, ParcelFileDescriptor parcelFileDescriptor2, Uri uri) {
        this.zzf = -1;
        this.zza = j;
        this.zzb = i;
        this.zzc = bArr;
        this.zzd = parcelFileDescriptor;
        this.zze = str;
        this.zzf = j2;
        this.zzg = parcelFileDescriptor2;
        this.zzh = uri;
    }

    public final long zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final byte[] zzc() {
        return this.zzc;
    }

    public final ParcelFileDescriptor zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zze;
    }

    public final long zzf() {
        return this.zzf;
    }

    public final Uri zzg() {
        return this.zzh;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, this.zze, Long.valueOf(this.zzf), this.zzg, this.zzh);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjc) {
            zzjc zzjc = (zzjc) obj;
            return Objects.equal(Long.valueOf(this.zza), Long.valueOf(zzjc.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzjc.zzb)) && Arrays.equals(this.zzc, zzjc.zzc) && Objects.equal(this.zzd, zzjc.zzd) && Objects.equal(this.zze, zzjc.zze) && Objects.equal(Long.valueOf(this.zzf), Long.valueOf(zzjc.zzf)) && Objects.equal(this.zzg, zzjc.zzg) && Objects.equal(this.zzh, zzjc.zzh);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
