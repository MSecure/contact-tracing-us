package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.messages.internal.zzc;
import java.util.Arrays;
import java.util.Locale;

public final class DiscoveryOptions extends a {
    public static final Parcelable.Creator<DiscoveryOptions> CREATOR = new zzl();
    public Strategy zza;
    public boolean zzb;
    public boolean zzc;
    public boolean zzd;
    public boolean zze;
    public ParcelUuid zzf;
    public boolean zzg;
    public boolean zzh;
    public boolean zzi;
    public boolean zzj;
    public int zzk;
    public int zzl;
    public byte[] zzm;
    public long zzn;

    public static final class Builder {
        public final DiscoveryOptions zza;

        public Builder() {
            this.zza = new DiscoveryOptions();
        }

        public Builder(DiscoveryOptions discoveryOptions) {
            DiscoveryOptions discoveryOptions2 = new DiscoveryOptions();
            this.zza = discoveryOptions2;
            discoveryOptions2.zza = discoveryOptions.zza;
            this.zza.zzb = discoveryOptions.zzb;
            this.zza.zzc = discoveryOptions.zzc;
            this.zza.zzd = discoveryOptions.zzd;
            this.zza.zze = discoveryOptions.zze;
            this.zza.zzf = discoveryOptions.zzf;
            this.zza.zzg = discoveryOptions.zzg;
            this.zza.zzh = discoveryOptions.zzh;
            this.zza.zzi = discoveryOptions.zzi;
            this.zza.zzj = discoveryOptions.zzj;
            this.zza.zzk = discoveryOptions.zzk;
            this.zza.zzl = discoveryOptions.zzl;
            this.zza.zzm = discoveryOptions.zzm;
            this.zza.zzn = discoveryOptions.zzn;
        }

        public final DiscoveryOptions build() {
            return this.zza;
        }

        public final Builder setLowPower(boolean z) {
            this.zza.zze = z;
            return this;
        }

        public final Builder setStrategy(Strategy strategy) {
            this.zza.zza = strategy;
            return this;
        }
    }

    public DiscoveryOptions() {
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
        this.zzn = 0;
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
        this.zzn = 0;
        this.zza = strategy;
    }

    public DiscoveryOptions(Strategy strategy, boolean z, boolean z2, boolean z3, boolean z4, ParcelUuid parcelUuid, boolean z5, boolean z6, boolean z7, boolean z8, int i, int i2, byte[] bArr, long j) {
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
        this.zzn = 0;
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
        this.zzn = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscoveryOptions) {
            DiscoveryOptions discoveryOptions = (DiscoveryOptions) obj;
            return i.j.X(this.zza, discoveryOptions.zza) && i.j.X(Boolean.valueOf(this.zzb), Boolean.valueOf(discoveryOptions.zzb)) && i.j.X(Boolean.valueOf(this.zzc), Boolean.valueOf(discoveryOptions.zzc)) && i.j.X(Boolean.valueOf(this.zzd), Boolean.valueOf(discoveryOptions.zzd)) && i.j.X(Boolean.valueOf(this.zze), Boolean.valueOf(discoveryOptions.zze)) && i.j.X(this.zzf, discoveryOptions.zzf) && i.j.X(Boolean.valueOf(this.zzg), Boolean.valueOf(discoveryOptions.zzg)) && i.j.X(Boolean.valueOf(this.zzh), Boolean.valueOf(discoveryOptions.zzh)) && i.j.X(Boolean.valueOf(this.zzi), Boolean.valueOf(discoveryOptions.zzi)) && i.j.X(Boolean.valueOf(this.zzj), Boolean.valueOf(discoveryOptions.zzj)) && i.j.X(Integer.valueOf(this.zzk), Integer.valueOf(discoveryOptions.zzk)) && i.j.X(Integer.valueOf(this.zzl), Integer.valueOf(discoveryOptions.zzl)) && Arrays.equals(this.zzm, discoveryOptions.zzm) && i.j.X(Long.valueOf(this.zzn), Long.valueOf(discoveryOptions.zzn));
        }
    }

    public final boolean getLowPower() {
        return this.zze;
    }

    public final Strategy getStrategy() {
        return this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zzf, Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj), Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(Arrays.hashCode(this.zzm)), Long.valueOf(this.zzn)});
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[14];
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
        objArr[12] = bArr == null ? "null" : zzc.zza(bArr);
        objArr[13] = Long.valueOf(this.zzn);
        return String.format(locale, "DiscoveryOptions{strategy: %s, forwardUnrecognizedBluetoothDevices: %s, enableBluetooth: %s, enableBle: %s, lowPower: %s, fastAdvertisementServiceUuid: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableUwbRanging: %s, uwbChannel: %d, uwbPreambleIndex: %d, uwbAddress: %s, flowId: %d}", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.y1(parcel, 1, getStrategy(), i, false);
        i.j.o1(parcel, 2, this.zzb);
        i.j.o1(parcel, 3, this.zzc);
        i.j.o1(parcel, 4, this.zzd);
        i.j.o1(parcel, 5, getLowPower());
        i.j.y1(parcel, 6, this.zzf, i, false);
        i.j.o1(parcel, 8, this.zzg);
        i.j.o1(parcel, 9, this.zzh);
        i.j.o1(parcel, 10, this.zzi);
        i.j.o1(parcel, 11, this.zzj);
        i.j.u1(parcel, 12, this.zzk);
        i.j.u1(parcel, 13, this.zzl);
        i.j.q1(parcel, 14, this.zzm, false);
        i.j.x1(parcel, 15, this.zzn);
        i.j.F1(parcel, e2);
    }

    public final boolean zza() {
        return this.zzh;
    }
}
