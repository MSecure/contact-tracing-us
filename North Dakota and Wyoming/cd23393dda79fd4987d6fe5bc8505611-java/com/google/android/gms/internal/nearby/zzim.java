package com.google.android.gms.internal.nearby;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzim extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzim> CREATOR = new zzip();
    private String zza;
    private String zzb;
    private String zzc;
    private BluetoothDevice zzd;
    private byte[] zze;

    private zzim() {
    }

    zzim(String str, String str2, String str3, BluetoothDevice bluetoothDevice, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bluetoothDevice;
        this.zze = bArr;
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

    public final BluetoothDevice zzd() {
        return this.zzd;
    }

    public final byte[] zze() {
        return this.zze;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Integer.valueOf(Arrays.hashCode(this.zze)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzim) {
            zzim zzim = (zzim) obj;
            return Objects.equal(this.zza, zzim.zza) && Objects.equal(this.zzb, zzim.zzb) && Objects.equal(this.zzc, zzim.zzc) && Objects.equal(this.zzd, zzim.zzd) && Arrays.equals(this.zze, zzim.zze);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
