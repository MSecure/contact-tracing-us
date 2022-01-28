package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.internal.zzb;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class DiscoveryOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DiscoveryOptions> CREATOR = new zzl();
    private Strategy zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private ParcelUuid zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private int zzl;
    private byte[] zzm;

    private DiscoveryOptions() {
        this.zzb = false;
        this.zzc = true;
        this.zzd = true;
        this.zze = false;
        this.zzg = true;
        this.zzh = true;
        this.zzi = true;
        this.zzj = false;
        this.zzk = 0;
        this.zzl = 0;
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static final class Builder {
        private final DiscoveryOptions zza;

        public Builder() {
            this.zza = new DiscoveryOptions();
        }

        public Builder(DiscoveryOptions discoveryOptions) {
            DiscoveryOptions discoveryOptions2 = new DiscoveryOptions();
            this.zza = discoveryOptions2;
            discoveryOptions2.zza = discoveryOptions.zza;
            discoveryOptions2.zzb = discoveryOptions.zzb;
            discoveryOptions2.zzc = discoveryOptions.zzc;
            discoveryOptions2.zzd = discoveryOptions.zzd;
            discoveryOptions2.zze = discoveryOptions.zze;
            discoveryOptions2.zzf = discoveryOptions.zzf;
            discoveryOptions2.zzg = discoveryOptions.zzg;
            discoveryOptions2.zzh = discoveryOptions.zzh;
            discoveryOptions2.zzi = discoveryOptions.zzi;
            discoveryOptions2.zzj = discoveryOptions.zzj;
            discoveryOptions2.zzk = discoveryOptions.zzk;
            discoveryOptions2.zzl = discoveryOptions.zzl;
            discoveryOptions2.zzm = discoveryOptions.zzm;
        }

        public final Builder setStrategy(Strategy strategy) {
            this.zza.zza = strategy;
            return this;
        }

        public final Builder setLowPower(boolean z) {
            this.zza.zze = z;
            return this;
        }

        public final DiscoveryOptions build() {
            return this.zza;
        }
    }

    DiscoveryOptions(Strategy strategy, boolean z, boolean z2, boolean z3, boolean z4, ParcelUuid parcelUuid, boolean z5, boolean z6, boolean z7, boolean z8, int i, int i2, byte[] bArr) {
        this.zzb = false;
        this.zzc = true;
        this.zzd = true;
        this.zze = false;
        this.zzg = true;
        this.zzh = true;
        this.zzi = true;
        this.zzj = false;
        this.zzk = 0;
        this.zzl = 0;
        this.zza = strategy;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = parcelUuid;
        this.zzg = z5;
        this.zzh = z6;
        this.zzi = z7;
        this.zzj = z8;
        this.zzk = i;
        this.zzl = i2;
        this.zzm = bArr;
    }

    @Deprecated
    public DiscoveryOptions(Strategy strategy) {
        this.zzb = false;
        this.zzc = true;
        this.zzd = true;
        this.zze = false;
        this.zzg = true;
        this.zzh = true;
        this.zzi = true;
        this.zzj = false;
        this.zzk = 0;
        this.zzl = 0;
        this.zza = strategy;
    }

    public final Strategy getStrategy() {
        return this.zza;
    }

    public final boolean getLowPower() {
        return this.zze;
    }

    public final boolean zza() {
        return this.zzh;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zzf, Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj), Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(Arrays.hashCode(this.zzm)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscoveryOptions) {
            DiscoveryOptions discoveryOptions = (DiscoveryOptions) obj;
            return Objects.equal(this.zza, discoveryOptions.zza) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(discoveryOptions.zzb)) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(discoveryOptions.zzc)) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(discoveryOptions.zzd)) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(discoveryOptions.zze)) && Objects.equal(this.zzf, discoveryOptions.zzf) && Objects.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(discoveryOptions.zzg)) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(discoveryOptions.zzh)) && Objects.equal(Boolean.valueOf(this.zzi), Boolean.valueOf(discoveryOptions.zzi)) && Objects.equal(Boolean.valueOf(this.zzj), Boolean.valueOf(discoveryOptions.zzj)) && Objects.equal(Integer.valueOf(this.zzk), Integer.valueOf(discoveryOptions.zzk)) && Objects.equal(Integer.valueOf(this.zzl), Integer.valueOf(discoveryOptions.zzl)) && Arrays.equals(this.zzm, discoveryOptions.zzm);
        }
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[13];
        objArr[0] = this.zza;
        objArr[1] = Boolean.valueOf(this.zzb);
        objArr[2] = Boolean.valueOf(this.zzc);
        objArr[3] = Boolean.valueOf(this.zzd);
        objArr[4] = Boolean.valueOf(this.zze);
        objArr[5] = this.zzf;
        objArr[6] = Boolean.valueOf(this.zzg);
        objArr[7] = Boolean.valueOf(this.zzh);
        objArr[8] = Boolean.valueOf(this.zzi);
        objArr[9] = Boolean.valueOf(this.zzj);
        objArr[10] = Integer.valueOf(this.zzk);
        objArr[11] = Integer.valueOf(this.zzl);
        byte[] bArr = this.zzm;
        objArr[12] = bArr == null ? "null" : zzb.zza(bArr);
        return String.format(locale, "DiscoveryOptions{strategy: %s, forwardUnrecognizedBluetoothDevices: %s, enableBluetooth: %s, enableBle: %s, lowPower: %s, fastAdvertisementServiceUuid: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableUwbRanging: %s, uwbChannel: %d, uwbPreambleIndex: %d, uwbAddress: %s}", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStrategy(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, getLowPower());
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeInt(parcel, 13, this.zzl);
        SafeParcelWriter.writeByteArray(parcel, 14, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
