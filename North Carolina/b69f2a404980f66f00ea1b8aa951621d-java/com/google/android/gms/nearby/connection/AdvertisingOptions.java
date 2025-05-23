package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.messages.internal.zzc;
import java.util.Arrays;
import java.util.Locale;

public final class AdvertisingOptions extends a {
    public static final Parcelable.Creator<AdvertisingOptions> CREATOR = new zzb();
    public Strategy zza;
    public boolean zzb;
    public boolean zzc;
    public boolean zzd;
    public boolean zze;
    public byte[] zzf;
    public boolean zzg;
    public ParcelUuid zzh;
    public boolean zzi;
    public boolean zzj;
    public boolean zzk;
    public boolean zzl;
    public boolean zzm;
    public boolean zzn;
    public int zzo;
    public int zzp;
    public byte[] zzq;
    public long zzr;
    public zzq[] zzs;

    public static final class Builder {
        public final AdvertisingOptions zza;

        public Builder() {
            this.zza = new AdvertisingOptions();
        }

        public Builder(AdvertisingOptions advertisingOptions) {
            AdvertisingOptions advertisingOptions2 = new AdvertisingOptions();
            this.zza = advertisingOptions2;
            advertisingOptions2.zza = advertisingOptions.zza;
            this.zza.zzb = advertisingOptions.zzb;
            this.zza.zzc = advertisingOptions.zzc;
            this.zza.zzd = advertisingOptions.zzd;
            this.zza.zze = advertisingOptions.zze;
            this.zza.zzf = advertisingOptions.zzf;
            this.zza.zzg = advertisingOptions.zzg;
            this.zza.zzh = advertisingOptions.zzh;
            this.zza.zzi = advertisingOptions.zzi;
            this.zza.zzj = advertisingOptions.zzj;
            this.zza.zzk = advertisingOptions.zzk;
            this.zza.zzl = advertisingOptions.zzl;
            this.zza.zzm = advertisingOptions.zzm;
            this.zza.zzn = advertisingOptions.zzn;
            this.zza.zzo = advertisingOptions.zzo;
            this.zza.zzp = advertisingOptions.zzp;
            this.zza.zzq = advertisingOptions.zzq;
            this.zza.zzr = advertisingOptions.zzr;
            this.zza.zzs = advertisingOptions.zzs;
        }

        public final AdvertisingOptions build() {
            return this.zza;
        }

        public final Builder setLowPower(boolean z) {
            this.zza.zzg = z;
            return this;
        }

        public final Builder setStrategy(Strategy strategy) {
            this.zza.zza = strategy;
            return this;
        }
    }

    public AdvertisingOptions() {
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzg = false;
        this.zzi = true;
        this.zzj = true;
        this.zzk = true;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = 0;
        this.zzp = 0;
        this.zzr = 0;
    }

    @Deprecated
    public AdvertisingOptions(Strategy strategy) {
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzg = false;
        this.zzi = true;
        this.zzj = true;
        this.zzk = true;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = 0;
        this.zzp = 0;
        this.zzr = 0;
        this.zza = strategy;
    }

    public AdvertisingOptions(Strategy strategy, boolean z, boolean z2, boolean z3, boolean z4, byte[] bArr, boolean z5, ParcelUuid parcelUuid, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i, int i2, byte[] bArr2, long j, zzq[] zzqArr) {
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzg = false;
        this.zzi = true;
        this.zzj = true;
        this.zzk = true;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = 0;
        this.zzp = 0;
        this.zzr = 0;
        this.zza = strategy;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = bArr;
        this.zzg = z5;
        this.zzh = parcelUuid;
        this.zzi = z6;
        this.zzj = z7;
        this.zzk = z8;
        this.zzl = z9;
        this.zzm = z10;
        this.zzn = z11;
        this.zzo = i;
        this.zzp = i2;
        this.zzq = bArr2;
        this.zzr = j;
        this.zzs = zzqArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdvertisingOptions) {
            AdvertisingOptions advertisingOptions = (AdvertisingOptions) obj;
            return i.j.X(this.zza, advertisingOptions.zza) && i.j.X(Boolean.valueOf(this.zzb), Boolean.valueOf(advertisingOptions.zzb)) && i.j.X(Boolean.valueOf(this.zzc), Boolean.valueOf(advertisingOptions.zzc)) && i.j.X(Boolean.valueOf(this.zzd), Boolean.valueOf(advertisingOptions.zzd)) && i.j.X(Boolean.valueOf(this.zze), Boolean.valueOf(advertisingOptions.zze)) && Arrays.equals(this.zzf, advertisingOptions.zzf) && i.j.X(Boolean.valueOf(this.zzg), Boolean.valueOf(advertisingOptions.zzg)) && i.j.X(this.zzh, advertisingOptions.zzh) && i.j.X(Boolean.valueOf(this.zzi), Boolean.valueOf(advertisingOptions.zzi)) && i.j.X(Boolean.valueOf(this.zzj), Boolean.valueOf(advertisingOptions.zzj)) && i.j.X(Boolean.valueOf(this.zzk), Boolean.valueOf(advertisingOptions.zzk)) && i.j.X(Boolean.valueOf(this.zzl), Boolean.valueOf(advertisingOptions.zzl)) && i.j.X(Boolean.valueOf(this.zzm), Boolean.valueOf(advertisingOptions.zzm)) && i.j.X(Boolean.valueOf(this.zzn), Boolean.valueOf(advertisingOptions.zzn)) && i.j.X(Integer.valueOf(this.zzo), Integer.valueOf(advertisingOptions.zzo)) && i.j.X(Integer.valueOf(this.zzp), Integer.valueOf(advertisingOptions.zzp)) && Arrays.equals(this.zzq, advertisingOptions.zzq) && i.j.X(Long.valueOf(this.zzr), Long.valueOf(advertisingOptions.zzr)) && Arrays.equals(this.zzs, advertisingOptions.zzs);
        }
    }

    public final boolean getLowPower() {
        return this.zzg;
    }

    public final Strategy getStrategy() {
        return this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), Boolean.valueOf(this.zzg), this.zzh, Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), Boolean.valueOf(this.zzl), Boolean.valueOf(this.zzm), Boolean.valueOf(this.zzn), Integer.valueOf(this.zzo), Integer.valueOf(this.zzp), Integer.valueOf(Arrays.hashCode(this.zzq)), Long.valueOf(this.zzr), Integer.valueOf(Arrays.hashCode(this.zzs))});
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[19];
        objArr[0] = this.zza;
        objArr[1] = Boolean.valueOf(this.zzb);
        objArr[2] = Boolean.valueOf(this.zzc);
        objArr[3] = Boolean.valueOf(this.zzd);
        objArr[4] = Boolean.valueOf(this.zze);
        byte[] bArr = this.zzf;
        objArr[5] = bArr == null ? null : zzc.zza(bArr);
        objArr[6] = Boolean.valueOf(this.zzg);
        objArr[7] = this.zzh;
        objArr[8] = Boolean.valueOf(this.zzi);
        objArr[9] = Boolean.valueOf(this.zzj);
        objArr[10] = Boolean.valueOf(this.zzk);
        objArr[11] = Boolean.valueOf(this.zzl);
        objArr[12] = Boolean.valueOf(this.zzm);
        objArr[13] = Boolean.valueOf(this.zzn);
        objArr[14] = Integer.valueOf(this.zzo);
        objArr[15] = Integer.valueOf(this.zzp);
        byte[] bArr2 = this.zzq;
        objArr[16] = bArr2 == null ? "null" : zzc.zza(bArr2);
        objArr[17] = Long.valueOf(this.zzr);
        objArr[18] = Arrays.toString(this.zzs);
        return String.format(locale, "AdvertisingOptions{strategy: %s, autoUpgradeBandwidth: %s, enforceTopologyConstraints: %s, enableBluetooth: %s, enableBle: %s, nearbyNotificationsBeaconData: %s, lowPower: %s, fastAdvertisementServiceUuid: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableBluetoothListening: %s, enableWebRtcListening: %s, enableUwbRanging: %s, uwbChannel: %d, uwbPreambleIndex: %d, remoteUwbAddress: %s, flowId: %d, uwbSenderInfo: %s, }", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.y1(parcel, 1, getStrategy(), i, false);
        i.j.o1(parcel, 2, this.zzb);
        i.j.o1(parcel, 3, this.zzc);
        i.j.o1(parcel, 4, this.zzd);
        i.j.o1(parcel, 5, this.zze);
        i.j.q1(parcel, 6, this.zzf, false);
        i.j.o1(parcel, 7, getLowPower());
        i.j.y1(parcel, 8, this.zzh, i, false);
        i.j.o1(parcel, 9, this.zzi);
        i.j.o1(parcel, 10, this.zzj);
        i.j.o1(parcel, 11, this.zzk);
        i.j.o1(parcel, 12, this.zzl);
        i.j.o1(parcel, 13, this.zzm);
        i.j.o1(parcel, 14, this.zzn);
        i.j.u1(parcel, 15, this.zzo);
        i.j.u1(parcel, 16, this.zzp);
        i.j.q1(parcel, 17, this.zzq, false);
        i.j.x1(parcel, 18, this.zzr);
        i.j.A1(parcel, 19, this.zzs, i, false);
        i.j.F1(parcel, e2);
    }
}
